package com.kh.member.model.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {
	public Member loginMember(String userId, String userPwd) {
//		Service = Connection 객체 
		
//		1) Connection 객체 생성
		Connection conn = JDBCTemplate.getConnection();
		
//		2) Dao에 요청
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		
//		3) Connection 객체 반납
		JDBCTemplate.close(conn);
		
//		4) Controller로 결과 넘기기
		return m;
		
	}

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().insertMemberDao(conn, m);
		// 성공했으면 1, 실패했으면 0
		if(result > 0) { //0보다 크다 == 0이 아니다 == 성공했다
			JDBCTemplate.commit(conn);
		} else { //0이다 == 실패했다
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	

}
