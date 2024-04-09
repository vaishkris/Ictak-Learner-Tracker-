package org.ictkerala.test_ictaklearner;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends TestBase
{
	@Test(priority = 1)
	public void Nav_1()
	{
	String actualTitle=driver.getTitle();
	String expectedTitle="ICTAK LearnerTracker App";
	Assert.assertEquals(actualTitle,expectedTitle); 
	System.out.println("Navigated to ICTAK Learner Tracker Website");
	}
	@Test(priority = 1)
	public void Ele_1()
	{
		logpage.LogoCheck();
		boolean Actual=logpage.logoassert();
		Assert.assertTrue(Actual, "Logo is displayed on the page");
		
	}
	
	@Test(priority=2)
	public void Ele_2()
	{
		logpage.Usernamefieldcheck();
		String ActualText=logpage.Usernamefieldcheck();
		Assert.assertNotNull(ActualText, "Username field is present.");
		System.out.println("UserName Field is Present");
	}
	@Test(priority=3)
	public void Ele_3()
	{
		logpage.Passwordfieldcheck();
		String ActualText=logpage.Passwordfieldcheck();
		Assert.assertNotNull(ActualText, "Password field is present.");
		System.out.println("Password Field is Present");
	}
	
	@Test(priority=3)
	public void Ele_4()
	{
		logpage.Loginbuttoncheck();
		String ActualText=logpage.Loginbuttoncheck();
		Assert.assertNotNull(ActualText, "Login");
		System.out.println("Login Button is Present");
	}
	
	
	@Test(priority=5)
	public void Trainloginvalid_1()
	{
	trainc.blankuser("","trainer@123");
	System.out.println("Login UnSuccessful");
	String ActualText=trainc.usererrormessage();
	Assert.assertEquals(ActualText, "Username is required.");
    }
	@Test(priority=6)
	public void Trainloginvalid_3()
	{
	trainc.blankcred("trainer","");	
    String ActualText=trainc.pwderrormessage1();
	Assert.assertEquals(ActualText,"Password is required.");
	System.out.println("Login UnSuccessful");
   }
	@Test(priority=5)
	public void Trainloginvalid_2()
	{
	trainc.invalidlogin("trainer","trainer@1234");
	System.out.println("Login Unsuccessful");
	String ActualText=trainc.Invaliderrormessage();
	Assert.assertEquals(ActualText, "Login Failed!!");
	}
	@Test(priority=7)
	public void Trainloginvalid_4()
	{
	trainc.blankcred(" "," ");
	String ActualText=trainc.blankerrormessage2();
	Assert.assertEquals(ActualText, "User not found !!");
	}
	@Test(priority=8)
	public void Trainlogvalid_1()
	{
	trainc.Validlogin("trainer","trainer@123");
	System.out.println("Login Successful");
	}
	@Test(priority=9)
	public void TDsuccess_1()
	{
	trainc.Loginvalidation();
	String ActualText=trainc.Loginvalidation();
	Assert.assertEquals(ActualText, "LearnerTracker");
	System.out.println("Login Successful and Navigated to Learners Dashboard");
	}
	@Test(priority=10)
	public void TDadd_1()
	{
	trainc.AddLearner();
	String ActualText=trainc.AddLearnervalidation();
	Assert.assertEquals(ActualText, "Learner's form");
	System.out.println("Navigated to Learners Form");
	}
	@Test(priority=11)
	public void TDaddlearnercheck_1()
	{
	trainc.Addlearnwithallfields("111", "Anna");
	String ActualText=trainc.postsuccessassertion();
	Assert.assertEquals(ActualText, "Posted successfully");
	}
	@Test(priority=12)
	public void TDaddidvalidation_1()
	{
	trainc.Addlearnwithblankid("", "Anna");
	String ActualText=trainc.blankidmessage();
	Assert.assertEquals(ActualText, "Must contain letters,numbers and - only");
	}
	@Test(priority=13)
	public void TDaddnamevalid_1()
	{
	trainc.Addlearnwithblankname("112", "");
	String ActualText=trainc.blanknamemessage();
	Assert.assertEquals(ActualText, "Must contain letters only");
	}
	@Test(priority=14)
	public void Tdaddlearner_3()
	{
	trainc.Addlearnwithblankcourse("112", "Anna");
	String ActualText=trainc.blankcoursemessage();
	Assert.assertEquals(ActualText, "Please select a course for the learner");
	}
	@Test(priority=15)
	public void Tdaddlearner_4()
	{
	trainc.Addlearnwithblankproject("112", "Anna");
	String ActualText=trainc.blankprojectmessage();
	Assert.assertEquals(ActualText, "Please select a project for the learner");
	}
	@Test(priority=16)
	public void Tdaddlearner_5()
	{
	trainc.Addlearnwithblankbatch("112", "Anna");
	String ActualText=trainc.blankbatchmessage();
	Assert.assertEquals(ActualText, "Please select a batch for the learner");
	}
	@Test(priority=17)
	public void Tdaddlearner_6()
	{
	trainc.Addlearnwithblankcoursestatusmessage("112", "Anna");
	String ActualText=trainc.blankcoursestatusmessage();
	Assert.assertEquals(ActualText, "Please select the course status of the learner");
	}
	@Test(priority=18)
	public void Tdvalue_1()
	{
		trainc.CoursesDropdowncheck();
	}
	@Test(priority=19)
	public void Tdvalue_2()
	{
		trainc.ProjectDropdowncheck();
	}
	@Test(priority=20)
	public void Tdvalue_3()
	{
		trainc.BatchDropdowncheck();
	}
	@Test(priority=21)
	public void Tdvalue_4()
	{
		trainc.CourseStatusDropdowncheck();
	}
	@Test(priority=22)
	public void TDaddbulk_1()
	{
		trainc.Uploadcsv();
		String ActualText=trainc.uploadmessageassert();
		Assert.assertEquals(ActualText, "Data added successfully..!"); 
		trainc.acceptmessage();
		
	}
	@Test(priority=23)
	public void TDaddbulk_3()
	{
		trainc.blankcsvupload();
		Alert alert = driver.switchTo().alert();
    	String alertText = alert.getText();
    	Assert.assertEquals(alertText, "No data found!");
    	alert.dismiss(); 
    	
	}
	@Test(priority=24)
	public void Tdaddbulkcancel_4()
	{
		trainc.cancelcsvupload();
		String alertText = trainc.cancelassertion();
    	Assert.assertEquals(alertText, "LearnerTracker");	
	}
	@Test(priority=25)
	public void TDedit_1()
	{
		trainc.editcsvupload();
		String msgconfirm = trainc.editassertion();
    	Assert.assertEquals(msgconfirm, "KKEM");	
		System.out.print("Editing Successful");	
	}
	@Test(priority=26)
	public void TDdelete_1()
	{
		trainc.deletecsvupload();
		
	}
	@Test(priority=27)
	public void Logouttrainer()
	{
		trainc.Logout();;
		String ActualText=trainc.Logoutassertion();
		Assert.assertEquals(ActualText, "ICTAK - Learner Tracker");
		System.out.print("Logout Successful and navigated to HomePage");		
		
	}
	@Test(priority=28)
	public void AdmLogin()
	{    
		adm.Adminlogin_1("admin", "admin@123");
        String ActualText=adm.adminloginassertion();
		Assert.assertEquals(ActualText, "Login Failed!!");
	}
	}
