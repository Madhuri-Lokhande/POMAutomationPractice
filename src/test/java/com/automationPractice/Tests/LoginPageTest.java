package com.automationPractice.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BaseClass.TestClass;
import com.automationPractice.Pages.LoginPage;
import com.automationPractice.Pages.MyAccountPage;

public class LoginPageTest extends TestClass {

	LoginPage loginpage; 
	MyAccountPage myaccPage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		InitialSetup();
		loginpage=new LoginPage();
		loginpage.navigateToLoginPage();
	}
	
	
	@Test(priority = 0)
	public void isLoginPageDisplayedCorrectly() {
		Assert.assertEquals(loginpage.getURL(), "http://automationpractice.com/index.php?controller=authentication&back=my-account");
		Assert.assertEquals(loginpage.Title(), "Login - My Store");
		Assert.assertTrue(loginpage.checkLogo()); 
		Assert.assertTrue(loginpage.isCartDisplayed());
		Assert.assertTrue(loginpage.isContactUsDisplayed()); 
		Assert.assertTrue(loginpage.isSearchFieldDisplayed()); 
		Assert.assertTrue(loginpage.isSignInBtnDisplayed());
		Assert.assertTrue(loginpage.isEmailFieldDisplayed()); 
		Assert.assertTrue(loginpage.isFogotPwdLinkDisplayed()); 
		Assert.assertTrue(loginpage.isFogotPwdLinkDisplayed()); 
	}
	
	@Test(priority = 1)
	public void AttemptToLoginWithValidUserNameAndPassword() {
		myaccPage=loginpage.loginWithUsernameAndPassword("madhuri1234test@gmail.com","Automation1234");
		Assert.assertEquals(loginpage.getAccountPageURL(),"http://automationpractice.com/index.php?controller=my-account");
	}
	
	@Test(priority = 2)
	public void AttemptToLoginWithInvalidPassword() {
		loginpage.loginWithUsernameAndPassword("madhuri1234test@gmail.com","Automation123");
		String actualErrMsg=loginpage.InvalidCredentialErrorMsg();
		Assert.assertEquals(actualErrMsg,"There is 1 error");
		Assert.assertNotEquals(loginpage.getAccountPageURL(),"http://automationpractice.com/index.php?controller=my-account");
	}
	
	@Test(priority = 3)
	public void AttemptToLoginWithInvalidUsername() {
		loginpage.loginWithUsernameAndPassword("madhuri12test@gmail.com","Automation1234");
		String actualErrMsg=loginpage.InvalidCredentialErrorMsg();
		Assert.assertEquals(actualErrMsg,"There is 1 error");
		Assert.assertEquals(loginpage.getURL(),"http://automationpractice.com/index.php?controller=authentication");
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
