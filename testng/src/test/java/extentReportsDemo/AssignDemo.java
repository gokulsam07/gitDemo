package extentReportsDemo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
//import com.aventstack.extentreports.reporter.configuration.Theme;

public class AssignDemo {

	public static void main(String[] args) throws IOException {
		ExtentReports extent  = new ExtentReports();
		File dest = new File("C:\\Users\\v-gokulsam\\Downloads\\Demo\\Report\\reportAssign.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(dest); //path is mandatory
		extent.attachReporter(spark);
//only pass report
		File dest1 = new File("C:\\Users\\v-gokulsam\\Downloads\\Demo\\Report\\reportPass.html");
		ExtentSparkReporter spark1 = new ExtentSparkReporter(dest1); //path is mandatory
		spark1.filter().statusFilter().as(new Status[] {Status.PASS}).apply();
		extent.attachReporter(spark1);
		
		//customize tabs
		
		spark.viewConfigurer().viewOrder().as(new ViewName[] {
				ViewName.AUTHOR,
				ViewName.DEVICE,
				ViewName.EXCEPTION,
				ViewName.TEST,
				ViewName.LOG,
				ViewName.DASHBOARD
		}).apply();
		
		
		//Report Customization
		
//		spark.getConf().setTheme(Theme.DARK);
//		spark.getConf().setReportName("Sample Report");
//		spark.getConf().setDocumentTitle("Gokul's report");
//		spark.getConf().setTimeStampFormat("MMM-dd,YYYY--HH:MM:SS");
		
		spark.loadJSONConfig(new File ("C:\\Users\\v-gokulsam\\eclipse-workspace\\testng\\src\\test\\java\\theme.json"));


		//sample tests

		ExtentTest test1 = extent.createTest("TestOne", "This is test one");
		test1.log(Status.INFO, "Info for testOne");
		test1.assignAuthor("Gokul");
		test1.assignCategory("Smoke");
		test1.assignCategory("Regression");
		test1.assignDevice("Win10 -Chrome");
		test1.log(Status.INFO, "Test on ended");


		ExtentTest test2 = extent.createTest("TestTwo", "This is test two");
		test2.log(Status.WARNING, "Info for testOne");
		test2.assignAuthor("Gokul","Gowtham");
		test2.assignCategory("Smoke");
		test1.assignCategory("Regression");
		test2.assignDevice("Win10 -Chrome");
		test2.log(Status.INFO, "Test two ended");

		ExtentTest test3 = extent.createTest("TestThree", "This is the third test");
		test3.log(Status.FAIL, "Info for testOne");
		test3.assignAuthor("Edison");
		test3.assignCategory("Smoke");
		test3.assignCategory("Sanity");
		test1.assignCategory("Regression");
		test3.assignDevice("Win10 -Chrome");
		test3.log(Status.FAIL, "Test three ended");
		test3.fail(new Exception("New Excpetion")); //will create a new tab for exception in report -- of there is any exception

		ExtentTest test4 = extent.createTest("TestFour", "This is the fourth  test");
		test4.log(Status.PASS, "Info for testOne");
		test4.assignAuthor(new String[] {"Gokul","Edison","Gowthan"});
		test4.assignCategory("Smoke");
		test4.assignCategory("Sanity");
		test4.assignCategory("Regression");
		test4.assignDevice("Win10 -Chrome");
		test4.log(Status.INFO, "Test three ended");



		extent.flush(); 
		Desktop.getDesktop().browse(dest.toURI()); 
		Desktop.getDesktop().browse(dest1.toURI()); //opens only pass report
	}
}
