package com.kh.mybatis.board.model.service;

import java.util.ArrayList;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.model.vo.PageInfo;

public interface BoardService {

	// 게시글 리스트 조회
	
	int selectCount();
	
	ArrayList<Board> selectList(PageInfo pi);
}
