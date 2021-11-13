package practice;

import java.util.Arrays;

public class ArrayEx9 {
public static void main(String[] args) {
	//임의의 값으로 배열 채우기
	
	//연속적인 범위의 임의의 값으로 채우는 경우, random()을 사용하면 된다
//	for(int i = 0; i < 배열.length; i++) {
//		배열[i] = (int)(Math.random() * 원하는 범위);
//	}
//	
//	but, 불연속적인 범위의 값들로 배열을 채우고 싶다면?
//			배열을하나 더 사용하면 된다
//			먼저 배열 code에 불연속적인 값들을 담고
//			임의로 선택된 index에 저장된 값으로 배열의 요소들을 하나씩 채우면 된다
	
		int[] code = {-4, -1, 3, 6, 11}; //불연속적인 값들로 구성된 배열
		int[] arr = new int[10];
		
		for(int i = 0; i < arr.length; i++) { //arr배열의 길이만큼 돌아감
			int tmp = (int)(Math.random() * code.length); // code의 길이(5) 안에서 랜덤값 생성(0~4)
			arr[i] = code[tmp]; //arr의 i번째 배열에, code배열의 tmp번 인덱스의 값이 들어간다
		}
		
		System.out.println(Arrays.toString(arr));
//		[-1, -1, -4, 6, -1, 11, 6, 6, 11, 3]
	}
}
