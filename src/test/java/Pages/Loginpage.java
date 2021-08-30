package Pages;



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

    // Username inside homepage 
	@FindBy(xpath= "//span[@class='rpm-heading-subtitle']")
	private WebElement username_text;

    //Profile ICON
	
    @FindBy(xpath= "//app-profile-image/img")
	 private WebElement Profile_icon;
	

  //Logout button
	
	@FindBy(xpath= "//span[text()='Logout']")
    private WebElement btn_logout;
	
	
	//Forgot password
	@FindBy(xpath= "//a[. = ' Forgot Password ']")
	private WebElement ForgotPassword_link;
	
	//Enter EmailID field 
	
	@FindBy(xpath= "//input[@placeholder = 'Enter your email address here']")
	private WebElement txt_EmailID;
	
	//Submit button in forgot password
	
	@FindBy(xpath= "//button[. = ' Submit ']")
	private WebElement btn_Submit;
	
	
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

	public void checkusernameIsDisplayed() {

		username_text.isDisplayed();
		System.out.println(username_text.getText());
	}
	public void clickLout() {
		Profile_icon.click();
		btn_logout.click();
	}

	public void loginValidUser(String username, String password) {
		
		txt_username.sendKeys(username);
		txt_password.sendKeys(password);
		btn_login.click();
		System.out.println(username_text.getText());
	}


	public void forgotPassword(String emailId)
	{
     ForgotPassword_link.click();
     txt_EmailID.sendKeys(emailId);
     btn_Submit.click();
     
	}
	
	
}


