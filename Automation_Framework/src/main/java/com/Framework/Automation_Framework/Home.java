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
    	try {
			String expected=driver.getTitle();
			Assert.assertEquals(expected, title);
			reportStep("Page title verified successfully ", "pass");
		} catch (Exception e) {
			reportStep("Page title not matching ", "fail");
		}

    	return this;
	}
	
	public Home clickUserName() {
		try {
			clickUserName.click();
			reportStep("username clicked successfully ", "pass");
		} catch (Exception e) {
			reportStep("username not clicked successfully ", "fail");
		}
		return this;
	}
	public Login clickLogoutButton() {
		try {
			clickLogout.click();
			reportStep("Logout clciked successfully ", "pass");
		} catch (Exception e) {
			reportStep("Logout clciked not successfully ", "fail");
		}
		return new Login(driver);

	}
	public Admin clickAdmin() {
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		return new Admin(driver);
	}
}
