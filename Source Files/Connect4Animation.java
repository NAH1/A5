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

import piece.*;
import boardGame.*;

/**
 * \\file - Connect4Animation.java
 * \author Daniel Squires - 709547
 * \date 22/03/2014
 */
public class Connect4Animation extends Animation{
	
	public int getYCoord() {
		return m_yCoord;
	}

	
	public void setYCoord(int coord) {
		m_yCoord = coord;
	}

	
	public int getXCoord() {
		return m_xCoord;
	}

	
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
	public Connect4Animation(JFrame frame, BoardGame game, GUI gui) {
		super(frame, game, gui);
		
		EventHandler handler = new EventHandler();
		javax.swing.Timer timer = new javax.swing.Timer(DELAY, handler);
		setTimer(timer);
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
		setYCoord(yCoord);
		
		if (playerColour == Color.RED) {
			ImageIcon ii = new ImageIcon("piece\\red.png");
			setPiece(ii.getImage());
		} else {
			ImageIcon ii = new ImageIcon("piece\\yellow.png");
			setPiece(ii.getImage());
		}
	}
	
	private int m_xCoord;
	private int m_yCoord;
}
