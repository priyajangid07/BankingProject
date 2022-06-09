package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	static ExtentHtmlReporter htmlReporter;
	
	static ExtentReports report;
	
	static ExtentTest test;
	
	static WebDriver driver;
	public static WebDriver getDriver(String browser)
	{
		if(driver == null)
		{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browsers\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browsers\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
	
		driver.get("https://groww.in/");
		driver.manage().window().maximize();
}
		
		return driver;
	}
	
	public static ExtentTest getTestForReporter(String useCase)
	{
		
		return test = report.createTest(useCase);
	}
	
	public static ExtentHtmlReporter getHtmlReporter()
	{
		if(htmlReporter == null)
		{
			htmlReporter = new ExtentHtmlReporter("ExtentReporter.html");
			
		}
		
		return htmlReporter;
	}
	
	public static ExtentReports getExtentReport()
	{
		if(report == null)
		{
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
		}
		
		return report;
	}
}
