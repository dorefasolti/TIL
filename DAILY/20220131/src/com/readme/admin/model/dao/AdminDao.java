package com.readme.admin.model.dao;
import static com.readme.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.readme.admin.model.vo.Answer;
import com.readme.admin.model.vo.BookMG;
import com.readme.admin.model.vo.CategoryAd;
import com.readme.admin.model.vo.EditorAd;
import com.readme.admin.model.vo.FleaAd;
import com.readme.admin.model.vo.Notice;
import com.readme.admin.model.vo.PageInfo;
import com.readme.admin.model.vo.Request;
import com.readme.admin.model.vo.ReviewAd;
import com.readme.member.model.dao.MemberDao;
import com.readme.member.model.vo.Member;

public class AdminDao {
	private Properties prop = new Properties();
	
	public AdminDao() {
		String fileName = MemberDao.class.getResource("/sql/admin/admin-mapper.xml").getPath();
		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

/*--------------------------------------1:1문의답변 시작----------------------------------------------------*/	
	
// 1:1문의 페이지 페이징바를 위한 리스트 카운트 조회 
	public int selectAnswerListCount(Connection conn) {

		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAnswerListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}
		
//	1:1문의 게시글 조회
	public ArrayList<Answer> selectAnswerList(Connection conn, PageInfo pi) {
		ArrayList<Answer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectAnswerList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();

			
			while(rset.next()) {
				Answer a = new Answer(rset.getInt("Q_NO"),
										rset.getInt("Q_WRITER"),
										rset.getString("Q_TITLE"),
										rset.getString("Q_CONTENT"),
										rset.getDate("Q_DATE"),
										rset.getString("STATUS"),
										rset.getString("Q_ANSWER"),
										rset.getString("USER_ID"));
				
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

//	1:1답변 등록
	public int updateAnswer(Connection conn, int qno, String qStat, String qAnswer) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAnswer");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, qAnswer);
			pstmt.setString(2, qStat);
			pstmt.setInt(3, qno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		

		return result;
	}


// 1:1문의 키워드 검색 리스느 카운트
	public int selectAnswerListCount(Connection conn, String[] searchAnswerCategory, String searchAnswerKeyword) {
		

		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		
		String sac = "";
		String sql = "";


		for(int i = 0; i < searchAnswerCategory.length; i++) {

			sac = searchAnswerCategory[i];

		}
		
		if(sac.equals("searchQStatus")) {

			sql = prop.getProperty("searchAnswerStatusListCount");

		} else if(sac.equals("searchQTitle")) {

			sql = prop.getProperty("searchQTitleListCount");
			
		} else if(sac.equals("searchQWriter")) {

			sql = prop.getProperty("searchQWriterListCount");
			
		} else {

		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchAnswerKeyword);
			

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}


// 1:1 키워드 검색 결과 리스트 조회
	public ArrayList<Answer> searchAnswerKeyword(Connection conn, String[] searchAnswerCategory, String searchAnswerKeyword, PageInfo pi) {
		
		ArrayList<Answer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() -1;
		
		String sac = "";
		String sql = "";
		
		for(int i = 0; i < searchAnswerCategory.length; i++) {

			sac = searchAnswerCategory[i];
		}
		
		if(sac.equals("searchQStatus")) {


			sql = prop.getProperty("searchAnswerStatus");
		} else if(sac.equals("searchQTitle")) {

			sql = prop.getProperty("searchQTitle");
		} else if(sac.equals("searchQWriter")) {

			sql = prop.getProperty("searchQWriter");
		} else {

		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchAnswerKeyword);

			
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Answer a = new Answer(rset.getInt("Q_NO"),
										rset.getInt("Q_WRITER"),
										rset.getString("Q_TITLE"),
										rset.getString("Q_CONTENT"),
										rset.getDate("Q_DATE"),
										rset.getString("STATUS"),
										rset.getString("Q_ANSWER"),
										rset.getString("USER_ID"));
				
				list.add(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		

		return list ;
	}

//	1:1문의 삭제
	public int deleteInquiryAnswer(Connection conn, ArrayList<Integer> checkNumbers) {
		int result = 0;
		
		Statement stmt = null;
		
		String sql = "DELETE FROM QUESTION WHERE Q_NO = " + checkNumbers.get(0);
		
		for(int i = 1; i < checkNumbers.size(); i++) {
			sql += " or Q_NO = " + checkNumbers.get(i);
		}
		

		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		
		return result;
	}

	
	
	
/*--------------------------------------공지사항관리 시작----------------------------------------------------*/	
	
//	공지사항 리스트카운트
	public int selectNoticListCount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		return listCount;
	}


// 공지사항 리스트 조회
	public ArrayList<Notice> selectNoticeList(Connection conn, PageInfo pi) {

		ArrayList<Notice> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice(rset.getInt("NOTICE_NO"),
										rset.getInt("NOTICE_WRITER"),
										rset.getString("NOTICE_TITLE"),
										rset.getString("NOTICE_CONTENT"),
										rset.getDate("NOTICE_DATE"),
										rset.getInt("COUNT"),
										rset.getString("COUNT"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		
		
		return list;
	}

//공지사항 수정
	public int updateNotice(Connection conn, int nno, String nTitle, String nContent) {
		int result = 0;

		
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("updateNotice");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, nTitle);
			pstmt.setString(2, nContent);
			pstmt.setInt(3, nno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}

// 공지사항 등록
	public int insertNotice(Connection conn, int nWriter, String nTitle, String nContent) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertNotice");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, nWriter);
			pstmt.setString(2, nTitle);
			pstmt.setString(3, nTitle);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}

		return result;
	}


	
//공지사항 검색 리스트카운트 조회
	public int selectNoticeListCount(Connection conn, String[] searchNoticeCategory,
			String searchNoticeKeyword) {
		
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectNoticeListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchNoticeKeyword);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		

		return listCount;
	}

//공지사항 키워드 검색 결과 리스트 조회
	public ArrayList<Notice> searchNoticeKeyword(Connection conn, String[] searchNoticeCategory, String searchNoticeKeyword, PageInfo pi) {
		
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() -1;
		
		String sql = prop.getProperty("searchNoticeKeyword");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchNoticeKeyword);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice(rset.getInt("NOTICE_NO"),
									rset.getInt("NOTICE_WRITER"),
									rset.getString("NOTICE_TITLE"),
									rset.getString("NOTICE_CONTENT"),
									rset.getDate("NOTICE_DATE"),
									rset.getInt("COUNT"),
									rset.getString("STATUS"));
						
				list.add(n);
			}
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		

		
		return list;
	}

//	공지사항 삭제
	public int deleteNotice(Connection conn, ArrayList<Integer> checkNumbers) {
		int result = 0;
		
		Statement stmt = null;
		
		String sql = "DELETE FROM NOTICE WHERE NOTICE_NO = " + checkNumbers.get(0);
		
		for(int i = 1; i < checkNumbers.size(); i++) {
			sql += " or NOTICE_NO = " + checkNumbers.get(i);
		}
		

		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		
		return result;
	}
	
	
	
/*--------------------------------------회원관리 시작---------------------------------------------------*/	

	
//회원 전체 조회를 위한 리스트 카운트
	public int selectUserManagementListcount(Connection conn) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUserManagementListcount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}


		return listCount;
	}

//회원 전체 조회 결과 리스트
	public ArrayList<Member> selectUserManagementList(Connection conn, PageInfo pi) {
		ArrayList<Member> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUserManagementList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member(rset.getInt("USER_NO"),
						rset.getString("USER_ID"),
						rset.getString("USER_PWD"),
						rset.getString("USER_NAME"),
						rset.getString("EMAIL"),
						rset.getString("GENDER"),
						rset.getString("BIRTH"),
						rset.getDate("ENROLL_DATE"),
						rset.getString("STATUS"),
						rset.getString("EVENT_ASSENT"),
						rset.getString("INFO_ASSENT"),
						rset.getInt("CHECK_COUNT"),
						rset.getInt("REVIEW_COUNT"),
						rset.getInt("POINT"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		

		return list;
	}


//회원 키워드 검색을 위한 리스트 카운트
	public int selectUserListCount(Connection conn, String[] searchUserCategory, String searchUserKeyword) {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String suc = "";
		String sql = "";


		for(int i = 0; i < searchUserCategory.length; i++) {

			suc = searchUserCategory[i];

		}
		
		if(suc.equals("searchUserId")) {

			sql = prop.getProperty("searchUserIdListCount");

			
		} else if(suc.equals("searchUserName")) {
			

			sql = prop.getProperty("searchUserNameListCount");
			
		} else if(suc.equals("searchUserStatus")) {

			sql = prop.getProperty("searchUserStatusListCount");
			
		} 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchUserKeyword);
			

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return listCount;
	}

	
// 회원 키워드 검색 리스트
	public ArrayList<Member> selectUserList(Connection conn, String[] searchUserCategory, String searchUserKeyword,
			PageInfo pi) {
		ArrayList<Member> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() -1;
		
		String sac = "";
		String sql = "";
		
		for(int i = 0; i < searchUserCategory.length; i++) {

			sac = searchUserCategory[i];
		}
		
		if(sac.equals("searchUserId")) {


			sql = prop.getProperty("searchUserId");
			
		} else if(sac.equals("searchUserName")) {

			sql = prop.getProperty("searchUserName");
			
		} else if(sac.equals("searchUserStatus")) {

			sql = prop.getProperty("searchUserStatus");
		} else {

		}
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchUserKeyword);

			
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = new Member(rset.getInt("USER_NO"),
						rset.getString("USER_ID"),
						rset.getString("USER_PWD"),
						rset.getString("USER_NAME"),
						rset.getString("EMAIL"),
						rset.getString("GENDER"),
						rset.getString("BIRTH"),
						rset.getDate("ENROLL_DATE"),
						rset.getString("STATUS"),
						rset.getString("EVENT_ASSENT"),
						rset.getString("INFO_ASSENT"),
						rset.getInt("CHECK_COUNT"),
						rset.getInt("REVIEW_COUNT"),
						rset.getInt("POINT"));
				list.add(m);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		

		return list ;
	}


	
//	회원 선택 삭제 * 누군가의 외래키로 사용 중일 경우 삭제 불가능 *
	public int deleteUser(Connection conn, ArrayList<Integer> checkNumbers) {
		int result = 0;
		
		Statement stmt = null;
		
		String sql = "DELETE FROM MEMBER WHERE USER_NO = " + checkNumbers.get(0);
		
		for(int i = 1; i < checkNumbers.size(); i++) {
			sql += " or user_no = " + checkNumbers.get(i);
		}
		

		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
		}
		
		
		return result;
	}





	public ArrayList<Answer> selectMainAnswerList(Connection conn) {
		ArrayList<Answer> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMainAnswerList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			

			rset = pstmt.executeQuery();

			
			while(rset.next()) {
				Answer a = new Answer(rset.getInt("Q_NO"),
										rset.getInt("Q_WRITER"),
										rset.getString("Q_TITLE"),
										rset.getString("Q_CONTENT"),
										rset.getDate("Q_DATE"),
										rset.getString("STATUS"),
										rset.getString("Q_ANSWER"),
										rset.getString("USER_ID"));
				
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	//요청게시판 게시글 총 개수 받아오는 메소드
	public int selectRequestListCount(Connection conn) {
		//SELECT해서 총 게시물 개수(정수)보내줍시당
		
		//필요변수
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectRequestListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;

	}

	public ArrayList<Request> AdminRequestSelectList(Connection conn, PageInfo pi) {
		
		//SELECT문
		ArrayList<Request> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("AdminRequestSelectList");
		
		int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
		int endRow = startRow + pi.getBoardLimit() -1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			//받아옵시당
			while(rset.next()) {
				
				list.add(new Request(rset.getInt("REQUEST_NO")
									,rset.getInt("REQUEST_WRITER")
									,rset.getString("REQUEST_TITLE")
									,rset.getString("REQUEST_CONTENT")
									,rset.getDate("REQUEST_DATE")
									,rset.getString("STATUS")
									,rset.getString("USER_ID")));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		

	}

	public int selectRequestNCount(Connection conn) {
		
		//SELECT해서 STATUS=N인 애들 총 개수 알아오기
		
				//필요변수
				int NCount = 0;
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				String sql = prop.getProperty("selectRequestNCount");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						NCount = rset.getInt("COUNT");
					}
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
				return NCount;
		
		
	
	}
	//리뷰 총 개수 알아오는 메소드
	public int selectReviewListCount(Connection conn) {
		
		//필요변수
				int listCount = 0;
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				
				String sql = prop.getProperty("selectReviewListCount");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					rset = pstmt.executeQuery();
					
					if(rset.next()) {
						listCount = rset.getInt("COUNT");
					}
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
				return listCount;

	}

	public ArrayList<ReviewAd> AdminUserBoardReviewSelect(Connection conn, PageInfo pi) {
		
		//SELECT문
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReviewAd> list = new ArrayList<>();
		
		String sql = prop.getProperty("AdminUserBoardReviewSelect");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			//가져오자,.
			
			while(rset.next()) {
				
				list.add(new ReviewAd(rset.getInt("REVIEW_NO")
									  ,rset.getString("USER_ID")
									  ,rset.getString("GNERE_NAME")
									  ,rset.getString("BOOK_TITLE")
									  ,rset.getString("REVIEW_TITLE")
									  ,rset.getDate("REVIEW_DATE")
									  ,rset.getString("STATUS")));
				
				
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}

	public int selectBookListCount(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String sql = prop.getProperty("selectBookList");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;

	}

	public ArrayList<BookMG> AdminBookList(Connection conn, PageInfo pi) {
		//SELECT
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookMG> list = new ArrayList<>();
		
		
		
		String sql = prop.getProperty("AdminBookList");
		
		try {
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				//가져오기...
				list.add(new BookMG(rset.getInt("BOOK_NO")
									,rset.getString("GNERE_NAME")
									,rset.getString("BOOK_TITLE")
									,rset.getString("BOOK_AUTHOR")
									,rset.getString("BOOK_PUBLISHER")
									,rset.getInt("COUNT")));
				
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
	
		return list;
	}

	public ArrayList<CategoryAd> AdminCategory(Connection conn) {
		//SELECT
		ArrayList<CategoryAd> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("AdminCategory");
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new CategoryAd(rset.getInt("GNERE_NO")
										,rset.getString("GNERE_NAME")));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
			
		return list;
	}

	public ArrayList<BookMG> AdminCategoryBookList(Connection conn, PageInfo pi, int bookCategoryNo) {
				//SELECT
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				ArrayList<BookMG> list = new ArrayList<>();
				int No = bookCategoryNo;
				
				
				String sql = prop.getProperty("AdminCategoryBookList");
				
				try {
					
					int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
					int endRow = startRow + pi.getBoardLimit() -1;
					
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setInt(1, No);
					pstmt.setInt(2, startRow);
					pstmt.setInt(3, endRow);
					
					rset = pstmt.executeQuery();
					
					while(rset.next()) {
						
						//가져오기...
						list.add(new BookMG(rset.getInt("BOOK_NO")
											,rset.getString("GNERE_NAME")
											,rset.getString("BOOK_TITLE")
											,rset.getString("BOOK_AUTHOR")
											,rset.getString("BOOK_PUBLISHER")
											,rset.getInt("COUNT")));
						
						
					}
				} catch (SQLException e) {
					
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
			
				return list;		
		
	
	}

	public int selectCategoryCount(Connection conn, int bookCategoryNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		int no = bookCategoryNo;
		
		String sql = prop.getProperty("selectCategoryCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,no);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;

	}

	public int selectFleaCount(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String sql = prop.getProperty("selectFleaCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return listCount;
	}

	public ArrayList<FleaAd> AdminUserBoardFleaSelect(Connection conn, PageInfo pi) {
		
		
		//SELECT문
				PreparedStatement pstmt = null;
				ResultSet rset = null;
				ArrayList<FleaAd> list = new ArrayList<>();
				
				String sql = prop.getProperty("AdminUserBoardFleaSelect");
				
				try {
					pstmt = conn.prepareStatement(sql);
					
					int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
					int endRow = startRow + pi.getBoardLimit() -1;
					
					pstmt.setInt(1, startRow);
					pstmt.setInt(2, endRow);
					
					rset = pstmt.executeQuery();
					
					//가져오자,.
					
					while(rset.next()) {
						
						list.add(new FleaAd(rset.getInt("FLEA_NO")
											  ,rset.getString("USER_ID")
											  ,rset.getDate("FLEA_DATE")
											  ,rset.getString("FLEA_TITLE")
											  ,rset.getInt("FLEA_TYPE")
											  ,rset.getString("FLEA_STATUS")));
						
						
					}
				} catch (SQLException e) {
				
					e.printStackTrace();
				}finally {
					close(rset);
					close(pstmt);
				}
				return list;
				

	}

	public int AdimnRequestOk(Connection conn, int requestNo) {
			//UPDATE
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("AdminRequestOk");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, requestNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		

		return result;
	}

	public int selectEditorListCount(Connection conn) {
	
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String sql = prop.getProperty("selectEditorListCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		
		return listCount;
	}

	public ArrayList<EditorAd> AdminEditorSelectList(Connection conn, PageInfo pi) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<EditorAd> list = new ArrayList<>();
		
	
		String sql = prop.getProperty("AdminEditorSelectList");
		
		try {
			
			int startRow = (pi.getCurrentPage() -1) * pi.getBoardLimit() + 1;
			int endRow = startRow + pi.getBoardLimit() -1;
			
			pstmt = conn.prepareStatement(sql);
			
		
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				//가져오기...
				list.add(new EditorAd(
									 rset.getInt("BOOK_NO")
									,rset.getString("GNERE_NAME")
									,rset.getString("BOOK_AUTHOR")
									,rset.getString("BOOK_PUBLISHER")
									,rset.getString("BOOK_TITLE")
									,rset.getString("BOOK_INTRO")
									,rset.getString("EDITOR_CHOICE")));
				
				
			}
			System.out.println(list);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
	
		return list;				

	}

	public int AdminEditorInput(Connection conn, int bookNo) {
		
		//UPDATE
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("AdminEditorInput");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		

		return result;
		
		
		
		
		
	}

	public int AdminEditorOut(Connection conn, int bookNo) {
		
		//UPDATE
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("AdminEditorOut");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, bookNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		

		return result;
	}

	public int selectEditorListCountAll(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int listCount = 0;
		
		String sql = prop.getProperty("selectEditorListCountAll");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				listCount = rset.getInt("COUNT");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
			
		}
		
		return listCount;

		
	}

	public int deleteReview(Connection conn, ArrayList<Integer> checkNumbers) {
	
		int result = 0;
	      
	      Statement stmt = null;
	      
	      String sql = "DELETE FROM REVIEW WHERE REVIEW_NO = " + checkNumbers.get(0);
	      
	      for(int i = 1; i < checkNumbers.size(); i++) {
	         sql += " or REVIEW_NO = " + checkNumbers.get(i);
	      }
	      

	      
	      try {
	         stmt = conn.createStatement();
	         result = stmt.executeUpdate(sql);
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(stmt);
	      }
	      
	      
	      return result;

	
	}

	public int deleteFlea(Connection conn, ArrayList<Integer> checkNumbers) {
		int result = 0;
	      
	      Statement stmt = null;
	      
	      String sql = "DELETE FROM FLEA_MARKET WHERE FLEA_NO = " + checkNumbers.get(0);
	      
	      for(int i = 1; i < checkNumbers.size(); i++) {
	         sql += " or FLEA_NO = " + checkNumbers.get(i);
	      }
	      

	      
	      try {
	         stmt = conn.createStatement();
	         result = stmt.executeUpdate(sql);
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         close(stmt);
	      }
	      
	      
	      return result;
	}
	


	
	
	
	
}
