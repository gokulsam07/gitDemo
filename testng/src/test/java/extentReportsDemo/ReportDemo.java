package extentReportsDemo;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportDemo {

	public static void main(String[] args) throws IOException {
		ExtentReports extent  = new ExtentReports();
		File dest = new File("C:\\Users\\v-gokulsam\\Downloads\\Demo\\Report\\report.html");
		ExtentSparkReporter spark = new ExtentSparkReporter(dest); //path is mandatory
		extent.attachReporter(spark);
		
		
		//sample tests
		
		ExtentTest test1 = extent.createTest("TestOne");
		test1.log(Status.INFO, "Info for testOne");
		test1.log(Status.WARNING, "<b><i><u>Info for testOne</b></i></u>"); //Formatting message/log
		
		
		String xml ="<note>\r\n"
				+ "<to>Tove</to>\r\n"
				+ "<from>Jani</from>\r\n"
				+ "<heading>Reminder</heading>\r\n"
				+ "<body>Don't forget me this weekend!</body>\r\n"
				+ "</note>";
		
		test1.log(Status.INFO, MarkupHelper.createCodeBlock(xml,CodeLanguage.XML));
		
		String json ="{  \r\n"
				+ "    \"employee\": {  \r\n"
				+ "        \"name\":       \"sonoo\",   \r\n"
				+ "        \"salary\":      56000,   \r\n"
				+ "        \"married\":    true  \r\n"
				+ "    }  \r\n"
				+ "}  ";
		test1.log(Status.INFO, MarkupHelper.createCodeBlock(json,CodeLanguage.JSON));
		
		ArrayList<String> al =new ArrayList<String>();
		al.add("Monday");
		al.add("Tuesday");
		al.add("Thursday");
		al.add("Friday");
		al.add("Sunday");
		al.add("Wednesday");
		al.add("Saturday");
		
		test1.log(Status.INFO, MarkupHelper.createUnorderedList(al));
		
		test1.log(Status.INFO, MarkupHelper.createOrderedList(al));
		
		test1.log(Status.PASS, "Warning test one");
		test1.pass("TestOne got passed");
		//test1.log(Status.PASS, "TestOne got passed"); //above line & this means the same thing
		
		
		ExtentTest test2 = extent.createTest("TestTwo");
		//test2.fail("TestTwo got failed");
		try {
			System.out.println(9/0);
		} catch (Exception e) {
			test2.fail(e);
		}
		
		test2.log(Status.INFO, MarkupHelper.createLabel("TestTwo got failed", ExtentColor.BLUE));
		
		ExtentTest test3 = extent.createTest("TestThree", "This is the third test");
		test3.skip("TestThree got Skipped");
		
		
		
		extent.flush(); // if this line is not there, report file will not be generated
		Desktop.getDesktop().browse(dest.toURI()); // to automatically open the file after flushing
	}
}
