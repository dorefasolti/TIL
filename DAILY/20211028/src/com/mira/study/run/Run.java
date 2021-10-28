package com.mira.study.run;

import java.util.Scanner;

import com.mira.study.ReviewMemory;

public class Run {
	public static void main(String[] args) {
		
		ReviewMemory b1 = new ReviewMemory();
		System.out.println(b1.information());
		// null null null 0 0.0 -> 어떠한 값도 들어오지 않았음
		
		ReviewMemory b2 = new ReviewMemory("제목", "출판사", "저자");
		System.out.println(b2.information());
		//제목 출판사 저자 0 0.0
		
		
		ReviewMemory b3 = new ReviewMemory("제목", "출판사", "저자", 10000, 10.0);
		System.out.println(b3.information());
//		제목 출판사 저자 10000 10.0
		
		
		
		//도서 정보를 입력받아서 도서들의 정보를 출력해주는 프로그램
		//책 3권의 정보를 입력받겠다고 가정할것
		//객체는 따로따록 ㅘㄴ리
		//입력은 스캐너 사용
		
		System.out.println(b1); //com.mira.study.ReviewMemory@2d363fb3
		b1 = null;
		System.out.println(b1); //null
		
		System.out.println(b2); //com.mira.study.ReviewMemory@7d6f77cc
		b2 = null;
		System.out.println(b2); //null
		
		System.out.println(b3); //com.mira.study.ReviewMemory@5aaa6d82
		b3 = null;
		System.out.println(b3); //null
		
		//이걸 통해 알 수 있는 것 => b1, b2, b3 객체는 어딘가의 주소를 가지고 있다(그 주소를 따라가면 힙영역이 나옴)
		//null을 대입하면 참조하고 있던 것과의 연결이 끊긴다(참조하고 있던 주소 사라짐)
		
		
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 3; i++) {
			//입력받을 정보 : 도서명, 출판사, 저자, 가격, 할인율
			
			System.out.println("제목 : ");
			String title = sc.next();
			
			System.out.println("출판사 : ");
			String publisher = sc.next();
			
			System.out.println("저자 : ");
			String author = sc.next();
			
			System.out.print("가격 : ");
			int price = sc.nextInt();
			
			System.out.print("할인율 : ");
			double discountRate = sc.nextDouble();
		
			//for문에서 i가 0, 1, 2로 돌아가는 반복문을 만든다
			//만약 i가 0이면 b1에 입력받은 값을 대입
			//1이면 b2, 2면 b3에 값을 대입한다
			
			
			if(i == 0) {
				b1 = new ReviewMemory(title, publisher, author, price, discountRate);				
			}else if(i == 1) {
				b2 = new ReviewMemory(title, publisher, author, price, discountRate);
				
			}else {
				b3 = new ReviewMemory(title, publisher, author, price, discountRate);
				
			}
		
		}
		System.out.println(b1.information());
//		제목입력 출판사입력 저자입력 1 10.0
		System.out.println(b2.information());
//		제목입력 출판사입력 저자입력 2 20.0
		System.out.println(b3.information());
//		제목입력 출판사입력 저자입력 3 30.0
	
	
	
		//사용자로부터 검색할 도서의 제목을 입력받아서
		//각 전체 도서들의 제목과 하나하나 비교해서 일치하는 도서의 가격을 알려주는 프로그램
		System.out.println("검색할 책 제목");
		String searchTitle = sc.next();
		
		if(b1.getTitle().equals(searchTitle)) {
			System.out.println(b1.getPrice());
		}
		if(b2.getTitle().equals(searchTitle)) {
			System.out.println(b2.getPrice());
		}
		if(b2.getTitle().equals(searchTitle)) {
			System.out.println(b3.getPrice());
		}
	
	
	
	
	}
	
}
