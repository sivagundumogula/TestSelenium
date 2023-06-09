package pom.testcases;


import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import utilities.ObjectFactory;
import utilities.ProjectDataProvider;
import wrappers.ProjectFunctions;

public class TC001 extends ProjectFunctions{
	
	@BeforeClass(groups="SmokeTest")
	public void beforeClass() {
		testCaseName="TC001";
		testCaseDesc="IRCTC SignUp";
		Author="Shiva";
		Categeory="dryrun";
		browserName="chrome";
	}

	@Test(groups="SmokeTest", dataProvider="fetchData", dataProviderClass=ProjectDataProvider.class)
	public void tc001(Map<String, Object> map) {
		
		ObjectFactory obj = new ObjectFactory();
		obj.irctcHomePage().clickOnRegsiterButton();
		obj.irctcSignUpPage().enterUserName(map.get("UserName").toString());
		obj.irctcSignUpPage().enterPassword("Password@123");
		obj.irctcSignUpPage().confirmPassword("Password@123");
		obj.irctcSignUpPage().selectLanguage("English");
		obj.irctcSignUpPage().selectSecurityQuestion("Who was your Childhood hero?");
		obj.irctcSignUpPage().entersecurityQuestionAnswer("Chiru");
		obj.irctcSignUpPage().clickOnContinue();
		obj.irctcSignUpPage().enterFirstName("Nihira");
		obj.irctcSignUpPage().enterMiddleName("G");
		obj.irctcSignUpPage().enterLastName("G");
		obj.irctcSignUpPage().selectoccupation("Private");
		obj.irctcSignUpPage().selectDateOfBirth();
		obj.irctcSignUpPage().clickMaritalStatus();
		obj.irctcSignUpPage().clickGender();
		obj.irctcSignUpPage().enterEmailID("sdhg@gmail.com");
		obj.irctcSignUpPage().enterMobileNumber("9923599235");
		obj.irctcSignUpPage().selectNationality();
		obj.irctcSignUpPage().clickOnContinueToAddress();
		obj.irctcSignUpPage().enterFlatNumber("201");
		obj.irctcSignUpPage().enterStreetName("SugarColony");
		obj.irctcSignUpPage().enterPincode("534265");
		obj.irctcSignUpPage().selectCity();
		obj.irctcSignUpPage().selectPostOffice();
		obj.irctcSignUpPage().enterResPhoneNumber("9923599235");
		int number = Integer.parseInt(map.get("PhoneNum").toString());
		
	}
	
}
