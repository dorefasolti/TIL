package com.readme.member.model.service;

import static com.readme.common.JDBCTemplate.close;
import static com.readme.common.JDBCTemplate.commit;
import static com.readme.common.JDBCTemplate.getConnection;
import static com.readme.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.readme.member.model.dao.MemberDao;
import com.readme.member.model.vo.Member;

public class MemberService {

	public Member loginMember(String userId, String userPwd) {
		
		Connection conn = getConnection();
		
		Member m = new MemberDao().loginMember(conn, userId, userPwd);
		
		close(conn);
		
		return m;
	}

	public int insertMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public Member updateMember(Member m) {
		Connection conn = getConnection();


		
		int result = 0;

		result = new MemberDao().updateMember(conn, m);			

		
		Member updateMem = null;
		
		if(result > 0) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, m.getUserId());
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem;
	}

	public Member updatePwdMember(String userId, String userPwd, String updatePwd) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updatePwdMember(conn, userId, userPwd, updatePwd);
		
		Member updateMem = null;
		
		if(result > 0) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, userId);
		} else {
			rollback(conn);
		}
			close(conn);
		
		return updateMem;
	}
	
	/*은비 구역------------------------------------------------------------------*/
	public String idSearchMember(String email) {
		
		Connection conn = getConnection();
		
		String result = new MemberDao().idSearchMember(conn, email);
		
		close(conn);
		
		return result;
	}

	public int pwdResetMember(String userId, String email, String changePwd1) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao().pwdResetMember(conn, userId, email, changePwd1);
		
		if(result>0) {
			commit(conn);//갱신된 회원 객체 받아올 필요 없지...?요  일단 이렇게 둠
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int idCheck(String checkId) {

		Connection conn = getConnection();
		
		int count = new MemberDao().idCheck(conn, checkId);
		
		close(conn);
		
		return count;
	}

	public int emailCheck(String email) {
		
		Connection conn = getConnection();
		
		int count = new MemberDao().emailCheck(conn, email);
		
		close(conn);
		
		return count;
	}

	public String memberLogin(String userId) {
		
		Connection conn = getConnection();
		
		String result = new MemberDao().memberLogin(conn, userId);
		
		close(conn);
		
		return result;
		
	
	}

	public int deleteMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}


	

}
