package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By winterToursMenu = By.linkText("Alaska Winter Tours");

	public WinterToursPage openWinterToursPage() {
		waitAndClick(winterToursMenu);
		return new WinterToursPage(driver);
	}
}
