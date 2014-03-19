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
		selectTest = new Selection("Othello");
		assertTrue(selectTest.GetGameType() == "Othello");
		selectTest = new Selection("connectfour");
		assertTrue(selectTest.GetGameType() == "connectfour");
		selectTest = new Selection("CONNECTFOUR");
		assertTrue(selectTest.GetGameType() == "CONNECTFOUR");
		
		/**Invalid Test Cases*/
		selectTest = new Selection(" ");
		assertFalse(selectTest.GetGameType() == " ");
		selectTest = new Selection("CONNECT4");
		assertFalse(selectTest.GetGameType() == "CONNECT4");
		selectTest = new Selection("1,2,3");
		assertFalse(selectTest.GetGameType() == "1,2,3");
		selectTest = new Selection("&*&");
		assertFalse(selectTest.GetGameType() == "&*&");
	}

	@Test
	public void testGetGameType() {
		/**Test that GetGameType() returns the two accepted options,
		 * Invalid entries that will not return on this method call 
		 * are listed in the testSelection() method*/
		selectTest = new Selection("othello");
		assertTrue(selectTest.GetGameType() == "othello");
		selectTest = new Selection("connectfour");
		assertTrue(selectTest.GetGameType() == "connectfour");
		
	}

	@Test
	public void testDraw() {
		selectTest = new Selection("othello");
		selectTest.Draw();
	}



}
