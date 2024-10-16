package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import base.TestBase;
import screens.CheckoutScreen;
import screens.HomeScreen;
import screens.ProductInformationScreen;

public class AmazonProductTest extends TestBase {

	HomeScreen homescreen;
	ProductInformationScreen productinformationscreen;
	CheckoutScreen checkoutscreen;

	@BeforeTest
	public void init() {

		homescreen = new HomeScreen(driver);
		productinformationscreen = new ProductInformationScreen(driver);
		checkoutscreen = new CheckoutScreen(driver);
	}

	@Test(priority = 1)
	public void selectrandomproduct() throws InterruptedException {

		homescreen.searchproduct("65-inch TV");
		homescreen.productlist();
	}

	@Test(priority = 2)
	public void productpageproductinformation() throws InterruptedException {
		productinformationscreen.checkout();

	}

	@Test(priority = 3)
	public void checkoutpageproductinformation() throws InterruptedException {
		String actualcheckoutproductname = checkoutscreen.checkoutproductinformation();
		log.debug(actualcheckoutproductname);
	
	}

}
