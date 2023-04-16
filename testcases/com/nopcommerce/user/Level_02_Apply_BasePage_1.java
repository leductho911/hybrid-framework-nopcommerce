// Framework 04 - Apply BasePage/ NopCommerce Checklist Business
// Note : @BeforeClass and AfterClass khong xu ly trong bai nay https://youtu.be/F-3M9oLKEXE?t=582

package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
//comment4
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_BasePage_1 {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;
	BasePage basePage;
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();

		basePage = new BasePage();

		jsExecutor = (JavascriptExecutor) driver;
		emailAddress = "leductho" + randomNumber() + "@gmail.com";

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

	}

	@Test
	public void TC_01_Register_Empty_Data() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		// driver.findElement(By.cssSelector("a.ico-register")).click();

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");
		// driver.findElement(By.cssSelector("button#register-button")).click();

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"),
				"First name is required.");
		// Assert.assertEquals(driver.findElement(By.cssSelector("#FirstName-error")).getText(),
		// "First name is required.");

	}

	@Test
	public void TC_02_Register_Invalid_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendKeysToElement(driver, "//input[@id='Email']", "dsaf4gmail.com");
		// driver.findElement(By.cssSelector("input#Email")).sendKeys("dsaf4gmail.com");

		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
		// Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(),
		// "Wrong email");

	}

	@Test
	public void TC_03_Register_Success() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendKeysToElement(driver, "//input[@id='LastName']", "FC");
		basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendKeysToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		basePage.clickToElement(driver, "//input[@id='gender-male']");

		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");

	}

	@Test
	public void TC_04_Register_Exiting_Email() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
		basePage.sendKeysToElement(driver, "//input[@id='LastName']", "FC");
		basePage.sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
		basePage.sendKeysToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		basePage.clickToElement(driver, "//input[@id='gender-male']");

		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertTrue(
				basePage.isElementDisplayed(driver, "//li[normalize-space()='The specified email already exists']"));

	}

	@Test
	public void TC_05_Register_Password_Less_Than_6_Chars() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");

		basePage.sendKeysToElement(driver, "//input[@id='Password']", "12345");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"),
				"Password must meet the following rules:\nmust have at least 6 characters");

		// Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),
		// "Password must meet the following rules:\nmust have at least 6 characters");
	}

	@Test
	public void TC_06_Register_Invalid_Confirm_Password() {
		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
		basePage.clickToElement(driver, "//a[@class='ico-register']");
		basePage.sendKeysToElement(driver, "//input[@id='Password']", "123456");
		basePage.sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "1234567");
		basePage.clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"),
				"The password and confirmation password do not match.");

		// Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
		// "The password and confirmation password do not match.");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}

}
