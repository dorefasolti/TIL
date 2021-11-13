package practice;

public class ArrayEx8 {
	public static void main(String[] args) {
		int[] ball  = new int[45];
		
		for(int i = 0; i < ball.length; i++) {
			ball[i] = i+1; //ball1에 1이 저장된다
		}
		for(int i = 0; i < ball.length; i++) {
			System.out.print(ball[i] + " ");
		}
//1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45
		
		int tmp = 0; //두 값을 바꾸는데 사용할 임시변수
		int j = 0; //임의의 값을 얻어서 저장할 변수
		
		//배열의 i번재 요소와 임의의 요소에 저장된 값을 서로 바꿔 값을 섞는다
		//0번째부터 5번째 요소까지 모두 6개만 바꾼다
		for(int i = 0; i < 6; i++) {
			j = (int)(Math.random() * 45); // 0~44범의의 임의의 값을 얻는다
			tmp = ball[i];
			ball[i] = ball[j];	//ball[i]와 [j]의 값을 서로 바꾼다
			ball[j] = tmp;  
		}
		
		//배열 ball의 앞에서부터 6개 요소를 출력한다
		for(int i = 0; i < 6; i++) {
			System.out.printf("ball[%d] = %d ", i, ball[i]);
		}
//		ball[0] = 2 ball[1] = 45 ball[2] = 8 ball[3] = 18 ball[4] = 13 ball[5] = 31 
		
//		길이가 45인 배열에 1부터 45까지의 값을 담은 다음, 반복문을 이용해
//		배열의 인덱스가 i인 값(ball[i])과 random()에 의해서 결정된 임의의 위치에 있는 값과 자리를 바꾸는 것을 6번 반복한다
//		= 1~45가지 번호가 쓰인 카드를 잘 섞은 다음, 맨 위의 카드 6장을 꺼내는 것과 같음
		
	}
}
