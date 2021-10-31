package com.mira.study.run;


import com.mira.study.contriller.CosmeticController1;
import com.mira.study.contriller.CosmeticController2;
import com.mira.study.model.vo.Cosmetic;
import com.mira.study.model.vo.Foundation;
import com.mira.study.model.vo.Lipstick;
import com.mira.study.model.vo.Shadow;

public class Run {
	
	public static void main(String[] args) {

		
//		//	1. 다형성 적용을 안했을 경우
//		CosmeticController1 cc1 = new CosmeticController1();
//		
//		//객체생성 + 초기화
//		//값을 넣어주자
//		cc1.insert(new Foundation("파파데데", "파데", 35000, true));
//		cc1.insert(new Lipstick("리리", "립스틱", 3000, true));
//		cc1.insert(new Shadow("쉐쉐", "섀도우", 18000, true));
//		
//		
//		//가게에 있는 제품을 조회
//		Foundation fo = cc1.selcetFoundation();
//		Lipstick li = cc1.selectLipstick();
//		Shadow sh = cc1.selectShadow();
//		
//		System.out.println(fo);
////		파파데데파데35000true
//		System.out.println(li);
////		리리립스틱3000true
//		System.out.println(sh);
////		쉐쉐섀도우18000browntrue
//		
		
		
		
//		2. 다형성 적용
		//객체생성
		CosmeticController2 cc2 = new CosmeticController2();
		
		
//		public void insert(Cosmetic any, int i) {
//			this.cos[i] = any;
//		}
//		
									//이 모든게 any
		cc2.insert(new Foundation("파파데데", "파데", 38000, 1), 0);
		cc2.insert(new Lipstick("리리스스", "립스틱", 28000, 1), 1);
		cc2.insert(new Shadow("쉐쉐", "섀도우", 25000, 1), 2);
		


		//재고 하나를 조회해주는 메소드
//		public Cosmetic select(int i) {
//			return cos[i];
//		}
		Foundation fou = (Foundation)cc2.select(0);
		Lipstick lip = (Lipstick)cc2.select(1);
		Shadow sha = (Shadow)cc2.select(2);
		
		System.out.println(fou);
//		파파데데파데38000true
		System.out.println(lip);
//		리리스스립스틱28000true
		System.out.println(sha);
//		쉐쉐섀도우25000browntrue
		
		//재고 전체를 조회해주는 메소드
//		public Cosmetic[] selectAll() {
//			return cos;
//		}
		Cosmetic[] cos = cc2.selectAll();
		for(int i = 0; i < 3; i++) {
			System.out.println(cos[i]);
		}
		
		
	}
	
	
	
	
}
	