package javada.com.java;

public class Monster {
	public int id;
	public Monster(int id) {
		this.id = id;
	}
	public void hit(int i) 
	{

		System.out.printf("Monster %d hit!\n", i);
	}
}

class Goblin extends Monster {

	public Goblin(int id) {
		super(id);
	}
	
	@Override
	public void hit(int i) {

		System.out.printf("Goblin %d hit by %d!\n", id, i);		
	}
	
	public void goblin_attack()
	{

		System.out.println("Goblin attack!");				
	}
}

class Ork extends Monster {

	public Ork(int id) {
		super(id);
	}
	@Override
	public void hit(int i) {


		System.out.printf("Ork %d hit by %d!\n", id, i);
	}	
}

/*
public void f()
{
	Monster m0 = new Monster();
	Monster m1 = new Goblin();
	Monster m2 = new Ork();
	
	Goblin g1 = new Goblin();
	g1.goblin_attack();
	
	m1.hit();
	
	Goblin g2 = (Goblin)m1;
}
*/