package automation.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class CssandXpathDemo {
	
	@Test(enabled=false)
	void xpath() {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://letcode.in/buttons");
		WebElement ele =driver.findElement(By.xpath("(//button[@class='button is-primary'])[1]"));
		System.out.println(ele.getCssValue("background-color"));
	}
	@Test(enabled=false)
	void cssTagID() {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://letcode.in/buttons");
		//driver.findElement(By.cssSelector("#home")).click();
		driver.findElement(By.cssSelector("button#home")).click();
		
	}
	
	@Test(enabled=true)
	void cssTagClass() {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://letcode.in/signin");
		driver.findElement(By.cssSelector("input[placeholder='Enter registered email'][name='email']")).sendKeys("Gokul");
		
	}

}
