package com.mira.study;

import java.util.Scanner;

public class Practice {

	//(구)3번문제
	public void lastTimePractice3() {
		Scanner sc = new Scanner(System.in);
		System.out.println("문자열을 입력하세요 : ");
		String str = sc.next();
		int count = str.length();
		String result = ("중복되지 않는 문자 : " + str.charAt(0) + " ");
		for(int i = 0; i < str.length(); i++){
			for(int j = 0; j < i; j++) {
				if(str.charAt(i) == str.charAt(j)) {
					
					count--;
					break;
				}
				else if(str.charAt(i) != str.charAt(j) && j == i-1) {
					result += str.charAt(i) + " ";
					
				}
			}
			
		}
		System.out.println(result);
		System.out.println("중복되지 않는 문자 개수 : " + count);
	}
		
	
	//1번이 되고싶었지만 중첩반복문과 break를 빼는게 더 효율적이라 실패
	public void fail() {
		Scanner sc = new Scanner(System.in); //문자열 입력받기
 		System.out.print("문자열 : "); //문자열 입력 메시지 출력
		String str = sc.next();// 입력받은 메시지를 str에 대입
		char[] arr = new char[str.length()]; //배열 arr을 선언하고 입력받은 문자열의 길이를 배열의 길이로 지정
		String result = "";  //결과를 저장할 변수 result를 선언하고 초기화
		
		for(int i = 0; i < str.length(); i++){	//문자열의 길이만큼 돌아가는 반복문 선언
			arr[i] = str.charAt(i); //arr[i]마다 입력받은 문자열의 i번 문자를 대입
		}
		
		System.out.println("문자 : "); //문자 입력을 요청하는 문구 출력
		char ch = sc.next().charAt(0); //문자를 입력받고 ch에 대입
		int count = 0; // 입력받은 문자와 문자열의 문자가 중복 될 시 숫자를 증가시켜 중복횟수를 알 수 있도록 변수 선언
		
		//application에 i가 존재하는 위치 -> 해당 i값을 뽑아내자
		//count같은걸 하나 만들어서 +시키자
		
		//중첩반복문 
		for(int i = 0; i < str.length(); i++) { //문자열의 길이만큼 돌아가는 반복문 
			for(int j = 0; j < i; j++) { //i값의 크기만큼돌아가는 반복문 
				if(str.charAt(i) == ch) { //
					result += (i + " ");
					count++;
					break;
				}
			}
		}
		System.out.println(result);
		System.out.println(count);
		
		
	}
	
	
	
	
	
	
	
	
	//진짜 1번
	public void method1() {
		Scanner sc = new Scanner(System.in); //문자열 입력받기
 		System.out.print("문자열 : "); //문자열 입력 메시지 출력
		String str = sc.next();// 입력받은 메시지를 str에 대입
		char[] arr = new char[str.length()]; //배열 arr을 선언하고 입력받은 문자열의 길이를 배열의 길이로 지정
		String result = "";  //결과를 저장할 변수 result를 선언하고 초기화
		
		for(int i = 0; i < str.length(); i++){	//문자열의 길이만큼 돌아가는 반복문 선언
			arr[i] = str.charAt(i); //arr[i]마다 입력받은 문자열의 i번 문자를 대입
		}
		
		System.out.println("문자 : "); //문자 입력을 요청하는 문구 출력
		char ch = sc.next().charAt(0); //문자를 입력받고 ch에 대입
		int count = 0; // 입력받은 문자와 문자열의 문자가 중복 될 시 숫자를 증가시켜 중복횟수를 알 수 있도록 변수 선언
		
		//application에 i가 존재하는 위치 -> 해당 i값을 뽑아내자
		//count같은걸 하나 만들어서 +시키자
			
		//중첩반복문 
		for(int i = 0; i < str.length(); i++) { //문자열의 길이만큼 돌아가는 반복문 
				if(arr[i] == ch) { //만약, 배열의 i번째 글자가 입력받은 문자와 일치한다면
					result += (i + " "); //result는 result + (i + " ") (문자열의 n번째 문자가 일치 -> n(i)를 result에 넣는다)
					count++; //count가 1 증가
				}
		
		}
		System.out.println(str + "에 " + ch + "가 존재하는 위치(인덱스) : " + result); // 중복된 인덱스가 몇번 인덱스인지 출력
		System.out.println(ch + "의 개수 : " +count); //중복된 글자 수만큼 count 수가 증가되어 출력됨
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//2번
	public void method2() {
		Scanner sc = new Scanner(System.in);//입력!
		System.out.print("정수  : ");//정수를 입력하라는 메시지 출력
		int len = sc.nextInt(); //입력받은 정수를 len변수에 저장
		int[] arr = new int[len]; // int형 arr배열을 선언하고, 배열의 길이를 입력받은 정수만큼으로 지정
		int sum = 0;
		for(int i = 0; i < arr.length; i++) { // 입력받은 문자열만큼 돌아가는 반복문
			System.out.print("배열 " + i + "번째 인덱스에 넣을 값 : "); 
			arr[i] = sc.nextInt(); //i 번째 인덱스에 입력값 하나씩 대입 반복문이 돌아가며 모든 배열에 값이 들어가게 된다
		}
		for(int i = 0; i < arr.length; i++) { //배열의 길이만큼 돌아가는 반복문
			System.out.print(arr[i] + " "); //arr배열의 i번째 인덱스를 출력, 
											//반복문이 배열 길이만큼 돌아가기 때문에, 반복문이 돌아갈 수록 값이 더해져서 모든 배열의 값이 출력된다
		}
		
		for(int i = 0; i < arr.length; i++) { //배열의 길이만큼 돌아가는 반복문
			sum += arr[i]; //합계를 저장할 변수 sum을 선언하고, arr배열의 i번째 인덱스에 저장된 값을 더함
		}
		System.out.println("\n총 합 : " + sum); //배열의 모든 값을 더한 총합이 출력됨
		
	}
	
	
	
	
	
	//3번
	public void method3() {
		Scanner sc = new Scanner(System.in); //입력!

		String[] chicken = new String[3]; //배열의 길이가 3인 치킨 배열
		chicken[0] = "양념"; 
		chicken[1] = "간장";
		chicken[2] = "피자";
		
		System.out.print("치킨 이름을 입력하세요 : "); 
		String first = sc.next(); //first에 1번치킨값을 입력
		System.out.print("이름을 입력하세요 : ");
		String second = sc.next(); //second에 2번치킨값을 입력
		
		String[] chickenNames = new String[] {first, second}; //first와 second를 배열로 묶음
		
		for(int k = 0; k < chickenNames.length; k++) { //first와 second를 묶은 배열의 길이(0, 1 => 1)만큼 돌아가는 반복문 
			String realChicken = chickenNames[k]; //k번째인덱스의 값을 realChicken에 대입
			int flag = -1; // flag값을 -1로 설정함(아래 문장들 수행이 끝난 후, 다시 flag의 값을 -1로 돌리기 위해 첫 for문 안에 위치하도록 함)
			
			for(int i = 0; i < chicken.length; i++) { //치킨 목록이 들어있는 배열의 길이만큼 돌아가는 반복문 
				if(chickenNames[k].equals(chicken[i])) { //만약, chickenNames의 k번째 인덱스의 값과 chicken배열의 i번째 인덱스의 값이 일치한다면!
					flag = i; //flag의 값에 i가 대입됨
					break; //flag 값이 변경되었다면 더 이상 반복할 이유가 없으므로 반복문을 빠져나감
				}
			}
			
			if(flag != -1) { //만약, flag의 값이 -1이 아니라면! (위 if문에서 중복이 true라면 => flag의 값에 i가 대입되었을 것 = flag의 값이 -1이 아닐것)
				System.out.print(realChicken + "치킨 배달 가능 "); //배달이 가능하다는 메시지 출력
			}else if (flag == -1){ //flag의 값이 -1이라면 입력메뉴와 주문 가능한 메뉴가 일치하지 않는다는 뜻이므로
				System.out.print(realChicken + "치킨은 없는 메뉴입니다."); //없는 메뉴라는 메시지 출력
			}		
		}	
	}
		

	
	
	//4번
	public void method4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 : ");
		int input = sc.nextInt();

		for(int i = input; i >= 1; i--) {
			for(int j = i; j > 1 ; j--) {
				if(j <= i) {
					System.out.print('*');
				}
			} 
			System.out.println('*');
		}		
	}
	


	
	
	
	
	
	
}