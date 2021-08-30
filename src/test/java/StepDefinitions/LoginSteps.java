package StepDefinitions;


import Com.QA.Config.BaseClass;
import Pages.Loginpage;

//import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps extends BaseClass{
	
	Loginpage login;
	@Given("Browser is launched")
	public void browser_is_launched() {
		System.out.println("Inside Step - browser is open");
		initializationOfBrowser();
		System.out.println("Driver::::::"+driver);
	
	}

	@And("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		//System.out.println("user is on login page");
		driver.get(prop.getProperty("url"));
		System.out.println("Navigated to login page");
	}
	
	@When("User enters valid credentials and click on login")
	public void user_enters_valid_credentials() {	
		System.out.println("Inside Step - user enters username and password and clicked on login");
		System.out.println(prop.getProperty("username")+ ""+prop.getProperty("password"));
		 login = new Loginpage(driver);
		 login.loginValidUser(prop.getProperty("username"),prop.getProperty("password"));
		
	}

	
	@Then("^user is navigated to the home page$")
	public void user_is_navigated_to_the_home_page() throws Throwable {
	   login.checkusernameIsDisplayed();
	   System.out.println("Inside Step - user is navigated to the home page");
	}
}



