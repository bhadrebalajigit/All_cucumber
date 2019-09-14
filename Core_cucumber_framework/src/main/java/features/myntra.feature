Feature: Hands on Test on Web automation on myntra site

  @Validlogin
 Scenario: Login with valid Credentialson myntra site
  Given Navigate to myntra site
  When user clicked on profile menu
  When user clicked on login button
  Then enter "InterviewTCT@gmail.com" and "Str@ongPassw0rd!"
  Then Click on login button

  
  @inValidLogin 
  Scenario: Login with invalid Credentialson myntra site
   Given Navigate to myntra site in chrome
  When user clicked on profile menu
  When user clicked on login button
  Then enter "InterviewTCTS@gmail.com" and "Str@ongPassw0rd" 
  Then Click on login button
  And validate Error message  
 
