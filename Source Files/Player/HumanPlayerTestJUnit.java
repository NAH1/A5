package Player;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;
/** This is a testing class
* \\file -HumanPlayerTestJUnit.java 
* \author -Mathew Lloyd 711293 
* \date -20th Feb 14
* \see HumanPlayer.java, Player.java
*
* \brief To test that the player class is working correctly
*
* The test class checks that the methods in the HumanClass are working correctly.
* The data is stored in the Player class therefore this testing class also tests
* the Player.java class.
*/
public class HumanPlayerTestJUnit {
	
	HumanPlayer hp = new HumanPlayer("JUnit test", Color.YELLOW);
	@Test
	public void testGetPiece() {
		assertEquals(Color.YELLOW, hp.GetPieceColour());
		
	}
	
	@Test
	public void testGetPlayerName() {
		
		assertTrue("JUnit test" ==  hp.GetPlayerName());
	}

	@Test
	public void testSetPieceColor() {
    	/**Valid Entries:*/
    	hp.SetPieceColor(Color.YELLOW);
    	assertEquals(Color.YELLOW, (hp.GetPieceColour()));
    	hp.SetPieceColor(Color.RED);
    	assertEquals(Color.RED, (hp.GetPieceColour()));
    	hp.SetPieceColor(Color.BLACK);
    	assertEquals(Color.BLACK, (hp.GetPieceColour()));
    	hp.SetPieceColor(Color.WHITE);
    	assertEquals(Color.WHITE, (hp.GetPieceColour()));
	}

	@Test
	public void testSetPlayerName() {
		hp.SetPlayerName("Proper Name Player");
		assertEquals("Proper Name Player", hp.GetPlayerName());
		hp.SetPlayerName("");
		assertEquals("", hp.GetPlayerName());
	}

}
