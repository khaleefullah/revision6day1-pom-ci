package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	private By winterToursMenu = By.linkText("Alaska Winter Tours");
	private By summerToursMenu = By.linkText("Summer Tours");

	public WinterToursPage openWinterToursPage() {
		waitAndClick(winterToursMenu);
		return new WinterToursPage(driver);
	}

	public SummerToursPage openSummerToursPage() {
		waitAndClick(summerToursMenu);
		return new SummerToursPage(driver);
	}
}
