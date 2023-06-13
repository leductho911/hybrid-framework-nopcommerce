package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserNoteBookPageObject;
import pageUIs.nopCommerce.user.UserNotebookPageUI;

public class Level_19_Sort_Data extends BaseTest {

	private WebDriver driver;
	private UserNoteBookPageObject notebookPage;


	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		notebookPage = PageGeneratorManager.getNoteBookPage(driver);
	}

	@Test
	public void Sort_Data_01_A_To_Z() {
		notebookPage.selectItemInSortByDropDown("Name: A to Z");
		notebookPage.sleepInSecond(3);
		Assert.assertTrue(notebookPage.isProductSortByNameAscWithLocator(driver, UserNotebookPageUI.PRODUCT_NAME_TEXT));
		
		notebookPage.selectItemInSortByDropDown("Name: Z to A");
		notebookPage.sleepInSecond(3);
		Assert.assertTrue(notebookPage.isProductSortByNameDescWithLocator(driver, UserNotebookPageUI.PRODUCT_NAME_TEXT));
	}
	
	
	public void Sort_Data_02_Z_To_A() {

	}
	
	public void Sort_Data_03_Price_Low_To_High() {
		notebookPage.selectItemInSortByDropDown("Price: Low to High");

	}
	
	public void Sort_Data_04_Price_High_To_Low() {
		notebookPage.selectItemInSortByDropDown("Price: High to Low");

	}

	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
