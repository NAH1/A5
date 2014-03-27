import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;


public class OthelloAnimationPointTest {

	// Test that a point animates to completion
	@Test
	public void testCompletion() {
		OthelloAnimationPoint p = new OthelloAnimationPoint
					(0, 0, 1, FRAMES, 0);
		
		for (int i = 0; i < FRAMES - 1; i++) {
			p.sync();
			assertFalse(p.completed());
		}
		
		p.sync();
		assertTrue(p.completed());
	}
	
	private final int FRAMES = 100;

}

