@Smoke
Feature: Dashboard page functionalities


@Dashboard1 
  Scenario: Verify Count of Patients
   
    Given user inside the dashboard page
    When user has seen patient card 
    Then user get the Count of patients 
    
   @Dashboard2
    Scenario: Verify Count of Clinics
 
    When user has seen Clinics card 
    Then user get the Count of Clinics 
    
    
   @Dashboard3
    Scenario: Verify Count of Providers
    When user has seen providers card 
    Then user get the Count of providers
    
    
   @Dashboard4
    
    Scenario: Verify Count of caregivers
   
 
      When user has seen caregivers card 
    Then user get the Count of caregivers
    
