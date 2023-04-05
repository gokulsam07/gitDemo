package automation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PageNavigationDemo {
	@Test(enabled=true)
	void PageDemo() {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://letcode.in/windows");
		driver.navigate().to("https://letcode.in/edit");
		driver.navigate().to("https://letcode.in/windows");
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().forward();
		System.out.println(driver.getCurrentUrl());
		driver.navigate().refresh();
		System.out.println(driver.getCurrentUrl());
	}
}
