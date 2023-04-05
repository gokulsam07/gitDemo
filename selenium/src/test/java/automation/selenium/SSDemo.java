package automation.selenium;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class SSDemo {
	@Test(enabled=false)
	void SS1() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/signin"); //particular element
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("gokuls2381@gmail.com", Keys.TAB,"Rioxx",Keys.TAB, Keys.ENTER);
		if(driver.getCurrentUrl().equals("https://letcode.in/signin")) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			WebElement toast = driver.findElement(By.xpath("//div[@class='toast-top-right toast-container']"));
			wait.until(ExpectedConditions.visibilityOf(toast));
			File source = driver.findElement(By.xpath("//div[@class='toast-top-right toast-container']")).getScreenshotAs(OutputType.FILE);
			File file=  new File("C:\\Users\\v-gokulsam\\Downloads\\Demo\\img.png");
			FileHandler.copy(source, file);
		}
	}
@Test(enabled=false)
	void SS2() throws InterruptedException, IOException {
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/signin"); //fullpage
		driver.manage().window().maximize();
		File source= driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\v-gokulsam\\Downloads\\Demo\\img.png");
		FileHandler.copy(source, dest);
		}	

@Test(enabled=true)
void SS3() throws InterruptedException, IOException {
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://letcode.in/signin"); //section screenshot
	driver.manage().window().maximize();
	File source=driver.findElement(By.id("navbar-menu")).getScreenshotAs(OutputType.FILE);
	File dest = new File("C:\\Users\\v-gokulsam\\Downloads\\Demo\\img.png");
	FileHandler.copy(source, dest);
	}
}


