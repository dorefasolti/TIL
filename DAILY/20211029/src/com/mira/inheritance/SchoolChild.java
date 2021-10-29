package com.mira.inheritance;
//			자식클래스이름 	extends  부모클래스이름
public class SchoolChild extends Student{

	//부모로부터 상속받는 부분은 기술하지 않는다
	//메소드는 상속이 가능! 상속받아서 재정의해서 사용하는 경우 => 오버라이딩
	
	
	//필드
	private boolean play;

	
	//생성자
	public SchoolChild() {
		System.out.println("자식1 초등학생");
	}
						//부모클래스에 있는 필드들을 초기화시킨다
	public SchoolChild(String name, String grade, int studentNumber, boolean play) {
		super(name, grade, studentNumber); //매개변수가 있는 부모 클래스의 생성자 호출
		this.play = play;
		
		//항상 부모를 먼저 적고 자식이 뒤에 나와야한다
	
	}

	//메서드
	public boolean isPlay() {
		return play;
	}

	public void setPlay(boolean play) {
		this.play = play;
	}
	
	
	//부모클래스에는 name, grade, studentNumber까지만 반환을 해주므로, 
	//해당 자식 클래스에서 새로 만든 필드인 play를 추가해서 반환해주어야한다
	//이걸 오버라이딩이라고 한다
	@Override
	public String information() {
		return super.information() + play;
	}
	
}
