import javax.swing.JFrame;

import boardGame.*;

/**
 * 
 * \author Daniel
 *
 */
public class AnimationOthello extends Animation{

	/**
	 * 
	 * \param frame - 
	 * \param game - 
	 */
	public AnimationOthello(JFrame frame,  Othello game) {
		super(frame, game);		
	}

	/**
	 * 
	 */
	@Override
	protected void cycle() {
		long startTime, timeDiff, sleep;
		int defaultSleep = 2;
		
		startTime = System.currentTimeMillis();
		while (getRunBool() == true) {
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
		}
	}

	@Override
	public void run() {
		
		
	}
	
	

}
