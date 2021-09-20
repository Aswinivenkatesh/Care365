
Feature: Practice page functionalities

// Create practice with valid data 
@Smoke @Practice1
  Scenario: Create a practice with valid data 
   
    Given user inside the Practice page
    When user clicked on add practice button
    And  user entered all mandatory fields and clicked on save button
    Then User has seen sucess message 
    
  @Practice2
    Scenario: Create practice with invalid data
    
    Given user inside the Practice page
    When user clicked on add practice button
    And user entered invalid data into each field 
    Then user has seen error message on UI
    
    
    @Practice3 
    
    Scenario: Edit practice functionality
  
    Given User inside edit practice page 
    When User edited required fields 
    Then user updated practice successfully
    
   