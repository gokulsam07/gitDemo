package automation.selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.FluentWait;


public class WaitsDemo {
	@Test(enabled=false)
	void ImplicitWait() throws InterruptedException { //Implicit Wait & Thread Sleep
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Before " +driver.findElement(By.cssSelector("#dte")).isEnabled());
		driver.findElement(By.xpath("//button[text()='Check this']")).click();
		Thread.sleep(10000);
		System.out.println("After "+ driver.findElement(By.cssSelector("#dte")).isEnabled());
	}

		@Test(enabled=false)
		void ExplicitWait() throws InterruptedException { //Implicit Wait & Thread Sleep
			WebDriver driver = new ChromeDriver(); 
			driver.get("https://omayo.blogspot.com/");
			driver.manage().window().maximize();
			System.out.println("Before " +driver.findElement(By.cssSelector("#dte")).isEnabled());
			driver.findElement(By.xpath("//button[text()='Check this']")).click();
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dte")));
			System.out.println("After "+ driver.findElement(By.cssSelector("#dte")).isEnabled());
		}

		@Test(enabled=true)
		void FluentWait() throws InterruptedException { //Implicit Wait & Thread Sleep
			WebDriver driver = new ChromeDriver(); 
			driver.get("https://omayo.blogspot.com/");
			driver.manage().window().maximize();
			System.out.println("Before " +driver.findElement(By.cssSelector("#dte")).isEnabled());
			driver.findElement(By.xpath("//button[text()='Check this']")).click();
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				     .withTimeout(Duration.ofSeconds(20))
				     .ignoring(NoSuchElementException.class)
				     .pollingEvery(Duration.ofSeconds(2));
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#dte")));
			System.out.println("After "+ driver.findElement(By.cssSelector("#dte")).isEnabled());
		}
	}

