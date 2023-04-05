package automation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandleTooltipDemo {

	@Test(enabled = true)
	void toolTip() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		WebElement one = driver.findElement(By.cssSelector("#age"));
		
		  Actions action = new Actions(driver);
		  action.moveToElement(one).build().perform(); 
		  
		  //will work fine without wait as well
		  
//		  WebDriverWait wait = new 
//		 WebDriverWait(driver, 5); WebElement toolTip =
//		  driver.findElement(By.cssSelector(".ui-helper-hidden-accessible"));
//		  wait.until(ExpectedConditions.visibilityOf(toolTip));
		
		System.out.println(driver.findElement(By.cssSelector(".ui-helper-hidden-accessible")).getText());
	}
}
