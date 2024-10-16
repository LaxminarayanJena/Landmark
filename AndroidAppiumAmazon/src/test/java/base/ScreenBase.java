package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class ScreenBase {

	public static AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	
	public void waitForElementPresent(long duration, String locator) {

		wait = new WebDriverWait(driver, duration);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
	}

	public ScreenBase(AppiumDriver<MobileElement> driver) {

		ScreenBase.driver = (AndroidDriver<MobileElement>) driver;

	}

	@SuppressWarnings("unchecked")
	public static void scroll(String visibleText) {
		((FindsByAndroidUIAutomator<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}
}
