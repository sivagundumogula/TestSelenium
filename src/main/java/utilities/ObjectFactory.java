package utilities;

import pom.pages.IRCTC_CharterPage;
import pom.pages.IRCTC_HomePage;
import pom.pages.IRCTC_LoungePage;
import pom.pages.IRCTC_SignUpPage;
import wrappers.GenericFunctions;

public class ObjectFactory {
	
	public GenericFunctions genericFunctions() {
		return new GenericFunctions();
	}
	
	public IRCTC_HomePage irctcHomePage() {
		return new IRCTC_HomePage();
	}
	
	public IRCTC_SignUpPage irctcSignUpPage() {
		return new IRCTC_SignUpPage();
	}
	
	public IRCTC_LoungePage irctcLoungePage() {
		return new IRCTC_LoungePage();
	}
	
	public IRCTC_CharterPage irctcCharterPage() {
		return new IRCTC_CharterPage();
	}

}
