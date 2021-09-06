
 Feature: feature to test login functionality
    @SmokeTest
    Scenario: Check login is successful with valid credentials
    //Launch the browser and login with valid credentials
    Given Browser is launched
  	And   User is on login page
    When  User enters valid credentials and click on login
    Then  user is navigated to the home page
    
    
            
     @Regression
     
     Scenario Outline: Verify logout functionalities
     Given user inside homepage
     When user Clicks on profileicon and clicked on logout button
     Then User is on login page 
     
     
    @Regression
    
    Scenario Outline: Check login with with invalid credentials
    Given User is on login page
    When user enters <username> and <password>
    Then Should see the error message on UI
    
     Examples:
     
     |username|password|
     |Test|test|
     |care365admin|test2|
     
     
     

           
     @Regression
     
    Scenario: Verify Forgot password functionalities
    
    Given User is on login page
    When forgot password steps
    Then Success message is displayed  
    
    
    
    
    
    
    
    
    
    
   

    
    
    
    
    
    
    