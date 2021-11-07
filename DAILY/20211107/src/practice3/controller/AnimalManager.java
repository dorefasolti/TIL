package practice3.controller;

import practice3.model.vo.Animal;
import practice3.model.vo.Cat;
import practice3.model.vo.Dog;

public class AnimalManager {
	public static void main(String[] args) {
		
		Animal[] ani = new Animal[5];

		
		ani[0] = new Dog("하니", "말티즈", 3);
		ani[1] = new Cat("뚱", "코숏", "한국", "고등어");
		ani[2] = new Dog("쪼롱이", "말티즈", 2);
		ani[3] = new Cat("다롱", "친칠라", "한국", "하얀색");
		ani[4] = new Dog("강", "말티즈", 3);
		
		for(int i = 0; i < ani.length; i++) {
			ani[i].speak();
		}
	}

}
