package com.kh.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {
	//JDBC과정 중 반복적으로 쓰이는 구문들을 각각의 메소드로 정리해둘 곳
	//"재사용할 목적"으로 공통 템플릿 작업 진행
	
	//스태틱이붙으면 스태틱ㄱ메모리영역...프로그램이종료될때까지 가져다쓸수잇다...
	//매스클래스를생각해..
	//Math.PI..이런거잇자나..
	//그런걸만들라구..
	
	//이 클래스에서 모든 메소드들은 다 static 메소드로 만들 것
	//싱글톤패턴 : 메모리 영역에 단 한번만 올라간 것을 재사용한 개념
	
	//공통적인 부분 뽑아내기
	//1. DB와 접속된 Connection 객체를 생성해서 반환시켜주는 메소드
	
	public static Connection getConnection() {
		Connection conn = null;
		
		//연결시키기 => 1), 2)
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn; //-> 메소드 본문 안에서 만든 커넥션객체를, 
		//		public static Connection getConnection() 
//										여기에 돌려주면 된다
	}
	
	//2. 전달받은 JDBC용 객체를 반납시켜주는 메소드(각 객체별로)
	//2-1) Connection 객체를 전달받아서 반납시켜주는 메소드
	public static void close(Connection conn) {
		//닫기만하니까 딱히 반환할게 없어서 보이드, 커넥션만!받아서 닫아야하니까 매개변수로 커넥션 받아주기
		//왜 여기서 닫지?
		//예외처리할게많으니까..
		
		try {
			//무조건 커넥션 객체를 닫는게 아니다! 주의사항!!!
			//만약에, conn이 null이라면, NullPointException이 발생할 수 있음
			//그러니까 닫으려면 일단 conn이 널이 아니어야하고 AND 이미 반납되어 닫혀있는 객체가 아니어야한다 
			
			//** 조건문 처리 안해도 널포인트익셉션 발생하지 않는데? 
			//널포인트익셉션? 언체크드리셉션 - 런타임익셉션(부모)을 상속받는다
			//런타임익셉션- 컴파일러가 잡아줄 수없는 문제, 굳이 트라이캐치를 쓰지 않아도 되고, 개발자가 예측할 수 있으므로 조건문으로 해결할 수 있다
			//런타임에러는 소스코드상 문법적 문제가 없는데 발생 문법을잘못쓴게아님에도 불구하고 그 외의 것들..
			//니가 알아서 커넥션객체 잘 만들었겠지 하고 안알려주는것
			//우리가 체크를해야한다..
			//사실 체크를 젣로 안했으니까 반복문을이용해서 체크를해봐야할것같앙,,, 나머지 오류들도 동일..
			//사실은 하나하나 예외가 발생할 수 있을 법한 구문이기 떄문에 전부 예외처리가 필요하다..
			//메소드 하나하나에 전부 트라이캐치해서 적기는 힘들엉... 실수할수도있자나..반복적인작업이자나..
			//개발자는 반복과멀어져야해..
			//그래서 템플릿을 따로 빼놧다...
			//
			
			if(conn!= null && !conn.isClosed())
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//2-2 Statement 객체를 전달받아서 반납시켜주는 메소드
	//=> 다형성으로 인해 PreparedStatement 객체 또한 매개변수로 전달이 가능하다
	//오버로딩을 이용해보자!
	//이름이 close()로 같아도 괜찮다! 왜? 매개변수 들어오는게 다르니까!
	
//	public static void close(PreparedStatement pstmt) { 
//		//Statememt의 자식! Statement의 자료형을 상속! Statement만 있어도 pstmt는 가져와서 쓸 수 있다
//		//이것이 다형성													
//	} 얘는 굳이 만들 필요가 없다
	public static void close(Statement stmt) {
		try {
			if(stmt!= null && !stmt.isClosed()) {				
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	

	//2-3) ResultSet 객체를 전달받아서 반납시켜주는 메소드(오버로딩 적용)
	public static void close(ResultSet rset) {
		try {
			if(rset!= null && !rset.isClosed()) {				
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	//이전에는 하나의 트라이 안에 모든게 들어있었다. 문제점! 위에서 문제가 발생하면 아래로 내려오지 않고 캐치로 빠져버린다
	//따로 빼서 각각 트라이캐치 잡아줘야한다
	
	//3. 전달받은 Connection 객체를 가지고 트랜젝션 처리를 해주는 메소드
	
	//3-1) 전달받은 Connection 객체를 가지고 COMMIT시켜주는 메소드
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
	//3-2) 전달받은 Connection 객체를 가지고 ROLLBACK시켜주는 메소드
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
