package core;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	private static ExtentReports extent;

	private ExtentManager() {

	}

	public static ExtentReports getInstance() {

		Path extentPath = Paths.get(System.getProperty("user.dir"), "target", "extent-report", "extent.html");

		if (extent == null) {
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter(extentPath.toString());
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setDocumentTitle("CDR-2202");
			htmlReporter.config().setReportName("Alaska Trips Regression Suite");

			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);

			extent.setSystemInfo("Browser", Config.getBrowser());
			extent.setSystemInfo("Base URL", Config.getBaseUrl());
			extent.setSystemInfo("Execution Mode", Config.getExecutionMode());
			extent.setSystemInfo("Timeout", String.valueOf(Config.getTimeout()));
			extent.setSystemInfo("Headless", String.valueOf(Config.isHeadless()));
		}
		return extent;
	}

	public static void flush() {
		if (extent != null) {
			extent.flush();
		}
	}

}
