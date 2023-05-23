//Framework 18 - Handle DataTable/ DataGrid - Part I

package com.facebook.register;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.facebook.HomePageObject;
import pageObjects.facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {

	private WebDriver driver;
	private HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		homePage = PageGeneratorManager.getHomePage(driver);

	}

	@Test
	public void TC_01_Verify_Element_Displayed() {
		homePage.clickToCreateNewAccountButton();
		homePage.enterToEmailAddressTextbox("email0912@gmail.com");
		homePage.sleepInSecond(1);
		verifyTrue(homePage.isConfirmEmailAddressTextboxDisplayed());
	}

	@Test
	public void TC_02_Verify_Element_Undisplayed_In_DOM() {
		homePage.enterToEmailAddressTextbox("");
		homePage.sleepInSecond(1);
		verifyFalse(homePage.isConfirmEmailAddressTextboxDisplayed());

		verifyTrue(homePage.isConfirmEmailAddressTextboxUndisplayed());

	}

	@Test
	public void TC_03_Verify_Element_Undisplayed_NOT_In_DOM() {
		homePage.clickCloseIconAtRegisterForm();
		homePage.sleepInSecond(1);
		verifyTrue(homePage.isConfirmEmailAddressTextboxUndisplayed());
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
