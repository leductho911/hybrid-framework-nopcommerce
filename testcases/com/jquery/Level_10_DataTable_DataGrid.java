//Framework 18 - Handle DataTable/ DataGrid - Part I

package com.jquery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.jQuery.dataTable.HomePageObject;

public class Level_10_DataTable_DataGrid extends BaseTest {

	private WebDriver driver;
	HomePageObject homePage;
	List<String> actualAllCountryValue;
	List<String> expectedAllCountryValue;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appURL) {
		driver = getBrowserDriver(browserName, appURL);
		homePage = pageObject.jQuery.dataTable.PageGeneratorManager.getHomePage(driver);
	}

	// @Test
	public void Table_01_Paging() {
		homePage.openPagingByPageNumber("10");
		Assert.assertTrue(homePage.isPageNumberActived("10"));
		homePage.openPagingByPageNumber("1");
		Assert.assertTrue(homePage.isPageNumberActived("1"));
		homePage.openPagingByPageNumber("20");
		Assert.assertTrue(homePage.isPageNumberActived("20"));
	}

	// @Test
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

	// @Test
	public void Table_03() {
		// homePage.getValueEachRowAtAllPage();

		// Read country data file here
		// Save into List<String> expectedAllCountryValue

		actualAllCountryValue = homePage.getColumnDataByDataKeyAtAllPage("country");

		Assert.assertEquals(actualAllCountryValue, expectedAllCountryValue);

	}

	@Test
	public void Table_04() {
		homePage.clickToLoadDataButton();
		homePage.enterToTextboxAtRowNumberByColumnName("Company", "2", "BAP");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "3", "Japan");
		homePage.sleepInSecond(3);
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "5", "Malaysia");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "3");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "5");
		homePage.sleepInSecond(3);
		homePage.clickToIconByRowNumber("Insert Row Above", "3");
		homePage.sleepInSecond(3);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
