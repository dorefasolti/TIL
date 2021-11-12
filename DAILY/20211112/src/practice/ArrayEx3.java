package practice;

public class ArrayEx3 {
	public static void main(String[] args) {
		
//		배열 복사
//		배열은 생성 후 길이 변경이 불가능하므로, 더 많은 저장공간이 필요하다면 보다 큰 배열을 새로 만들고, 내용을 복사해와야함
//		비용이 많이 드는 작업이므로 처음부터 배열의 길이를 넉넉하게 잡아주는 것이 좋다
//		but, 너무 크면 메모리가 낭비되므로, 기존의 2배 정도로 배열을 생성하는 것이 좋음
//		
//		int[] arr = new int[5];
//		크기가 5인 배열 arr 생성 
		
//		배열의 크기가 부족한 상황 발생!
		
//		int[] tmp = new int[arr.length*2];
//		배열의 길이가 arr의 길이 * 2인 배열 tmp 생성
//		arr.length의 값이 5이므로, 길이가 10인 배열 tmp가 생성되고
//		배열 tmp의 요소는 int의 기본값인 0으로 초기화됨
		
//		for(int i = 0; i < arr.length; i++) {
//			tmp[i] = arr[i];
//		}
//		for문을 이용해 배열 arr의 모든 요소에 저장된 값을 배열 tmp에 복사
		
		
//		arr = tmp; 
//		참조변수 arr이 새로운 배열을 가리키게 한다
//		= 참조변수 arr에 참조변수 tmp의 값을 저장한다
//		arr이 담고 있는 주소 => 0x100
//		tmp가 담고 있는 주소 => 0x200
//		arr = tmp -> arr에 0x200이 들어간다는 뜻
		
//		==> 참조변수 arr과 tmp는 이름만 다를 뿐 동일한 배열
//		기존에 arr이 가리키고 있던 0x100은 더 이상 자신을 가리키는 참조변수가 없기 때문에 사용할 수 없다
//		why? 배열은 참조변수를 통해서만 접근할 수 있기 때문
//		so, 의미가 없어진 배열은 jvm의 가비지컬렉터에 의해서 소멸된다
		

		int[] arr = new int[5];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = i + 1; //i의 초기값은 0이므로 +1,  1, 2, 3, 4, 5 들어가도록
		}
		System.out.println("변경 전");
		System.out.println("arr.length : " + arr.length);
		for(int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] : " + arr[i]);
		} 
//		변경 전
//		arr.length : 5
//		arr[0] : 1
//		arr[1] : 2
//		arr[2] : 3
//		arr[3] : 4
//		arr[4] : 5
		
		int[] tmp = new int[arr.length*2]; 
		
		for(int i = 0; i < arr.length; i++) { //배열 arr에 저장된 값들을 tmp로 복사
			tmp[i] = arr[i];
		}
		arr = tmp; //tmp 에 저장된 값을 arr에 저장한다
		
		System.out.println("변경 후");
		System.out.println("arr.length : "  + arr.length);
		for(int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] : " + arr[i]);
		}
//		변경 후
//		arr.length : 10
//		arr[0] : 1
//		arr[1] : 2
//		arr[2] : 3
//		arr[3] : 4
//		arr[4] : 5
//		arr[5] : 0
//		arr[6] : 0
//		arr[7] : 0
//		arr[8] : 0
//		arr[9] : 0

//		=> 기존 arr의 배열은 날아가고(가비지컬렉터), tmp를 이용해 새로 만든 배열의 주소가 arr에 들어온다(tmp, arr 모두 같은 배열을 참조하고 있는 것)
		
		
		
		
		
		
//		System.arraycopy()를 이용한 복사
//		for문은 배열의 요소 하나하나에 접근해서 복사하지만, arraycopy()는 지정된 범위의 값들을 한번에 통째로 복사한다.
//		*배열의 복사는 for문보다 System.arraycopy()를 사용하는 것이 효율적이다*
		
		System.arraycopy(arr, 0, tmp, 0, arr.length);
//						arr[0]에서, tmp[0]으로, arr.length개의 데이터를 복사
		
		
		char[] abc = {'A', 'B', 'C', 'D'};
		char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		System.out.println(abc); //ABCD
		System.out.println(num); //0123456789
		
		//배열 abc와 num을 붙여서 하나의 배열(result)로 만든다
		char[] result = new char[abc.length+num.length];
		System.arraycopy(abc, 0, result, 0, abc.length);
		System.arraycopy(num, 0, result, abc.length, num.length);
		System.out.println(result); //ABCD0123456789
		
		//배열 abc를 배열 num의 첫 번째 위치부터 배열 abc의 길이만큼 복사
		System.arraycopy(abc, 0, num, 0, abc.length);
		System.out.println(num); //ABCD456789
		
		// number의 인덱스6위치에 3개를 복사
		System.arraycopy(abc, 0, num, 6, 3);
		System.out.println(num); //ABCD45ABC9
		
//		다른 배열과 달리 char배열은 for문을 사용하지 않고도 print, prinln으로 배열에 저장된 모든 문자 출력 가능
	}

}
