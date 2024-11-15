package com.Framework.Automation_Framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Home extends Basepage {
	
	private WebDriver driver;

	public Home(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//p[contains(@class,'oxd-userdropdown-name')]")
	private WebElement clickUserName;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement clickLogout;
	
	
	public Home verifyingTitle(String title) {
    	String expected=driver.getTitle();
    	Assert.assertEquals(expected, title);
    	
    	return this;
	}
	
	public Home clickUserName() {
		clickUserName.click();
		return this;
	}
	public Login clickLogoutButton() {
		clickLogout.click();
		return new Login(driver);

	}
	public Admin clickAdmin() {
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		return new Admin(driver);
	}
}
