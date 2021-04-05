package com.automationPractice.Tests;

import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BaseClass.TestClass;
import com.automationPractice.Pages.LoginPage;
import com.automationPractice.Pages.MyAccountPage;
import com.automationPractice.Pages.MyAddressPage;

public class MyAddressTest extends TestClass {

	MyAccountPage accountpage;
	LoginPage loginpage;
	MyAddressPage myaddrs;
	
	public MyAddressTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		InitialSetup();
		accountpage = new MyAccountPage();
		loginpage = new LoginPage();
		loginpage.navigateToLoginPage();
		myaddrs=new MyAddressPage();
		accountpage = loginpage.loginWithUsernameAndPassword("madhuri1234test@gmail.com", "Automation1234");
		myaddrs=accountpage.myAddressClick();
	}
	
	@Test(priority = 0)
	public void verifyTitle() {
		Assert.assertEquals(myaddrs.getTitle1(), "Addresses - My Store");
		System.out.println("Title of My address Page is: "+myaddrs.getTitle1());
	}
	
	@Test(priority = 1)
	public void verifyURL()  {
		Assert.assertEquals(myaddrs.getPageUrl(),"http://automationpractice.com/index.php?controller=addresses");
		System.out.println("URL of My Address is: "+myaddrs.getPageUrl());
	}
	
	@Ignore
	public void checkMyAddressasd() {
	//Assert.assertTrue(myaddrs.addNewAddressButton());
		//Assert.assertEquals(myaddrs.addNewAddressButton(),"My addressasd");
		System.out.println("My Addressasd button is present: "+myaddrs.addNewAddressButton());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
