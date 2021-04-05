package com.automationPractice.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationPractice.BaseClass.TestClass;

public class LoginPage extends TestClass {

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	WebElement signInBtn;

	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo;

	@FindBy(id = "search_query_top")
	WebElement searchField;

	@FindBy(xpath = "//b[contains(text(),'Cart')]")
	WebElement cart;

	@FindBy(css = "#contact-link > a")
	WebElement contactUs;

	@FindBy(css = "#SubmitCreate > span")
	WebElement createNewAcc;

	@FindBy(id = "email")
	WebElement emailField;

	@FindBy(id = "passwd")
	WebElement passwdField;

	@FindBy(id = "SubmitLogin")
	WebElement loginBtn;

	@FindBy(css = "#login_form > div > p.lost_password.form-group > a")
	WebElement forgotPwd;

	@FindBy(xpath = "//p[contains(text(),'There is 1 error')]")
	WebElement errorMsg;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public void navigateToLoginPage() {
		signInBtn.click();
	}

	public String Title() {
		return driver.getTitle();
	}

	public String getURL() {
		return driver.getCurrentUrl();
	}

	public boolean checkLogo() {
		return logo.isDisplayed();
	}

	public boolean isCartDisplayed() {
		return cart.isDisplayed();
	}

	public boolean isSearchFieldDisplayed() {
		return searchField.isDisplayed();
	}

	public boolean isContactUsDisplayed() {
		return contactUs.isDisplayed();
	}

	public boolean isEmailFieldDisplayed() {
		return emailField.isDisplayed();
	}

	public boolean isPasswordFieldDisplayed() {
		return passwdField.isDisplayed();
	}

	public boolean isSignInBtnDisplayed() {
		return loginBtn.isDisplayed();
	}

	public boolean isFogotPwdLinkDisplayed() {
		return forgotPwd.isDisplayed();
	}

	public MyAccountPage loginWithUsernameAndPassword(String uName, String pass) {
		emailField.sendKeys(uName);
		passwdField.sendKeys(pass);
		loginBtn.click();
		return new MyAccountPage();
	}

	public String getAccountPageURL() {
		return driver.getCurrentUrl();
	}

	public String InvalidCredentialErrorMsg() {
		return errorMsg.getText();
	}

}
