package pomClasses;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilClasses.UtilClass;

public class Login_page extends UtilClass {

	WebDriver driver;
	
	@FindBy(xpath="//span[text()='Login/Register']")  //span[text()='Login/Register'] //for login button to enter login pop up
	private WebElement loginButton;
	
	@FindBy(xpath="//input[@id='login_email1']")   //input[@id='login_email1']      // for email 
	private WebElement email;
	
	@FindBy(xpath="//span[text()='Continue']")  	//span[text()='Continue']   //for continue button
	private WebElement Continue;
	
	@FindBy(xpath="//input[@id='login_password1']")   //input[@id='login_password1']   // for password
	private WebElement password;
	
	@FindBy(xpath="//div[@class='col l12 leps592LoginButton']")   //div[@class='col l12 leps592LoginButton']   //for submit button
	private WebElement submit;
	
	@FindBy(xpath="(//input[@type='number'])[1]")
	private WebElement pinField;
	
	
	public Login_page(WebDriver driver)        //CONSTRUCTOR to give value to global driver 
	{
		PageFactory.initElements(driver,this);
		this.driver=driver;                       //blue is global driver
		
	}
	
	public void clickOnLoginButton()          //login button
	{
		loginButton.click();
	}
	
	public void enterEmail() throws IOException             //email
	{
		expliciteWait(driver, email);
		email.sendKeys(UtilClass.getDataFromPropertyFile("email"));
	}
	
	public void clickOnContinue()                //continue
	{
		expliciteWait(driver, Continue);
		Continue.click();
	}
	
	
	public void enterpassword() throws IOException          //password
	{
		expliciteWait(driver, password);
		password.sendKeys(UtilClass.getDataFromPropertyFile("password"));
	}
	
	
	public void clickOnSubmit()             //submit
	{
		expliciteWait(driver, submit);
		submit.click();
	}
	
	
	
	public void enterPin() throws IOException, InterruptedException
	{
		String pin = getDataFromPropertyFile("pin");
		
		char[] digit = pin.toCharArray();
		
		System.out.println(Arrays.toString(digit));
		
		Thread.sleep(4000);
		
		expliciteWait(driver, pinField);
		
		List<WebElement> elements = driver.findElements(By.xpath("//input[@type='number']"));
		
		for(int i=0; i<digit.length; i++)
		{
			elements.get(i).sendKeys(String.valueOf(digit[i]));
		}
	}
	
}
