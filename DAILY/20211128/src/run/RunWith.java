package run;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import view.ProductView;

public class RunWith {

	public static void main(String[] args) {
		
	 new ProductView().mainMenu();
		Properties prop = new Properties();
		//프로퍼티스 객체 생성
		
		//A키에 대한 B값
		//A = B 
		//앞의 키에 매칭되게 나온다...
		prop.setProperty("driver", "oracle.jdbc.driver.OracleDriver"); //키값 : 드라이버, 밸류 : 오라클드라이버
		prop.setProperty("url", "jdbc:oracle:thin:@localhost:1521:xe"); //겟커넥션 할 떄 첫번째 인자가 유알엘
		prop.setProperty("username", "JDBC");
		prop.setProperty("password", "JDBC");
		
		//파일객체로 뽑아내려면 store()메소드를 사용한다
		
		try {																//그냥 코멘트
			prop.store(new FileOutputStream("resources/driver.properties"), "driver.properties");
			//외부 매체에 내보낸다
			prop.storeToXML(new FileOutputStream("resources/query.xml"), "query.xml");
			//별도의 경로 제시가 없으면 프로젝트 폴더 내에 만들어진다
			//resources : 주로 프로젝트 내의 외부파일들을 저장하는 역할
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
