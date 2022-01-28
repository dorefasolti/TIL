package com.readme.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.readme.member.model.vo.Member;
import static com.readme.common.JDBCTemplate.*;

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

		Member m = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String sql = prop.getProperty("loginMember");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);

			rset = pstmt.executeQuery();

			if (rset.next()) {
				m = new Member(rset.getInt("USER_NO"), rset.getString("USER_ID"), rset.getString("USER_PWD"),
						rset.getString("USER_NAME"), rset.getString("EMAIL"), rset.getString("GENDER"),
						rset.getString("BIRTH"), rset.getDate("ENROLL_DATE"), rset.getString("STATUS"),
						rset.getString("EVENT_ASSENT"), rset.getString("INFO_ASSENT"), rset.getInt("CHECK_COUNT"),
						rset.getInt("REVIEW_COUNT"), rset.getInt("POINT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return m;
	}

	public int insertMember(Connection conn, Member m) {

		int result = 0;
		PreparedStatement pstmt = null;

		String sql = prop.getProperty("insertMember");

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getGender());
			pstmt.setString(6, m.getBirth());
			pstmt.setString(7, m.getEventAssent());
			pstmt.setString(8, m.getInfoAssent());

//			System.out.println(m);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}
	

	public int updateMember(Connection conn, Member m) {

		int result = 0;
		PreparedStatement pstmt = null;

		
		
		String sql = prop.getProperty("updateMember");

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getGender());
			pstmt.setString(4, m.getBirth());
			pstmt.setString(5, m.getEventAssent());
			pstmt.setString(6, m.getInfoAssent());
			
			pstmt.setString(7, m.getUserId());
			


			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

	public Member selectMember(Connection conn, String userId) {
		Member m = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member(rset.getInt("USER_NO"),
								rset.getString("USER_ID"),
								rset.getString("USER_PWD"),
								rset.getString("USER_NAME"),
								rset.getString("EMAIL"),
								rset.getString("GENDER"),
								rset.getString("BIRTH"),
								rset.getDate("ENROLL_DATE"),
								rset.getString("STATUS"),
								rset.getString("EVENT_ASSENT"),
								rset.getString("INFO_ASSENT"),
								rset.getInt("CHECK_COUNT"),
								rset.getInt("REVIEW_COUNT"),
								rset.getInt("POINT"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return m;
	}

	public int updatePwdMember(Connection conn, String userId, String userPwd, String updatePwd) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updatePwdMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, updatePwd);
			pstmt.setString(2, userPwd);
			pstmt.setString(3, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	/*은비 구역------------------------------------------------------------------*/

	public String idSearchMember(Connection conn, String email) {
		
		//SELECT문 -- ResultSet
		
		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idSearchMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			//실행 후 결과 받기
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				result = rset.getString("USER_ID");
			}
			
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int pwdResetMember(Connection conn, String userId, String email, String changePwd1) {
		
		//UPDATE문 => 처리된 행의 개수
		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("pwdResetMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, changePwd1);
			pstmt.setString(2, userId);
			pstmt.setString(3, email);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public int idCheck(Connection conn, String checkId) {
		//SELECT => ResultSet -> COUNT 함수 이용(숫자 한 개)
		
		//변수
		int count = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idCheck");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, checkId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				count = rset.getInt("COUNT(*)");			
				
			}
		} catch (SQLException e) {		
			e.printStackTrace();
		}
		
		return count;
	}

	public int emailCheck(Connection conn, String email) {
		
		//SELECT => ResultSet -> COUNT 함수 이용(숫자 한 개)
		
				//변수
				int count = 0;
				
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				String sql = prop.getProperty("emailCheck");
				
				try {
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, email);
					
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						
						count = rset.getInt("COUNT(*)");			
						
					}
				} catch (SQLException e) {		
					e.printStackTrace();
				}
				
				return count;

	}

	public String memberLogin(Connection conn, String userId) {
		
		//SELECT문 - ResultSet
		String result = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("memberLogin");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  userId);
			
			rset = pstmt.executeQuery();

			if(rset.next()) {
				
				result = rset.getString("EMAIL");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return result;
		
	}

	public int deleteMember(Connection conn, String userId, String userPwd) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}



}
