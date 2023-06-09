package stepDefinations;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	
	ChromeDriver driver;

	@Given("Launch Chrome Browser and Load the Facebook URL")
	public void launch_chrome_browser_and_load_the_facebook_url() {
	    // Write code here that turns the phrase above into concrete actions
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver();
	  driver.get("https://facebook.com");
	  driver.manage().window().maximize();
	}
	@When("Click on signup")
	public void click_on_signup() throws InterruptedException {
		driver.findElementByLinkText("Create new account").click();
		Thread.sleep(2000);
	}

	@When("Enter the FirstName")
	public void enter_the_first_name() {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElementByXPath(" //*[@name='firstname']").sendKeys("Siva");
	}
	@When("Enter Surname")
	public void enter_surname() {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElementByXPath(" //*[@name='lastname']").sendKeys("Kumar");
	}
	@When("Enter Email Id")
	public void enter_email_id() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElementByXPath(" //*[@name='reg_email__']").sendKeys("asdf@gmail.com");
		 Thread.sleep(2000);
	}
	@When("ReenterEmailId")
	public void reenter_email_id() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElementByXPath(" //*[@name='reg_email_confirmation__']").sendKeys("asdf@gmail.com");
	}
	
	@When("Enter Password")
	public void enter_password() {
		 driver.findElementByXPath(" //*[@name='reg_passwd__']").sendKeys("asffdhjfA@12");
	}
	@When("Select Gender as Male")
	public void select_gender_as_male() {
		 driver.findElementByXPath(" //label[text()='Male']").click();
	}
	
	@When("Click on create account")
	public void click_on_create_account() {
	    // Write code here that turns the phrase above into concrete actions
	   driver.findElementByXPath(" //button[@name='websubmit']").click();
	}
	
	@When("click on Signup")
	public void click_on_Signup() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElementByLinkText("Create new account").click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
	@When("Enter the Firstname as {string}")
	public void enter_the_firstname_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElementByXPath(" //*[@name='firstname']").sendKeys(string);
	}
	@When("Enter the Surname as {string}")
	public void enter_the_surname_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
		 driver.findElementByXPath(" //*[@name='lastname']").sendKeys(string);
	}
	@When("Enter Email id as {string}")
	public void enter_email_id_as(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    
	}
	
	@When("verify month dropdown values")
	public void verify_month_dropdown_values(DataTable datatable) {
	  //List<String> list =  datatable.asList();
	 List<List<String>> list1 = datatable.asLists();
	  Select sel = new Select(driver.findElementById("month"));
	 List<WebElement> options =  sel.getOptions();
	SoftAssert sa = new SoftAssert();
	 for(int i = 0; i< list1.get(0).size(); i++) {
		 sa.assertEquals(options.get(i).getText(), list1.get(0).get(i));
	 }
	 sa.assertAll();
	}
	
}
