package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPageObjects {
	
	@FindBy(how=How.NAME,using="username") //method1
	public static WebElement username;
	
	@FindBy(name="password") //method 2 -- all selectors are there in PageFactory
	public static WebElement password;
	
	@FindBy(tagName="button")
	public static WebElement submit;

	

	
	  public static WebElement userName(WebDriver driver) 
	  { 
		  return driver.findElement(By.name("username"));
		  }
	  public static WebElement password(WebDriver driver) 
	  { 
		  return driver.findElement(By.name("password"));
	  } 
	  public static WebElement submit(WebDriver driver)
	  {
		  return driver.findElement(By.tagName("button")); 
		  }
	
}
