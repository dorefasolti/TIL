package com.readme.admin.model.service;

import static com.readme.common.JDBCTemplate.*;
import static com.readme.common.JDBCTemplate.commit;
import static com.readme.common.JDBCTemplate.getConnection;
import static com.readme.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.readme.admin.model.dao.AdminDao;
import com.readme.admin.model.vo.Answer;
import com.readme.admin.model.vo.PageInfo;
import com.readme.member.model.dao.MemberDao;

public class AdminService {

	public ArrayList<Answer> selectAnswerList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Answer> list = new AdminDao().selectAnswerList(conn, pi);
		
		close(conn);
		
		return list;
	}

	public int updateAnswer(int qno, String qStat, String qAnswer) {
		Connection conn = getConnection();
		
		int result = new AdminDao().updateAnswer(conn, qno, qStat, qAnswer);
		
		Answer updateAnswer = null;
		
		if(result > 0) {
			commit(conn);

		} else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	}

	public int selectAnswerListCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectAnswerListCount(conn);
		
		close(conn);
		
		
		return listCount;
	}
	public int selectAnswerListCount(String[] searchAnswerCategory, String searchAnswerKeyword) {
		System.out.println("서비스로넘어옴?");
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectAnswerListCount(conn, searchAnswerCategory, searchAnswerKeyword);
		
		close(conn);
		
		
		return listCount;
	}

	public ArrayList<Answer> searchAnswerKeyword(String[] searchAnswerCategory, String searchAnswerKeyword, PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Answer> list = new AdminDao().searchAnswerKeyword(conn, searchAnswerCategory, searchAnswerKeyword, pi);
		
		close(conn);
		return list;
	}




	
	
	
	
}
