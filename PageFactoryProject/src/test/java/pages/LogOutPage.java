package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage {
	
	WebDriver driver;
	
	public LogOutPage(WebDriver driver1)
	{
		this.driver=driver1;
	}
	
	
	@FindBy(id="welcome") WebElement welcomeLink;
	
	@FindBy(linkText="Logout") WebElement LogoutLink;
	
	public void logOutFromOrangeHRM()
	{
		welcomeLink.click();
		LogoutLink.click();
	}

}
