
package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObject.jQuery.HomePageObject;
import pageObjects.nopCommerce.user.FooterWishlistPageObject;
import pageObjects.nopCommerce.user.UserAddressesPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserOrdersPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_10_DataTable_DataGrid extends BaseTest {

	private WebDriver driver;
	HomePageObject homePage;
	

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		homePage = pageObject.jQuery.PageGeneratorManager.getHomePage(driver);		
	}

	@Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		homePage.openPagingByPageNumber("1");
		Assert.assertTrue(homePage.isPageNumberActived("1"));
		homePage.openPagingByPageNumber("20");
		Assert.assertTrue(homePage.isPageNumberActived("20"));
	}
	
	@Test
	public void Table_02_Enter_To_Header() {
		homePage.refreshCurrentPage(driver);
		homePage.enterToHeaderSearchboxByLabel("Females", "338282");
		homePage.enterToHeaderSearchboxByLabel("Country", "Argentina");
		homePage.enterToHeaderSearchboxByLabel("Males", "349238");
		homePage.enterToHeaderSearchboxByLabel("Total", "687522");
		
		homePage.enterToHeaderSearchboxByLabel("Females", "276880");
		homePage.enterToHeaderSearchboxByLabel("Country", "Angola");
		homePage.enterToHeaderSearchboxByLabel("Males", "276472");
		homePage.enterToHeaderSearchboxByLabel("Total", "553353");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
