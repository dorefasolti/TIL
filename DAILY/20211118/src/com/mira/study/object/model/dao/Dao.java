package com.mira.study.object.model.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.mira.study.object.model.vo.Drink;

public class Dao {
	//출력
	//프로그램--> 외부매체(파일)
	
//	ObjectOutputStream : 객체 단위를 파일에 출력하고자 할 때 필요한 보조스트림
	
	public void fileSave(String fileName) { //파일 이름을 입력받아서 지정해보자
		//Drink 객체 생성
		Drink dr = new Drink("이디야", "토피넛라떼", 4500);
		
//		try~with~resources 이용해 기반스트림, 보조스트림, 자원반납
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
//			보조스트림												기반스트림
			
			//객체 데이터를 파일에 출력(아까 만들어둔 Drink 객체)
			oos.writeObject(dr); //객체를 출력할거니까 write<Object>
			
		
		
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
//	여기까지 하고, Run 클래스에서 fileSave 메소드를 호출하면
//	drink.txt 파일은 생기지만
//	java.io.NotSerializableException: com.mira.study.object.model.vo.Drink
//	at java.base/java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1193)
//	at java.base/java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:353) 
//	at com.mira.study.object.model.dao.Dao.fileSave(Dao.java:25)
//	at com.mira.study.object.run.Run.main(Run.java:8)
//	이런 오류 메시지가 출력된다
//	=> Dao클래스의 25번째 줄에서 문제가 발생했는데, 
//	여기에 가보면 writeObject를 사용했는데,
//	그게 ObjectOutputStream에서 제공하는 메소드..
	
//	생성되어있는 drink.txt 파일에 들어가보면 오류메시지와 함께 이상한 문구가 출력되어 있는 것을 확인할 수 있다
	
//	가장 중요한 건 오류메시지
//	java.io.NotSerializableException:
//	직렬화가 되어있지 않다는 의미
	
//	Dao의 25번재 줄은 oos.writeObject(dr); 
//	여기서 dr을 받아온 곳은 Drink 클래스
//	Drink 클래스에 직렬화를 해줘야한다
// 	직렬화를 해주는 방법은 문제가 발생한 클래스 명 뒤에 implements Serializable 붙여주기
//	Phone 클래스에서 직렬화를 완료하고 다시 실행해보면 더 이상 오류메시지가 출력되지 않고
//  drink.txt의 내용도 바뀌어있는 것을 확인할 수 있다
	
	//파일 출력 끝.
	
	
	
	//입력
	//프로그램 <-- 외부매체
	public void fileRead(String fileName) {
		//FileInputStream : 기반스트림
		//ObjectInputStream : 객체 단위 파일로부터 읽어올 때 사용하는 보조스트림

//		
//		1. 기반스트림 생성
//		2. 보조스트림 생성
//		4. 자원반납
		try(ObjectInputStream ois = new ObjectInputStream
				(new FileInputStream(fileName))){
			
//			3. 읽어오기 readObjet() 사용
			//역직렬화는 readObjet() 알아서 해준다
			Drink dr = (Drink)ois.readObject();
						//여기는 반환형이 오브젝트타입(객체모양대로 가지고옴)
			//그걸 Drink모양에 넣으려고 한다?
			//Object클래스가 부모 클래스인데 자식클래스인 Drink모양으로?
			//부모가 자식 모양으로 들어오려고 하면 문제 발생
			//강제 형변환(Drink)명시해줘야함 	*다형성*
			System.out.println(dr);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		출력 결과
//		Drink [brand=이디야, menu=토피넛라떼, price=4500]
//		형변환을 잊지 말자
//		Object는 부모 클래스고, 우리가 가져오고자 하는 것은 자식클래스의 모양
//		자식클래스로 형변환해주자
		
		
	}
	
	
}
