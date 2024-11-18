package com.Framework.Automation_Framework;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcelData;

/**
 * Hello world!
 */
public class Basepage {

	public WebDriver driver;
	public Login lp;
	public Home hp;
	public Admin ap;
	public String excelFileName;

	@DataProvider(name = "fetchData")
	public String[][] fetchData() throws IOException {
		return ReadExcelData.readData(excelFileName);	
	}

	@BeforeMethod
	public void webdriverCreation() {
		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		implicitwait(20);

	}

	@AfterMethod
	public void quit() {
		driver.quit();
	}

	public void url(String url) {
		driver.get(url);
	}

	public void click(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void sendKeys(String username, String value) {
		driver.findElement(By.xpath(username)).sendKeys(value);
	}

	public void sendKeysCss(String css, String value) {
		driver.findElement(By.cssSelector(css)).sendKeys(value);
	}

	public void implicitwait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	public void explicitwait(int seconds, String value) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
	}

}
