package ch5;

public class ArrayEx1 {
	public static void main(String[] args) {
		int[] score = new int[5];
		int k = 1;
		
		score[0] = 50;
		score[1] = 60;
		score[k+1] = 70;
		score[3] = 80;
		score[4] = 90;
		
		int tmp = score[k+2] + score[4];
				//1+2 = 3
		
		//for문으로 모든 배열의 요소 출력한다
		for(int i = 0; i < score.length; i++) {
			System.out.printf("score[%d] : %d\n", i, score[i]);
			// %n과 \n의 차이
			// 둘다 줄바꿈이지만
			// %n이 OS에 독립적
		}
		
		System.out.printf("tmp : %d%n", tmp);
//		System.out.printf("score [%d] : %d%n", 7, score[7]); 
		//7번 인덱스 출력
		//코드 작성 시 아무 문제 없지만, 출력해보면 
		//java.lang.ArrayIndexOutOfBoundsException 오류 발생
		// => 배열의 인덱스가 유효한 범위를 넘었다
		
		//배열의 길이 => int범위 + 양의정수(0포함)
		
		//배열이름.length 
		//배열의 길이에 대한 정보
		
		int len = score.length;
		System.out.println(len); 
		//score(0~4, 총 5)의 길이가 출력된다
		
//		score.length = 30;
		//The final field array.length cannot be assigned
		//배열은 한번 생성하면 길이를 변경할 수 없으므로 배열이름.length는 상수
		//즉, 값을 읽을 수는 있지만 변경할 수는 없다
		
		int[] s = new int[6]; //=> 1. 배열의 길이를 5로 설정했다 3. 배열의 길이를 6으로 늘렸다 
		for(int i = 0; i < 5; i++) { //2. for(; i < 5;) 를 이용해 배열을 출력했다 4. 5->6으로 변경해줘야한다
			System.out.println(s[i]);
		}
		//만약 배열의 길이를 변경하고 싶다면, 반복문에서도 숫자를 바꿔주어야 하는 번거로움이 있다
		for(int i = 0; i < s.length; i++) { 
			// 반복문 선언 시 배열이름.length를 이용하는 것이 편하고, 오류가 발생할 가능성이 적다
			System.out.println(s[i]);
		}
		
		//만약, 배열에 저장할 공간이 부족한 경우에는?
//		더 큰 배열을 새로 생성하고, 기존 배열의 내용을 새 배열에 복사한다.
		//but, 배열 선언 시 처음부터 배열의 길이를 넉넉하게 잡는 것이 좋다
		
//		-----------------------------------------------------------------------
//		배열 초기화
		
//		생성과 동시에 자신의 타입에 해당하는 기본값으로 초기화됨
//		-> 따로 초기화를 해주지 않아도 된다
//		but, 원하는 값을 저장하려면 각 요소마다 값을 지정해주어야 함
//		
//		방법1.
//		원하는 값을 저장하기 위해 각 요소마다 값을 지정할 수 있다
//		but, 배열의 크기가 크다면?
		int[] s0 = new int[1];
		s0[0] = 1;
		
//		방법2. 배열의 크기가 큰 경우
//		but, for문을 이용해 배열을 초기화 하기 위해서
//		저장하려는 값에 일정한 규칙이 있어야한다
		int[] s1 = new int[5];
		for(int i = 0; i < s.length; i++) {
			s[i] = i * 10 + 50;
		}
		
		
//		방법3. 배열 생성과 동시에 초기화
		//{} 안에 쉼표로 구분해서 값을 나열
		//{} 안 값의 개수에 의해 배열의 길이가 자동 결정되므로 [] 안에 길이를 적지 않아도 된다
		int[] s2 = new int[] { 1, 2, 3, 4, 5 };
		int[] s3 = {1, 2, 3, 4, 5};
		// new int[]를 생략할 수도 있다
//		** 배열의 선언과 생성을 따로 하는 경우에는 생략할 수 없다
		int[] s4;
		s4 = new int[] {1, 2, 3, 4, 5}; // 선언과 생성을 따로 하는 경우
//		s4 = {1, 2, 3, 4, 5};  //불가능
		//Array constants can only be used in initializers 
		
		
//		* 길이가 0인 배열 만들기
//		방법1.
		int[] s5 = new int[0]; //배열의 길이를 0으로 넣었다
//		방법2.
		int[] s6 = new int[] {}; //배열의 요소를 아무것도 넣지 않았다
//		방법3.
		int[] s7 = {}; //new int[]가 생략되었다
		
		
	}
}


