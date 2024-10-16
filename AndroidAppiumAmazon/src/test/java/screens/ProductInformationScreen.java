package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductInformationScreen extends ScreenBase {

	@AndroidFindBy(xpath = "//*[@text='See All Buying Options']")
	public WebElement SeeAllBuyingOptions;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
	public WebElement AddToCart;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@index='1']")
	public WebElement Cart;

	public ProductInformationScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	public void checkout() throws InterruptedException {

		Thread.sleep(3000);
		scroll("See All Buying Options");
		SeeAllBuyingOptions.click();
		AddToCart.click();
		Cart.click();
		Thread.sleep(3000);
		log.debug("checkout");

	}

}
