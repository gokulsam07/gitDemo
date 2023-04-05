package automation.selenium;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BrokenElementDemo {
	@Test(enabled=false)
	void DownloadCheck() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");
		driver.manage().window().maximize();
		WebElement e = driver.findElement(By.cssSelector("div#content>div>img"));
		System.out.println(e.getAttribute("naturalWidth"));
		//WebElement e1 = driver.findElement(By.cssSelector("div#content>div>img:nth-of-type(3)"));
		if(e.getAttribute("naturalWidth").equals("0")) { //Code to check an image is broken or not

			//if the "naturalWidth" is 0, then the image is broken
			System.out.println("Broken"); 
		}
		/*
		 * if(e1.getAttribute("naturalWidth").equals(0)) { System.out.println("Broken");
		 * }else { System.out.println("Not Broken Image 2"); }
		 */ //proper image
	}

	@Test(enabled=false)
	void BrokenLinks() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize();
		//		WebElement partial = driver.findElement(By.partialLinkText("without clicking me"));
		//		System.out.println("This is where I go "+partial.getAttribute("href"));

		//		driver.findElement(By.linkText("Broken?")).click();
		//		if(driver.getTitle().contains("Error")) 
		//		{
		//			System.out.println("Page is broken");
		//			}

		driver.findElement(By.linkText("How many links in this page?")).click();
		List<WebElement> gridLink = driver.findElements(By.xpath("(//div[@class='card'])[1]//a[@href]"));

		System.out.println("Grid has "+ gridLink.size() + " links");
	}

	@Test(enabled=true)
	void InAPage() throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zlti.com/");
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		for (WebElement webElement : links) {

			try {	
				String link = webElement.getAttribute("href");
				URL url = new URL(link);
				HttpURLConnection hcon = (HttpURLConnection)url.openConnection();
				hcon.connect();
				int rcode = hcon.getResponseCode();
				if(rcode>400) {
					System.out.println(link + " is broken");
				}else {System.out.println(link + " is not broken");}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
}
