package cooperation2;

public class SuperMarket {
	String marketName;
	int customer;
	int money;
	
	public SuperMarket(String marketName) {
		this.marketName = marketName;
	}
	
	public void take(int money) {
		this.money += money;
		customer ++;
	}
	
	public void showInfo() {
		System.out.println(marketName + "의 오늘 방문객은 " + customer + "명이고, 수입은 " + money + "원입니다.");
	}
}
