package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Com.QA.Config.BaseClass;

public class ClinicPage extends BaseClass {


	// Add Clinic button

	@FindBy(xpath = "//span[text()=' Add Clinic ']")
	public WebElement ADD_Button;
	
	//Clinic Name

	@FindBy(xpath= "//mat-dialog-content/mat-form-field[1]//input")
	private WebElement ClinicName_Txt;

	
	// Practice dropdown
	@FindBy(xpath="//mat-dialog-content/mat-form-field[2]//mat-select")
	private WebElement PracticeName_Dropdown;
	
	//Practice option 
	
	@FindBy(xpath="//mat-option//span[contains(text(),' Appollo ')]")
	private WebElement Practice_Values;
	
	
	//Primary Contact  number 
	@FindBy(xpath="//mat-dialog-content/mat-form-field[3]//input")
	public WebElement PhoneNumber_Txt;
	
	//Primary person contact name
	
	@FindBy(xpath="//mat-dialog-content/mat-form-field[4]//input")
	public WebElement PrimarypersonName_Txt;
	
	//Primary person contact number 
	
	@FindBy(xpath="//mat-dialog-content/mat-form-field[5]//input")
	public WebElement PrimarypersonContact_Txt;
	
	
	// Emergency contact number 
	
	@FindBy(xpath="//mat-dialog-content/mat-form-field[6]//input")
	public WebElement EmergencyContact_Txt;
	
	
	//Address 

	@FindBy(xpath="//mat-dialog-content/mat-form-field[7]//input")
	public WebElement Address_Txt;

	
	//ZipCode
	@FindBy(xpath="//mat-dialog-content/mat-form-field[8]//input")
	public WebElement ZIPCode_Txt;

     //Zipcode search
	@FindBy(xpath= "//mat-dialog-content//mat-icon[. = 'search']")
	public WebElement ZIPCode_SearchButton;

	//State dropdown
	@FindBy(xpath = "//div[3]/mat-select/div/div[1]/span/span")
	public WebElement StateDropdown;

	
	//City name field
	@FindBy(xpath = "//mat-dialog-content/mat-form-field[10]//input")
	public WebElement  City_Txt;

  //City dropdown arrow
	@FindBy(xpath = "//mat-icon[. = 'arrow_drop_down']")
	public WebElement  CityDropdown_Arrow;

	
	//City name value 
	@FindBy(xpath="//mat-option/span")
	public WebElement CityName;

	//NPI Textfield

	@FindBy(xpath="//mat-dialog-content/mat-form-field[11]//input")
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
	public ClinicPage(WebDriver driver) { 
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
	public void create_Clinic() throws InterruptedException

	{

		ClinicName_Txt.sendKeys("Appollo Clinic");
		PracticeName_Dropdown.click();
		Practice_Values.click();
		PhoneNumber_Txt.click();
		PhoneNumber_Txt.sendKeys("97878065"+ random_Numbers());
		PrimarypersonName_Txt.sendKeys("Savitha");
		PrimarypersonContact_Txt.sendKeys("97878065"+ random_Numbers());
		EmergencyContact_Txt.sendKeys("97878065"+ random_Numbers());
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

	
	

	public void create_Clinic(String Clinic_name,String Practice_name,String phone_no,String Personname,String EmailID, String Address,String Zipcode, String NPI) throws InterruptedException

	{

		ClinicName_Txt.sendKeys(Clinic_name);
		Select Practicename = select_Dropdown(PracticeName_Dropdown);
		Practicename.isMultiple();
		Practicename.selectByValue(Practice_name);
		PhoneNumber_Txt.sendKeys(phone_no);
		PrimarypersonName_Txt.sendKeys(Personname);
		PrimarypersonContact_Txt.sendKeys(phone_no);
		EmergencyContact_Txt.sendKeys(phone_no);
		
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

			System.out.println("Clinic is created successfully");


		}

		else 

			System.out.println("Clinic creation is failed ");

	}

	// Set practice name
	public void set_PracticeName(String Practice_name)
	
	{
		ClinicName_Txt.sendKeys(Practice_name);
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
