package com.mira.study;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Upper {

	public void method() {
		
		//영단어를 소문자로 입력하면 첫 글자를 대문자로 변환해주는 프로그램
		
		Scanner sc = new Scanner(System.in);
		System.out.println("영단어를 입력하시오(띄어쓰기 포함) : ");
		String a = sc.nextLine();

		
		StringTokenizer stn = new StringTokenizer(a, " ");
		
		String[] real = new String[a.length()];
		

		int num = stn.countTokens(); 
		// 토큰의 길이는 토큰이 출력될 때마다 하나씩 줄어듦
		// 반복문에 토큰의 길이 그대로 넣으면 모든 토큰의 길이를 출력할 수 없기 때문에
		// 토큰이 출력되지 않은 상태에서 토큰의 길이를 변수 num에 저장하고 반복문에 num을 사용하면 배열의 길이만큼 반복이 가능하다
		for(int i = 0; i < num; i++) {
			real[i] = stn.nextToken();
			System.out.print(real[i].substring(0, 1).toUpperCase() + real[i].substring(1, real[i].length()) + " ");
							//real[i]번째 인덱스에 들어있는 값의 첫번째 글자(0번째)를 대문자로 변환해서 출력하고
							//							 첫번째 글자를 제외한 글자(1번째)부터 마지막까지 문자를 출력한다
		}

		

	}
	

}
