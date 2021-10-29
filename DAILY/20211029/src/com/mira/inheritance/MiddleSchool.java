package com.mira.inheritance;

public class MiddleSchool extends Student {
	
	private boolean schoolUniform;

	
	
	
	public MiddleSchool() {
		System.out.println("자식2 중학생");
	}
	
	public MiddleSchool(String name, String grade, int studentNumber, boolean schoolUniform) {
		super(name, grade, studentNumber);
		this.schoolUniform = schoolUniform;
	}


	public boolean isSchoolUniform() {
		return schoolUniform;
	}

	public void setSchoolUniform(boolean schoolUniform) {
		this.schoolUniform = schoolUniform;
	}
	
	
	//information 오버라이딩 일부러 안했음
}
