package testcases;

import base.BaseTest;
import core.DriverFactory;
import dataprovider.TestDataProvider;
import pages.*;

import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Hashtable;

public class WinterToursTest extends BaseTest{
	
	HomePage homePage;
	WinterToursPage winterToursPage;

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "dp")
	public void winterToursTest(Hashtable<String, String> data) {

		homePage = new HomePage(DriverFactory.getDriver());
		winterToursPage = homePage
				.openWinterToursPage()
				.enterName(data.get("Name"))
				.enterEmail(data.get("Email"))
				.enterPhone(data.get("Phone"))
				.enterMessage(data.get("Message"));
	}
}
