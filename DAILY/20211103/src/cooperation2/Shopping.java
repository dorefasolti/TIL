package cooperation2;

public class Shopping {

	public static void main(String[] args) {
		
		Person momo = new Person("모모", 50000);
		Person hoho = new Person("호호", 10000);
		
		SuperMarket sMarket = new SuperMarket("sMarket");
		momo.takeSuperMarket(sMarket);
		
		Cafe cCafe = new Cafe("cCafe");
		hoho.takeCafe(cCafe);
		
		momo.showInfo();
		sMarket.showInfo();
		hoho.showInfo();
		cCafe.showInfo();
		
	}
}
