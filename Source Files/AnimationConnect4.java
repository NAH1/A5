import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.ImageIcon;

import piece.GamePiece;
import boardGame.*;

public class AnimationConnect4 extends Animation{

	/**
	 * Constructor method
	 * \param frame
	 * \param game
	 */
	public AnimationConnect4(JFrame frame, BoardGame game, GUI gui) {
		super(frame, game, gui);
		setXCoord(INITIAL_X);
		//Set the X Coordinate to be where the player has clicked
		setYCoord(INITIAL_Y);	//Set the Y Coordinate to be 0
	}

	/**
	 * Increment the Y Coordinate of the piece and check if the piece
	 * will move off the board if it is incremented any further
	 */
	@Override
	protected void cycle() {
		if (getYCoord() >= HEIGHT) {
			setRunBool(false);
			//getAnimatorThread().interrupt();
			//setYCoord(INITIAL_Y);
		} else {
			setYCoord(getYCoord() + 1);
		}		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		System.out.println("Paint Component :: START");
		drawPiece(g);
		System.out.println("Paint Component :: END");
	}
	
	@Override
	protected void drawPiece(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(m_piece, getXCoord(), getYCoord(), getGUIFrame());
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}
	
	/**
	 * 
	 */
	@Override
	public void run() {
		System.out.println("Animator Thread :: START");
		long startTime, timeDiff, sleep;
		int defaultSleep = 2;
		ImageIcon newPiece = new ImageIcon();
		String playerColour = getGUI().GetGame().GetCurrent();
		
		startTime = System.currentTimeMillis();
		
		while (getRunBool() == true) {
			GamePiece piece = getGame().GetPiece(0, 0);
			cycle();
			//setGUIFrame(getGUI().getFrame());
			getGUIFrame().repaint();
			if (getYCoord() > 0) {
				
			}			
			//getGame().SetPiece(getXCoord(), getYCoord(), "red");
			
			timeDiff = System.currentTimeMillis() - startTime;
			sleep = DELAY - timeDiff;
			
			if (sleep < 0) {
				sleep = defaultSleep;
			}
			
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				System.out.println("Interrupted: " + e.getMessage());
			}
			
			startTime = System.currentTimeMillis();
		}
	}
	
	private Image m_piece;
}
