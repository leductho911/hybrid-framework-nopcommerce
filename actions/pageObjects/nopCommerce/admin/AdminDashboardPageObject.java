package pageObjects.nopCommerce.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIs.nopCommerce.admin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage {
	private WebDriver driver;

	public AdminDashboardPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isAdminDashboardPageDisplayed() {
		waitForElementVisible(driver, AdminDashboardPageUI.CONTENT_HEADER);
		return isElementDisplayed(driver, AdminDashboardPageUI.CONTENT_HEADER);
	}

	public AdminLoginPageObject clickToLogoutLink() {
		waitForElementClickable(driver, AdminDashboardPageUI.LOGOUT_LINK);
		clickToElement(driver, AdminDashboardPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}

}
