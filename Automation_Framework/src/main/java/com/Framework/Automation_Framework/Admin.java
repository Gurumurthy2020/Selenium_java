package com.Framework.Automation_Framework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Admin extends Basepage {

	private WebDriver driver;
	
	public Admin(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(xpath="//h6[text()='Admin']")
	WebElement adminTitle;
	
	@FindBy(xpath="//label[text()='Username']//following::input[contains(@class,'oxd-input--active')]")
	WebElement enteringUsername;
	
	@FindBy(xpath="//button[text()=' Search ']")
	WebElement clickSearchButton;
	
	
	public Admin verifyAdminTab() {
		boolean actual=adminTitle.isDisplayed();
		if (actual) {
			System.out.println("we are in admin page");
		} else {
			System.out.println("we are not in admin page");
		}
		
		return this;
	}
	
	public Admin enterUsername() {
		enteringUsername.sendKeys("Sai Karthikeya Rachamalla");
		clickSearchButton.click();
		
		return this;
	}
	
	public Admin verifyingUsername() {
		
		try {
			List<WebElement> values=driver.findElements(By.xpath("//div[contains(@class,'oxd-table-row oxd-table-row--with-border')]//div//div"));
			boolean result=driver.findElement(By.xpath("//*[contains(text(),'Sai Karthikeya Rachamalla')]")).isDisplayed();
			if (result) {
				System.out.println("Name is displayed in result");
			} else {
				System.out.println("Name is not displayed in result");

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("an error occured:"+e.getMessage());

		}
		
		return this;
	}
	
}
