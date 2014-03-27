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
		g.setColor(BGCOLOR);
		g.fillRect(m_X * SQRW + 3, m_Y * SQRH + 1, SQRW - 4, SQRH - 2);
		
		g.setColor(color());
        g.fillOval((m_X * SQRW) + (SQRW/2 - width()/2) + PADDING,
        			m_Y * SQRH + PADDING,
        			width(),
        			DIAMETER);
	}
	
	private int frame() {
		return m_Completion;
	}
	
	private int width() {
		// from 1.0 to 0.0 to 1.0
		
		// 0.0 to 1.0
		double completion = (double) frame() / (double) m_Limit;
		
		completion *= 2.0; // now 0.0 to 2.0
		completion -= 1.0; // now -1.0 to 1.0
		completion = Math.abs(completion);
		
		return (int) Math.round((double) DIAMETER * completion);
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
	private final int SQRW = 71; // square width (yeah WTF, right?)
	private final int SQRH = 70; // square height
	private final Color BGCOLOR = new Color(170, 150, 100);
	private final int DIAMETER = 60;
	private final int PADDING = 5;
}