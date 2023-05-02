import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AlcoholTestStudent {
	Alcohol a1, a2, a3;

	@BeforeEach
	void setUp() throws Exception {
		a1 = new Alcohol("Jeremy", Size.MEDIUM, true);
		a2 = new Alcohol("Beverly", Size.LARGE, false);
		a3 = new Alcohol("Jayme", Size.SMALL, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		a1 = a2 = a3 = null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(3.6, a1.price, 0.01);
		assertEquals(4.0, a2.price, 0.01);
	}
	
	@Test
	void testEquals() {
		assertTrue(a1.equals(a1));
		assertTrue(!(a1.equals(a2)));
	}
	
}
