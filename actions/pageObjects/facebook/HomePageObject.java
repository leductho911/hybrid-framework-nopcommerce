package pageObjects.facebook;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.facebook.HomePageUI;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToCreateNewAccountButton() {
        waitForElementClickable(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
        clickToElement(driver, HomePageUI.CREATE_NEW_ACCOUNT_BUTTON);
    }


    public boolean isEmailAddressTextboxDisplayed() {
        waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
        return isElementDisplayed(driver, HomePageUI.EMAIL_TEXTBOX);
    }

    public void enterToEmailAddressTextbox(String email) {
        waitForElementVisible(driver, HomePageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, HomePageUI.EMAIL_TEXTBOX, email);
    }

    public boolean isConfirmEmailAddressTextboxDisplayed() {
        return isElementDisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
    }

    public void clickCloseIconAtRegisterForm() {
        waitForElementClickable(driver, HomePageUI.CLOSE_ICON_AT_REGISTER_FORM);
        clickToElement(driver, HomePageUI.CLOSE_ICON_AT_REGISTER_FORM);
    }

    public boolean isConfirmEmailAddressTextboxUndisplayed() {
        waitForElementUndisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
        return isElementUndisplayed(driver, HomePageUI.CONFIRM_EMAIL_TEXTBOX);
    }
}
