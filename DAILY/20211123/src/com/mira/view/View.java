package com.mira.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.mira.controller.Controller;
import com.mira.model.vo.Member;

/**
 * @author MIRA
 *
 */
/**
 * @author MIRA
 *
 */
public class View {

		private Scanner sc = new Scanner(System.in);
		private Controller c = new Controller();
		
		
		public void mainMenu() {
			
			while(true) {
				System.out.println("**** 회원 관리 프로그램 ****");
				System.out.println("1. 회원 추가");
				System.out.println("2. 회원 전체 조회");
				System.out.println("3. 회원 아이디로 검색");
				System.out.println("0. 프로그램 종료");
				System.out.println("이용할 메뉴 선택 : ");
				
				int menu = sc.nextInt();
				sc.nextLine();
				
				switch(menu) {
				case 1 : insertMember(); break;
				case 2 : selectAll(); break;
				case 3 : selectByUserId(); break;
				case 0 : System.out.println("프로그램을 종료합니다."); return;
				default : System.out.println("번호를 잘못 입력했습니다.");
				}
				
			}
		}
		
		
		
		public void insertMember() {
			System.out.println("----- 회원 추가 -----");
			
			System.out.print("아이디 : ");
			String userId = sc.nextLine();
			
			
			System.out.print("비밀번호 : ");
			String userPwd = sc.nextLine();
			
			System.out.print("이름 : ");
			String userName = sc.nextLine();
			
			System.out.print("성별(M/F) : ");
			String gender = sc.nextLine().toUpperCase();
			
			System.out.print("나이 : ");
			int age = sc.nextInt();
			sc.nextLine();
			
			System.out.println("이메일 : ");
			String email = sc.nextLine();
			
			System.out.println("전화번호(숫자만) : ");
			String phone = sc.nextLine();
			
			System.out.println("주소 : ");
			String address = sc.nextLine();
			
			System.out.println("취미(,로 공백 없이 나열)");
			String hobby = sc.nextLine();
			
			c.insertMember(userId, userPwd, userName, gender, age, email, phone, address, hobby);
			
			
			
			
		}
		
		
		public void selectAll() {
			System.out.println("----회원 전체 조회 ----");
			c.selectAll();
		}
		
		
		public void selectByUserId() {
			System.out.println("---회원 아이디로 검색---");
			System.out.println("아이디 : ");
			String userId = sc.nextLine();
			
			c.selectByUserId(userId);
		}

//---------------------------------------------------------------

		/**
		 * 서비스 요청 성공 시 보게 될 화면
		 * @param message 성공메시지
		 */
		public void displaySuccess(String message) {
			System.out.println("\n서비스 요청 성공 : " + message);
		}

		/**
		 * 서비스 요청 실패 시 보게 될 화면
		 * @param message 실패메시지
		 */
		public void displayFail(String message) {
			System.out.println("\n서비스 요청 실패 : " + message);
		}



		/**
		 * 조회 서비스 요청 시 조회 결과가 없을 때 보게 될 화면
		 * @param string 사용자에게 보여질 메시지
		 */
		public void displayNodate(String message) {
			System.out.println(message);
		}



		/**
		 * 조회서비스 요청 시 여러 행이 조회된 결과를 받아서 보게 될 화면
		 * @param list 여러 행이 조회된 결과
		 */
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

