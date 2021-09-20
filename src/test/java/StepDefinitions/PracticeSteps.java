package StepDefinitions;

import java.util.Set;

import Com.QA.Config.BaseClass;
import Pages.HomePage;
import Pages.PracticePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PracticeSteps extends BaseClass {
	
	HomePage home;
	PracticePage practice;
	
	
	//Create practice with valid data
	
	@Given("user inside the Practice page")
	public void user_inside_the_practice_page() {
		home= new HomePage(driver);
		home.click_PracticeMenu();
		System.out.println("User inside Practice page");		
	  
	}
	
	@When("user clicked on add practice button")
	public void user_clicked_on_add_practice_button() {
		practice=new PracticePage(driver);
		practice.Click_AddButton();
		System.out.println("User Clicked on Add button");   
	}
	
	@And("user entered all mandatory fields and clicked on save button")
	public void user_entered_all_mandatory_fields_and_clicked_on_save_button() throws Throwable {
		System.out.println("User inside create practice page");
		
	    practice.create_Practice();
	    
	}
	
	@Then("User has seen sucess message")
	public void user_has_seen_sucess_message() {
	    System.out.println("User has seen Toast Message");
	}
	
	
	//create practice with invalid data
	
	
	
	@And("user entered invalid data into each field$")
	public void user_entered_invalid_data_into_each_field() {
		System.out.println("Inside step: User entered invalid data");
		//practice.create_Practice(null, null, null, null, null, null);
		
	}
	
	@Then("user has seen error message on UI$")
	public void user_has_seen_error_message_on_ui() {
		
		System.out.println("User has seen error messages under respective field ");
	    
	}
	
	
	

	


	//Edit practice
	
	@Given("User inside edit practice page$")
	public void user_inside_edit_practice_page() {
	    practice = new PracticePage(driver);
	    practice.Click_onEdit();
	    System.out.println("User inside edit practice page");
	}
	@When("User edited required fields")
	public void user_edited_required_field() {
		//practice.create_Practice(null, null, null, null, null, null);
		
	}
	@Then("user updated practice successfully")
	public void user_updated_practice_successfully() {
		System.out.println("User updated successfully");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
