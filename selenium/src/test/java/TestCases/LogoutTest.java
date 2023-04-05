package TestCases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import PageObjects.LoginPageObjects;
import PageObjects.DashboardLogoutObject;

public class LogoutTest {
	@Test(enabled=false)
	void Logout_using_POM() throws InterruptedException {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LoginPageObjects.userName(driver).sendKeys("Admin");
		LoginPageObjects.password(driver).sendKeys("admin123");
		LoginPageObjects.submit(driver).click();
		System.out.println("LoggedIn");
		Thread.sleep(2000);
		DashboardLogoutObject.Profile(driver).click();
		DashboardLogoutObject.Logout(driver).click();
		System.out.println("LoggedOut");
	}

	@Test(enabled=true)
	void Logout_using_POMPF() throws InterruptedException {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(driver, LoginPageObjects.class); 
		
		//PageFactory.initElements(driver, DashboardLogoutObject.class); //can be initialized here as well
		
		//Log in using Page factory
		
		LoginPageObjects.username.sendKeys("Admin");
		LoginPageObjects.password.sendKeys("admin123");
		LoginPageObjects.submit.click();
		System.out.println("LoggedIN");
		
		//Log out using page factory

		PageFactory.initElements(driver, DashboardLogoutObject.class); //can be initialized here as well
		DashboardLogoutObject.profile.click();
		DashboardLogoutObject.logout.click();
		System.out.println("LoggedOUT");
	}
}
