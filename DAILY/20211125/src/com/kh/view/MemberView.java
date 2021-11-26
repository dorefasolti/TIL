 package com.kh.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.controller.MemberController;
import com.kh.model.vo.Member;

public class MemberView {
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	public void mainMenu() {
		
		while(true) {
			
			System.out.println("***** 회원 관리 프로그램 *****");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 아이디로 검색");
			System.out.println("4. 회원 이름 키워드로 검색");
			System.out.println("5. 회원 정보 변경");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			
			int number = sc.nextInt();
			sc.nextLine();
			
			switch(number) {
			case 1 : insertMember(); break;
			case 2 : selectAll(); break;
			case 3 : searchUserID(); break;
			case 4 : searchKeyword(); break;
			case 5 : updateMember(); break;
			case 6 : deleteMember(); break;
			case 0 : System.out.println("종료합니다."); return;
			default : System.out.println("잘못 입력하셨습니다."); break;
			}
		}
	}
	
	public void insertMember() {
		System.out.println("----회원 추가----");
		
		System.out.println("아이디 : ");
		String userId = sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String userPwd = sc.nextLine();
		
		System.out.println("이름 : ");
		String userName = sc.nextLine();
		
		System.out.println("성별 : ");
		String gender = String.valueOf(sc.nextLine().toUpperCase().charAt(0));
		
		System.out.println("나이 : ");
		int age = sc.nextInt();
		sc.nextLine();
		
		System.out.println("이메일 : ");
		String email = sc.nextLine();
		
		System.out.println("핸드폰번호(숫자만) : ");
		String phone = sc.nextLine();
		
		System.out.println("주소 : ");
		String address = sc.nextLine();
		
		System.out.println("취미 : ");
		String hobby = sc.nextLine();
		
		mc.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby); 
		
	}
	
	public void selectAll() {
		System.out.println("--전체 회원 조회--");
		
		mc.selectAll();
	}
	
	public void searchUserID() {
		System.out.println("---- 회원 아이디로 검색 ----");
		System.out.println("검색할 아이디를 입력하세요 : ");
		String userId = sc.nextLine();
		
		mc.searchUserId(userId);
	}
	
	public void searchKeyword() {
		System.out.println("--- 키워드 검색 ---");
		System.out.println("검색할 키워드를 입력하세요 : ");
		String keyword = sc.nextLine();
		
		mc.seasrchKeyword(keyword);
		
	}
	
	public void updateMember() {
		System.out.println("---- 회원 정보 수정 ----");
		System.out.println("변경할 회원의 아이디");
		String userId = sc.nextLine();
		
		System.out.println("새 비밀번호");
		String newPwd = sc.nextLine();
		
		System.out.println("새 이메일 : ");
		String newEmail = sc.nextLine();
		
		System.out.println("새 휴대폰번호(숫자만) : ");
		String newPhone = sc.nextLine();
		
		System.out.println("새 주소 : ");
		String newAddress = sc.nextLine();
		
		mc.updateMember(userId, newPwd, newEmail, newPhone, newAddress);
		
	}
	
	public void deleteMember() {
		System.out.println("----회원 탈퇴----");
		System.out.println("탈퇴할 아이디 : ");
		String userId = sc.nextLine();
		
		mc.deleteMembeR(userId);
	}
	
	
	//--------------------------------------------------

	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}

	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패" + message);
	}

	public void displayNodate(String message) {
		System.out.println(message);
	}

	public void displayList(ArrayList<Member> list) {
		System.out.println("\n조회된 데이터는 " + list.size() + "건 입니다.\n");
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	public void displayOne(Member m) {
		System.out.println("\n조회된 데이터는 다음과 같습니다.");
		System.out.println(m);
	}
	
	
	
	
}
