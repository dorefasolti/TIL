package com.mira.study;

import java.util.Arrays;
import java.util.Scanner;

public class Practice {
	
	public void minMax() {
		
		int[] arr = new int[10]; // 10개 값 저장할 수 있는 정수형 배열 선언, 할당
		int random;
		
		 // 1~10 사이의 난수를 발생시켜 배열에 초기화
		for(int i = 0; i < 10; i++) { //i가 0부터 9까지(총10회) 회전하는 조건문
			arr[i] = (int)(Math.random() * 10) +1; 
			//한번 반복할 때마다 각 arr마다 랜덤값을 적용
		}

		System.out.println(Arrays.toString(arr)); 
		//Arrays.toString을 이용해 배열 전체를 출력
		int min = arr[0]; 
		for(int i = 0; i < arr.length; i++) { //length를 이용해 배열 길이만큼 반복되도록 설정
			if(min >= arr[i]) { //min과 arr대조해서 min이 더 크거나 같으면
				min = arr[i];	//min에 arr을 대입
			}
		}
		System.out.println("최소값 : " + min); //for문이 끝난 후 결과 출력
		
		int max = arr[0];
		for(int i = 0; i < arr.length; i++) {
			if(max <= arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("최대값 : " + max);
		
	}
	
	public void lotto() {
		
		int[] lucky = new int[6]; //6개의 값을 배열할 수 있는 정수형 배열
		
		for(int i = 0; i < 6; i++) {//i가 6회 반복될 수 있도록 하는 조건식
			for(int j = 0; j < 6; j++) {
				if(i == j) {
					continue;					
				}else if(lucky[i] == lucky[j]) {
					lucky[i] = (int)(Math.random()*45)+1; // lucky에 랜덤값 대입
				}
			}
		}
		System.out.println(Arrays.toString(lucky));
	}
		
	
	public void strint() {
		
		Scanner sc =  new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.next();
		
		char[] ch = new char[str.length()];
		
	
		for(int i = 0; i < str.length(); i++) {
			ch[i] = str.charAt(i);
		}
		//		ch[0] = str.charAt(0);
		//		ch[1] = str.charAt(1);
		//		ch[2] = str.charAt(2);
		//		ch[3] = str.charAt(3);
		//		ch[4] = str.charAt(4);Z
		//		반복문을 풀어서 보면 이렇게 된다...
		
		System.out.print("문자열에 있는 문자 : " + Arrays.toString(ch));
		int duplication = 0;
		for(int i = 0; i < str.length(); i++) {
			for(int j = 0; j < str.length(); j++) {
				if(i == j) {
					continue;
				}else if(ch[i] != ch[j]) {
					duplication = i;
					
				}
			
			}
		} System.out.println("\n중복되지 않는 문자 개수 : " + duplication);
	}

//	Int flag = -1;
//
//	For (int i = 0; i < str.length()l; ++i) {
//	  If (str[i] == 2) {
//	    Flag = i;
//	    break;
//	  }
//	}
	
//	for (i = 0; i < arr.length; ++i) {
//		  For (j = 0; j < arr.length; ++j) {
//		    If (i == j) continue;
//		    If (arr[i] == arr[j]) // 중복
//		    { … }
//		  }
//		}
	
}
