package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class WinterToursPage extends BasePage {

	public WinterToursPage(WebDriver driver) {
		super(driver);
	}

	private By nameField = By.id("field_qh4icy4");
	private By emailField = By.id("field_29yf4d4");
	private By phoneField = By.id("field_e5nnt");
	private By messageField = By.id("field_9jv0r13");

	public WinterToursPage enterName(String name) {
		waitAndType(nameField, name);
		return this;
	}

	public WinterToursPage enterEmail(String email) {
		waitAndType(emailField, email);
		return this;
	}

	public WinterToursPage enterPhone(String phone) {
		waitAndType(phoneField, phone);
		return this;
	}

	public WinterToursPage enterMessage(String message) {
		waitAndType(messageField, message);
		return this;
	}
}
