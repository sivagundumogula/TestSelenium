package pom.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import wrappers.GenericFunctions;

public class IRCTC_HomePage extends GenericFunctions {
	

	@FindBy(xpath="//a[text()=' REGISTER '] ")
	private WebElement registerButton;
	
	public IRCTC_HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnRegsiterButton() {
		clickTheElement(registerButton);
	}
	
	public void clickonTrains() {
		clickByXpath(objprop.getProperty("IRCTC_HomePage.clickOnTrains"));
	}
	
	public void mouseHoverOnHolidays() {
		mouseHoverUsingXpath(objprop.getProperty("IRCTC_HomePage.clickOnHolidays"));
	}
	
	public void mouseHoverOnStays() {
		mouseHoverUsingXpath(objprop.getProperty("IRCTC_HomePage.clickOnStays"));
	}
	
	public void clickOnLounge() {
		mouseClickUsingLinkText(objprop.getProperty("IRCTC_HomePage.clickOnLounge"));
	}

}
