package com.mira.study.run;

import com.mira.study.HighSchool;
import com.mira.study.MiddleSchool;
import com.mira.study.SchoolChild;

public class Run {
	public static void main(String[] args) {

		
//		SchoolChild 객체를 생성
//		name, grade, schoolNo, play
		SchoolChild child = new SchoolChild("초등학생", "1학년", 1, true);
		
//		MiddleSchool 객체를 생성
//		name, grade, schoolNo, schoolUniform
		MiddleSchool middle = new MiddleSchool("중학생", "2학년", 2, true);
		
//		HighSchool 객체를 생성
//		name, grade, schoolNo, study
		HighSchool high = new HighSchool("고등학생", "3학년", 3, true);
				
		
		
		System.out.println(child.information());
		System.out.println(middle.information());
		System.out.println(high.information());
		
		
		
		//클래스들의 필드부, 메소드부(getter/setter)를 확인해보면 매 클래스마다 중복된 코드들이 있다
		//이렇게 중복된 코드를 작성할 경우, 수정 등 유지보수 할 일이 생겼을 때 매번 하나하나 수정해야한다
		
		//상속
		//=> 매 클래스마다 중복된 필드, 메소드들을 부모클래스로 만들어두고
		//	해당 클래스에서 속성, 행위를 가져다 쓰는 방븝
		
		//=> 코드가 깔끔해지고 생산성이 증가, 유지보수가 용이
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
