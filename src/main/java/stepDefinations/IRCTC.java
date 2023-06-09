package stepDefinations;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import utilities.JSONReader;
import utilities.ObjectFactory;
import wrappers.GenericFunctions;

public class IRCTC {

ChromeDriver driver;
ObjectFactory obj = new ObjectFactory();

@Before
@Given("Launch ChromeBrowser and load URL")
public void launch_chrome_browser_and_load_url() {
    
}
@When("click on Register")
public void click_on_register() {
    
}
@When("enter user name")
public void enter_user_name() {
    
}
@When("enter password")
public void enter_password() {
    
}
@When("confirm password")
public void confirm_password() {
   
}
@When("select language")
public void select_language() {
    
}
@When("select security question")
public void select_security_question() {
    
}
@When("click on continue")
public void click_on_continue() {
    
}
@When("enter first name")
public void enter_first_name() {
    
}
@When("enter last name")
public void enter_last_name() {
    
}
@When("enter middle name")
public void enter_middle_name() {
    
}
@When("select occupation")
public void select_occupation() {
    
}
@When("select date of birth")
public void select_date_of_birth() {
    
}
@When("click marital status")
public void click_marital_status() {
    
}
@When("enter emailID")
public void enter_email_id() {
    
}
@When("enter mobile")
public void enter_mobile() {
    
}
@When("select nationality")
public void select_nationality() {
    
}

@Given("Load {string} Json File and start Test with {string} and {string}")
public void load_json_file(String jsonFileName, String tcName, String desc) {
    // Write code here that turns the phrase above into concrete actions
    JSONReader json = new JSONReader();
   obj.genericFunctions().setData =  json.getJsonData(jsonFileName, tcName);
    obj.genericFunctions().startTest(tcName, desc);
}
@When("enter username ass {string}")
public void enter_username_ass(String string) {
    // Write code here that turns the phrase above into concrete actions
    obj.irctcSignUpPage().enterUserName(GenericFunctions.readData(string));
}
@When("enter password as {string}")
public void enter_password_as(String string) {
    // Write code here that turns the phrase above into concrete actions
	 obj.irctcSignUpPage().enterPassword(string);
}
@When("enter confirm password as {string}")
public void enter_confirm_password_as(String string) {
    // Write code here that turns the phrase above into concrete actions
    obj.irctcSignUpPage().enterPassword(string);
}


}
