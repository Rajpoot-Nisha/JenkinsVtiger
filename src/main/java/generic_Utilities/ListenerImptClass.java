package generic_Utilities;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.netty.handler.codec.http.HttpContentEncoder.Result;

public class ListenerImptClass implements ITestListener {
	public void onTestFailure(ITestResult result)
	{

	java_utilitiy jlib = new java_utilitiy();
	
	String testData = result.getMethod().getMethodName();
	EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sDriver);
	File src = edriver.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(src, new File("./ScreenShot/"+testData+".png"));
	}
	catch(Exception e ){
		
		e.printStackTrace();
	}
}
}