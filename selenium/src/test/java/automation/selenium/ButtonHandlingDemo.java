package automation.selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ButtonHandlingDemo {
	@Test(enabled=false)
	void ButtonRadio() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/radio");
		driver.manage().window().maximize();
		driver.findElement(By.id("no")).click();
		driver.findElement(By.id("two")).click();
	}

	@Test(enabled=false)
	void SelectedDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/radio");
		driver.manage().window().maximize();
		driver.findElement(By.id("no")).click();
		System.out.println(driver.findElement(By.id("no")).isDisplayed());
		System.out.println(driver.findElement(By.id("no")).isEnabled());
		System.out.println(driver.findElement(By.id("no")).isSelected());
		System.out.println(driver.findElement(By.id("yes")).isSelected());
	}

	@Test(enabled=false)
	void FindBug() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/radio");
		driver.manage().window().maximize();
		driver.findElement(By.id("bug")).click();
		driver.findElement(By.id("nobug")).click();
		boolean e1= driver.findElement(By.id("bug")).isSelected();
		boolean e2= driver.findElement(By.id("nobug")).isSelected();
		if (e1==e2) {
			System.out.println("bug");
		}else System.out.println("Not an issue");
	}

	@Test(enabled=false)
	void FindSelected() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/radio");
		driver.manage().window().maximize();
		System.out.println("Status of bar before action "+ driver.findElement(By.id("notfoo")).isSelected());
		System.out.println("Status of foo before action "+ driver.findElement(By.id("foo")).isSelected());
		driver.findElement(By.id("foo")).click();
		System.out.println("Status of foo before action "+driver.findElement(By.id("foo")).isSelected());
		System.out.println("Status of bar before action "+driver.findElement(By.id("notfoo")).isSelected());
		System.out.println(driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).isSelected());
	}

	@Test(enabled=false)
	void EnabledDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/radio");
		driver.manage().window().maximize();
		System.out.println("Going Enabled "+driver.findElement(By.id("going")).isEnabled());
		System.out.println("Maybe Enabled "+driver.findElement(By.id("maybe")).isEnabled());
	}
	@Test(enabled=true)
	void CheckBoxDemo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		System.out.println("Before change CB1 "+driver.findElement(By.id("checkbox1")).isSelected());
		System.out.println("Before change CB2 "+driver.findElement(By.id("checkbox2")).isSelected());
		driver.findElement(By.id("checkbox1")).click();
		driver.findElement(By.id("checkbox2")).click();
		System.out.println("After change CB1 "+driver.findElement(By.id("checkbox1")).isSelected());
		System.out.println("After change CB2 "+driver.findElement(By.id("checkbox2")).isSelected());
	}


}
