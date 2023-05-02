
/**
 * A representation of a beverage object.
 * 
 * @author Jeremy Lunsford
 * @version 2023.04.26
 *
 */

public abstract class Beverage {
	
	public String bevName;
	public Type type;
	public Size size;
	public double basePrice = 2.0;
	public double price = 0.0;
	
	Beverage(String bevName, Type type, Size size) {
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	public double addSizePrice() {
		this.basePrice += 1.0;
		return basePrice;
	}
	
	public abstract double calcPrice();
	
	public boolean equals(Beverage anotherBev) {
		boolean result = false;
		if ((this.bevName.equals(anotherBev.bevName))
			&& (this.size.equals(anotherBev.size))
			&& (this.type.equals(anotherBev.type))) {
				result = true;
			}
		return result;
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	
	public String getBevName() {
		return this.bevName;
	}
	
	public Size getSize() {
		return this.size;
	}
	
	public Type getType() {
		return this.type;
	}
	
	public String toString() {
		String s = this.bevName + "," + this.size;
		return s;
	}

}
