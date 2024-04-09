package org.ictkerala.test_ictaklearner;

import java.time.Duration;

import org.ictkerala.ictlearnerwesite.Admin;
import org.ictkerala.ictlearnerwesite.LoginPage;
import org.ictkerala.ictlearnerwesite.PlacementOfficerLogin;
import org.ictkerala.ictlearnerwesite.TrainerControl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase
{
	WebDriver driver;
	TrainerControl trainc;
	PlacementOfficerLogin placon;
    LoginPage logpage;
    Admin    adm;
	@BeforeClass
	public void testConfig()
	{
	  
	   driver =new ChromeDriver();
	   trainc=new TrainerControl(driver);
	   placon=new PlacementOfficerLogin(driver);
	   logpage=new LoginPage(driver);
	   adm=new Admin(driver);
		driver.get("https://learnertracker.netlify.app/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
    @AfterClass
    
	public void TearDown()
	{
	System.out.println("All Test Cases Executed");
	}  
	}

