package pom.pages;

import wrappers.GenericFunctions;

public class IRCTC_SignUpPage extends GenericFunctions{
	
	public void enterUserName(String userName) {
		enterById(objprop.getProperty("IRCTC_SignUpPage.enterUserName"), userName);
	}
	
	public void enterPassword(String pwd) {
		enterById(objprop.getProperty("IRCTC_SignUpPage.enterPassword"), pwd);
	}
	public void confirmPassword(String cnfpwd) {
	
		enterById(objprop.getProperty("IRCTC_SignUpPage.enterCnfrmPassword"), cnfpwd);
	}
	
	public void selectLanguage(String language) {
		clickByXpath(objprop.getProperty("IRCTC_SignUpPage.selectLanguage"));
		
		clickByXpath("//li[@aria-label='"+language+"']");
	}
	public void selectSecurityQuestion(String question) {
		clickByXpath(objprop.getProperty("IRCTC_SignUpPage.selectSecurityQuestion"));
		clickByXpath("//span[text()='"+question+"']");
	}
	public void entersecurityQuestionAnswer(String answer) {
		enterByXpath(objprop.getProperty("IRCTC_SignUpPage.enterSecurityAnswer"), answer);
	}
	public void clickOnContinue() {
		clickByXpath(objprop.getProperty("IRCTC_SignUpPage.clickOnContinue"));
	}
	public void enterFirstName(String firstName) {
		enterById(objprop.getProperty("IRCTC_SignUpPage.enterFirstName"), firstName);
	}
	public void enterMiddleName(String middleName) {
		enterById(objprop.getProperty("IRCTC_SignUpPage.enterMiddleName"), middleName);
	}
	public void enterLastName(String lastName) {
		enterById(objprop.getProperty("IRCTC_SignUpPage.enterLastName"), "jsdfhi");
	}
	public void selectoccupation(String occupation) {
		clickByXpath(objprop.getProperty("IRCTC_SignUpPage.selectOccupation"));
		clickByXpath("//span[text()='"+occupation+"']");
	}
	public void selectDateOfBirth() {
		clickByXpath(objprop.getProperty("IRCTC_SignUpPage.selectDateOfBirth"));
		clickByXpath("//*[@id=\"ui-tabpanel-1\"]/div/div[6]/p-calendar/span/div/div/div[2]/table/tbody/tr[1]/td[1]/a");
	}
	public void clickMaritalStatus() {
		clickById(objprop.getProperty("IRCTC_SignUpPage.clickMaritalStatus"));
	}
	public void clickGender() {
		clickByXpath(objprop.getProperty("IRCTC_SignUpPage.clickGender"));
	}
	public void enterEmailID(String email) {
		enterById(objprop.getProperty("IRCTC_SignUpPage.enterEmailID"), email);
	}
	public void enterMobileNumber(String mobile) {
		enterById(objprop.getProperty("IRCTC_SignUpPage.enterMobileNumber"), mobile);
	}
	public void selectNationality() {
		selectByValueXpath(objprop.getProperty("IRCTC_SignUpPage.selectNationality"), "94");
	}
	public void clickOnContinueToAddress() {
		clickByXpath(objprop.getProperty("IRCTC_SignUpPage.clickOnContinueToAddress"));
	}
	public void enterFlatNumber(String flatNumber) {
		enterById(objprop.getProperty("IRCTC_SignUpPage.enterFlatNumber"), flatNumber);
	}
	public void enterStreetName(String streetName) {
		enterById(objprop.getProperty("IRCTC_SignUpPage.enterStreetName"), streetName);
	}
	public void enterPincode(String pincode) {
		enterByName(objprop.getProperty("IRCTC_SignUpPage.enterPinCode"), pincode);
	}
	public void selectCity() {
		clickByXpath(objprop.getProperty("IRCTC_SignUpPage.selectCity"));
        clickByXpath("//select[@formcontrolname='resCity']/descendant::option[2]");
	}
	public void selectPostOffice() {
		 clickByXpath(objprop.getProperty("IRCTC_SignUpPage.selectPostOffice"));
	}
	public void enterResPhoneNumber(String resPhoneNumber) {
		 enterById(objprop.getProperty("IRCTC_SignUpPage.enterResPhoneNumber"), resPhoneNumber);
	}
	
	

}
