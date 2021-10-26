package com.mira.study.run;

import com.mira.study.Study;

public class Run {
	
//				(void = return type)
	public static void main(String[] args) { //(String[] args) 매개변수. 바꿀 수는 있지만 코딩컨벤션! 변경하지 말자
//						(main = method이름)
//--------------------------------- 1번 ----------------------
		
		
		//객체 생성  == 인스턴스화
//	Student Kim = new Student();
//	kim.name = "미라";
//	kim.age = 28;
//	멤버변수의 접근제한자를 public으로 해두면 이렇게 다른 클래스에서도 접근 가능함
//	=> private으로 변경한 후
//	=> getter/setter 메소드를 만들어 값에 접근할 수 있게 해야한다
		
		
		Study first = new Study();
		
		first.setName("미라"); 
		//setter로 이름에 값을 주고
		System.out.println(first.getName()); //출력문 이용해서 출력해야 한다
		//getter로 값을 가져온다
//		first.getName()만 쓰면 출력 안됨! why? getter는 출력이 아니라 반환만! 가능!
		
		
//--------------------------------- 1번 끝!!!!----------------------

		
		
		
//--------------------------------- 2번 시작!!!!----------------------
		
//		2-1
		Study s1 = new Study();
		//객체 생성 시 memberB 멤버변수 할당
//		s1.test(5);
		//test 메소드 호출 시 localB, maegaeB 지역변수 할당
		//test 메소드 소멸 시 localB, maegaeB 지역변수 소멸
		
		
		System.out.println(s1); // s1 객체의 주소값이 들어있음
		
		
		s1 = null;
//		memberB멤버변수도 함께 소멸(레퍼런스 카운트가 0이 됨)
		System.out.println(s1);
//		출력해보면 결과값이 null로 바뀌었음
		
//		2-2 내용 X
		
//		2-3
		Study s3 = new Study();
		System.out.println(Study.staticcc);
//		public static String staticcc = "static 변수";
//				static => 객체를 생성하지 않아도 사용 가능(객체 참조하지 않아도 가능)
//		
		
		
		
		
		
		

//--------------------------------- 2번 끝!!!!----------------------

		
//--------------------------------- 3번 시작!!!!----------------------

		
//		생성자를 이용해 초기화 할 수 있는데 왜 setter가 필요?
//		setter는 초기화만 하는 게 아니라 값을 대입하기도 한다
//		중간에 변경해야 할 일이 생겼을 때,
//		다시 값을 대입하기 위해 생성자를 호출하는 것보다 세터의 값만 수정해주는게 효율적
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//--------------------------------- 3번 끝!!!!----------------------
//--------------------------------- 4번 시작!!!!----------------------

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	

	
	
		
		
		
		
		
		
		
		
		
		
		
}
