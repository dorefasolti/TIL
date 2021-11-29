package controller;

import java.util.ArrayList;

import model.dao.ProductDao;
import model.vo.Product;
import view.ProductView;

public class ProductController {
		
	// 1.selectAll 시작
		public void selectAll() {   
		
		ArrayList<Product> list = new ProductDao().selectAll();
		
		if(list.isEmpty()) { 
			new ProductView().message("전체 조회 결과가 없습니다.");
		}else {   
		    new ProductView().displayList(list);
		}
		
	}  //selectAll 끝
	
	
		//2. insertProduct	
		public void insertProduct(String productId, String productName, int price, String description, int stock) {     
		
		Product p = new Product(productId, productName, price, description, stock);
		
		int result = new ProductDao().insertProduct(p);
		
		if(result > 0) {   // 추가
			new ProductView().message("상품 추가!");
		} else {         // 실패
			new ProductView().message("상품 추가 실패!");
		}
	}   // insertProduct() 끝
		
		//3.selectByProductName
		public void selectByProductName(String keyword) {
			ArrayList<Product> list = new ArrayList<>();
			list = new ProductDao().selectByProductName(keyword);
			
			if(list.isEmpty()) {
				new ProductView().displayFail("키워드를 확인하세요");
			} else {
				new ProductView().displayList(list);
			}
		}
		
		
	
		//4. updateProduct
		/**
		 * 4. 상품 정보 수정 하기 (상품 id로 조회하고 수정)
		 * @param productId 상품 id
		 * @param price 상품가격
		 * @param description 상품상세정보
		 * @param stock 재고
		 */
		public void updateProduct(String productId, int price, String description, int stock) {
			
			// 상품 정보 수정용 Product 객체 생성 (model.vo.Product 참조)
			Product p = new Product(productId, price, description, stock);
			
			// 결과 받아오기
			int result = new ProductDao().updateProduct(p);
			
			if(result > 0) {
				// 1행 이상 수정시
				new ProductView().displaySuccess(productId + "의 상품 정보를 정상적으로 수정하였습니다.");
			} else {
				// 수정 실패시
				new ProductView().displayFail(productId + "의 상품 정보 수정에 실패하였습니다.");
			}
			
		}
	
	//deleteProduct
	public void deleteProduct(String productId) {
		
		int result = new ProductDao().deleteProduct(productId);
		
		if(result > 0) {
			new ProductView().displaySuccess("탈퇴 성공!");
		}else {
			new ProductView().displayFail("탈퇴 실패!");
		}
	}

}
