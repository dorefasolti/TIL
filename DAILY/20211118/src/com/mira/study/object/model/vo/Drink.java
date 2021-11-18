package com.mira.study.object.model.vo;

import java.io.Serializable;
					//인터페이스이기 때문에 implements 해주기
public class Drink implements Serializable{//직렬화를 하겠다고 옵션 부여하기
	
	//필드부
	//브랜드
	//메뉴이름
	//가격
	
	private String brand;
	private String menu;
	private int price;
	
	public Drink() {
		super();
	}
	public Drink(String brand, String menu, int price) {
		super();
		this.brand = brand;
		this.menu = menu;
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Drink [brand=" + brand + ", menu=" + menu + ", price=" + price + "]";
	}
	
	
}
