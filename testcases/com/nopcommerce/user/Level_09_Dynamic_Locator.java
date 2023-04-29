// * Framework 05 - Page Object Pattern - Part I 

package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.FooterWishlistPageObject;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserOrdersPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_09_Dynamic_Locator extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String firstName, lastName, password, email;

	private UserCustomerInforPageObject userCustomerInforPage;
	private UserAddressesPageObject userAddressesPage;
	private UserOrdersPageObject userOrdersPage;
	private FooterWishlistPageObject footerWishlistPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		password = "123456";
		email = "leductho" + randomNumber() + "@gmail.com";

	}

	@Test
	public void User_01_Register_Login() {
		registerPage = homePage.clickToRegisterLink();

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getSuccessMessageAtRegisterPage(), "Your registration completed");

		homePage = registerPage.clickToContinueButton();

		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		userCustomerInforPage = homePage.clickToMyAccountLink();

		Assert.assertTrue(userCustomerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_02_Dynamic_Page() {
		// addressesPage = customerInforPage.openAddressesPage(driver);
		// cach 2
		userCustomerInforPage.openPageAtMyAccountPage(driver, "Addresses");
		userAddressesPage = PageGeneratorManager.getUserAddressesPage(driver);

		// cach 1
		// userOrdersPage = userAddressesPage.openOrdersPage(driver);
		userOrdersPage = (UserOrdersPageObject) userAddressesPage.openPageAtMyAccountPageName(driver, "Orders");

		userOrdersPage.openPageAtHeaderOrFooter(driver, "footer-upper", "Wishlist");
		footerWishlistPage = PageGeneratorManager.getFooterWishlistPage(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
