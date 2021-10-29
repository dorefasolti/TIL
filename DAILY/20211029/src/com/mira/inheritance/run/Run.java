package com.mira.inheritance.run;

import com.mira.inheritance.HighSchool;
import com.mira.inheritance.MiddleSchool;
import com.mira.inheritance.SchoolChild;
import com.mira.inheritance.Student;

public class Run {
	public static void main(String[] args) {
		
		
		Student s = new Student(); // 기본생성자에 있는 "부모" 매시지 출력됨
		
		System.out.println();
		
		SchoolChild ch = new SchoolChild(); 
		//부모 (줄바꿈) 자식1 초등학생 출력됨
		//부모의 기본 생성자가 자식의 기본 생성자 안에 호출된다
		//student의 기본생성자가 먼저 호출되고 schoolchild의 기본 생성자가 호출된다
		//자식은 부모가 생긴 이후에 생기는것, 부모 먼저 생기고 -> 자식이 생긴다
 		
		SchoolChild child = new SchoolChild("초등학생", "1학년", 1, true); //초기화까지
		System.out.println(child.information());
		//초등학생1학년1true
		
		
		
		MiddleSchool middle = new MiddleSchool("중학생", "2학년", 2, true);
		System.out.println(middle.information());
		//중학생2학년2
		//middleschool 클래스에서 인포메이션을 만들지 않았는데 결과값이 출력된다
		//why? 내가 실행하고자 하는 메소드가 해당 클래스에 존재하지 않는다면,
		//자동으로 상속관계에 있는 부모클래스의 메소드를 호출한다
		
		
		HighSchool high = new HighSchool("고등학생", "3학년", 3, true);
		System.out.println(high.information());
		//고등학생3학년3true
		
		//오버라이딩 : 부모클래스의 메소드를 자식클래스에서 재정의
		//=> 자식클래스에서 오버라이딩을 했을 경우, 자식클래스의 오버라이딩 된 메소드가 우선권을 가지고 호출된다
	}
}
