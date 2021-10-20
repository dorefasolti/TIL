package com.mira.study;

public class ReviewContinue {
	public void method() {
		/*
		 * continue
		 * 반복문 안에서 쓰임
		 * continue를 만나면 그 뒤에 어떤 구문이 있건
		 * 실행하지 않고 
		 * 가장 가까운 반목문으로 올라감
		 * 
		 * 
		 * */
		
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				continue;				
			}
			System.out.println(i + " ");
		}
//		1~10 사이에서 홀수만 출력하는 코드
//		1 3 5 7 9

		
		int sum = 0;
		for(int i = 0; i <= 100; i++) {
			if(i % 6 == 0) {
				continue;
			}
			sum += i;
		}
		System.out.println("합계 : " + sum);
		//1부터 100 사이에서
		//6의 배수값들은 제외하고 총 합계 구하기
		
	}

}
