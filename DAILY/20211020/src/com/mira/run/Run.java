package com.mira.run;

import com.mira.study.Practice;
import com.mira.study.ReviewBreak;
import com.mira.study.ReviewContinue;
import com.mira.study.ReviewDoWhile;
import com.mira.study.ReviewWhile;

public class Run {
	public static void main(String[] args) {
		ReviewWhile rw = new ReviewWhile();
		rw.method();
		
		ReviewDoWhile rd = new ReviewDoWhile();
		rd.method2();
		
		ReviewBreak rb = new ReviewBreak();
		rb.method();
		
		ReviewContinue rc = new ReviewContinue();
		rc.method();
		
		
		Practice p = new Practice();
//		p.sukje1();
//		p.sukje2();
	}
}
