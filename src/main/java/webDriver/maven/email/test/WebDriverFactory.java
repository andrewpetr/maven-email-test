package webDriver.maven.email.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	private static final String CHROME = "chrome";
	private static final String FIREFOX = "firefox";

	private static WebDriver webDriver;

	private WebDriverFactory() {

	}

	public static WebDriver getInstance(String browser) {
		if (webDriver == null) {
			if (CHROME.equals(browser)) {
				setChromeDriver();
				webDriver = new ChromeDriver();

			} else if (FIREFOX.equals(browser)) {
				webDriver = new FirefoxDriver();

			} else
				throw new RuntimeException("Invalid browser property set in configuration file");
		}

		return webDriver;
	}

	public static void killDriverInstance() {
		if (webDriver != null) {
			webDriver.quit();
			webDriver = null;
		}
	}

	private static void setChromeDriver() {
		String os = System.getProperty("os.name").toLowerCase().substring(0, 3);
		String chromeBinary = "c:/Java/workspace/email.test/src/drivers/chromedriver"
				+ (os.equals("win") ? ".exe" : "");
		System.setProperty("webdriver.chrome.driver", chromeBinary);
	}

}