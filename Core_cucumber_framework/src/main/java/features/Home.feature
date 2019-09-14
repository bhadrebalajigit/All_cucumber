Feature: Verify content on home page

  
 Scenario: Verify Today's Deal link
  Given User is on Home Page
  When User Navigate to LogIn Page
	Then User enters UserName and Password
	And Validate logged user
	Then close the browser
	
	 @HomeTest
 Scenario: Login to amzone 
  Given Read the Test data for TC_001

  
  
  