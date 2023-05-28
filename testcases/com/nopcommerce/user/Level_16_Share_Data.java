package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register;

import pageObjects.nopCommerce.user.*;

public class Level_16_Share_Data extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private String validPassword, email;


	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		validPassword = Common_01_Register.validPassword;
		email = Common_01_Register.email;

		log.info("Login - Step 01: Navigate to 'Login' page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02: Enter email to textbox: " + email);
		loginPage.inputToEmailTextbox(email);

		log.info("Login - Step 03: Enter password to textbox" + validPassword);
		loginPage.inputToPasswordTextbox(validPassword);

		log.info("Login - Step 04: Click to 'Login' Button");
		homePage = loginPage.clickToLoginButton();
	}

	
	@Test
	public void Search_01_Empty_Data() {
	}

	@Test
	public void Search_02_Product_Name() {
	}
	
	@Test
	public void Search_03_Price() {
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
