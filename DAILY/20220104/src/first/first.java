package first;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class first {
	public static void main(String[] args) {
//		1. ũ�� ����̹� �������� ����
		System.setProperty("webdriver.chrome.driver", "C:/dev/chromedriver.exe");
		
//		2. ������̹� �ε�
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//���ʵ��� ��ٸ� ��?
		
		driver.get("http://www.naver.com");
		//�����Ͽ��� �̿��� ���̹� �����ϱ� �Ϸ�
		
		
//		3. �˻��� �Է�(input �±� id == query)
		wait.until(ExpectedConditions.elementToBeClickable(By.id("query")));
		//������ 10�ʸ�ŭ ��ٸ���� ����, �� ��ŭ ��ٷȴµ� �ȵǸ� �������?
//		�� ��� ��ü�� Ŭ���� �� ���� ������ ��ٷ���
//		��ٸ��� ���� ������ �����ض�(���)
		
		WebElement inputSearch = driver.findElement(By.id("query"));
//		ByŬ������ ��Ұ� ��� ���� findElement �Ѱ� ã�°�
//		findElements�� ��ȯ���� list
//		���⼭ ���̵� �����ΰ� ã�Ƽ� inputSearch�� ��ƺ���
//		System.out.println(inputSearch);
//		[[ChromeDriver: chrome on WINDOWS (c1fae921cf3f68f3d2c399b0448ef713)] -> id: query]

//		�ؽ�Ʈ�Է�â�� �˻�� �Է��غ���
		inputSearch.sendKeys("���ֿ���");
		
//		4. �˻���ư Ŭ��(button�±� id == search_btn)
		WebElement searchButton = driver.findElement(By.id("search_btn"));
		searchButton.click();
//		Ŭ������ �Ϸ�
		
		
//		������� �ϸ� ���ֿ��� �˻� ���â�� ��
	}
}
