package pendingTopics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateActions {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		RemoteWebDriver driver1 = new ChromeDriver();
		driver1.get("https://facebook.com");
		//driver.findElement(By.id(""));
		driver1.findElementByLinkText("Forgotten password?").click();
		
		Thread.sleep(5000);
		
		// To Navigate Back
		driver1.navigate().back();
		Thread.sleep(5000);
		driver1.navigate().forward();
		
		Thread.sleep(5000);
		
		
		driver1.navigate().refresh();
		
	}
	
}
