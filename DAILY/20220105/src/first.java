import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class first {
	public static void main(String[] args) {
//		1. ũ�� ����̹� �������� ����
		System.setProperty("webdriver.chrome.driver", "C:/dev/chromedriver.exe");
		
//		2. �� ����̹� �ε�
		WebDriver driver = new ChromeDriver();
//		�հ� ���� �������� �ٸ��� => �������� ����Ȱ�
		driver.get("https://www.interpark.com/member/login.do?_method=initial&GNBLogin=Y&&wid1=wgnb&wid2=wel_login&wid3=login&imfsUserPath=http%3A%2F%2Fwww.interpark.com%2Fmalls%2Findex.html%3FgateTp%3D1&historyGoCnt=-1");
		
//		3. ���� Element�� iframe ���� ������ �߰� �޼ҵ带 ���
		driver.switchTo().frame("subIframe");
//		�̰� �߰��޼ҵ�� ������������ ã�� �޼ҵ�
//		subIframe���� ����ġ�ض�(�� ������ ���ο��� subIframe�� ã�ƶ�)	
		
		WebElement inputId = driver.findElement(By.id("userId"));
		WebElement inputPwd = driver.findElement(By.id("userPwd"));
		
//		id, pwd �Է�
		inputId.sendKeys("����e��wlfhd");
		inputPwd.sendKeys("��Г�ghwlfhd");
//		���� �����Ӹ޼ҵ尡 ���� ���, �̰͸� �Է��ϸ� �ƹ��͵� �ȵȴ�
//		��? �α���â�� ���� ��
//		�����������̶�� Ʋ�� �����, �ٸ����� �ִ� html�������� �α��� ���� �����Ա� ����
//		�߰��޼ҵ�(frame()�� �ʼ�����
		
//		������� ���̵� ��й�ȣ �ڵ��Է� ��!
		
//		���� �α��� ��ư�� Ŭ���غ���
//		1) ���̵�� ã�Ƽ� Ŭ���ϱ�
//		WebElement btns = driver.findElement(By.id("btn_login"));
//		btns.click();
		
//		2)Ŭ���� �Ӽ����� ã�Ƽ� Ŭ���ϱ�
		List<WebElement> btns = driver.findElements(By.className("btnRed"));
		
//		�迭�� ���̸� ���
		System.out.println(btns.size());
//		0
//		== �α��� ��ư�� �ϳ����̶�� ��
		btns.get(0).click();
	}
}
