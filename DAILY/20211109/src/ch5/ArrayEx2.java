package ch5;

import java.util.Arrays;

public class ArrayEx2 {

	public static void main(String[] args) {

		
//		배열 출력하기
//		방법1. for문을 이용해 배열 한 칸 당 한줄씩 출력
		int[] iArr = {1, 2, 3, 4, 5};
		//for문을 이용해 순서대로 하나씩 출력하기
		for(int i = 0; i < iArr.length; i++) {
			System.out.println(iArr[i]);
		}
//		1
//		2
//		3
//		4
//		5
		
//		방법2. for문을 이용해 한줄로 출력하기
		int[] i2 = {1, 2, 3, 4, 5};
		for(int i = 0; i < i2.length; i++) {
			System.out.print(i2[i] + ",");
		}
//		1, 2, 3, 4, 5,
		System.out.println(); // 다음 출력이 바로 이어지지 않도록 줄바꿈 해줌
	
//		방법3. Arrays.toString(배열이름) 메서드 사용하기
		int[] i3 = {1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(i3));
//		[1, 2, 3, 4, 5]
		//*주의*
		System.out.println(i3); // I@2401f4c3 
		//배열이름을 그대로 출력하려고 하면 자료형@주소 형식으로 출력된다
		//I는 1차원 int 배열
		//@ 이하 16진수는 배열의 내부 주소(실제 주소X)
		//*예외*
		char[] chArr = {'a', 'b', 'c', 'd'};
		System.out.println(chArr);
		//char배열은 위와 같이 출력했을 때 정상적인 결과가 출력된다
		
		
		int[] a1 = new int[10];
		int[] a2 = new int[10];
		int[] a3 = {1, 2, 3, 4, 5};   //int[] a3 = new int[] {1, 2, 3, 4, 5};
		char[] c = {'a', 'b', 'c', 'd'};
		
		for(int i = 0; i <a1.length; i++) {
			a1[i] = i + 1; //1~10의 숫자를 순서대로 배열에 넣는다
		}
		
		for(int i = 0; i < a2.length; i++) {
			a2[i] = (int)(Math.random()*10) +1; //1~10 중 랜덤한 값을 배열에 저장
		}
		
		//배열에 저장된 값 출력하기
		for(int i = 0; i <a1.length; i++) {
			System.out.println(a1[i] + ", ");
		}
		System.out.println();
		System.out.println(Arrays.toString(a1)); //[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
		System.out.println(Arrays.toString(a2)); //[10, 4, 7, 2, 10, 3, 1, 6, 10, 7]
		System.out.println(Arrays.toString(c)); //[a, b, c, d]
		System.out.println(a3); //[I@41a4555e
		System.out.println(c); //abcd

	}
	
}
