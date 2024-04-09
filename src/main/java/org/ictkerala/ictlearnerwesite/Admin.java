package org.ictkerala.ictlearnerwesite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Admin 
{
	WebDriver driver;
	@FindBy(xpath="//input[@name='username']")
	private WebElement Username;
	@FindBy(xpath="//input[@id='password']")
	private WebElement Password;
	@FindBy(xpath="//button[text()='Login']")
	private WebElement LoginButton;
	@FindBy(xpath="//div[text()='Login Failed!!']")
	private WebElement errormessage;
	public  Admin(WebDriver driver)

	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

		public void Adminlogin_1(String user,String pwd)
	    {
			driver.navigate().refresh();
		Username.sendKeys(user);
	    Password.sendKeys(pwd);
	    LoginButton.click();
	
    }
		public String adminloginassertion()
{
			String expected=errormessage.getText();
			return(expected);
}
}
	


