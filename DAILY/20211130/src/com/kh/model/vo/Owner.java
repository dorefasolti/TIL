package com.kh.model.vo;

public class Owner {
	// 필드부
		private String cardNo;
		private int cardPwd;
		private String cardOwner;
		private int balance;
		
		
		// 생성자부
		public Owner() {
			super();
		}
		
		// 회원 조회용
		public Owner(String cardNo, String cardOwner, int balance) {
			super();
			this.cardNo = cardNo;
			this.cardOwner = cardOwner;
			this.balance = balance;
		}

		public Owner(String cardNo, int cardPwd, String cardOwner, int balance) {
			super();
			this.cardNo = cardNo;
			this.cardPwd = cardPwd;
			this.cardOwner = cardOwner;
			this.balance = balance;
		}

		
		// 메소드부
		public String getCardNo() {
			return cardNo;
		}

		public void setCardNo(String cardNo) {
			this.cardNo = cardNo;
		}

		public int getCardPwd() {
			return cardPwd;
		}

		public void setCardPwd(int cardPwd) {
			this.cardPwd = cardPwd;
		}

		public String getCardOwner() {
			return cardOwner;
		}

		public void setCardOwner(String cardOwner) {
			this.cardOwner = cardOwner;
		}

		public int getBalance() {
			return balance;
		}

		public void setBalance(int balance) {
			this.balance = balance;
		}

		@Override
		public String toString() {
			return "Owner [cardNo=" + cardNo + ", cardPwd=" + cardPwd + ", cardOwner=" + cardOwner + ", balance=" + balance
					+ "]";
		}
	
	
	
	
	

}
