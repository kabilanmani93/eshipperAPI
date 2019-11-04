package dataProvider;

import java.util.Properties;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import factory.DataProviderFactory;

public class ReportDataProvider
{

/*Properties pro;
static ExtentReports report;
static ExtentTest logger;

//Constructor
	public ReportDataProvider()
	{
		
		report = new ExtentReports(DataProviderFactory.getConfig().getReportPath(),true);
	}

	public ExtentTest startReport(String TCName, String TCDescription)
	{
		logger = report.startTest(TCName,TCDescription);
		return logger;
	}
	
	public static void endReport()
	{
		report.endTest(logger);
		report.flush();	
	}
*/
	 ExtentHtmlReporter htmlreports;
	 static ExtentReports report;
	 ExtentTest test;	
	
	public ReportDataProvider()
	{
		
		htmlreports = new ExtentHtmlReporter(DataProviderFactory.getConfig().getReportPath());
		report = new ExtentReports();
		report.attachReporter(htmlreports);
		
		htmlreports.config().setReportName("Test Extent V3.0");
		htmlreports.config().setTheme(Theme.DARK);
		htmlreports.config().setTestViewChartLocation(ChartLocation.TOP);
	}

	public ExtentTest startReport(String TCName, String TCDescription)
	{
		test = report.createTest(TCName,TCDescription);
		return test;
	}
	
	public static void endReport()
	{
		
		report.flush();	
	}
	
}