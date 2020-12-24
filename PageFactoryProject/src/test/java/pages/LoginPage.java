package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
		
		WebDriver driver;
	
		public LoginPage(WebDriver ldriver)
		{
			this.driver=ldriver;
		}
	
		@FindBy(name="txtUsername") WebElement username;
		
		@FindBy(name="txtPassword") WebElement password;
		
		@FindBy(id="btnLogin") WebElement loginButton;
		
		
		public void loginToOrange(String orangeUserName, String orangePassword)
		{
			username.sendKeys(orangeUserName);
			password.sendKeys(orangePassword);
			loginButton.click();
		}
		
		
		
		
		
		
}
