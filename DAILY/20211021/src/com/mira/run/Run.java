package com.mira.run;

import com.mira.study.Practice;
import com.mira.study.ReviewPractice;

public class Run {
	public static void main(String[] args) {
		Practice p = new Practice();
//		p.minMax();
		p.lotto();
//		p.strint();
		ReviewPractice rp = new ReviewPractice();
//		rp.method1();
//		rp.method2();
		
	}
}
//1번 문제 !

//10개의 값을 저장할 수 있는 정수형 배열을 선언 및 할당하고
//1~10 사이의 난수를 발생시켜 배열에 초기화 후
//배열 전체 값과 그 값 중에서 최대값과 최소값을 출력하세요.
//ex.
//5 3 2 7 4 8 6 10 9 10
//최대값 : 10
//최소값 : 2


//2번 문제 !

//로또 번호 자동 생성기 프로그램을 작성하는데 중복 값 없이 출력하세요.
//ex.
//39 1 41 34 2 27


//3번 문제 !

//문자열을 입력 받아 문자열에 어떤 문자가 들어갔는지 배열에 저장하고
//문자의 개수와 함께 출력하세요.
//ex.
//문자열 : application
//문자열에 있는 문자 : a, p, l, i, c, t, o, n
//중복되지 않는 문자 개수 : 8