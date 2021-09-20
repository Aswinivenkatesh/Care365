package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.QA.Config.BaseClass;

public class AdminPage extends BaseClass {
	
	
	
	//add admin button
	
		@FindBy(xpath= "//span[contains(.,'Add Admin')]")
		private WebElement addAdmin_Btn;
		
		//Role dropdown
		
		@FindBy(xpath= "//div[3]/mat-select/div/div[1]")
		private WebElement Role_Dropdown;
		
		
		//Firstname
		@FindBy(xpath= "//mat-dialog-content/mat-form-field[2]//input")
		private WebElement Firstname_txt;
		
		//Middle name
		
		
		@FindBy(xpath= "//mat-dialog-content/mat-form-field[3]//input")
		private WebElement Middlename_txt;
		
		//Last name
		
		@FindBy(xpath= "//mat-dialog-content/mat-form-field[4]//input")
		private WebElement Lastname_txt;
		
		
		//Email ID
		

		@FindBy(xpath= "//mat-dialog-content/mat-form-field[5]//input")
		private WebElement EmailID_txt;
		
		//Phone number
		
		@FindBy(xpath= "//mat-dialog-content/mat-form-field[6]//input")
		private WebElement PhoneNumber_txt;
		
		
		//Designation

		@FindBy(xpath= "//mat-dialog-content/mat-form-field[7]//input")
		private WebElement Designation_txt;
		
		

		//Save button
		@FindBy(xpath="//form/div//span[1]")
		public WebElement Save_Button;
		
		
		//Toast message 
			@FindBy(xpath= "//div[@class='hot-toast-message']")
			private WebElement errorMsg;

		
		//Constructor
			public AdminPage(WebDriver driver) { 
				try {

					PageFactory.initElements(driver, this);
				}
				catch(Exception e)
				{
					e.getMessage();
				}
			}
			
			//Click on add admin button
			
			public void Click_onAdd()
			{
				addAdmin_Btn.click();
			}
			
			//Create admin
			
			public void create_Admin()
			{
				
				System.out.println("Role:::::"+ Role_Dropdown.getText());
				Firstname_txt.sendKeys("Charvi");
				Middlename_txt.sendKeys("Chowdary");
				Lastname_txt.sendKeys("KN");
				EmailID_txt.sendKeys("char"+random_Numbers()+"@gmail.com");
				PhoneNumber_txt.sendKeys("9156232"+random_Numbers());
				Designation_txt.sendKeys("admin");
				Save_Button.click();
				explicitWait_ElementtoBeVisible(errorMsg);
				String toastMsg = errorMsg.getText();
				//System.out.println(toastMsg);
				if(toastMsg.equals("Created successfully!"))

				{

					System.out.println("Admin user is created successfully");


				}

				else {

					System.out.println("Admin user creation is failed ");

			}
			}

}
