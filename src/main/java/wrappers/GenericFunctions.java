package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentReportsGeneric;

public class GenericFunctions extends ExtentReportsGeneric implements Wrappers{

	public static RemoteWebDriver driver;
	public static Properties objprop;
	
	public void logStatus(String status, String desc) {
		long number = takeSnap();
		String imagePath = System.getProperty("user.dir")+"/images/image"+number+".jpg";
		if(status.equalsIgnoreCase("Pass")) {
			test.log(LogStatus.PASS, desc+test.addScreenCapture(imagePath));
		}else if(status.equalsIgnoreCase("Fail")) {
			test.log(LogStatus.FAIL, desc+test.addScreenCapture(imagePath));
		}
	}
	
	public void loadProperties() {
		 objprop = new Properties();
		try {
			objprop.load(new FileInputStream("./src/test/java/properties/Object.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Map<String, String> setData;
	
	public static String readData(String key) {
		return setData.get(key);
	}
	
	public static void setData(Map<String, String> map) {
		setData = map;
	}
	
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}else if(browser.equalsIgnoreCase("firefox")) {
				
				driver = new FirefoxDriver();
			}else if(browser.equalsIgnoreCase("edge")) {
				
				driver = new EdgeDriver();
			}
			
			driver.get(url);
			driver.manage().window().maximize();
			loadProperties();
			//logStatus("Pass", "The "+browser+" browser launched successfully and loaded URL as - "+url);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			//logStatus("Fail", "Unable to Launch "+browser+" browser due to Timeout Issue");
		}catch (WebDriverException e) {
			// TODO: handle exception
			//logStatus("Fail", "Unable to Identify the Issue");
		}
		
	}

	public void enterById(String idValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(idValue).sendKeys(data);
			logStatus("Pass","The Element Identified Using Id Value as - "+idValue+" and Entered Data as -"+data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify The Element with Idvalue as -"+idValue+" might be locator Issue or Locator Changed");			
		}catch(ElementNotVisibleException e) {
			logStatus("Fail", "The Element With Id Value as - "+idValue+" is not Visible In UI");
		}catch(ElementNotInteractableException e) {
			logStatus("Fail", "The Element with Id Value as - "+idValue+" is Not Interactable");
		}catch(StaleElementReferenceException e) {
			logStatus("Fail", "The Element With Id Value as - "+idValue+" reference is Lost or DOM is refreshed");
		}catch(WebDriverException e) {
			logStatus("Fail", "Unable to Identify the Issue");
		}finally {
			takeSnap();
		}
		
	}

	public void enterByName(String nameValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(nameValue).sendKeys(data);
			logStatus("Pass", "The element Identified Using name Value as "+nameValue+ "and entered data as "+data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with nameValue as"+nameValue+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with nameValue "+nameValue+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with nameValue"+nameValue+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with nameValue as "+nameValue+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
		
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			logStatus("Pass", "The element Identified Using xpathValue as "+xpathValue+ "and entered data as "+data);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with xpathValue as"+xpathValue+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with xpathValue "+xpathValue+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with xpathValue"+xpathValue+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with xpathValue as "+xpathValue+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
		
	}
	public void verifyTitle(String title) {
		// TODO Auto-generated method stub
		try {
			String actTitle = driver.getTitle();
			if(actTitle.equals(title)) {
				logStatus("Pass", "Both the titles are same");
			}else {
				logStatus("pass", "Both titles are not same");
			}
		} catch (NoSuchWindowException e) {
			// TODO: handle exception
			logStatus("Fail", "No such window is present");
		}
		catch (WebDriverException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to identify the issue");
		}
	}

	public void verifyTextById(String id, String text) {
		// TODO Auto-generated method stub
		try {
			String actText = driver.findElementById(id).getText();
			if(actText.equals(text)) {
				logStatus("Pass", "Given text is same as the actual text");
			}else {
				logStatus("Pass", "Given text is not same as the actal text");
			}
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "No such window is present");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the issue");
		}
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actText = driver.findElementByXPath(xpath).getText();
			if(actText.equals(text)) {
				logStatus("Pass", "Given text is same as the actual text");
			}else {
				logStatus("Pass", "Given text is not same as the actal text");
			}
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "No such window is present");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the issue");
		}
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		try {
			String actText = driver.findElementByXPath(xpath).getText();
			if(actText.contains(text)) {
				logStatus("Pass", "Given text contains the text entered");
			}else {
				logStatus("Pass", "Given text  not contains the text entered");
			}
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "No such window is present");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the issue");
		}
	}

	// ElementClickInterceptedException can be added and Print statement is missing in try block
	public void clickById(String id) {
		// TODO Auto-generated method stub
		try {
			driver.findElementById(id).click();
			logStatus("Pass", "The element Identified Using id Value as "+id);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with id as"+id+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with id "+id+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with id"+id+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with id as "+id+" referance is lost or DOM is refreshed");
		}
		catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}
		finally {
			takeSnap();
		}
		
	}

	public void clickByClassName(String classVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByClassName(classVal).click();
			logStatus("Pass", "The element Identified Using classname Value as "+classVal);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("fail", "Unable to Identify the element with classname as"+classVal+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with classname "+classVal+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with classname"+classVal+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with classname as "+classVal+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
		
		
	}

	public void clickByName(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByName(name).click();
			logStatus("Pass", "The element Identified Using name Value as "+name);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with Name as"+name+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Name "+name+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Name"+name+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Name as "+name+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
	}

	public void clickByLink(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			logStatus("Pass", "The element Identified Using Link Text as "+name);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with Link Name as"+name+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Link Name "+name+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Link Name"+name+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Link Name as "+name+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
	}

	public void clickByLinkNoSnap(String name) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByLinkText(name).click();
			logStatus("Pass", "The element Identified Using Link Text as "+name+"and clicked");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with Link Name as"+name+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Link Name "+name+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Link Name"+name+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Link Name as "+name+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			logStatus("Pass", "The element Identified Using xpath Value as "+xpathVal+"and clicked");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with  Xpath as"+xpathVal+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Xpath "+xpathVal+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Xpath"+xpathVal+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Xpath as "+xpathVal+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
	}
	
	public void clickTheElement(WebElement xpathVal) {
		// TODO Auto-generated method stub
		try {
			xpathVal.click();
			logStatus("Pass", "The element Identified Using xpath Value as "+xpathVal+"and clicked");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with  Xpath as"+xpathVal+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Xpath "+xpathVal+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Xpath"+xpathVal+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Xpath as "+xpathVal+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
	}

	public void clickByXpathNoSnap(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			logStatus("Pass", "The element Identified Using Xpath as "+xpathVal+" is clicked");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail","Unable to Identify the element with  Xpath as"+xpathVal+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Xpath "+xpathVal+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Xpath"+xpathVal+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Xpath as "+xpathVal+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}
	}

	public String getTextById(String idVal) {
		// TODO Auto-generated method stub
		String text = null;
		try {
			text = driver.findElementById(idVal).getText();
			logStatus("Pass", "The element Identified Using id Value as "+idVal);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with  ID as"+idVal+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail","The element with ID "+idVal+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with ID"+idVal+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with ID as "+idVal+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
		return text;
	}
	
	
// return the text and add print statements in try block
	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		String text=null;
		try {
			driver.findElementByXPath(xpathVal).getText();
			logStatus("Pass", "The element Identified Using xpath Value as "+xpathVal);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with  Xpath as"+xpathVal+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Xpath "+xpathVal+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Xpath"+xpathVal+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with Xpath as "+xpathVal+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
		return text;
	}

	// elementNotSelectable exception cna be added
	public void selectVisibileTextById(String id, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement ID = driver.findElementById(id);
			Select sel = new Select(ID);
			sel.selectByVisibleText(value);
			logStatus("Pass", "The element Identified Using visible text and id Value as "+id);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with  ID as"+id+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with ID "+id+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with ID"+id+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with ID as "+id+" referance is lost or DOM is refreshed");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with ID as"+id+"is not selectable");
		}
		catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
	}

	public void selectIndexById(String id, int value) {
		// TODO Auto-generated method stub
		try {
			WebElement ID = driver.findElementById(id);
			Select sel = new Select(ID);
			sel.selectByIndex(value);
			logStatus("Pass", "The element Identified Using id Value as "+id);
		} 
		catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Pass","Unable to Identify the element with  ID as"+id+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with ID "+id+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with ID"+id+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with ID as "+id+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
	}

	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> IDS = driver.getWindowHandles();
			Iterator<String> itr = IDS.iterator();
			while(itr.hasNext()) {
				driver.switchTo().window(itr.next());
			}
			String firstWinId = itr.next();
			String secondWinId = itr.next();
			driver.switchTo().window(firstWinId);
			logStatus("Pass", "Window switch is success");
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "No such window is present");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
	}

	// update logic to support switchto last window
	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		try {
			Set<String> IDS = driver.getWindowHandles();
			Iterator<String> itr = IDS.iterator();
			while(itr.hasNext()) {
				driver.switchTo().window(itr.next());
				logStatus("Pass", "Switch to last window is success");
			}
			//String firstWinId = itr.next();
			//String secondWinId = itr.next();
			//driver.switchTo().window(secondWinId);
		} catch (NoSuchWindowException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "No such window is present");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
			logStatus("Pass", "alert accepted");
		} catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unhandled Alert");
		}catch (NoAlertPresentException e) {
			// TODO: handle exception
			logStatus("Fail", "NO such alert is present");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			logStatus("Pass", "alert dismissed");
		} catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unhandled Alert");
		}catch (NoAlertPresentException e) {
			// TODO: handle exception
			logStatus("Fail", "NO such alert is present");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}
	}

	// return the text 
	public String getAlertText() {
		// TODO Auto-generated method stub
		String text=null;
		try {
			driver.switchTo().alert().getText();
			logStatus("Pass", "The text from alert is printed successfully");
		} catch (UnhandledAlertException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unhandled Alert");
		}catch (NoAlertPresentException e) {
			// TODO: handle exception
			logStatus("Fail", "NO such alert is present");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}
		return text;
	}

	public long takeSnap() {
		// TODO Auto-generated method stub
		long number = System.currentTimeMillis();
		File pic=driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./images/image"+number+".jpg");
		//logStatus("Pass", "Snap taken successfully");
		try {
			FileUtils.copyFile(pic, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return number;
	}

	// nosuch window exception can be added
	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to identify the isssue");
		}
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			driver.quit();
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to identify the isssue");
		}
	}

	public void mouseHoverUsingXpath(String xpathValue) {
		// TODO Auto-generated method stub
		try {
			WebElement ele = driver.findElementByXPath(xpathValue);
			Actions act = new Actions(driver);
			act.moveToElement(ele).perform();
			logStatus("Pass", "The element Identified Using xpath Value as "+xpathValue);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with xpathValue as"+xpathValue+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with xpathValue "+xpathValue+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with xpathValue"+xpathValue+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with xpathValue as "+xpathValue+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
	}

	public void selectByValueXpath(String xpath, String value) {
		// TODO Auto-generated method stub
		try {
			WebElement ID = driver.findElementByXPath(xpath);
			Select sel = new Select(ID);
			sel.selectByValue(value);
			logStatus("Pass", "The element Identified Using xpath Value as "+xpath);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with  ID as"+xpath+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with ID "+xpath+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with ID"+xpath+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with ID as "+xpath+" referance is lost or DOM is refreshed");
		}catch (ElementNotSelectableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with ID as"+xpath+"is not selectable");
		}
		catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
	}

	public void mouseClickUsingLinkText(String linkText) {
		// TODO Auto-generated method stub
		try {
			WebElement ele = driver.findElementByLinkText(linkText);
			Actions act = new Actions(driver);
			act.click(ele).perform();
			logStatus("Pass", "Mouse click is success");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			logStatus("Fail", "Unable to Identify the element with xpathValue as"+linkText+"might be locator issue or locator changed");
		}catch (ElementNotVisibleException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with xpathValue "+linkText+"is not visible in UI");
		}catch (ElementNotInteractableException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with xpathValue"+linkText+"is not Interactable");
		}catch (StaleElementReferenceException e) {
			// TODO: handle exception
			logStatus("Fail", "The element with xpathValue as "+linkText+" referance is lost or DOM is refreshed");
		}catch (WebDriverException e) {
			// TODO: handle exception
			logStatus("Fail", "Unable to identify the isssue");
		}finally {
			takeSnap();
		}
	}

	
	
}
