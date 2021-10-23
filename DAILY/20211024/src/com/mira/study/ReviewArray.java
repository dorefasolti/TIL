package com.mira.study;

import java.util.Arrays;
import java.util.Scanner;

public class ReviewArray {

	public void method() {
//		배열 : 하나의 공간에 같은 자료형들의 값을 여러 개 담을 수 있다
//				배열의 각 인덱스 자리에 실제 값이 담기며,
//				인덱스는 0부터 시작한다.

		
//		1. 배열 선언
//		자료형[] 배열명; 
//		int[] array;
		
//		2. 배열 할당
//		배열명 = new 자료형[];
//		자료형[] 배열명 = new 자료형[배열 길이]; 과같이 선언과 동시에 할당을 할 수도 있다.
//		배열, 객체도 참조형이기 때문에 new를 이용해 할당한다.
//		int[] array = new int[10];
		
//		3. 각각의 인덱스에 값 대입
//		배열명[인덱스값(몇번째인덱스)] = 값;
//		array[0] = 1;
//		array[1] = 2;
//		array[2] = 3;
//		반복문으로 한 번에 대입할 수도 있다
//		for(int i = 0; i < Array.length; i++) {
//			arr[i] = i+1;
//		}
//		Index 15 out of bounds for length 15
//		=> 인덱스의 범위를 벗어났다는 오류메시지
		
		
//		* String형 배열
//		1. 배열의 선언과 할당
//		String[] names = new String[10];
//		
//		2. 배열의 인덱스에 값을 대입한다
//		names[0] = "김김일";
//		names[1] = "김김이";
//		names[2] = "김김삼";
//		names[3] = "김김사";
//		names[4] = "김김오";
//		names[5] = "김김육";
//		names[6] = "김김칠";
//		names[7] = "김김팔";
//		names[8] = "김김구";
//		names[9] = "김김십";
//		
//		names[1000] = "김김백" // 빨간줄은 뜨지 않지만, 실행하면 Index 1000 out of bounds for length 10 라는 오류메시지가 출력된다
//							배열 인덱스의 범위를 10까지로 지정해놓고 1000번째 인덱스를 입력할 수는 없다는 뜻
//		
	}
	
	public void method1() {
		//최댓값을 구하는 인덱스
		int[] n = new int[5];
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < n.length; i++) {
			System.out.print("정수를 입력하세요 : ");
			n[i] = sc.nextInt();
			System.out.print("n배열의 " + i + "번째 인덱스에 들어가는 값" + n[i] + " ");
			System.out.println(Arrays.toString(n));
			}
		
		int max = n[0];
		for(int i = 0; i < n.length; i++) {
			if(max <= n[i]) {
				max = n[i];
			}
		} 
		System.out.println("최댓값 : " + max);
	
	}
	public void method2() {
		//최솟값을 구하는 인덱스
		int[] n = new int[5]; //배열 선언, 할당
		Scanner sc = new Scanner(System.in); //입력받을 수 있도록!
		int min = 0; //최솟값을 담을 변수 min을 선언
		for(int i = 0; i < n.length; i++) {	//배열n의 길이만큼 반복되도록 함		
			System.out.println("배열의 인덱스를 채울 숫자를 입력하세요 : ");
			n[i] = sc.nextInt(); //배열의 [i]번째 인덱스에 입력받은 값을 대입
								 //반복문이 돌아가면서 모든 인덱스에 값이 대입됨
			min = n[0];  //min에 배열0의 0번째 인덱스를 대입
			for(int j = 0; j < n.length; j++) { //배열의 길이만큼 반복문이 돌아감
				if(min >= n[j]) {//min과 배열n의 인덱스를 각각 비교
//				(min의 초기값은 위에서 대입한 n[0] 0번인덱스값부터 마지막 배열까지 비교히게되고, 배열의 값이 min과 같거나 작으면 if문을 수행)
					min = n[j]; 
					//min값과 같거나 작았던 인덱스의 값이 min에 대입된다. 
					//이후 다시 비교 시 더 큰 값이라면 패스, 
					//더 작은 값이 나타나면 그 값이 다시 min에 대입됨
				}
			}
		}
		System.out.println("min = " + min); //min값을 출력!
		
	}
		
	public void method3() {
		//배열의 모든 누적 합을 구하기
		int[] a = new int[5]; //배열 선언, 할당
		int sum = 0; //합계를 대입할 변수 sum을 선언
		a[0] = 5; //각 인덱스마다 값 대입
		a[1] = 4;
		a[2] = 3;
		a[3] = 2;
		a[4] = 1;
		for(int i = 0; i < a.length; i++) { //배열의 길이만큼 도는 반복문
			sum += a[i]; // sum = sum + a[i] -> 반복문이 돌아가며 i값이 변화, 모든 인덱스에 들어있는 값들이 더해지게 된다.
		}
		System.out.println(sum); //출력
	}
	
	
	public void method4() {
		Scanner sc = new Scanner(System.in); //입력!
		
		System.out.print("문자열을 입력하세요 : ");
		String str = sc.next(); //입력받은 문자열을 str에ㅐ 대입
		
		String result = "문자열에 있는 문자 : " + str.charAt(0) + " ";
		//result에 문자열의 0번째 글자 미리 입력해두기
		int count = str.length(); 
		//count에 str[]의 길이 대입하기
		for(int i = 0; i <= str.length()-1; i++) { 
			for(int j = 0; j <= i-1; j++) {
				//중복을 확인하기 위해 중첩반복문을 돌림
				if(str.charAt(i) == str.charAt(j)) { //str의 i번째 글자와 j번째 글자가 일치하는지 확인 
					count--; //일치한다면 count를 1감소
					//count에는 배열의 길이가 저장되어있고, 중복되었을 때마다 1 감소시키는 것으로 중복된 글자가 있는 것을 알려줌
					break;//첫 for문으로 빠져나가기
				}else if(str.charAt(i) != str.charAt(j) && j == i-1) {
//					str.charAt(i) 가 str.charAt(j)가 아니면서 j가 i-1인 경우
					result += str.charAt(i) + " ";					
//					result = result + str.charAt(i)가 된다
//					(result에는 이미 첫글자가 대입되어있음, 이후 else if문의 조건에 해당하는 경우 인덱스에 저장된 값이 추가로 더해짐)
				}
			}
			
		}
		
		System.out.println(count);
		System.out.println(result);
		
		
		
		
		
		
		
		
		
		
	}
}
