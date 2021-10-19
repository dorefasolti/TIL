package com.mira.study;

import java.util.Scanner;

public class ReviewSwitch {

//	switch문
//	switch(조건)
//	조건과 값n을 동등비교해서 맞으면 출력, 아니면 넘어감
//	조건 => 엘리베이터 버튼이라고 생각하면 된다
//	8 입력 -> case1, case2 ... 모두 지나치고 case8에서 8층입니다!문이 열립니다. 여기서 break문을 만나면 엘리베이터에서 내리는 것
//	
//	switch(조건){						조건(정수, 문자, 문자열) 
//		case 값1 : 수행문1				조건 == 값1이 true일 경우 실행할 코드 
//					break; 			switch영역을 빠져나간다
//	
//		case 값2 : 수행문2				case1이 false일 경우 case2와 비교
//					break;			true일 경우break->switch빠져나가기
	
//	...(case 3... 이어짐)				case2도 false 다시 비교 ..(반복)
	
//	default : 						case문 내에서 해당하는 값이 없을 때 출력. else문과 같다
//									break문은 적지 않는다
//	}								switch문 닫기
	
	
	public void iceCream() {
		//아이스크림 판매점
		//콘, 컵, 아이스크림케익, 쉐이크
		//3000, 3500, 45000, 6000
		
		Scanner sc = new Scanner(System.in);
		System.out.println("콘, 컵, 케익, 쉐이크를 판매중입니다.");
		System.out.println("주문하실 상품을 골라주세요.");
		String iceCream = sc.nextLine();
		int price = 0;
		
		switch(iceCream) {
		case "콘" : price = 3000;
		break;
		case "컵" : price = 3500;
		break;
		case "케익" : price = 45000;
		break;
		case "쉐이크" : price = 6000;
		default : System.out.println("판매하지 않는 상품입니다.");
//		return;
		}
		System.out.printf("%s의 가격은 %d입니다", iceCream, price);
//		
//		* 조건에 부합하지 않는 단어를 입력했을 때 
//				판매하지 않는 상품입니다.
//				라면땅의 가격은 0입니다
//			라는 메시지가 출력된다 
//			해결방법 => default 아래 switch{}가 닫히기 전에 return;을 입력
//			return : 해당 위치에서 메소드를 종료(호출 끝)시키고 다시 main 메서드로 돌아가게 한다
//		
//		* switch문을 닫는 중괄호와 출력문 사이에 return을 입력했을 경우
//			=> 출력문이 사용되기 전 메서드가 끝나버렸기 때문에 해당 문장은 dead code가 되며 
//			Unreachable code라는 오류가 뜬다
		
	}
	
	public void logIn() {
		Scanner sc = new Scanner(System.in);
		System.out.print("아이디를 입력하세요 : ");
		String id = sc.nextLine();
		System.out.print("비밀번호를 입력하세요 : ");
		String pw = sc.nextLine();
		
		String userId = "dorefasolti";
		String userPw = "1234";
		
		// userId == id && userPw == pw 조건이 불가능한 이유
		// 기본 자료형은 동등비교(== !=)가 가능하지만 참조자료형인 String는 동등비교가 불가능
		// why? 참조자료형은 실제로 변수에 담기는 값이 '주소값'이기 때문
		// so, 문자열 비교 시 equals()메서드를 사용한다
		// 결과값은 true/false로 반환
 		if(userId.equals(id) && userPw.equals(pw)){
			System.out.println("로그인 성공");
		}else {
			if(!userId.equals(id)){				
				System.out.println("존재하지 않는 아이디입니다.");
			}else {
				System.out.println("잘못된 비밀번호입니다.");
			}
		}
	}
}
