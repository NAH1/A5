
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.awt.Color;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.Assert;
import org.junit.Test;

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

	HumanPlayer p1 = new HumanPlayer("Jim", Color.BLACK);
	HumanPlayer p2 = new HumanPlayer("Bob", Color.WHITE);
	GameController game = new GameController(GameController.GameType.OTHELLO, p1, p2);
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
		assertArrayEquals(testAvailabeMove, othello.AvailableMove(Color.BLACK));
		
		/**Invalid Test Cases*/
		Assert.assertThat(testAvailabeMove, IsNot.not(IsEqual.equalTo(othello.AvailableMove(Color.WHITE))));
		
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
		assertTrue(othello.SetPiece(4, 2, Color.BLACK));
		assertTrue(othello.SetPiece(5, 3, Color.BLACK));
		assertTrue(othello.SetPiece(2, 4, Color.WHITE));
		assertTrue(othello.SetPiece(3, 5, Color.WHITE));
		
		/**Invalid Test Cases*/
		assertFalse(othello.SetPiece(
				99, 99, Color.BLACK));
		assertFalse(othello.SetPiece(
				99, 99, Color.WHITE));
		assertFalse(othello.SetPiece(-1, -5, Color.BLACK));
		assertFalse(othello.SetPiece(-1, -5, Color.WHITE));
		assertFalse(othello.SetPiece(-1, -5, Color.YELLOW));
	}

	@Test
	public void testCheckPassTurn() {
		/**Valid Test Cases*/
		othello.SetPiece(4, 2, Color.BLACK);
		othello.SetPiece(5, 3, Color.BLACK);
		othello.SetPiece(2, 4, Color.BLACK);
		othello.SetPiece(3, 5, Color.BLACK);
		othello.AvailableMove(Color.BLACK);
		assertTrue(othello.CheckPassTurn());
		
		/**Invalid Test Cases*/
		othello.SetPiece(4, 2, Color.BLACK);
		othello.SetPiece(5, 3, Color.BLACK);
		othello.SetPiece(2, 4, Color.WHITE);
		othello.SetPiece(3, 5, Color.WHITE);
		othello.AvailableMove(Color.BLACK);
		assertFalse(othello.CheckPassTurn());
		
	}

	@Test
	public void testMove() {
		/**Valid Test Cases*/
		assertTrue(othello.Move(4, 2, Color.BLACK));
		assertTrue(othello.Move(5, 2, Color.WHITE));
		
		/**Invalid Test Cases*/
	 	assertFalse((othello.Move(-99, -22, Color.BLACK)));
	 	assertFalse((othello.Move(992, -422, Color.YELLOW)));
	 	assertFalse((othello.Move(-7, 422, Color.BLACK)));
	}

	@Test
	public void testWinningCondition() {
		for (int i = 0; i < othello.GetHeight(); i++) {
			for (int j = 0; j < othello.GetWidth(); j++) {
					othello.SetPiece(j, i, Color.BLACK);
			}
		}
		/**Valid Test Cases*/
		assertTrue(othello.WinningCondition());
		
	}
}
