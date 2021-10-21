package com.mira.study;

import java.util.Scanner;

public class ReviewPractice {

	
	public void method1() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("연산자(+, -, *, /, %) : "); //exit입력하면 프로그램 종료
			String p = sc.nextLine();{				
				if(p.equals("exit")) { System.out.println("프로그램을 종료합니다");
						return;
				}
			}
			
			System.out.println("정수 1 입력 : ");
			int num1 = sc.nextInt();
			System.out.println("정수 2 입력 : ");
			int num2 = sc.nextInt();
			
			int result = 0;
			
			switch(p) {
			case "+" : result = num1 + num2;
				break;
			case "-" : result = num1 - num2;
				break;
			case "*" : result = num1 * num2;
				break;
			case "/" : if(num2 == 0) {
						System.out.println("0으로 나눌 수없습니다.");
						} else result = num1 / num2;
				break;
			case "%" : result = num1 % num2;
				break;
			default : System.out.println("없는 연산자입니다.");
			}//스위치 끝
			System.out.println("result : " + result);
		}//while문의 끝
		
		
	}
	
	public void method2() {
		
		//2번 
		Scanner sc = new Scanner(System.in);
		System.out.print("시작 숫자 : ");
		int num = sc.nextInt();
		System.out.print("공차 : ");
		int gongcha = sc.nextInt();

		String str = ""; //합계를 담을 sum이라는 변수에 초기값 num의 값을 대입
		int sum = num; //초기값 num을 제외한 나머지 결과값을 담을 문자열 str이란 변수 선언
		
		for(int i = 1; i <=10; i++) {
			sum += gongcha; // 합계를 담을 sum이라는 변수에 gongcha값을 더해서 대입
			str += sum +(" "); //결과값을 담을str 변수에 sum에 담긴 값을 문자열로 변환하여 대입 ex)6" " + 9" "
		}
		System.out.println(str);//초기값 num에 공백을 붙인 뒤 반복문에서 완성한 결과값 str을 붙여서 출력
		
		
		
	}
	
	
	
}
