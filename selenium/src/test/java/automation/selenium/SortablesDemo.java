package automation.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class SortablesDemo {
	@Test(enabled=true)
	void Sortables() throws InterruptedException {
		WebDriver  driver = new ChromeDriver();
		driver.get("https://jqueryui.com/sortable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		List<WebElement> sortables = driver.findElements(By.xpath("//ul[@id='sortable']//li"));
		WebElement one=sortables.get(0);
		WebElement last=sortables.get(5);
		Actions action = new Actions(driver);
		action.clickAndHold(one);
		action.moveToElement(last);
		action.release(last);
		action.build().perform();

		//		for (int i = 0; i < sortables.size()-1; i++) {
		//			WebElement one=sortables.get(i);
		//			WebElement last=sortables.get(sortables.size()-1-i);
		//			Actions action = new Actions(driver);
		//			action.clickAndHold(one);
		//			action.moveToElement(last);
		//			action.release();
		//			action.build().perform();
		//			Thread.sleep(2000);
		//		}


	}
}
