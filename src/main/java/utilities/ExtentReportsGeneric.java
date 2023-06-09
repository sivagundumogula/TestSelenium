package utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportsGeneric {
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public static String testCaseName, testCaseDesc, Author, Categeory;  
	
	public void startReport() {
		extent = new ExtentReports("./reports/HTMLReport.html", false);
	}
	
	public void startTest(String testName, String description) {
		test = extent.startTest(testName, description);
	}
	
	
	
	
	public void endTest() {
		extent.endTest(test);
	}
	
	public void endReport() {
		extent.flush();
	}

}
