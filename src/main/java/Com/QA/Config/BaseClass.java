package Com.QA.Config;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileInputStream;
import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	
	public BaseClass() {
		
	try {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\admim\\eclipse-workspace\\CARE365_Project\\src\\main\\java\\Com\\QA\\Config\\Data.properties");
		prop.load(fis);
	
	}
	
	catch(IOException e)
	{
			System.out.println(e.getMessage());
	}
	}
	
	@BeforeSuite
	public void initializationOfBrowser() {
		
		String browsername = prop.getProperty("Browsername");
		if(browsername.equals("chrome"))
		{
			
			ChromeOptions options = new ChromeOptions();
			//options.addArguments("--enable-notifications");
			
			HashMap<String, Object>	 prefs = new HashMap<String, Object>();
			
		   prefs.put("profile.default_content_setting_values.notifications", 1);
           options.setExperimentalOption("prefs",prefs);
		   WebDriverManager.chromedriver().setup();
	
			        driver = new ChromeDriver(options);
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);		
				    driver.manage().window().maximize();
		}
		else if(browsername.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
	
			        driver = new FirefoxDriver();
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);		
				    driver.manage().window().maximize();
		}
		else if(browsername.equals("IE"))
		{
			WebDriverManager.edgedriver().setup();
	
			        driver = new EdgeDriver();
					driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);		
				    driver.manage().window().maximize();
		}
		
		
		
	}
	
	@AfterSuite
	public void closeBrowser()
	{
		driver.close();
	}


	public String readDataFromExcel(String Sheet,String keyValue) throws IOException {
		
		// TODO Auto-generated method stub
		System.out.println("Inside the excel read method");
		FileInputStream fis = new FileInputStream("C:\\Users\\admim\\OneDrive\\Documents\\Xpath_Of_Elements.xlsx");
		
		  Workbook workbook = new XSSFWorkbook(fis);
		
		  Sheet sheet = workbook.getSheet(Sheet);
		  
		  int lastRow = sheet.getLastRowNum();
		  
		 // Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String,String>>();
		  
		  Map<String, String> dataMap = new HashMap<String, String>();
		  
		  //Looping over entire row
		  for(int i=1; i<=lastRow; i++){
			  
			  Row row = sheet.getRow(i);
			  
			  //0th Cell as Key
			  Cell keyCell = row.getCell(0);
			  
			  //1st Cell as Value
			  Cell valueCell = row.getCell(1);
				    
			  String value = valueCell.getStringCellValue().trim();
			  String key = keyCell.getStringCellValue().trim();
				  
			  //Putting key & value in dataMap
			  dataMap.put(key, value);
				  
			  //Putting dataMap to excelFileMap
			 // excelFileMap.put("DataSheet", dataMap);
			  
			  
		  }
		  System.out.println(dataMap.get(keyValue));
		  return dataMap.get(keyValue);
		
		 
		
	}
	
	//Implicit Wait
	
	public void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	//Explicit Wait
	public void explicitWait_ElementtoBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	
	public void alert_Accept()
	{
		Alert alert = driver.switchTo().alert();
	
		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
        System.out.println(alertMessage);
    	alert.accept();
	}
	
	public void alert_Dismiss()
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void alert_getText()
	{
		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
        System.out.println(alertMessage);
	}
	
	
	public void robot_movetoElement() throws AWTException
	{
		Robot robot = new Robot();
		robot.mouseMove(0, 0);
	}

//	public void notification_popup()
//	{
//	    options = new ChromeOptions();
//		options.addArguments("--enable-notifications");
//	}
//	
	
}
