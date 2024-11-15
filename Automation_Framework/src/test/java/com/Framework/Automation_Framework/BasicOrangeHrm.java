package com.Framework.Automation_Framework;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class BasicOrangeHrm extends Basepage {

   
    @org.testng.annotations.Test
    public void LoginOrangeHrm() {
    	
    	Login lp= new Login(driver);
     
    	  lp.enterUserName()
    	  .enterPassword()
    	  .clickLoginButton()
    	  .verifyingTitle("OrangeHRM")
    	  .clickUserName()
    	  .clickLogoutButton();
    	 
    	
    }
    
     	
    
}
