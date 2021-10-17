package com.mira.study;

public class ReviewVariable {
	
	public void variable() {
		//변수 선언하기
		int mira; //변수 선언
		mira = 184; //변수에 값을 대입
		System.out.println("미라의 키는 : " + mira);
		//변수 초기화하기
		int kim = 062; // 변수 선언과 동시에 초기화 가능
		
		char char1 = 'A'; 
		System.out.println(char1);//문자 'A' 그대로 출력
		System.out.println((int)char1); //문자 'A'에 대응하는 아스키코드값(정수)는 65 -> 65 출력

		double dNum = 3.14;
		float fNum0 = 3.14f; // 실수형 변수에 값을 대입할 때는 꼭 숫자 뒤에 f를 붙여주어야 함

		boolean isDelicious = true;
		System.out.println("떡볶이는 맛있는 음식이다 " + isDelicious);
		
		final int MIRA_DAY = 23;//상수 : 변하지 않는 값, 예약어 final 붙이고 변수명은 대문자로 적기, 이어지는 단어는 _로 연결
		System.out.println("MIRA_DAY");
		
		//리터럴(리터럴 상수)
		//프로그램에서 사용하는 모든 숫자, 문자, 논리값을 일컫는 말
		int a = 30; // 리터럴 : 30
		String str = "안녕하세요"; // 리터럴 : 안녕하세요
		final int HI = 30; // 변수 뿐 아니라 상수에도 적용되는 말
		
		//묵시적 형 변환
		byte bNum = 10;
		int iNum0 = bNum; // bNum에는 바이트형 값이 들어있었으나 int형 변수로 자동으로 변환된다
		int iNum1 = 20;
		float fNum1 = iNum1;
		System.out.println(iNum1); //inum의 값은 10
		System.out.println(fNum1); //inum의 값을 float형에 대입하자 10.0으로 자동 형변환되어 출력되었다
		
		//명시적 형 변환
		double dNum1 = 13.223;
		float fNum2 = 23.032f;
		
		int iNum2 = (int)dNum + (int)fNum2; // double 13.233 + float 23.032 를 정수형 int로 변환해 13+23이 된다
		System.out.println(iNum2);//26 출력 소수점 이하 결과값이 날아갔다
		
	}


		
	

}
