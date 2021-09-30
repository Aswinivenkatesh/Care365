package Com.QA.Config;

import java.awt.AWTException;

import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

//import java.util.HashMap;
//import java.util.Map;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
			FileInputStream fis = new FileInputStream("C:\\Users\\admim\\eclipse-workspace\\CARE365_Project\\src\\test\\resources\\Data\\Data.properties");
			prop.load(fis);

		}

		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}


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
			implicitWait();
			browser_Maximize();
			System.out.print("Driver:::"+driver);
		}

		else if(browsername.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();
			implicitWait();
			browser_Maximize();

		}
		else if(browsername.equals("IE"))
		{
			WebDriverManager.edgedriver().setup();

			driver = new EdgeDriver();
			implicitWait();
			browser_Maximize();

		}



	}


	// Broswer maximize

	public static void browser_Maximize()
	{
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);		
		driver.manage().window().maximize();
	}

	//Verify page title 

	public static void verifyPage(WebDriver driver, String expectedTitle)
	{
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains(expectedTitle));
		String actualTitle= driver.getTitle();
		if(expectedTitle.equals(actualTitle))
			System.out.println("expected page title is:====>"+ expectedTitle);
		else
			System.out.println("expected page not displayed, current page title is:===>"+actualTitle);
	}


	//Close Browser
	public void closeBrowser()
	{
		driver.close();
	}


	
	// Basic method to read data from excel 
	 
		public static Map<String, String> readXLData( String sheet, String Column_name) throws IOException
		{
			System.out.println("Inside the excel read method");
			FileInputStream fis = new FileInputStream("C:\\Users\\admim\\eclipse-workspace\\CARE365_Project\\src\\test\\resources\\Data\\TestData.xlsx");
			Workbook workbook = new XSSFWorkbook(fis);

			Sheet sheet_name = workbook.getSheet(sheet);
			//int totalNoOfCols = sheet.getcolumn;
			int lastRow = sheet_name.getLastRowNum();
			System.out.println(lastRow+"last row count");
			Row column = sheet_name.getRow(0);
			String data="";
			Map<String, String> dataMap = new HashMap<String, String>();
	 
	        for(int i=0; i < column.getLastCellNum(); i++)
	        {
	            if(column.getCell(i).getStringCellValue().trim().equals(Column_name))
	            {
	            	for(int j=1; j<=lastRow; j++)
	            	{
	            		Row row = sheet_name.getRow(j);
	         
//	            		data=row.getCell(j).toString();
	            		data = row.getCell(i).toString();
	            		System.out.println("Cell value:::" +row.getCell(i));

	            		dataMap.put(row.getCell(i).toString(),row.getCell(i).toString());
	            	}
	            			
	            	}
	            }
			return dataMap;
		}
	
	
	
	
	//Read data from excel sheet using hashmap technology


	public String readDataFromExcel(String Sheet,String keyValue) throws IOException {

		// TODO Auto-generated method stub
		System.out.println("Inside the excel read method");
		FileInputStream fis = new FileInputStream("C:\\Users\\admim\\eclipse-workspace\\CARE365_Project\\src\\test\\resources\\Data\\TestData.xlsx");
		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheet(Sheet);
		//int totalNoOfCols = sheet.getcolumn;
		int lastRow = sheet.getLastRowNum();
		System.out.println(lastRow+"last row count");

		// Map<String, Map<String, String>> excelFileMap = new HashMap<String, Map<String,String>>();

		Map<String, String> dataMap = new HashMap<String, String>();

		//Looping over entire row
		
		for(int i=1; i<=lastRow; i++){

			Row row = sheet.getRow(i);

			//0th Cell as Key
			Cell keyCell = row.getCell(0);

			//1st Cell as Value
			Cell valueCell = row.getCell(1);
			
			System.out.println("Value Cell "+keyCell+" "+valueCell);
			String value;
			String key;
			try {
//			 value = valueCell.getStringCellValue().trim();
//			key = keyCell.getStringCellValue().trim();
				
				value = valueCell.toString();
			     key =keyCell.toString();
			} catch (NumberFormatException ex) {
				value =String.valueOf(valueCell.getNumericCellValue());
			     key =String.valueOf(keyCell.getNumericCellValue());
			}
             
						
			
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


	//Explicit Wait- Element to be clickable 
	public void explicitWait_ElementtoBeClickable(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	//Explicit wait- Element is visible
	public void explicitWait_ElementtoBeVisible(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(element));

	}



	//Accept Alert

	public void alert_Accept()
	{
		Alert alert = driver.switchTo().alert();

		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alertMessage);
		alert.accept();
	}


	//Dismiss Alert
	public void alert_Dismiss()
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}



	//Get text from Alert
	public void alert_getText()
	{
		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
		System.out.println(alertMessage);
	}

	//Create select class


	public Select select_Dropdown(WebElement element)
	{
		Select slc = new Select(element);
		return slc;
	}


	// Take a screenshot


	public static void takesScreenShot(WebDriver driver)
	{
		try {
			Date d = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"); 
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			//File des= new File(path);
			FileUtils.copyFile(src, new File("C:\\Users\\admim\\eclipse-workspace\\CARE365_Project\\target\\Screenshots " + sdf.format(d)+ ".png"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	//Robot class: Move to Element 
	public void robot_movetoElement() throws AWTException
	{
		Robot robot = new Robot();
		robot.mouseMove(0, 0);
	}





	// Set up webdriver-  when driver reference  is null
	public WebDriver setup_Browser()
	{
		if(driver==null)
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Driver:::::"+ driver);
		}
		return driver;

	}

	//Check element is displayed 
	public  void element_isDisplayed(WebElement Element)
	{

		System.out.println("Element is displayed:::" +Element.isDisplayed());

	}

	//Check element is selected 

	public void element_isSelected(WebElement Element)

	{
		System.out.println("Element is selected:::" +Element.isSelected());
	}


	//Element is Enabled 

	public void element_isEnabled(WebElement Element)
	{
		System.out.println("Element is Enabled:::" +Element.isEnabled());
	}

	//	public void notification_popup()
	//	{
	//	    options = new ChromeOptions();
	//		options.addArguments("--enable-notifications");
	//	}


	// Handle multiple windows
	public void HandleWindows()
	{
		Set<String> wh=driver.getWindowHandles();
		System.out.println(wh.size());
		for(String window: wh)
		{

			driver.switchTo().window(window);
			System.out.println(driver.switchTo().window(window).getTitle());
		}	

	}

	//Generate random numbers 
	public int random_Numbers()
	{
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(1000); 
		return randomInt;
	}


	// Generate Random NPI numbers

	public String  random_NPINumbers()
	{
		Random randomGenerator = new Random();  
		long randomNPI = randomGenerator.nextInt(1000000000); 
		return String.valueOf(randomNPI);
	}

}
