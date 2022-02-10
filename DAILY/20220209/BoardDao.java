package com.kh.mybatis.board.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;

public class BoardDao {
	
	public int selectListCount(SqlSession sqlSession) {
		return sqlSession.selectOne("boardMapper.selectListCount");
	}

	public ArrayList<Board> selectList(SqlSession sqlSession, PageInfo pi) {
		
		//마이바티스에서는 페이징처리를 위해 RowBounds라는 클래스를 제공한다.
		
		/*
		 * ex) boardLimit == 5
		 * 
		 * offset : 몇개의 게시글을 건너뛰고 조회할 건지에 대한 값
		 * 							offset(건너뛸숫자)	  limit(조회할숫자)
		 * currentPage : 1 => 1~5			0				5
		 * currentPage : 2 => 6~10			5				5
		 * currentPage : 3 => 11~14			10				5
		 * ......
		 * 
		 * 
		 * */
		
		int limit = pi.getBoardLimit();
		int offset = (pi.getCurrentPage() -1 ) * limit;
		
		RowBounds rowBounds = new RowBounds(offset, limit);
		
//		RowBounds 객체를 넘겨야 할 경우
//		selectList메소드의 오버로딩된 형태로 매개변수가 3개인 메소드를 사용해야만 하기 때문
//		딱히 두번째 매개변수자리에 넘길 값이 없다면 null을 넘기면 됨
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectList", null, rowBounds);
		
		
	}

}
