import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import Player.HumanPlayer;
/** This is a test class
* 
* \\file -GameControllerTest.java 
* \author - Thomas Letheby
* \date -22nd Feb 14
* \see GameController.java
*
* \brief Testing the GameController class
*
* Sets up a new GameController and tests it. Manipulates the object
* by using the inbuilt methods, much like a fully functioning game from the user would.
*/

public class GameControllerTest {

	@Test
	public void TestGetGameOn1() {
		GameController test = new GameController(GameController.GameType.OTHELLO);
		assertTrue(test.GetGamOn() == true);
		
		GameController test2 = new GameController(GameController.GameType.CONNECTFOUR);
		assertTrue(test2.GetGamOn() == true);
	}
	
	@Test
	public void TestGetGameOn2() {
		GameController test1 = new GameController(GameController.GameType.OTHELLO);
		test1.SetGameOn(true);
		assertTrue(test1.GetGamOn() == false);
		
		GameController test2 = new GameController(GameController.GameType.CONNECTFOUR);
		test2.SetGameOn(true);
		assertTrue(test2.GetGamOn() == false);
	}
	
	@Test
	public void TestGetPlayerName1() {
		GameController test1 = new GameController(GameController.GameType.OTHELLO);
		assertTrue(test1.GetPlayerName(Color.BLACK) == "Bob");
		GameController test2 = new GameController(GameController.GameType.CONNECTFOUR);
		assertTrue(test2.GetPlayerName(Color.RED) == "Jim");
	}
	
	@Test
	public void TestGetPlayerName2() {
		HumanPlayer C4p1 = new HumanPlayer("Jack", Color.RED);
		HumanPlayer C4p2 = new HumanPlayer("David", Color.YELLOW);
		
		HumanPlayer Op1 = new HumanPlayer("Ben", Color.BLACK);
		HumanPlayer Op2 = new HumanPlayer("Bob", Color.WHITE);
		
		GameController test1 = new GameController(GameController.GameType.CONNECTFOUR, C4p1, C4p2);
		assertTrue(test1.GetPlayerName(Color.YELLOW) == "David");
		assertTrue(test1.GetPlayerName(Color.RED) == "Jack");
		
		GameController test2 = new GameController(GameController.GameType.CONNECTFOUR, Op1, Op2);
		assertTrue(test2.GetPlayerName(Color.BLACK) == "Ben");
		assertTrue(test2.GetPlayerName(Color.WHITE) == "Bob");
	}
	
}

