package actitime.genericLib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import actitime.elementRepository.HomepageLocators;
import actitime.elementRepository.LoginLocators;
import actitime.elementRepository.LogoutLocator;

public class Baseclass {
	public	WebDriver driver;
    public static WebDriver listenerdriver;
	public Datautility du=new Datautility();
	public CommonUtility cu=new CommonUtility();
	@BeforeClass(alwaysRun=true)
	public void luanchbrowser() throws IOException
	{   driver=new EdgeDriver();
	    listenerdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod(alwaysRun=true)
	public void login() throws IOException
	{   
		driver.get(du.getDataFromProperties("url"));
		LoginLocators ll=new LoginLocators(driver);
		ll.loginApp(du.getDataFromProperties("username"),du.getDataFromProperties("password"));
		HomepageLocators hp=new HomepageLocators(driver);
		hp.Homepage();
	}
	@AfterMethod(alwaysRun=true)
	public void logout()
	{
		LogoutLocator lol=new LogoutLocator(driver);
		lol.logoutApp();
		//driver.findElement(By.id("logoutLink")).click();
	}
	@AfterClass(alwaysRun=true)
	public void closebrowser()
	{
		driver.quit();
	}
}
