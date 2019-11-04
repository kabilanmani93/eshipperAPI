package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigDataProvider 
{
	Properties pro;
	
	public ConfigDataProvider()
	{
		File src = new File ("./src/test/resources/properties/config.properties");
			
				
		try
		{
			FileInputStream fis = new FileInputStream(src);			
			pro = new Properties();
			pro.load(fis);
		}
		catch (Exception e)
		{
			System.out.println("The Exception message is" + e.getMessage());
		}
		
		
	}
	
	public Properties getConfigPro()
	{
		return pro;
		
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("URL");
		return url;
	}
	
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromePath");
		return chromepath;
	}
	
	public String getLog4jPath()
	{
		String Log4jpath = pro.getProperty("log4jPath");
		return Log4jpath;
	}
	 
	public String getScreenShotPath()
	{
		String ScreenShotPath = pro.getProperty("screenShotFolderPath");
		return ScreenShotPath;
	}
	
	public String getReportPath()
	{
		String ReportPath = pro.getProperty("reportPath");
		return ReportPath;
	}
	
	public String getUMURL()
	{
		String UMURL = pro.getProperty("UMURL");
		return UMURL;
	}
	 
	

}
