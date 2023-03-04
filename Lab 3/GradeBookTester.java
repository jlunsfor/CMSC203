import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTester {
	
	private GradeBook g1 = new GradeBook(5);
	private GradeBook g2 = new GradeBook(5);
	
	@BeforeEach
	public void setUp() throws Exception {
		g1.addScore(5.3);
		g1.addScore(97.5);
		g1.addScore(31.0);
		g1.addScore(78.1);
		g1.addScore(51.8);
		g2.addScore(45.6);
		g2.addScore(37.8);
		g2.addScore(1.0);
		g2.addScore(99.5);
		g2.addScore(50.5);
	}

	@AfterEach
	public void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		assertTrue(g1.toString().equals("5.3 97.5 31.0 78.1 51.8 "));
		assertTrue(g2.toString().equals("45.6 37.8 1.0 99.5 50.5 "));
		assertEquals(5, g1.getScoreSize());
		assertEquals(5, g2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(263.7, g1.sum());
		assertEquals(234.4, g2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(5.3, g1.minimum());
		assertEquals(1.0, g2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(258.4, g1.finalScore());
		assertEquals(233.4, g2.finalScore());
	}

}
