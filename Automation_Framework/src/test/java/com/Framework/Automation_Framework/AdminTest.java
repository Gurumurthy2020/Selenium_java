package com.Framework.Automation_Framework;

import org.testng.annotations.Test;

public class AdminTest extends Basepage {
	
	@Test
	public void AdminVerification() {
		Login lp = new Login(driver);
		lp.enterUserName()
		.enterPassword()
		.clickLoginButton()
		.verifyingTitle("OrangeHRM")
		.clickAdmin()
		.verifyAdminTab()
		.enterUsername()
		.verifyingUsername();
	}

}
