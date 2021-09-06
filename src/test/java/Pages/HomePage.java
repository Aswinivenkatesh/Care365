package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.QA.Config.BaseClass;

public class HomePage extends BaseClass {
	
	
	 // Username inside homepage 
		@FindBy(xpath= "//span[text()='- SUPER ADMIN -']")
		private WebElement username_text;

	    //Profile ICON
		
	    @FindBy(xpath= "//app-profile-image/img")
		 private WebElement Profile_icon;
		

	  //Logout button
		
		@FindBy(xpath= "//span[text()='Logout']")
	    private WebElement btn_logout;
		
		
		// Successfull email confirmation
		
		@FindBy(xpath= "//div[@class='hot-toast-message']")
		private WebElement MailSent_confirmationMsg;
		

		public HomePage(WebDriver driver) { 
			try {
				
	        PageFactory.initElements(driver, this);
			}
			catch(Exception e)
			{
				e.getMessage();
			}
	}
		
		public void checkusernameIsDisplayed() {

			username_text.isDisplayed();
			System.out.println(username_text.getText());
		}
		
		public void clickLogout() throws InterruptedException {
			
			
			explicitWait_ElementtoBeClickable(Profile_icon);
			System.out.println("Profile Iconis displayed "+  Profile_icon.isDisplayed());
			Profile_icon.click();
			explicitWait_ElementtoBeClickable(btn_logout);
			btn_logout.click();
			
		}
		
		public void mail_confirmation()
		{
			String Toast_message = MailSent_confirmationMsg.getText();
			System.out.println(MailSent_confirmationMsg.getText());
			
//			if(Toast_message.equals("Mail sent successfully"))
//			{
//				System.out.println("Testcase passed: Email sent successfully");
//				
//			}
//			else 
//				System.out.println("Testcase Failed:"+ Toast_message);
	}

}
