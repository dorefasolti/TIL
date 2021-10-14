package com.mira.run;
import com.mira.study.ReviewVariable; 
//임포트 안하면 호출 안됨 경로를 안알려줬는데 어떻게 와요?
//com.mira.study패키지의 Review클래스 위치를 알려줌
import com.mira.study.ReviewInput;
public class Run {

	public static void main(String[] args) {
		ReviewVariable r = new ReviewVariable();
		
		r.declareVariable();
		//r에는 Review클래스의 주소가 들어있음
		//Review안에서 어떤 메소드를 호출할것인가! 호출할 메소드 이름 입력하기
		
		ReviewInput rr = new ReviewInput();
		rr.inputTest();
	}
}
