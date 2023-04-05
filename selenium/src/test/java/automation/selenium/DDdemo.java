package automation.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class DDdemo {
	
	@Test(enabled=false)
	void DD() {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement frame  = driver.findElement(By.tagName("iframe")); //inside the frame, so switctTo
		driver.switchTo().frame(frame);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).build().perform();
	}
	@Test(enabled=true)
	void DDby() {
		WebDriver driver = new ChromeDriver(); 
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		WebElement frame  = driver.findElement(By.tagName("iframe")); 
		driver.switchTo().frame(frame);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Point p = target.getLocation();
		Actions action = new Actions(driver);
		action.dragAndDropBy(source, p.getX(), p.getY()).build().perform();
	}

}
