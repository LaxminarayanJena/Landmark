package screens;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends ScreenBase {

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/action_bar_burger_icon")
	public WebElement hamburgericon;

	@AndroidFindBy(xpath = "//*[@text='Settings']")
	public WebElement settings;

	@AndroidFindBy(xpath = "//*[@text='Country & Language']")
	public WebElement countryandlanguage;

	@AndroidFindBy(xpath = "//*[@text='Country/Region: United States']")
	public WebElement countryusa;

	@AndroidFindBy(xpath = "//*[contains(@text, 'Australia Amazon.com.au')]")
	public WebElement countryaustralia;

	@AndroidFindBy(xpath = "//*[@text='Done']")
	public WebElement done;

	@AndroidFindBy(xpath = "//android.widget.EditText[@index='0']")
	public WebElement productsearchbox;

	@AndroidFindBy(xpath = "//*[@text='Search']")
	public WebElement productsearchtextbox;

	@AndroidFindBy(xpath = "//*[contains(@text, 'Samsung 65\"')]")
	public List<WebElement> lt;

	public HomeScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	public void countryselection() throws InterruptedException {
		hamburgericon.click();
		settings.click();
		countryandlanguage.click();
		countryusa.click();
		countryaustralia.click();
		Thread.sleep(2000);
		done.click();
		Thread.sleep(2000);
		log.debug("country selection");
	}

	public void searchproduct(String product) {
		productsearchbox.click();
		productsearchtextbox.sendKeys(product);
		((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		scroll("Next->");
		log.debug("search product");
	}

	public void productlist() throws InterruptedException {
		int count = lt.size();
		Random r = new Random();
		int linkNo = r.nextInt(count);
		MobileElement link = (MobileElement) lt.get(linkNo);
		Thread.sleep(2000);
		String RandomSearchPageProductName = link.getText().trim();
		System.out.println("RandomSearchPageProductName-" + RandomSearchPageProductName);
		link.click();
		log.debug("getting random 65 inch tv");

	}
}
