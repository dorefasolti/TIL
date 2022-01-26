package com.readme.member.model.service;

import static com.readme.common.JDBCTemplate.*;

import java.sql.Connection;

import com.readme.common.JDBCTemplate;
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

	public int updateMember(Member m) {
		Connection conn = getConnection();

		int result = new MemberDao().updateMember(conn, m);
		Member updateMem = null;
		
		if(result > 0) {
			commit(conn);
			updateMem = new MemberDao().selectMember(conn, m.getUserId());
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		System.out.println(result);
		return result;
	}
	
	

}
