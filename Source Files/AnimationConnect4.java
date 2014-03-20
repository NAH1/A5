import javax.swing.JFrame;

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
		setXCoord(INITIAL_X); //Set the X Coordinate to be where the player has clicked
		setYCoord(INITIAL_Y);	//Set the Y Coordinate to be 0
		System.out.println("HEIGHT: " + HEIGHT + " WIDTH: " + WIDTH);
		System.out.println("Y Coordinate: " + getYCoord() + " X Coordinate: " + getXCoord());
	}

	/**
	 * Increment the Y Coordinate of the piece and check if the piece
	 * will move off the board if it is incremented any further
	 */
	@Override
	protected void cycle() {
		if (getYCoord() > HEIGHT) {
			setRunBool(false);
			//getAnimatorThread().interrupt();
			//setYCoord(INITIAL_Y);
		} else {
			setYCoord(getYCoord() + 1);
		}		
	}
	
	/**
	 * 
	 */
	@Override
	public void run() {
		long startTime, timeDiff, sleep;
		int defaultSleep = 2;
		
		startTime = System.currentTimeMillis();
		
		while (getRunBool() == true) {
			GamePiece piece;
			cycle();
			if (getYCoord() > 0) {
				getGUI().m_panels[getXCoord()][getYCoord() - 1].removeAll();
				getGUI().m_panels[getXCoord()][getYCoord() - 1].add(getGUI().m_labels[getXCoord()][getYCoord() - 1]);
				System.out.println("Y Coordinate: " + getYCoord() + " X Coordinate: " + getXCoord());
			}			
			//getGame().SetPiece(getXCoord(), getYCoord(), "red");
			piece = getGame().GetPiece(getXCoord(), getYCoord());
			getGUI().m_labels[getXCoord()][getYCoord()].setIcon(piece.GetIcon());
			
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

}
