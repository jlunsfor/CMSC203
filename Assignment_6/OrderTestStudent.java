import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderTestStudent {
	Order o1, o2, o3;

	@BeforeEach
	void setUp() throws Exception {
		o1 = new Order(8, Day.MONDAY, new Customer("Margaret", 60));
		o2 = new Order(12, Day.SATURDAY, new Customer("David", 75));
		o3 = new Order(10, Day.SUNDAY, new Customer("Linda", 20));
	}

	@AfterEach
	void tearDown() throws Exception {
		o1 = o2 = o3 = null;
	}

	@Test
	void testAddNewBeverage() {
		Coffee cf = new Coffee("regular Coffee", Size.SMALL, false, false);
		Alcohol al = new Alcohol("Mohito", Size.SMALL, false);
		Smoothie sm1 = new Smoothie("Detox", Size.MEDIUM, 1, false);
		Smoothie sm2 = new Smoothie("Detox", Size.LARGE, 1, false);
		o1.addNewBeverage("Mohito", Size.SMALL);
		o2.addNewBeverage("Black coffee", Size.MEDIUM, false, false);
		o3.addNewBeverage("Green monster", Size.LARGE, 1, false);
	}

}
