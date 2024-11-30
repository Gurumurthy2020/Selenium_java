package com.Framework.Automation_Framework;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AdminTest extends Basepage {
	
	@BeforeTest
	public void setValue() {
		excelFileName="login";
		testName="Admin Test";
		testDescription="Verifying orangehrm with Admin Test details";
		testAuthor="Guru";
	}

	
	@Test(dataProvider = "fetchData")
	public void AdminVerification(String uName,String pWord, String title) {
		Login lp = new Login(driver);
		lp.enterUserName(uName)
		.enterPassword(pWord)
		.clickLoginButton()
		.verifyingTitle(title)
		.clickAdmin()
		.verifyAdminTab()
		.enterUsername()
		.verifyingUsername();
	}

}
