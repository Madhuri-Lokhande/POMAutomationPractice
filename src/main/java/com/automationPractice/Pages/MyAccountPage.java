package com.automationPractice.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BaseClass.TestClass;

public class MyAccountPage extends TestClass {

	@FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")
	WebElement loggedInUserName;

	@FindBy(xpath = "//h1[contains(text(),'My account')]")
	WebElement myAccount;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[1]/a")
	WebElement womenLink;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
	WebElement dressesLink;

	@FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[3]/a")
	WebElement tshirtLink;
	
	@FindBy(xpath="//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li[1]/a")
	WebElement casualDressLink;
	
	@FindBy(xpath="//span[contains(text(),'My addresses')]")
	WebElement myAdressLink;
	
	@FindBy(xpath="//*[@id=\"contact-link\"]/a")
	WebElement contactUs;
	
	private By accountHeaders=By.xpath("//*[@id=\"center_column\"]/div/div/ul/li/a/span");
	private By womenTopsList1 = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[1]/ul/li/a");
	private By womenDressesList1 = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/ul/li[2]/ul/li/a");
	

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public String getAccountPageTitle() {
		return driver.getTitle();
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String loginUserName() {
		return loggedInUserName.getText();
	}

	public boolean isMyAccountDisplayed() {
		return myAccount.isDisplayed();
	}

	public boolean isWomenLinkDisplayed() {
		return womenLink.isDisplayed();
	}

	public boolean isDressesLinkDisplayed() {
		return dressesLink.isDisplayed();
	}

	public boolean isTShirtLinkDisplayed() {
		return tshirtLink.isDisplayed();
	}

	public String womenToolTip() {
		return womenLink.getAttribute("title");
	}
	
	public int womenTopCount() {
		List<WebElement> topscount = driver.findElements(womenTopsList1);
		return topscount.size();
	}
	
	public int womenDressCount() {
		List<WebElement> dressCount = driver.findElements(womenDressesList1);
		return dressCount.size();
	}

	public String dressesToolTip() {
		return dressesLink.getAttribute("title");
	}

	public String tshitToolTip() {
		return tshirtLink.getAttribute("title");
	}

	public List<String> getListofTopsContentfromWomen() throws InterruptedException {

		Actions act = new Actions(driver);
		act.moveToElement(womenLink).build().perform();
		Thread.sleep(2000);
		List<WebElement> tops = driver.findElements(womenTopsList1);
		List<String> arrayList = new ArrayList<String>();

		for (WebElement topsList : tops) {
			arrayList.add(topsList.getText());
		}
		return arrayList;
	}

	public List<String> getListofDressesContentfromWomen() throws InterruptedException {

		Actions act = new Actions(driver);
		act.moveToElement(womenLink).build().perform();
		Thread.sleep(2000);
		List<WebElement> tops = driver.findElements(womenDressesList1);
		List<String> arrayList = new ArrayList<String>();

		for (WebElement topsList : tops) {
			arrayList.add(topsList.getText());
		}
		return arrayList;
	}
	
	public void clickCasualDressInWomen() throws InterruptedException {
		Actions act = new Actions(driver);
		act.moveToElement(womenLink).build().perform();
		Thread.sleep(2000);
		
		casualDressLink.click();
	}
	
	public List<String> accountContents() {
		List<WebElement> accountsHeaderList=driver.findElements(accountHeaders);
		List<String> HeadersList = new ArrayList<String>();
		
		for (WebElement headers : accountsHeaderList) {
			HeadersList.add(headers.getText());
		}
		return HeadersList;
	}
	
	public MyAddressPage myAddressClick() {
		myAdressLink.click();
		return new MyAddressPage();
	}
	
	public ContactUsPage contactUsClick() {
		contactUs.click();
		return new ContactUsPage();
	}
	
}
