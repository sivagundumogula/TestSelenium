package stepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.ObjectFactory;

public class Hooks_Practice {
	
	ObjectFactory obj = new ObjectFactory();
	
	@Before
	public void beforeHook() {
		obj.genericFunctions().startReport();
		obj.genericFunctions().invokeApp("", "");
	}

	@After
	public void afterHook() {
		obj.genericFunctions().closeAllBrowsers();
		obj.genericFunctions().endTest();
		obj.genericFunctions().endReport();
	}
}
