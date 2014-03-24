import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import boardGame.*;

/**
 * 
 * \author Daniel
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
		
		//String playerColour = getGUI().GetGame().GetCurrent().GetPiece();
		
		/*
		EventHandler handler = new EventHandler();
		javax.swing.Timer timer = new javax.swing.Timer(DELAY, handler);
		setTimer(timer);
		
		if (playerColour == "white") {
			ImageIcon ii = new ImageIcon("piece\\white.png");
			setPiece(ii.getImage());
		} else {
			ImageIcon ii = new ImageIcon("piece\\black.png");
			setPiece(ii.getImage());
		}*/
	}

	/**
	 * 
	 */
	@Override
	protected void cycle() {
		
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
	}

	@Override
	protected void drawPiece(Graphics g) {
		
	}
	
	
	private List <OthelloAnimationPoint> m_Animating;
}
