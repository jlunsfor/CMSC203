
public class BevShopDriverApp {
	public static void main(String[] args) {
		// Create the shop
		System.out.println("Let's play with the drink shop.");
		BevShop bevShop = new BevShop();
		
		// Check the hours
		System.out.println("So I've made a drink shop and the hours are " +
				"from 8-23. Let's see if I can place an order at noon and 3.");
		int timeGood = 12;
		int timeBad = 3;
		System.out.println("Order at noon: " + bevShop.isValidTime(timeGood));
		System.out.println("Order at 3am: " + bevShop.isValidTime(timeBad));
		System.out.println("I'll come by at noon on Tuesday, then.");
		Day date = Day.TUESDAY;
		
		// Start making orders
		System.out.println("Now let's place an order for some coffee.");
		String myName = "Jeremy";
		int myAge = 35;
		bevShop.startNewOrder(timeGood, date, myName, 35);
		Order currentOrder = bevShop.getCurrentOrder();
		System.out.println("My order number is " + currentOrder);
		System.out.println("Let's get two coffees: one for me and another for Michele.");
		bevShop.processCoffeeOrder(myName, Size.SMALL, false, true);
		bevShop.processCoffeeOrder("Michele", Size.LARGE, true, false);
		System.out.println(currentOrder.toString());
		System.out.println("And the total of that is: " + currentOrder.calcOrderTotal() + ".\n\n");
		
		// Separate items
		for (int i = 0; i < 10; i++) {
			System.out.print("--");
		}
		System.out.println();
		
		// Start a new order
		timeGood = 13;
		System.out.println("Another hour another customer. "
				+ "Lunch rush started at " + timeGood);
		bevShop.startNewOrder(timeGood, date, "Anthony", 20);
		bevShop.processSmoothieOrder("Anthony", Size.MEDIUM, 3, false);
		Order orderAnthony = bevShop.getCurrentOrder();
		System.out.print(orderAnthony.toString());
		System.out.println("And the total of that is: " + orderAnthony.calcOrderTotal() + ".\n\n");

		bevShop.startNewOrder(timeGood, date, "Eva", 45);
		bevShop.processCoffeeOrder("Eva", Size.SMALL, true, false);
		Order orderEva= bevShop.getCurrentOrder();
		System.out.print(orderEva.toString());
		System.out.println("And the total of that is: " + orderEva.calcOrderTotal() + ".\n\n");
		
		// Separate items
		for (int i = 0; i < 10; i++) {
			System.out.print("--");
		}
		System.out.println();
		
		// Happy hour order
		timeGood = 18;
		System.out.println("Happy hour started at " + timeGood);
		bevShop.startNewOrder(timeGood, date, "Michele", 23);
		bevShop.processAlcoholOrder("Michele", Size.LARGE);
		Order orderMichele = bevShop.getCurrentOrder();
		System.out.print(orderMichele.toString());
		System.out.println("And the total of that is: " + orderMichele.calcOrderTotal() + ".\n\n");
		
		// Separate items
		for (int i = 0; i < 10; i++) {
			System.out.print("--");
		}
		System.out.println();
		
		// Get the day's totals
		System.out.println("This might be a lighter day, but it proves it.");
		System.out.println("There were a total of " + bevShop.totalNumOfMonthlyOrders() +
				" orders today.");
		System.out.println("For a total revenue of " + bevShop.totalMonthlySale() + 
				".");
		
		// Separate items
		for (int i = 0; i < 10; i++) {
			System.out.print("--");
		}
		System.out.println();
	}

}
