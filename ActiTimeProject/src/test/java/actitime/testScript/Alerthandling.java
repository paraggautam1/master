package actitime.testScript;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import actitime.genericLib.Baseclass;
@Listeners(actitime.genericLib.ListenerImplementation.class)
public class Alerthandling extends Baseclass {
	@Test(groups= {"smoke"})
	public void getalerthandling() throws EncryptedDocumentException, IOException {
		driver.findElement(By.xpath("//div[@class='popup_menu_button popup_menu_button_settings ']")).click();
		driver.findElement(By.xpath("//a[text()='Types of Work']")).click();
		driver.findElement(By.xpath("//span[text()='Create Type of Work']")).click();
		driver.findElement(By.id("name")).sendKeys(du.getDataFromExcelSheet("Sheet1", 4, 1));
		driver.findElement(By.xpath("//input[@value='      Cancel      ']")).click();
		String msg="Are you sure you want to cancel the Type of Work creation?";
	    SoftAssert sa=new SoftAssert();
	    sa.assertTrue(cu.getAlertHandling(driver).contains(msg));
		Reporter.log(cu.getAlertHandling(driver), true);
		cu.getAlertAccept(driver);
		System.out.println("tc pass");
		sa.assertAll();
	}

}
