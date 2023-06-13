package com.wordpress.admin;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.PageGeneratorManager;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Post_01_Create_Read_Update_Delete_Search extends BaseTest {

	private WebDriver driver;
	AdminLoginPO adminLoginPage;
	AdminDashboardPO adminDashboardPage;
	String adminUsername = "admin";
	String adminPassword = "admin";
	

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl) {
		log.info("Pre-condition - Step 01: Open browser and admin URL");
		driver = getBrowserDriver(browserName, adminUrl);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		
		log.info("Pre-condition - Step 02: Enter to Username textbox with value:" + adminUsername);

		log.info("Pre-condition - Step 03: Enter to Password textbox with value:" + adminPassword);

		log.info("Pre-condition - Step 04: Click to Login button");	


	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create_post - Step 01: Click to 'Posts' menu link");	

		log.info("Create_post - Step 02: Click to 'Add New' button");
		
		log.info("Create_post - Step 03: Enter to Post title");
		
		log.info("Create_post - Step 04: Enter to Post body");	
		
		log.info("Create_post - Step 05: Click to 'Publish' button");	
		
		log.info("Create_post - Step 06: Verify 'Post Published' message is displayed");	

		log.info("Create_post - Step 07: Open 'Search post' page");	
		
	}
	
	public void Post_02_Search_Post() {
		
	}

	public void Post_03_View_Post() {
		
	}

	public void Post_04_Edit_Post() {
		
	}

	public void Post_05_Delete_Post() {
		
	}

	
	@AfterClass (alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
