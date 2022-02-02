package com.readme.event.model.dao;

import static com.readme.common.JDBCTemplate.close;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.readme.event.model.vo.Event;

public class EventDao {
	
	private Properties prop = new Properties();
	
	public EventDao() {
		
		String fileName = EventDao.class.getResource("/sql/event/event-mapper.xml").getPath();

		try {
			prop.loadFromXML(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int updateAddDate(Connection conn, int userNo) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAddDate");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNo);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Event> selectMemberReviewCount(Connection conn) {
		
		ArrayList<Event> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectMemberReviewCount");
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Event e = new Event();
				e.setUserId(rset.getString("USER_ID"));
				e.setReviewCount(rset.getInt("REVIEW_COUNT"));
				
				list.add(e);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public int selectReviewCountList(Connection conn) {
	    // SELECT -> ResultSet => 근데 우리가 지금 필요한건 총 게시글의 갯수 ???
        // SELECT문을 쓰지만 상식적으로 반환되는 값이 정수가 필요함
        // 변수
        int listCount = 0;
     
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        
        String sql = prop.getProperty("selectReviewCountList");
        
        try {
           pstmt = conn.prepareStatement(sql);
      
           rset = pstmt.executeQuery();
           
           if(rset.next()) {
              listCount = rset.getInt("COUNT");   // COUNT로 빼내기 위해서 DB에다가 별명 설정해준거임!
           }
        } catch (SQLException e) {
           e.printStackTrace();
        }finally {
           close(rset);
           close(pstmt);
        }
        
        return listCount;
	}

	public int point(Connection conn, String userId, String userPwd) {
		   int result = 0;
		      PreparedStatement pstmt = null;
		      
		      String sql = prop.getProperty("point");
		      
		      try {
		         pstmt = conn.prepareStatement(sql);
		         
		         pstmt.setString(1, userId);
		         pstmt.setString(2, userPwd);
		         
		         result = pstmt.executeUpdate();
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } finally {
		         close(pstmt);
		      }
		      
		      return result;
	}


}
