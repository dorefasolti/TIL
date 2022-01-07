import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class first {
	public static void main(String[] args) {
//		크롬드라이버 실행파일 셋팅
		System.setProperty("webdriver.chrome.driver", "C:/dev/chromedriver.exe");
		
//		웹드라이버 로드
		WebDriver driver = new ChromeDriver();
		
//		명시적으로 대기 조건을 거는 객체
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
//		자바스크립트를 실행할 수 있도록 객체 생성(형변환)
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
//		url을 입력하여 페이지 이동
		driver.get("홈페이지주소입력");
		
//		Element 중 id와 password를 입력할 수 있는 태그를 찾아서 객체에 담는다.
		WebElement inputId = driver.findElement(By.id("id"));
		WebElement inputPwd = driver.findElement(By.id("password"));
		
		inputId.sendKeys("아이디당");
		inputPwd.sendKeys("비밀번호당");
		
//		자바스크립트 익스큐터 객체를 이용해서 함수를 호출
		executor.executeScript("fnLogin()");
//		executor.executeScript("fnLogin()");
		
//		title에 마이페이지가 포함될 때까지 대기
		wait.until(ExpectedConditions.titleContains("마이페이지"));
		
//		스크립트 이용해서 페이지 이동
		executor.executeScript("location.href='/login/updateUserFrm.kh'");
		
//		title에 개인정보 수정이 포함될 때까지 대기
		wait.until(ExpectedConditions.titleContains("개인정보수정"));
		
//		비밀번호 요소를 클릭할 수 있을 때까지 대기
		wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		
//		password input 객체를 찾아 각각의 element 객체에 할당
		WebElement inputPassword = driver.findElement(By.id("password"));
		WebElement inputPassword1 = driver.findElement(By.id("password1"));
		
		
//		value 입력
		inputPassword.sendKeys("변경할비밀번호당");
		inputPassword1.sendKeys("변경할비밀번호를확인하장");
		
//		자바스크립트 함수 호출
		executor.executeScript("fnInsertUser()");
		
//		alert
		wait.until(ExpectedConditions.alertIsPresent());
		
//		알럿 확인 누르기
		driver.switchTo().alert().accept();
		
	}
}
