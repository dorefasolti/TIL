package com.readme.admin.model.dao;
import static com.readme.common.JDBCTemplate.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.readme.admin.model.vo.Answer;
import com.readme.admin.model.vo.PageInfo;
import com.readme.member.model.dao.MemberDao;

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
	
	public int selectAnswerListCount(Connection conn, String[] searchAnswerCategory, String searchAnswerKeyword) {
		
		System.out.println("디에이오로넘어옴?");
		System.out.println("디에이오에 키워드가 잘 넘어왔나?:" + searchAnswerKeyword);
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		
		String sac = "";
		String sql = "";


		for(int i = 0; i < searchAnswerCategory.length; i++) {

			sac = searchAnswerCategory[i];
			System.out.println("디에이오에 어떤 카테고리가 넘어왔지?:"+sac);
		}
		
		if(sac.equals("searchQStatus")) {

			sql = prop.getProperty("searchAnswerStatusListCount");
//			System.out.println("스테이터스검색?:"+sac);
		} else if(sac.equals("searchQTitle")) {
//			System.out.println("타이틀검색?:"+sac);
			sql = prop.getProperty("searchQTitleListCount");
			
		} else if(sac.equals("searchQWriter")) {
//			System.out.println("작성자검색?:"+sac);
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
		System.out.println("dao에서 리스트카운트가 잘 나오나?"+listCount);
		return listCount;
	}


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

	
	


	
	
	
	
}
