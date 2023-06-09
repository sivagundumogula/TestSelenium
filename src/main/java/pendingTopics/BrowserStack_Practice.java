package pendingTopics;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserStack_Practice {
	
	public static void main(String[] args) throws MalformedURLException {
		

		ChromeOptions browserOptions = new ChromeOptions();
		URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
		
		browserOptions.setCapability("platformName", "Windows 11");
	
		/*browserOptions.setPlatformName("Windows 11");
		
		
		
		browserOptions.setBrowserVersion("latest");*/
		Map<String, Object> sauceOptions = new HashMap<String, Object>();
		sauceOptions.put("username", "oauth-sivakumar.g1991-1b43b");
		sauceOptions.put("accessKey", "586bc3a6-3d92-4f94-a617-6fa0341f7623");
		sauceOptions.put("build", "selenium-build-D38SO");
		sauceOptions.put("name", "<your test name>");
		browserOptions.setCapability("sauce:options", sauceOptions);
		RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);
		
		driver.get("https://facebook.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		
	}

}
