package actitime.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepageLocators {
  public HomepageLocators(WebDriver driver)
	{
	  PageFactory.initElements(driver,this);
	}
  @FindBy(xpath="//div[@id='container_tasks']")
  private WebElement taskmanager;
  public WebElement gettaskManager()
  {
	return taskmanager;
  }
  public void Homepage()
  {
	  gettaskManager().click();
  }
}
