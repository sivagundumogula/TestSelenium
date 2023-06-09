package pom.pages;

import wrappers.GenericFunctions;

public class IRCTC_LoungePage extends GenericFunctions{
	
	public void switchToNextWindow() {
		switchToLastWindow();
	}
	
	public void clickBySidebar() {
		clickById(objprop.getProperty("IRCTC_LoungePage.clickBySideBar"));
	}
	public void clickOnCharter() {
		clickByLink(objprop.getProperty("IRCTC_LoungePage.clickOnCharter"));
	}

}
