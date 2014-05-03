import static org.junit.Assert.*;

import org.junit.Test;


public class BowlingGameTest {

	private Game g;
	
	protected void setUp() {
		g = new Game();
	}

	
	@Test
	public void testGutterGame() {
		setUp();
		rollMany(20, 0);
		
		assertEquals(0, g.score());
	}

	@Test
	public void testAllOnes() {
		setUp();
		rollMany(20, 1);
		
		assertEquals(20, g.score());
	}

	@Test
	public void testOneSpare() {
		setUp();
		rollSpare();
		g.roll(3);
		rollMany(17, 0);
		
		assertEquals(16, g.score());
	}

	@Test
	public void testOneStrike() {
		setUp();
		rollStrike();
		g.roll(3);
		g.roll(4);
		rollMany(16, 0);
		
		assertEquals(24, g.score());
	}

	@Test
	public void testPerfectGame() {
		setUp();
		rollMany(12, 10);
		
		assertEquals(300, g.score());
	}


	private void rollStrike() {
		g.roll(10);
	}

	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++)
			g.roll(pins);
	}

	private void rollSpare() {
		g.roll(5);
		g.roll(5);
	}
}
