package com.mira.study;

public class PracticeSubmit {
//	1번숙제!
//	나만의 클래스 3개를 만들고 클래스마다 객체를 2개 이상씩 생성할 것!
//	클래스 안의 멤버 변수는 최소 3개 이상일 것!
//	클래스 안의 메서드는 최소 2개 이상일 것!
//	메서드를 호출하여 객체의 상태를 변경할 것!!
	
	public String flavor;
	public int size;
	public int price;
	
		
	public void sizeUp() {
			System.out.println("사이즈업을 해드립니다");
			this.size += 1;

	}
	
	public void discount(int price) {
		System.out.println("가격을 할인해드립니다");
		this.price = (this.price - 500);
	}
	
}
