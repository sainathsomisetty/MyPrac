package com.crm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.base.TestBase;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginpage.validateLoginPage();
		Assert.assertEquals(title, "CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest() {
		boolean flag = loginpage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
