package com.mira.study;

import java.util.Scanner; //입력받기 위해 꼭 필요함
public class ReviewInput {

	public void inputTest() {
		//키보드로부터 입력받는 코드 작성하기
		//java.util.Scanner라는 클래스 사용(자바 제공)
		//Scanner 클래스 안에 있는 메소드를 호출해서 사용
		
		Scanner sc = new Scanner(System.in);
		//객체 생성
		//System.in : 입력받은 값들을 받아 바이트 단위로 읽을 것

		System.out.println("주소를 입력하세요");
		//입력받고자 하는 내용을 먼저 질문하여 입력 유도하기
		

		String adress;
		adress = sc.next();
		//사용자가 입력한 값을 문자열로 받아오는 메소드
		//nextLine() : 사용자가 입력한 값 중 공백이 있을 경우 공백에 무관하게 입력한 문장을 완벽하게 출력
		//next() : 사용자가 입력한 값 중 공백이 있을 경우 공백 이전!까지만 입력받음
	
		System.out.println(adress + "에 살고 계시는군요!");
		
	
		//next() : 다음 입력받은 것을 반환
		//nextInt(), nextDouble(), nextFloat(), nextLog() : 다음 입력받은 특정 자료형을 반환
		//nextLine() \n이 나올 때까지 한 라인을 입력받고 \n을 버린 나머지를 반환
		
		sc.nextLine();
		//nextInt() 등으로 값을 입력받은 직후 nextLine() 사용 시 다음 질문으로 넘어가는 이유
		//=> nextLine()이 직전에 사용하고 버퍼에 남아있던 \n을 만나 바로 실행되기 때문
		//=> sc.nextLine() 오류가 발생하는 위치 사이에 빈 메소드를 입력해서 /n 처리해주면 해결!
		

		
		System.out.println("여성이라면 F, 남성이라면 M을 입력하세요");
		char gender = sc.nextLine().charAt(0);
		//자바에는 문자열을 바로 입력받는 기능 없어서 charAt(0)을 입력해야 함
		//먼저 문자열을 입력받은 후, 그 문자열의 0번째 문자를 추출한다는 의미
		//해당 문자열의 길이보다 더 큰 숫자를 적게 되면 StringIndexOutOfBound 오류 발생
		System.out.println(gender + "시군요!");
	
	
	
	
	
	
	}
	
}
