package com.kh.practice.point.controller;

import com.kh.practice.point.model.vo.Circle;

public class CircleController {
	Circle c = new Circle();
	
	public String calcArea(int x, int y, int radius) {
		return "면적 : " + 3.14 * radius * radius;
	}
	
	public String calcCircum(int x, int y, int radius) {
		return "둘레 : " + 3.14 * radius * 2;
	}
}
