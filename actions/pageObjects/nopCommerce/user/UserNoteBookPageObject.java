package pageObjects.nopCommerce.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.nopCommerce.user.UserNotebookPageUI;

public class UserNoteBookPageObject extends BasePage {
	private WebDriver driver;

	public UserNoteBookPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInSortByDropDown(String selectedItem) {
		waitForElementClickable(driver, UserNotebookPageUI.SORT_BY_DROPDOWN);
		selectItemInDefaultDropdown(driver, UserNotebookPageUI.SORT_BY_DROPDOWN, selectedItem);
	}

		
	public boolean isProductSortByNameAsc() {
        List<WebElement> elementLists = getListWebElement(driver, UserNotebookPageUI.PRODUCT_NAME_TEXT);
        List<String> names = elementLists.stream().map(n -> n.getText()).collect(Collectors.toList());
        List<String> sortedNames = new ArrayList<String>(names);
        Collections.sort(sortedNames);
        return names.equals(sortedNames);
	}
	
	public boolean isProductSortByNameAscWithLocator(WebDriver driver, String locator) {
	    List<WebElement> elementList = getListWebElement(driver, locator);
	    List<String> names = elementList.stream()
	            .map(WebElement::getText)
	            .collect(Collectors.toList());
	    List<String> sortedNames = new ArrayList<>(names);
	    sortedNames.sort(Comparator.naturalOrder());
	    return names.equals(sortedNames);
	}

	
	public boolean isProductSortByNameDescWithLocator(WebDriver driver, String locator) {
	    List<WebElement> elementList = getListWebElement(driver, locator);
	    List<String> names = elementList.stream()
	            .map(WebElement::getText)
	            .collect(Collectors.toList());
	    List<String> sortedNames = new ArrayList<>(names);
	    sortedNames.sort(Comparator.reverseOrder());
	    return names.equals(sortedNames);
	}


	
}
