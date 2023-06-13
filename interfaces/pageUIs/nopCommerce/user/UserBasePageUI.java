package pageUIs.nopCommerce.user;

public class UserBasePageUI {
	public static final String ADDRESSES_LINK = "xpath=//div[@class='listbox']//a[text()='Addresses']";
	public static final String ORDERS_LINK = "xpath=//div[@class='listbox']//a[text()='Orders']";
	public static final String REWARD_POINTS_LINK = "XPATH=//div[@class='listbox']//a[text()='Reward points']";
	public static final String CUSTOMER_INFO_LINK = "xpath=//div[@class='listbox']//a[text()='Customer info']";
	public static final String DYNAMIC_PAGES_AT_MY_ACCOUNT_SIDEBAR = "xpath=//div[@class='listbox']//a[text()='%s']";
	public static final String DYNAMIC_PAGES_AT_HEADER_FOOTER = "xpath=//div[@class='%s']//a[text()='%s']";
	
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_LINK_BY_TEXT = "xpath=//a[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
}
