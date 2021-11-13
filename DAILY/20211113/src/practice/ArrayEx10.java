package practice;

public class ArrayEx10 {
	public static void main(String[] args) {
		//정렬하기
		int[] numArr = new int[10];
		
		for(int i = 0; i < numArr.length; i++){
			System.out.print(numArr[i] = (int)(Math.random() * 10));
		}
		System.out.println();
		
		for(int i = 0; i < numArr.length-1; i++) {
			boolean changed = false; // 자리바꿈이 발생했는지 체크한다
			
			for(int j = 0; j < numArr.length-1-i; j++) {
				if(numArr[j] > numArr[j+1]) {
					int temp = numArr[j];
					numArr[j] = numArr[j+1];
					numArr[j+1] = temp;
					changed = true;
				} 
			}//j 반복문 끝
			
			if(!changed) break; //자리바꿈이 없으면 반복문을 벗어남
			for(int k = 0; k < numArr.length; k++) 
				System.out.print(numArr[k]);

			System.out.println();
		}//i 반복문 끝
		
		System.out.println();
		
		
		int[] num = new int[10];
		
		for(int i = 0; i < num.length; i++) {
			System.out.print(num[i] = (int)(Math.random() * 10));
		}
		System.out.println();
		for(int i = 0; i < num.length-1;i++) {
			boolean changed = false;
			
			for(int j = 0; j < num.length-1-i; j++) {
				if(num[j] > num[j+1]) {
					int tmp;
					tmp = num[j];
					num[j] = num[j+1];
					num[j+1] = tmp;
					changed = true;	
				}
			}
			
			if(!changed) break;
			
			for(int k = 0; k < num.length; k++) {
				System.out.print(num[k]);
			} System.out.println();
		}
		
		
		
		
		
	}
	
	
	
}
