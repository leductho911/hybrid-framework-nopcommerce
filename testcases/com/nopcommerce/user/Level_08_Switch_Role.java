// * Framework 05 - Page Object Pattern - Part I 

package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_08_Switch_Role extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserRegisterPageObject registerPage;
	private UserCustomerInforPageObject customerInforPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String firstName, lastName, userPassword, userEmail, adminEmail, adminPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		userPassword = "123456";
		userEmail = "leductho" + randomNumber() + "@gmail.com";
		adminEmail = "admin@yourstore.com";
		adminPassword = "admin";

		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(userEmail);
		registerPage.inputToPasswordTextbox(userPassword);
		registerPage.inputToConfirmPasswordTextbox(userPassword);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getSuccessMessageAtRegisterPage(), "Your registration completed");
		homePage = registerPage.clickToContinueButton();

	}

	@Test
	public void Role_01_User() {
		loginPage = homePage.clickToLoginLink();
		homePage = loginPage.loginAsUser(userEmail, userPassword);
		customerInforPage = homePage.clickToMyAccountLink();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void Role_02_Admin() {
		customerInforPage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmail, adminPassword);
		Assert.assertTrue(adminDashboardPage.isAdminDashboardPageDisplayed());
		adminLoginPage = adminDashboardPage.clickToLogoutLink();
		Assert.assertTrue(adminLoginPage.isLoginPageDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
