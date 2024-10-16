package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class CommonUtils {

	public static int IMPLICIT_WAIT_TIME;
	public static int EXPLICIT_WAIT_TIME;
	public static String BASE_PKG;
	public static String APP_PATH;
	public static String DEVICE_NAME;
	public static String APPIUM_PORT;
	public static URL serverUrl;
	

	private static Properties prop = new Properties();
	private static DesiredCapabilities capabilities = new DesiredCapabilities();

	private static AppiumDriver<MobileElement> driver;

	public static void loadAndroidConfProp(String propertyFileName) throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/test/resources/properties/" + propertyFileName);
		prop.load(fis);

		IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
		EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
		APP_PATH = prop.getProperty("application.path");
		BASE_PKG = prop.getProperty("base.pkg");
		DEVICE_NAME = prop.getProperty("device.name");
		APPIUM_PORT = prop.getProperty("appium.server.port");

	}

	public static void setAndroidCapabilities() {
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
		capabilities.setCapability("app", APP_PATH );	
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, BASE_PKG);
	}
		

	public static AppiumDriver<MobileElement> getAndroidDriver() throws MalformedURLException {

		serverUrl = new URL("http://localhost:" + APPIUM_PORT + "/wd/hub");
		driver = new AndroidDriver<MobileElement>(serverUrl, capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;

	}


}