package com.kh.model.vo;

public class ATM {
	// 필드부
		private int ATMMoeny;
		
		
		// 생성자부
		public ATM() {
			super();
		}

		public ATM(int ATMMoeny) {
			super();
			this.ATMMoeny = ATMMoeny;
		}
		
		
		// 메소드부
		public int getATMMoeny() {
			return ATMMoeny;
		}

		public void setATMMoeny(int ATMMoeny) {
			this.ATMMoeny = ATMMoeny;
		}

	
}
