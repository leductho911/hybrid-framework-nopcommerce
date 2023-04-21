// * Framework 05 - Page Object Pattern - Part I 

package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_Model_01_Register {

	private WebDriver driver;
	private String projectPath = System.getProperty("user.dir");
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private String firstName, lastName, password, emailAddress;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// mở URL nó sẽ qua trang HomePage
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		emailAddress = "leductho" + randomNumber() + "@gmail.com";

	}

	@Test
	public void Register_01_Register_Empty_Data() {
		// waitForElementClickable(driver, "//a[@class='ico-register']");
		// clickToElement(driver, "//a[@class='ico-register']");
		homePage.clickToRegisterLink();

		// Click Register Link thì nó sẽ mở trang Register > khởi tạo Register page
		registerPage = new RegisterPageObject(driver);
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextBox(), "First name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextBox(), "Last name is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(), "Password is required.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(), "Password is required.");

	}

	@Test
	public void Register_02_Register_Invalid_Email() {
		homePage.clickToRegisterLink();

		// Click Register Link thì nó sẽ mở trang Register > khởi tạo Register page
		registerPage = new RegisterPageObject(driver);

		// sendKeysToElement(driver, "//input[@id='Email']", "dsaf4gmail.com");
		registerPage.inputToEmailTextbox("dsaf4gmail.com");

		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver, "//span[@id='Email-error']"),
		// "Wrong email");
		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Register_03_Register_Success() {
		homePage.clickToRegisterLink();

		// Click Register Link thì nó sẽ mở trang Register > khởi tạo Register page
		registerPage = new RegisterPageObject(driver);

		// sendKeysToElement(driver, "//input[@id='FirstName']", "Automation");
		// sendKeysToElement(driver, "//input[@id='LastName']", "FC");
		// sendKeysToElement(driver, "//input[@id='Email']", emailAddress);
		// sendKeysToElement(driver, "//input[@id='Password']", "123456");
		// sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "123456");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your
		// registration completed");
		Assert.assertEquals(registerPage.getSuccessMessageAtRegisterPage(), "Your registration completed");

		// clickToElement(driver, "//a[@class='ico-logout']");
		// registerPage.clickToLogoutLink();
	}

	@Test
	public void Register_04_Register_Existing_Email() {
		homePage.clickToRegisterLink();

		// Click Register Link thì nó sẽ mở trang Register > khởi tạo Register page
		registerPage = new RegisterPageObject(driver);

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver,
		// "//div[contains(@class,'message-error')]//li"),
		// "The specified email already exists");
		Assert.assertEquals(registerPage.getErrorMessageExistingEmail(), "The specified email already exists");
	}

	@Test
	public void Register_05_Register_Password_Less_Than_6_Chars() {
		homePage.clickToRegisterLink();
		// Click Register Link thì nó sẽ mở trang Register > khởi tạo Register page
		registerPage = new RegisterPageObject(driver);

		registerPage.inputToPasswordTextbox("123");

		registerPage.clickToRegisterButton();

//		Assert.assertEquals(getElementText(driver, "//span[@id='Password-error']"),
//				"Password must meet the following rules:\nmust have at least 6 characters");
		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextBox(),
				"Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_06_Register_Invalid_Confirm_Password() {
		homePage.clickToRegisterLink();
		// Click Register Link thì nó sẽ mở trang Register > khởi tạo Register page
		registerPage = new RegisterPageObject(driver);

		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(emailAddress);

		registerPage.clickToRegisterButton();

		// Assert.assertEquals(getElementText(driver,
		// "//span[@id='ConfirmPassword-error']"),
		// "The password and confirmation password do not match.");
		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextBox(),
				"The password and confirmation password do not match.");

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
