package com.mira.list.mvc.controller;

import java.util.ArrayList;

import com.mira.list.mvc.model.vo.Book;

public class LibraryController {
	
	
//	controller : 사용자의 요청을 받아서 처리해주는 클래스
//					결과를 view로 반환
	
	public ArrayList<Book> list = new ArrayList<>();
	//책들이 들어갈 리스트이므로, Book 객체만 받을 수 있도록 한다
	{//초기화 블록 : 객체 생성 시 무조건 수행되는 블록
		list.add(new Book("데미안", "헤르만 헤세", "문학자료실(2F)", "833.912 H587데b이"));
		list.add(new Book("베로니카 죽기로 결심하다", "파울로 코엘료", "문학자료실(3F)", "869.3 C672ㅂ이개"));
		list.add(new Book("향수 : 어느 살인자의 이야기", "파트리크 쥐스킨트", "문학자료실(3F)", "	833.9 S964ㅎ강신 c.2"));
		
	}
	
//			System.out.println(list.get(i).getName() + list.get(i).getAuthor()+list.get(i).getLocation()+list.get(i).getCallNumber());
	//코드가 너무 길어서 보류
	public void allSearch() {
//		//모든 책 리스트를 반환하는 메소드
		for(int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i).toString());
		}
	}
	
//	public ArrayList<Book> allSearch() {
//		
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).getName() + list.get(i).getAuthor()+list.get(i).getLocation()+list.get(i).getCallNumber());
//			System.out.println(list.get(i).toString());
//		}
//		
//		return list;
//		
//	}
	//return list; 출력결과 : [Book [name=데미안, author=헤르만 헤세, Location=문학자료실(2F), callNumber=833.912 H587데b이], Book [name=베로니카 죽기로 결심하다, author=파울로 코엘료, Location=문학자료실(3F), callNumber=869.3 C672ㅂ이개], Book [name=향수 : 어느 살인자의 이야기, author=파트리크 쥐스킨트, Location=문학자료실(3F), callNumber=	833.9 S964ㅎ강신 c.2]]
	//출력물이 예쁘지 않아서 보류
	
	
	
	public ArrayList<Book> keywordSearch(String keyword) {
		//키워드를 이용해 책을 검색하는 메소드
		
		ArrayList<Book> search = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			if((list.get(i).getName().contains(keyword))||(list.get(i).getAuthor().contains(keyword))) {
				search.add(list.get(i));
			}
							
		}
		return search;
	
	}
	public void addBook(String name, String author, String location, String callNumber) {
		//리스트에 책을 추가하는 메소드
		list.add(new Book(name, author, location, callNumber));
		
	}
	public int deleteBook(String keyword) {
		//리스트에서 책을 삭제하는 메소드
		int result = 0;
		for(int i = 0; i < list.size(); i++) {
			if((list.get(i).getName().equals(keyword))||(list.get(i).getAuthor().equals(keyword))||(list.get(i).getLocation().equals(keyword))||(list.get(i).getCallNumber().equals(keyword))) {
				list.remove(i);
				result++;
			}
		}
		return result;
		
	}
}
