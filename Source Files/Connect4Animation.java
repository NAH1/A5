import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.print.attribute.AttributeSetUtilities;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import piece.*;
import boardGame.*;

/**
 * \\file - Connect4Animation.java
 * \author Daniel Squires - 709547
 * \date 22/03/2014
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
	 * Constructor of Connect4Animation
	 * Calls the constructor of superclass Animation
	 * Sets the X and Y Coordinate, and sets the Image Piece
	 * \param frame - 
	 * \param game - 
	 * \param gui - 
	 */
	public Connect4Animation(GUI gui) {
		super(gui.FRAME, gui.GetBoard(), gui);
		setYCoord(0);
		
		EventHandler handler = new EventHandler();
		javax.swing.Timer timer = new javax.swing.Timer(DELAY, handler);
		setTimer(timer);
		Toolkit.getDefaultToolkit().addAWTEventListener(
				this, AWTEvent.MOUSE_MOTION_EVENT_MASK);
	}

	/**
	 * Increment the Y Coordinate of the piece and check if the piece
	 * will move off the board if it is incremented any further
	 */
	@Override
	protected void cycle() {
		final int INCREMENT = 5;
		
		if (getYCoord() >= HEIGHT) {
			setRunBool(false);
			//getAnimatorThread().interrupt();
			//setYCoord(INITIAL_Y);
		} else {
			setYCoord(getYCoord() + INCREMENT);
		}		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		System.out.println("Paint Component :: START");
		if (getRunBool() == true) {
			drawPiece(g);
		}
		System.out.println("Paint Component :: END");
	}
	
	/**
	 * Draw the piece onto the Board
	 * \param Graphics g - The Graphics Context
	 */
	@Override
	protected void drawPiece(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(getPiece(), getXCoord(), getYCoord(), this);
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	@Override
	public void animate(int xCoord, int yCoord, Color playerColour) {
		setXCoord(xCoord);
		setYCoord(0);
		setLowestYCoord(yCoord);
		
		if (playerColour == Color.RED) {
			ImageIcon ii = new ImageIcon("piece\\red.png");
			setPiece(ii.getImage());
		} else {
			ImageIcon ii = new ImageIcon("piece\\yellow.png");
			setPiece(ii.getImage());
		}
		
		getTimer().start();
	}
	
	@Override
	public void eventDispatched(AWTEvent event) {
        if (event instanceof MouseEvent) { 
            MouseEvent me = (MouseEvent) event; 
            if (!SwingUtilities.isDescendingFrom(me.getComponent()
            		, getGUIFrame())) { 
                return; 
            } 
            if (me.getID() == MouseEvent.MOUSE_MOVED &&
            		me.getComponent() == getGUI().FRAME) {
            	if (!getRunBool()) {
            		setXCoord(((MouseEvent) event).getX());
            		repaint();
            	}            	
            } 
            if (me.getID() == MouseEvent.MOUSE_CLICKED &&
            		me.getComponent() == getGUI().FRAME) {
                if (!getRunBool()) {
                    setRunBool(true);
                    animate(((MouseEvent) event).getX(), HEIGHT, 
                    		getGUI().GetGame().GetCurrent().GetPieceColour());
                }
            } 
        } 
	}
	
	private int m_xCoord;
	private int m_yCoord;
	private int m_lowestYCoord;
}
