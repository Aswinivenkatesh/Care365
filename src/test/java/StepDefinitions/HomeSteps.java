package StepDefinitions;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import Com.QA.Config.BaseClass;
import Pages.HomePage;
import Pages.Loginpage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps extends BaseClass {
	
	//public static WebDriver driver = setup_Browser();
	Loginpage login;
	HomePage home;
	//Scenario: Check all 12 menus are present in home page
	 @Given("user inside the Home page")
	    public void user_inside_homepage() throws Throwable
	    {
	     System.out.println("Inside Step -User is inside home page");
	    	
	    }
	    
		@When("user Counts number of menus in home page")
		public void user_seen_all_menus() throws InterruptedException {
			home = new HomePage(driver);
			 home.allMenusList_count();
			System.out.println("Inside Step - All 12 menus are present in home page ");
		}
		
		
		@Then("Count matched with requirement")
		public void menu_count_matched()
		{
			System.out.println("Count of menus are matched  ");
			
		}
       
		
		//Click on each menu 
		
		@When("user clicked on each menu")
		public void user_clicked_on_each_menu() {
			home = new HomePage(driver);
			home.Clickon_Allmenus();
			 System.out.println("USer Clicked on each menu");
		   
		}
		@Then("User navigated to respective page")
		public void user_navigated_to_respective_page() {
		   System.out.println("User navigated to respective page");
		}
		
		
		
		
		

}
