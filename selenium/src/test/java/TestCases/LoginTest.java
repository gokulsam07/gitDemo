package TestCases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjects.LoginPageObjects;

public class LoginTest {

	@Test(enabled = false)
	void Login_using_POM() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPageObjects.userName(driver).sendKeys("Admin");
		LoginPageObjects.password(driver).sendKeys("admin123");
		LoginPageObjects.submit(driver).click();
		System.out.println("Title after Login page " +driver.getCurrentUrl());
	}
	
	@Test(enabled =true)
	void Login_using_POMPF() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, LoginPageObjects.class); //without this line NullPointer Exception will be thrown while finding elements
		//because there is no driver object to the page objects in test method --it has to be set on top once
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPageObjects.username.sendKeys("Admin");
		LoginPageObjects.password.sendKeys("admin123");
		LoginPageObjects.submit.click();

	}

}