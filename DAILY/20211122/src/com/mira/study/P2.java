package com.mira.study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class P2 {
public static void main(String[] args) {
	
	

	//사용자에게 값을 입력받아 DBMS로 전달
	
//	Scanner sc = new Scanner(System.in);
//	System.out.println("번호 : ");
//	int num = sc.nextInt();
//	System.out.println("이름 : ");
//	String name = sc.next();
	
	
	
//	필요한 변수들 먼저 세팅
//	1단계 끝
	int result = 0;
	Connection conn = null;
	Statement stmt = null; //자바.sql에 있는 것 임포트

	
	//2단계
	//실행 sql문 작성("완성 형태"로 만들기)
	//세미콜론을 절대 붙이면 안된다 
	
	String sql = "INSERT INTO PRACTICE VALUES(4, '김김김', SYSDATE)";
//	String sql = "INSERT INTO TEST VALUES("+ num + ",'" + name + "'" + ", SYSDATE)";

	try {
		//1) JDBC driver 등록 //드라이버는 클래스를 땡겨오는것이기때문에 클래스낫파운드,...
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("driver 등록 성공");

		//2) Connection 객체 생성 (1이 안되어있으면 불가능)
		//DB에 연결(url, 계정명, 비밀번호)
															//원래아이피자리
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
//																					"계정명" "비번"
		System.out.println("Connection 객체 생성!");
		
		//3) Statement 객체 생성
		stmt = conn.createStatement();
		System.out.println("Statement 객체 생성!");
		
		//4) sql 쿼리 날려서 실행 후 결과 받기(처리된 행 수)
		result = stmt.executeUpdate(sql);
		
		//내가 실행할 sql 문이 dml문(insert, update, delete)일 경우
		//=> stmt.executeUpdate("DML문") : int
		//내가 실행할 sql문이 select문일 경우
		//=> stmt.executeQuery("SELECT문") : resultSet
		
		//5) 트랜잭션 처리 
		if(result > 0) { //성공했을 경우 commit
			conn.commit();
		} else { //아닐 경우 rollback
			conn.rollback();
		}
		
		
		
	} catch (ClassNotFoundException e) {
		System.out.println("드라이버 오타");
		e.printStackTrace();
		
	} catch (SQLException e) {
		System.out.println("커넥션 객체부터 확인");
		e.printStackTrace();
	} finally {
		try {
			stmt.close(); //역순으로 닫아주기
			conn.close(); //sql익셉션으로 잡아주기
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	if(result > 0) {
		System.out.println("insert 성공!");
	} else {
		System.out.println("insert 실패!");
	}

	//인서트문 사용 끝
	
}
}
