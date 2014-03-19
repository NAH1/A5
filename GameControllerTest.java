import static org.junit.Assert.*;

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
		GameController test = new GameController("othello");
		assertTrue(test.GetGamOn() == true);
		
		GameController test2 = new GameController("connectfour");
		assertTrue(test2.GetGamOn() == true);
	}
	
	@Test
	public void TestGetGameOn2() {
		GameController test1 = new GameController("othello");
		test1.SetGameOn(true);
		assertTrue(test1.GetGamOn() == false);
		
		GameController test2 = new GameController("connectfour");
		test2.SetGameOn(true);
		assertTrue(test2.GetGamOn() == false);
	}
	
	@Test
	public void TestGetPlayerName1() {
		GameController test1 = new GameController("othello");
		assertTrue(test1.GetPlayerName("black") == "Bob");
		GameController test2 = new GameController("connectFour");
		assertTrue(test2.GetPlayerName("red") == "Jim");
	}
	
	@Test
	public void TestGetPlayerName2() {
		HumanPlayer C4p1 = new HumanPlayer("Jack", "red");
		HumanPlayer C4p2 = new HumanPlayer("David", "yellow");
		
		HumanPlayer Op1 = new HumanPlayer("Ben", "black");
		HumanPlayer Op2 = new HumanPlayer("Bob", "white");
		
		GameController test1 = new GameController("ConnectFour", C4p1, C4p2);
		assertTrue(test1.GetPlayerName("yellow") == "David");
		assertTrue(test1.GetPlayerName("red") == "Jack");
		
		GameController test2 = new GameController("connectFour", Op1, Op2);
		assertTrue(test2.GetPlayerName("black") == "Ben");
		assertTrue(test2.GetPlayerName("white") == "Bob");
	}
	
}

