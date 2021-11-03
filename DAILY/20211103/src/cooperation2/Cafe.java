package cooperation2;

public class Cafe {
	public String cafeName;
	public int customer;
	public int money;
	
	public Cafe(String cafeName) {
		this.cafeName = cafeName;
	}
	
	public void take(int money) {
		this.money += money;
		customer++;
	}
	
	public void showInfo() {
		System.out.println(cafeName + "카페의 오늘 방문객은 " + customer + "명이고, 수입은 " + money + "원입니다.");
	}
}
