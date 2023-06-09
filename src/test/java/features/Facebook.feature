Feature: Facebook Signup Scenarios

  Background: 
    Given Launch Chrome Browser and Load the Facebook URL

  @TC001 @SmokeTest
  Scenario: Facebook SignUp
    When Click on signup
    When Enter the FirstName
    And Enter Surname
    And Enter Email Id
    And ReenterEmailId
    And Enter Password
    And Select Gender as Male
    And Click on create account

  @TC002
  Scenario: Facebook Signup New
    When click on Signup
    When Enter the Firstname as "Shiva"
    And Enter the Surname as "G"
    And Enter Email id as "gshiva@gmail.com"


@TC003
  Scenario Outline: Facebook Signup New One
    When click on Signup
    When Enter the Firstname as "<firstname>"
    And Enter the Surname as "<surname>"
    And Enter Email id as "<emailid>"

    Examples: 
      | firstname | surname   | emailId                     |
      | Shiva     | G         | gshiva@gmail.com            |
      | Harish    | C         | charish@gmail.com           |
      | selenium  | Webdriver | seleniumwebdriver@gmail.com |
      
      
  @TC004
  Scenario: Facebook Signup New
    When click on Signup
    When Enter the Firstname as "Shiva"
    And Enter the Surname as "G"
    And Enter Email id as "gshiva@gmail.com"
    And verify month dropdown values
    |Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec|
    |Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec|
    |Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec|
    |Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec|
    
