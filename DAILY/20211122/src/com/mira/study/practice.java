package com.mira.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class practice {
	public static void main(String[] args) {
		
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		
		
		String sql = "INSERT INTO PRACTICE VALUES(1, '김김김', SYSDATE)";
		
		
		
		try {
		//	1)JDBC driver 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver 등록 성공");

			
			//2)Connection 객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			System.out.println("Connection 객체 생성");
			
			//3)Statement 객체 생성
			stmt = conn.createStatement();
			System.out.println("Statement 객체 생성");
			
			//4)sql 쿼리 날려서 실행 후 결과 받기(처리된 행 수)
			result = stmt.executeUpdate(sql);

			
			//5) 트랜잭션 처리
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(result > 0) {
			System.out.println("insert 성공");
			
		} else {
			System.out.println("insert 실패");
		}
		
		
	}

}
