package automation.selenium;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import junit.framework.Assert;
public class WebTablesDemo {
	@Test(enabled=false)
	void TableDemo1() {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://letcode.in/table");
		String lastName ="Raj";
		driver.manage().window().maximize();
		List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='simpletable']//tbody/tr"));
		int i=-1;
		for (WebElement webElement : rowData) {
			i++;
			List<WebElement> colData = webElement.findElements(By.xpath("//table[@id='simpletable']//tbody/tr/td[2]"));
			if(colData.get(i).getText().equals(lastName)) {
				System.out.println("lastname matched");
				List<WebElement> box = webElement.findElements(By.xpath("//table[@id='simpletable']//td[4]/input"));
				box.get(i).click();
				break;
			}
		}
	}

	@Test(enabled=true)
	void SortTable() {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://letcode.in/table");
		driver.manage().window().maximize();
		ArrayList<String> sorted = new ArrayList<String>();
		sorted.add("Cupcake");
		sorted.add("Eclair");
		sorted.add("Frozen yogurt");
		sorted.add("Gingerbread");
		sorted.add("Ice cream");

		//		WebDriverWait wait = new WebDriverWait(driver,5);
		//		wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElement(By.xpath("//div[@class='mat-sort-header-content ng-tns-c30-0']"))));
		driver.findElement(By.xpath("//div[@class='mat-sort-header-content ng-tns-c30-0']")).click();
		List<WebElement> list = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']/td[1]"));
		ArrayList<String> sortedAuto = new ArrayList<String>();
		for (WebElement webElement : list) {
			sortedAuto.add(webElement.getText());
		}

		Assert.assertEquals(true, sorted.equals(sortedAuto));
	}

}
