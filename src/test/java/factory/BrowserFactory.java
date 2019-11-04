package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory 
{
	static WebDriver driver;
	
	public static WebDriver getBrowser(String BrowserName)
	{
		if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			System.out.println(DataProviderFactory.getConfig().getChromePath());
			System.setProperty("webdriver.chrome.driver", DataProviderFactory.getConfig().getChromePath());
			//System.setProperty("webdriver.chrome.driver", "/home/hasher/eclipse-workspace/AutomationFiles/chromedriver");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		System.out.println("Test driver");
		return driver;
	}
	
	public static void closeBrowser(WebDriver ldriver)
	{
		ldriver.quit();
	}
	
	
}
