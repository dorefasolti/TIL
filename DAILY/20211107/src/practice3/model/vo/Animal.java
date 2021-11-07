package practice3.model.vo;

public abstract class Animal {
	public String name;
	public String kinds;
	
	protected Animal() {
	}

	protected Animal(String name, String kinds) {
		this.name = name;
		this.kinds = kinds;
	}
	
	
	public String toString() {
		return "저의 이름은 " + name + "이고, 종류는 " + kinds + "입니다.";
	}
	
	
	abstract public void speak();
}
