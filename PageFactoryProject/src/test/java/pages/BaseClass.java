package pages;

import java.io.File;
import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utility.BrowserFactory;
import utility.ConfigDataProvider;
import utility.ExcelDataProvider;
import utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider configObj;
	public static ExtentReports report;
	public static ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() throws FileNotFoundException
	{
		excel = new ExcelDataProvider();
		configObj  = new ConfigDataProvider();
		
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"\\Reports\\ExtentReportResults.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@Parameters({"browser","appURL"})
	@BeforeClass
	public void setup(String browser,String appURL)
	{
		//driver = BrowserFactory.startApplication(driver,configObj.GetBrowser(),configObj.getURL());
		driver = BrowserFactory.startApplication(driver,browser,appURL);
		System.out.println(driver.getTitle());
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult Result)
	{
		if(Result.getStatus()==ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver);
		}
		
		report.flush();
	}
	
}
