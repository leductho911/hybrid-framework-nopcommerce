package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName) {

		if (browserName.equals("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		} else if (browserName.equals("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		} else if (browserName.equals("edge")) {
			driver = WebDriverManager.edgedriver().create();
		} else if (browserName.equals("safari")) {
			driver = new SafariDriver();
		} else if (browserName.equals("opera")) {
			driver = WebDriverManager.operadriver().create();
		} else {
			throw new RuntimeException("Browser name invalid");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// mở URL nó sẽ qua trang HomePage
		driver.get(GlobalConstants.USER_PAGE_URL);
		return driver;

	}

	public int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(9999);

	}
}
