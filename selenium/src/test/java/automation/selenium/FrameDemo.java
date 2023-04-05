package automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FrameDemo {
	@Test(enabled=true)
	void DD() {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://letcode.in/frame");
		driver.manage().window().maximize();
		WebElement frame  = driver.findElement(By.id("firstFr")); 
		driver.switchTo().frame(frame);
		driver.findElement(By.name("fname")).sendKeys("gokul");
		driver.switchTo().frame(0);
		driver.findElement(By.name("email")).sendKeys("gokuls2381@gmail.com");
		driver.switchTo().parentFrame(); //for switching to parent frame, use parentFrame() 
		//do not pass the parent frame as object --> will return stale state exception
		driver.findElement(By.name("lname")).sendKeys("saminathan");
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Watch tutorial"));

	}
}
