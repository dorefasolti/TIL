package com.mira.study.model.vo;

public class Shadow extends Cosmetic{
	public static final String COLOR = "brown";
	private int eyes;
	
	
	public Shadow() {
		super();
	}
	public Shadow(String brand, String name, int price, int eyes) {
		super(brand, name, price);
		this.eyes = eyes;
	}
	public int isEyes() {
		return eyes;
	}
	public void setEyes(int eyes) {
		this.eyes = eyes;
	}
	public static String getColor() {
		return COLOR;
	}
	
	@Override
	public String toString() {
		return super.toString() + COLOR + eyes;
	}
	
}
