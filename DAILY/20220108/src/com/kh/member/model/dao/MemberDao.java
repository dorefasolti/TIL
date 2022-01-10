package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;

public class MemberDao {
	private Properties prop = new Properties();
	
	
	public MemberDao() {
		
		String fileName = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
		
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Member loginMember(Connection conn, String userId, String userPwd) {
//		SELECT문 => ResultSet객체(unique key조건에 의해한 행만 조회됨) => Member
		
//		필요한 변수 
		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("loginMember");
		
		try {
//		pstm	t 객체 생성
			pstmt = conn.prepareStatement(sql);
	//		구멍메꾸기	
	//		pstmt.setString(1, 사용자가 입력한 아이디값);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
	//		쿼리문 실행 결과 받기
//			쿼리문 실행 메소드
//			pstmt.executeQuery(); => SELECT
//			pstmt.executeUpdate() => INSERT/UPDATE/DELETE
			rset = pstmt.executeQuery();
			
//			rset으로부터 각각의 컬럼값을 뽑아서 Member객체 담는다.
//			rset.next()
//			조회결과가 여러행일 때 => while(rest.next())
//			조회결과가 한 행일 때 => if(rset.next))
//			지금은 unique조건으로 결과가 안나오거나, 하나만 나오거나 둘 중 하나임(여러개불가능)
			
			if(rset.next()) {
//				각 컬럼의 값을 뽑기
//				rset.getInt / getString / getDate(뽑아올 컬럼명 또는 컬럼의 순번)
				
				m = new Member(rset.getInt("USER_NO")
								,rset.getString("USER_ID")
								,rset.getString("USER_PWD")
								,rset.getString("USER_NAME")
								,rset.getString("PHONE")
								,rset.getString("EMAIL")
								,rset.getString("ADDRESS")
								,rset.getString("INTEREST")
								,rset.getDate("ENROLL_DATE")
								,rset.getDate("MODIFY_DATE")
								,rset.getString("STATUS"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			자원반납 =>  생성된 순서의 역순
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
//		Service에 결과(Member)넘기기
		return m;
		
	}

	public int insertMemberDao(Connection conn, Member m) {
		//INSERT문 => 처리된 행의 갯수
		
		//필요한 변수를 셋팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember"); // member-mapper에서 불러오는것
		
		try {
			//pstmt객체 생성(sql미리넘기기)
			pstmt = conn.prepareStatement(sql);
			
			// 빵꾸 메꾸기
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getPhone());
			pstmt.setString(5, m.getEmail());
			pstmt.setString(6, m.getAddress());
			pstmt.setString(7, m.getInterest());
			
			//SQL 실행 및 결과 받기
			//select => pstmt.executeQuery();
			//insert/update/delete=>pstmt.executeUpdate();
			//프리페어드니까 괄호 안에 sql넣지말기 위에서 이미 채웠음
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//자원반납
			JDBCTemplate.close(conn);
		}
		//결과리턴
		return result;
		
		
	}

	
}
