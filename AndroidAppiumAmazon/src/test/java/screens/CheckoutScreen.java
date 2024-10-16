package screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBys;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutScreen extends ScreenBase {

	
	@AndroidFindBys({ @AndroidBy (xpath = "//android.view.View[@index='0']")})
	public List<WebElement> links;

	public CheckoutScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	public  String checkoutproductinformation() throws InterruptedException {
		
		String checkoutscreenproductname =links.get(10).getText();
		log.debug("checkoutproductinformation");
		return checkoutscreenproductname;	
		
        
		
	}

}
