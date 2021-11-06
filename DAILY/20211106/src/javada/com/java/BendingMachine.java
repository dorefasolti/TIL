package javada.com.java;

public class BendingMachine {
	public Beverage beverage;
	
	public BendingMachine(String name, int price) {
		this.beverage = new Beverage(name, price);
	}
	
	public Beverage pushButton()
	{
		return getBeverage();
	}
	
	public Beverage getBeverage()
	{
		return beverage;
	}
}
