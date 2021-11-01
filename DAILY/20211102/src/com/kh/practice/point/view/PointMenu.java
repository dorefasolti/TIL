package com.kh.practice.point.view;

import java.util.Scanner;

import com.kh.practice.point.controller.CircleController;
import com.kh.practice.point.controller.RectangleController;

public class PointMenu {
	
	Scanner sc = new Scanner(System.in);
	CircleController cc = new CircleController();
	RectangleController rc = new RectangleController();
	
	public void mainMenu() {
		System.out.println(" ========== 메인 메뉴 ========== ");

		System.out.println("숫자를 입력하세요(1 : 원, 2 : 사각형, 9 : 끝내기)");
		while(true) {
			int a = sc.nextInt();
			if(a == 1) {
				System.out.println("1. 원");
				circleMenu();
				break;
			} else if(a == 2) {
				System.out.println("2. 사각형");			
				rectangleMenu();
				break;
			} else if(a == 9){
				System.out.println("9. 끝내기");
				break;
			} else {
				System.out.println("다시 입력하세요");
				break;
			}
		}	

		
	}
	
	public void circleMenu() {
		System.out.println(" ========== 원 메뉴 ========== ");
		System.out.println("숫자를 입력하세요(1 : 원 둘레, 2 : 원 넓이, 9 : 메인으로)");
		while(true) {
			int b = sc.nextInt();
			if(b == 1) {
				System.out.println("1. 원 둘레");
				calcCircum();
			} else if(b == 2) {
				System.out.println("2. 원 넓이");			
				calcCircleArea();
			} else {
				System.out.println("9. 메인으로");
				return;
			}
		}	
	}
	
	public void rectangleMenu() {
		System.out.println(" ========== 사각형 메뉴 ========== ");
		System.out.println("숫자를 입력하세요(1 : 사각형 둘레, 2 : 사각형 넓이, 9 : 메인으로)");
		while(true) {
			int b = sc.nextInt();
			if(b == 1) {
				System.out.println("1. 사각형 둘레");
				calcPerimeter();
			} else if(b == 2) {
				System.out.println("2. 사각형 넓이");			
				calcRectArea();
			} else {
				System.out.println("9. 메인으로");
				return;
			}
		}
	}
	
	public void calcCircum() {
		System.out.println("calcCircum");
		System.out.println("x 좌표  : ");
		int x = sc.nextInt();
		System.out.println("y 좌표  : ");
		int y = sc.nextInt();
		System.out.println("반지름  : ");
		int radius = sc.nextInt();
		System.out.println(cc.calcCircum(x, y, radius));
		
	}
	
	public void calcCircleArea() {
		System.out.println("calcCircleArea");
		System.out.println("x 좌표  : ");
		int x = sc.nextInt();
		System.out.println("y 좌표  : ");
		int y = sc.nextInt();
		System.out.println("반지름  : ");
		int radius = sc.nextInt();
		System.out.println(cc.calcArea(x, y, radius));
	}
	
	public void calcPerimeter() {
		System.out.println("calcPerimeter");
		System.out.println("x 좌표  : ");
		int x = sc.nextInt();
		System.out.println("y 좌표  : ");
		int y = sc.nextInt();
		System.out.println("높이  : ");
		int height = sc.nextInt();
		System.out.println("너비  : ");
		int width = sc.nextInt();
		System.out.println(rc.calcPerimeter(x, y, height, width));
	}
	
	public void calcRectArea() {
		System.out.println("calcRectArea");
		System.out.println("x 좌표  : ");
		int x = sc.nextInt();
		System.out.println("y 좌표  : ");
		int y = sc.nextInt();
		System.out.println("높이  : ");
		int height = sc.nextInt();
		System.out.println("너비  : ");
		int width = sc.nextInt();
		System.out.println(rc.calcArea(x, y, height, width));
	}
	
}
