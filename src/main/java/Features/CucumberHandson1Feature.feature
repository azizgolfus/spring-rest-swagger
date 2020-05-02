Feature: Signup process 

Scenario: User Sign up scenario 
	Given User comes on phptravels homepage
	Then user clicks the button of Myaccount and then click on sign up tab
	Then enter the user details
	| Azizur | Rahman | 9876543210 | azizurrahman@gmail.com | ar@123 | ar@123|
	And after giving details submit the form