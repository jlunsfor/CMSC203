import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	
	public ArrayList<Order> orders = new ArrayList<Order>();
	
	public BevShop() {
		super();
	}
	
	public boolean isValidTime(int time) {
		boolean result = false;
		if ((time >= 8) && (time <= 23)) {
			result = true;
		}
		return result;
	}
	
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	public boolean isMaxFruit(int numOfFruit) {
		boolean result = false;
		if (numOfFruit > getMaxNumOfFruits()) {
			result = true;
		}
		return result;
	}
	
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	public boolean isEligibleForMore() {
		boolean result = false;
		if (this.getNumOfAlcoholDrink() < getMaxOrderForAlcohol()) {
			result = true;
		}
		return result;
	}
	
	public int getNumOfAlcoholDrink() {
		Order o = getCurrentOrder();
		int numOfAlcoholDrink =  o.findNumOfBeveType(Type.ALCOHOL);
		return numOfAlcoholDrink;
	}
	
	public boolean isValidAge(int age) {
		boolean result = false;
		if (age >= getMinAgeForAlcohol()) {
			result = true;
		}
		return result;
	}
	
	public void startNewOrder(int time, Day day,
			String customerName, int customerAge) {
		Customer c = new Customer(customerName, customerAge);
		Order o = new Order(time, day, c);
		orders.add(o);
	}
	
	public void processCoffeeOrder(String bevName, Size size,
			boolean extraShot, boolean extraSyrup) {
		Order o = getCurrentOrder();
		o.addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	public void processAlcoholOrder(String bevName, Size size) {
		Order o = getCurrentOrder();
		o.addNewBeverage(bevName, size);
	}
	
	public void processSmoothieOrder(String bevName, Size size, 
			int numOfFruits, boolean addProtein) {
		Order o = getCurrentOrder();
		o.addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	
	public int findOrder(int orderNo) {
		int index = -1;
		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).orderNo == orderNo) {
				index = i;
			}
		}
		return index;
	}
	
	public double totalOrderPrice(int orderNo) {
		int orderIndex = findOrder(orderNo);
		Order order = orders.get(orderIndex);
		double total = order.calcOrderTotal();
		return total;
	}
	
	public double totalMonthlySale() {
		double total = 0.0;
		for (Order order : orders) {
			int i = order.getOrderNo();
			total += totalOrderPrice(i);
		}
		return total;
	}
	
	public int totalNumOfMonthlyOrders() {
		int total = orders.size();
		return total;
	}
	
	public Order getCurrentOrder() {
		// Order o = orders.get(0);
		int i = orders.size() - 1;
		Order o = orders.get(i);
		return o;
	}
	
	public Order getOrderAtIndex(int index) {
		Order o = orders.get(index);
		return o;
	}
	
	public void sortOrders() {
		for (int i = 0; i < orders.size(); i++) {
			int minIndex = i;
			for (int j = i; j < orders.size(); j++) {
				if (orders.get(j).calcOrderTotal() < orders.get(minIndex).calcOrderTotal()) {
					minIndex = j;
				}
			}
			Order temp = orders.get(minIndex);
			orders.set(minIndex, orders.get(i));
			orders.set(i, temp);
		}
	}
	
	public String toString() {
		String s = "";
		// iterate through each order
		for (Order o : orders) {
			s += o.toString();
		}
		s += totalMonthlySale();
		return s;
	}

}
