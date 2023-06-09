package pom.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.ObjectFactory;
import wrappers.ProjectFunctions;

public class TC002 extends ProjectFunctions {
	@BeforeClass(groups="RegressionTest")
	public void beforeClass() {
		testCaseName="TC002";
		testCaseDesc="IRCTC Lounge+";
		Author="Shiva";
		Categeory="dryrun";
	}
	@Test(groups="RegressionTest")
	public void tc002() {
		ObjectFactory obj = new ObjectFactory();
		obj.irctcHomePage().mouseHoverOnHolidays();
		obj.irctcHomePage().mouseHoverOnStays();
		obj.irctcHomePage().clickOnLounge();
		obj.irctcLoungePage().switchToNextWindow();
		obj.irctcLoungePage().clickBySidebar();
		obj.irctcLoungePage().clickOnCharter();
		obj.irctcCharterPage().clickOnEnquiryForm();
		obj.irctcCharterPage().enterUserName("Nihira");
		obj.irctcCharterPage().enterOrganizationName("Techm");
		obj.irctcCharterPage().enterAddress("asdhiudef");
		obj.irctcCharterPage().enterMobileNumber("9923599235");
		obj.irctcCharterPage().enterEmail("sdjfiu@gmail.com");
		obj.irctcCharterPage().selectCharter();
		obj.irctcCharterPage().enterOriginStation("sdj");
		obj.irctcCharterPage().enterDestinationStation("hdjk");
		obj.irctcCharterPage().selectCheckInDate();
		obj.irctcCharterPage().selectCheckOutDate();
		obj.irctcCharterPage().enterDuration("7");
		obj.irctcCharterPage().enterCoachDetails("sdhjhfk");
		obj.irctcCharterPage().enterNumberOfPassangers("9");
		obj.irctcCharterPage().enterCharterPurpose("jdhku");
		obj.irctcCharterPage().enterServices("jedhke");
		obj.irctcCharterPage().clickSubmit();
	}

}
