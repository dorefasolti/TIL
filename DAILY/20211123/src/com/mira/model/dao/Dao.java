package com.mira.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mira.model.vo.Member;

public class Dao {

	public int insertMember(Member m) {
		int result = 0;
		Connection conn = null;
		Statement stmt = null;
		
		String sql = "INSERT INTO POSTPRACTICE VALUES(SEQ_USERNO.NEXTVAL,"
						+ "'" + m.getUserId() + "',"
						+ "'" + m.getUserPwd() + "',"
						+ "'" + m.getUserName() + "',"
						+ "'" + m.getGender() + "',"
							+ m.getAge() + ","
						+ "'" + m.getEmail() + "',"
						+ "'" + m.getPhone() + "',"
						+ "'" + m.getAddress() + "',"
						+ "'" + m.getHobby() + "', SYSDATE)";
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
		
			stmt = conn.createStatement();
			
			result = stmt.executeUpdate(sql);
			
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public ArrayList<Member> selectAll() {
		
		ArrayList<Member> list = new ArrayList<>();	
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM POSTPRACTICE";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(sql);
			
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return list;
	}

	public Member selectByUserId(String userId) {

		Member m = null;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = "SELECT * FROM POSTPRACTICE WHERE USERID = '" + userId + "'";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "JDBC", "JDBC");
			
			stmt = conn.createStatement();
			rset = stmt.executeQuery(sql);
			
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
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return m;
	}



}
