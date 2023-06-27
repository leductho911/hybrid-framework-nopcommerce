package com.nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.testdata.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import ultilities.Environment;

public class Level_22_Multiple_Environment_Owner extends BaseTest {

	Environment environment;
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject userCustomerInforPage;
	private UserDataMapper userData;

	private String firstName, lastName, validPassword, email, dateOfBirth, monthOfBirth, yearOfBirth;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String environmentName) {

		ConfigFactory.setProperty("env", environmentName);
		environment = ConfigFactory.create(Environment.class);
		driver = getBrowserDriver(browserName, environment.appUrl());

		homePage = PageGeneratorManager.getUserHomePage(driver);

		userData = UserDataMapper.getUserData("UserData.json");
		firstName = userData.getFirstName();
		lastName = userData.getLastName();
		validPassword = userData.getValidPassword();
		email = userData.getEmail();
		dateOfBirth = userData.getDate();
		monthOfBirth = userData.getMonth();
		yearOfBirth = userData.getYear();
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 02: Enter to Firstname textbox with value: " + firstName);
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register - Step 03: Enter to Lastname textbox with value: " + lastName);
		registerPage.inputToTextboxByID(driver, "LastName", firstName);

		log.info("Register - Step 04: Select date of birth");
		registerPage.selectToDropdownByName(driver, "DateOfBirthDay", dateOfBirth);
		registerPage.selectToDropdownByName(driver, "DateOfBirthMonth", monthOfBirth);
		registerPage.selectToDropdownByName(driver, "DateOfBirthYear", yearOfBirth);

		log.info("Register - Step 05: Enter to Email textbox with value: " + email);
		registerPage.inputToTextboxByID(driver, "Email", email);

		log.info("Register - Step 06: Enter to Password textbox with value: " + validPassword);
		registerPage.inputToTextboxByID(driver, "Password", validPassword);

		log.info("Register - Step 07: Enter to Confirm Password textbox with value: " + validPassword);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", validPassword);

		log.info("Register - Step 08: Click to  'Register' Button");
		registerPage.clickToButtonByText(driver, "Register");

		log.info("Register - Step 09: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getSuccessMessageAtRegisterPage(), "Your registration completed");

		log.info("Register - Step 10: Click to 'Continue' Button");
		// homePage = registerPage.clickToContinueButton();
		registerPage.clickToLinkByText(driver, "Continue");
		homePage = PageGeneratorManager.getUserHomePage(driver);

	}

	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to 'Login' page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02: Enter email to textbox: " + email);
		loginPage.inputToEmailTextbox(email);

		log.info("Login - Step 03: Enter password to textbox" + validPassword);
		loginPage.inputToPasswordTextbox(validPassword);

		log.info("Login - Step 04: Click to 'Login' Button");
		homePage = loginPage.clickToLoginButton();

		log.info("Login - Step 05: Verify 'My account' Link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 06: Navigate to 'My Account' page");
		userCustomerInforPage = homePage.clickToMyAccountLink();

		log.info("Login - Step 07: Verify 'My Customer Info' page is displayed");
		Assert.assertTrue(userCustomerInforPage.isCustomerInforPageDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
