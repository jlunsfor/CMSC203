
public class Smoothie extends Beverage {
	
	public int numOfFruits;
	public boolean addProtein;
	public final double PROTEIN_CHARGE = 1.5;
	public final double FRUIT_CHARGE = 0.5;
	
	public Smoothie(String bevName, Size size,
			int numOfFruits, boolean addProtein) {
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
		this.price = calcPrice();
	}
	
	public int getNumOfFruits() {
		return numOfFruits;
	}
	
	public boolean getAddProtein() {
		return addProtein;
	}
	
	public double addProteinPrice() {
		this.price += PROTEIN_CHARGE;
		return this.price;
	}
	
	public double addFruitPrice() {
		this.price += FRUIT_CHARGE;
		return this.price;
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
		if (this.getAddProtein() == true) {
			price = addProteinPrice();
		}
		for (int i = 0; i < numOfFruits; i++) {
			this.addFruitPrice();
		}
		return price;
	}
	
	public String toString() {
		String s = this.bevName + "," + this.size + "," +
			this.addProtein + "," + this.numOfFruits + "," +
			this.price;
		return s;
	}
	
	public boolean equals(Beverage anotherBev) {
		boolean result = false;
		if ((this.getBevName() == anotherBev.getBevName())
			&& (this.getSize() == anotherBev.getSize())
			&& (this.getType() == anotherBev.getType())
			&& (this.getAddProtein() == ((Smoothie)anotherBev).getAddProtein())
			&& (this.getNumOfFruits() == ((Smoothie)anotherBev).getNumOfFruits())
			&& (this.calcPrice() == anotherBev.calcPrice())) {
			result = true;
		}
		return result;
	}

}
