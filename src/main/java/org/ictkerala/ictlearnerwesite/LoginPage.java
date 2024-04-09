package org.ictkerala.ictlearnerwesite;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage 
{
	WebDriver driver;
	@FindBy(xpath="//img[@alt='logo']")
	private WebElement logo;
	@FindBy(xpath="//input[@placeholder='Enter your username']")
	private WebElement UsernameField;
	@FindBy(xpath="//input[@placeholder='Enter your password']")
	private WebElement PasswordField;
	@FindBy(xpath="//button[text()='Login']")
	private WebElement LoginButtonAssert;
	
	public  LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void LogoCheck()
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", logo);
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logo);
       if (logo.isDisplayed()) 
       {
       System.out.println("Logo is displayed.");
       }
       else
      {
      System.out.println("Logo is not displayed.");
      }
	}
	public boolean logoassert()
	{
		boolean Actuallogo=logo.isDisplayed();
		return(Actuallogo);
	}
public String Usernamefieldcheck()
{
	String ActualText=UsernameField.getText();
	return (ActualText);
	
}
public String Passwordfieldcheck()
{
	String ActualText=PasswordField.getText();
	return (ActualText);
	
}

public String Loginbuttoncheck()
{
	String ActualText=LoginButtonAssert.getText();
	return (ActualText);
	
}}

	
