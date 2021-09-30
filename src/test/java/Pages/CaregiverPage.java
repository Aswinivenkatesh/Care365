package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.QA.Config.BaseClass;

public class CaregiverPage extends BaseClass {


	// Add Practice button

	@FindBy(xpath = "//span[text()=' Add Practice ']")
	public WebElement ADD_Button;
	
	//practice Name
	// id = "mat-input-5"

	@FindBy(xpath= "//mat-dialog-content/mat-form-field[1]//input")
	private WebElement PracticeName_Txt;

	//Phone number 
	@FindBy(xpath="//mat-dialog-content/mat-form-field[2]//input")
	public WebElement PhoneNumber_Txt;
	
	//Email ID

	@FindBy(xpath="//mat-dialog-content/mat-form-field[3]//input")
	public WebElement EmailId_Txt;
	
	//Address 

	@FindBy(xpath="//mat-dialog-content/mat-form-field[4]//input")
	public WebElement Address_Txt;

	
	//ZipCode
	@FindBy(xpath="//mat-dialog-content/mat-form-field[5]//input")
	public WebElement ZIPCode_Txt;

     //Zipcode search
	@FindBy(xpath= "//mat-dialog-content//mat-icon[. = 'search']")
	public WebElement ZIPCode_SearchButton;

	//State dropdown
	@FindBy(xpath = "//div[3]/mat-select/div/div[1]/span/span")
	public WebElement StateDropdown;

	
	//City name field
	@FindBy(xpath = "//mat-dialog-content/mat-form-field[7]//input")
	public WebElement  City_Txt;

  //City dropdown arrow
	@FindBy(xpath = "//mat-icon[. = 'arrow_drop_down']")
	public WebElement  CityDropdown_Arrow;

	
	//City name value 
	@FindBy(xpath="//mat-option/span")
	public WebElement CityName;

	//NPI Textfield

	@FindBy(xpath="//mat-dialog-content/mat-form-field[8]//input")
	public WebElement NPI_Txt;

	
	//Save button
	@FindBy(xpath="//form/div//span[1]")
	public WebElement Save_Button;

	//Toast message 
	@FindBy(xpath= "//div[@class='hot-toast-message']")
	private WebElement errorMsg;


	// Actions
	@FindBy(xpath= "(//mat-row[@class='mat-row cdk-row ng-star-inserted']//button)[1]")
	private WebElement More_actions;
	
	//Edit option
	
	@FindBy(xpath= "//div//button//span[text()='Edit']")
	private WebElement Edit;
	
	//Admin option
	
	@FindBy(xpath= "//div//button//span[text()='Admins']")
	private WebElement Admins;
	
	
	
	//Constructor
	public CaregiverPage(WebDriver driver) { 
		try {

			PageFactory.initElements(driver, this);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
	}


	// Click on add practice button

	public void Click_AddButton()
	{
		ADD_Button.click();

	}

	// create_Practice
	public void create_Practice() throws InterruptedException

	{

		PracticeName_Txt.sendKeys("Appollo");
		PhoneNumber_Txt.click();
		PhoneNumber_Txt.sendKeys("97878065"+ random_Numbers());
		EmailId_Txt.sendKeys("Asw"+random_Numbers()+"@gmail.com");
		Address_Txt.sendKeys("No:123, Grills Road");
		ZIPCode_Txt.sendKeys("985");
		ZIPCode_SearchButton.click();
		StateDropdown.getText();

		CityDropdown_Arrow.click();
		City_Txt.sendKeys("C");
		City_Txt.clear();
		CityName.click();
		NPI_Txt.sendKeys("90"+random_NPINumbers());
		Thread.sleep(1000*3);
		Save_Button.click();
		explicitWait_ElementtoBeVisible(errorMsg);
		String toastMsg = errorMsg.getText();
		//System.out.println(toastMsg);
		if(toastMsg.equals("Created successfully!"))

		{

			System.out.println("Practice is created successfully");


		}

		else 

			System.out.println("Practice creation is failed ");




	}

	
	

	public void create_Practice(String Pract_name,String Phone_No, String Email_ID, String Address,String Zipcode, String NPI) throws InterruptedException

	{

		PracticeName_Txt.sendKeys(Pract_name);
		PhoneNumber_Txt.sendKeys(Phone_No);
		EmailId_Txt.sendKeys(Email_ID);
		Address_Txt.sendKeys(Address);
		ZIPCode_Txt.sendKeys(Zipcode);
		ZIPCode_SearchButton.click();
		StateDropdown.getText();

		CityDropdown_Arrow.click();
		City_Txt.sendKeys("C");
		City_Txt.clear();
		CityName.click();
		NPI_Txt.sendKeys(NPI);
		Thread.sleep(1000*3);
		Save_Button.click();

		String toastMsg = errorMsg.getText();
		System.out.println(toastMsg);
		if(toastMsg.equals("Created successfully!"))

		{

			System.out.println("Practice is created successfully");


		}

		else 

			System.out.println("Practice creation is failed ");

	}

	// Set practice name
	public void set_PracticeName(String Practice_name)
	
	{
		PracticeName_Txt.sendKeys(Practice_name);
	}
    // Set Email ID
	
	public void set_EmailID(String Email_ID)
	{
		EmailId_Txt.sendKeys(Email_ID);
	}
	
	
	
	// Set Phone number 
	
	public void set_phoneNumber(String Phone_No)
	{
		PhoneNumber_Txt.sendKeys(Phone_No);
		
	}
	
	//Set Address
	
	public void set_Address(String Address)
	{
		Address_Txt.sendKeys(Address);
	}
	
	
	//Set ZIPCODE
	public void set_ZipCode(String Zipcode)
	{
		ZIPCode_Txt.sendKeys(Zipcode);
	}
	
	
	//Set NPI number 
	
	public void set_NPINumber(String NPI)
	{
		NPI_Txt.sendKeys(NPI);
	}
	
	//Click on admins
	public void Click_onAdmins() {
		explicitWait_ElementtoBeClickable(More_actions);
		More_actions.click();
        Admins.click();
		
	}
	
	//Click on edit option
	
	public void Click_onEdit()
	{
		explicitWait_ElementtoBeClickable(More_actions);
		More_actions.click();
        Edit.click();	
	}

}
