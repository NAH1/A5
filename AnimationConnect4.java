import javax.swing.JFrame;

import boardGame.*;

public class AnimationConnect4 extends Animation{

	/**
	 * Constructor method
	 * \param frame
	 * \param game
	 */
	public AnimationConnect4(JFrame frame, ConnectFour game) {
		super(frame, game);
		//setXCoord(0); //Set the X Coordinate to be where the player has clicked
		setYCoord(0);	//Set the Y Coordinate to be 0
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
			cycle();
			getGame().SetPiece(getXCoord(), getYCoord(), "red");
			
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
