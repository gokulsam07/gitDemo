package automation.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CalenderDemo { //JQuery Implementation will have a text box
	@Test(enabled=false)
	void CalendarBySendKeys()  {
		WebDriver  driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.id("datepicker")).sendKeys("1/1/2010",Keys.ENTER);
	}

	@Test(enabled=true)
	void CalendarByCode() throws InterruptedException {

		String expectedStartMonthYear ="April 2023";
		String ExpectedStartDate = "Apr. 19, 2023";
		String expectedEndMonthYear = "May 2023";
		String ExpectedEndDate = "May 19, 2023";
		WebDriver  driver = new ChromeDriver();
		driver.get("https://www.expedia.ca/");
		driver.manage().window().maximize();
		
		//Departure 
		
		driver.findElement(By.id("d1-btn")).click();
		int flag=0;
		while(flag==0) {
			WebElement sCheck = driver.findElement(By.xpath("//div[@class='uitk-date-picker-menu-months-container']//div[1]//h2"));
			if(sCheck.getText().equals(expectedStartMonthYear)) 
			{
				List<WebElement> date = driver.findElements(By.xpath("(//div[@class='uitk-date-picker-month'])[1]//button"));
				for (WebElement webElement : date) 
				{
					if(webElement.getAttribute("aria-label").contentEquals(ExpectedStartDate)) 
					{
						webElement.click();
						webElement.click();
						driver.findElement(By.cssSelector("button[data-stid='apply-date-picker']")).click();
						flag=1;
						break;
					}
				}	
			}else {
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@data-stid='date-picker-paging'])[2]")).click();
			}
		}
		
		//Destination
		
		driver.findElement(By.id("d2-btn")).click();
		int pole=0;
		while(pole==0) {
			WebElement dCheck = driver.findElement(By.xpath("//div[@class='uitk-date-picker-menu-months-container']//div[1]//h2"));
			if(dCheck.getText().equals(expectedEndMonthYear)) 
			{
				List<WebElement> date = driver.findElements(By.xpath("(//div[@class='uitk-date-picker-month'])[1]//button"));
				for (WebElement webElement : date) 
				{
					if(webElement.getAttribute("aria-label").contentEquals(ExpectedEndDate)) 
					{
						webElement.click();
						webElement.click();
						driver.findElement(By.cssSelector("button[data-stid='apply-date-picker']")).click();
						pole=1;
						break;
					}
				}	
			}else {
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//button[@data-stid='date-picker-paging'])[2]")).click();
			}
		}

	}

}
