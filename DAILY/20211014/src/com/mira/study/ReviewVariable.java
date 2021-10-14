package com.mira.study;

public class ReviewVariable {

	public void declareVariable( ){
		
		//논리형 자료형(논리값 true, false)
		boolean isTrue;
		isTrue = true;
		Boolean isFalse = false;
		
		//숫자형 자료형
		//정수형
		byte bNum = 1;
		short sNum = 2;
		int iNum = 3;
		long lNum = 4L; // L붙여주기
		//실수형
		float fNum = 2.22f; // f붙여주기
		double dNum = 3.33;
		//문자형
		char ch;
		ch = 'a'; //단일문자. 작은 따옴표로 감싸기
		String str = "abc"; //단일문자 두 개 이상, 문자열은 큰 따옴표
				
		//출력문
		//1. System.out.println(); li = line의 약자, 줄바꿈해줌(개행)
		//2. System.out.print(); 줄바꿈 하지 않음
		//3. System.out.printf(); f = format. 줄바꿈X 
		//						  %d와 같은 서식지정자의 수와 변수의 순서와 수, 종류가 같아야 한다 
		
		//논리형
		//boolean(true/false) %b
		System.out.printf("%b, %b\n", null);
		//정수형 %d
		System.out.printf("%d, %d, %d, %d\n", bNum, sNum, iNum, lNum);
		
		//실수형 %f
		//%1.f 소수점 아래 2번째에서 반올림되어 1번째까지만 출력(자릿수 지정)
		System.out.printf("%f, %f\n", fNum, dNum);
		
		//문자형 %c소문자 단일문자, %C대문자 단일문자, %s소문자 문자열, %S대문자 문자열
		System.out.printf("소문자 %c, 대문자 %c, 소문자 %s, 대문자 %S\n", ch, ch, str, str);
	
		
		//상수
		//final 자료형 상수이름;
		//전부 대문자로 표기할 것, 이어지는 단어는 _ 로 연결
		
		final int AUTUMN_DREAM;
		AUTUMN_DREAM = 20211014;
		System.out.println("AUTUMN_DREAM");
		
		
	
	}
}
