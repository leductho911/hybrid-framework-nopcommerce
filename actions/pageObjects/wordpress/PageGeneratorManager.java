package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;



public class PageGeneratorManager {
	
	public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPO(driver);	}
	
	public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPO(driver);	}

}
