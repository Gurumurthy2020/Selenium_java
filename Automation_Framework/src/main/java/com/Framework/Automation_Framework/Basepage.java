package com.Framework.Automation_Framework;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

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
	
	public static ExtentReports extent;
	public static ExtentTest test;
	public String testName,testDescription,testAuthor;
	
	public static Logger logfile = LogManager.getLogger(Basepage.class.getName());
	
	
	@BeforeSuite
	public void startReport() {
		extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target\\extentreports.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		extent.attachReporter(spark);
	}
	
	@BeforeClass
	public void testDetails() {
		test = extent.createTest(testName);
		test.assignAuthor(testAuthor);
		test.assignCategory(testDescription);
		
	}
	
	public void reportStep(String stepinfo, String status ) {		
		if (status.equalsIgnoreCase("pass")) {
			test.pass(stepinfo);
		}else if (status.equalsIgnoreCase("fail")) {
			test.fail(stepinfo);
			throw new RuntimeException("See extend report for more details");	
		}
	}

	@DataProvider(name = "fetchData")
	public String[][] fetchData() throws IOException {
		return ReadExcelData.readData(excelFileName);
	}

	@BeforeMethod
	public void webdriverCreation() {
		System.out.println("before method");

		driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		implicitwait(20);
		logfile.info("url entered successfully");

	}


	@AfterMethod
	public void quit() {
		driver.quit();
	}
	
	@AfterSuite
	public void teardown() {
		extent.flush();
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
