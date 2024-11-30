package com.Framework.Automation_Framework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Login extends Basepage {

	
	 private WebDriver driver;
	  
		public static Logger logfile = LogManager.getLogger(Login.class.getName());

	  public Login(WebDriver driver) {
		  this.driver = driver;
	  PageFactory.initElements(driver, this); 
	  }
	 

	@FindBy(xpath = "//input[@name='username']")
	private WebElement username;

	@FindBy(css = "input[name='password']")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	public Login enterUserName(String uName) {
		try {
			username.sendKeys(uName);
			reportStep("Username entered successfully ", "pass");
		} catch (Exception e) {
			reportStep("Username not entered successfully ", "fail");
		}
		return this;
	}

	public Login enterPassword(String pWord) {
		try {
			password.sendKeys(pWord);
			reportStep("Password entered successfully ", "pass");
		} catch (Exception e) {
			reportStep("Password not entered successfully ", "fail");
		}
		return this;
	}

	public Home clickLoginButton() {
		try {
			loginButton.click();
			reportStep("login button clicked successfully ", "pass");

		} catch (Exception e) {
			reportStep("login button not clicked successfully ", "fail");
		}
		return new Home(driver);
	}

}
