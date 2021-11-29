package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.Controller;
import model.vo.Product;

public class View {
	Controller c = new Controller();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		
		System.out.println("");
		selectByProductName();
		
	}
	
	public void  selectByProductName(){
		System.out.println("상품 이름으로 키워드 검색");
		System.out.println("상품명 키워드를 입력하세요 : ");
		String keyword = sc.nextLine();
		
		c. selectByProductName(keyword);
	}

	public void Fail(String keyword) {
		System.out.println("실패입니다. " + keyword);
	}

	public void Success(ArrayList<Product> list) {
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
