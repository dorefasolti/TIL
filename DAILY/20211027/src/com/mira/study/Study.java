package com.mira.study;

public class Study {

//	------------------------------------4 - 1 시작 ------------------------------

	
//	
//	메소드
//	입력을 가지고 어떤 일을 수행한 다음 결과물을 출력
//	
//	접근제한자 예약어 반환형 메소드이름(매개변수의 자료형 매개변수명) {
//		수행할 코드
//		return 반환값;
//	}
//	
//	생략 가능한 것
//	예약어, 매개변수, (반환형이 void일 경우) return문
//	호출 시 인자값(argument)는 매개변수 자료형과 갯수가 일치해야한다
//	
//	한 번 정의해두면 필요할 때마다 호출해서 사용할 수 있다
//	
//	
	
	
//	예약어 생략됨
	
//	1. 매개변수 X 반환값X
	public void method1() {
//		반환형 void
//		return X
	}
	
//	2. 매개변수 X 반환값 O
	public int method2() {
		return (int) (Math.random()*45) +1;
//		반환형 : 원하는 자료형
//		return O
	
	}
	
//	3. 매개변수 O, 반환값 X
	public void method3(int num1, int num2) {
//		반환형 void
//		매개변수O
//		return X
	}
	
//	4. 매개변수O, 반환값 O
	public int method4(int a, int b) {
		return a + b;
//		반환형 : 원하는 자료형
//		매개변수 O
//		return O
	}
	
	
	
	
//	------------------------------------4 - 1 끝!!! ------------------------------

	
	
//	------------------------------------ 4 - 2 시작 ------------------------------

	
//	static 메소드
//	객체 생성을 하지 않아도 사용 가능
	
	
//	예약어 static
	
//	1 .매개변수X 반환값X static 메소드
	public static void staticmethod1() {
		
	}
	
	
	
//	2. 매개변수X 반환값O static 메소드
	
	public static String staticmethod2() {
		return "매개변수X 반환값O";
	}
	
	
	
//	3. 매개변수O 반환값X static 메소드
	
	public static void staticmethod3() {
		
	}
	
	
	
//	4. 매개변수O, 반환값O
	public static String staticmethod4(String name, int age) {
		return name + age;
	}
	
	
	
	
	
	
	
//	------------------------------------4 - 2 끝!!! ------------------------------


//	------------------------------------4 - 3 시작!!! ------------------------------

	
	
	
//	
//	메소드 오버로딩
//	한 클래스 내 같은 메소드명으로 여러 메소드를 정의 할 수 있는 방법
//	매개변수 자료형의 갯수, 순서, 종류가 달라야한다
//	매개변수명, 접근제한자, 반환형은 메소드 오버로딩에 영향X
//	
	
	
	public void test() {
//		기본메소드
	}
	
	public void test(int a) {
//		매개변수가 int a 하나인 메소드
	}
	
	public void test(int a, String s) {
//		매개변수가 int a, String s 두 개인 메소드
	}
	
	public void test(String s, int a) {
//		매개변수가 String s, int a 두 개인 메소드(순서가 다르다)
	}
	
//	public void test(int a, int b) {
//		매개변수가 int a, int b 두 개인 메소드
	}
	
	
//	public void test(int a, int b)
//	마지막 메소드를 이용해 알아보자 
	
//	1.
//	만약, 보기와 형식이 동일하지만 매개변수 명이 다른 메소드를 만든다면?
//	매개변수의 이름과는 상관 없이 자료형의 갯수, 순서가 같으므로 불가능하다
//	public void test(int c, int b)
//	만약, 인트 (10, 20)을 입력받았을 때, 컴퓨터는 a,b를 받는 메소드에 넣어야할지, c, d를 받는 메소드에 넣어야 할지 알 수 없다
	
//	2. 만약, 반환형이 다른 메소드를 만든다면?
//	public int test(int a, int b) {
//		return a + b;
//	}
//	반환형이 다르다고 오버로딩이 적용되지 않는다
//	메소드를 호출하는 시점에서 매개변수가 동일하다면 151번 줄과 같은 이유로 오류 발생
//	
//	3. 만약, 접근제한자가 다른 메소드를 만든다면?		
//	private void test(int a, int b) {
//	}
//	1, 2번과 동일하게 접근제한자가 달라도 매개변수가 동일하기 때문에 오버로딩 적용이 불가능하다
	
	
//	☆잊지 말자! 오버로딩 시 매개변수는 꼭 달라야한다☆



//------------------------------------4 - 3 끝!!! ------------------------------



