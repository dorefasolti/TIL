import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class first {
	public static void main(String[] args) {
//		ũ�ҵ���̹� �������� ����
		System.setProperty("webdriver.chrome.driver", "C:/dev/chromedriver.exe");
		
//		������̹� �ε�
		WebDriver driver = new ChromeDriver();
		
//		��������� ��� ������ �Ŵ� ��ü
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		
//		�ڹٽ�ũ��Ʈ�� ������ �� �ֵ��� ��ü ����(����ȯ)
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		
//		url�� �Է��Ͽ� ������ �̵�
		driver.get("Ȩ�������ּ��Է�");
		
//		Element �� id�� password�� �Է��� �� �ִ� �±׸� ã�Ƽ� ��ü�� ��´�.
		WebElement inputId = driver.findElement(By.id("id"));
		WebElement inputPwd = driver.findElement(By.id("password"));
		
		inputId.sendKeys("���̵��");
		inputPwd.sendKeys("��й�ȣ��");
		
//		�ڹٽ�ũ��Ʈ �ͽ�ť�� ��ü�� �̿��ؼ� �Լ��� ȣ��
		executor.executeScript("fnLogin()");
//		executor.executeScript("fnLogin()");
		
//		title�� ������������ ���Ե� ������ ���
		wait.until(ExpectedConditions.titleContains("����������"));
		
//		��ũ��Ʈ �̿��ؼ� ������ �̵�
		executor.executeScript("location.href='/login/updateUserFrm.kh'");
		
//		title�� �������� ������ ���Ե� ������ ���
		wait.until(ExpectedConditions.titleContains("������������"));
		
//		��й�ȣ ��Ҹ� Ŭ���� �� ���� ������ ���
		wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));
		
//		password input ��ü�� ã�� ������ element ��ü�� �Ҵ�
		WebElement inputPassword = driver.findElement(By.id("password"));
		WebElement inputPassword1 = driver.findElement(By.id("password1"));
		
		
//		value �Է�
		inputPassword.sendKeys("�����Һ�й�ȣ��");
		inputPassword1.sendKeys("�����Һ�й�ȣ��Ȯ������");
		
//		�ڹٽ�ũ��Ʈ �Լ� ȣ��
		executor.executeScript("fnInsertUser()");
		
//		alert
		wait.until(ExpectedConditions.alertIsPresent());
		
//		�˷� Ȯ�� ������
		driver.switchTo().alert().accept();
		
	}
}
