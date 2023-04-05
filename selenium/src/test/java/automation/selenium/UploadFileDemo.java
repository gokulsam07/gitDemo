package automation.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadFileDemo {
	@Test(enabled=true)
	void FileUpload() throws InterruptedException, AWTException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/file.xhtml");
		driver.manage().window().maximize();
		driver.findElement(By.id("j_idt88:j_idt89")).click();

		//StringSelection Class transfers string data as text to clip board
		StringSelection ss = new StringSelection("C:\\Users\\v-gokulsam\\Downloads\\Demo\\ENRFinal.csv");
		//toolkit is present by default in system, this is where clipBoard will be present
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		//imitate mouse events like ENTER, CTRL+C, CTRL+V
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER); //VK - Virtual Keys
	}
//Other methods includes using send keys and AutoIT. The above one is using Robot Class

}
