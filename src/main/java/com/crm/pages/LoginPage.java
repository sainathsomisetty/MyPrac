package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or Object reporsitory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginButton;

	@FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
	WebElement signup;
	
	@FindBy(xpath = "//img[contains(class, 'img-responsive']")
	WebElement crmLogo;
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPage() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String urname, String passwrd) {
		username.sendKeys(urname);
		password.sendKeys(passwrd);
		loginButton.click();
		
		return new HomePage();
		
	}
}
