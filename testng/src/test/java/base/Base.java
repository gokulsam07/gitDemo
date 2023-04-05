package base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Base {

	public String takeScreeshot(String name, WebDriver failedDriver) {
		File source = ((TakesScreenshot) failedDriver).getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\v-gokulsam\\Downloads\\Demo\\" + name+ ".jpg");
		try {
			FileHandler.copy(source, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return dest.getAbsolutePath();
	}
}