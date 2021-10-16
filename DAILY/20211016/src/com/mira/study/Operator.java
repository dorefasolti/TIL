package com.mira.study;

public class Operator {

	public void arithmetic() {
//		산술연산자 
//		이항 연산자로서 연산 방법, 우선순위가 일반 수학과 동일
//		+, -, *, /, %
//		%(모듈러, modular) = > 나머지 
		
		int num1 = 10;
		int num2 = 7;
		System.out.println("num1 + num2 = " + (num1 + num2));
		System.out.println("num1 - num2 = " + (num1 - num2));
		System.out.println("num1 * num2 = " + (num1 * num2));
		System.out.println("num1 / num2 = " + (num1 / num2));
		System.out.println("num1 % num2 = " + (num1 % num2));
		
//		int num3 = 10;
//		int num4 = 0;
//		System.out.println("num3 % num4 = " + (num3 % num4));
//		10 % 0, 10 / 0 ; -> 0으로 나눌 경우 빨간줄이 뜨진 않지만 아래와 같은 오류메시지 출력됨
//		Exception in thread "main" java.lang.ArithmeticException: / by zero
		
		System.out.println("산술연산자 끝");
	}
	
	public void increaseDecrease() {
//		증감연산자
//		단항 연산자. 한번에 1씩 증가 혹은 감소
//		++ : 값을 1씩만 증가시키는 연산자
//		-- : 값을 1씩만 감소시키는 연산자
//		전위연산 : ++a, --a, 증감연산자 먼저 수행 -> 다른 연산 수행(값이 먼저 증가/감소 되고 값이 처리됨)
		
		int num = 10;
		System.out.println("num = " + num); //num의 초기값은 10
		int num1 = ++num;
		System.out.println("num = " + num); // num의 값이 1증가하여 11
		System.out.println("num1 = " + num1); // 출력 이전에 ++연산 -> 11출력됨
		
		//		후위연산 : a++, a--, 다른 연산 먼저 수행 -> 증감연산자 수행(값이 처리되고 난 후 값이 증가하거나 감소됨)
		int a = 10;
		int b = a++;
		
		System.out.println("a = " + a); //b에 10이 대입된 후 a의 값이 1 증가 -> 11 출력
		System.out.println("b = " + b); //10 출력 후 a의 값이 1증가
	
		System.out.println("증감연산자 끝");
	
	
	}
	
	public void compound() {
//		
//		복합대입연산자 : =
//		산술연산자와 대입연산자가 결합한 것
////		
//		+=, -=, *=, /=, %= 
//		꼭 산술연산자가 먼저 나와야 함
//		대입연산자가 먼저 나오면 값이 제대로 나오지 않는다
		
		int num = 1;
		System.out.println("현재 num = " + num);
		num += 5 ; // num = num + 3
		System.out.println("num에 5 더하기 = " + num);
		num -= 5; // num = num -5
		System.out.println("num에서 5 빼기 = " + num);
		num *= 5; // num = num * 5
		System.out.println("num에 5 곱하기 = " + num);
		num /= 5; // num = num / 5
		System.out.println("num을 5로 나누기 = " + num);
		num %= 5 ; // num = num % 5
		System.out.println("num을 5로 나눈 나머지 = " + num);

		System.out.println("복합대입연산자 끝");
	}
	
	public void negation() {
		
//		논리부정연산자 : 논리값(true/false)을 반대로 바꿔주는 연산자
//		!논리값
		
		System.out.println("true의 부정 = " + !true);
		System.out.println("false의 부정 = " + !false);
		
		System.out.println("논리부정연산자 끝");
	}
	
	public void comparison() {
		
//		비교연산자(관계연산자)
//		두 개의 값을 가지고 비교, 이항연산자
//		a = 10, b  = 10000
//		a > b = false
//		참 => true
//		거짓 = >false 
//		피연산자는 숫자, 결과값은 논리값으로 출력됨
		
//		1. 크고 작음을 비교
//		a < b : a가 b보다 작은가?
//		a > b : a가 b보다 큰가?
//		a <= b : a가 b보다 작거나 큰가?
//		a >= b : a가 b보다 크거나 같은가?
		
//		2. 일치함을 비교(동등비교)
//		a == b : a와 b가 일치하는가?
//		a != b : a와 b가 일치하지 않는가?
		
		int a = 10;
		int b = 10001; 
		System.out.println("a < b : " + (a < b)); //true
		System.out.println("a <= b : " + (a <= b)); //true
		
		boolean result1 = (a == b);
		System.out.println("a == b : " + result1); //false(a와 b는 같은가? -> 같지 않다 false 출력)
		boolean result2 = (a != b);
		System.out.println("a != b = " + result2); //true(a와 b는 같지 않은가? -> 같지 않다 true 출력 )
		
		System.out.println("a는 짝수입니까? : " + (a % 2 == 0)); //true
		System.out.println("b는 홀수입니까? : " + (b % 2 == 0)); //false
		//짝수는 2로 나눴을 때 나머지가 0, 홀수는 1
	}
	
	
	
}
