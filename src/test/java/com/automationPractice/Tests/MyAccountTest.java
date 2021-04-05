package com.automationPractice.Tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.automationPractice.BaseClass.TestClass;
import com.automationPractice.Pages.ContactUsPage;
import com.automationPractice.Pages.LoginPage;
import com.automationPractice.Pages.MyAccountPage;
import com.automationPractice.Pages.MyAddressPage;

public class MyAccountTest extends TestClass {

	MyAccountPage accountpage;
	LoginPage loginpage;
	MyAddressPage myaddrs;
	ContactUsPage contactu;

	public MyAccountTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		InitialSetup();
		accountpage = new MyAccountPage();
		loginpage = new LoginPage();
		loginpage.navigateToLoginPage();
		accountpage = loginpage.loginWithUsernameAndPassword("madhuri1234test@gmail.com", "Automation1234");
	}

	@Test(priority = 0)
	public void CheckUserName() {
		Assert.assertEquals(accountpage.getAccountPageTitle(), "My account - My Store");
		Assert.assertTrue(accountpage.isMyAccountDisplayed());
		String loggedInUserName = accountpage.loginUserName();
		System.out.println("Logged In User Name is: " + loggedInUserName);
	}

	@Test(priority = 1)
	public void CheckPresentTags() {
		Assert.assertTrue(accountpage.isDressesLinkDisplayed());
		Assert.assertTrue(accountpage.isTShirtLinkDisplayed());
		Assert.assertTrue(accountpage.isWomenLinkDisplayed());
	}

	@Test(priority = 3)
	public void CheckToolTipTags() {
		Assert.assertEquals(accountpage.womenToolTip(), "Women");
		System.out.println("Womens Tag tool tip is: " + accountpage.womenToolTip());

		Assert.assertEquals(accountpage.dressesToolTip(), "Dresses");
		System.out.println("Womens Tag tool tip is: " + accountpage.dressesToolTip());

		Assert.assertEquals(accountpage.tshitToolTip(), "T-shirts");
		System.out.println("Womens Tag tool tip is: " + accountpage.tshitToolTip());
	}

	@Test(priority = 4)
	public void printWomensTopsCategory() throws InterruptedException {

		Assert.assertEquals(accountpage.womenTopCount(), 2);
		Assert.assertEquals(accountpage.womenDressCount(), 3);

		List<String> topList = accountpage.getListofTopsContentfromWomen();
		List<String> DressesList = accountpage.getListofDressesContentfromWomen();

		System.out.println("Number of items in tops category: " + accountpage.womenTopCount());
		System.out.println("Number of items in Dress category: " + accountpage.womenDressCount());
		System.out.println("Tops Contents: " + topList);
		System.out.println("Dresses Contents: " + DressesList);
	}

	@Test(priority = 2)
	public void printAccountHeaders() {
		List<String> accHeaders = accountpage.accountContents();
		System.out.println("Account Headers List: " + accHeaders);
	}

	@Test(priority = 5)
	public void casualDressWomen() throws InterruptedException {
		String expectedUrl = "http://automationpractice.com/index.php?id_category=9&controller=category";
		accountpage.clickCasualDressInWomen();
		Assert.assertEquals(expectedUrl, accountpage.getCurrentUrl());
		System.out.println("URL of Casual dress Page is: " + accountpage.getCurrentUrl());
	}
	
	@Test(priority = 6)
	public void clickMyAddress() {
		myaddrs=accountpage.myAddressClick();
		Assert.assertEquals(myaddrs.getPageUrl(),"http://automationpractice.com/index.php?controller=addresses");
		System.out.println("URL of My Address Page is: "+myaddrs.getPageUrl());
	}

	@Test(priority = 7)
	public void clickContactUs() {
		contactu=accountpage.contactUsClick();
		Assert.assertEquals(contactu.contactUsUrl(),"http://automationpractice.com/index.php?controller=contact");
		System.out.println("URL of Contact Us Page is: "+myaddrs.getPageUrl());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
