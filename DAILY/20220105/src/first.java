import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class first {
	public static void main(String[] args) {
//		1. 크롬 드라이버 실행파일 설정
		System.setProperty("webdriver.chrome.driver", "C:/dev/chromedriver.exe");
		
//		2. 웹 드라이버 로드
		WebDriver driver = new ChromeDriver();
//		앞과 뒤의 참조형이 다르다 => 다형성이 적용된것
		driver.get("https://www.interpark.com/member/login.do?_method=initial&GNBLogin=Y&&wid1=wgnb&wid2=wel_login&wid3=login&imfsUserPath=http%3A%2F%2Fwww.interpark.com%2Fmalls%2Findex.html%3FgateTp%3D1&historyGoCnt=-1");
		
//		3. 만약 Element가 iframe 내에 있으면 추가 메소드를 사용
		driver.switchTo().frame("subIframe");
//		이게 추가메소드다 아이프레임을 찾는 메소드
//		subIframe으로 스위치해라(이 프래임 내부에서 subIframe를 찾아라)	
		
		WebElement inputId = driver.findElement(By.id("userId"));
		WebElement inputPwd = driver.findElement(By.id("userPwd"));
		
//		id, pwd 입력
		inputId.sendKeys("아이e디wlfhd");
		inputPwd.sendKeys("비밀벊ghwlfhd");
//		위에 프레임메소드가 없는 경우, 이것만 입력하면 아무것도 안된다
//		왜? 로그인창을 만들 때
//		아이프레임이라는 틀을 만들고, 다른곳에 있는 html문서에서 로그인 폼을 가져왔기 때문
//		추가메소드(frame()가 필수적임
		
//		여기까지 아이디 비밀번호 자동입력 끝!
		
//		이제 로그인 버튼을 클릭해보자
//		1) 아이디로 찾아서 클릭하기
//		WebElement btns = driver.findElement(By.id("btn_login"));
//		btns.click();
		
//		2)클래스 속성으로 찾아서 클릭하기
		List<WebElement> btns = driver.findElements(By.className("btnRed"));
		
//		배열의 길이를 출력
		System.out.println(btns.size());
//		0
//		== 로그인 버튼이 하나뿐이라는 뜻
		btns.get(0).click();
	}
}
