package com.kh.mybatis.member.model.service;

import com.kh.mybatis.member.model.vo.Member;

// 인터페이스 : 상수필드(public static final) + 추상메소드(public abstract)
public interface MemberService {
	
	
	// 회원가입용 메소드
	int insertMember(Member m);
	// 로그인
	Member loginMember(Member m);
	// 회원정보 수정
	int updateMember(Member m);
	// 회원 탈퇴
	int deleteMember(Member m);
	
	
}
