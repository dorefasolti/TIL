package cooperation2;

public class Person {
	public String personName;
	public int age;
	public int money;
	
	public Person(String personName, int money) {
		this.personName = personName;
		this.money = money;
	}
	
	public void takeSuperMarket(SuperMarket supermarket) {
		supermarket.take(10000);
		this.money -= 10000;
		
	}
	
	public void takeCafe(Cafe cafe) {
		cafe.take(4500);
		this.money -= 4000;
	}
	
	public void showInfo() {
		System.out.println(personName + "님의 남은 돈은" + money + "원입니다.");
	}
}
