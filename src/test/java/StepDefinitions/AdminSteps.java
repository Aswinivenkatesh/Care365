package StepDefinitions;

import Com.QA.Config.BaseClass;
import Pages.AdminPage;
import Pages.PracticePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminSteps extends BaseClass 	 {
	
	PracticePage practice;
	AdminPage admin;
	
	//Create admin under practice
	
		@Given("user inside Admin page$")
		public void user_inside_admin_page() {
			
	     practice= new PracticePage(driver);
	     practice.Click_onAdmins();
		System.out.println("User inside admin page");
		    
	     
		}
		@When("user Clicked on add admin button$")
		public void user_clicked_on_add_admin_button() {
		    
			admin= new AdminPage(driver);
			admin.Click_onAdd();
			System.out.println("User Clicked on add admin button");
			
		}
		@When("user filled all mandatory details$")
		public void user_filled_all_mandatory_details() {
		    admin.create_Admin();
			
		}
		@Then("user created admin successfully$")
		public void user_created_admin_successfully() {
		    System.out.println("user record is created in list");
		}

}
