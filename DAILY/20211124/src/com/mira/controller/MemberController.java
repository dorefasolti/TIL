package com.mira.controller;

import java.util.ArrayList;

import com.kh.model.vo.Member;
import com.kh.view.MemberView;
import com.mira.model.dao.MemberDao;

public class MemberController {

	public void insertMember(String userId, String userPwd, String userName, String gender, int age, String email,
			String phone, String address, String hobby) {
		
//		ArrayList<Member> m = new ArrayList<>();
		
//		m.add(new Member(userId, userPwd, userName, gender, age, email, phone, address, hobby));
		
		//1. 전달된 데이터들을 Member 객체에 담기 => 가공처리
		Member m = new Member(userId, userPwd, userName, gender, age, email, phone, address, hobby);
		
		
		//2. Dao의 insertMember 메소드 호출
		int result = new MemberDao().insertMember(m);
		
		
		//3. 결과값에 따라서 사용자가 보게 될 화면 지정
		if(result > 0) {//성공했을 경우
			new MemberView().displaySuccess("회원 추가 성공"); //성공메시지를 띄워주는 화면 호출
		} else {//실패했을 경우
			new MemberView().displayFail("회원 추가 실패"); //실패메시지를 띄워주는 화면 호출
		}
	
	
	}

	public void selectAll() {
		ArrayList<Member> list = new MemberDao().selectAll();
		
		if(list.isEmpty()) {
			new MemberView().displayNodate("전체 조회 결과가 없습니다");
		} else {
			new MemberView().displayList(list);
		}
		
		
	}

	public void searchUserId(String userId) {
		Member m = new MemberDao().searchUserId(userId);
		
		if(m == null) {
			new MemberView().displayNodate(userId + "해당 검색 결과가 없습니다.");
		} else {
			new MemberView().displayOne(m);
		}
	}



	public void updateMember(String userId, String newPwd, String newEmail, String newPhone, String newAddress) {
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(newPwd);
		m.setEmail(newEmail);
		m.setPhone(newPhone);
		m.setAddress(newAddress);
		
		int result = new MemberDao().updateMember(m);
		
		if(result > 0) {
			new MemberView().displaySuccess("회원 정보 변경 성공");
			
		} else {
			new MemberView().displayFail("회원 정보 변경 실패");
		}
	}

	public void deleteMembeR(String userId) {
		int result = new MemberDao().deleteMember(userId);
		
		if(result > 0) {
			new MemberView().displaySuccess("회원 탈퇴 성공");
			
		} else {
			new MemberView().displayFail("회원 탈퇴 실패");
		}
	}

}
