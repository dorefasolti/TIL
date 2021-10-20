package com.mira.study;

import java.util.Scanner;

public class Practice {
	// 정수 두 개와 연산자를 입력받고 입력된 연산자에 따라 알맞은 결과를 출력!
// 단, 해당 프로그램은 연산자 입력에 "exit"라는 값이 입력될 때까지 무한 반복하며
// exit가 입력되면 "프로그램을 종료합니다."를 출력하고 종료합니다.
// 또한 연산자가 나누기이면서 두 번째 정수가 0으로 들어오면
// "0으로 나눌 수 없습니다. 다시 입력해주세요."를 출력하며,
// 없는 연산자가 들어올 시 "없는 연산자입니다. 다시 입력해주세요."라고 출력하고
// 두 경우 모두 처음으로 돌아가 사용자가 다시 연산자부터 입력하도록 하세요.
	
// ex.
// 연산자(+, -, *, /, %) : +
// 정수 1 : 10
// 정수 2 : 4
// 10 + 4 = 14
	
// 연산자(+, -, *, /, %) : ^
// 정수 1 : 10
// 정수 2 : 4
// 없는 연산자입니다. 다시 입력해주세요.
	
// 연산자(+, -, *, /, %) : exit
// 프로그램을 종료합니다.
	
// 연산자(+, -, *, /, %) : /
// 정수 1 : 10
// 정수 2 : 0
// 0으로 나눌 수 없습니다. 다시 입력해주세요.
	
	public void sukje1() {
		
		Scanner sc = new Scanner(System.in);
		int result;
		
		while(true) {			
			System.out.print("연산자(+, -, *, /, %) : ");
			String op = sc.next();
			if (op.equals("exit")){ //연산자에 exit가 입력되면 프로그램 종료
				System.out.println("프로그램을 종료합니다.");
				return;
			}
			System.out.print("정수1 : ");
			int num1 = sc.nextInt();
			System.out.print("정수2 : ");
			int num2 = sc.nextInt();
			
			if(op.equals("/") && num2 == 0 ){ //연산자 == /  num2 == 2가 입력되었을 때 불가능하다는 메시지 출력 후 다시 while로 돌아감
				System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요.");
				continue;
			} else if( op.equals("+") ||  op.equals("-") ||  op.equals("*") || op.equals("%") || op.equals("/")) {
				if(op.equals("+")) result = num1 + num2;			
				else if(op.equals("-")) result = num1 - num2;
				else if(op.equals("*")) result = num1 * num2;
				else if(op.equals("%")) result = num1 % num2;
				else {result = num1 / num2;}
				System.out.println(num1 + " " + op + " " + num2 + " = " + result);
			}else { // +,-,/,/,% 제외한 연산자 입력 시 불가능 메시지출력하고 while로 돌아감
				System.out.println("없는 연산자입니다. 다시 입력해주세요");
				continue;
			}
		}
	}
	
	public void sukje2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("시작 숫자 : ");
		int n1 = sc.nextInt();
		System.out.print("공차 : ");
		int n2 = sc.nextInt();

		for (int i = 0; i < 10; i++) {
			System.out.print(n1 + " ");
			n1 += n2;
		
		
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
}




