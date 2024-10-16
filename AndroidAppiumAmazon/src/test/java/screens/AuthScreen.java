package screens;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AuthScreen extends ScreenBase {

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
	public WebElement emailTextBox;

	@AndroidFindBy(xpath = "//*[@text='Continue']")
	public WebElement Continue;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='1']")
	public WebElement passwordTextBox;

	@AndroidFindBy(xpath = "//android.widget.Button[@index='0']")
	public WebElement ContinueBtn;

	public AuthScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}
    
	
	public void userSign_In(String email, String password) throws InterruptedException {
		emailTextBox.sendKeys(email);
		Continue.click();
		Thread.sleep(6000);
		passwordTextBox.sendKeys(password);
		ContinueBtn.click();
		log.debug("User signed in");
	}

}
