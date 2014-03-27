import java.awt.AWTEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * 
 */

/**
 * 	\\file Connect4AnimationPane.java
 * 	\author Daniel Squires
 *	\date 26/03/2014
 */
public class Connect4AnimationPane extends JPanel {
	
	public void setC4Animation(Connect4Animation C4Animation) {
		m_C4Animation = C4Animation;
	}
	
	/**
	 * 
	 */
	public Connect4AnimationPane(JFrame frame) {
		super(null);
		m_frame = frame;
		setOpaque(false);
		System.out.println("Connect4AnimationPane constructed");
	}
	
	@Override
	public void paintComponent(Graphics g) {
		final int OVAL_HEIGHT = 60;
		final int OVAL_WIDTH = 60;
		final int X_INC = 6;
		final int Y_INC = 4;
		
		if (m_C4Animation.getTimer().isRunning()) {
			if (m_trace) {
				System.out.println("Timer is running:");
				System.out.println("Connect4 Animation Pane Paint Component :: START");
			}
			super.paintComponents(g);
			System.out.println("XCoord: " + m_C4Animation.getXCoord());
			System.out.println("YCoord: " + m_C4Animation.getYCoord());
			
			Graphics2D g2d = (Graphics2D) g;
			
			g2d.setColor(Color.WHITE);
			g2d.fillOval(m_C4Animation.getXCoord() + X_INC, 
					m_C4Animation.getLowestYCoord() + Y_INC,
					OVAL_HEIGHT, OVAL_WIDTH);
			
			g2d.setColor(m_C4Animation.getPlayerColour());
			g2d.fillOval(m_C4Animation.getXCoord() + X_INC, m_C4Animation.getYCoord() + Y_INC,
					OVAL_HEIGHT, OVAL_WIDTH);
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
			g2d.dispose();
		}
	}
	
	private JFrame m_frame;
	private Connect4Animation m_C4Animation;
	private boolean m_trace = false;
}
