package testCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.LogOutPage;
import utility.Helper;

public class TC_02_LogOutFromOrange extends BaseClass {
	
	@Test
	public void loginToCRM() 
	{
		logger = report.createTest("Logout from Orange HRM");
		
		LogOutPage logOutPageObj = PageFactory.initElements(driver, LogOutPage.class);
		
		logger.info("Exiting from the application");
		
		//Call Logout method from Pages/LogoutPage
		logOutPageObj.logOutFromOrangeHRM();
		
		Helper.captureScreenshot(driver);
		
		logger.pass("Login successful.");
				
	}

}
