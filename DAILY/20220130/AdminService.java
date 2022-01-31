package com.readme.admin.model.service;

import static com.readme.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.readme.admin.model.dao.AdminDao;
import com.readme.admin.model.vo.Answer;
import com.readme.member.model.vo.Member;
import com.readme.admin.model.vo.Notice;
import com.readme.admin.model.vo.PageInfo;
import com.readme.member.model.dao.MemberDao;

public class AdminService {

//1:1문의답변 페이지에 들어갔을 때 보여줄 리스트 조회를 위함
	public ArrayList<Answer> selectAnswerList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Answer> list = new AdminDao().selectAnswerList(conn, pi);
		
		close(conn);
		
		return list;
	}

// 1:1 문의 답변 등록
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

// 1:1문의 페이지에 들어갔을 때 페이징바를 위한 리스트카운트
	
	  public int selectAnswerListCount() { 
		  
		  Connection conn = getConnection();
	 
		  int listCount = new AdminDao().selectAnswerListCount(conn);
		 
		  close(conn);
		 
		  
		  return listCount; 
	  }
	 
	
//1:1문의 검색에서 사용할 리스트카운트(페이징바) 
	public int selectAnswerListCount(String[] searchAnswerCategory, String searchAnswerKeyword) {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectAnswerListCount(conn, searchAnswerCategory, searchAnswerKeyword);
		
		close(conn);
		
		
		return listCount;
	}

// 1:1 문의 키워드 검색 리스트뽑아오기
	public ArrayList<Answer> searchAnswerKeyword(String[] searchAnswerCategory, String searchAnswerKeyword, PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Answer> list = new AdminDao().searchAnswerKeyword(conn, searchAnswerCategory, searchAnswerKeyword, pi);
		
		close(conn);
		return list;
	}

//공지사항 페이지 들어갔을 때 보일 페이징바 위한 리스트카운트
	public int selectNoticeListCount() {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectNoticListCount(conn);
		
		close(conn);
		
		 
		return listCount;
	}

// 공지사항 리스트 조회(페이지 들어갔을 때 뿌려줄 용도)
	public ArrayList<Notice> selectNoticeList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new AdminDao().selectNoticeList(conn, pi);
		
		close(conn);
		
		return list;
	}
	
	
// 공지사항 수정
	public int updateNotice(int nno, String nTitle, String nContent) {
		System.out.println(nTitle);
		
		Connection conn = getConnection();
		
		int result = new AdminDao().updateNotice(conn, nno, nTitle, nContent);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	
//	공지사항 작성
	public int insertNotice(int nWriter, String nTitle, String nContent) {
		Connection conn = getConnection();
		int result = new AdminDao().insertNotice(conn, nWriter, nTitle, nContent);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	
//	검색기능 리스트카운트 조회
	public int selectNoticeListCount(String[] searchNoticeCategory, String searchNoticeKeyword) {


		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectNoticeListCount(conn, searchNoticeCategory, searchNoticeKeyword);

		close(conn);
		
		return listCount;
	}

//	키워드 검색 결과 조회 리스트
	public ArrayList<Notice> searchNoticeKeyword(String[] searchNoticeCategory, String searchNoticeKeyword,
			PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Notice> list = new AdminDao().searchNoticeKeyword(conn, searchNoticeCategory, searchNoticeKeyword, pi);
		
		close(conn);
		return list;
	}

	public int selectUserManagementListcount() {
		Connection conn = getConnection();  
		
		int listCount = new AdminDao().selectUserManagementListcount(conn);
			 
		close(conn);  
		return listCount; 
	}

	public ArrayList<Member> selectUserManagementList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Member> list = new AdminDao().selectUserManagementList(conn, pi);
		
		close(conn);
		
		return list;
	}
		


	
	
	
	
}
