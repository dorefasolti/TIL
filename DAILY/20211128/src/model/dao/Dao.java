package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.vo.Product;

public class Dao {

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

}
