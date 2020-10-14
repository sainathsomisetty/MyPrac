package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(), 'User: Demo User')]")
	WebElement usrName;
	
	@FindBy(linkText="Tasks")
	WebElement tasks;
	
	@FindBy(xpath="//a[text()='Contacts']")
	WebElement contacts;
	
	@FindBy(linkText="Cases")
	WebElement Cases;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePage() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName() {
		return usrName.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		contacts.click();
		return new ContactsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasks.click();
		return new TasksPage();
	}
	
}
