package pageUI.jQuery.dataTable;

public class HomePageUI {
	public static final String PAGINATION_PAGE_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_ACTIVED_BY_NUMBER = "xpath=//li[@class='qgrd-pagination-page']/a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String HEADER_SEARCHBOX_BY_LABEL = "xpath=//div[@class='qgrd-header-text' and text()='%s']/parent::div/following-sibling::input";
	public static final String TOTAL_PAGE = "css=ul.qgrd-pagination-ul > li.qgrd-pagination-page";
	public static final String ALL_ROW_EACH_PAGE = "xpath=//tbody/tr";
	public static final String ALL_ROW_COUNTRY_EACH_PAGE = "xpath=//tbody/tr/td[@data-key='Country']";
	public static final String ALL_ROW_COLUMN_EACH_PAGE = "xpath=//tbody/tr/td[@data-key='%s']";
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//thead/tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]//select";
	public static final String BUTTON_LOAD_DATA = "css=button#load";
	public static final String CHECKBOX_BY_ROW_INDEX_AND_COLUMN_INDEX = "xpath=//tbody/tr[%s]/td[%s]//input";
	public static final String BUTTON_BY_ROW_INDEX_AND_BUTTON_TITLE = "xpath=//tbody/tr[%s]//button[@title='%s']";

}
