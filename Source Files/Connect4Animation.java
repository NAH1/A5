import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.print.attribute.AttributeSetUtilities;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import piece.*;

/**
 * \\file - Connect4Animation.java
 * \author Daniel Squires - 709547
 * \date 22/03/2014
 * 
 * \brief Class which handles all the animations for connect four
 * 
 */
public class Connect4Animation extends Animation{
	/**
	 * Get the y coordinate of the piece
	 * \return the Y Coordinate of the piece m_yCoord
	 */
	public int getYCoord() {
		return m_yCoord;
	}

	/**
	 * Set the value to the y Coordinate m_yCoord
	 * \param coord the integer to set the y coordinate to
	 */
	public void setYCoord(int coord) {
		m_yCoord = coord;
	}
	
	/**
	 * Get the lowest y place in the column that is not filled
	 * \return the Lowest Y Coordinate of the Column m_lowestYCoord
	 */
	public int getLowestYCoord() {
		return m_lowestYCoord;
	}
	
	/**
	 * Set the value to the lowest Y Coordinate m_lowestYCoord
	 * \param coord the integer to set the lowest y coordinate to
	 */
	public void setLowestYCoord(int coord) {
		m_lowestYCoord = coord;
	}

	/**
	 * Get the x coordinate of the piece
	 * \return the X Coordinate of the piece m_xCoord
	 */
	public int getXCoord() {
		return m_xCoord;
	}

	/**
	 * Set the value to the x Coordinate m_xCoord
	 * \param coord the integer to set the x coordinate to
	 */
	public void setXCoord(int coord) {
		m_xCoord = coord;		
	}	
	
	/**
	 * 
	 * \return m_playerColour the colour of the players piece
	 */
	public Color getPlayerColour() {
		return m_playerColour;
	}
	
	/**
	 * 
	 */
	public void setAnimationPane() {
		m_GlassPane.setC4Animation(this);
	}
	
	/**
	 * Constructor of Connect4Animation
	 * Calls the constructor of superclass Animation
	 * Sets the X and Y Coordinate, and sets the Image Piece
	 * \param frame - 
	 * \param game - 
	 * \param gui - 
	 */
	public Connect4Animation(GUI gui) {
		setYCoord(0);
		WIDTH = gui.GetBoard().GetWidth();
		HEIGHT = gui.GetBoard().GetHeight();
		
		createTimer();
		
		JFrame frame = gui.GetFrame();
		m_GlassPane = new Connect4AnimationPane(frame);		
		frame.setGlassPane(m_GlassPane);
		m_GlassPane.setVisible(true);
		
	}

	/**
	 * Increment the Y Coordinate of the piece and check if the piece
	 * will move off the board if it is incremented any further
	 */
	@Override
	protected void cycle() {
		final int INCREMENT = 10;
		
		if (getYCoord() >= getLowestYCoord()) {
			if (m_trace) {
				System.out.println("Stopping Cycle");
			}
			getTimer().stop();
			setYCoord(INITIAL_Y);
			//getAnimatorThread().interrupt();
			//setYCoord(INITIAL_Y);
		} else {
			setYCoord(getYCoord() + INCREMENT);
		}
		m_GlassPane.repaint();
	}
	
	
	public void paintComponent(Graphics g) {
		System.out.println("Connect4Animation :: paintComponent: START");
	}
	
	@Override
	public void animate(int xCoord, int yCoord, Color playerColour, int delay) {
		setXCoord(xCoord * xMultiple);
		setYCoord(0);
		setLowestYCoord(yCoord * yMultiple);
		if (m_trace) {
			System.out.println("xCoord" + xCoord);
			System.out.println("LowestYCoord" + yCoord);
		}
		
		m_playerColour = playerColour;
		
		getTimer().start();
	}
	

	private int m_xCoord;
	private int m_yCoord;
	private int m_lowestYCoord;
	private Connect4AnimationPane m_GlassPane;
	private Color m_playerColour;
	protected final int INITIAL_X = 100;	//The initial X Coordinate of the Image
    protected final int INITIAL_Y = 2;	//The initial Y Coordinate of the Image
    protected final int WIDTH;		//Width of the gameboard
    protected final int HEIGHT;		//Height of the gameboard
    protected final int xMultiple = 71;
    protected final int yMultiple = 70;
    private boolean m_trace = false;
}
