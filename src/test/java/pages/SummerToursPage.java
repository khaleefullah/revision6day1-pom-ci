package pages;

import base.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SummerToursPage extends BasePage {

	public SummerToursPage(WebDriver driver) {
		super(driver);
	}

	private By nameField = By.id("field_qh4icy4");
	private By emailField = By.id("field_29yf4d4");
	private By phoneField = By.id("field_e5nnt");
	private By messageField = By.id("field_9jv0r13");

	public SummerToursPage enterName(String name) {
		waitAndType(nameField, name);
		return this;
	}

	public SummerToursPage enterEmail(String email) {
		waitAndType(emailField, email);
		return this;
	}

	public SummerToursPage enterPhone(String phone) {
		waitAndType(phoneField, phone);
		return this;
	}

	public SummerToursPage enterMessage(String message) {
		waitAndType(messageField, message);
		return this;
	}

}
