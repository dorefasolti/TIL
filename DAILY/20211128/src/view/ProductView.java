package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.ProductController;
import model.vo.Product;

public class ProductView {
	private Scanner sc = new Scanner(System.in);
	private ProductController pc =  new ProductController();
	
	public void mainMenu() {
		while(true) {
			
			System.out.println("---메뉴구성---");
			System.out.println("1. 상품 전체 조회 하기");
			System.out.println("2. 상품 추가하기");
			System.out.println("3. 상품명 검색하기");
			System.out.println("4. 상품 정보 수정하기");
			System.out.println("5. 상품 삭제 하기");
			System.out.println("0. 프로그램 종료하기");
			
			System.out.println("사용할 메뉴의 번호를 적어주세요 >");
			int menu = sc.nextInt();
			sc.nextLine();
		
		
		switch(menu) {
		case 1 : selectAll(); break;
		case 2 : insertProduct(); break;
		case 3 : selectByProductName(); break;
		case 4 : updateProduct(); break;
		case 5 : deleteProduct(); break;
		case 0 : System.out.println("프로그램을 종료합니다!"); return;
		default : System.out.println("번호를 잘못 입력하셨습니다!");
		
			}//switch
		}//while
		
	}//mainMenu
	
	// selectAll() 시작
	private void selectAll() {   
		
		System.out.println("----- 상품 조회하기 -----");
		
		pc.selectAll();
		
	} // selectAll() 끝


	// insertProduct() 시작
	private void insertProduct() {  
		System.out.println("----- 상품 추가하기 -----");
		
		System.out.print("상품 아이디 : ");
		String productId = sc.nextLine();
		
		System.out.print("상품명 : ");
		String productName = sc.nextLine();
		
		
		System.out.print("상품가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.print("상품상세정보 : ");
		String description = sc.nextLine();
		
		
		System.out.print("재고 : ");
		int stock = sc.nextInt();
		
		pc.insertProduct(productId, productName, price, description, stock);
		
	} //insertProduct() 끝
	
	//3. selectByProductName
	public void  selectByProductName(){
		System.out.println("상품 이름으로 키워드 검색");
		System.out.println("상품명 키워드를 입력하세요 : ");
		String keyword = sc.nextLine();
		
		pc.selectByProductName(keyword);
	}

	/**
	 * 4. 상품 정보 수정 하기 (상품 id로 조회하고 수정)
	 */
	public void updateProduct() {
		
		System.out.println("===== 상품 정보 수정 =====");
		
		System.out.println("변경할 상품아이디 입력 >");
		String productId = sc.nextLine();
		
		System.out.println("변경할 상품가격 입력 >");
		int price = sc.nextInt();
		sc.nextLine();
		
		System.out.println("변경할 상품상세정보 입력 >");
		String description = sc.nextLine();
		
		System.out.println("변경할 재고 입력 >");
		int stock = sc.nextInt();
		sc.nextLine();

		pc.updateProduct(productId, price, description, stock);

	}

	
	//deleteProduct() 시작
	public void deleteProduct() {
		System.out.println("상품 삭제 페이지입니다.");
		System.out.println("삭제할 상품의 아이디를 입력해주세요 >");
		String productId = sc.nextLine();
		
		pc.deleteProduct(productId);
		
	}//deleteProduct() 끝
	
	//-----------------------------------------------------------------
	
		public void message(String message) {   // 메세지 출력
			System.out.println(message);
		}

		public void displayList(ArrayList<Product> list) {  // displayList() 시작
			System.out.println("\n조회된 데이터는 " + list.size() + "건 입니다.\n");
			for(int i=0; i<list.size(); i++) {
				System.out.println(list.get(i));
			}
		}   // displayList() 끝
	
		/**
		 * 성공 화면
		 * @param message 성공 메시지
		 */
		public void displaySuccess(String message) {
			System.out.println("\n서비스 요청 성공: " + message);
		}
		
		/**
		 * 실패 화면
		 * @param message 실패 메시지
		 */
		public void displayFail(String message) {
			System.out.println("\n서비스 요청 실패: " + message);
		}
		
	
	
	
	
	

}
