package com.Framework.Automation_Framework;




import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;

import utils.ReadExcelData;



public class BasicOrangeHrm extends Basepage {
	
	@BeforeTest
	public void setValue() {
		System.out.println("before test");
		excelFileName="Login";
		testName="Basic orangeHrm";
		testDescription="Verifying orangehrm with mandatory details";
		testAuthor="Guru";

		
	}

   
	@Test(dataProvider = "fetchData")
    public void LoginOrangeHrm(String uName,String pWord, String title ) {
		
    	Login lp= new Login(driver);
     
    	  lp.enterUserName(uName)
    	  .enterPassword(pWord)
    	  .clickLoginButton()
    	  .verifyingTitle(title)
    	  .clickUserName()
    	  .clickLogoutButton();
    	 
    	
    }
    
     	
    
}
