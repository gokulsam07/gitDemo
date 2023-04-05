package extentReportsDemo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.TakesScreenshot;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TakeSSReportDemo {

	public static WebDriver driver =null;

	public static void main(String[] args) throws IOException, InterruptedException {
		ExtentReports extent = new ExtentReports();
		File dst = new File("C:\\Users\\v-gokulsam\\Downloads\\Demo\\Report\\report.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(dst);
		extent.attachReporter(spark);
		ExtentTest test1 = extent.createTest("TestOne");
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(op);
		driver.manage().window().maximize();
		test1.log(Status.INFO, "Test one started");
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("gokuls2381@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Rox132&");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		//String ss= takeScreenshot();
		test1.log(Status.FAIL,  MediaEntityBuilder.createScreenCaptureFromBase64String(takeScreenshot(), "Enter the correct username/password").build());
		//test1.log(Status.FAIL, "Test one ended");
		//test1.addScreenCaptureFromBase64String(ss,"Login Failed");
		
		test1.log(Status.INFO, "Test one ended");
		extent.flush();
		Desktop.getDesktop().browse(dst.toURI());



	}

	public static String takeScreenshot() throws IOException {
//		File ss = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		File dest = new File("C:\\Users\\v-gokulsam\\Downloads\\Demo\\"+name+".png");
//		FileHandler.copy(ss, dest);
//		return dest.toString();
		
		String base64Code = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		return base64Code;
	}
}
