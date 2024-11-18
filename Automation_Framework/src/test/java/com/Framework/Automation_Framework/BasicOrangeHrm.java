package com.Framework.Automation_Framework;




import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.ReadExcelData;



public class BasicOrangeHrm extends Basepage {
	
	@BeforeTest
	public void setValue() {
		System.out.println("before test");
		excelFileName="Login";
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
