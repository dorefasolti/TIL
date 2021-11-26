package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDao {
	
	/*
	 * JDBC용 객체
	 * - Connection : DB의 연결정보를 담고 있는 객체(ip주소, port번호, 계정명, 비밀번호)
	 * - (Prepared)Statement : 해당 DB에 SQL문을 전달하고 실행한 후 결과를 받아내는 객체
	 * - ResultSet : 만일 실행한 SQL문이 SELECT문일 경우 조회된 결과들이 담겨있는 객체
	 * 
	 * **PreparedStatement 특징 : SQL문을 바로 실행하지 않고 잠시 보관하는 개념(미완성된 SQL문을 먼저 보낸다, 빵꾸뚫린채로 프린트에프할때..%s, %d 앞에 채워두고, num, num1 채워주는 것처럼.. 빈 부분은 나중에 채워준다)
	 * 							미완성된 sql문을 먼저 전달하고 실행하기 전에 완성 형태로 만든 후 실행만 하면 됨
	 * 							미완성된 SQL문 만들기(사용자가 입력한 값들이 들어갈 수 있는 공간을 ?(위치홀더)로 확보
	 * 							각 위치 홀더에 맞는 값들을 세팅
	 * **Statement(부모)와 PreparedStatement(자식)관계
	 * 차이점
	 * 1) Statement는 완성된 SQL문, PreparedStatement 미완성된 SQL문
	 * 
	 * 2) Statement 객체 생성 시 			stmt = conn.createStatement();
	 * 	  PreparedStatement 객체 생성 시 pstmt = conn.prepareStatement();
	 * 
	 * 3) Statement로 SQL문 실행 시			결과 = stmt.excuteXXXX(sql);
	 * 	  PreparedStatement로 SQL문 실행 시 ?로 빈 공간을 실제 값으로 채워 준 뒤 실행한다.
	 *										  pstmt.setString(?위치, 실제값);
	 *										  pstmt.setInt(?위치, 실제값);
	 *									결과 = pstmt.executexxxx(); 
	 * 
	 * 
	 * ** JDBC 처리 순서
	 * 1) JDBC Driver 등록 : 해당 DBMS가 제공하는 클래스 등록
	 * 2) Connection 객체 생성 : 접속하고자 하는 DB의 정보를 입력해서 DB에 접속하면서 생성(url, 계정, 비번)
	 * 3_1) PreparedStatement 객체 생성 : Connection 객체를 이용해서 생성(미완성된 SQL문을 담아서)
	 * 3_2) 현재 미완성된 SQL문을 완성형태로 채우기
	 * 						=> 미완성된 경우에만 해당 / 완성된 경우에는 생략 가능
	 * 4) SQL문 실행 : executeXXX() => sql매개변수 없음!!
	 * 				> SELECT문의 경우 : executeQuery()메소드 호출
	 * 				> 나머지 DML문의 경우 : executeUpdate()메소드 호출
	 * 
	 * 5) 결과 받기
	 * 				> SELECT문의 경우 : ResultSet 객체(조회된 데이터들이 담겨있음)로 받기 => 6_1)
	 * 				> 나머지 DML문의 경우 : int형(처리된 행의 갯수)으로 받기 => 6_2)
	 * 
	 * 6_1) ResultSet에 담겨있는 데이터들을 하나씩 뽑아서 VO 객체에 담기(많으면 ArrayList로 관리)
	 * 6_2) 트랜잭션처리(성공이면 COMMIT, 실패면 ROLLBACK)
	 * 
	 * 7) 다 쓴 JDBC 객체들은 반드시 자원반납(close()) => 생성된 순서의 역순으로!
	 * 8) 결과 반환(Controller로)
	 * 			> SELECT문의 경우 6_1에서 만들어진 결과
	 * 			> 나머지 DML문의 경우 처리된 행의 갯수
	 *  
	 * */
	
	public int insertMember(Member m) { //INSERT문 => 처리된 행의 갯수 => 트랜잭션 처리
			
		//0) 필요한 변수를 먼저 셋팅
		
		int result = 0; //처리된 결과(처리된 행의 갯수)를 담아줄 변수
		Connection conn = null; //접속된 DB의 연결정보를 담는 변수
		PreparedStatement pstmt = null; //SQL문 실행 후 결과를 받기 위한 변수
		
		// + 필요한 변수 : 실행할 SQL(미완성된 형태로)
		// INSERT INTO MEMBER
		// VALUES(SEQ_USERNO.NEXTVAL, 'XXX', 'XXX', 'XXX', 'XXX', X, 'XXX@XXX', 'XXXX', 'XXXX', 'XXX', SYSDATE)
		
		// + "'" + + "',"
		
		String sql = "INSERT INTO MEMBER "
						+ "VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, DEFAULT)"; //미완성SQL 만들기 0번 끝
		
		try {
			//1) JDBC드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 오타가 있을 경우, ojdbc.jar를 누락시켰을 경우
			// -> ClassNotFoundException이 발생할 수 있으므로 예외처리 꼭 해줘야 함
			
			// 2) Connection 객체 생성(== DB와 연결시키겠다 --> url, 계정명, 비밀번호)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			// 3_1) PreparedStatement 객체 생성(SQL문을 미리 넘겨준다.)
			pstmt = conn.prepareStatement(sql);
			
			// 3_2 미완성된 SQL문일 경우 완성시켜주기
//					pstmt.setXXX(?의 위치, 실제값)
										//순서는 ↓ 물음표 순서
			//VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, DEFAULT)"; 
			pstmt.setString(1, m.getUserId()); //문자형태로 못박아뒀기 때문에 '' 신경 안써도 된다?..
			pstmt.setString(2, m.getUserPwd()); 
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			//PreparedStatement의 단점
			//=> 완성된 SQL문을 볼 수 없다.
			
			//4, 5) DB에 완성된 SQL문을 실행 후 결과(처리된 행의 갯수) 받기
			result = pstmt.executeUpdate();
			
			//6_2) 트랜잭션 처리
			if(result > 0) { //1개 이상의 행이 INSERT되었다면 == 성공했을 경우니까 커밋!
				conn.commit();
			} else { //실패했을 경우 롤백
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오타");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("빵꾸제대로채우기");
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//7) 다 쓴 JDBC용 객체 자원 반납 => 생성된 순서의 역순으로 close()
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//8) 결과 반환
		return result; //처리된 행의 갯수
		
	}

	public ArrayList<Member> selectAll() {
		
		ArrayList<Member> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member();
m.setUserNo(rset.getInt("USERNO")); 
				
				m.setUserId(rset.getString("USERID"));
				m.setUserPwd(rset.getString("USERPWD"));
				m.setUserName(rset.getString("USERNAME"));
				m.setGender(rset.getString("GENDER"));
				m.setAge(rset.getInt("AGE"));
				m.setEmail(rset.getString("EMAIL"));
				m.setPhone(rset.getString("PHONE"));
				m.setAddress(rset.getString("ADDRESS"));
				m.setHobby(rset.getString("HOBBY"));
				m.setEnrollDate(rset.getDate("ENROLLDATE"));
				
				list.add(m);
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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return list;
	}

	public Member searchUserId(String userId) {
		
		Member m = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
//		String sql = "INSERT INTO MEMBER "
//				+ "VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, DEFAULT)"; //미완성SQL 만들기 0번 끝

		
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			System.out.println("커넥트");
			pstmt = conn.prepareStatement(sql);
			System.out.println("pstmt");
			
			pstmt.setString(1, userId);
//			pstmt.setString(1, m.getUserId()); //문자형태로 못박아뒀기 때문에 '' 신경 안써도 된다..
			/*주의사항!!!!!!!!!!!입력받은 userId를 넣어줘야함, 겟유저아이디 아님!!!!!!!!!*/
//			rset = pstmt.executeQuery(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("USERNO")
						, rset.getString("USERID")
						, rset.getString("USERPWD")
						, rset.getString("USERNAME")
						, rset.getString("GENDER")
						, rset.getInt("AGE")
						, rset.getString("EMAIL")
						, rset.getString("PHONE")
						, rset.getString("ADDRESS")
						, rset.getString("HOBBY")
						, rset.getDate("ENROLLDATE"));
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
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return m;
	}

	public ArrayList<Member> searchKeyword(String keyword) {
		// TODO Auto-generated method stub
		
		/*
		 * 내일 강사와 함께 만ㄷ르자아아ㅏ
		 * */
		return null;
	}

	public int updateMember(Member m) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
//		 * UPDATE MEMBER
//		 * SET USERPWD = 'XXX', EMAIL = 'XXX', PHONE = 'XXX', ADDRESS = 'XXX
//		 * WHERE USERID = 'XXX';
		
		
		String sql = "UPDATE MEMBER SET USERPWD = ?, EMAIL =  ?, PHONE = ?, ADDRESS = ? WHERE USERID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserPwd()); 
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return result;
	}

	public int deleteMember(String userId) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return result;
	}
	
	

//	public int insertMember(Member m) {
//		
//		int result = 0;
//		Connection conn = null;
//		Statement stmt = null;
//		
//		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL,"
//                + "'" + m.getUserId() + "',"
//                + "'" + m.getUserPwd() + "',"
//                + "'" + m.getUserName() + "',"
//                + "'" + m.getGender() + "',"
//                     + m.getAge() + ","
//                 + "'" + m.getEmail() + "',"
//                 + "'" + m.getPhone() + "',"
//                 + "'" + m.getAddress() + "',"
//                 + "'" + m.getHobby() + "', SYSDATE)";
//		
//		try {
//		
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
//			
//			stmt = conn.createStatement();
//			
//			result = stmt.executeUpdate(sql);
//			
//			if(result > 0) {
//				conn.commit();
//			} else {
//				conn.rollback();
//			}
//					
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				stmt.close();
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		
//		return result;
//	}
//
//	public ArrayList<Member> selectAll() {
//		
//		ArrayList<Member> list = new ArrayList<>();
//		
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rset = null;
//		
//		String sql = "SELECT * FROM MEMBER";
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
//			
//			stmt = conn.createStatement();
//			
//			rset = stmt.executeQuery(sql);
//			
//			while(rset.next()) {
//				
//				Member m = new Member();
//				
//				m.setUserNo(rset.getInt("USERNO")); 
//				m.setUserId(rset.getString("USERID"));
//				m.setUserPwd(rset.getString("USERPWD"));
//				m.setUserName(rset.getString("USERNAME"));
//				m.setGender(rset.getString("GENDER"));
//				m.setAge(rset.getInt("AGE"));
//				m.setEmail(rset.getString("EMAIL"));
//				m.setPhone(rset.getString("PHONE"));
//				m.setAddress(rset.getString("ADDRESS"));
//				m.setHobby(rset.getString("HOBBY"));
//				m.setEnrollDate(rset.getDate("ENROLLDATE"));
//				
//				list.add(m);
//			}
//		
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				rset.close();
//				stmt.close();
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		
//		return list;
//	}

}
