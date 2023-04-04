package actitime.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutLocator {
	public LogoutLocator(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="logoutLink")
	private WebElement logoutopt;
	
	public WebElement getLogoutButton()
	{
		return logoutopt;
	}
    public void logoutApp()
    {
    	
    	getLogoutButton().click();
    	
    }

}
