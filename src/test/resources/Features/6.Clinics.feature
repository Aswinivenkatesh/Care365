Feature: Clinic page functionalities

// Create Clinic with valid data 
@Smoke @Clinic1
  Scenario: Create a Clinic with valid data 
   
    Given user inside the Clinics page
    When user clicked on add Clinic button
    And  user entered all mandatory fields
    Then User successfully created clinic 
    
   @Clinic2
    Scenario: Create Clinic with invalid data
    
    Given user inside the Clinics page
    When user clicked on add Clinic button
    And user entered invalid data and clicked on submit button
    Then Error messages displayed under particular field
    
    
    @Clinic3
    Scenario: Edit Clinic functionality
  
    Given User inside edit clinics page 
    When User update the fields 
    Then user updated Clinic successfully