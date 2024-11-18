package com.Framework.Automation_Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login extends Basepage {

	
	 private WebDriver driver;
	  
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
		username.sendKeys(uName);
		return this;
	}

	public Login enterPassword(String pWord) {
		password.sendKeys(pWord);
		return this;
	}

	public Home clickLoginButton() {
		loginButton.click();
		return new Home(driver);
	}

}
