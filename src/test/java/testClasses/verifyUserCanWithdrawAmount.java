package testClasses;


	import java.io.IOException;

	import org.openqa.selenium.WebDriver;
	import org.testng.Assert;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.MediaEntityBuilder;
	import com.aventstack.extentreports.Status;
	import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseClasses.BaseClass;
import pomClasses.Fund_page;
import pomClasses.Home_page;
import pomClasses.Login_page;

	

	public class verifyUserCanWithdrawAmount {
		
		WebDriver driver;
		Login_page lp;
		Home_page hp;
		Fund_page fp;
		
		ExtentHtmlReporter htmlReporter;
		ExtentReports report;
		ExtentTest test;
		
		@Parameters("browser")
		@BeforeClass
		public void beforeClass(String bName)
		{
			htmlReporter = BaseClass.getHtmlReporter();
			report = BaseClass.getExtentReport();
			test = BaseClass.getTestForReporter("VerifyUserCanWithdrawAmount");
			
			driver = BaseClass.getDriver(bName);
		}
		
		@BeforeMethod()
		public void beforeMethod()
		{
			lp = new Login_page(driver);
			hp = new Home_page(driver);
			fp = new Fund_page(driver);
		}
		
		
		
		
		
		
		@AfterMethod
		public void afterMethod(ITestResult result) throws IOException
		{
			if(result.getStatus() == ITestResult.SUCCESS)
			{
				test.log(Status.PASS, "Test is passed " + result.getName());
			}
			else
			{
				String path = hp.getScreenShot(driver, result.getName());
				test.log(Status.FAIL, "Test is failed " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			}
		}
		
		
		@AfterClass
		public void afterClass()
		{
			report.flush();
		}
}
