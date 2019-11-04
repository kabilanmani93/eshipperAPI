package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import factory.DataProviderFactory;

public class Helper
{
	
	public static String captureScreenshot(WebDriver driver,String ScreenhotName)
	{
		TakesScreenshot ts =(TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dst = DataProviderFactory.getConfig().getScreenShotPath()+ScreenhotName+ System.currentTimeMillis()+".png";
		try 
		{
			FileUtils.copyFile(src,new File(dst));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return dst;
	}
	

}
