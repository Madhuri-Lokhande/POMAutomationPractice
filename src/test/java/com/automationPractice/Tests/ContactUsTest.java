package com.automationPractice.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BaseClass.TestClass;
import com.automationPractice.Pages.ContactUsPage;
import com.automationPractice.Pages.LoginPage;
import com.automationPractice.Pages.MyAccountPage;

public class ContactUsTest extends TestClass {

	MyAccountPage accountpage;
	LoginPage loginpage;
	ContactUsPage contactu;

	public ContactUsTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		InitialSetup();
		accountpage = new MyAccountPage();
		loginpage = new LoginPage();
		contactu=new ContactUsPage();
		loginpage.navigateToLoginPage();
		accountpage = loginpage.loginWithUsernameAndPassword("madhuri1234test@gmail.com", "Automation1234");
		contactu = accountpage.contactUsClick();
	}

	@Test(priority = 0)
	public void verifyTitleContactUs() {
		Assert.assertEquals(contactu.contactUsTitle(), "Contact us - My Store");
	}

	@Test(priority = 1)
	public void verifyContactUsNav() {
		Assert.assertTrue(contactu.isContactUsNavisDisplayed());
	}

	@Test(priority = 2)
	public void verifySubjectHeading() {
		Assert.assertEquals(contactu.selectSubjectHead(),"Customer service");
		System.out.println("Selected Subject Heading: "+contactu.selectSubjectHead());
	}
	
	@Test(priority = 3)
	public void verifyAddedMsg() throws InterruptedException {
		System.out.println("Message: "+contactu.addMessage());
	}
	
	@Test(priority = 4)
	public void verifyFileUpload() throws IOException, InterruptedException {
		Assert.assertEquals(contactu.fileUpload(), "Automate.docx");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
