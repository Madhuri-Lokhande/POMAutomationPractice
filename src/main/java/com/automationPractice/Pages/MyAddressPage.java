package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationPractice.BaseClass.TestClass;

public class MyAddressPage extends TestClass{

	@FindBy(xpath="//*[@id=\"center_column\"]/div[1]/div/div/ul/li[1]/h3")
	WebElement myaddressasd;
	
	
	public String getTitle1() {
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean addNewAddressButton() {
		return myaddressasd.isDisplayed();
	}
	
	
}
