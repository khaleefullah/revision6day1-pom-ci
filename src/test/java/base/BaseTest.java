package base;

import core.Config;
import core.DriverFactory;
import core.LoggerManager;
import pages.HomePage;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

public class BaseTest {
	
	private static final Logger log = LoggerManager.getLogger(HomePage.class);
	
	@BeforeMethod
	public void setup() {
		DriverFactory.initDriver();
		DriverFactory.getDriver().get(Config.getBaseUrl());
		log.info("Driver initialized and navigated to the Base URL");
	}

	@AfterMethod
	public void teardown() {
		DriverFactory.quitDriver();
		log.info("Driver is terminated");
	}
}
