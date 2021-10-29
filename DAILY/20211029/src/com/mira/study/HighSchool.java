package com.mira.study;

public class HighSchool {
	private String name;
	private String grade;
	private int studentNo;
	private boolean study;
	
	
	public HighSchool() {
	}
	
	public HighSchool(String name, String grade, int studentNo, boolean study) {

		this.name = name;
		this.grade = grade;
		this.studentNo = studentNo;
		this.study = study;
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
	public boolean isStudy() {
		return study;
	}
	public void setStudy(boolean study) {
		this.study = study;
	}
	
	
	
	public String information() {
		return name + grade + studentNo + study;
	}
	
	
}
