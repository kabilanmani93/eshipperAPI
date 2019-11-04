package factory;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.configuration.Config;

import dataProvider.ConfigDataProvider;
import dataProvider.ReportDataProvider;
import dataProvider.ExcelDataProvider;

public class TestBase 
{
	/*
	 WebDriver
	 properties
	 Logs
	 extentReports
	 DB
	 Excel
	 Mail
	 */
	
	public static WebDriver driver;
	public static ConfigDataProvider config= DataProviderFactory.getConfig();
	public static ExcelDataProvider excel= DataProviderFactory.getExcel();
	public static ReportDataProvider report= DataProviderFactory.getReport();
	
	public static Logger log = Logger.getLogger("devpinoyLogger");	
	public static String log4jpath = config.getLog4jPath();
	
	
	@BeforeSuite
	public void setUp(String BrowserName)
	{
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			System.out.println(DataProviderFactory.getConfig().getChromePath());
			System.setProperty("webdriver.chrome.driver", config.getChromePath());
			driver = new ChromeDriver();
			
			//if a prperty needs to fetched separately
			//String Url =config.getConfigPro().getProperty("URL");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		System.out.println("Test driver");
		log.info("Logger Msg devpinoy Before Suite");
		
		driver.get(config.getApplicationURL());
		
		//return driver;
	}

	@AfterSuite
	public void tearDown()
	{
		if(driver !=null)
		{
			driver.quit();
		}
	}
	

}
