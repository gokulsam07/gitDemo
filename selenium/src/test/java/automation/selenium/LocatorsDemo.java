package automation.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class LocatorsDemo {


	@Test(enabled=false)
	void byId() {
		WebDriver driver = new ChromeDriver(); //Will work without system prop because driver location set in system path variables
		driver.get("https://letcode.in/edit");
		driver.manage().window().maximize();
		driver.findElement(By.id("fullName")).sendKeys("Gokul");
	}

	@Test(enabled=false)
	void byclassName() {
		WebDriver driver = new ChromeDriver(); //Will work without system prop because driver location set in system path variables
		driver.get("https://letcode.in/edit");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.className("content"));
		System.out.println(ele.getText());
	}
	@Test(enabled=false)
	void byTagName() {
		WebDriver driver = new ChromeDriver(); //Will work without system prop because driver location set in system path variables
		driver.get("https://letcode.in/signup");
		driver.manage().window().maximize();
		WebElement ele = driver.findElement(By.tagName("button"));
		System.out.println(ele.getText());
	}

	@Test(enabled=false)
	void byName() {
		WebDriver driver = new ChromeDriver(); //Will work without system prop because driver location set in system path variables
		driver.get("https://letcode.in/signin");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("Gokul");

	}

	@Test(enabled=true)
	void bylinkandPartialLinkText() {
		WebDriver driver = new ChromeDriver(); //Will work without system prop because driver location set in system path variables
		driver.get("https://letcode.in/buttons");
		driver.findElement(By.partialLinkText("Sign")).click();
		driver.findElement(By.linkText("Log in")).click();

	}



}
