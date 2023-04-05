package automation.selenium;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseActionsDemo {
	@Test(enabled=false)
	void moveToAndClick() {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://letcode.in/selectable");
		driver.manage().window().maximize();
		//driver.switchTo().frame(0);
		WebElement one = driver.findElement(By.xpath("(//h3[@id='clour'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(one).click().build().perform();
		String clr = driver.findElement(By.cssSelector("div.ui-selectable.ui-selected")).getCssValue("background-color");
		System.out.println(clr);
	}

	@Test(enabled=false)
	void DoubleClick() {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		WebElement dc = driver.findElement(By.xpath("//button[@ondblclick='dblclickAlert()']"));
		Actions action = new Actions(driver);
		action.doubleClick(dc).build().perform();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(enabled=false)
	void ContextClick() {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();
		WebElement rc = driver.findElement(By.cssSelector("span.context-menu-one.btn.btn-neutral"));
		Actions action = new Actions(driver);
		action.contextClick(rc).build().perform();
		driver.findElement(By.cssSelector("body#authentication>ul>li>span")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
	}

	@Test(enabled=false)
	void SelectMultipleKeys() throws InterruptedException {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://letcode.in/edit");
		driver.manage().window().maximize();
		driver.findElement(By.id("fullName")).sendKeys("gokul");
		Thread.sleep(1000);
		driver.findElement(By.id("fullName")).sendKeys(Keys.chord(Keys.CONTROL,"z"));
	}

	@Test(enabled=false) //https://jqueryui.com/selectable/
	void ChordTab() throws InterruptedException {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://letcode.in/edit");
		driver.manage().window().maximize();
		WebElement link = driver.findElement(By.linkText("Work-Space"));
		Actions action = new Actions(driver);
		action.moveToElement(link).keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).perform();
	}

	@Test(enabled=true) 
	void SelectableDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://jqueryui.com/selectable/");
		driver.manage().window().maximize();
		WebElement frame = driver.findElement(By.tagName("iframe"));
		driver.switchTo().frame(frame);
		List<WebElement> selectables = driver.findElements(By.xpath("//ol[@id='selectable']//li"));
		Actions action = new Actions(driver);
		action.clickAndHold(selectables.get(0)).clickAndHold(selectables.get(1)).clickAndHold(selectables.get(2)).build().perform();

	}
}
