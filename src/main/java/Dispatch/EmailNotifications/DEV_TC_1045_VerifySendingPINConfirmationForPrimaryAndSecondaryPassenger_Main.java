package Dispatch.EmailNotifications;

import java.awt.Robot;
import java.util.List;
import common.TestBase;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.awt.event.KeyEvent;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.datatransfer.Clipboard;
import common.UpdateExtentReportResults;
import org.openqa.selenium.support.FindBy;
import java.awt.datatransfer.StringSelection;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;

public class DEV_TC_1045_VerifySendingPINConfirmationForPrimaryAndSecondaryPassenger_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	String testStatus;
	String scenario;
	String testStep;
	Boolean visibilityStatus;
	String screenshotPath;
	String exception;
	int indexCount = 1;

	@FindBy(xpath = "//b[contains(normalize-space(),'PIN')]")
	List<WebElement> pinNumber;

	@FindBy(xpath = "(//div[contains(normalize-space(),'Booking confirmation')])[2]")
	List<WebElement> mailSubject;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@title='Clear']")
	List<WebElement> clearBtn;

	LocalDate today;
	TestBase objTestBase;
	JavascriptExecutor js;
	GetCurrentDateTime getDate;
	UpdateExtentReportResults objupdateResults;

	public DEV_TC_1045_VerifySendingPINConfirmationForPrimaryAndSecondaryPassenger_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
			getDate = new GetCurrentDateTime();
			objupdateResults = new UpdateExtentReportResults(driver);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyEmailConfirmation(Boolean visibilityStatus, String vehicleType, String tripID)
			throws Exception {
		try {
			for (int i = 0; i <= 1; i++) {
				driver.get(prop.getProperty("yopmailURL"));
				objTestBase.defaultWaitTime(3000);
				driver.navigate().refresh();
				objTestBase.defaultWaitTime(2000);

				if (i == 0)
					scenario = "Primary Email";
				else
					scenario = "Secondary Email";

				utillLogger.info(getClass().getSimpleName() + " - DEV_TC_1045 Email = " + eMail);
				objTestBase.defaultWaitTime(2000);

				testStep = "Verification Email Notfication Received for Vehicle: " + vehicleType + " - " + scenario
						+ " of TripID = " + tripID;
				visibilityStatus = emailIDSerach(visibilityStatus, scenario, tripID);
				if (visibilityStatus.booleanValue() == true) {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "PASSED";
				} else {
					if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
					testStatus = "FAILED";
				}

				testStep = "Verification Email Notfication Received with PIN Number for Vehicle: " + vehicleType + " - "
						+ scenario + " of TripID = " + tripID;
				if (testStatus == "PASSED") {
					visibilityStatus = verificationOfPINConfirmationEmail(visibilityStatus, scenario, tripID);
					if (visibilityStatus.booleanValue() == true) {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						testStatus = "PASSED";
					} else {
						if (localExecutionFlag == true)	objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);	else	browserStackTestStatusUpdate("passed", testStep);
						testStatus = "FAILED";
					}
				} else {
					objupdateResults.updateResults(screenshotPath, logger, LogStatus.SKIP, testStep, exception);
					testStatus = "SKIPPED";
				}

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,150)", "");
				objTestBase.defaultWaitTime(2000);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			driver.get(prop.getProperty("yopmailURL"));
			objTestBase.defaultWaitTime(3000);
			driver.manage().window().maximize();
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);

		}
		return visibilityStatus;
	}

	public Boolean verificationOfPINConfirmationEmail(Boolean visibilityStatus, String scenario, String tripID)
			throws Exception {
		try {
			expected = driver.getCurrentUrl();
			action = new Actions(driver);
			if (expected.toLowerCase().contains("yopmail")) {
				defaultWaitTime(1000);
				driver.switchTo().frame("ifmail");
				objTestBase.defaultWaitTime(3000);
				StringSelection stringSelection = new StringSelection(tripID);
				Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				robot = new Robot();

				// ctrl+F
				robot.keyPress(KeyEvent.VK_CONTROL);
				Thread.sleep(500);
				robot.keyPress(KeyEvent.VK_F);
				Thread.sleep(500);
				// Releasing Ctrl and F key
				robot.keyRelease(KeyEvent.VK_F);
				Thread.sleep(500);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(2000);

				// ctrl+v
				robot.keyPress(KeyEvent.VK_CONTROL);
				Thread.sleep(500);
				robot.keyPress(KeyEvent.VK_V);
				Thread.sleep(500);
				robot.keyRelease(KeyEvent.VK_V);
				Thread.sleep(500);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(500);

				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(500);
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(500);

				robot.keyPress(KeyEvent.VK_ESCAPE);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
				Thread.sleep(500);

				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(500);
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(500);

				stringSelection = new StringSelection("PIN");
				clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				clipboard.setContents(stringSelection, null);
				// ctrl+F
				robot.keyPress(KeyEvent.VK_CONTROL);
				Thread.sleep(500);
				robot.keyPress(KeyEvent.VK_F);
				Thread.sleep(500);
				// Releasing Ctrl and F key
				robot.keyRelease(KeyEvent.VK_F);
				Thread.sleep(500);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(2000);
				// ctrl+v
				robot.keyPress(KeyEvent.VK_CONTROL);
				Thread.sleep(500);
				robot.keyPress(KeyEvent.VK_V);
				Thread.sleep(500);
				robot.keyRelease(KeyEvent.VK_V);
				Thread.sleep(500);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(500);
				// Enter
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(500);
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(500);
				// Escape
				robot.keyPress(KeyEvent.VK_ESCAPE);
				Thread.sleep(1000);
				robot.keyRelease(KeyEvent.VK_ESCAPE);
				Thread.sleep(500);

				if (pinNumber.size() != 0)
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

			driver.switchTo().defaultContent();
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
			driver.get(prop.getProperty("yopmailURL"));
			objTestBase.defaultWaitTime(3000);
			driver.manage().window().maximize();
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);

		}
		return visibilityStatus;
	}

	public Boolean emailIDSerach(Boolean visibilityStatus, String scenario, String tripID) throws Exception {
		action = new Actions(driver);
		try {
			if (scenario.contains("Primary"))
				eMail = prop.getProperty("dispatchadminMail");
			else
				eMail = prop.getProperty("spEmail");
			action = new Actions(driver);
			String[] tempEmail = eMail.toString().split("@");
			defaultWaitTime(1000);
			if (clearBtn.size() != 0) {
				if (clearBtn.get(0).isDisplayed()) {
					clearBtn.get(0).click();
					objTestBase.defaultWaitTime(1000);
				}
			}
			action.moveToElement(loginBtn).click().sendKeys(tempEmail[0]).build().perform();
			defaultWaitTime(2000);
			action.sendKeys(Keys.ENTER).build().perform();
			defaultWaitTime(2000);
			driver.navigate().refresh();
			defaultWaitTime(3000);
			visibilityStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
			driver.get(prop.getProperty("yopmailURL"));
			objTestBase.defaultWaitTime(3000);
			driver.manage().window().maximize();
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);

		}
		return visibilityStatus;
	}
}