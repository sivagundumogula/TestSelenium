package pom.pages;

import org.openqa.selenium.WebElement;

import wrappers.GenericFunctions;

public class IRCTC_CharterPage extends GenericFunctions {
	
	// Page Factory
	// Properties Files
	
	
	
	
	public void clickOnEnquiryForm() {
		clickByLink(objprop.getProperty("IRCTC_CharterPage.clickOnEnquiryForm"));
	}
	public void enterUserName(String name) {
		enterByName(objprop.getProperty("IRCTC_CharterPage.enterUserName"), name);
	}
	public void enterOrganizationName(String organization) {
		enterByName(objprop.getProperty("IRCTC_CharterPage.enterOrganization"), organization);
	}
	public void enterAddress(String address) {
		enterByName(objprop.getProperty("IRCTC_CharterPage.enterAddress"), address);
	}
	public void enterMobileNumber(String mobile) {
		enterByName(objprop.getProperty("IRCTC_CharterPage.enterMobile"), mobile);
	}
	public void enterEmail(String email) {
		enterByName(objprop.getProperty("IRCTC_CharterPage.enterEmail"), email);
	}
	public void selectCharter() {
		selectByValueXpath(objprop.getProperty("IRCTC_CharterPage.selectCharter"), "Saloon Charter");
	}
	public void enterOriginStation(String orgstation) {
		enterByName(objprop.getProperty("IRCTC_CharterPage.enterOrganization"), orgstation);
	}
	public void enterDestinationStation(String deststation) {
		enterByName(objprop.getProperty("IRCTC_CharterPage.enterDestinationStation"), deststation);
	}
	public void selectCheckInDate() {
		clickByName(objprop.getProperty("IRCTC_CharterPage.selectCheckinDate"));
		clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[9]/div/div/table/tbody/tr[2]/td[3]/span");
	}
	public void selectCheckOutDate() {
		clickByName(objprop.getProperty("IRCTC_CharterPage.selectCheckOutDate"));
		clickByXpath("//*[@id=\"enquiry\"]/div/form/div/div[10]/div/div/table/tbody/tr[2]/td[6]/span");
	}
	public void enterDuration(String duration) {
		enterByName(objprop.getProperty("IRCTC_CharterPage.enterDuration"), duration);
	}
	public void enterCoachDetails(String coachdetails) {
		enterByName(objprop.getProperty("IRCTC_CharterPage.enterCoachDetails"), coachdetails);
	}
	public void enterNumberOfPassangers(String numPassenger) {
		enterByName(objprop.getProperty("IRCTC_CharterPage.enterNumberOfPassengers"), numPassenger);
	}
	public void enterCharterPurpose(String purpose) {
		enterByName(objprop.getProperty("IRCTC_CharterPage.enterCharterPurpose"), purpose);
	}
	public void enterServices(String services) {
		enterByName(objprop.getProperty("IRCTC_CharterPage.enterServices"), services);
	}
	public void clickSubmit() {
		clickByXpath(objprop.getProperty("IRCTC_CharterPage.clickOnSubmit"));
	}
	

}
