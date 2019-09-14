Feature: Sample program

@Test
Scenario: Login to Amazon site
    Given user is on Home page
    When User entered username and password
    Then Validate username

   
   @Test1
   Scenario: Login to Amazon site with parameterization
  Given user is on Home page
  When user enter "bhadrebalaji@gmail.com" and "jodha@123"
  Then Validate username
  
  @Test2
  Scenario: Login with Data table
      Given user is on Home page
      When User enter credentilals
      |Username | Password |
      |bhadrebalaji@gmail.com | jodha@123 |
      Then Validate username
      
 @Test3     
 Scenario Outline: Login with Multiple user
 	Given user is on Home page
 		When User entering  "<username>" and "<password>"
 		Then Validate username
 		
 		Examples:
 		| username                 | password   |
 		| bhadrebalaji@gmail.com   | jodha@123  |
 		| tupekarsupriya@gmail.com | jodha@123  |