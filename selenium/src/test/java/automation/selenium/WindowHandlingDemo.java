package automation.selenium;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class WindowHandlingDemo {
	@Test(enabled=false)
	void parentWindow() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/windows");
		driver.manage().window().maximize();
		driver.findElement(By.id("home")).click();
		String name = driver.getWindowHandle();
		System.out.println("Parent "+name);
		Set<String> set = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(set);
		System.out.println("Parent "+list.get(0));
		System.out.println("Child "+list.get(1));
		driver.close(); //close the parent window
		list.remove(0);
		driver.switchTo().window(list.get(0)); //switches to the left over window
		System.out.println(driver.getCurrentUrl());
	}

	@Test(enabled=true)
	void MutiWindow() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/windows");
		driver.manage().window().maximize();
		driver.findElement(By.id("home")).click();
		driver.findElement(By.id("multi")).click();
		driver.findElement(By.id("multi")).click();
		driver.findElement(By.id("multi")).click();
		Set<String> set = driver.getWindowHandles();
		ArrayList<String> list = new ArrayList<String>(set);
		/*
		 * for (String windows : list) { System.out.println(windows); }
		 */

		System.out.println(driver.getCurrentUrl());
		driver.close();
		list.remove(0);
		driver.switchTo().window(list.get(0));
		System.out.println(driver.getCurrentUrl());
		driver.close();
		list.remove(0);
		driver.switchTo().window(list.get(0));
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getCurrentUrl());
		driver.quit();


	}
}
