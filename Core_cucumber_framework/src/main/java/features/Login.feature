Feature: LogIn Action Test

  #Scenario: Successful Login with Valid Credentials
  #Given User is on Home Page
  #When User Navigate to LogIn Page
  #Then User enters UserName and Password
  #And Validate logged user
  #Then close the browser
  
 @LoginTest
  Scenario Outline: Successful Login with Valid Credentials
    Given User is on Home Page
    When User Navigate to LogIn Page
    Then User enters "<UserName>" and "<Password>"
    And Validate logged "<user>"
 

    Examples: 
      | UserName                 | Password  | user    |
      | bhadrebalaji@gmail.com   | jodha@123 | balaji  |
      | tupekarsupriya@gmail.com | jodha@123 | Supriya |
      | bhadrebalaji@gmail.com   | jodha@123 | balaji  |

  
  @SmokeTest
  Scenario: check title of amazon page
    Given User is on Home Page
    Then check title of the homepage


   @SmokeTest
  Scenario: Validate user
    Given User is on Home Page
    When User Navigate to LogIn Page
    Then User enters UserName
 

@IosProduct
  Scenario: Search IOS Product
    Given User is on Home Page
    When User Navigate to LogIn Page
    Then User enters UserName and Password
    And Validate logged user
    Then Enter IOS Product
      | iphone |
    Then Print product name and Price of first product

    
@LoginTest
    Scenario: Successful Login with Valid Credentials with headers
    Given User is on Home Page
    When User Navigate to LogIn Page
    Then User enters username and password
    
    			| username									| password	|
          | bhadrebalaji@gmail.com   	| jodha@123	|
      

