import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;


public class AIHardTest {

	@Test
	public void test() {
		BoardGame b = new Othello();
		AIHard a = new AIHard("A", Color.black);
		assertTrue(a.takeMove());
		int x = a.getX();
		int y =a.getY();
		assertTrue(
				((x == 5) && (y == 3)) ||
				((x == 6) && (y ==4)) ||
				((x == 3) && (y == 5)) ||
				((x == 4) && (y ==6))
				);
	}
}
