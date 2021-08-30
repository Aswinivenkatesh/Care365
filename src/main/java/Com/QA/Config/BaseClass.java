package Com.QA.Config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
	
	public void initializationOfBrowser() {
		
		String browsername = prop.getProperty("Browsername");
		if(browsername.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
	
			        driver = new ChromeDriver();
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
	
	
	

}
