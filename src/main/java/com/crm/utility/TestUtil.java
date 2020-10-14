package com.crm.utility;

import com.crm.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT = 15;
	public static long IMPLICIT_WAIT = 10;
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}
	
}
