import java.awt.Color;
import java.awt.Graphics2D;

/**
 * \\file -OthelloAnimationPoint.java 
 * \author - Ben Golightly
 * 
 * \see OthelloAnimation.java
 * 
 * \brief Simple structure class to hold information about a peice being
 *        animated. Multiple copies of these will be held in a list by
 *        the OthelloAnimation class which may need to animate multiple
 *        peices when capturing.
 * 
 */

public class OthelloAnimationPoint {
	
	public OthelloAnimationPoint(int x, int y, int type, int limit) {
		m_X = x;
		m_Y = y;
		m_Type = type;
		m_Completion = 0;
		m_Limit = limit;
	}
	
	public void draw(Graphics2D g) {
		/*System.out.println("OthelloAnimationPoint::draw at "
				+ m_X +", " + m_Y +
				", frame: " + m_Completion +
				", width: " + width());*/
		
		// hack to cover set peices
		g.setColor(Color.gray);
		g.fillRect(m_X * SQRW, m_Y * SQRW, SQRW, SQRW);
		
		g.setColor(color());
        g.fillOval((m_X * SQRW) + (SQRW/2 - width()/2),
        			m_Y * SQRW, width(), SQRW);
	}
	
	private int frame() {
		return m_Completion;
	}
	
	private int width() {
		return (int) Math.round(70.0 * (double) frame() / (double) m_Limit);
	}
	
	private Color color() {
		if (frame() < m_Limit / 2) {
			if (m_Type < 0) { return Color.black; } else { return Color.white; }
		}
		else {
			if (m_Type < 0) { return Color.white; } else { return Color.black; }
		}
			
	}
	
	public void sync() {
		m_Completion++;
	}
	
	public boolean completed() {
		return m_Completion == m_Limit;
	}
	
	private int m_X;     // X location of an animation = new ArrayList<Integer>()
	private int m_Y;     // Y location of an animation
	private int m_Type;  // black to white, or reverse
	private int m_Completion;
	private int m_Limit;
	private final int SQRW = 70; // square width
}