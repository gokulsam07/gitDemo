package multiple;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;


public class DDusingPOI {

	WebDriver driver; // Class level init
	static String[][] data;
	private static XSSFWorkbook workbook;

	// For data provider using POI
	@DataProvider(name="loginData")
	public static String[][] readExcel() throws IOException {
		FileInputStream fs = new FileInputStream("C:\\Users\\v-gokulsam\\Downloads\\WBA\\CredsWB.xlsx");
		workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("credentials");

		int rowCount = sheet.getLastRowNum();
		short colCount = sheet.getRow(1).getLastCellNum();
		data = new String[rowCount+1][colCount];

		for (int i = 0; i <= rowCount; i++) {
			XSSFRow rows = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				XSSFCell cell = rows.getCell(j);
				data[i][j] = cell.getStringCellValue();
			}
		}
		return data; 
	}


	@BeforeTest public void launchDriver() { //Init in a separate method so thatit won't open browser multiple times 
		ChromeOptions op = new ChromeOptions();
		op.addArguments("--remote-allow-origins=*"); 
		driver = new ChromeDriver(op);
	}



	@Test(enabled = true,dataProvider="loginData") void Login_using_POM(String username, String password) throws InterruptedException { //actual test methods
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.tagName("button")).click();
		if(driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index")) {
			Thread.sleep(2000);
			driver.findElement(By.cssSelector(".oxd-userdropdown-tab")).click();
			driver.findElement(By.linkText("Logout")).click();}
		else System.out.println("Invalid credentials failed");
	}

	@AfterTest public void closeDriver() { driver.quit(); }


}
