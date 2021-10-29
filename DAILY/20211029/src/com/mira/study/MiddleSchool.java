package com.mira.study;

public class MiddleSchool {
	private String name;
	private String grade;
	private int studentNo;
	private boolean schoolUniform;
	
	
	
	
	public MiddleSchool() {
	}


	
	
	public MiddleSchool(String name, String grade, int studentNo, boolean schoolUniform) {

		this.name = name;
		this.grade = grade;
		this.studentNo = studentNo;
		this.schoolUniform = schoolUniform;
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




	public boolean isSchoolUniform() {
		return schoolUniform;
	}




	public void setSchoolUniform(boolean schoolUniform) {
		this.schoolUniform = schoolUniform;
	}




	public String information() {
		return name + grade + studentNo + schoolUniform;
	}
	
	

}
