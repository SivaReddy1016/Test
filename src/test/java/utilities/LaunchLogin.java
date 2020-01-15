package utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaunchLogin {
	public static WebDriver driver = null;
	public static Properties config = null;
	static WebDriverWait wait;

	public void launchApplication(String URL) throws Exception {

		String url = setEnv().getProperty(URL);
		if (driver == null) {
			initilizeBrowser(setEnv().getProperty("browser"));
		}
		driver.get(url);
	}

	public static Properties setEnv() throws Exception {
		config = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "//Config//config.properties");
		config.load(ip);
		return config;
	}

	public static void initilizeBrowser(String browser) {
		browser = browser.toLowerCase().trim();
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//Resource//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			break;

		case "ie":
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "//Resource//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			break;
		default:
			// System.setProperty("webdriver.gecko.driver",
			// System.getProperty("user.dir") +"Resource/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			break;
		}
		wait = new WebDriverWait(driver, 60);
	}

}
