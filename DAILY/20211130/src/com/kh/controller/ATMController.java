package com.kh.controller;

import com.kh.model.service.ATMService;
import com.kh.model.vo.Owner;
import com.kh.view.ATMView;

public class ATMController {
	
	
	public void selectAll(String cardNo, int langCheck) {   
			
			
		Owner o = new ATMService().selectAll(cardNo);
		
		if(langCheck == 1) {
			
			if(o == null) { 
			new ATMView().displayFail("조회된 결과가 없습니다", langCheck);
			}else {   
			new ATMView().displayOne(o, langCheck);
			}
		}
		if(langCheck == 2) {
			
			if(o == null) { 
				new ATMView().displayFail("There's no result that was searched", langCheck);
				}else {   
				new ATMView().displayOne(o, langCheck);
				}
			
		}
		if(langCheck == 3) {
			if(o == null) { 
				new ATMView().displayFail("照会結果がありません", langCheck);
				} else {   
				new ATMView().displayOne(o, langCheck);
				}
		}
	} //selectAll 끝
	
	
	
	
	


		
	public void deposit(String cardNo, int cardPwd, int cash, int langCheck) {
			
		int result = new ATMService().deposit(cardNo, cardPwd, cash);
			
			
		if(result > 1) {
			if(langCheck == 1) {
				new ATMView().displaySuccess("입금 완료", langCheck);
			} else if(langCheck == 2) {
				new ATMView().displaySuccess("The deposit successful", langCheck);
			} else if(langCheck == 3) {
				new ATMView().displaySuccess("入金に成功しました", langCheck);
			}
		} else {
			if(langCheck == 1) {
				new ATMView().displayFail("입금 실패", langCheck);
			}else if(langCheck == 2) {
				new ATMView().displayFail("The deposit failed", langCheck);
			}else if(langCheck == 3) {
				new ATMView().displayFail("入金に失敗しました", langCheck);
			}
		}
			
	}   // deposit 끝
		
		
		
	public void withdraw(String cardNo, int cardPwd, int cash, int langCheck) {
		int result = 0;
		result = new ATMService().withdraw(cardNo, cardPwd, cash);
			
		if(langCheck == 1) {
			if(result > 1) {
				new ATMView().displaySuccess("출금 성공", langCheck);
			} else {
				new ATMView().displayFail("출금 실패", langCheck);
			}
		} else if(langCheck == 2) {
			if(result > 1) {
				new ATMView().displaySuccess("The withdraw successful", langCheck);
			} else {
				new ATMView().displayFail("The withdraw failed", langCheck);
			}
		} else if(langCheck == 3) {
			if(result > 1) {
				new ATMView().displaySuccess("出金に成功しました", langCheck);
			} else {
				new ATMView().displayFail("出金に失敗しました", langCheck);
			}
		}
	} //withdraw 끝
	
	

	public void sendMoney(String cardNo, int cardPwd, String sendCardNo, int cash, int langCheck) {  
			
			
			
		int result = new ATMService().sendMoney(cardNo, cardPwd, sendCardNo, cash);
		

		
		if(result > 1) {
			if(langCheck == 1) {
				new ATMView().displaySuccess("송금 완료", langCheck);
			}else if(langCheck == 2) {
				new ATMView().displaySuccess("Transfer Successful", langCheck);
			}else if(langCheck == 3) {
				new ATMView().displaySuccess("送金に成功しました", langCheck);
			}
		} else {
			if(langCheck == 1) {
				new ATMView().displayFail("송금 실패", langCheck);
			}else if(langCheck == 2) {
				new ATMView().displaySuccess("Transfer failed", langCheck);
			}else if(langCheck == 3) {
				new ATMView().displaySuccess("送金に失敗しました", langCheck);
			}
		}
	} //sendMoney 끝
	
}
