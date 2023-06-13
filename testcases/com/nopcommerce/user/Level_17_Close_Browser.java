package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopCommerce.user.*;

public class Level_17_Close_Browser extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String firstName, lastName, validPassword, email;

	private UserCustomerInforPageObject userCustomerInforPage;
	
	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		validPassword = "123456";
		email = "leductho" + randomNumber() + "@gmail.com";
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Register - Step 02: Enter to Firstname textbox with value: " + firstName);
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Register - Step 03: Enter to Lastname textbox with value: " + lastName);
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Register - Step 04: Enter to Email textbox with value: " + email);
		registerPage.inputToEmailTextbox(email);

		log.info("Register - Step 05: Enter to Password textbox with value: " + validPassword);
		registerPage.inputToPasswordTextbox(validPassword);

		log.info("Register - Step 06: Enter to Confirm Password textbox with value: " + validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		log.info("Register - Step 07: Click to 'Register' Button");
		registerPage.clickToRegisterButton();

		log.info("Register - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getSuccessMessageAtRegisterPage(), "Your registration completedssss");

		log.info("Register - Step 09: Click to 'Continue' Button");
		homePage = registerPage.clickToContinueButton();
	}

	@Test
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
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 06: Navigate to 'My Account' page");
		userCustomerInforPage = homePage.clickToMyAccountLink();

		log.info("Login - Step 07: Verify 'My Customer Info' page is displayed");
		Assert.assertFalse(userCustomerInforPage.isCustomerInforPageDisplayed());
	}


	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
