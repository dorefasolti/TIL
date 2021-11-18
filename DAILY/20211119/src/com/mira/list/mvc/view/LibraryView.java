package com.mira.list.mvc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.mira.list.mvc.controller.LibraryController;
import com.mira.list.mvc.model.vo.Book;

public class LibraryView {
	private Scanner sc = new Scanner(System.in);
	Book lib = new Book();
	LibraryController lc = new LibraryController();
	
	//메인화면
	//프로그램을 실행하면 사용자가 가장 먼저 마주할 화면
	//Run클래스에서 접근이 가능해야하므로
	//접근제한자 public
	
	public void mainMenu() {
		System.out.println();
		//종료시키기 전까지 계속 돌아가는 프로그램을 만들고 싶다
		//while문을 이용해 무한반복, 보여줄 화면을 만들 것
		
		while(true) {
			System.out.println("도서관에 오신 것을 환영합니다. 원하는 메뉴를 선택하세요");
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 통합검색");
			System.out.println("3. 책 기증하기");
			System.out.println("4. 파손된 책 신고하기");
			System.out.println("0. 종료");
			
			System.out.print("원하는 메뉴를 선택하세요 : ");
			int num = sc.nextInt();
			
			switch(num) {
			case 1 : allSearch(); break;
			case 2 : keywordSearch(); break;
			case 3 : addBook(); break;
			case 4 : deleteBook(); break;
			case 0 : System.out.println("종료합니다"); return;
			default : System.out.println("잘못된 번호입니다.");
			}
		}
	}
	
	
	public void allSearch() {
		//모든 책 리스트를 반환하는 메소드
		System.out.println(lc.list);

		
	}
	public void keywordSearch() {
		//키워드를 이용해 책을 검색하는 메소드
		System.out.println("찾고싶은 책의 정보를 입력하세요");
		sc.nextLine();
		String keyword = sc.nextLine();
		
		ArrayList<Book> list = lc.keywordSearch(keyword);
		
		System.out.println("검색 결과");
		if(list.isEmpty()) {
			System.out.println("조회된 결과가 없습니다.");
		}else {
			for(Book b : list) {
				System.out.println(b);
				
			}
		}
		
	}
	
	public void addBook() {
		//리스트에 책을 추가하는 메소드
		sc.nextLine();
		System.out.println("기증받은 책의 정보를 입력해주세요.");
		System.out.println("제목 : ");
		String name = sc.nextLine();
		System.out.println("저자 : ");
		String author = sc.nextLine();
		System.out.println("보관장소 : ");
		String Location = sc.next();
		System.out.println("청구기호 : ");
		String callNumber = sc.next();
		
		lc.addBook(name, author, Location, callNumber);
		sc.nextLine();
	}
	public void deleteBook() {
		//리스트에서 책을 삭제하는 메소드
		sc.nextLine();
		System.out.println("파손된 책의 정보를 입력하세요 : ");
		String keyword = sc.nextLine();
		
		
		int result = lc.deleteBook(keyword);
		
		if(result != 0) {
			System.out.println("성공적으로 삭제되었습니다");
		}else {
			System.out.println("다시 입력하세요.");
		}
	}
}
