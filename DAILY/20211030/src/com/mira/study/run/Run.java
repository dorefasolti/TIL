package com.mira.study.run;

import com.mira.study.Child1;
import com.mira.study.Child2;
import com.mira.study.Parent;

public class Run {
	public static void main(String[] args) {
		
		System.out.println("1. 부모타입 참조해 부모 객체를 다루는 경우");
		Parent p1 = new Parent();
		p1.printParent(); //나는 부모 출력됨
//		p1.printChild2(); 
		//The method printChild2() is undefined for the type Parent
		//p1은 parent에만 접근할 수 있다
		//child는 자식, 부모는 자식에게 접근할 수 없다
		
		System.out.println("2. 자식타입 참조해서 자식 객체를 다루는 경우");
		Child1 c1 = new Child1();
		c1.printChild1(); //나는 첫번째 자식
		c1.printParent(); //나는 부모
		//c1으로는 child1, parent 둘 다 접근이 가능하다
		//자식은 본인것, 부모것 둘 다 접근 가능
		
		
		
		//여기서부터 다형성
		System.out.println("부모타입 참조해 자식 객체를 다루는 경우");
		Parent p2 = new Child1();
		//parent와 child1은 다른데 어떻게 오류가 뜨지 않는가?
//		=> 대입연산자는 좌항, 우항의 타입이 같아야 함
//		=> 자동으로 형변환이 이루어졌음 
//		=> 어떻게? Parent p2 = (parent) new Child1; 
//		=> (Parent)가 생략되어 우리에겐 보이지 않음
		p2.printParent(); //나는부모
//		p2.printChild(); //The method printChild() is undefined for the type Parent
						//p2로는 parent에만 접근 가능
		
//		지금 p2의 자료형은 Parent이기 때문에 child1에 접근이 불가능하다
//		만약, p2가 Child2에 접근하고싶다면?
		((Child1)p2).printChild1(); //나는첫번째자식 출력 이제 가능하다
		
		
//		*상속구조일 경우 클래스 간 형변환이 가능하다
//		1. 업캐스팅
//		자식타입 -> 부모타입
//		자동형변환(생략 가능)
//		2. 다운캐스팅
//		부모타입 -> 자식타입
//		강제형변환(생략 불가능)
		
		
		
		
		System.out.println("다형성을 접목한 배열");
		//부모타입의 객체 배열을 만든 후
		//자식들을 부모 배열로 묶어보자
		
		Parent[] arr = new Parent[4];
		//보이지 않지만 arr[0] = (parent) new Child1();임
		arr[0] = new Child1(1, 2, 3);
		arr[1] = new Child1(4, 5, 6);
		arr[2] = new Child2(7, 8, 9);
		arr[3] = new Child2(10, 11, 12);
		
		
		//printParent메서드 호출 
		//부모 배열로 묶었으니까 가능하다
		for(int i = 0; i < arr.length; i++) {
			arr[i].printParent();
		}
		
		//만약, printChild1, printChild2에 접근하고싶다면?
//		arr[0].printChild1;
		//지금은 불가능하다
		//왜? 부모로 형변환이 되어있기 때문(부모는 자식에 접근 불가능)
		
		
//		방법1 자식으로 형변환을 한다
		((Child1)arr[0]).printChild1(); //나는첫번째자식 출력됨
		((Child1)arr[1]).printChild1();
		((Child2)arr[2]).printChild2(); //나는두번째자식 출력됨
		((Child2)arr[3]).printChild2();
//		단점
//		반복문 적용 불가능
//		인덱스0123은 돌릴 수 있는데, child1, child2는 어떻게?
		
		//만약, Child1을 Child2로 강제형변환 한다면?
//		((Child2)arr[0]).printChild2(); 
		//코드 상 오류는 발생하지 않지만 
//		실행 시 ClassCastException 오류메시지가 출력
			//클래스 간 형변환이 잘못되었을 경우 발생하는 에러
//		why? Child1과 Child2는 아무런 관계가 없다
//		서로 존재를 모르고 사는 이복형제 느낌..
		
		
		
		System.out.println("반복문과 오버라이딩을 접목해보자");
		
		for(int i = 0; i < arr.length; i++) {
			arr[i].print();
//			첫번재 자식
//			첫번재 자식
//			두 번째 자식
//			두 번째 자식
//			이렇게 출력된다
			
			
//		Child1, Child2 클래스에서 print메소드는 @Override되어있는 상태
//		오버라이딩되면 자식클래스에서 부모클래스의 메서드를 덮어쓰는것
//		=> 덮어쓴 후에는 우선운위가 '자식 > 부모'로 변경된다
//			(오버라이딩된 메소드 > 원조메소드)

//		결론
//		객체배열을 사용할 때 오버라이딩을 이용하면 강제형변환을 하지 않아도 된다
		
		}
		
		
		
	}
}
