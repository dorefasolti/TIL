package com.kh.practice4;
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




	public void lotto(){
		int[] lottoNumbers = new int[6]; // 로또번호 6개를 담을 배열 
		int num = 0;
		
		for(int i = 0; i < 6; i++){ //6개의 숫자를 넣기 위해 6번 돌아가는 반복문
			int flag = -1; //코드 내에서 등장할 일이 없는 숫자 -1로 선언하여 다른 값들과 혼란이 없도록 함
			int randomNumber = 0; //랜덤한 숫자가 들어갈 변수 선언
			
			do {
				flag = -1; 
				randomNumber = (int)(Math.random()*45)+1; //randomNumber에 랜덤한 값을 대입
				
				for(int j = 0; j < num; j++) {
					if(randomNumber == lottoNumbers[j]) { //중복값 확인
						flag = j; 
						break; 
					}
				}
			}while(flag != -1); 
			
			
				lottoNumbers[num] = randomNumber; //로또 배열의 num번째에 랜덤한 숫자 대입됨
				num++; // num 증가하고 for문 i++로 돌아감

				
				//중복이 있을 경우 num값이 증가하지 못한 상태로 다시 반복문을 돌아서 새로운 랜덤값 출력하는 코드  
		}
		System.out.println(Arrays.toString(lottoNumbers));

	}
	
	
	public void method() {
		Scanner sc =  new Scanner(System.in);
		System.out.print("문자열 : "); 
		String str = sc.next(); //입력받음
		char[] alphabets = new char[str.length()]; //문자열을 저장할 배열 선언
		int n = 0;
		
				//첫for문 (i)가 1회 돌아갈 때 내부 반복문(j)은 j값이 n보다 작을 동안 돌아가는 중첩반복문
				for(int i = 0; i < str.length(); i++) { //문자열의 길이만큼 배열 
					char ch = str.charAt(i); //ch에 입력받은 문자열의 i번째 단어가 대입된다
					int flag = -1; //중복 체크하기 위해 설정한 변수
					for(int j = 0; j < n; j++) { //중첩반복문 j < n이므로 n-1만큼 반복ㅁ누이 돌아간다
						if(ch == alphabets[j]) { //n이 3일 때, 현재 ch에 들어있는 값과 a[0], a[1], a[2]값을 비교한다
							flag = j; //만약 같다면 flag = j
							break;							
						}
					}
					//만약 위에서 중복이 나왔다면 flag의 값이 -1이 아니게 되어 
					//가장 첫 for문의 i++위치로 돌아간다(n은 증가X => 빈자리를 다시 채워주기 위함)
					if(flag == -1) { 
						alphabets[n] = ch; //ch의 값이 알파벳배열의 n번째에 대입됨
							
						n++; //n이 증가한다
					}
				}
				System.out.println("문자열에 있는 문자 : " + Arrays.toString(alphabets));
				
				System.out.println("중복되지 않는 문자 개수 : " + n);
		
	}
	
}



