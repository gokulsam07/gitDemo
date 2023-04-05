package automation.selenium;
import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CheckDownloadDemo {
	@Test(enabled=true)
	void DownloadCheck() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/file");
		driver.manage().window().maximize();
		driver.findElement(By.id("xls")).click();
		Thread.sleep(2000);
		//Java code

		File filecheck = new File("C:\\Users\\v-gokulsam\\Downloads");
		File[] list = filecheck.listFiles();

		for (File f : list) {

			if(f.getName().equals("sample.xlsx")) {

				System.out.println("File Downloaded successfully");
				break;
			}
		}
	}
}

