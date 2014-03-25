import static org.junit.Assert.*;

import org.junit.Test;
/**
* \\file -SelectionTest.java
* \author -Thomas Letheby 
* \date -25th Feb 14
*\see Selection.java
*
*\brief Selection.java test
*
*The class is a test class for Selection.java
*There are tests for testing valid and invalid inputs.
*/

public class SelectionTest {

	Selection selectTest;
	@Test
	public void testSelection() {
		/**Valid Test Cases*/
		selectTest = new Selection(GameController.GameType.OTHELLO);
		assertTrue(selectTest.GetGameType() == GameController.GameType.OTHELLO);
		selectTest = new Selection(GameController.GameType.CONNECTFOUR);
		assertTrue(selectTest.GetGameType() == GameController.GameType.CONNECTFOUR);
		selectTest = new Selection(GameController.GameType.CONNECTFOUR);
		assertTrue(selectTest.GetGameType() == GameController.GameType.CONNECTFOUR);
	}

	@Test
	public void testGetGameType() {
		/**Test that GetGameType() returns the two accepted options,
		 * Invalid entries that will not return on this method call 
		 * are listed in the testSelection() method*/
		selectTest = new Selection(GameController.GameType.OTHELLO);
		assertTrue(selectTest.GetGameType() == GameController.GameType.OTHELLO);
		selectTest = new Selection(GameController.GameType.CONNECTFOUR);
		assertTrue(selectTest.GetGameType() == GameController.GameType.CONNECTFOUR);
		
	}

	@Test
	public void testDraw() {
		selectTest = new Selection(GameController.GameType.OTHELLO);
		selectTest.Draw();
	}



}
