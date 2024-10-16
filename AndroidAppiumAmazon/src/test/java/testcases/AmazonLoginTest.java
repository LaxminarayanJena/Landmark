package testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import base.TestBase;
import screens.CheckoutScreen;
import screens.HomeScreen;
import screens.ProductInformationScreen;
import screens.WelcomeScreen;
import utility.TestUtil;

public class AmazonLoginTest extends TestBase {

	WelcomeScreen welcomescreen;
	HomeScreen homescreen;

	@BeforeTest
	public void init() {
		welcomescreen = new WelcomeScreen(driver);
		homescreen = new HomeScreen(driver);
	}

	@Test(priority = 1, dataProvider = "getData")
	public void amazonlogin(String email, String password) throws InterruptedException {
		welcomescreen.login().userSign_In(email, password);

	}

	@Test(priority = 2)
	public void selectcountryregion() throws InterruptedException {
		homescreen.countryselection();

	}

	@DataProvider
	public static Object[][] getData() {

		return TestUtil.getData("AmazonLoginTest");

	}

}
