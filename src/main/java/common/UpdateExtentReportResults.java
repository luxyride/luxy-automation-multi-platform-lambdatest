package common;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UpdateExtentReportResults extends TestBase {

	private WebDriver driver;
	private int i = 0;

	public UpdateExtentReportResults(WebDriver driver) {
		this.driver = driver;
	}

	public void updateResults(String screenshotPath, ExtentTest logger, LogStatus status, String testStep,
			String exception) throws Exception {
		if (exception == "" || exception == null) {
			screenshotPath = getScreenshot(driver, "temp_" + i);
			logger.log(status, testStep + "\n" + logger.addScreenCapture(screenshotPath));
			i++;
		} else {
			screenshotPath = getScreenshot(driver, "temp_" + i);
			logger.log(status, testStep + "\n" + logger.addScreenCapture(screenshotPath));
			logger.log(status, testStep + "\n" + exception);
			i++;
		}
	}
}
