package com.mira.view;

import java.util.Scanner;

import com.mira.controller.Controller;

public class View {
	Scanner sc = new Scanner(System.in);
	Controller c = new Controller();
	
	public void mainMenu() {
		while(true) {
			System.out.println("-- 회원 관리 --");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디 검색");
			System.out.println("4. 회원 키워드 검색");
			System.out.println("5. 회원 수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			System.out.println("-------------");
			System.out.print("먼데 ~ >");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 : insert(); break;
//			case 2 : select(); break;
//			case 3 : id(); break;
//			case 4 : name(); break;
//			case 5 : update(); break;
//			case 6 : delete(); break;
			case 0 : System.out.println("끝!");return;
			default : System.out.println("다시 ~");
			}
		}
	}
	
	public void insert() {
		System.out.println("---- 회원추가 ----");
		
		// 입력
		System.out.print("아이디 > ");
		String userId = sc.nextLine();
		
		System.out.print("비밀번호 > ");
		String userPwd = sc.nextLine();
		
		System.out.print("이름 > ");
		String userName = sc.nextLine();
		
		System.out.print("성별 (M/F) > ");
		String gender = String.valueOf(sc.nextLine().toUpperCase().charAt(0));
		
		System.out.print("나이 > ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.print("이메일 > ");
		String email = sc.nextLine();
		
		System.out.print("휴대폰번호(숫자만) > ");
		String phone = sc.nextLine();
		
		System.out.print("주소 > ");
		String address = sc.nextLine();
		
		System.out.print("취미 > ");
		String hobby = sc.nextLine();
		
		c.insert(userId, userPwd, userName, gender, age, email, phone, address, hobby);
	}

	public void Success(String keyword) {
		System.out.println("성공" + keyword);
	}

	public void Fail(String keyword) {
		System.out.println("실패 + keyword");
		
	}

}
