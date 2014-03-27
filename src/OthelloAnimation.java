import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * \\file -OthelloAnimation.java 
 * \author -Ben Golightly
 * \date -27th March 2014
 * 
 * \see Animation.java
 * \see Othello.java
 * \see OthelloAnimaitonPane.java
 * \see OthelloAnimaitonPoint.java
 * 
 * \brief This class manages the animation of multiple Othello pieces. 
 * 
 * It works by painting a "glass pane" on top of the application in order to
 * render a list of animations onto.
 */
public class OthelloAnimation extends Animation{

	/**
	 * Constructor for an OthelloAnimation controller
	 * \param gui a reference to the GUI, used to add the glass pane.
	 */
	public OthelloAnimation(GUI gui) {
		JFrame frame = gui.GetFrame();
		
		m_GlassPane = new OthelloAnimationPane();
		m_Animating = new ArrayList<OthelloAnimationPoint>();
		frame.setGlassPane(m_GlassPane);
		m_GlassPane.setVisible(true);

		createTimer();
		getTimer().start();
	}

	/**
	 * Command used to define a new point of animation to a playerColour. Used
	 * to animate the capture of pieces by a player in Othello.
	 * \param xcoord the X position of the piece to animate capturing
	 * \param ycoord the Y position of the piece to animate capturing
	 * \param playerColour the colour of the piece to animate to. Must be
	 * 		  			   Color.black or Color.white.
	 * \param delay the delay
	 */
	@Override
	public void animate(int xcoord, int ycoord, Color playerColour, int delay) {
		int dir;
		
		if (playerColour == Color.black) {
			dir = 1;
		}
		else if (playerColour == Color.white) {
			dir = -1;
		}
		else {
			throw new IllegalArgumentException("bad playerColour");
		}
		
		m_Animating.add(new OthelloAnimationPoint(xcoord, ycoord, dir, FRAMES,
					delay));
	}

	/**
	 * called by the animation superclass at periodic intervals in order to
	 * update the animation display.
	 */
	@Override
	protected void cycle() {
		// First remove any completed animations
		ArrayList<OthelloAnimationPoint> toRemove =
			new ArrayList<OthelloAnimationPoint>();

		for (OthelloAnimationPoint point : m_Animating) {
			point.sync();
			if (point.completed()) { toRemove.add(point); }
		}
	
		m_Animating.removeAll(toRemove);
		
		// Then set the points to animate
		m_GlassPane.setPoints(m_Animating);
		
		// The draw the glass pane with these points
		m_GlassPane.revalidate();
		m_GlassPane.repaint();
	}
	
	/** a reference to a glass pane to draw animations on to. */
	private OthelloAnimationPane m_GlassPane;
	/** currently active points to animate */
	private ArrayList <OthelloAnimationPoint> m_Animating;
	/** how many frames in the animation */
	private final int FRAMES = 15; // 15 frames == 0.5 seconds
}
