package com.mira.controller;

import java.util.ArrayList;

import com.mira.model.dao.Dao;
import com.mira.model.vo.Member;
import com.mira.view.View;

public class Controller {

	public void insertMember(String userId, String userPwd, String userName, String gender, int age, String email,
			String phone, String address, String hobby) {
		
		Member m = new Member(userId, userPwd, userName, gender, age, email, phone, address, hobby);
		
		int result = new Dao().insertMember(m);
		
		if(result > 0) { 
			new View().displaySuccess("회원 추가 성공");
		} else {
			new View().displayFail("회원 추가 실패");
		}
		
	}
	
	
	public void selectAll() {
		ArrayList<Member> list = new Dao().selectAll();
		
		if(list.isEmpty()) {
			new View().displayNodate("전체 조회 결과가 없습니다.");
		} else {
			new View().displayList(list);
		}
	}


	public void selectByUserId(String userId) {
		Member m = new Dao().selectByUserId(userId);
		
		if(m == null) {
			new View().displayNodate(userId + "해당 검색 결과가 없습니다.");
		} else {
			new View().displayOne(m);
		}
	}

}
