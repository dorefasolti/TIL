package com.mira.study;

public class ReviewDoWhile {
	public void method2() {
		/*
		 * do-while문
		 * 별도 조건 검사 없이 무조건 최초 1회 실행
		 * 조건이 맞지 않더라도 한 번은 꼭 수행
		 * 
		 * do{
		 * 	syso("안녕하세요");
		 *	증감식;(필수x)
		 *	}while(조건식);
		 * 
		 * 
		 * do와 while차이
		 * while문 -> 무조건 조건식이 true여야 실행
		 * do-while -> 최초 1회는 조건식이 거짓이더라도 무조건 실행
		 * */
		int num = 1;
		do {
			System.out.println("안녕하세요");
		
		}while(num == 0);		
	}
}
