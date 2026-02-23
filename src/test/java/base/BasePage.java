package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import core.Config;
import core.LoggerManager;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class BasePage {
	
	protected WebDriver driver;
	private static final Logger log = LoggerManager.getLogger(BasePage.class); 
	
	public BasePage(WebDriver driver) {
		this.driver = driver;		
	}
	
	protected WebDriverWait explicitWait() {
		return new WebDriverWait(driver, Duration.ofSeconds(Config.getTimeout()));
	}
	
	public void waitAndClick(By by) {
		log.info("Clicking element: {}", by);
		explicitWait().until(ExpectedConditions.elementToBeClickable(by)).click();
	}
	
	public void waitAndType(By by, String value) {
		log.info("Typing into element: {}", by);
		explicitWait().until(ExpectedConditions.visibilityOfElementLocated(by)).clear();
		explicitWait().until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(value);
	}
}
