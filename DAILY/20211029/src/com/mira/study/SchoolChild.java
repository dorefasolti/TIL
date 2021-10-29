package com.mira.study;

public class SchoolChild {
	private String name;
	private String grade;
	private int studentNo;
	private boolean play;

	
	
	public SchoolChild() {
	}
	
	
	public SchoolChild(String name, String grade, int studentNo, boolean play) {
		this.name = name;
		this.grade = grade;
		this.studentNo = studentNo;
		this.play = play;
	}


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


	public int getStudentNo() {
		return studentNo;
	}


	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}


	public boolean isPlay() {
		return play;
	}


	public void setPlay(boolean play) {
		this.play = play;
	}
	

	public String information() {
		return name + grade + studentNo + play;
	}
}
