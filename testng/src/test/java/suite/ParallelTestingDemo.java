package suite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class ParallelTestingDemo {

	@Test
	public void orange() {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(op);
		driver.get("https://google.com");
		driver.close();

	}
	@Test
	public void letcode() {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(op);
		driver.get("https://letcode.in/dropdowns");
		driver.close();
	}
}
