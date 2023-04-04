package actitime.genericLib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementation implements ITestListener  {
	public void onTestFailure(ITestResult result) {
		String tcname=result.getName();
	TakesScreenshot ts=(TakesScreenshot)Baseclass.listenerdriver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File tgr=new File("./failedTc/"+tcname+".png");
	try {
		FileUtils.copyFile(src,tgr);
	} catch (IOException e) {
		
	}
	}

	
}
 