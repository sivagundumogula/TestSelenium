package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ProjectFunctions extends GenericFunctions{
	
	public static String browserName;
	
	@BeforeSuite(groups= {"SmokeTest", "RegressionTest", "FunctionalTest"})
	public void berforeSuite() {
		startReport();
	}
	
	@BeforeTest(groups= {"SmokeTest", "RegressionTest", "FunctionalTest"})
	public void beforeTest() {
		loadProperties();
	}
	
	@BeforeMethod(groups= {"SmokeTest", "RegressionTest", "FunctionalTest"})
	public void beforeMethod() {
		startTest(testCaseName, testCaseDesc);
		test.assignAuthor(Author);
		test.assignCategory(Categeory);
		invokeApp("chrome", "https://www.irctc.co.in/nget/train-search");
	}
	
	@AfterMethod(groups= {"SmokeTest", "RegressionTest", "FunctionalTest"})
	public void afterMethod() {
		closeAllBrowsers();
	}
	@AfterClass(groups= {"SmokeTest", "RegressionTest", "FunctionalTest"})
	public void afterClass() {
		endTest();
	}
	@AfterTest(groups= {"SmokeTest", "RegressionTest", "FunctionalTest"})
	public void afterTest() {
	}
	@AfterSuite(groups= {"SmokeTest", "RegressionTest", "FunctionalTest"})
	public void afterSuite() {
		
		endReport();
	}
}
