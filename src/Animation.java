import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 	\\file - Animation.java
 * 	\author Daniel Squires - 709547
 * 	\date 18/03/2014
 * 
 * 	\brief Abstract animation super class
 * 
 * 	Super class for the 2 animation classes, has an abstract method
 * 	animate which is used by the classes to start animations,
 * 	abstract method cycle which will be called each cycle of the Timer,
 * 	setTimer which is private and only called in the createTimer class
 * 	and holds the Timer object and a final integer TIME_SLICE which is sent
 * 	to the Timer constructor for how long between each tick
 */
public abstract class Animation {	
	/**
	 * Instantiates the timer
	 * \param timer - timer object to instantiate m_timer to
	 */
	private void setTimer(javax.swing.Timer timer) {
		m_timer = timer;
	}
	
	/**
	 * Get the timer
	 * \return the timer m_timer
	 */
	public javax.swing.Timer getTimer () {
		return m_timer;
	}
	
	/**
	 * Used to create the timer object which is used by
	 * the Animation classes
	 */
	protected void createTimer() {
		javax.swing.Timer timer =
				new javax.swing.Timer(TIME_SLICE, new ActionListener() {         
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
	 * \param delay - optional delay
	 */
	public abstract void animate(int xcoord, int ycoord, Color playerColour,
				int delay);
	
	/**
	 * This abstract method will be used to update GUI coordinates
	 */
	protected abstract void cycle();

	//Global Vairables
	private javax.swing.Timer m_timer;
    protected final int TIME_SLICE = 16;
    //the initial delay to put the thread to sleep by
}
