package automation.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropDownsDemo {
	@Test(enabled=false)
	void SingleSelect() {
		WebDriver driver = new ChromeDriver(); //Will work without system prop because driver location set in system path variables
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		WebElement fruitList = driver.findElement(By.id("fruits"));
		Select optn = new Select(fruitList);
		System.out.println(optn.isMultiple());
		optn.selectByIndex(1);
		System.out.println(driver.findElement(By.cssSelector("p.subtitle")).getText());
	}

	@Test(enabled=false)
	void MultipleSelect() {
		WebDriver driver = new ChromeDriver(); //Will work without system prop because driver location set in system path variables
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		WebElement heroList = driver.findElement(By.id("superheros"));
		Select optn = new Select(heroList);
		System.out.println(optn.isMultiple());
		List<WebElement> list = optn.getOptions();
		for (WebElement option : list) {
			System.out.println(option.getText());
		}
	}
	@Test(enabled=false)
	void TrySelect() {
		WebDriver driver = new ChromeDriver(); //Will work without system prop because driver location set in system path variables
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		WebElement heroList = driver.findElement(By.id("superheros"));
		Select optn = new Select(heroList);
		optn.selectByVisibleText("Ant-Man");
		optn.selectByVisibleText("Aquaman");
		List<WebElement> finalList = optn.getAllSelectedOptions();
		for (WebElement option : finalList) {
			System.out.println(option.getText());
		}

	}
	@Test(enabled=true)
	void LastTry() {
		WebDriver driver = new ChromeDriver(); //Will work without system prop because driver location set in system path variables
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
		WebElement langList = driver.findElement(By.id("lang"));
		Select optn = new Select(langList);
		List<WebElement> allList = optn.getOptions();
		for (WebElement webElement : allList) {
			System.out.println(webElement.getText());
		}
		optn.selectByIndex(allList.size()-1);

	}
}
