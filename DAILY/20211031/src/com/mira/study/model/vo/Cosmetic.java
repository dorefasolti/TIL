package com.mira.study.model.vo;

//부모
public class Cosmetic {
	private String brand;
	private String name;
	private int price;
	
	
	
	
	
	
	public Cosmetic() {
	}


	public Cosmetic(String brand, String name, int price) {
		this.brand = brand;
		this.name = name;
		this.price = price;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public String toString() {
		return brand + name + price;
	}
	
	
	
	
}
