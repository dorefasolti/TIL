package com.mira.study.run;

import java.util.Scanner;

import com.mira.study.ReviewMemory;

public class ObjectArrayRun {
	public static void main(String[] args) {
		
		//객체배열에 대해 알아보자
		//클래스이름[] 배열이름 = new 클래스이름[배열크기]
		
//		int[] iArr = new int[5]; 
//		인트형 배열, 이름은 iArr, 5칸
//		String[] sArr = new String[5];
//		문자열형 배열 sArr, 5칸
//		ReviewMemory[] rArr = new ReviewMemory[3];
//		내가 만든 클래스를 자료형으로 사용해서 배열을 만들 것ㅇ
//		(ReviewMemory)

		ReviewMemory[] arr = new ReviewMemory[3];
		//arr[0], arr[1], arr[3] 배열을 생성
			
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < arr.length; i++) { //arr의 길이만큼 돌아가는 배열(각 인덱스에 값을 넣어주기 위함)
			 System.out.println("제목 : ");
	         String title = sc.next();
	         
	         System.out.println("출판사 : ");
	         String publisher = sc.next();
	         
	         System.out.println("저자 : ");
	         String author = sc.next();
	         
	         System.out.println("가격 : ");
	         int price = sc.nextInt();
	         
	         System.out.println("할인율 : ");
	         double discountRate = sc.nextDouble();
	         sc.nextLine();
		
		
		
		arr[i] = new ReviewMemory(title, publisher, author, price, discountRate);
		//첫번째 반복 : 0번 인덱스에 입력받은 값들을 대입
		//두번째 : 1번인덱스에
		//세번째 : 2번인덱스에
		
		}
	
		//배열의 길이만큼 돌아가는 반복문
		//i가 arr[] 안에 들어가고, i가 증가하며 각각 다른 배열을 출력하게됨
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].information());
		} 
	
		//책 제목을 입력받고 같은 책이 있으면 가격을 출력해준다
		System.out.println("입력하세요 : ");
		String serachTitle = sc.next();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].equals(serachTitle)) {
				System.out.println(arr[i].getPrice());
			}
		}
		
	}
}
