import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;
/**
 * \\file -OthelloAnimatioTest.java 
 * \author -Ben Golightly
 * \date -28th March 2014
 * 
 * \brief this tests the othello animation class
 * 
 * This test runs the animation to check if any errors occur.
 * 
 */

public class OthelloAnimationTest {

	// test it runs without a runtime exception
	
	/**
	 * This test runs the animation to check if any errors occur.
	 */
	@Test
	public void test() {
		
		try
		{
			GameController g = new GameController(GameController.GameType.OTHELLO);
			OthelloAnimation a = new OthelloAnimation(g.GetGUI());
			a.animate(0, 0, Color.WHITE, 0);
			
			try{
				Thread.sleep(1000);
			}
			catch (InterruptedException e) { fail("test inconclusive due" +
				"to inturruption"); }
		}
		catch (RuntimeException e)
		{
			fail("Runtime exception!");
		}
	}

}
