package com.mira.practice.student.view;

import com.mira.practice.student.controller.StudentController;
import com.mira.practice.student.model.vo.Student;

public class StudentMenu {
	private StudentController ssm = new StudentController();
//	sArr[0] = new Student("김길동", "자바", 100);
//	sArr[1] = new Student("박길동", "디비", 50);
//	sArr[2] = new Student("이길동", "화면", 85);
//	sArr[3] = new Student("정길동", "서버", 60);
//	sArr[4] = new Student("홍길동", "자바", 20);
	
//	this.name = name;
//	this.subject = subject;
//	this.score = score;
	
	
	
	public StudentMenu() {
		Student[] sArr = ssm.printStudent();
		System.out.println(" ========== 학생 정보 출력 ========== ");
		for(int i = 0; i < sArr.length; i++) {
			System.out.println("이름 : " + sArr[i].getName() + " / 과목 : " + sArr[i].getSubject() + " / 점수 : " + sArr[i].getScore());
		}
		

		
		
		System.out.println(" ========== 학생 성적 출력 ========== ");
		
		double[] dArr = ssm.avgScore();
		System.out.println("점수 합계 : " + (int)ssm.avgScore()[0]);
		System.out.println("평균 : " + ssm.avgScore()[1]);
		
		
		System.out.println(" ========== 성적 결과 출력 ========== ");
		for(int i = 0; i < sArr.length; i++) {
//			System.out.println(sArr[i]);
			if(sArr[i].getScore() >= ssm.CUT_LINE) {
				System.out.println(sArr[i].getName() + "학생은 통과입니다.");
			}else {
				System.out.println(sArr[i].getName() + "학생은 재시험 대상입니다.");
			}
		}
		
	}
	
	
}
