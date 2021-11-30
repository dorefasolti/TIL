package com.mira.controller;

import com.mira.model.dao.Dao;
import com.mira.model.vo.Member;
import com.mira.view.View;

public class Controller {

	public void insert(String userId, String userPwd, String userName, String gender, int age, String email,
			String phone, String address, String hobby) {

		Member m = new Member(userId, userPwd, userName, gender, age, email, phone, address, hobby);
		
		int result = new Dao().insert(m);
		
		if(result > 0) {
			new View().Success("회원 추가 성공");
		} else {
			new View().Fail("회원 추가 불가능");
		}
	}

}
