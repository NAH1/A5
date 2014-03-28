import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

/**
 * \\file - AIEasyTest.java
 * \author - Geraint Howard - 710909
 * \date - 27/03/14
 * 
 * \brief A test class that tests the AIEasy by placing pieces 
 * into positions that are valid moves
  */

public class AIEasyTest {
    
	/**
	 * Tests the AIEasy by making a valid move in Othello
	 */
	@Test
	public void test() {
		BoardGame b = new Othello();
		AIEasy a = new AIEasy("A", Color.black);
		assertTrue(a.takeMove());
		int x = a.getX();
		int y =a.getY();
		assertTrue(
                   ((x == BLACK1X + 1) && (y == BLACK1Y - 1)) ||
                   ((x == WHITE1X + 1) && (y == BLACK1Y)) ||
                   ((x == BLACK1X - 1) && (y == BLACK1Y + 1)) ||
                   ((x == BLACK1X) && (y == WHITE2Y + 1))
                   );
	}
	final int BLACK1X = 3;
	final int BLACK1Y = 3;
	final int WHITE1X = 4;
	final int WHITE2Y = 4 ;
}
