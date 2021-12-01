package com.kh.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.model.dao.ATMDao;
import com.kh.model.vo.Owner;

public class ATMService {
	
	
		//전체 조회
		public Owner selectAll(String cardNo) {

			Connection conn = getConnection();
			Owner o = new ATMDao().seletAll(conn, cardNo);
			close(conn);
			return o;
		}  // 전체 조회 끝
		
	


	

		//입금
		public int deposit(String cardNo, int cardPwd, int cash) {  
			
			Connection conn = getConnection();
			
			int result = new ATMDao().deposit(cardNo, cardPwd, cash, conn);
			
			if(result > 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
			
			}  // 입금 끝

		
		//출금
		public int withdraw(String cardNo, int cardPwd, int cash) {
			
			int result = 0;
			
			Connection conn = getConnection();
			
			result = new ATMDao().withdraw(conn, cardNo, cardPwd, cash);
			
			if(result > 1) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		} //출금 끝
		
		
		
		// 송금
		public int sendMoney(String cardNo, int cardPwd, String sendCardNo, int cash) {
			
			Connection conn = getConnection();
			
			int result = new ATMDao().sendMoney(cardNo, cardPwd, sendCardNo, cash, conn);
			
			if(result > 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
			
		} //송금 끝

}
