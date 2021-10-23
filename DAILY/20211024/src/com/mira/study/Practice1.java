package com.mira.study;

import java.util.Arrays;
import java.util.Scanner;

public class Practice1 {
	public void first() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.next();
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		char[] str2 = new char[100];
		
		int n = 0;
		int flag = -1;
		String result = "";
//		charAt(j)와 str2[i]가 일치하는지 확인한다
//		일치한다면 flag = j의 값이 된다
		
		for(int i = 0; i > str.length(); i++) {
			char ch1 = ch;
			flag = -1;
			for(int j = 0; j < i; j++) {
				if(ch1 == str2[j]) {
					flag = j;
					result += str.charAt(i) + " ";
					break;
				}
			}
			
			if(flag == -1) {
				str2[n] = ch1;
				n++;
				
			}
		}
		System.out.println(Arrays.toString(str2));
		System.out.println("문자열에서 입력한 문자의 위치가 존재하는 위치 : " + result);
		System.out.println("입력한 문자의 개수 : " + n);
		
	}	
	
	public void second() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.next();
		System.out.print("문자 : ");
		char ch = sc.next().charAt(0);
		char[] str2 = new char[str.length()];
		
		int n = str.length();
		String result = "";
		
//		charAt(j)와 str2[i]가 일치하는지 확인한다
//		일치한다면 flag = j의 값이 된다
		System.out.println(ch);

		for(int i = 0; i > str.length(); i--) {
//			
			for(int j = 0; j < i; i++) {
				if(str.charAt(i) == ch) {
					result += str.charAt(i) + " ";
					--n;
					break;
				}
			}
			if(str.charAt(i) == ch) {
				
			}
		}
		
		
		System.out.println("문자열에서 입력한 문자의 위치가 존재하는 위치 : " + result);
		System.out.println("입력한 문자의 개수 : " + n);
	}
}
