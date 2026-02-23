package core;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {

	public static WebDriver createDriver() {

		String browser = Config.getBrowser();

		switch (browser.toLowerCase()) {

		case "chrome":

			ChromeOptions chromeOptions = new ChromeOptions();
			applyHeadless(chromeOptions);
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--disable-dev-shm-usage");
			chromeOptions.addArguments("--disable-gpu");
			return createDriver(chromeOptions);

		case "firefox":

			FirefoxOptions firefoxOptions = new FirefoxOptions();
			applyHeadless(firefoxOptions);
			return createDriver(firefoxOptions);

		case "edge":

			EdgeOptions edgeOptions = new EdgeOptions();
			applyHeadless(edgeOptions);
			return createDriver(edgeOptions);

		default:
			throw new IllegalArgumentException("Invalid browser: " + browser);
		}

	}

	@SuppressWarnings("deprecation")
	public static WebDriver createRemoteDriver(Capabilities options) {
		try {
			return new RemoteWebDriver(new URL(Config.getGridUrl()), (org.openqa.selenium.Capabilities) options);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Remote driver not created. Grid URL: " + Config.getGridUrl());
		}

	}

	private static void applyHeadless(Capabilities options) {
		if (Config.isHeadless()) {

			if (options instanceof ChromeOptions c) {
				c.addArguments("--headless=new");
			}
			if (options instanceof FirefoxOptions f) {
				f.addArguments("--headless=new");
			}
			if (options instanceof EdgeOptions e) {
				e.addArguments("--headless=new");
			}
		}
	}

	private static WebDriver createDriver(Capabilities options) {
		if (Config.getExecutionMode().equalsIgnoreCase("remote")) {
			return createRemoteDriver(options);
		}

		if (options instanceof ChromeOptions) {
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver((ChromeOptions) options);
		}

		if (options instanceof FirefoxOptions) {
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver((FirefoxOptions) options);
		}

		if (options instanceof EdgeOptions) {
			WebDriverManager.edgedriver().setup();
			return new EdgeDriver((EdgeOptions) options);
		}

		throw new IllegalArgumentException("Unsupported capabilities");
	}

}
