import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface {
	
	public int orderTime;
	public Day orderDay;
	public int orderNo;
	public Customer customer;
	public ArrayList<Beverage> bevs;
	
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		customer = new Customer(cust);
		this.orderNo = generateOrder();
		bevs = new ArrayList<Beverage>();
	}
	
	public int generateOrder() {
		Random rand = new Random();
		int orderNo = rand.nextInt(10000, 90000);
		return orderNo;
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	
	public int getOrderTime() {
		return orderTime;
	}
	
	public Day getOrderDay() {
		return orderDay;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public Day getDay() {
		return orderDay;
	}
	
	public boolean isWeekend() {
		boolean result = false;
		if (this.getOrderDay().equals(Day.valueOf("SATURDAY"))
				|| this.getOrderDay().equals(Day.valueOf("SUNDAY"))) {
			result = true;
		}
		return result;
	}
	
	public Beverage getBeverage(int itemNo) {
		Beverage bev = bevs.get(itemNo);
		return bev;
	}
	
	public int getTotalItems() {
		return bevs.size();
		
	}
	
	public void addNewBeverage(String bevName, Size size,
			boolean extraShot, boolean extraSyrup) {
		// Add a coffee beverage to the order
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		bevs.add(coffee);
	}
	
	public void addNewBeverage(String bevName, Size size) {
		// Adds an alcohol beverage to the order
		boolean weekendFlag = isWeekend();		
		Alcohol alcohol = new Alcohol(bevName, size, weekendFlag);
		bevs.add(alcohol);
	}
	
	public void addNewBeverage(String bevName, Size size,
			int nomOfFruits, boolean addProtein) {
		// Adds a smoothie beverage to the order
		Smoothie smoothie = new Smoothie(bevName, size, nomOfFruits, addProtein);
		bevs.add(smoothie);
	}
	
	public double calcOrderTotal() {
		double orderTotal = 0.0;
		//for (int i = 0; i < bevs.size(); i++) {
		for (Beverage item : this.bevs) {
			orderTotal += item.price;
		}
		return orderTotal;
	}
	
	public int findNumOfBeveType(Type type) {
		int numOfBev = 0;
		for (Beverage item : bevs) {
			if (item.type == type) {
				numOfBev++;
			}
		}
		return numOfBev;
	}
	
	public String toString() {
		String s = orderNo + "," + orderTime + "," + orderDay + ","
				+ customer.getName() + "," + customer.getAge() + "\n";
		for (Beverage item : bevs) {
			s += item.toString() + "\n"; 
		}
		return s;
	}
	
	public int compareTo(Order anotherOrder) {
		int result = 0;
		if (this.getOrderNo() < anotherOrder.getOrderNo()) {
			result = -1;
		}
		else if (this.getOrderNo() > anotherOrder.getOrderNo()) {
			result = 1;
		}
		return result;
	}

}
