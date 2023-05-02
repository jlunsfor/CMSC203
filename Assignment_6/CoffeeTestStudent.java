import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CoffeeTestStudent {
	Coffee c1, c2, c3;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new Coffee("Joanna", Size.MEDIUM, true, false);
		c2 = new Coffee("Michael", Size.SMALL, true, false);
		c3 = new Coffee("Jayme", Size.LARGE, false, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		c1 = c2 = c3 = null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(3.5, c1.price, 0.01);
		assertEquals(2.5, c2.price, 0.01);
		assertEquals(4.5, c3.price);
	}
	
	@Test
	void testEquals() {
		assertTrue(c1.equals(c1));
		assertTrue(!(c2.equals(c3)));
	}
	
	@Test
	void testGetExtraShot() {
		assertTrue(c1.getExtraShot());
		assertTrue(!(c3.getExtraShot()));
	}

}
