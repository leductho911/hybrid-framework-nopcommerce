package pageObjects.facebook;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static pageObjects.facebook.HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
}
