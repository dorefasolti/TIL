package controller;

import java.util.ArrayList;

import model.dao.Dao;
import model.vo.Member;

public class Controller {
	Dao d = new Dao();
	
	
	public void insert(String userId, String userPwd, String userName, String phone, String address) {
		Member m = new Member(userId, userPwd, userName, phone, address);
		
		int result = d.insert(m);
		
		if(result > 0) {
			System.out.println("추가성공");
		} else {
			System.out.println("추가 실패");
		}
	}


	public void all() {
		ArrayList<Member> list = new ArrayList<>();
		
		list = d.all();
		
		if(list.isEmpty()) {
			System.out.println("실패");

		} else {
			System.out.println("가져왔음");
			for(int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}


	public void id(String id) {
		Member m = new Dao().id(id);
		
		if(m == null) {
			System.out.println("없다");
		} else {
			System.out.println(m);
		}
	}


	public void keyword(String keyword) {
		Member m = new Dao().keyword(keyword);
		
		if(m == null) {
			System.out.println("없다");
		} else {
			System.out.println(m);
		}
	}


	public void update(String userId, String newPwd, String newName, String newPhone, String newAddress) {
//		Member m = new Member(userId, newPwd, newName, newPhone, newAddress);
		Member m = new Member();
		
		m.setUserId(userId);
		m.setUserPwd(newPwd);
		m.setUserName(newName);
		m.setPhone(newPhone);
		m.setAddress(newAddress);
		int result = 0;
		
		result = new Dao().update(m);
		System.out.println("여기?");
		
		if(result > 0) {
			System.out.println("수정성공");
		} else {
			System.out.println("수정실패");
		}
	}


	public void delete(String userId) {
		int result = new Dao().delete(userId);
		
		if(result > 0) {
			System.out.println("삭제 성공");
		} else {
			System.out.println("삭제 실패");			
		}
		
	}

}
