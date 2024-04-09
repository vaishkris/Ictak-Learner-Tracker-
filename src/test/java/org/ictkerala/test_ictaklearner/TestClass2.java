package org.ictkerala.test_ictaklearner;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass2 extends TestBase

{
	@Test(priority = 1)
	public void TCnavigation()
	{
	String actualTitle=driver.getTitle();
	String expectedTitle="ICTAK LearnerTracker App";
	Assert.assertEquals(actualTitle,expectedTitle); 
	System.out.println("Navigated to ICTAK Learner Tracker Website");
	}
	@Test(priority = 1)
	public void TC_1()
	{
		logpage.LogoCheck();
	}
	
	@Test(priority=2)
	public void Tc3_()
	{
		logpage.Usernamefieldcheck();
		String ActualText=logpage.Usernamefieldcheck();
		Assert.assertNotNull(ActualText, "Username field is present.");
		System.out.println("UserName Field is Present");
	}
	@Test(priority=3)
	public void Tc4_()
	{
		logpage.Passwordfieldcheck();
		String ActualText=logpage.Passwordfieldcheck();
		Assert.assertNotNull(ActualText, "Password field is present.");
		System.out.println("Password Field is Present");
	}
	@Test(priority=4)
	public void validcred()
	{
	placon.Validlogin("pofficer","pofficer@123");
	String ActualText=placon.Loginvalidation();
	Assert.assertEquals(ActualText, "LearnerTracker");
	System.out.println("Login Successful and Navigated to Learners Dashboard");
	}
	//@Test(priority=6)
//	public void updateform()
	//{
//	placon.updatestatus();
//	String ActualText=placon.UpdateAssertion();
	//Assert.assertEquals(ActualText,"Learner's form");
	//System.out.println("Successfully Navigated to Learners Form Details");
	//}

	@Test(priority=7)
	public void PofficerUpdate_1()
	{
	placon.updatestatus();
	String ActualText=placon.UpdateAssertion();
	Assert.assertEquals(ActualText,"Learner's form");
	System.out.println("Successfully Navigated to Learners Form Details");
	//}
	placon.SubmitUpdation();
	String ActualText1=placon.UpdatedetailAssertion();
	Assert.assertEquals(ActualText1, "Placed");
	System.out.println("Successfully Updated Details");
	}

	@Test(priority=8)
	public void PofficerUpdate_3()
	{
	placon.StatusMenuCheck();
	System.out.println("Options Checked");
	}

	@Test(priority=8)
	public void pofficerlogout()
	{
	placon.LogoutOfficer();
	System.out.println("Logout Successful");
	String ActualText=trainc.Logoutassertion();
	Assert.assertEquals(ActualText, "ICTAK - Learner Tracker");
	System.out.print("Logout Successful and navigated to HomePage");	
	
	}

}
