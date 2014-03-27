import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.awt.Color;

import org.junit.Test;

import Player.HumanPlayer;

/** This is a test class
* \\file -ConnectFourTest.java 
* \author - Lam Chak Yan 667271
* \date -21st Feb 14
* \see ConnectFour.java
*
* \brief Testing the ConnectFour game class
*
* The test simulates the potential moves that the player might make by placing random pieces
* the pieces are sometimes there to throw an error. Also checks that the winning condition
* is found.
*/

public class ConnectFourTest {

	HumanPlayer p1 = new HumanPlayer("Jim", Color.RED);
	HumanPlayer p2 = new HumanPlayer("Bob", Color.YELLOW);
	GameController g = new GameController(GameController.GameType.OTHELLO);
	ConnectFour c4 = new ConnectFour();
	
	/**
	 * Invalid colour is tested in ConnectFourPieceTest
	 */
	@Test
	public void testSetPiece() {
		/**Valid Test Cases*/
		assertTrue(c4.SetPiece(9,6,Color.RED));
		assertTrue(c4.SetPiece(0,0,Color.YELLOW));
		
		/**Invalid Test Cases*/
		assertFalse(c4.SetPiece(9, 7, Color.RED));
		assertFalse(c4.SetPiece(10, 8, Color.YELLOW));
		assertFalse(c4.SetPiece(-1, -1, Color.YELLOW));
	}
	
	@Test
	public void testGetWidth() {
		/**Valid Test Cases*/
		assertEquals(10, c4.GetWidth());

		/**Invalid Test Cases*/
		assertThat(0, not(c4.GetWidth()));
		assertThat(-5, not(c4.GetWidth()));
		assertThat(9, not(c4.GetWidth()));
		assertThat(999, not(c4.GetWidth()));
	}
	
	@Test
	public void testGetHeight() {
		/**Valid Test Cases*/
		assertEquals(7, c4.GetHeight());

		/**Invalid Test Cases*/
		assertThat(0, not(c4.GetHeight()));
		assertThat(-2, not(c4.GetHeight()));
		assertThat(9, not(c4.GetHeight()));
		assertThat(999, not(c4.GetHeight()));
	}
	
	@Test
	public void testMove() {
		/**Valid Test Cases*/
		assertTrue(c4.Move(9,6,Color.RED));
		assertTrue(c4.Move(9,1,Color.YELLOW));
		assertTrue(c4.Move(9,6,Color.RED));
		assertTrue(c4.Move(9,1,Color.YELLOW));
		assertTrue(c4.Move(9,2,Color.RED));
		assertTrue(c4.Move(9,3,Color.YELLOW));
		assertTrue(c4.Move(9,4,Color.RED));
		
		/**Invalid Test Cases*/
		assertFalse(c4.Move(9,7,Color.RED));
	}
	
	@Test
	public void testWinningCondition() {
		/**Invalid Test Cases*/
		assertFalse(c4.WinningCondition());
		
		/**Valid Test Cases*/
		c4.Move(9,6,Color.RED);
		c4.Move(9,5,Color.RED);
		c4.Move(9,6,Color.RED);
		c4.Move(9,6,Color.RED);
		assertTrue(c4.WinningCondition());
	}
	
	@Test
	public void testSetWinner(){
		/**Invalid Test Cases*/
		assertFalse(c4.SetWinner());
		
		/**Valid Test Cases*/
		c4.Move(9,6,Color.RED);
		c4.Move(9,5,Color.RED);
		c4.Move(9,6,Color.RED);
		c4.Move(9,6,Color.RED);
		assertTrue(c4.SetWinner());
	}
	
	@Test
	public void testGetPiece(){
		assertEquals(null ,c4.GetPiece(2, 2));
		c4.Move(9,3,Color.RED);
		assertEquals(Color.RED ,c4.GetPiece(9, 6).GetColour());
	}
	
	@Test
	public void testGetWinningColour(){
		assertThat(Color.RED, not(c4.GetWinningColour()));
		c4.Move(9,6,Color.RED);
		c4.Move(9,6,Color.RED);
		c4.Move(9,6,Color.RED);
		c4.Move(9,6,Color.RED);
		c4.SetWinner();
		assertEquals(Color.RED, c4.GetWinningColour());
	}
	
	@Test
	public void testGetTotalPieces(){
		assertEquals(0, c4.GetTotalPieces());
		c4.Move(9,6,Color.RED);
		c4.Move(9,6,Color.RED);
		assertEquals(2, c4.GetTotalPieces());
	}

}
