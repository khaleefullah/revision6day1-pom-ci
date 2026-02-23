package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import core.ExtentManager;
import core.ExtentTestManager;
import utils.ScreenshotUtility;

public class CustomListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		ExtentManager.getInstance();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentTestManager.setTest(ExtentManager.getInstance().createTest(result.getName()));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentTestManager.getTest().log(Status.PASS, "Test is passed");
		ExtentTestManager.unload();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String screenPath = ScreenshotUtility.captureScreenshot(result.getName());
		ExtentTestManager.getTest().log(Status.FAIL, "Test is failed");
		ExtentTestManager.getTest().addScreenCaptureFromPath(screenPath);
		ExtentTestManager.unload();
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentTestManager.getTest().log(Status.SKIP, "Test is skipped");
		ExtentTestManager.unload();
	}

	@Override
	public void onFinish(ITestContext context) {
		ExtentManager.flush();
	}

}
