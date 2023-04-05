package base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Base2 {

	public void takeScreeshot(WebDriver failedDriver) {
		File source = ((TakesScreenshot) failedDriver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\v-gokulsam\\Downloads\\Demo\\ssfailed.jpg");
		try {
			FileHandler.copy(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}