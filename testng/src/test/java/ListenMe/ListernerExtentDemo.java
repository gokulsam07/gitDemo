package ListenMe;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base.Base;
import extentReportsDemo.GenerateReport;

public class ListernerExtentDemo extends Base implements ITestListener {
	ExtentReports report = GenerateReport.getReport();
	public ExtentTest eTest;
	public void onTestStart(ITestResult result) {
		String test =result.getName(); 
		System.out.println(test);
		eTest = report.createTest(test);
		eTest.log(Status.INFO, "Started test");

	}

	public void onTestSuccess(ITestResult result) {
		String test =result.getName(); 
		eTest.log(Status.PASS, test+" Test passed");
	}

	public void onTestFailure(ITestResult result) {
		String test =result.getName(); 
		eTest.log(Status.FAIL, test+" Test failed");
		WebDriver driver =null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception  e) {
			e.printStackTrace();
		} 
		eTest.addScreenCaptureFromPath(takeScreeshot(test,driver));

	}

	public void onStart(ITestResult result) {
		String test =result.getName(); 
		eTest.log(Status.PASS, test+" Test Started");
	}

	public void onFinish(ITestContext context) {
		report.flush();
		File rep = new File("C:\\Users\\v-gokulsam\\Downloads\\Demo\\Report\\bac.html");
		try {
			Desktop.getDesktop().browse(rep.toURI());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
