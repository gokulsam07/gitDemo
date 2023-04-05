package listernersDemoClasses;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//import ListenMe.RetryAnalyzerDemo;
import junit.framework.Assert;

public class BasicTestNGDemo {
	public WebDriver driver;
	@BeforeTest
	public void setUp() {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(op);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

	//@Test(retryAnalyzer=RetryAnalyzerDemo.class)
	@Test
	public void BasicDemo() throws InterruptedException {
		driver.findElement(By.id("email")).sendKeys("Admi1n");
		driver.findElement(By.id("pass")).sendKeys("abc");
		driver.findElement(By.name("login")).click();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		sa.assertAll();
	}

	@Test(priority=2)
	public void BasicDemo2() {
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("gokuls2381@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("RussianRoulette@123&&8");
		driver.findElement(By.name("login")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
	}

}

