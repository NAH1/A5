import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * \\file - Animation.java
 * \author Daniel Squires - 709547
 * \date 18/03/2014
 */
public abstract class Animation {	
	/**
	 * 
	 * \param timer
	 */
	private void setTimer(javax.swing.Timer timer) {
		m_timer = timer;
	}
	
	/**
	 * 
	 * \return
	 */
	public javax.swing.Timer getTimer () {
		return m_timer;
	}
	
	protected void createTimer() {
		javax.swing.Timer timer =
				new javax.swing.Timer(DELAY, new ActionListener() {         
		        @Override
		        public void actionPerformed(ActionEvent e) {
		               cycle();          
		        }
		    });
		
		setTimer(timer);
	}
	
	/**
	 * Indicate that an animation should begin at the given point
	 * \param xcoord - (Start) x coordinate
	 * \param ycoord - (Start) y coordinate
	 * \param playerColour - the colour of the peice / current player
	 */
	public abstract void animate(int xcoord, int ycoord, Color playerColour);
	
	/**
	 * This abstract method will be used to update GUI coordinates
	 */
	protected abstract void cycle();

	//Global Vairables
	private javax.swing.Timer m_timer;
    protected final int DELAY = 16;
    //the initial delay to put the thread to sleep by
}
