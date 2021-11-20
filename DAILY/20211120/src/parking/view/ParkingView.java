package parking.view;

import java.util.ArrayList;
import java.util.Scanner;

import parking.controller.ParkingController;
import parking.model.vo.Car;

public class ParkingView {
	private Scanner sc = new Scanner(System.in);		
	private ParkingController pc = new ParkingController();
	
	public void mainMenu() {
		while(true) {			
			System.out.println("==주차 타워 관리 프로그램==");
			System.out.println("1. 차량 주차");
			System.out.println("2. 차량 출차");
			System.out.println("3. 주차된 차량 검색");
			System.out.println("4. 전체 출력");
			System.out.println("0. 프로그램 종료하기");
			
			int value = sc.nextInt();
			
			switch(value){
			case 1 : carIn(); break; 
			case 2 : carOut(); break;
			case 3 : carSearch(); break;
			case 4 : allSearch(); break;
			case 0 : System.out.println("프로그램을 종료합니다.");return;
			default : System.out.println("잘못입력하셨습니다.");
			}
		}
	
		
		
	}
	
	public void carIn() {
		//차량번호, 차량종류, 차주를 입력받는 메소드
		
		
		System.out.println("차량 번호 : ");
		int carNum = sc.nextInt();
		System.out.println("차량 종류(1. 경차 / 2. 세단 / 3. SUV / 4. 트럭)");
		int carinfo = sc.nextInt();
		String carType = null;
		switch(carinfo){
			case 1 : carType = "경차"; break;
			case 2 : carType = "세단"; break;
			case 3 : carType = "SUV"; break;
			case 4 : carType = "트럭"; break;
			default : System.out.println("다시 입력하세요");
		}
		System.out.println("차주 : ");
		String owner = sc.next();
		
		pc.carIn( carNum, carType, owner);
		
	}
	
	public void carOut() {
		System.out.println("차량번호 : ");
		int keyword = sc.nextInt();
		pc.carOut(keyword);
		System.out.println("출차가 완료되었습니다.");
		//문제점 차량번호가 같은 사람이 둘 이상일 경우 모두 출차처리된다
		//갯수개 2개 이상인 경우 차주 이름 비교하는거 추가하기
	}
	
	public void carSearch() {
		System.out.println("주차 차량 차주 검색 : ");
		String keyword = sc.next();
		
		ArrayList<Car> list = pc.carSearch(keyword);
		
		if(list.isEmpty()) {
			System.out.println("일치하는 차량이 없습니다.");
		}else {
			System.out.println("검색 결과 " + list.size() + "대의 차량이 조회되었습니다");			
			for(Car c : list) {
				System.out.println(c);
			}
		}
	}
	
	public void allSearch() {
		
		System.out.println("현재 주차된 차량은 " + pc.list.size() + "대 입니다.");
		pc.allSearch();
	}
}
