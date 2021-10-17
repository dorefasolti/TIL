package com.mira.study;

public class ReviewOperator {
	public void operator() {
		//산술연산자
		//단항연산자 : 항이 한 개인 연산자 ex) num++
		//이항연산자 : 항이 두 개인 연산자 ex) num1 + num2
		//삼항연산자 : 항이 세 개인 연산자 ex) 5 > 4 ? 50 : 40;
		
		//대입연산자 : 변수에 값을 대입하는 연산자
		int mira = 184; // =을 이용해 184가 mira에 대입됨
		//부호연산자
		//+ : 변수, 상수의 값을 양수로 만듦
		//- : 변수, 상수의 값을 음수로 만듦
		
		//산술연산자
		//+, -, *, /, %(나머지)
		int aGroup = 100;
		int bGroup = 200;
		
		int testResult = (aGroup + bGroup); // +연산을 이용해 aGroup과 bGroup의 점수 더하기
		int testAverage = (testResult / 2);
		System.out.println(testAverage); // /연산을 이용해 aGroup과 bGroup 평균 구하기

		//증감연산자
		int miraHeight = 184;
		int miraGrown = ++miraHeight; //184를 1 증가 = 185 값을 miraGrown에 대입함
		System.out.println(miraGrown);
		System.out.println(miraHeight);//1증가되어 185가 됨
		int miraReduce = miraHeight--; // 185
		System.out.println(miraReduce);// 1 감소되기 전의 miraHeight값(185)가 대입됨. 대입 후 감소
		System.out.println(miraHeight);//1 감소되어 184
		
		//관계연산자(true / false로 값을 출력함)
//		> 왼쪽 항이 크면 참, 아니면 거짓
//		< 오른쪽 항이 크면 참, 아니면 거짓
//		>= 죄항이 우항보다 크거나 같으면 참, 아니면 거짓
//		<= 우항이 좌항보다 크거나 같으면 참, 아니면 거짓
//		== 두 항이 같으면 참, 아니면 거짓
//		!= 두 항이 다르면 참, 아니면 거짓 
		
		
		//논리연산자
//		&&(논리곱) 두 항이 모두 참일 경우 참 참참참!
//		||(논리합) 두 항 중 하나만 참이면 참, 둘 다 거짓이면 거짓
//		!(부정) 참일경우 거짓으로, 거짓일 경우 참으로
		
		//복합대입연산자 
		//대입연산자와 다른 연산자를 조합해 하나의 연산자처럼 사용, 코드를 간결하게 표현할 수 있다
		//+=, -=, *=, /=, %=, <<=, >>=, >>>=, &=, !=, ^=
		
		//조건연산자
		//연산에 필요한 항이 세개이므로 삼항연산자라고도 함
		//조건식의 결과가 참인지, 거짓인지에 따라 결과값이 다르다
		//조건식 ? 결과1 : 결과2 -> 조건식이 참이면 결과 1, 조건식이 거짓이면 결과2 출력
		
	}
}
