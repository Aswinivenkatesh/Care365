 @Smoke
 Feature: Admin page functionalities

// Create practice with valid data

     @Admin
    Scenario: Add Admin under practice with valid credentials
  
    Given user inside Admin page
    When user Clicked on add admin button 
    And user filled all mandatory details
    Then user created admin successfully
    