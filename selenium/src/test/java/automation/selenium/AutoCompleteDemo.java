package automation.selenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoCompleteDemo {
	@Test(enabled=true) 
	void SelectableDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://jqueryui.com/autocomplete/");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("tags")).sendKeys("H");
		Thread.sleep(4000);
		List<WebElement> searchList = driver.findElements(By.xpath("//ul[@id='ui-id-1']//li"));
		for (int i = 0; i < searchList.size(); i++) {
			if(searchList.get(i).getText().contentEquals("Scheme")) {
				searchList.get(i).click();
				break;
			}
		}
	}
}
