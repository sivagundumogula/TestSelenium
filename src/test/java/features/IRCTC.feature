Feature: IRCTC Signup 

 
 @IRCTC
 Scenario: IRCTC signup
Given Load "IRCTC" Json File and start Test with "TC001" and "IRCTC SignUp"
 When click on Register 
 When enter username ass "UserName"
 When enter password as "password"
 When enter confirm password as "confirmpassword"
 #When select "language"
 #When select security question
 #When click on continue
 #When enter first name
 #When enter last name
 #When enter middle name
 #When select occupation
 #When select date of birth
 #When select occupation
 #When click marital status
 #When enter emailID
 #When enter mobile
 #When select nationality 