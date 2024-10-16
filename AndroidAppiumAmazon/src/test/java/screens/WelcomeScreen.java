package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WelcomeScreen extends ScreenBase {

	@AndroidFindBy(xpath = "//*[@text='Already a customer? Sign in']")
	public WebElement SignIn;

	public WelcomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	public AuthScreen login() {
		SignIn.click();
		log.debug("Logged in");
		return new AuthScreen(driver);
	}

}
