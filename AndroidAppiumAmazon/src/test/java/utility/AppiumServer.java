package utility;

import java.io.File;
import java.util.HashMap;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {
	
	public static AppiumDriverLocalService service;
	
	public static void start(){
		
		service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files (x86)\\Appium\\node.exe"))
						.withAppiumJS(new File("C:\\Program Files (x86)\\Appium\\node_modules\\appium\\bin\\appium.js"))
						.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\Appium.log")));

		service.start();
		
	}
	public static AppiumDriverLocalService startAppiumServer() {		
		HashMap<String, String> environment = new HashMap<String, String>();
		environment.put("ANDROID_HOME", "/Users/Jena/Library/Android/sdk");
		environment.put("JAVA_HOME", "/Library/Java/JavaVirtualMachines/jdk1.8.0_251.jdk/Contents/Home/bin/java");
		return AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("/usr/local/Cellar/node/13.12.0/bin/node"))
				.withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"))	
			     		.usingPort(4723)
						.withIPAddress("127.0.0.1").withArgument(GeneralServerFlag.SESSION_OVERRIDE)
						.withEnvironment(environment)

		);
	
		
	}
	
	public static void stop(){
		
		service.stop();
		
	}
}
