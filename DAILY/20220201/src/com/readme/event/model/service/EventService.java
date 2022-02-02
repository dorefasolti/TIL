package com.readme.event.model.service;

import static com.readme.common.JDBCTemplate.close;
import static com.readme.common.JDBCTemplate.commit;
import static com.readme.common.JDBCTemplate.getConnection;
import static com.readme.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.readme.event.model.dao.EventDao;
import com.readme.event.model.vo.Event;
import com.readme.fleaMarket.model.dao.FleaMarketDao;
import com.readme.member.model.dao.MemberDao;

public class EventService {

	public int updateAttDate(int userNo) {
		
		Connection conn = getConnection();
		
		int result = new EventDao().updateAddDate(conn, userNo);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public ArrayList<Event> selectMemberReviewCount() {
		
		Connection conn = getConnection();
		
		ArrayList<Event> list = new EventDao().selectMemberReviewCount(conn);
		
		close(conn);
		
		return list;
	}

	public int selectReviewCountList() {
		
		Connection conn = getConnection();
		
		int listCount = new EventDao().selectReviewCountList(conn);
		// SELECT문의 결과는 ResultSet이 맞긴한데
		// 게시글에 총 갯수를 알아야하기 때문에 정수형으로 반환받는다.
		
		close(conn);
		
		
		return listCount;		// TODO Auto-generated method stub
	}
	
	public int point(String userId, String userPwd) {
		 Connection conn = getConnection();
	      
	      int result = new EventDao().point(conn, userId, userPwd);
	      
	      if(result > 0) {
	         commit(conn);
	      } else {
	         rollback(conn);
	      }
	      close(conn);
	      
	      return result;
	}

}
