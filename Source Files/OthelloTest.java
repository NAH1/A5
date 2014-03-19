
import static org.junit.Assert.*;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import Player.HumanPlayer;
import boardGame.*;

/** This is a testing class
*\\file -OthelloTest.java 
* \author -Chun Kit So 742666
* \date -21th Feb 14
* \see Othello.java
*
* \brief The following class tests the Othello Game 
*
* moves and pieces are simulated to check for any potential move errors
* and any other errors in the code.
*/

public class OthelloTest {

	HumanPlayer p1 = new HumanPlayer("Jim", "black");
	HumanPlayer p2 = new HumanPlayer("Bob", "white");
	GameController game = new GameController("othello", p1, p2);
	Othello othello = new Othello();

	@Test
	public void testAvailableMove() {
		
		/**Valid Test Cases*/
		char[][] testAvailabeMove = new char[othello.GetWidth()][othello
				.GetHeight()];
		testAvailabeMove[4][2] = 'O';
		testAvailabeMove[5][3] = 'O';
		testAvailabeMove[2][4] = 'O';
		testAvailabeMove[3][5] = 'O';
		for (int i = 0; i < othello.GetHeight(); i++) {
			for (int j = 0; j < othello.GetWidth(); j++) {
				if (testAvailabeMove[j][i] != 'O')
					testAvailabeMove[j][i] = 'X';
			}
		}
		assertArrayEquals(testAvailabeMove, othello.AvailableMove("black"));
		
		/**Invalid Test Cases*/
		Assert.assertThat(testAvailabeMove, IsNot.not(IsEqual.equalTo(othello.AvailableMove("white"))));
		
	}

	@Test
	public void testGetWidth() {
		/**Valid Test Cases*/
		assertEquals(8, othello.GetWidth());
		
		/**Invalid Test Cases*/
		assertThat(0, not(othello.GetWidth()));
		assertThat(2, not(othello.GetWidth()));
		assertThat(9, not(othello.GetWidth()));
		assertThat(999, not(othello.GetWidth()));
	}

	@Test
	public void testGetHigh() {
		/**Valid Test Cases*/
		assertEquals(8, othello.GetHeight());
		
		/**Invalid Test Cases*/
		assertThat(0, not(othello.GetHeight()));
		assertThat(2, not(othello.GetHeight()));
		assertThat(9, not(othello.GetHeight()));
		assertThat(999, not(othello.GetHeight()));
	}

	@Test
	public void testGetWhiteScore() {
		/**Valid Test Cases*/
		assertEquals(2, othello.GetWhiteScore());
		
		/**Invalid Test Cases*/
		assertThat(0, not(othello.GetWhiteScore()));
		assertThat(3, not(othello.GetWhiteScore()));
		assertThat(10, not(othello.GetWhiteScore()));
		assertThat(9999, not(othello.GetWhiteScore()));
	}

	@Test
	public void testGetBlackScore() {
		/**Valid Test Cases*/
		assertEquals(2, othello.GetBlackScore());
		
		/**Invalid Test Cases*/
		assertThat(0, not(othello.GetBlackScore()));
		assertThat(3, not(othello.GetBlackScore()));
		assertThat(10, not(othello.GetBlackScore()));
		assertThat(9999, not(othello.GetBlackScore()));
	}

	@Test
	public void testSetPiece() {
		/**Valid Test Cases*/
		assertTrue(othello.SetPiece(4, 2, "black"));
		assertTrue(othello.SetPiece(5, 3, "black"));
		assertTrue(othello.SetPiece(2, 4, "white"));
		assertTrue(othello.SetPiece(3, 5, "white"));
		
		/**Invalid Test Cases*/
		assertFalse(othello.SetPiece(
				99, 99, "black"));
		assertFalse(othello.SetPiece(
				99, 99, "white"));
		assertFalse(othello.SetPiece(-1, -5, "black"));
		assertFalse(othello.SetPiece(-1, -5, "white"));
		assertFalse(othello.SetPiece(-1, -5, "yellow"));
	}

	@Test
	public void testCheckPassTurn() {
		/**Valid Test Cases*/
		othello.SetPiece(4, 2, "black");
		othello.SetPiece(5, 3, "black");
		othello.SetPiece(2, 4, "black");
		othello.SetPiece(3, 5, "black");
		othello.AvailableMove("black");
		assertTrue(othello.CheckPassTurn());
		
		/**Invalid Test Cases*/
		othello.SetPiece(4, 2, "black");
		othello.SetPiece(5, 3, "black");
		othello.SetPiece(2, 4, "white");
		othello.SetPiece(3, 5, "white");
		othello.AvailableMove("black");
		assertFalse(othello.CheckPassTurn());
		
	}

	@Test
	public void testMove() {
		/**Valid Test Cases*/
		assertTrue(othello.Move(4, 2, "black"));
		assertTrue(othello.Move(5, 2, "white"));
		
		/**Invalid Test Cases*/
	 	assertFalse((othello.Move(-99, -22, "black")));
	 	assertFalse((othello.Move(992, -422, "yellow")));
	 	assertFalse((othello.Move(-7, 422, "black")));
	}

	@Test
	public void testWinningCondition() {
		for (int i = 0; i < othello.GetHeight(); i++) {
			for (int j = 0; j < othello.GetWidth(); j++) {
					othello.SetPiece(j, i, "black");
			}
		}
		/**Valid Test Cases*/
		assertTrue(othello.WinningCondition());
		
	}
}
