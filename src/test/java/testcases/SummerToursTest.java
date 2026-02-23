package testcases;

import base.BaseTest;
import core.DriverFactory;
import dataprovider.TestDataProvider;

import java.util.Hashtable;
import org.testng.annotations.*;
import pages.*;

public class SummerToursTest extends BaseTest{

	HomePage homePage;
	SummerToursPage summerToursPage;
	
	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "dp")
	public void summerToursTest(Hashtable<String, String> data) {
		
		homePage = new HomePage(DriverFactory.getDriver());
		summerToursPage = homePage
		.openSummerToursPage()
		.enterName(data.get("Name"))
		.enterEmail(data.get("Email"))
		.enterPhone(data.get("Phone"))
		.enterMessage(data.get("Message"));
	}
}
