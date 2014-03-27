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
public class Connect4AnimationPane extends JPanel implements AWTEventListener {
	private JFrame m_frame;
	private Connect4Animation m_C4Animation;
	
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
		super.paintComponents(g);
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(m_C4Animation.getPiece(), m_C4Animation.getXCoord(),
				m_C4Animation.getYCoord(), this);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

	@Override
	public void eventDispatched(AWTEvent event) {
		if (event instanceof MouseEvent) { 
            MouseEvent me = (MouseEvent) event; 
            if (!SwingUtilities.isDescendingFrom(me.getComponent(), m_frame)) { 
                System.out.println("Return");
                return; 
            } 
        } 

	}

}
