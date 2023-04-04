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
public class CustomerCreation extends Baseclass {
	
	@Test(groups= {"system","smoke"})
	public void createCustomer() throws EncryptedDocumentException, IOException {
		int num=cu.getRandomnum(1000);
		String customername=du.getDataFromExcelSheet("Sheet1", 3, 1);
		customername=customername+num;
	
		//driver.findElement(By.xpath("//div[@id='container_tasks']")).click();
	    driver.findElement(By.xpath("//div[text()='Add New']")).click();
	    driver.findElement(By.xpath("//div[text()='+ New Customer']")).click();
	    driver.findElement(By.className("newNameField")).sendKeys(customername);
        driver.findElement(By.cssSelector("[placeholder='Enter Customer Description']")).sendKeys("testing");
        driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
        cu.gettextToBePresentInElementLocated(driver,By.cssSelector(".titleEditButtonContainer>.title"),customername);
        String actualcustomername=driver.findElement(By.cssSelector(".titleEditButtonContainer>.title")).getText();
        SoftAssert sa=new SoftAssert();
        sa.assertTrue(customername.contains(actualcustomername));
        Reporter.log(actualcustomername, true);
        System.out.println("pass");
        sa.assertAll();
	}

}
