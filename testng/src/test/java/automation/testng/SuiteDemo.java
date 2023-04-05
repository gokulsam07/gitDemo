package automation.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SuiteDemo {
	WebDriver driver;


	@BeforeSuite
	public void launchBrowser() {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*"); 
		driver = new ChromeDriver(op);

	}


	//These are the tests -- multiple test can be called as suite

	@Test(priority=2)
	public void testOrange() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	@Test(priority=0)
	public void testLetCode() {
		driver.get("https://letcode.in/dropdowns");
	}

	@Test(priority=1)
	public void testDemoWebsite() {
		driver.get("https://jqueryui.com/");
	}



	@AfterSuite	
	public void closeBrowser() {
		driver.close();
	}

}
