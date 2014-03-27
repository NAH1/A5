import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.*;

import javax.swing.JPanel;



/**
 * 	\\file Connect4AnimationPane.java
 * 	\author Daniel Squires - 709547
 *	\date 26/03/2014
 *
 *	\brief This class manages the glasspane to draw the object for animations
 */
public class Connect4AnimationPane extends JPanel {
	
	/**
	 * Sets the Connect4Animation object
	 * \param C4Animation - Animation object to instantiate vairable to
	 */
	public void setC4Animation(Connect4Animation C4Animation) {
		m_C4Animation = C4Animation;
	}
	
	/**
	 * Constructor which calls super constructor
	 * Sets the Opacity to false
	 */
	public Connect4AnimationPane() {
		super(null);
		setOpaque(false);
		if (m_trace) {
			System.out.println("Connect4AnimationPane constructed");
		}
	}
	
	@Override
	/**
	 * Paints the component to the JPanel
	 * \param g - the Graphics object to protect 
	 */
	public void paintComponent(Graphics g) {
		final int OVAL_HEIGHT = 60;
		final int OVAL_WIDTH = 60;
		final int X_INC = 6;
		final int Y_INC = 4;
		
		if (m_C4Animation.getTimer().isRunning()) {
			if (m_trace) {
				System.out.println("Timer is running:");
				System.out.println("XCoord: " + m_C4Animation.getXCoord());
				System.out.println("YCoord: " + m_C4Animation.getYCoord());
			}
			super.paintComponents(g);
			
			
			Graphics2D g2d = (Graphics2D) g;
			
			g2d.setColor(Color.WHITE);
			g2d.fillOval(m_C4Animation.getXCoord() + X_INC, 
					m_C4Animation.getLowestYCoord() + Y_INC,
					OVAL_HEIGHT, OVAL_WIDTH);
			
			g2d.setColor(m_C4Animation.getPlayerColour());
			g2d.fillOval(m_C4Animation.getXCoord() + X_INC, 
					m_C4Animation.getYCoord() + Y_INC,
					OVAL_HEIGHT, OVAL_WIDTH);
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
			g2d.dispose();
		}
	}
	
	//private variables
	private Connect4Animation m_C4Animation;
	private boolean m_trace = false;
}
