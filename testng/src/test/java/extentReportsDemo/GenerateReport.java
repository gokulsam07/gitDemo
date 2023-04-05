package extentReportsDemo;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class GenerateReport {
	
	public static ExtentReports getReport() {
		ExtentReports report  = new ExtentReports();
		File dest = new File("C:\\Users\\v-gokulsam\\Downloads\\Demo\\Report\\bac.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(dest); 
		report.attachReporter(spark);
		return report;
		
	}

}
