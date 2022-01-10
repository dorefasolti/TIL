package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
//	JDBC과정 중 반복적으로 쓰이는 구문들을 각각의 메소드로 정의해둘 용도로 사용했었음
//	재사용할 목적으로 공통 템플릿 작업을 진행했었다
	
//	이 클래스에서의 모든 메소드들은 다 static 메소드로 만들 것
//	싱글톤 패턴 : 메모리 영역에 단 한번만 올라간 것을 재사용하는 개념
	
	public static Connection getConnection() {
//		DB와 접속된 Connection 객체를 생성해서 반환해주는 메소드
		
//		내가 접속할 DB의 url정보, 접속할 유저명, 비밀번호
//		자바소스코드 내에 명시적으로 작성함 => 정적코딩방식(하드코딩)
//		문제점 : dbms 바뀌면 (접속한계정바뀌면) 자바소스코드 수정해야함
//		해결방식 : DB관련된 정보들을 별도로 관리하는 외부파일(.properties)로 만들어서 관리
//					=> 외부파일로 key에 대한 value를 읽어들여서 반영시킬 것 => 동적코딩방식
		
		Properties prop = new Properties();
		
		Connection conn = null;
		
//		읽어들이고자하는 파일의 물리적인 경로
		String fileName = JDBCTemplate.class.getResource("/sql/driver/driver.properties").getPath();
		
		try {
//			prop 으로부터 load메소드를 이용해서 각 키에 해당하는 밸류를 가져올 것
			prop.load(new FileInputStream(fileName));
			
//			prop으로부터  getProperty메소드를 이용해서 각 키에 해당되는 밸류를 뽑아서 배치(프로퍼티스에서 driver=oracle.jdbc.driver.OracleDriver라고 썼음)
			Class.forName(prop.getProperty("driver"));
//			Class.forName("oracle.jdbc.driver.OracleDriver"); 이것과 같음
			
			conn = DriverManager.getConnection(prop.getProperty("url"),
												prop.getProperty("username"),
												prop.getProperty("password"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Connection 객체를 반환
		return conn;
	}
	
//	2. 전달받은 JDBC용 객체를 반납시켜주는 메소드(각 객체별로)
//	2_1. Conn 객체 닫아주는 메소드
	public static void close(Connection conn) {
		try {
			if(conn != null && conn.isClosed()) {				
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
//	2_2. Statement 전달받아서 반납시켜주는 메소드
	public static void close(Statement stmt) {
		try {
			if(stmt != null && stmt.isClosed()) {				
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	2_3. ResultSet 객체를 전달받아서 반납시켜주는 메소드
	public static void close(ResultSet rset) {
		try {
			if(rset!= null && !rset.isClosed()) {				
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	
//	3. 전달받은 Connection 객체를 가지고 트랜잭션 처리를 해주는 메소드
//	3_1. 전달받은 Connection 객체를 가지고 Commit 시켜주는 메소드 
	
	public static void commit(Connection conn) {
		//매개변수를 커넥션으로 만들어주기
		
		try {
			if(conn!= null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//3_2. 생략
	public static void rollback(Connection conn) {
		//매개변수를 커넥션으로 만들어주기
		
		try {
			if(conn!= null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
