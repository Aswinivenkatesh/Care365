package Pages;



import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.QA.Config.BaseClass;

public class Loginpage extends BaseClass {


	//username
                       
	@FindBy(name= "username")
	private WebElement txt_username;

	//Password  
	
	@FindBy(name= "pass")
	 private WebElement txt_password;

	//Login Button 

	@FindBy(xpath= "//button[text()=' Sign in ']")
   private  WebElement btn_login ;

   
	
	
	//Forgot password
	@FindBy(xpath= "//a[. = ' Forgot Password ']")
	private WebElement ForgotPassword_link;
	
	//Enter EmailID field 
	
	@FindBy(xpath= "//input[@placeholder = 'Enter your email address here']")
	private WebElement txt_EmailID;
	
	//Submit button in forgot password
	
	@FindBy(xpath= "//button[. = ' Submit ']")
	private WebElement btn_Submit;
	
	//Error message
	
	@FindBy(xpath= "//div[@class='hot-toast-message']")
	private WebElement errorMsg;

	public Loginpage(WebDriver driver) { 
		try {
						
        PageFactory.initElements(driver, this);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
}


	public void enterUsername(String username) {

		txt_username.sendKeys(username);
	}

	public void enterPassword(String password) {

		txt_password.sendKeys(password);
	}

	public void clickLogin() {

		btn_login.click();
	}

	

	public void loginValidUser(String username, String password) 
	{
		txt_username.sendKeys(username);
		txt_password.sendKeys(password);
		btn_login.click();
		
	}

	

	public void forgotPassword(String emailId)
	{
     ForgotPassword_link.click();
     txt_EmailID.sendKeys(emailId);
     btn_Submit.click();
     HomePage home=new HomePage(driver);
	 home.mail_confirmation();
    
     }
	
	public void error_message()
	{
		 getErrorMsg().getText();
		System.out.println("Error message "+getErrorMsg().getText());
		
	}


	public WebElement getErrorMsg() {
		return errorMsg;
	}

}


