package actitime.genericLib;


import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtility {
	public int getRandomnum(int range)
	{
		Random r=new Random();
		int num=r.nextInt(range);
		return num;
	}
	public String getAlertHandling(WebDriver driver)
	{
		
		Alert alt=driver.switchTo().alert();
		String msg=alt.getText();
		return msg;
	}
	public void getAlertAccept(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.accept();	
	}
	public void getSelectByVisible(WebElement dropdown,String Visibletext)
	{
		Select s=new Select(dropdown);
		s.selectByVisibleText(Visibletext);
	}
	public void gettextToBePresentInElementLocated(WebDriver driver,By locator,String text)
	{
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,text));
	}
	public void getVisibilityofElementLocated(WebDriver driver,By locator)
	{
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void getScrollByAmount(WebDriver driver,int x,int y)
	{
		Actions act= new Actions(driver);
		act.scrollByAmount(x, y).perform();
	}
	public void getMoveToElement(WebDriver driver,WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}
	public void getContextClick(WebDriver driver,WebElement wb)
	{
		Actions act= new Actions(driver);
		act.contextClick(wb).perform();
	}

}
