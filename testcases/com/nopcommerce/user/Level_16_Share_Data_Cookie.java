package com.nopcommerce.user;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;

import pageObjects.nopCommerce.user.*;

public class Level_16_Share_Data_Cookie extends BaseTest {

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;


	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Pre-condition - Step 01: Navigate to 'Login' page");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-condition - Step 02: Set cookie and reload page");
		loginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);
		
		loginPage.refreshCurrentPage(driver);		
		loginPage.sleepInSecond(3);
		
		log.info("Pre-condition - Step 03: Verify 'My account' Link is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());		
		
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
