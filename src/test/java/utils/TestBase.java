package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

/**
 * Base class for WebDriver initialization and browser management
 */
public class TestBase {
	private WebDriver driver;

	/**
	 * Initialize and return WebDriver instance
	 * Lazy initialization - driver is created only once and reused
	 */
	public WebDriver WebDriverManager() throws IOException {

		if (driver == null) {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//global.properties");
			Properties prop = new Properties();
			prop.load(fis);

			String URL = prop.getProperty("QAUrl");

			if (prop.getProperty("browser").equalsIgnoreCase(TestConstants.DEFAULT_BROWSER)) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--start-maximized");
				driver = new ChromeDriver(options);
			} else if (prop.getProperty("browser").equalsIgnoreCase("firefox"))  {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--start-maximized");
				driver = new FirefoxDriver(options);
			} else if (prop.getProperty("browser").equalsIgnoreCase("safari"))  {
				SafariOptions options = new SafariOptions();
				driver = new SafariDriver(options);
				driver.manage().window().maximize();
			} else if (prop.getProperty("browser").equalsIgnoreCase("edge"))  {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--start-maximized");
				driver = new EdgeDriver(options);
			}
			driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(TestConstants.IMPLICIT_WAIT_TIMEOUT));
			driver.get(URL);
		}
		return driver;
	}
	
	/**
	 * Close the driver and quit the browser
	 */
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
