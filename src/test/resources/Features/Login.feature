
 Feature: feature to test login functionality
 Scenario: Check login is successful with valid credentials
  
    Given Browser is launched
  	And   User is on login page
    When  User enters valid credentials
    And   User enters valid credentials and click on login
    Then user is navigated to the home page
    
