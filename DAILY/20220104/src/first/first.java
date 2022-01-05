package first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class first {
	public static void main(String[] args) {
//		1. 크롬 드라이버 실행파일 셋팅
		System.setProperty("webdriver.chrome.driver", "C:/dev/chromedriver.exe");
		
//		2. 웹드라이버 로드
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//몇초동안 기다릴 것?
		
		driver.get("http://www.naver.com");
		//셀레니움을 이용해 네이버 접속하기 완료
		
		
//		3. 검색어 입력(input 태그 id == query)
		wait.until(ExpectedConditions.elementToBeClickable(By.id("query")));
		//위에서 10초만큼 기다리라고 했음, 그 만큼 기다렸는데 안되면 어떻게할지?
//		이 요소 객체를 클릭할 수 있을 때까지 기다려라
//		기다리고 나면 다음걸 실행해라(대기)
		
		WebElement inputSearch = driver.findElement(By.id("query"));
//		By클래스에 요소가 모두 존재 findElement 한개 찾는거
//		findElements는 반환형이 list
//		여기서 아이디가 쿼리인걸 찾아서 inputSearch에 담아보자
//		System.out.println(inputSearch);
//		[[ChromeDriver: chrome on WINDOWS (c1fae921cf3f68f3d2c399b0448ef713)] -> id: query]

//		텍스트입력창에 검색어를 입력해보자
		inputSearch.sendKeys("진주월귤");
		
//		4. 검색버튼 클릭(button태그 id == search_btn)
		WebElement searchButton = driver.findElement(By.id("search_btn"));
		searchButton.click();
//		클릭까지 완료
		
		
//		여기까지 하면 진주월귤 검색 결과창이 뜸
	}
}
