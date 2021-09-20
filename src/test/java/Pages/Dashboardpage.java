package Pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboardpage {
	
	
	
	
	
	
	    //No.Of Clinics count
	     @FindBy(xpath="//p[text()='No. of Clinics']//parent::div//h2") 
	     private WebElement Clinic_Count; 
	
	
	   //No.Of Caregivers count
	
	     @FindBy(xpath="//p[text()='No. of Caregivers']//parent::div//h2") 
	     private WebElement Caregivers_Count; 
	
	
	   //No.Of patients count
	     @FindBy(xpath="//p[text()='No. of Patients']//parent::div//h2") 
	     private WebElement Patients_Count; 
	
	
	
	   //No.Of doctors count
	
	     @FindBy(xpath="//p[text()='No. of Doctors']//parent::div//h2") 
	     private WebElement Providers_Count; 
	
	
		
		public Dashboardpage(WebDriver driver) { 
			try {
				
	        PageFactory.initElements(driver, this);
			}
			catch(Exception e)
			{
				e.getMessage();
			}
	}
		
		public void get_PatientsCount()
		{
			 String PatientsCount = Patients_Count.getText();
			System.out.println("No.Of Patients: " + PatientsCount);
		}

		public void get_ProvidersCount()
		{
			String ProvidersCount = Providers_Count.getText();
			System.out.println("No.Of Providers: " + ProvidersCount);
		}
        public void get_ClinicsCount()
        {
        	String ClinicsCount = Clinic_Count.getText();
        	System.out.println("No.Of Clinics: " + ClinicsCount);
        }

        public void get_CaregiversCount()
        {
               String CaregiversCount = Caregivers_Count.getText();
        	System.out.println("No.Of Caregivers: " + CaregiversCount);
        }




}



