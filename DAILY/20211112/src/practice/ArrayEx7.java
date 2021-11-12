package practice;

public class ArrayEx7 {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		
		for(int i = 0; i < numArr.length; i++) {
			numArr[i] = i; //배열의 숫자를 0~9로 초기화한다
			System.out.println(numArr[i]);
		}
//		0
//		1
//		2
//		3
//		4
//		5
//		6
//		7
//		8
//		9
		System.out.println();
		
		for(int i = 0; i < 100; i++) {
			int n = (int)(Math.random() * 10); //0~9 중 한 값을 랜덤하게 
			int tmp = numArr[0];  //tmp에 numArr[0] 을 넣는다
			numArr[0] = numArr[n]; //numArr[0]에 numArr[n]을 넣는다 
			numArr[n] = tmp; //numArr[n]에 tmp를 넣는다(기존 numArr[0])
			// numArr[0]에는 numArr[n]의 값이,
			// numArr[n]에는 tmp에 넣어두었던 기존 numArr[0]의 값이 들어간다
		}
		
		for(int i = 0; i < numArr.length; i++) {
			System.out.println(numArr[i]);
		}
//		9
//		4
//		6
//		5
//		0
//		8
//		7
//		2
//		1
//		3
//		랜덤한 값이 들어가기 때문에, 실행할 때마다 결과가 다르다
		
	}
	
}
