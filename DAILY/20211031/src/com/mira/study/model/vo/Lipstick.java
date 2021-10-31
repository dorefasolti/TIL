package com.mira.study.model.vo;

public class Lipstick extends Cosmetic{
	private int lip;

	public Lipstick() {
		super();
	}

	public Lipstick(String name, String brand, int price, int lip) {
		super(name, brand, price);
		this.lip = lip;
	}

	public int isLip() {
		return lip;
	}

	public void setLip(int lip) {
		this.lip = lip;
	}
	
	@Override
	public String toString() {
		return super.toString() + lip;
	}
}
