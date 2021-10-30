package com.mira.study;

public class Parent {
	private int x;
	private int y;
	
	
	
	public Parent() {

	}
	public Parent(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	
	
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void printParent() {
		System.out.println("나는부모");
	}
	public void print() {
		System.out.println("부모");
	}
	
	
}
