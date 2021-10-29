package com.mira.inheritance;

public class HighSchool extends Student{

	private boolean study;

	public HighSchool() {
		System.out.println("자식3 고등학생");
	}

	public HighSchool(String name, String grade, int studentNumber, boolean study) {
		super(name, grade, studentNumber);
		this.study = study;
	}

	public boolean isStudy() {
		return study;
	}

	public void setStudy(boolean study) {
		this.study = study;
	}
	
	
	public String information() {
		return super.information() + study;
	}
	
}
