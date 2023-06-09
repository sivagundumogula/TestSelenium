package utilities;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HTMLReporter_Practice {
	// Report Name, and Location
	// Test Case Name
	// Test Case Description
	// Test Step Status
	
	@Test
	public void reports() {
		
		// startReport
		ExtentReports report = new ExtentReports("./reports/report.html");
		
		// start test
		ExtentTest test = report.startTest("Test Case Name", "Test cAse Description");
		
		//logstatus
		test.log(LogStatus.PASS, "Test Step Passed");
		test.log(LogStatus.PASS, "Test Step Passed");
		test.log(LogStatus.PASS, "Test Step Passed");
		test.log(LogStatus.PASS, "Test Step Passed");
		test.log(LogStatus.FAIL, "Test Step Failed");
		test.log(LogStatus.PASS, "Test Step Passed");
		
		// endText
		report.endTest(test);;
		
		// endReport
		report.flush();
		
		
	}

}
