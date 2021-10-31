package com.mira.study.contriller;

import com.mira.study.model.vo.Cosmetic;

//다형성 적용
public class CosmeticController2 {
	//필드부
	private Cosmetic[] cos = new Cosmetic[3];
//			코스메틱형 배열
	//메소드부
	
	public void insert(Cosmetic any, int i) {
		this.cos[i] = any;
	}
	
	
	//재고 하나를 조회해주는 메소드
	public Cosmetic select(int i) {
		return cos[i];
	}
	
	//재고 전체를 조회해주는 메소드
	public Cosmetic[] selectAll() {
		return cos;
	}
}
