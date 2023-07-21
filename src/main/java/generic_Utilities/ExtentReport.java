package generic_Utilities;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

// Here I am Designing the Extent Report
public class ExtentReport implements ITestListener {
WebDriver driver;
ExtentReports report;
ExtentTest test;
	public void onTestStart(ITestResult result) {
		//Step 3 - create test method during the test start.
		report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		//Step 4 - log the pass method 
		test.log(Status.PASS,result.getMethod().getMethodName());
		
	}

	public void onTestFailure(ITestResult result) {
		//Step 5 - Log the all failed method.
		String testName = result.getMethod().getMethodName();
		System.out.println("--------execute----------");
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sDriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		try {
			
			FileUtils.copyFile(src, new File("./Screen/"+testName+".png"));
		}catch(Exception e )
		{
			e.printStackTrace();
		}
		test.log(Status.FAIL, result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) {
		//Step 6 - log the Skipped method
		test.log(Status.SKIP, result.getMethod().getMethodName());
	}

	public void onStart(ITestContext context) //(suit start) first method - where execution starts
	{//Step1: Extent Report Configuration.
		Date d = new Date();
		System.out.println(d);
		d.toString().replace(":","-").replace(" ", "*;");
		ExtentSparkReporter htmlReport = new ExtentSparkReporter(new File("ExtentReport.html"));
		htmlReport.config().setDocumentTitle("VTiger Extent Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Automation Test");
		
		//Step 2- Attach the Physical Report and do the System Configuration
				report = new ExtentReports();
				report.attachReporter(htmlReport);
				report.setSystemInfo("OS", "windows 10");
				report.setSystemInfo("Environment", "Automation Testing");
				report.setSystemInfo("url", "https://localhost:8888");
				report.setSystemInfo("Reporter Name", "Nisha");
			
	}

	public void onFinish(ITestContext context)//(suit finish) first method - where execution finished
	{
	
		report.flush();
		
	}
	

}
