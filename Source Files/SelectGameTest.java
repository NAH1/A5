import org.junit.Test;
/**
 * \\file SelectGameTest.java
 * \author Tyrone Bramwell 710981 
 * \date 20th Feb 14
*  \see SelectGame.java
*
* \brief To test the SelectGame.java class
*
* There are only two methods that are able to be tested in this
* class. The second test fails as the method has no input parameters.
*
*/

public class SelectGameTest {

	@Test
	public void testDraw1() {
		SelectGame test = new SelectGame();
		test.Draw();
	}
	@Test
	public void testDraw(){
		SelectGame test = new SelectGame();
		test.Draw();
	}

}
