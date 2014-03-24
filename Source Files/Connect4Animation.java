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
		setXCoord(INITIAL_X);
		//Set the X Coordinate to be where the player has clicked
		setYCoord(INITIAL_Y);	//Set the Y Coordinate to be 0
		String playerColour = getGUI().GetGame().GetCurrent().GetPiece();
		
		EventHandler handler = new EventHandler();
		javax.swing.Timer timer = new javax.swing.Timer(DELAY, handler);
		setTimer(timer);
		
		if (playerColour == "red") {
			ImageIcon ii = new ImageIcon("piece\\red.png");
			setPiece(ii.getImage());
		} else {
			ImageIcon ii = new ImageIcon("piece\\yellow.png");
			setPiece(ii.getImage());
		}
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
	
	private class MotionListener implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            if (getRunBool() == false) {
                if (getXCoord() < WIDTH && getXCoord() > 0) {
                    setYCoord(e.getX());
                    repaint();
                } else if (getXCoord() > WIDTH) {
                    setXCoord(getXCoord() - 1);
                    repaint();
                } else if (getXCoord() < 0) {
                    setXCoord(getXCoord() + 1);
                    repaint();
                } else {
                    setXCoord(INITIAL_X);
                    repaint();
                }
            }

        }
        
    }

	@Override
	public int getYCoord() {
		return m_yCoord;
	}

	@Override
	public void setYCoord(int coord) {
		m_yCoord = coord;
	}

	@Override
	public int getXCoord() {
		return m_xCoord;
	}

	@Override
	public void setXCoord(int coord) {
		m_xCoord = coord;		
	}
	
	private int m_xCoord;
	private int m_yCoord;
}