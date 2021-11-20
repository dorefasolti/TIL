package parking.model.vo;

public class Car {
	//차량번호  차량종류 차주
	
	private int parkingNum;
	private int carNum;
	private String carType;
	private String owner;
	public Car() {
		super();
	}
	public Car(int parkingNum, int carNum, String carType, String owner) {
		super();
		this.parkingNum = parkingNum;
		this.carNum = carNum;
		this.carType = carType;
		this.owner = owner;
	}
	
	
	public Car(int carNum, String carType, String owner) {
		super();
		this.carNum = carNum;
		this.carType = carType;
		this.owner = owner;
	}
	public int getParkingNum() {
		return parkingNum;
	}
	public void setParkingNum(int parkingNum) {
		this.parkingNum = parkingNum;
	}
	public int getCarNum() {
		return carNum;
	}
	public void setCarNum(int carNum) {
		this.carNum = carNum;
	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "Parking [parkingNum=" + parkingNum + ", carNum=" + carNum + ", carType=" + carType + ", owner=" + owner
				+ "]";
	}
	
	
}
