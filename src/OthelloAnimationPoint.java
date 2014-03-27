import java.awt.Color;
import java.awt.Graphics2D;

/**
 * \\file -OthelloAnimationPoint.java 
 * \author - Ben Golightly
 * 
 * \see Animation.java
 * \see Othello.java
 * \see OthelloAnimationPane.java
 * \see OthelloAnimation.java
 * 
 * \brief Simple structure class to hold information about a piece being
 *        animated. Multiple copies of these will be held in a list by
 *        the OthelloAnimation class which may need to animate multiple
 *        pieces when capturing.
 * 
 */

public class OthelloAnimationPoint {
	
	/**
	 * Constructor for an animation point
	 * \param x The x position in the grid
	 * \param y The y position in the grid
	 * \param type The direction in which to animate (black to white, or
	 *  			the reverse)
	 * \param limit The limit of the animation size.
	 * \param delay The delay
	 */
	public OthelloAnimationPoint(int x, int y, int type, int limit, int delay) {
		m_X = x;
		m_Y = y;
		m_Type = type;
		m_Completion = 0;
		m_Limit = limit;
		m_Delay = delay * DELAY_TIME;
	}
	
	/**
	 * Draw the animation point
	 * zparam g a graphics handle
	 */
	public void draw(Graphics2D g) {
		/*System.out.println("OthelloAnimationPoint::draw at "
				+ m_X +", " + m_Y +
				", frame: " + m_Completion +
				", width: " + width());*/
		
		// hack to cover set peices
		g.setColor(BGCOLOR);
		g.fillRect(m_X * SQRW + SQ_PADX1,
					m_Y * SQRH + SQ_PADY1,
					SQRW - SQ_PADX2,
					SQRH - SQ_PADY2);
		
		g.setColor(color());
        g.fillOval((m_X * SQRW) + (SQRW/2 - width()/2) + PADDING,
        			m_Y * SQRH + PADDING,
        			width(),
        			DIAMETER);
	}
	
	/**
	 * The current frame of the animation
	 * \return The current frame of the animation
	 */
	private int frame() {
		return m_Completion;
	}
	
	/**
	 * The current width of an animated piece, which varies in order to simulate
	 * "flipping" a peice.
	 * \return The width
	 */
	private int width() {
		if (m_Delay > 0) { return DIAMETER; }
		// 0.0 to 1.0
		double completion = (double) frame() / (double) m_Limit;
		
		completion *= 2.0; // now 0.0 to 2.0
		completion -= 1.0; // now -1.0 to 1.0
		completion = Math.abs(completion);
		
		// now 0.0 to DIAMETER
		return (int) Math.round((double) DIAMETER * completion);
	}
	
	/**
	 * The current colour at the current stage of the animation 
	 * \return The colour
	 */
	private Color color() {
		if (m_Delay > 0) {
			if (m_Type < 0) { return Color.black; } else { return Color.white; }
		}
		
		if (frame() < m_Limit / 2) {
			if (m_Type < 0) { return Color.black; } else { return Color.white; }
		}
		else {
			if (m_Type < 0) { return Color.white; } else { return Color.black; }
		}
			
	}
	
	/**
	 * Update the animation state of the piece
	 */
	public void sync() {
		if (m_Delay > 0) { m_Delay--; return; }
		m_Completion++;
	}
	
	/**
	 * Query the status of the piece animation
	 * \return True iff it has finished.
	 */
	public boolean completed() {
		return m_Completion == m_Limit;
	}
	
	/** x location of animation */
	private int m_X;
	/** y location of animation */
	private int m_Y;
	/** type of animation */
	private int m_Type;  // black to white, or reverse
	/** progress animation */
	private int m_Completion;
	/** limit of animation */
	private int m_Limit;
	/** delay */
	private int m_Delay;
	private final int DELAY_TIME = 10;
	/** Width of grid square */
	private final int SQRW = 71; // square width (yeah WTF, right?)
	/** Height of grid square */
	private final int SQRH = 70; // square height
	/** Colour of grid square */
	private final Color BGCOLOR = new Color(170, 150, 100);
	/** Diameter of circle */
	private final int DIAMETER = 60;
	/** Left/top padding/margin of circle */
	private final int PADDING = 5;
	/**padding */
	private final int SQ_PADX1 = 3;
	/**padding */
	private final int SQ_PADX2 = 4;
	/**padding */
	private final int SQ_PADY1 = 1;
	/**padding */
	private final int SQ_PADY2 = 2;
}