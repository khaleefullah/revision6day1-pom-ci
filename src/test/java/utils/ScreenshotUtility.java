package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import core.DriverFactory;

public class ScreenshotUtility {

	public static String captureScreenshot(String testName) {

		Date d = new Date();
		String timeStamp = d.toString().replace(" ", "").replace(":", "").toUpperCase();
		String fileName = testName + "_" + timeStamp + ".png";
		Path filePath = Paths.get(System.getProperty("user.dir"), "target", "screenshots", fileName);

		TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(filePath.toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath.toString();
	}
}
