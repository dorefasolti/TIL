package com.mira.inheritance;

//상속
//매 클래스마다 중복된 필드와 메소드들을 단 하나의 클래스로 정의한 후 해당 클래스의 내용을 가져다 쓰는 것

//기존의 클래스(부모)를 이용해 새 클래스(자녀)를 만든다
//but 복제의 개념이 아니라 진화의 개념으로 생각해야한다
//똑같이 만들거면 새로 만들 이유가 X 계속 쓰면 되니까
//무언가 추가해서 진화시켜야한다
public class Student {
	//필드
	private String name;
	private String grade;
	private int studentNumber;
	
	//생성자
	
	public Student() {
		System.out.println("부모");
	}

	public Student(String name, String grade, int studentNumber) {
		this.name = name;
		this.grade = grade;
		this.studentNumber = studentNumber;
	}

	
	//메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	

	

	public String information() {
		return name + grade + studentNumber;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
