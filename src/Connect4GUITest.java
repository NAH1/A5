import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.junit.Test;

/** 
* This is a test class
* \\file Connect4GUITest.java
* \author Chak Yan Lam
* \date 22nd Feb 14
*
* \see Connect4GUI, GUI
*
* \brief The testing class for the Connect4GUI
*
* New players are simulated and the test is to make sure that information about the players
* can be set. This class also tests the GUI class as Connect4GUI inherits from this therefore 
* is tested here.
* 
*/
public class Connect4GUITest {
	HumanPlayer p1 = new HumanPlayer("Jim", Color.BLACK);
	HumanPlayer p2 = new HumanPlayer("Bob", Color.WHITE);
	ConnectFour C4 = new ConnectFour();
	GameController game = new GameController(
			GameController.GameType.OTHELLO, p1, p2);
	Connect4GUI C4GUI = new Connect4GUI(C4, game);
	

	@Test
	public void testSetConnectFourInfo() {
		assertTrue(C4GUI.setInfo());
	}

	@Test
	public void testSetPanelColour() {
		assertTrue(C4GUI.setPanelColour());
	}

}
