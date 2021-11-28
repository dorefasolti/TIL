package view;

import java.util.Scanner;

import controller.Controller;

public class View {
	Scanner sc = new Scanner(System.in);
	Controller c = new Controller();
	public void mainMenu() {
		while(true) {
			System.out.println("회원 관리 프로그램");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원전체 조회");
			System.out.println("3. 회원아이디 검색");
			System.out.println("4. 회원 키워드 검색");
			System.out.println("5. 회원 수정");
			System.out.println("6. 회원 탈퇴");
			System.out.println("0. 프로그램 종료");
			
			System.out.println("번호를 입력하세요");
			int number = sc.nextInt();
			sc.nextLine();
			
			switch(number) {
			case 1 : insert(); break;
			case 2 : all(); break;
			case 3 : id();break;
			case 4 : keyword(); break;
			case 5 : update(); break;
			case 6 : delete(); break;
			case 0 : System.out.println("종료합니다."); return;
			default : System.out.println("잘못입력하셨습니다"); break;
			}
		
		
		
		}
		
		
	}
	public void insert() {
		System.out.println("회원 추가");

		System.out.println("아이디");
		String userId = sc.nextLine();
		
		System.out.println("비밀번호");
		String userPwd = sc.nextLine();
		
		System.out.println("이름");
		String userName = sc.nextLine();
		
		System.out.println("전화번호");
		String phone = sc.nextLine();
		
		System.out.println("주소");
		String address = sc.nextLine();
		
		c.insert(userId, userPwd, userName, phone, address);	
	}
	
	public void all() {
		System.out.println("회원 전체 조회");
		c.all();
	}
	
	public void id() {
		System.out.println("아이디로 조회");
		System.out.println("아이디");
		String id = sc.nextLine();
		
		c.id(id);
	}
	
	public void keyword() {
		System.out.println("키워드로 조회");
		System.out.println("키워드 입력");
		String keyword = sc.nextLine();
		
		c.keyword(keyword);
	}
	
	public void update() {
		System.out.println("회원수정");
		System.out.println("아이디 : ");
		String userId = sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String newPwd = sc.nextLine();
		
		
		System.out.println("이름 : ");
		String newName = sc.nextLine();
		
		
		System.out.println("번호 : ");
		String newPhone = sc.nextLine();
		
		
		System.out.println("주소 : ");
		String newAddress = sc.nextLine();
		
		c.update(userId, newPwd, newName, newPhone, newAddress);
		
	}
	
	public void delete() {
		System.out.println("회원 삭제");
		System.out.println("아이디 : ");
		String userId = sc.nextLine();
		
		c.delete(userId);
	}
	
	
	
//	---------------------------------
}
