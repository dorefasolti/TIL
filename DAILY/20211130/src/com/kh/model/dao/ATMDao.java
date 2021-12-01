package com.kh.model.dao;
import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.model.vo.Owner;
public class ATMDao {
	
	
	public Owner seletAll(Connection conn, String cardNo) {
			
			Owner o = null;
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = "SELECT * FROM MEMBER WHERE CARD_NO = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cardNo);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					 o = new Owner(rset.getString("CARD_NO") 
							 		,rset.getString("CARD_OWNER")
							 		,rset.getInt("BALANCE"));
							 }
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(rset);
				close(pstmt);
			}
			return o;
			
		}
		
	
	public int deposit(String cardNo, int cardPwd, int cash, Connection conn) {
			
		int result = 0;
		int result2 = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET BALANCE = (BALANCE + ?) WHERE CARD_NO = ? AND CARD_PWD = ?";
		String sql2 = "UPDATE ATM SET ATM_MONEY = (ATM_MONEY + ?)";
			
		try {
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setInt(1, cash);
			pstmt.setString(2, cardNo);
			pstmt.setInt(3, cardPwd);
				
			result = pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, cash);
			result2 = result + pstmt.executeUpdate();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result2;
	}   // 입금 끝
	
	
	
	
	public int withdraw(Connection conn, String cardNo, int cardPwd, int cash) {
		
		int result = 0;
		int result2 = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET BALANCE = (BALANCE - ?) WHERE CARD_NO = ? AND CARD_PWD = ?";
		String sql2 = "UPDATE ATM SET ATM_MONEY = (ATM_MONEY - ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cash);
			pstmt.setString(2, cardNo);
			pstmt.setInt(3, cardPwd);
			
			result = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, cash);
			result2 = result + pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result2;
	} //출금 끝
	
	public int sendMoney(String cardNo, int cardPwd, String sendCardNo, int cash, Connection conn) {
		
		int result = 0;
		int result2 = 0;
		PreparedStatement pstmt = null;
		String sql = "UPDATE MEMBER SET BALANCE = (BALANCE - ?) WHERE CARD_NO = ? AND CARD_PWD = ?";
		String sql2 = "UPDATE MEMBER SET BALANCE = (BALANCE + ?) WHERE CARD_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, cash);
			pstmt.setString(2, cardNo);
			pstmt.setInt(3, cardPwd);
			
			result = pstmt.executeUpdate();
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, cash);
			pstmt.setString(2, sendCardNo);
			result2 = result + pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result2;

	}   // 송금 끝

}
