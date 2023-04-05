package automation.selenium;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertsDemo {
	@Test(enabled=false)
	void SimpleAlert() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.manage().window().maximize();
		driver.findElement(By.id("accept")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
	}
	
	@Test(enabled=false)
	void ConfirmAlert() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.manage().window().maximize();
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		//alert.accept();
		System.out.println(alert.getText());
		alert.dismiss();
	}
	
	@Test(enabled=false)
	void PromptAlert() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.manage().window().maximize();
		driver.findElement(By.id("prompt")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.sendKeys("Gokul");
		alert.accept();
	}
	
	@Test(enabled=false)
	void SweetAlert() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.manage().window().maximize();
		driver.findElement(By.id("modern")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[aria-label='close']")).click();
	}
	
	@Test(enabled=false)
	void JavaScriptAlerOrBootstrapAlert() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		driver.manage().window().maximize();
		driver.findElement(By.id("modern")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("button[aria-label='close']")).click();
	}
}
