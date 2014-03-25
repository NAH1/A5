import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import boardGame.*;

import java.util.ArrayList;

/**
 * 
 * \author Ben Golightly
 *
 */
public class OthelloAnimation extends Animation{

	/**
	 * Constructor method
	 * \param frame - 
	 * \param game - 
	 */
	public OthelloAnimation(JFrame frame,  BoardGame game, GUI gui) {
		super(frame, game, gui);
		
		m_Animating = new ArrayList<OthelloAnimationPoint>();

		EventHandler handler = new EventHandler();
		javax.swing.Timer timer = new javax.swing.Timer(DELAY, handler);
		setTimer(timer);
		
		ImageIcon ii[] = new ImageIcon[10];
		//("piece\\white.png")
		
	}

	@Override
	public void animate(int xcoord, int ycoord, Color playerColour) {
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
		
		m_Animating.add(new OthelloAnimationPoint(xcoord, ycoord, dir, 10));
	}

	/**
	 * 
	 */
	@Override
	protected void cycle() {
		ArrayList<OthelloAnimationPoint> toRemove =
			new ArrayList<OthelloAnimationPoint>();

		for (OthelloAnimationPoint point : m_Animating) {
			point.sync();
			System.out.println("TEST ANIMATION: " + point.frame());
			if (point.completed()) { toRemove.add(point); }
		}
	
		m_Animating.removeAll(toRemove);
	
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}

	@Override
	protected void drawPiece(Graphics g) {
		
	}
	
	
	private ArrayList <OthelloAnimationPoint> m_Animating;
}
