import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SmoothieTestStudent {
	Smoothie s1, s2, s3;

	@BeforeEach
	void setUp() throws Exception {
		s1 = new Smoothie("Zach", Size.SMALL, 3, true);
		s2 = new Smoothie("Darling", Size.SMALL, 2, false);
		s3 = new Smoothie("Jonah", Size.LARGE, 3, true);
	}

	@AfterEach
	void tearDown() throws Exception {
		s1 = s2 = s3 = null;
	}

	@Test
	void testCalcPrice() {
		assertEquals(5.0, s1.price);
		assertEquals(3.0, s2.price);
		assertEquals(7.0, s3.price);
	}
	
	@Test
	void testEquals() {
		assertTrue(s2.equals(s2));
		assertTrue(!(s2.equals(s3)));
	}
	
	@Test
	void testGetAddProtein() {
		assertTrue(s1.getAddProtein());
		assertTrue(!(s2.getAddProtein()));
	}
	
	@Test
	void testGetNumOfFruits() {
		assertEquals(2, s2.getNumOfFruits());
		assertEquals(3, s3.getNumOfFruits());
	}

}
