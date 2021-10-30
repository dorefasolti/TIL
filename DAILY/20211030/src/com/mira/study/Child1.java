package com.mira.study;

public class Child1 extends Parent{
	private int z;

	
	
	
	public Child1() {
	}

	public Child1(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public void printChild1() {
		System.out.println("나는첫번째자식");
	}
	
	@Override
	public void print() {
		System.out.println("첫번재 자식");
	}
	
	
	
}

	