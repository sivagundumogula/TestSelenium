package pom.testcases;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElementsConcept {


	@Test
	public void findElement() throws InterruptedException {
		
		List<String> list = Arrays.asList("Train","Train Name","From","Dep.","Date", "To","Arr.", "Dates", "Travels","R","M", "T", "W","T","F","S","S", "1A", "2A", "3A", "CC", "SL", "2S", "3E");
						
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		driver.findElementById("buttonFromTo").click();
		Thread.sleep(5000);
		List<WebElement> list1 = driver.findElementsByXPath("//div[@id='divTrainsList']/table/tbody/tr/th/a");
		System.out.println(list1.size());
		/*for(int i=0; i<list1.size(); i++) {
			String text = list1.get(i).getText();
			if(text.equals(list.get(i))) {
				System.out.println(text+" matches with"+list.get(i));
			}else {
				System.out.println(text+" Not matches with"+list.get(i));
			}
		}*/
		
		SoftAssert sa = new SoftAssert();
		for(int i=0; i<list1.size(); i++) {
			//Assert.assertEquals(list1.get(i).getText(), list.get(i));
			sa.assertEquals(list1.get(i).getText(), list.get(i));
		}
		sa.assertAll();
		
	}
	
}
