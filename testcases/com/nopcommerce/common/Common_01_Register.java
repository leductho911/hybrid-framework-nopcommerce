// * Framework 05 - Page Object Pattern - Part I 

package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String firstName, lastName;
	public static String validPassword, email;
	
	
		
	@Parameters({ "browser", "url" })
	@BeforeTest(description = "Create new common user for all Class Test")
	public void User_01_Register(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		validPassword = "123456";
		email = "leductho" + randomNumber() + "@gmail.com";
		
		log.info("Pre-Condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Pre-Condition - Step 02: Enter to Firstname textbox with value: " + firstName);
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Pre-Condition - Step 03: Enter to Lastname textbox with value: " + lastName);
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Pre-Condition - Step 04: Enter to Email textbox with value: " + email);
		registerPage.inputToEmailTextbox(email);

		log.info("Pre-Condition - Step 05: Enter to Password textbox with value: " + validPassword);
		registerPage.inputToPasswordTextbox(validPassword);

		log.info("Pre-Condition - Step 06: Enter to Confirm Password textbox with value: " + validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		log.info("Register - Step 07: Click to 'Register' Button");
		registerPage.clickToRegisterButton();

		log.info("Pre-Condition - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getSuccessMessageAtRegisterPage(), "Your registration completed");

		log.info("Pre-Condition - Step 09: Click to 'Continue' Button");
		homePage = registerPage.clickToContinueButton();
		
		driver.quit();
	}	

}
