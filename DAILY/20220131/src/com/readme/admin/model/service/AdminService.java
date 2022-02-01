package com.readme.admin.model.service;

import static com.readme.common.JDBCTemplate.close;
import static com.readme.common.JDBCTemplate.commit;
import static com.readme.common.JDBCTemplate.getConnection;
import static com.readme.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.readme.admin.model.dao.AdminDao;
import com.readme.admin.model.vo.Answer;
import com.readme.admin.model.vo.BookMG;
import com.readme.admin.model.vo.CategoryAd;
import com.readme.admin.model.vo.EditorAd;
import com.readme.admin.model.vo.FleaAd;
import com.readme.admin.model.vo.Notice;
import com.readme.admin.model.vo.PageInfo;
import com.readme.admin.model.vo.Request;
import com.readme.admin.model.vo.ReviewAd;
import com.readme.member.model.vo.Member;

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
	
//1:1문의  삭제
	public int deleteInquiryAnswer(ArrayList<Integer> checkNumbers) {
		Connection conn = getConnection();
		
		int result = new AdminDao().deleteInquiryAnswer(conn, checkNumbers);
		
		close(conn);
		return result;
	}

	
//----------------공지사항 -------------------------------------------------------
	
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

	
//	공지사항 검색기능 리스트카운트 조회
	public int selectNoticeListCount(String[] searchNoticeCategory, String searchNoticeKeyword) {


		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectNoticeListCount(conn, searchNoticeCategory, searchNoticeKeyword);

		close(conn);
		
		return listCount;
	}

//	공지사항 키워드 검색 결과 조회 리스트
	public ArrayList<Notice> searchNoticeKeyword(String[] searchNoticeCategory, String searchNoticeKeyword,
			PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Notice> list = new AdminDao().searchNoticeKeyword(conn, searchNoticeCategory, searchNoticeKeyword, pi);
		
		close(conn);
		return list;
	}


//공지사항 삭제
	public int deleteNotice(ArrayList<Integer> checkNumbers) {
		Connection conn = getConnection();
		
		int result = new AdminDao().deleteNotice(conn, checkNumbers);
		
		close(conn);
		return result;
	}

		
	
	
//	----------- 회원관리 -----------------
	
//회원 전체 조회를 위한 리스트 카운트
	public int selectUserManagementListcount() {
		Connection conn = getConnection();  
		
		int listCount = new AdminDao().selectUserManagementListcount(conn);
			 
		close(conn);  
		return listCount; 
	}


// 회원 전체 조회 결과 리스트
	public ArrayList<Member> selectUserManagementList(PageInfo pi) {
		Connection conn = getConnection();
		
		ArrayList<Member> list = new AdminDao().selectUserManagementList(conn, pi);
		
		close(conn);
		
		return list;
	}

//회원 키워드 검색을 위한 리스트 카운트
	public int selectUserListCount(String[] searchUserCategory, String searchUserKeyword) {
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectUserListCount(conn, searchUserCategory, searchUserKeyword);

		close(conn);
		
		return listCount;
	}

//회원 키워드 검색 결과 조회 리스트
	public ArrayList<Member> selectUserList(String[] searchUserCategory, String searchUserKeyword, PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Member> list = new AdminDao().selectUserList(conn, searchUserCategory, searchUserKeyword, pi);
		
		close(conn);
		return list;
	}

	

// 회원 삭제
	public int deleteUser(ArrayList<Integer> checkNumbers) {
		Connection conn = getConnection();
		
		int result = new AdminDao().deleteUser(conn, checkNumbers);
		
		close(conn);
		return result;
	}

	

/*-------------------메인페이지---------------------------------------------*/


//메인페이지 미답변 문의 조회
	public ArrayList<Answer> selectMainAnswerList() {
		Connection conn = getConnection();
		
		ArrayList<Answer> list = new AdminDao().selectMainAnswerList(conn);
		
		close(conn);
		
		return list;
	}
		
	
	
	
	
	//게시글 총개수 받아오는 거
	public int selectRequestListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectRequestListCount(conn);
		
		close(conn);
		
		return listCount;
	}
	//요청게시판의 페이징바
	public ArrayList<Request> AdminRequestSelectList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<Request> list = new AdminDao().AdminRequestSelectList(conn, pi);
		
		close(conn);
		
		return list;
		

	}
	//요청게시판 중 처리안한 애들 가져오는 거
	public int selectRequestNCount() {
		
		Connection conn = getConnection();
		
		int Ncount = new AdminDao().selectRequestNCount(conn);
		
		close(conn);
		
		return Ncount;
		
		
	}
	//리뷰 총 개수 알아오는 거
	public int selectReviewListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectReviewListCount(conn);
		
		close(conn);
		
		return listCount;
		
		
	}
	public ArrayList<ReviewAd> AdminUserBoardReviewSelect(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<ReviewAd> list = new AdminDao().AdminUserBoardReviewSelect(conn, pi);
		
		close(conn);
		
		return list;
		
		
	}
	public int selectBookListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectBookListCount(conn);
		
		close(conn);
		
		return listCount;

	}
	public ArrayList<BookMG> AdminBookList(PageInfo pi) {	

		Connection conn = getConnection();
		
		ArrayList<BookMG> list = new AdminDao().AdminBookList(conn, pi);
		
		close(conn);
		
		return list;
		
	
	}
	public ArrayList<CategoryAd> AdminCategory() {
		
		Connection conn = getConnection();
		
		ArrayList<CategoryAd> list = new AdminDao().AdminCategory(conn);
		
		close(conn);
		
		return list;
		
	}
	public ArrayList<BookMG> AdminCategoryBookList(PageInfo pi, int bookCategoryNo) {
		
		Connection conn = getConnection();
		
		ArrayList<BookMG> list = new AdminDao().AdminCategoryBookList(conn, pi, bookCategoryNo);
		
		close(conn);
		
		return list;
	}
	public int selectCategoryCount(int bookCategoryNo) {
		
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectCategoryCount(conn, bookCategoryNo);
		
		close(conn);
		
		return listCount;

	}
	public int selectFleaListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectFleaCount(conn);
		
		close(conn);
		
		return listCount;

	
	}
	public ArrayList<FleaAd> AdminUserBoardFleaSelect(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<FleaAd> list = new AdminDao().AdminUserBoardFleaSelect(conn, pi);
		
		close(conn);
		
		return list;
	}
	public int AdminRequestOk(int requestNo) {
		
		Connection conn = getConnection();
		
		int result = new AdminDao().AdimnRequestOk(conn, requestNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}	
		
		close(conn);
		
		return result;
	}
	
	public int selectEditorListCount() {
		
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectEditorListCount(conn);
		
		close(conn);
		
		return listCount;
		
	
	}
	public ArrayList<EditorAd> AdminEditorSelectList(PageInfo pi) {
		
		Connection conn = getConnection();
		
		ArrayList<EditorAd> list = new AdminDao().AdminEditorSelectList(conn, pi);
		
		close(conn);
		
		return list;
		
	
	}
	//에디터픽 등록!!!!!!!!!
	public int AdminEditorInput(int bookNo) {
		
		Connection conn = getConnection();
		
		int result = new AdminDao().AdminEditorInput(conn, bookNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}	
		
		close(conn);
		
		return result;
	}
	//에디터픽 해제!!!!!!!!
	public int AdminEditorOut(int bookNo) {
		
		Connection conn = getConnection();
		
		int result = new AdminDao().AdminEditorOut(conn, bookNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}	
		
		close(conn);
		
		return result;
	}
	public int selectEditorListCountAll() {
		
		Connection conn = getConnection();
		
		int listCount = new AdminDao().selectEditorListCountAll(conn);
		
		close(conn);
		
		return listCount;
		

	}
	public int deleteReview(ArrayList<Integer> checkNumbers) {
	
		Connection conn = getConnection();
	      
	      int result = new AdminDao().deleteReview(conn, checkNumbers);
	      
	      close(conn);
	      
	      return result;
	}
	public int deleteFlea(ArrayList<Integer> checkNumbers) {
		
		Connection conn = getConnection();
	      
	      int result = new AdminDao().deleteFlea(conn, checkNumbers);
	      
	      close(conn);
	    
	      return result;
		
	}


	
	
	
	
}
