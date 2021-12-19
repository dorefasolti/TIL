package toString;

public class ToString {

//	인스턴스에 대한 정보를 문자열로 제공할 목적으로 정의한 것
//	인스턴스의 정보를 제공한다는 것 => 인스턴스 변수에 저장된 값들을 문자열로 표현한다는 뜻
	
//	Object클래스에 정의된 toString
//	putlic String toString(){
//	return getClass().getName()+"@"Integer.toHexString(hashCode());
	
//	클래스 작성할 때 toString()을 오버라이딩 하지 않는다면 위와 같은 내용이 그대로 사용될 것이다
//	즉, toString() 호출 -> 클래스이름에 16진수의 해시코드를 얻게 될 것
	
	
}

class Card{
	String kind;
	int number;
	
	Card() {
		this("SPADE", 1);
	}

	public Card(String string, int i) {
		this.kind = kind;
		this.number = number;
	}
}

class Card2{
//	toString 출력 시 클래스이름+해시코드가 아닌 문자열로 반환되도록 해보자
	String kind;
	int number;
	Card2(){
		this("SPADE", 1);
	}
	public Card2(String kind, int number) {
		this.kind = kind;
		this.number = number;
		
	}
	public String toString() {
		return "kind : " + kind + ", number : " + number;
//		card인스턴스의 kind와 number를 문자열로 반환하도록 
		
	}
	
}
class CardToString{
	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();
		
		System.out.println(c1.toString());
//		toString.Card@26f0a63f
		System.out.println(c2.toString());
//		toString.Card@4926097b
		
//		Card클래스에서 Object클래스로부터 상속받은 toString()을 오버라이딩 하지 않았기 때문에,
//		Card인스턴스에 toString()을 호출하면 Object 클래스의 toString()이 호출됨
//		=> 클래스이름과 해시 코드 출력
//		서로 다른 인스턴스에 대해 toString()호출 -> 클래스 이름은 같아도 해시코드값이 다른 것을 알 수 있음
		
		String str = new String("KOREA");
		java.util.Date today = new java.util.Date();
		
		System.out.println(str);
//		KOREA
		System.out.println(str.toString());
//		KOREA
		System.out.println(today);
//		Sun Dec 19 22:46:57 KST 2021
		System.out.println(today.toString());
//		Sun Dec 19 22:46:57 KST 2021
		
//		클래스이름과해시코드가 아닌 다른 결과 출력됨
//		String클래스의 toString() => String
		
//		why?
//		String 클래스의 toString은 String 인스턴스가 갖고 있는 문자열을 반환하도록 오버라이딩되어있음
//		Date클래스 -> Date인스턴스가 갖고 있는 날짜와 시간을 문자열로 변환하여 반환하도록 오버라이딩 되어 있음
		
//		=> toString은 일반적으로 인스턴스나 클래스에 대한 정보 또는 인스턴스 변수들의 값을 문자열로 변환하여 반환하도록 오버라이딩 되는 것이 보통임
		
		Card2 c3 = new Card2();
		Card2 c4 = new Card2("HEART", 10);
		System.out.println(c3.toString());
//		kind : SPADE, number : 1
		System.out.println(c4.toString());
//		kind : HEART, number : 10
		
		
	}
	

}