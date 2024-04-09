package org.ictkerala.ictlearnerwesite;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PlacementOfficerLogin 
{
WebDriver driver;

	public  PlacementOfficerLogin (WebDriver driver)

	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']")
	private WebElement Username;
	@FindBy(xpath="//input[@id='password']")
	private WebElement Password;
	@FindBy(xpath="//button[text()='Login']")
	private WebElement LoginButton;
	@FindBy(xpath="//small[text()='Username is required.']")
	private WebElement Usernameerrormessage;
	@FindBy(xpath="//small[text()='Password is required.']")
	private WebElement 	Passworderrormessage;
	@FindBy(xpath="//div[contains(@class, 'alert') and contains(@class, 'alert-danger') and contains(@class, 'alert-dismissible') and contains(@class, 'show') and text()='User not found !!']")
	private WebElement 	loginerrormessage;
	@FindBy(xpath="//div[@role='alert' and contains(@class, 'alert-danger') and contains(@class, 'alert-dismissible') and contains(@class, 'show') and text()='Login Failed!!']")
	private WebElement 	invaliderrormessage;
    @FindBy(xpath="//a[@href='/' and contains(@class, 'text-muted') and contains(@class, 'text-decoration-none')]")
	private WebElement 	logo;
	@FindBy(xpath="//a[@class='navbar-brand' and  text()='LearnerTracker']")
	private WebElement 	Dashboardvalid;
	@FindBy (xpath="//button[@type=\"button\"and@class=\"btn btn-success btn btn-primary\"]")
	private WebElement UpdateButton;
	@FindBy(xpath="//h3[text()=\"Learner's form\"]")
    private WebElement LearnersForm;
	@FindBy(xpath="//select[@name='pstatus']")
    private WebElement TestDrpDwn;
	@FindBy(xpath="//button[text()='Submit']")
    private WebElement SubmitButton;
	@FindBy(xpath="//button[text()='Back to Dashboard']")
    private WebElement BacktoDashboard;
	@FindBy(xpath="//a[@id='basic-nav-dropdown' and text()='Officer']")
    private WebElement Logout;
	@FindBy(xpath="//a[text()='Logout']")
    private WebElement Logoutsuccess; 
	@FindBy(xpath="//td[text()='Placed']")
	private WebElement Upateverify;
	
	public void Validlogin(String user,String Pwd)
    {
	Username.sendKeys(user);
    Password.sendKeys(Pwd);
    LoginButton.click();
    }
	public void blanklogin(String user,String Pwd)
    {
	Username.sendKeys(user);
    Password.sendKeys(Pwd);
    LoginButton.click();
    }
	public void blankcred(String user,String Pwd)
    {
	Username.sendKeys(user);
    Password.sendKeys(Pwd);
    LoginButton.click();
    }
	
	public void invalidlogin(String user,String Pwd)
    {

	Username.sendKeys(user);
    Password.sendKeys(Pwd);
    LoginButton.click();
    Username.clear();
    Password.clear();   
    }
	public String usererrormessage()
	{
	String	ActualText=Usernameerrormessage.getText();
		return(ActualText);
	}
	public String pwderrormessage1()
	{
	String	ActualText=Passworderrormessage.getText();
	return(ActualText);
	}
	public String blankerrormessage2()
	{
	
	String	ActualText=loginerrormessage.getText();
	return(ActualText);
		
	}
	public String Invaliderrormessage()
	{
		
	String	ActualText=invaliderrormessage.getText();
	return(ActualText);
	}
	public String Loginvalidation()
	{
		String ActualText=Dashboardvalid.getText();
		return(ActualText);
	}
	public void LogoCheck()
	{
		logo.click();
	}
	
	public void Redirectvalidation()
	{
		String actualTitle=driver.getTitle();
		String expectedTitle="ICTAK LearnerTracker App";
		Assert.assertEquals(actualTitle,expectedTitle); 
		System.out.println("Navigated to ICTAK Learner Tracker Website");
	}
	public void updatestatus()
	{
		UpdateButton.click();
		TestDrpDwn.click();
		Select dropDown=new Select(TestDrpDwn);
		dropDown.selectByVisibleText("Placed");
		
	}
	public void SubmitUpdation()
	{
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	//	wait.until(ExpectedConditions.elementToBeClickable(SubmitButton)).click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SubmitButton);
	      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", SubmitButton);
		//SubmitButton.click();
	}
	public String UpdateAssertion()
	{   
		String ActualText=LearnersForm.getText();
		return(ActualText);
	}
	public String UpdatedetailAssertion()
	{
		String ActualText=Upateverify.getText();
		return(ActualText);
	}
	
	
	public void StatusMenuCheck()
	{
		UpdateButton.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", TestDrpDwn);
			Select select = new Select(TestDrpDwn);
			List<WebElement> options = select.getOptions();
			List<String> expectedOptions = Arrays.asList("Placed","Job seeking","Not Interested");
			for (String expectedOption : expectedOptions) {
				boolean found = false;
				for (WebElement option : options) {
					if (option.getText().equals(expectedOption)) {
						found = true;
						break;
					}
				}
			Assert.assertTrue(found, "Option '" + expectedOption + "' not found in dropdown");
			System.out.println("Assertion Passed: Option '" + expectedOption + "' found in dropdown");

			}
            BacktoDashboard.click();
            }       
	
      public void LogoutOfficer()
      {
    	  driver.navigate().refresh();
    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
       	wait.until(ExpectedConditions.elementToBeClickable(Logout)).click();
    	  Logoutsuccess.click();
    	  
      }
	}
	







