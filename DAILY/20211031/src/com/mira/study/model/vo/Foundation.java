package com.mira.study.model.vo;

public class Foundation extends Cosmetic{
	
	private int skin;

	
	
	
	public Foundation() {
		super();
	}


	public Foundation(String brand, String name, int price, int skin) {
		super(brand, name, price);
		this.skin = skin;
	}


	public int isSkin() {
		return skin;
	}


	public void setSkin(int skin) {
		this.skin = skin;
	}
	

	
	@Override
	public String toString() {
		return super.toString() + skin;
	}
}
