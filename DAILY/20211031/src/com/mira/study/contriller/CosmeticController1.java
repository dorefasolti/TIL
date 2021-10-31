package com.mira.study.contriller;

import com.mira.study.model.vo.Foundation;
import com.mira.study.model.vo.Lipstick;
import com.mira.study.model.vo.Shadow;

public class CosmeticController1 {
// 다형성 적용 전
	
	
	private Foundation fou;
	private Lipstick lip;
	private Shadow sha;
	
	//생성자부 생략됨
	
	
	//메소드
	//재고를 추가해주는 기능 오버로딩하기
	//오버로딩 : 같은 메소드명으로 여러개 but 자료형/순서/갯수가 달라야함
						//왜 이렇게 쓰냐?
						//int a라고 쓰는 방색 생각하기
						//foundation을 자료형으로 쓰는것
	public void insert(Foundation fou) {
		this.fou = fou;
	}
	
	public void insert(Lipstick lip) {
		this.lip = lip;
	}
	
	public void insert(Shadow sha) {
		this.sha = sha;
	}
	
	
	//내가 찾고있는 상품이 있는지 알려주는 기능
	//오버로딩 할 수 없다 왜? 매개변수가 없다
	
	//반환형이 파운데이션
	public Foundation selcetFoundation() {
		return fou;
	}
	
	public Lipstick selectLipstick() {
		return lip;
	}
	
	public Shadow selectShadow() {
		return sha;
	}
	
	
}
