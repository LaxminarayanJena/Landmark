package utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import base.TestBase;

public class TestUtil extends TestBase {

	public static String destDir;
	public static DateFormat dateFormat;
	public static String destFile;

	public static void takeScreenShot() throws IOException {

		destDir = System.getProperty("user.dir") + "/test-output/html/screenshots";
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
		new File(destDir).mkdir();
		destFile = dateFormat.format(new Date()) + ".png";
		FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));

	}

	@DataProvider
	public static Object[][] getData(String sheetName) {

		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rows - 1][cols];
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}

		return data;

	}
}
