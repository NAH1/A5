import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;


public class OthelloAnimationTest {

	// test it runs without a runtime exception
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
