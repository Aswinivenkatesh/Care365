package Pages;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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
		
		@FindBy(xpath= "//span[contains(text(),'Logout')]")
	    private WebElement btn_logout;
		
		
		// Successfull email confirmation
		
		@FindBy(xpath= "//div[@class='hot-toast-message']")
		private WebElement MailSent_confirmationMsg;
		
		
		//All menus parent element
		
		@FindBy(xpath="//div[@class='mat-list-item-content']")
		public List<WebElement> AllMenus;
		
		//Title of the page
		
		@FindBy(xpath="//span[@class='rpm-page-title']")
		private WebElement Title_ofPage;
		
		
		//Dashboard menu
		
		
		@FindBy(xpath= "//span[text()='Dashboard']")
		private WebElement DashboardMenu;
		
		// Practices menu
		@FindBy(xpath= "//span[text()='Practices']")
		private WebElement PracticeMenu;
		
		//Clinics menu
		
		@FindBy(xpath= "//span[text()='Clinics']")
		private WebElement ClinicsMenu;
		
		//Providers Menu
		@FindBy(xpath= "//span[text()='Providers']")
		private WebElement ProvidersMenu;
		
		//Caregivers Menu
		@FindBy(xpath= "//span[text()='Caregivers']")
		private WebElement CaregiversMenu;
		
		//Enrollment menu
		@FindBy(xpath= "//span[text()='Enrollments']")
		private WebElement EnrollmentsMenu;
		
		
		//Devices Menu
		@FindBy(xpath= "//span[text()='Devices']")
		private WebElement DevicesMenu;
		
		//Settings Menu
		
		@FindBy(xpath= "//span[text()='Settings']")
		private WebElement SettingsMenu;
		
		//Reports Menu
		@FindBy(xpath= "//span[text()='Reports']")
		private WebElement ReportsMenu;
		
		//ICD codes sub menu
		
		@FindBy(xpath= "//span[text()=' ICD Codes']")
		private WebElement ICD_CodesMenu;
		
		//CPT codes sub menu
		@FindBy(xpath= "//span[text()= ' CPT Codes']")
		private WebElement CPT_CodesMenu;
		
		//Device Types sub menu
		
		@FindBy(xpath= "//span[text()= ' Device Types']")
		private WebElement DeviceTypes_Menu;
		
		//Specialities sub menu
		
		@FindBy(xpath= "//span[text()= ' Specialities']")
		private WebElement SpecialitiesMenu;
		
		//logHistory sub menu
		
		@FindBy(xpath= "//span[text()=' Log History']")
		private WebElement LogHistory_Menu;
		
		

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

		public void Clickon_Allmenus()
		{
			click_DashboardMenu();
			click_PracticeMenu();
			click_ClinicsMenu();
			click_CaregiversMenu();
			click_ProvidersMenu();
			click_EnrollmentsMenu();
			
			click_DevicesMenu();
			click_SettingMenu();
		
			click_ICDCodesMenu();
			click_CPTCodesMenu();
			click_deviceTypesMenu();
			click_SpecialitiesMenu();
			click_ReportsMenu();
			click_LogHistoryMenu();
			
		}
		
		
		public void click_DashboardMenu()
		{
			
			element_isDisplayed(DashboardMenu);
			DashboardMenu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}
		public void click_PracticeMenu()
		{
			
			element_isDisplayed(PracticeMenu);
			PracticeMenu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}
		
		public void click_ClinicsMenu() 
		{
			
			element_isDisplayed(ClinicsMenu);
			explicitWait_ElementtoBeClickable(ClinicsMenu);
			ClinicsMenu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}
		

		public void click_CaregiversMenu()
		{
			element_isDisplayed(CaregiversMenu);
			CaregiversMenu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}

		public void click_ProvidersMenu()
		{
			element_isDisplayed(ProvidersMenu);
			ProvidersMenu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}
		
		
		public void click_DevicesMenu()
		{
			element_isDisplayed(DevicesMenu);
			DevicesMenu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}
		
		public void click_EnrollmentsMenu()
		{
			element_isDisplayed(EnrollmentsMenu);
			EnrollmentsMenu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}
		
		public void click_SettingMenu()
		{
			element_isDisplayed(SettingsMenu);
			SettingsMenu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}
		public void click_ICDCodesMenu()
		{
			element_isDisplayed(ICD_CodesMenu);
			ICD_CodesMenu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}
		public void click_CPTCodesMenu()
		{
			element_isDisplayed(CPT_CodesMenu);
			CPT_CodesMenu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}
		
		public void click_deviceTypesMenu()
		{
			element_isDisplayed(DeviceTypes_Menu);
			DeviceTypes_Menu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}
		public void click_SpecialitiesMenu()
		{
			element_isDisplayed(SpecialitiesMenu);
			SpecialitiesMenu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}
		
		public void click_ReportsMenu()
		{
			element_isDisplayed(ReportsMenu);
			ReportsMenu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}
		public void click_LogHistoryMenu()
		{
			element_isDisplayed(LogHistory_Menu);
			LogHistory_Menu.click();
			Title_ofPage.getText();
			System.out.println("Title of the page:" +Title_ofPage.getText());
		}
			
		public void allMenusList_count()
		{
			int Count_OfMenus = AllMenus.size();
			if(Count_OfMenus==12)
			{
				System.out.println(Count_OfMenus+" menus are present in homepage");
						
			}
			else 
				System.out.println("menu counts are not matched");
		}
		
		
}
