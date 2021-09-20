package StepDefinitions;

import org.openqa.selenium.WebDriver;

import Com.QA.Config.BaseClass;
import Pages.Dashboardpage;
import Pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DashboardSteps extends BaseClass {
	
	Dashboardpage dash;
	HomePage  home ;
	//Get the count of Clinics 	
	
	@Given("user inside the dashboard page")
	public void user_inside_the_dashboard_page() {
		home = new HomePage(driver);
		home.click_DashboardMenu();
		System.out.println("User is inside the home page");
	    
	}
	
	@When("user has seen patient card")
	public void user_has_seen_patientCard() {
		
		System.out.println("User has seen patient card");
	    
	}
	@Then("user get the Count of patients")
	public void count_Of_Patients() {
		dash= new Dashboardpage(driver);
		dash.get_PatientsCount();
   
	}
	
	//Get the count of Clinics
	
	@When("user has seen Clinics card")
	public void user_has_seen_Clinics_Card() {
		
		System.out.println("User has seen clinics card");
	}
	@Then("user get the Count of Clinics")
	public void count_Of_Clinics() {
		dash= new Dashboardpage(driver);
		dash.get_ClinicsCount();
	    
	}
	
	//Get the count of Providers
	
	@When("user has seen providers card")
	public void user_has_Seen_providersCard() {
		System.out.println("User has seen provider card");
	}
	@Then("user get the Count of providers")
	public void count_Of_Providers() {
		dash= new Dashboardpage(driver);
		dash.get_ProvidersCount();
	   
	}

	
	// Get the count of caregivers
	
	
	@When("user has seen caregivers card")
	public void user_has_seen_caregiversCard() {
		System.out.println("User has seen caregivers card");
	    
	}
	@Then("user get the Count of caregivers")
	public void count_Of_caregivers() {
		dash= new Dashboardpage(driver);
		dash.get_CaregiversCount();
	   
	}
	
	
}
