package com.mira.study;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class practice2 {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM PRACTICE";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver 등록 성공");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			System.out.println("Connection 객체 생성");
			
			stmt = conn.createStatement();
			System.out.println("Statment 객체 생성");
			
			rset = stmt.executeQuery(sql);
			System.out.println("sql문 삽입 완료");
			
			while(rset.next()) {
				
				int pNo = rset.getInt("PNO");
				
				String pName = rset.getString("PNAME");
				Date pDate = rset.getDate("PDATE");
				System.out.println(pNo + ", " + pName + " , " + pDate);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
