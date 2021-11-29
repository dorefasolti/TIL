package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.Product;

public class ProductDao {
	
	// 1. selectAll() 시작
	public ArrayList<Product> selectAll() {   
		
		ArrayList<Product> list = new ArrayList<>();
		Connection conn = null; 
		Statement stmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM PRODUCT";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PRODUCT","PRODUCT");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
			while(rset.next()) {
				Product p = new Product();
				
				p.setProductId(rset.getString("PRODUCT_ID"));
				p.setProductName(rset.getString("PRODUCT_NAME"));
				p.setPrice(rset.getInt("PRICE"));
				p.setDescription(rset.getString("DESCRIPTION"));
				p.setStock(rset.getInt("STOCK"));
				
				list.add(p);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
		
	} //selectAll() 끝
	
	 	//2. insertProduct() 시작
		public int insertProduct(Product p) {     // insertProduct() 시작
		
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "INSERT INTO PRODUCT VALUES('"+ p.getProductId() +"', '"+ p.getProductName() +"', "+ p.getPrice() +", '"+ p.getDescription() +"', "+ p.getStock() +")";
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PRODUCT","PRODUCT");
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
			
			if(result > 0) {   // 성공
				conn.commit();
			} else {   // 실패
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}   // insertProduct() 끝
		  // insertProduct() 끝
		
		//3.selectByProductName 
		public ArrayList<Product> selectByProductName(String keyword) {
			ArrayList<Product> list = new ArrayList<>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rset = null;
			

			String sql = "SELECT * FROM PRODUCT WHERE PRODUCT_NAME LIKE '%" + keyword + "%'";
					
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PRODUCT", "PRODUCT");
				stmt = conn.createStatement();
				
				rset = stmt.executeQuery(sql);
				
				while(rset.next()) {
					list.add(new Product(rset.getString("PRODUCT_ID")
							, rset.getString("PRODUCT_NAME")
							, rset.getInt("PRICE")
							, rset.getString("DESCRIPTION")
							, rset.getInt("STOCK")));
					System.out.println(list);
				}

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					rset.close();
					stmt.close();
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}                      
			}
			return list;
		}
		
		// 4. 상품 정보 수정 하기 (상품 id로 조회하고 수정)
		public int updateProduct(Product p) {
				
				// 필요 변수 선언
				int result = 0;
				
				Connection conn = null;
				Statement stmt = null;
				
				// 상품 ID 일치하는 상품 정보 업데이트 SQL문
				String sql = "UPDATE PRODUCT SET "
						+ "PRICE = " + p.getPrice() + ", "
						+ "DESCRIPTION = '" + p.getDescription() + "', "
						+ "STOCK = " + p.getStock()
						+ " WHERE PRODUCT_ID = '" + p.getProductId() + "'";
				System.out.println(sql);
				try {
					
					// JDBC Driver 등록
					Class.forName("oracle.jdbc.driver.OracleDriver");
					
					// Connection 객체 생성 (URL, 계정명, 비밀번호), (계정/비밀번호: PRODUCT)
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PRODUCT", "PRODUCT");
					
					// Statement 객체 생성
					stmt = conn.createStatement();
					
					// SQL문 전달 후 실행 결과 받아오기
					result = stmt.executeUpdate(sql);
					System.out.println(result);
					
					if(result > 0) {
						// 1행 이상 수정됐을 때 Commit
						conn.commit();
					} else {
						// 아닐 때 Rollback
						conn.rollback();
					}
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					try {
						// 자원 반납
						stmt.close();
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				return result;
				
			}	
		
		
		
	//5. deleteProduct() 시작
	public int deleteProduct(String productId) {
		//사용할 변수 설정, int result 값
		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		
		//SQL문 작성
		String sql = "DELETE FROM PRODUCT WHERE PRODUCT_ID = '" + productId + "'";
		try {
			//1. Driver연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2. Connection 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","PRODUCT","PRODUCT");
			
			//3. Statement 연결
			stmt = conn.createStatement();
			
			//4,5
			result = stmt.executeUpdate(sql);
			
			//6 트랜잭션 처리
			if(result > 0) {
				conn.commit();
			}else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return result;
		
	}

}
