package StepDefinitions;

import java.util.Set;


import Com.QA.Config.BaseClass;
import Pages.ClinicPage;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClinicSteps extends BaseClass {
	
	HomePage  home;
	ClinicPage clinic;
	
	
	//Create practice with valid data
	
	@Given("user inside the Clinics page")
	public void user_inside_the_practice_page() throws Throwable {
		home= new HomePage(driver);
		home.click_ClinicsMenu();
		System.out.println("User inside Clinics page");		
	  
	}
	
	@When("user clicked on add Clinic button")
	public void user_clicked_on_add_practice_button() {
		clinic=new ClinicPage(driver);
		clinic.Click_AddButton();
		System.out.println("User Clicked on Add button");   
	}
	
	@And("user entered all mandatory fields")
	public void user_entered_all_mandatory_fields_and_clicked_on_save_button() throws Throwable {
		System.out.println("User entering data into fields");
		
	    clinic.create_Clinic();
	    
	}
	
	@Then("User successfully created clinic")
	public void user_has_seen_sucess_message() {
	    System.out.println("User has seen Toast Message");
	}
	
	
	//create practice with invalid data
	
	
	
	@And("user entered invalid data and clicked on submit button$")
	public void user_entered_invalid_data() {
		System.out.println("Inside step: User entered invalid data");
		//clinic.create_Practice(null, null, null, null, null, null);
		
	}
	
	@Then("Error messages displayed under particular field$")
	public void error_message_displayed_on_ui() {
		
		System.out.println("User has seen error messages under respective field ");
	    
	}
	
	
	

	


	//Edit practice
	
	@Given("User inside edit clinics page$")
	public void user_inside_edit_practice_page() {
	    clinic = new ClinicPage(driver);
	    clinic.Click_onEdit();
	    System.out.println("User inside edit practice page");
	}
	@When("User update the fields")
	public void user_updated_required_field() {
		//practice.create_Practice(null, null, null, null, null, null);
		
	}
	@Then("user updated Clinic successfully")
	public void user_updated_practice_successfully() {
		System.out.println("User updated successfully");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
