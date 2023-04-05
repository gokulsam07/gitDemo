package ListenMe;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import base.Base2;


public class ListernerDemo extends Base2 implements ITestListener
//public class ListernerDemo implements ITestListener
{

	public void onTestStart(ITestResult result) {
		System.out.println("Started the individual test");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Successful");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed");
		try {
			
			WebDriver failedDriver= (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			takeScreeshot(failedDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Skipped the test");
	}

	public void onStart(ITestContext context) {
		System.out.println("Started all tests");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Completed all tests");
	}

}
