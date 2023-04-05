package automation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchDriverDemo {

	
	@Test(enabled=false)
	void launchDriverNoProp() {
		WebDriver driver = new ChromeDriver(); //Will work without system prop because driver location set in system path variables
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
	}
	
	@Test
	void launchDriverWithProp() {
		//since the path is already set, it will work without the below line as well, but one more way of setting driver prop
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\v-gokulsam\\Downloads\\chromedriver");
		WebDriver driver = new ChromeDriver(); //Will work without system prop because driver location set in system path variables
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		System.out.println(driver.getCurrentUrl());
	}
}
