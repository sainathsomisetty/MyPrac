package com.crm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.pages.ContactsPage;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.utility.TestUtil;

public class HomePageTest extends HomePage{
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil utility;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		String title = homepage.verifyHomePage();
		Assert.assertEquals(title, "CRMPRO", "Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameLabel() {
		utility.switchToFrame();
		Assert.assertTrue(homepage.verifyUserName());
	}
	
	@Test(dependsOnMethods = {"verifyHomePageTitle"})
	public void verifyContacts() {
		utility.switchToFrame();
		contactspage =  homepage.clickOnContactsLink();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
