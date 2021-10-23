package com.mira.study.run;

import com.mira.study.PracticeSubmit;

public class Run {
	public static void main(String[] args) {
		PracticeSubmit iceCream = new PracticeSubmit();
		
		iceCream.flavor = "초콜릿";
		iceCream.size = 1;
		iceCream.price = 6500;
		
		System.out.println(iceCream.flavor + "맛 " + iceCream.size + "사이즈의 가격은 " + iceCream.price + "입니다.");
	
	
		iceCream.sizeUp();
		System.out.println(iceCream.size);
		
		iceCream.discount(500);
		System.out.println(iceCream.price);
		
		
	
	}
	
	
	
}
