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

	public Member updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new MemberDao().updateMember(conn, m);
		
//		System.out.println(result);
		
		//갱신된 회원 객체를 다시 조회해오기 -> 업데이트를 성공한 경우에만
		
		Member updateMem = null;
		
		if(result > 0) { //성공
			JDBCTemplate.commit(conn);
			updateMem = new MemberDao().selectMember(conn, m.getUserId());
			//성공했다면! 0, 1 인 result값이 아니라 새 메소드를 하나 만들어서 rset을 돌려준다
		
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);
		
		
		return updateMem;
	}

	public Member updatePwdMember(String userId, String userPwd, String updatePwd) {

		Connection conn = JDBCTemplate.getConnection();
		
		//비밀번호를 업데이트하는 dao메소드 호출
		int result = new MemberDao().updatePwdMember(conn, userId, userPwd, updatePwd);
		
		//호출 결과에 따라서 성공이면 commit 후에 새로 바뀐 회원의 정보를 다시 받아오겠다.
		Member updateMem = null;
		
		if(result > 0) { //성공
			JDBCTemplate.commit(conn);
			//갱신된 회원 객체를 다시 받아오기
			updateMem = new MemberDao().selectMember(conn, userId);
		} else { //실패
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		
		
		return updateMem;
	}


}
