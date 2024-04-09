package org.ictkerala.ictlearnerwesite;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TrainerControl {
	WebDriver driver;

	@FindBy(xpath = "//p[text()='ICTAK - Learner Tracker']")
	private WebElement Homepage;
	@FindBy(xpath = "//input[@name='username']")
	private WebElement Username;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement Password;
	@FindBy(xpath = "//button[text()='Login']")
	private WebElement LoginButton;
	@FindBy(xpath = "//small[text()='Username is required.']")
	private WebElement Usernameerrormessage;

	@FindBy(xpath = "//small[text()='Password is required.']")
	private WebElement Passworderrormessage;
	@FindBy(xpath = "//div[contains(@class, 'alert') and contains(@class, 'alert-danger') and contains(@class, 'alert-dismissible') and contains(@class, 'show') and text()='User not found !!']")
	private WebElement loginerrormessage;
	@FindBy(xpath = "//div[@role='alert' and contains(@class, 'alert-danger') and contains(@class, 'alert-dismissible') and contains(@class, 'show') and text()='Login Failed!!']")
	private WebElement invaliderrormessage;

	@FindBy(xpath = "//div[text()='Posted successfully']")
	private WebElement successmessage;

	@FindBy(xpath = "//button[@type='button' and contains(@class, 'btn-success')]")
	private WebElement Addbutton;
	@FindBy(xpath = "//a[@class='navbar-brand' and  text()='LearnerTracker']")
	private WebElement Dashboardvalid;
	@FindBy(xpath = "//h3[text()=\"Learner's form\"]")
	private WebElement Learnersform;
	@FindBy(xpath = "//input[@name='learnerid']")
	private WebElement LearnersID;
	@FindBy(xpath = "//input[@id='name']")
	private WebElement Name;
	@FindBy(xpath = "//select[@name='course']")
	private WebElement CourseDropdwnCheck;
	@FindBy(xpath = "//select[@name='project']")
	private WebElement Projectdropdown;
	@FindBy(xpath = "//select[@name='batch']")
	private WebElement Batchdropdown;
	@FindBy(xpath = "//select[@name='cstatus']")
	private WebElement CourseStatusdropdown;
	@FindBy(xpath = "//button[text()='Submit']")
	private WebElement SubmitButton;
	@FindBy(xpath = "//button[text()='Back to Dashboard']")
	private WebElement BacktoDashboard;
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement Okbutton;
	@FindBy(xpath = "//p[text()='Must contain letters,numbers and - only']")
	private WebElement Learneridblankmessage;
	@FindBy(xpath = "//p[text()='Must contain letters only']")
	private WebElement nameblankmessage;
	@FindBy(xpath = "//p[text()='Please select a course for the learner']")
	private WebElement courseblankmessage;
	@FindBy(xpath = "//p[text()='Please select a project for the learner']")
	private WebElement projectblankmessage;
	@FindBy(xpath = "//p[text()='Please select a batch for the learner']")
	private WebElement batchblankmessage;
	@FindBy(xpath = "//p[text()='Please select the course status of the learner']")
	private WebElement coursestatusblankmessage;
	@FindBy(xpath = "//button[@type='button' and contains(@class, 'btn-success')]/ion-icon[@name='cloud-upload']")
	private WebElement Uploadlearnerdetails;
	@FindBy(xpath = "//input[@type='file' and @name='file' and @accept='.csv']")
	private WebElement File;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement Submitcsv;

	@FindBy(xpath = "//button[@class='btn btn-success']")
	private WebElement EditDetails;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	private WebElement Deletedetails;
	@FindBy(xpath = "//button[text()='Return to Dashboard']")
	private WebElement Successuploadmessage;
	@FindBy(xpath = "//h2[text()='Data added successfully..!']")
	private WebElement Uploadmessageverify;
	@FindBy(xpath = "//button[text()='OK']")
	private WebElement Oksaved;
	@FindBy(xpath = "//button[@class='ui mini button' and text()='Cancel']")
	private WebElement Cancel;
	@FindBy(xpath="//td[text()='KKEM']")
	private WebElement editcourse;
	
	@FindBy(xpath = "//a[@id='basic-nav-dropdown']")
	private WebElement Logoutdropdown;
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement Logout;

	public TrainerControl(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void Validlogin(String user, String Pwd) {
		Username.clear();
		Password.clear();
		Username.sendKeys(user);
		Password.sendKeys(Pwd);
		LoginButton.click();
	}

	public void blankuser(String user, String Pwd) {

		Username.sendKeys(user);
		Password.sendKeys(Pwd);
		LoginButton.click();

	}

	public void blankpwd(String user, String Pwd) {
		Password.clear();
		Username.sendKeys(user);
		Password.sendKeys(Pwd);
		LoginButton.click();

	}

	public void blankcred(String user, String pwd) {
		driver.navigate().refresh();
		Username.clear();
		Password.clear();
		Username.sendKeys(user);
		// Password.sendKeys(Pwd);
		LoginButton.click();

	}

	public void invalidlogin(String user, String Pwd) {
		Username.clear();
		Password.clear();
		Username.sendKeys(user);
		Password.sendKeys(Pwd);
		LoginButton.click();

	}

	public String usererrormessage() {
		String ActualText = Usernameerrormessage.getText();
		return (ActualText);
	}

	public String pwderrormessage1() {

		String ActualText = Passworderrormessage.getText();
		return (ActualText);
	}

	public String blankerrormessage2() {

		String ActualText = loginerrormessage.getText();
		return (ActualText);

	}

	public String Invaliderrormessage() {

		String ActualText = invaliderrormessage.getText();
		return (ActualText);
	}

	public String Loginvalidation() {
		String ActualText = Dashboardvalid.getText();
		return (ActualText);
	}

	public void AddLearner() {
		Addbutton.click();
	}

	public String AddLearnervalidation() {
		String ActualText = Learnersform.getText();
		return (ActualText);
	}

	public void Addlearnwithallfields(String id, String name) {

		LearnersID.sendKeys(id);
		Name.sendKeys(name);
		Select dropDown = new Select(CourseDropdwnCheck);
		dropDown.selectByIndex(3);
		Select dropDown1 = new Select(Projectdropdown);
		dropDown1.selectByIndex(3);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Batchdropdown);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Batchdropdown);
		Select dropDown2 = new Select(Batchdropdown);
		dropDown2.selectByIndex(2);
		Select dropDown3 = new Select(CourseStatusdropdown);
		dropDown3.selectByIndex(1);
		SubmitButton.click();
		Okbutton.click();
	}

	public String postsuccessassertion() {
		String ActualText = successmessage.getText();
		return (ActualText);
	}

	public void Addlearnwithblankid(String id, String name) {

		Addbutton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(LearnersID)).click();
		LearnersID.sendKeys(id);
		Name.sendKeys(name);
		Select dropDown = new Select(CourseDropdwnCheck);
		dropDown.selectByIndex(3);
		Select dropDown1 = new Select(Projectdropdown);
		dropDown1.selectByIndex(3);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Batchdropdown);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Batchdropdown);
		Select dropDown2 = new Select(Batchdropdown);
		dropDown2.selectByIndex(2);
		Select dropDown3 = new Select(CourseStatusdropdown);
		dropDown3.selectByIndex(1);
		SubmitButton.click();

	}

	public String blankidmessage() {
		String ActualText = Learneridblankmessage.getText();
		return (ActualText);
	}

	public void Addlearnwithblankname(String id, String name) {
		BacktoDashboard.click();
		Addbutton.click();
		LearnersID.sendKeys(id);
		Name.sendKeys(name);
		Select dropDown = new Select(CourseDropdwnCheck);
		dropDown.selectByIndex(2);
		Select dropDown1 = new Select(Projectdropdown);
		dropDown1.selectByIndex(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Batchdropdown);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Batchdropdown);
		Select dropDown2 = new Select(Batchdropdown);
		dropDown2.selectByIndex(3);
		Select dropDown3 = new Select(CourseStatusdropdown);
		dropDown3.selectByIndex(1);
		SubmitButton.click();
	}

	public String blanknamemessage() {
		String ActualText = nameblankmessage.getText();
		return (ActualText);
	}

	public void Addlearnwithblankcourse(String id, String name) {
		BacktoDashboard.click();
		Addbutton.click();
		LearnersID.sendKeys(id);
		Name.sendKeys(name);
		Select dropDown = new Select(CourseDropdwnCheck);
		dropDown.selectByIndex(0);
		Select dropDown1 = new Select(Projectdropdown);
		dropDown1.selectByIndex(1);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Batchdropdown);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Batchdropdown);
		Select dropDown2 = new Select(Batchdropdown);
		dropDown2.selectByIndex(3);
		Select dropDown3 = new Select(CourseStatusdropdown);
		dropDown3.selectByIndex(1);
		SubmitButton.click();
	}

	public String blankcoursemessage() {
		String ActualText = courseblankmessage.getText();
		return (ActualText);
	}

	public void Addlearnwithblankproject(String id, String name) {
		BacktoDashboard.click();
		Addbutton.click();
		LearnersID.sendKeys(id);
		Name.sendKeys(name);
		Select dropDown = new Select(CourseDropdwnCheck);
		dropDown.selectByValue("ST");
		Select dropDown1 = new Select(Projectdropdown);
		dropDown1.selectByIndex(0);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Batchdropdown);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Batchdropdown);
		Select dropDown2 = new Select(Batchdropdown);
		dropDown2.selectByIndex(3);
		Select dropDown3 = new Select(CourseStatusdropdown);
		dropDown3.selectByIndex(1);
		SubmitButton.click();
	}

	public String blankprojectmessage() {
		String ActualText = projectblankmessage.getText();
		return (ActualText);
	}

	public void Addlearnwithblankbatch(String id, String name) {
		BacktoDashboard.click();
		Addbutton.click();
		LearnersID.sendKeys(id);
		Name.sendKeys(name);
		Select dropDown = new Select(CourseDropdwnCheck);
		dropDown.selectByValue("ST");
		Select dropDown1 = new Select(Projectdropdown);
		dropDown1.selectByIndex(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Batchdropdown);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Batchdropdown);
		Select dropDown2 = new Select(Batchdropdown);
		dropDown2.selectByIndex(0);
		Select dropDown3 = new Select(CourseStatusdropdown);
		dropDown3.selectByIndex(1);
		SubmitButton.click();
	}

	public String blankbatchmessage() {
		String ActualText = batchblankmessage.getText();
		return (ActualText);
	}

	public void Addlearnwithblankcoursestatusmessage(String id, String name) {
		BacktoDashboard.click();
		Addbutton.click();
		LearnersID.sendKeys(id);
		Name.sendKeys(name);
		Select dropDown = new Select(CourseDropdwnCheck);
		dropDown.selectByValue("ST");
		Select dropDown1 = new Select(Projectdropdown);
		dropDown1.selectByIndex(2);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Batchdropdown);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Batchdropdown);
		Select dropDown2 = new Select(Batchdropdown);
		dropDown2.selectByIndex(3);
		Select dropDown3 = new Select(CourseStatusdropdown);
		dropDown3.selectByIndex(0);
		SubmitButton.click();
	}

	public String blankcoursestatusmessage() {
		String ActualText = coursestatusblankmessage.getText();
		return (ActualText);
	}

	public void CoursesDropdowncheck() {
		BacktoDashboard.click();
		Addbutton.click();
		{
			{
				Select select = new Select(CourseDropdwnCheck);
				List<WebElement> options = select.getOptions();
				List<String> expectedOptions = Arrays.asList("FSD", "DSA", "ML-AI", "RPA", "ST", "CSA");
				for (String expectedOption : expectedOptions) {
					boolean found = false;
					for (WebElement option : options) {
						if (option.getText().equals(expectedOption)) 
						{
							found = true;
							break;
					}}
					Assert.assertTrue(found, "Option '" + expectedOption + "' not found in dropdown");
					System.out.println("Assertion Passed: Option '" + expectedOption + "' found in dropdown");
					
				}
			}
		}
	}

	public void ProjectDropdowncheck() {
		{
			Select select = new Select(Projectdropdown);
			List<WebElement> options = select.getOptions();
			List<String> expectedOptions = Arrays.asList("ICTAK", "KKEM", "NORKA", "ABCD", "KDISC");
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
		}

	}
	

	public void BatchDropdowncheck() {
		{
			Select select = new Select(Batchdropdown);
			List<WebElement> options = select.getOptions();
			List<String> expectedOptions = Arrays.asList("May_22", "Jun_22", "Jul_22", "Aug_22", "Dec_22", "Mar_23");
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
		}
	}

	public void CourseStatusDropdowncheck() {
		Select select = new Select(CourseStatusdropdown);
		List<WebElement> options = select.getOptions();
		List<String> expectedOptions = Arrays.asList("Qualified", "Incompetent");
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
	}

	public void Uploadcsv()
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", BacktoDashboard);
		Uploadlearnerdetails.click();
		File.sendKeys("C:\\Users\\ISHU\\Downloads\\SampleCSV - Sheet1.csv");
		Submitcsv.click();
	
	}

	public void acceptmessage() {
		Successuploadmessage.click();
		Oksaved.click();

	}

	public String uploadmessageassert() {
		
		String ActualText = Uploadmessageverify.getText();
		return (ActualText);

	}

	public void blankcsvupload() {
		Uploadlearnerdetails.click();
		Submitcsv.click();
	}

	public void cancelcsvupload() {
		Cancel.click();
		Uploadlearnerdetails.click();
		Cancel.click();
	}

	public String cancelassertion() {
		String Actualtext = Dashboardvalid.getText();
		return (Actualtext);

	}

	public void deletecsvupload() {

		
		Deletedetails.click();

	}

	public void editcsvupload() {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	       	wait.until(ExpectedConditions.elementToBeClickable(EditDetails)).click();
		Select select = new Select(Projectdropdown);
		select.selectByValue("KKEM");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", SubmitButton);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", SubmitButton);
		 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
	       	wait1.until(ExpectedConditions.elementToBeClickable(SubmitButton)).click();
		
	}
     public String editassertion()
    {
	String msgconfirm=editcourse.getText();
	return(msgconfirm);
     }
	public void Logout() {
		Logoutdropdown.click();
		Logout.click();
	}

	public String Logoutassertion() {
		String ActualText = Homepage.getText();
		return (ActualText);
	}
}
