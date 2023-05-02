
public class Coffee extends Beverage {
	
	public boolean extraShot;
	public boolean extraSyrup;
	
	public Coffee(String bevName, Size size,
			boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
		this.price = calcPrice();
	}
	
	public boolean getExtraShot() {
		return extraShot;
	}
	
	public boolean getExtraSyrup() {
		return extraSyrup;
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
		if (this.getExtraShot() == true) {
			price += 0.5;
		}
		if (this.getExtraSyrup() == true) {
			price += 0.5;
		}
		return price;
	}
	
	public String toString() {
		String s = this.bevName + "," + this.size+ "," +
			this.extraShot + "," + this.extraSyrup + "," +
			this.price;
		return s;
	}
	
	public boolean equals(Beverage anotherBev) {
		boolean result = false;
		if ((this.getBevName() == anotherBev.getBevName())
			&& (this.getSize() == anotherBev.getSize())
			&& (this.getType() == anotherBev.getType())
			&& (this.getExtraShot() == ((Coffee)anotherBev).getExtraShot())
			&& (this.getExtraSyrup() == ((Coffee)anotherBev).getExtraSyrup())
			&& (this.price == anotherBev.price)) {
			result = true;
		}
		return result;
	}

}
