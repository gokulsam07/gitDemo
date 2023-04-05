package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DashboardLogoutObject {
	//PageFacotry
	@FindBy(css=".oxd-userdropdown-tab")
	public static WebElement profile;
	@FindBy(linkText="Logout")
	public static WebElement logout;
	
	/* Can we find elements without normal POM or FindBy annotation?
	 * YES - HOW? 
	 * if the element id/name in DOM & public static WebElement <id/name>; matches, Page factory will automatically try to find id then name
	 * If it matches, the element will be found & necessary operations will be done
	 * However, it is applicable only when there is ID or Name --> order of search will be ID -> Name by PF
	 */
	
	
	//Normal POM
	public static WebElement Profile(WebDriver driver) {
		return driver.findElement(By.cssSelector(".oxd-userdropdown-tab"));
	}
	public static WebElement Logout(WebDriver driver) {
		return driver.findElement(By.linkText("Logout"));
	}
}
