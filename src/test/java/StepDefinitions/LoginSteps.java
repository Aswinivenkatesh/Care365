package StepDefinitions;


import Com.QA.Config.BaseClass;
import Pages.HomePage;
import Pages.Loginpage;

//import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps extends BaseClass{

	Loginpage login;
	HomePage  home ;
	//Scenario : Launch the browser and login with valid credentials
	@Given("Browser is launched")
	public void browser_is_launched() {
		System.out.println("Inside Step - browser is open");
		initializationOfBrowser();
		driver.get(prop.getProperty("url"));

	}

	@And("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		System.out.println("Inside Step- User Navigated to login page");
		
	}

	@When("User enters valid credentials and click on login")
	public void user_enters_valid_credentials() {	
		
		System.out.println(prop.getProperty("username")+ ""+prop.getProperty("password"));
		login = new Loginpage(driver);
		login.loginValidUser(prop.getProperty("username"),prop.getProperty("password"));
		System.out.println("Inside Step - user entered username as " + prop.getProperty("username")+  "and password as" +prop.getProperty("password") + " and clicked on login");
	}


	@Then("^user is navigated to the home page$")
	public void user_is_navigated_to_the_home_page() throws Throwable {
        home= new HomePage(driver);
		home.checkusernameIsDisplayed();
		System.out.println("Inside Step - logged in successfully");
		
	}
	// Homepage menu verification
	
//	
//	@When("user has seen all menu options")
//	public void user_clicks_on_profileicon() throws InterruptedException {
//		System.out.println("DRIVER:::"+driver);
//		 home.allMenusList_count();
//		System.out.println("Inside Step - User has seen all menu options ");
//	}
//	
//	
//	@Then("User clicked on each menu and navigated to respective page")
//	public void user_clickedon_eachmenu()
//	{
//		home.Clickon_Allmenus();
//		
//	}
//	
	
}

//	//Scenario: Verify Logout functionalities
//	
//    @Given("user inside homepage")
//    public void user_inside_homepage() throws Throwable
//    {
//    	
//      System.out.println("Inside Step -User is inside home page");
//    	
//    }
//    
//	@When("user Clicks on profileicon and clicked on logout button")
//	public void user_clicks_on_profileicon() throws InterruptedException {
//        home=new HomePage(driver);
//    	home.checkusernameIsDisplayed();
//		home.clickLogout();
//		System.out.println("Inside Step - User Clicked on logout button");
//	}
//
//
//	//Scenario : Verify login with invalid credentials
//	
//	
//	@When("user enters (.*) and (.*)$")
//	public void user_enters_username_and_password(String username,String password) throws Throwable {
//		login=new Loginpage(driver);
//		System.out.println("Inside Step - User entered username as " + username + "and password as" + password + " clicked on login button");
//		login.loginValidUser(username, password);
//		login.error_message();
//		Thread.sleep(1000*3);
//        driver.navigate().refresh();
//			    
//	}
//
//	@Then("Should see the error message on UI")
//	public void should_see_the_error_message_on_ui() {
//		
//		
//		System.out.println("Inside step : invalid credentials tests are executed");
//
//	}
//
//	// Scenario: Verify Forgot password functionalities
//
//	@When("forgot password steps")
//	public void user_clicks_on_forgot_password() throws InterruptedException {
//		System.out.println("Inside: User clicked on forgot password link");
//		login = new Loginpage(driver);
//		login.forgotPassword(prop.getProperty("EmailID"));
//		
//		System.out.println("User entered email ID as "+ prop.getProperty("EmailID") +" and clicked on submit");
//
//	}
//	@Then("Success message is displayed")
//	public void success_message_is_displayed() {
//		
//		
//	}
//
//}
//
//
//
