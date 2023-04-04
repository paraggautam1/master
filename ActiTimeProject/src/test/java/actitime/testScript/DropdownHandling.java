package actitime.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import actitime.genericLib.Baseclass;
@Listeners(actitime.genericLib.ListenerImplementation.class)
public class DropdownHandling extends Baseclass{
  @Test(groups= {"system"})
	public void getdropdownhandling() {
	 String expectedresult="MODIFICATIONS NOT SAVED";
	 driver.findElement(By.xpath("//div[@class='popup_menu_button popup_menu_button_settings ']")).click();
	 driver.findElement(By.xpath("//div[text()='Manage system settings & configure actiTIME']/../div[1]")).click();
	 WebElement dropdown=driver.findElement(By.id("userGroupNamingCodeSelect"));
	 cu.getSelectByVisible(dropdown,"Location");
	 String result=driver.findElement(By.id("FormModifiedTextCell")).getText();
	 //Assert.assertEquals(expectedresult,result);
	 SoftAssert sa=new SoftAssert();
	 sa.assertTrue(result.contains(expectedresult));
	 Reporter.log(result, true);
	 System.out.println("tc pass");
	 sa.assertAll();
  }
}
