package parking.controller;

import java.util.ArrayList;

import parking.model.vo.Car;

public class ParkingController {
	
	private int counter = 0;
	public ArrayList<Car> list = new ArrayList<>();{
		// list.add(new Car(1, 1234, "트럭", "김김김"));
		// list.add(new Car(2, 5678, "세단", "이이이"));
	}
	
	public ParkingController()
	{
		carIn(1234, "트럭", "김김김");
		carIn(5678, "세단", "이이이");
	}
	
	public void carIn(int carNum, String carType, String owner) {
		list.add(new Car(counter + 1, carNum, carType, owner));
		counter++;
	}
	
	public int carOut(int keyword) {
		int result = 0;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getCarNum() == keyword) {
				list.remove(i);
				result++;				
			}
		}
		
		return result;
	}
	
	public ArrayList<Car> carSearch(String keyword) {
		
		ArrayList<Car> search = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getOwner().equals(keyword)) {
				search.add(list.get(i));
			}
		}
		return search;
	}
	
	public void allSearch() {
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
	}
}
