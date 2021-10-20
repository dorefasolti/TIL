package com.mira.study;

public class ReviewBreak {
	public void method() {
		/*
		 * break;
		 * break문을 만나는 순간 가장 가까운 반복문을 빠져나감
		 * 해당 break문이 속해있는 반복문 한겹만 탈출
		 * 
		 * switch 안 break와는 다름(switch는 해당 switch문만)
		 * 
		 * return : 반복문이 아니라 메서드 자체를 나가 다시 메인함수로 돌아감
		 * 
		 * */
	
		//랜덤값을 계속 출력하고
		//랜덤값이 홀수일 경우 반복문 탈출하는 코드
		for(;;) {
			int random = (int)(Math.random() * 100) +1;
			if(random %2 == 1) {
				break;
			}else {
				System.out.println("random : " + random);
			}
		}
	
	
	
	
	
	}
}
