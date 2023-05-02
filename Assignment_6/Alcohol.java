
public class Alcohol extends Beverage {
	
	public boolean isWeekend;
	public final double WEEKEND_CHARGE = 0.6;
	public boolean weatherFlag;
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
		this.price = calcPrice();
	}
	
	public double calcPrice() {
		price = this.getBasePrice();
		if (this.getSize() == Size.MEDIUM) {
			price = this.addSizePrice();
		}
		if (this.getSize() == Size.LARGE) {
			price = this.addSizePrice();
			price = this.addSizePrice();
		}
		if (this.isWeekend() == true) {
			price += WEEKEND_CHARGE;
		}
		return price;
	}
	
	public String toString() {
		String s = this.bevName + "," + this.size + "," 
			+ this.isWeekend + "," + this.price;
		return s;
	}
	
	public boolean equals(Beverage anotherBev) {
		boolean result = false;
		if ((this.getBevName() == anotherBev.getBevName())
			&& (this.getSize() == anotherBev.getSize())
			&& (this.getType() == anotherBev.getType())
			&& (this.isWeekend() == ((Alcohol)anotherBev).isWeekend())
			&& (this.price == ((Alcohol)anotherBev).price)) {
			result = true;
		}
		return result;
	}
	
	public boolean isWeekend() {
		return isWeekend;
	}

}
