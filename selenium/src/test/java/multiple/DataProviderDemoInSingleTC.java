package multiple;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemoInSingleTC {
	@Test(enabled = true, dataProvider="loginData")
	void Login_using_POM(String username, String password) {
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(op);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
	}

	@DataProvider(name="loginData")
	public String[][] loginDataProvider() {
		return data;
	}

	String[][] data = {{"Admin","admin123"},{"Admin1","admin123"},{"Admin","admin1234"},{"Admin1","admin1234"}};
}

