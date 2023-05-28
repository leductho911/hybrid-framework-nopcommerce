
package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_Cookie extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String firstName, lastName, validPassword, email;
	public static Set<Cookie> loggedCookies;
	
	
		
	@Parameters({ "browser", "url" })
	@BeforeTest(description = "Create new common user for all Class Test")
	public void User_01_Register(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		validPassword = "123456";
		email = "leductho" + randomNumber() + "@gmail.com";
		
		log.info("Pre-condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Pre-condition - Step 02: Enter to Firstname textbox with value: " + firstName);
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Pre-condition - Step 03: Enter to Lastname textbox with value: " + lastName);
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Pre-condition - Step 04: Enter to Email textbox with value: " + email);
		registerPage.inputToEmailTextbox(email);

		log.info("Pre-condition - Step 05: Enter to Password textbox with value: " + validPassword);
		registerPage.inputToPasswordTextbox(validPassword);

		log.info("Pre-condition - Step 06: Enter to Confirm Password textbox with value: " + validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		log.info("Pre-condition - Step 07: Click to 'Register' Button");
		registerPage.clickToRegisterButton();

		log.info("Pre-condition - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getSuccessMessageAtRegisterPage(), "Your registration completed");

		log.info("Pre-condition - Step 09: Click to 'Continue' Button");
		homePage = registerPage.clickToContinueButton();
		
		log.info("Pre-condition - Step 10: Navigate to 'Login' page");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-condition - Step 11: Enter email to textbox: " + email);
		loginPage.inputToEmailTextbox(email);

		log.info("Pre-condition - Step 12: Enter password to textbox" + validPassword);
		loginPage.inputToPasswordTextbox(validPassword);

		log.info("Pre-condition - Step 13: Click to 'Login' Button");
		homePage = loginPage.clickToLoginButton();
		
		homePage.sleepInSecond(3);
		
		loggedCookies = homePage.getAllCookies(driver);
		
		driver.quit();
	}

		
}
