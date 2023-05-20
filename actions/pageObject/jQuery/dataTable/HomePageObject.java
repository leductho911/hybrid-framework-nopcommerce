package pageObject.jQuery.dataTable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jQuery.dataTable.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderSearchboxByLabel(String headerLabel, String searchValue) {
		waitForElementVisible(driver, HomePageUI.HEADER_SEARCHBOX_BY_LABEL, headerLabel);
		sendKeysToElement(driver, HomePageUI.HEADER_SEARCHBOX_BY_LABEL, searchValue, headerLabel);
		pressKeyToElement(driver, HomePageUI.HEADER_SEARCHBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGE);
		List<String> allRowValueAllPage = new ArrayList<String>();

		for (int page = 1; page <= totalPage; page++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, String.valueOf(page));

			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRowElement : allRowElementEachPage) {
				allRowValueAllPage.add(eachRowElement.getText());
			}

		}
		return allRowValueAllPage;
	}

	public List<String> getColumnDataByDataKeyAtAllPage(String dataKey) {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGE);
		List<String> columnDataAtAllPage = new ArrayList<String>();

		for (int page = 1; page <= totalPage; page++) {
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, String.valueOf(page));

			List<WebElement> allColumnElementEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_COLUMN_EACH_PAGE,
					dataKey);
			for (WebElement eachColumnElement : allColumnElementEachPage) {
				columnDataAtAllPage.add(eachColumnElement.getText());
			}

		}

		return columnDataAtAllPage;
	}

	public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String inputValue) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber,
				String.valueOf(columnIndex));
		sendKeysToElement(driver, HomePageUI.TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, inputValue, rowNumber,
				String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String selectValue) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementVisible(driver, HomePageUI.DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber,
				String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX, selectValue, rowNumber,
				String.valueOf(columnIndex));

	}

	public void clickToLoadDataButton() {
		waitForElementClickable(driver, HomePageUI.BUTTON_LOAD_DATA);
		clickToElement(driver, HomePageUI.BUTTON_LOAD_DATA);
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber,
				String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUI.CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber,
				String.valueOf(columnIndex));
	}

	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME, columnName) + 1;

		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber,
				String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI.CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX, rowNumber,
				String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String buttonTitle, String rowNumber) {
		waitForElementClickable(driver, HomePageUI.BUTTON_BY_ROW_INDEX_AND_BUTTON_TITLE, rowNumber, buttonTitle);
		clickToElement(driver, HomePageUI.BUTTON_BY_ROW_INDEX_AND_BUTTON_TITLE, rowNumber, buttonTitle);
	}

}
