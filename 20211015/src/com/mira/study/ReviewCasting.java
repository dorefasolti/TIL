package com.mira.study;

public class ReviewCasting {
// 형변환(Type Casting) -> 값의 종류, 즉 자료형을 바꾸는 것

	//컴퓨터 안에서 값을 처리하는 규칙
//	1. 대입연산자(=)을 기준으로 왼쪽(좌항)과 오른쪽(우항)이 같은 자료형일 것
//	2. 같은 자료형끼리만 연산이 가능, 다른 자료형끼리 연산하고 싶을 때 "형변환"필요
//	3. 연산의 결과물도 같은 자료형일 것
	
	
	public void autoCasting() {
//		자동형변환(Promotion)
//		작은 크기의 자료형에서 큰 크기의 자료형으로 변환될 때
//		자동으로 형변환이 진행됨(수동으로 바꿀 필요 X)
		
//		1. int(정수, 4byte) -> double(실수, 8byte)의 경우
		int i1 = 10; //int i1에 10을 대입
		System.out.println(i1); // 10출력
		double d1 = i1; //double d1에 i1(10)을 대입함
//		double은 실수형
//		자동으로 형변환되어 10.0이 출력됨	
		System.out.println(d1); // 10.0출력
		
//		2. int(정수, 4byte) -> long(정수, 8byte)
		int i2 = 120000;
		long l3 = i2;
		System.out.println(l3); //120000출력
//		 -> long형으로 자동 형변환
				
//		3. long(정수, 8byte) -> float(실수, 4byte)
		//long은 8byte, float는 4byte인데 왜 크기가 작은 float로 형변환이 이루어지는가?
//		=>실수가 크기는 작지만 표현범위가 더 방대하기 때문
		long l4 = 10000;
		float f5 = l4;
		System.out.println(f5); //10000.0출력
		
//		4. char(문자, 2byte) <-> int(정수, 4byte)
//		양방향 전환이 가능함
		
		char ch = 65;
		System.out.println(ch); 
		int num = ch;
		System.out.println(ch);
		// 아스키코드에서 65 = A => A 출력
		
		System.out.println('뿌'); // 뿌 출력
		System.out.println((int)'뿌'); // 뿌를 아스키코드 값으로 변환한 값인 491000 출력 
		System.out.println('뿌'+(char)2); //49100에 2를 더한 49102 출력
		System.out.println('뿌'+'2'); // 49100에 문자 '2'를 아스키코드로 변환한 숫자50이 더해져 49150
		
		
		//2와 '2'는 다르다 우리 눈에는 같지만 컴퓨터에게는 다르게 인식된다 같은 발음이지만 '2와 이'만큼 다르다
		//정수(10진수) 2는 아스키코드에서 문자로 STX
		//'2'는 문자로 취급되어 10진수로 바꾸면 50이 된다
		//뿌는 아스키코드로 변환하면 49100이다
		//뿌 49100 + (char)2는 2가 STX로 저장되었다가 연산할 때 다시 int형으로 바뀌어서 2가 된다 -> 49102
		//김 49100 + '2' 는 int형으로 바뀌어 계산될 때 문자 '2'의 값이 10진수 50이기 때문에 49150이 된다
				
		
//		5. byte, short 간의 연산
		byte b1 = 1;
		byte b2 = 2;
		System.out.println(b1 + b2);
		//결과값이 int형 - > CPU가 값을 처리하는 기본 크기가 int형 크기(4byte)
//		byte resultB = (b1 + b2); 
		//결과값이 int인데 왜 byte형에 결과값을 넣으려고 하는가? 오류발생
		byte resultB = (byte)(b1 + b2);
		//강제 형변환을 해주면 가능
		
		byte b3 = (byte)128;
		System.out.println(b3);
//		128을 넣었는데 왜 -128이 나올까? 
//		->byte에서 양수는 최대 127까지 입력 가능(-128~127)
//		->b128 입력 -> 오버플로우 발생해서 결과값이 변한 것
		
	}
	
	public void forceCasting() {
//		강제형변환(Type Casting, 명시적 형변환)
//		자동 형변환이 되지 않는 경우에 진행
//		캐스팅연산자'()' 통해서 진행
//		(바꿀 자료형) 값
//		큰 크기의 자료형 -> 작은 크기의 자료형으로 변환
//		-> 값 손실이 발생할 수 있음

//	1. double(8byte) -> float(4byte)
	float f1 = 5.0f;
	double d2 = 10.0;
	float f2 = (float)d2;
	
//	2. double(8byte) -> int(4byte)
	double d3 = 10.89;
	int i3 = (int)d3;
	System.out.println(i3);
//	실수형 double 10.89 -> 정수형 int로 형변환 -> 10 출력
//	int가 표현할 수 없는 범위인 소수점 아래 데이터가 손실됨
	
	}
	
	
	
	
}
