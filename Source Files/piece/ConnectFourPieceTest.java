package piece;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;
/** This is a test class
* \\file ConnectFourPieceTest.java
* \author Gavin Bailey 711036
* \date 24th Feb 14
* 
*  \see ConnectFourPiece.java , GamePiece.java
*
* \brief This class tests the ConnectFourPiece
*
* The ConnectFourPiece was tested with invalid colours that are valid for 
* the other class. There was also tests of numebrs which shouldn't be allowed
* and there was tests for setting the Icons. As ConnectFourPiece inherits from
* GamePiece.java therefore this goes towards testing that class.
*/
public class ConnectFourPieceTest {

	ConnectFourPiece C4P;
	@Test
	public void testGetIcon() {
		/**Tests that there is still a piece being set
		 * (Invalid Tests)
		 * */
		C4P = new ConnectFourPiece(null);
		assertTrue(C4P.GetIcon() == null);
		C4P = new ConnectFourPiece(Color.BLACK);
		assertTrue(C4P.GetIcon() == null);
		C4P = new ConnectFourPiece(Color.WHITE);
		assertTrue(C4P.GetIcon() == null);
		
		/**Valid Tests*/
		C4P = new ConnectFourPiece(Color.RED);
		assertTrue(C4P.GetIcon() != null);
		C4P = new ConnectFourPiece(Color.YELLOW);
		assertTrue(C4P.GetIcon() != null);
		
	}

	@Test
	public void testSetIcons() {
		System.out.println("SetIcons() Cannot be tested like this" +
				"but instead is tested by attempting to set pieces above.");
	}

	@Test
	public void testConnectFourPiece() {
		C4P = new ConnectFourPiece(Color.BLACK);
		assertTrue(C4P.SetIcons());
		C4P = new ConnectFourPiece(Color.WHITE);
		assertTrue(C4P.SetIcons());
		C4P = new ConnectFourPiece(Color.YELLOW);
	}

}
