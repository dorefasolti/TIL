package com.mira.today;
import com.mira.tomorrow.SecondStudy;
//import문 -> 해당 패키지에 있는 클래스를 가져다 쓸 것
//노란색 밑줄이 뜨는 이유 : import문이나 변수선언 등을 적어놨지만 아직 사용되지 않았음을 알림

public class FirstStudy {
	public static void main(String[] args) {
//다른 클래스에 있는 메소드를 호출하는 방법
//클래스이름 클래스를 대변할 이름(별명) = new 클래스이름();
//클래스 이름 뒤에 ()가 있어야 메소드임 빼먹지 않기
		
//		methodA();
//		이렇게 메소드 이름만 적으면 왜 오류가 날까?
//		-> SecondStudy 클래스로부터 import 했지만 아직 객체 생성X 오류남

		SecondStudy ss = new SecondStudy();
		//SecondStudy 클래스 안에 있는 methodA(메소드)를 데리고 올 것
		//SecondStudy를 줄여서 ss라고 부를 것
		//new라는 생성자로 SecondStudy라는 메소드를 만들 것
		
		
	
	}
}
