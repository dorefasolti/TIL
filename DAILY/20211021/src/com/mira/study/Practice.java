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

}
