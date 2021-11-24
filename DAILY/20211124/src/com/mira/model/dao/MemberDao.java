package com.mira.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDao {
	
	
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

			e.printStackTrace();
		} catch (SQLException e) {

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



	public int updateMember(Member m) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		
		
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
