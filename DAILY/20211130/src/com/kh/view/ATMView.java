package com.kh.view;

import java.util.Scanner;

import com.kh.controller.ATMController;
import com.kh.model.vo.Owner;

public class ATMView {
	
	// 필드부
	private Scanner sc = new Scanner(System.in); // 입력
	private ATMController ac = new ATMController(); // 컨트롤러
	private int langCheck;	// 언어 확인용 변수 (1: 한국어, 2: 영어, 3: 일본어)
	
	
	//-----------------------------------------------------------
	// 언어 선택 화면
	
	/**
	 * ATM 언어 선택
	 */
	public void mainSelect() {
		
		// 언어 선택 화면
		System.out.println("언어를 선택해주세요");
		System.out.println("Please Select　your Language");
		System.out.println("言語を選択してください\n");
				
		System.out.println("1. 한국어");
		System.out.println("2. English");
		System.out.println("3. 日本語");
		System.out.println("\n> ");
		
		int menuLang = sc.nextInt();
		sc.nextLine();
		
		// 언어 선택 분기
		switch(menuLang) {
			case 1:
				langCheck = 1;
				mainMenuKor();
				break;
			case 2:
				langCheck = 2;
				mainMenuEng();
				break;
			case 3:
				langCheck = 3;
				mainMenuJpn();
				break;
			default:
				System.out.println("잘못 입력하셨습니다");
				System.out.println("다시 입력해주세요\n");
			
				System.out.println("Entered incorrectly");
				System.out.println("Please enter again\n");
				
				System.out.println("入力に誤りがあります");
				System.out.println("再入力してください\n");
		}
		
	} // mainSelect 끝
	
	
	//-----------------------------------------------------------
	// 한국어 메인 화면
	
	/**
	 * 한국어 메뉴
	 */
	public void mainMenuKor() {
		
		while(true) {
			
			System.out.println("\n===== KH은행 ATM =====");
			System.out.println("1. 카드 조회");
			System.out.println("2. 입금");
			System.out.println("3. 출금");
			System.out.println("4. 송금");
			System.out.println("5. Translation English");
			System.out.println("6. 日本語に変更");
			System.out.println("0. 종료");
			System.out.println("=====================\n");
			System.out.println("원하시는 서비스 번호를 입력해주세요");
			System.out.println("> ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				case 1:
					selectAllKor();
					break;
				case 2:
					depositKor();
					break;
				case 3:
					withdrawKor();
					break;
				case 4:
					sendMoneyKor();
					break;
				case 5:
					langCheck = 2;
					mainMenuEng();
					break;
				case 6:
					langCheck = 3;
					mainMenuJpn();
					break;
				case 0:
					System.out.println("이용해주셔서 감사합니다");
					return;
				default:
					System.out.println("잘못 입력하셨습니다");
					System.out.println("다시 입력해주세요\n");
			}
			
		}
		
	} // mainMenuKor 끝

	
	//-----------------------------------------------------------
	// 한국어 메뉴 선택 화면
	
	/**
	 * 1. 카드 조회용 화면
	 */
	public void selectAllKor() {
		
		System.out.println("====== 카드 조회 ======");
		System.out.println("카드 번호를 입력해주세요 (- 포함)");
		System.out.println("> ");
		String cardNo = sc.nextLine();
		
		ac.selectAll(cardNo, langCheck);
		
	} // selectAllKor 끝
	
	/**
	 * 2. 입금 화면
	 */
	private void depositKor() {
		
		System.out.println("======== 입금 ========");
		
		System.out.println("카드 번호를 입력해주세요 (- 포함)");
		System.out.println("> ");
		String cardNo = sc.nextLine();
		
		System.out.println("카드 비밀번호를 입력해주세요");
		System.out.println("> ");
		int cardPwd = sc.nextInt();
		sc.nextLine();
		
		System.out.println("입금할 금액을 입력해주세요");
		System.out.println("> ");
		int cash = sc.nextInt();
		sc.nextLine();
		
		ac.deposit(cardNo, cardPwd, cash, langCheck);
		
	} // depositKor 끝
	
	/**
	 * 3. 출금 화면
	 */
	private void withdrawKor() {
		
		System.out.println("======== 출금 ========");
		
		System.out.println("카드 번호를 입력해주세요 (- 포함)");
		System.out.println("> ");
		String cardNo = sc.nextLine();
		
		System.out.println("카드 비밀번호를 입력해주세요");
		System.out.println("> ");
		int cardPwd = sc.nextInt();
		sc.nextLine();
		
		System.out.println("출금할 금액을 입력해주세요");
		System.out.println("> ");
		int cash = sc.nextInt();
		sc.nextLine();
		
		ac.withdraw(cardNo, cardPwd, cash, langCheck);
		
	} // withdrawKor 끝
	
	/**
	 * 4. 송금 화면
	 */
	private void sendMoneyKor() {
		
		System.out.println("======== 송금 ========");
		
		System.out.println("카드 번호를 입력해주세요 (- 포함)");
		System.out.println("> ");
		String cardNo = sc.nextLine();
		
		System.out.println("카드 비밀번호를 입력해주세요");
		System.out.println("> ");
		int cardPwd = sc.nextInt();
		sc.nextLine();
		
		System.out.println("상대방 카드 번호를 입력해주세요");
		System.out.println("> ");
		String sendCardNo = sc.nextLine();
		
		System.out.println("송금할 금액을 입력해주세요");
		System.out.println("> ");
		int cash = sc.nextInt();
		sc.nextLine();
		
		ac.sendMoney(cardNo, cardPwd, sendCardNo, cash, langCheck);
		
	} // sendMoneyKor 끝
	
	
	//-----------------------------------------------------------
	// 영어 메인 화면
	
	/**
	 * 영어 메뉴
	 */
	public void mainMenuEng() {
		
		while(true) {
			
			System.out.println("\n===== KH Bank ATM =====");
			System.out.println("1. Card Account Info");
			System.out.println("2. Deposit");
			System.out.println("3. Withdraw");
			System.out.println("4. Transfer");
			System.out.println("5. 한국어로 전환");
			System.out.println("6. 日本語に変更");
			System.out.println("0. Exit");
			System.out.println("=======================\n");
			System.out.println("Please select desired service");
			System.out.println("> ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				case 1:
					selectAllEng();
					break;
				case 2:
					depositEng();
					break;
				case 3:
					withdrawEng();
					break;
				case 4:
					sendMoneyEng();
					break;
				case 5:
					langCheck = 1;
					mainMenuKor();
					break;
				case 6:
					langCheck = 3;
					mainMenuJpn();
					break;
				case 0:
					System.out.println("Thank you for use our service!");
					return;
				default:
					System.out.println("Entered incorrectly");
					System.out.println("Please enter again");

			}
			
		}
		
	} // mainMenuEng 끝

	
	//-----------------------------------------------------------
	// 영어 메뉴 선택 화면
	
	/**
	 * 1. 카드 조회용 화면
	 */
	public void selectAllEng() {
		
		System.out.println("== Card Account Info ==");
		System.out.println("Enter your Card Number (Including -)");
		System.out.println("> ");
		String cardNo = sc.nextLine();
		
		ac.selectAll(cardNo, langCheck);
		
	} // selectAllEng 끝
	
	/**
	 * 2. 입금 화면
	 */
	private void depositEng() {
		
		System.out.println("======= Deposit =======");
		
		System.out.println("Enter your Card Number (Including -)");
		System.out.println("> ");
		String cardNo = sc.nextLine();
		
		System.out.println("Enter PIN Number");
		System.out.println("> ");
		int cardPwd = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter deposit money");
		System.out.println("> ");
		int cash = sc.nextInt();
		sc.nextLine();
		
		ac.deposit(cardNo, cardPwd, cash, langCheck);
		
	} // depositEng 끝
	
	/**
	 * 3. 출금 화면
	 */
	private void withdrawEng() {

		System.out.println("====== Withdraw ======");
		
		System.out.println("Enter your Card Number (Including -)");
		System.out.println("> ");
		String cardNo = sc.nextLine();
		
		System.out.println("Enter PIN Number");
		System.out.println("> ");
		int cardPwd = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter withdraw money");
		System.out.println("> ");
		int cash = sc.nextInt();
		sc.nextLine();
		
		ac.withdraw(cardNo, cardPwd, cash, langCheck);
		
	} // withdrawEng 끝
	
	/**
	 * 4. 송금 화면
	 */
	private void sendMoneyEng() {
		
		System.out.println("====== Transfer ======");
		
		System.out.println("Enter your Card Number (Including -)");
		System.out.println("> ");
		String cardNo = sc.nextLine();
		
		System.out.println("Enter PIN Number");
		System.out.println("> ");
		int cardPwd = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter transfer Card Number (Including -)");
		System.out.println("> ");
		String sendCardNo = sc.nextLine();
		
		System.out.println("Enter transfer money");
		System.out.println("> ");
		int cash = sc.nextInt();
		sc.nextLine();
		
		ac.sendMoney(cardNo, cardPwd, sendCardNo, cash, langCheck);
		
	} // sendMoneyEng 끝
	
	
	//-----------------------------------------------------------
	// 일본어 메인 화면
	
	/**
	 * 일본어 메뉴
	 */
	public void mainMenuJpn() {
		
		while(true) {
			
			System.out.println("\n===== KH銀行 ATM =====");
			System.out.println("1. カード情報の照会");
			System.out.println("2. お預け入れ");
			System.out.println("3. お引き出し");
			System.out.println("4. お振り込み");
			System.out.println("5. 한국어로 전환");
			System.out.println("6. Translation English");
			System.out.println("0. 終了");
			System.out.println("=====================\n");
			System.out.println("ご希望のお引き取りを選択してください");
			System.out.println("> ");
			
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
				case 1:
					selectAllJpn();
					break;
				case 2:
					depositJpn();
					break;
				case 3:
					withdrawJpn();
					break;
				case 4:
					sendMoneyJpn();
					break;
				case 5:
					langCheck = 1;
					mainMenuKor();
					break;
				case 6:
					langCheck = 2;
					mainMenuEng();
					break;
				case 0:
					System.out.println("ご利用ありがとうございます");
					return;
				default:
					System.out.println("入力に誤りがあります");
					System.out.println("再選択してください\n");
			}
			
		}
		
	} // mainMenuJpn 끝

	
	//-----------------------------------------------------------
	// 일본어 메뉴 선택 화면
	
	/**
	 * 1. 카드 조회용 화면
	 */
	public void selectAllJpn() {

		System.out.println("==== カード情報の照会 ====");
		System.out.println("カード番号を入力してください (「-」を含む)");
		System.out.println("> ");
		String cardNo = sc.nextLine();
		
		ac.selectAll(cardNo, langCheck);
		
	} // selectAllJpn 끝
	
	/**
	 * 2. 입금 화면
	 */
	private void depositJpn() {
		
		System.out.println("====== お預け入れ ======");
		
		System.out.println("カード番号を入力してください (「-」を含む)");
		System.out.println("> ");
		String cardNo = sc.nextLine();
		
		System.out.println("暗証番号を入力してください");
		System.out.println("> ");
		int cardPwd = sc.nextInt();
		sc.nextLine();
		
		System.out.println("お預け入れ金額を入力してください");
		System.out.println("> ");
		int cash = sc.nextInt();
		sc.nextLine();
		
		ac.deposit(cardNo, cardPwd, cash, langCheck);
		
	} // depositJpn 끝
	
	/**
	 * 3. 출금 화면
	 */
	private void withdrawJpn() {
		
		System.out.println("====== お引き出し ======");
		
		System.out.println("カード番号を入力してください (「-」を含む)");
		System.out.println("> ");
		String cardNo = sc.nextLine();
		
		System.out.println("暗証番号を入力してください");
		System.out.println("> ");
		int cardPwd = sc.nextInt();
		sc.nextLine();
		
		System.out.println("お引き出し金額を入力してください");
		System.out.println("> ");
		int cash = sc.nextInt();
		sc.nextLine();
		
		ac.withdraw(cardNo, cardPwd, cash, langCheck);
		
	} // withdrawJpn 끝
	
	/**
	 * 4. 송금 화면
	 */
	private void sendMoneyJpn() {
		
		System.out.println("====== お振り込み ======");
		
		System.out.println("カード番号を入力してください (「-」を含む)");
		System.out.println("> ");
		String cardNo = sc.nextLine();
		
		System.out.println("暗証番号を入力してください");
		System.out.println("> ");
		int cardPwd = sc.nextInt();
		sc.nextLine();
		
		System.out.println("相手のカード番号を入力してください (「-」を含む)");
		System.out.println("> ");
		String sendCardNo = sc.nextLine();
		
		System.out.println("お振り込み金額を入力してください");
		System.out.println("> ");
		int cash = sc.nextInt();
		sc.nextLine();
		
		ac.sendMoney(cardNo, cardPwd, sendCardNo, cash, langCheck);
		
	} // sendMoneyJpn 끝
	
	
	//-----------------------------------------------------------
	// 디스플레이 화면 - 언어 분기
	// 1: 한국어, 2: 영어, 3: 일본어
	
	/**
	 * 서비스 요청 성공 화면
	 * @param message 성공 메시지
	 */
	public void displaySuccess(String message, int langCheck) {
		
		if(langCheck == 1) { // 
			System.out.println("\n서비스 요청 성공: " + message);
		} else if(langCheck == 2) {
			System.out.println("\nService request successful: " + message);
		} else if(langCheck == 3) {
			System.out.println("\nサービス要請成功: " + message);
		}
		
	}
	
	/**
	 * 서비스 요청 실패 화면
	 * @param message 실패 메시지
	 */
	public void displayFail(String message, int langCheck) {
		
		if(langCheck == 1) {
			System.out.println("\n서비스 요청 실패: " + message);
		} else if(langCheck == 2) {
			System.out.println("\nService request failed: " + message);
		} else if(langCheck == 3) {
			System.out.println("\nサービス要請成功: " + message);
		}
		
	}

	/**
	 * 회원 조회 화면
	 * @param o 조회한 회원 정보
	 */
	public void displayOne(Owner o, int langCheck) {
		
		if(langCheck == 1) {
			System.out.println("\n입력하신 카드 회원 정보는 다음과 같습니다.\n");
			System.out.println("카드 번호: " + o.getCardNo());
			System.out.println("회원 이름: " + o.getCardOwner());
			System.out.println("잔액: " + o.getBalance());
		} else if(langCheck == 2) {
			System.out.println("\nYour Card Account Information\n");
			System.out.println("Card Number: " + o.getCardNo());
			System.out.println("Owner: " + o.getCardOwner());
			System.out.println("Balance: " + o.getBalance());
		} else if(langCheck == 3) {
			System.out.println("\nお客様情報\n");
			System.out.println("カード番号: " + o.getCardNo());
			System.out.println("お名前: " + o.getCardOwner());
			System.out.println("残高: " + o.getBalance());
		}
		
	}
	
}
