package com.kh.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.vo.Member;

public class MemberDao {
	/**
	 * JDBC 용 객체
	 * - Connection : DB의 연결정보를 담고 있는 객체(ip주소, port번호, 계정명, 비밀번호)
	 * - (Prepared)Statement : 해당 DB에 SQL문을 전달하고 실행한 후 결과를 받아내는 객체
	 * - ResultSet : 만일 실행한 SQL문이 SELECT문일 경우 조회된 결과들이 담겨있는 객체
	 * 
	 * ** PreparedStatement 특징 : SQL문을 바로 실행하지 않고 잠시 보관하는 개념
	 * 			미완성된 SQL문을 먼저 전달하고 실행하기전에 완성 형태로 만든 후 실행만 하면 됨  
	 *    		미완성된 SQL문 만들기 (사용자가 입력한 값들이 들어갈 수 있는 공간을 ?(위치홀더)로 확보
	 * 			각 위치홀더에 맞는 값들을 세팅
	 * 
	 * 
	 * ** Statement(부모)와 PreparedStatement(자식) 관계
	 * * 차이점
	 * 1) Statement는 완성된 SQL문, PreparedStatement는 미완성된 SQL문
	 * 
	 * 2) Statement 객체 생성시			stmt = conn.createStatement();
	 *    PreparedStatement 객체 생성 시 pstmt = conn.prepareStatement(sql);
	 *    
	 * 3) Statement로 SQL문 실행 시 			결과 = stmt.executeXXXX(sql);
	 * PreparedStatement로 SQL문 실행 시 ?로 빈 공간을 실제 값으로 채워 준뒤 실행한다.
	 * 												pstmt.setString(?위치, 실제값);
	 * 												pstmt.setInt(?위치, 실제값);
	 * 										결과 = pstmt.executexxxx();
	 * 
	 * 
	 * ** JDBC 처리순서
	 * 1) JDBC Driver등록 : 해당 DBMS가 제공하는 클래스 등록
	 * 2) Connection 객체 생성 : 접속하고자하는 DB의 정보를 입력해서 DB에 접속하면서 생성(url, 계정, 비번)
	 * 3_1) PreparedStatement객체 생성 : Connection객체를 이용해서 생성(미완성된 SQL문을 담아서)
	 * 3_2) 현재 미완성된 SQL문을 완성형태로 채우기
	 * 						=> 미완성된 경우에만 해당 / 완성된 경우에는 생략 가능
	 * 4) SQL문 실행 : executeXXX() => sql매개변수 없음!!
	 * 				> SELECT문의 경우 : executeQuery() 메소드 호출
	 * 				> 나머지 DML문의 경우 : executeUpdate() 메소드 호출
	 * 5) 결과 받기 :
	 * 				> SELECT문의 경우 : ResultSet 객체(조회된 데이터들이 담겨있음)로 받기 => 6_1)
	 * 				> 나머지 DML문의 경우 : int형(처리된 행의 갯수)으로 받기 => 6_2)
	 * 6_1) ResultSet에 담겨있는 데이터들을 하나씩 뽑아서 VO객체에 담기(많으면 ArrayList로 관리)
	 * 6_2) 트랜잭션처리(성공이면 COMMIT, 실패면 ROLLBACK)
	 * 7) 다 쓴 JDBC용 객체들은 반드시 자원반납(close()) => 생성된 순서의 역순으로!!
	 * 8) 결과 반환 (Controller로)
	 * 			> SELECT문의 경우 6_1) 에서 만들어진 결과
	 * 			> 나머지 DML문의 경우 처리된 행의 갯수
	 */

	public int insertMember(Connection conn, Member m) {
		//INSERT문 => 처리된 행의 갯수 => dml문은 트랜잭션처리해줘야함
		//결과값이 정수형으로 돌아오기 때문에 정수형번수선언
		//0) 필요한 변수들 먼저 셋팅
		int result = 0;	//처리된 결과(행의 갯수)를 담아줄 변수
		
		
		PreparedStatement pstmt = null; //SQL문 실행 후 결과를 받기 위한 변수
		
		//실행할 SQL문(미완성된 형태로)
		String sql = "INSERT INTO MEMBER"
				+ " VALUES(SEQ_USERNO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
		
		try {
			//3-1) PreparedStatement 객체 생성(SQL문을 미리 넘겨준다)
			//conn은 이미 서비스에서 만들어서 여기로 넘어왔다
			pstmt = conn.prepareStatement(sql);
			
			//3_2 미완성된 sql문일 경우 완성시켜주기
			//pstmt.setXXX(?위치, 실제값)
			//m은 매개변수로 입력받았었다!
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());//인트!!인트!!인트!!
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());			
			
			//4, 5) DB에 완성된 SQL문을 실행 후 결과(처리된 행의 갯수)받기
			
			result = pstmt.executeUpdate();
			//이걸 사용하면! 결과값이 정수로 돌아옴, result에 담아주자
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result; //이제 커밋,롤백 해야하는데 여기서 하지 않는다..
						//conn은 서비스에서 만들었으니까..
						//결과값(정수)를 들고 서비스로 돌아가자
	}
	
	//서비스단에서 디에이오의 셀릭트올 호출하면서 conn을 같이 넘겨줬다
	public ArrayList<Member> selectAll(Connection conn) { 
		//셀렉트절사용
		//스테이트먼트 사용해서 셀렉트절 날리면, 리절트셋으로 돌아온다
		//아무것도 돌아오지 않을 수도 있지만, 엄청 많은 양의 결과가 돌아올 수도 있다
		//이걸 어레이리스트를 만들어서 담아주자
		//SELECT -> RESULTSET 형태 -> ARRAYLIST 반환
		
		//0) 필요한 변수들 셋팅
		//조회된 결과를 뽑아서 담아줄 변수 => ArrayList 생성(여러 호이ㅝㄴ의 정보, 여러 행
		ArrayList<Member> list = new ArrayList<>(); //빈 리스트 만들기
		//돌려줄 리스트 만들었고
		//실질적으로 보내고 받아올 객체가 필요하다
//		PreparedStatement, ResultSet
		
		PreparedStatement pstmt = null;
		//SQL문 실행, 결과 받을 변수
		ResultSet rset = null;
		//SELECT문이 실행된 조회결과값들이 처음 담길 객체
		
		//실행할 SQL문
		String sql = "SELECT * FROM MEMBER ORDER BY USERNO";
		//별로 채우면 연산 속도가 엄청 오래 걸림
		//실무에서는 전체 조회 할 때 하나하나에 ? 해서 출력
//		String sql = "SELECT ?"
//						+ ", ?"
//						+ ", ?"
//						+ ", ?"
//						....
//					+"FROM""
//					+	"		MEMBER";
		//장점 :  처리속도가 빠르고, 어떤 컬럼이 들어갔는지 확인할 수 있다 문제해결 시 수정이 용이하다
		//하지만 수업떄는 별로..
		//0번 끝.
		
		//1, 2번은 다른곳에소
		
		//3-1 preparedstatement 객체 생성 sql을 미리 같이 넘겨준다
		try {
			pstmt = conn.prepareStatement(sql);
			//에스큐엘익셉션 생길 수 있으므로 예외처리
		
			//3-2미완성된 sql문이라면 완성시켜주기
			//이건 미완성된 에스큐엘문이 아니라, 완성되었으니 ?가 들어가지 않았다
			//=> 생략 가능
			
			
			//sql문을 실행하고 그 결과를 받아와야한다
			//4, 5)sql문 select을 실행 후 결과(resultSet)받기
			rset = pstmt.executeQuery();
			
			//6-1)현재 조회결과가 담긴 resultset에서 한 행씩 뽑아서 vo객체에 담기
			//와일문 + 
			//rset.next() : 커서를 내린다 행이 있으면 true, 없으면 false
			while(rset.next()) {
				
				//rset의 커서 위치에 있는 데이터를 뽑아서 멤버 객체에 담기
				Member m = new Member();
				
				//rset으로부터 뭐 뽑을건지 말해줘야됨
				//rset.getInt(컬럼명, 컬럼순서) : 인트형 뽑을떄
				//rset.getString(컬럼명, 컬럼순서) : 스트링형 뽑을때
				//rset.getDate(컬럼명, 컬럼순서)Date형 뽑을 때
				//권장사항 : 컬럼명으로 쓰고, 대문자로 쓰시오
				
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
				//유저넘버, 엔롤빼고 9개만 해도 문제가 생기지는 않는다
				//우리가 11개를 가지고돌아왔는데, 9개만 넣어주면 9개만 들어갈수있다
				//나중에 뽑아보면 유저넘버랑, 엔롤데이트에 널이 들어있을 것이다
				//에러는 나지 않음! 미리 9개짜리를 만들어놨기 떄문에(매개변수 생성자)
				
				list.add(m); //리스트에 담아주자
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//7) 다 쓴 jdbc용 객체 반납(생성된 순서의 역순으로)
			//다 써서 이제 필요없는걸 닫아야함!
			JDBCTemplate.close(rset);
			//템플릿에 지금 클로즈메소드가 두개있는데 어떻게 해야 구분을 하지?
			//괄호 안에 인자값을 rset를 넣어서 오버로딩을 이용하면 된다
			JDBCTemplate.close(pstmt);
			//pstmt를 닫는 메소드를 만들지 않았는데 왜 되지?
			//pstmt가 stmt의 자식이기 때문에! 자식은 부모의 것을 이용할 수 있다!
			//상속관계! 다형성! 
			
			
		}
		
		//8) 결과 반환(조회결과들이 모두 담겨있는 리스트)
		return list;
	}



	public Member selectByUserId(Connection conn, String userId) {
		
		Member m = new Member();
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = "SELECT * FROM MEMBER WHERE USERID = ?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
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
				
				
//				m = new Member(rset.getInt("USERNO")
//						, rset.getString("USERID")
//						, rset.getString("USERPWD")
//						, rset.getString("USERNAME")
//						, rset.getString("GENDER")
//						, rset.getInt("AGE")
//						, rset.getString("EMAIL")
//						, rset.getString("PHONE")
//						, rset.getString("ADDRESS")							
//						, rset.getString("HOBBY")						
//						, rset.getDate("ENROLLDATE"));
			
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public ArrayList<Member> selectByUserName(Connection conn, String keyword) {
		ArrayList<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = "SELECT * FROM MEMBER WHERE USERNAME LIKE '%' || ? || '%' ORDER BY USERNO";
		
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
			//여기서 이거, conn을 하지 않는 이유 => 템플릿에 저장해놨고,
			//컨트롤러에서 그걸 호출한다음에 여기에 conn을 넘겨줬기 떄문
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Member(rset.getInt("USERNO")
						, rset.getString("USERID")
						, rset.getString("USERPWD")
						, rset.getString("USERNAME")
						, rset.getString("GENDER")
						, rset.getInt("AGE")
						, rset.getString("EMAIL")
						, rset.getString("PHONE")
						, rset.getString("ADDRESS")
						, rset.getString("HOBBY")
						, rset.getDate("ENROLLDATE")));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		return list;
		
	}

	public int updateMember(Connection conn, Member m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MEMBER SET USERPWD = ?, EMAIL = ?, PHONE = ?, ADDRESS = ? WHERE USERID = ?";
		
//		String sql = "UPDATE MEMBER"
//			    +" SET USERPWD = ?,"
//			    +"EMAIL = ?,"
//			    +"PHONE = ?,"
//			    +"ADDRESS = ?"
//			    +" WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, m.getUserPwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getAddress());
			pstmt.setString(5, m.getUserId());
//			pstmt.setString(5, "USERID");
			//이렇게!!!!쓰는거!!!!!!!!아니라고!!!!!!!!!그러면!!!!!!!
//			USERID = USERID 이렇게 들어간다고!!!!!!!!!!!
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String userId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
