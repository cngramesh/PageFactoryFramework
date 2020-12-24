package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LoginPage;
import utility.Helper;

public class TC_01_LoginToOrange extends BaseClass {
	
	@Test
	public void loginToCRM() 
	{
		logger = report.createTest("Login to Orange HRM");
		
		LoginPage loginPageObj = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting application");
		
		String uname = excel.getStringData("Login", 0, 0);
		String password = excel.getStringData("Login", 0, 1);
		loginPageObj.loginToOrange(uname,password);
		Helper.captureScreenshot(driver);
		
		logger.pass("Login successful.");
				
	}
	

}
