package com.automationPractice.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.automationPractice.BaseClass.TestClass;

public class ContactUsPage extends TestClass {

	@FindBy(xpath = "//*[@id=\"columns\"]/div[1]/span[2]")
	WebElement contactUsNav;

	@FindBy(id = "id_contact")
	WebElement subjectSelector;

	@FindBy(id = "message")
	WebElement message;

	@FindBy(id = "fileUpload")
	WebElement attachFile;
	
	@FindBy(xpath="//span[@class='filename']")
	WebElement choosenFileName;

	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String contactUsTitle() {
		return driver.getTitle();
	}
	
	public String contactUsUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isContactUsNavisDisplayed() {
		return contactUsNav.isDisplayed();
	}
	
	public String selectSubjectHead() {
		Select select=new Select(subjectSelector);
		select.selectByVisibleText("Customer service");
		return select.getFirstSelectedOption().getText();
	}
	
	public String addMessage() throws InterruptedException {
		message.sendKeys("Loreum Ipsum");
		Thread.sleep(2000);
		return message.getAttribute("value");
	}
	
	public String fileUpload() throws IOException, InterruptedException {
		Actions builder = new Actions(driver);

		builder.moveToElement(attachFile).click().build().perform();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("D:\\Software Testing Hands On\\AutoIt\\AutomationPracticeFileUpload.exe");
		Thread.sleep(2000);
		return choosenFileName.getText();
	}
	
	
}
