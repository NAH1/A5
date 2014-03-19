import static org.junit.Assert.*;

import org.junit.Test;

import Player.HumanPlayer;
import boardGame.Othello;
/** 
* This is a test class
* \\file -OthelloGUITest.java 
* \author - Jake Daryl Plumley
* \date -22nd Feb 14
* \see OthelloGUI.java, GUI.java
*
* \brief The testing class for the OthelloGUI.java
*
* New players are simulated and the test is to make sure that information about the players
* can be set. This class also tests the GUI.java class as OthelloGUI inherits from this.
* 
*/

public class OthelloGUITest {
	HumanPlayer p1 = new HumanPlayer("Jim", "black");
	HumanPlayer p2 = new HumanPlayer("Bob", "white");
	Othello othello = new Othello();
	GameController game = new GameController("othello", p1, p2);
	OthelloGUI OthelloGUI = new OthelloGUI(othello, game);

	@Test
	public void testSetOthelloInfo() {
		assertTrue(OthelloGUI.SetOthelloInfo());
	}

	@Test
	public void testSetPanelColour() {
		assertTrue(OthelloGUI.SetPanelColour());
	}
}
