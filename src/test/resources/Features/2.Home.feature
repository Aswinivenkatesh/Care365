
@Smoke
Feature: To Test HomePage Functionality

@Home1 @RegressionTest
  Scenario: Verify 12 menus are present in home page 
   
    Given user inside the Home page
    When user Counts number of menus in home page
    Then Count matched with requirement
    
   @Home2 
    Scenario: Verify all 12 menus are clickable
    Given user inside the Home page
    When user clicked on each menu
    Then User navigated to respective page 
    
    
    
    