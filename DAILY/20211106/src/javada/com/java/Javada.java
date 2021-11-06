package javada.com.java;

public class Javada {
	public static void main(String[] args) {
		Goblin g1 = new Goblin(1);
		Goblin g2 = new Goblin(2);
		Goblin g3 = new Goblin(3);
		Goblin g4 = new Goblin(4);
		
		Ork o1 = new Ork(1);
		Ork o2 = new Ork(2);
		Ork o3 = new Ork(3);
		Ork o4 = new Ork(4);

		
		Monster[] ms = new Monster[] {
				g1, g2, g3, g4,
				o1, o2, o3, o4
		};
		
		for (int i = 0; i < ms.length; ++i) {
			ms[i].hit(40);
		}

	}
}
