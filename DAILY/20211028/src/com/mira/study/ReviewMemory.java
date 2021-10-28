package com.mira.study;

public class ReviewMemory {
	
	private String title;
	private String publisher;
	private String author;
	private int price;
	private double discountRate;
	
	public ReviewMemory() {
	}
	
	public ReviewMemory(String title, String publisher, String author) {
		this.title = title;
		this.publisher = publisher;
		this.author = author;
	}
	
	public ReviewMemory(String title, String publisher, String author, int price, double discountRate) {
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.price = price;
		this.discountRate = discountRate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public double getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(double discountRate) {
		this.discountRate = discountRate;
	}
	
	
	public String information() {
		return title + " " + publisher + " " + author + " " + price + " " + discountRate;
	}
	
}
