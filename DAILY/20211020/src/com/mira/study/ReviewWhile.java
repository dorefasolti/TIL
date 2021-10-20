package com.mira.study;

import java.util.Arrays;

public class ReviewWhile {
	public void method() {
		
		
//		while문
//		초기화식;
//		while(조건식) {
//			반복적으로 실행할 코드
//			증감식;(필수X)
//		}
//		조건식 결과가 true일 경우 scope 안 코드를 반복적으로 실행
//		while(true) => 무한반복
		int i = 1;

		while(i <= 10){
			System.out.println("i는 " + i);
			i++;
		}
		
		
		
		int j = 1;
		while(j < 10) {
			System.out.println(j + "다섯번만 나올것");
			j += 2;
		}
		//1~10 사이 홀수만 출력
		//1에 2씩 더하기
		//j = j + 2라는 뜻 
		
		
		int k = 1;
		int sum = 0;
		while(k <= 100) {
			sum = k + sum;
			k++;
		}
		System.out.println(sum);
//		//1부터 100까지 더하는 코드
		

		int b = 1; //초기식
		int total = 0; //합계를 계산해서 담아둘 변수
		while(b <= 100) {
			if(b % 2 == 0) {total = total + b;} 
			b++;
		}
		System.out.println(total);
//		//1~100까지 짝수만 더하기
		
		
		int a = 1;
		int tot = 0;
		while(a <= 100) {
			if(a % 2 == 1) {
				tot += a;
			}
			a++;
		}
		System.out.println(tot);

	}

}










