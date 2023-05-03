package commons;

import java.io.File;

public class GlobalConstants {

	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F";
	public static final String USER_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String PORTAL_DEV_URL = "https://demo.nopcommerce.com/";
	public static final String PORTAL_STG_URL = "https://demo.nopcommerce.com/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");

	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles";
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator + "autoIT";

	public static final String DB_DEV_URL = "12.18.133.15:9860";
	public static final String DB_DEV_USER = "mh_user";
	public static final String DB_DEV_PASSWORD = "JHG@&^&NK345";

	public static final String DB_STG_URL = "132.45.153.4:9860";
	public static final String DB_STG_USER = "mh_STG_user";
	public static final String DB_STG_PASSWORD = "JHG@&^&NK345";

	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final long RETRY_TEST_FAIL = 3;

}
