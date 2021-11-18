package com.mira.list.mvc.model.vo;

public class Book {
	
	private String name; //책 이름
	private String author;
	private String Location; //보관장소
	private String callNumber; //청구기호
	
	
	public Book() {
		super();
	}


	public Book(String name, String author, String location, String callNumber) {
		super();
		this.name = name;
		this.author = author;
		Location = location;
		this.callNumber = callNumber;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getLocation() {
		return Location;
	}


	public void setLocation(String location) {
		Location = location;
	}


	public String getCallNumber() {
		return callNumber;
	}


	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}


	@Override
	public String toString() {
		return "\n Book [제목 : " + name + ", 저자 : " + author + ", 보관장소 : " + Location + ", 청구기호 : " + callNumber
				+ "]\n";
	}

	
	
}
