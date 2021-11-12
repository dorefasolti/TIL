package practice;

public class ArrayEx5 {
	public static void main(String[] args) {
		
		
//		배열의 활용
		
//		총합과 평균
		int sum = 0; //총점을 저장하기 위한 변수
		float average = 0f; //평균을 저장하기 위한 변수
		
		int[] score = {100, 88, 100, 100, 90};
		for(int i = 0; i < score.length; i++) {
			sum += score[i]; // 반복문을 이용해 배열에 저장되어 있는 값을 모두 더한다
		}
		average = sum / (float)score.length; //계산 결과를 float로 얻기 위해 형변환
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + average);
//		총점 : 478
//		평균 : 95.6

		
		
		
	}
}
