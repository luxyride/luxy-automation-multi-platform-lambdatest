package Dispatch.EmailNotifications;

import java.awt.Robot;
import common.TestBase;
import java.awt.Toolkit;
import java.time.Duration;
import java.util.List;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.datatransfer.Clipboard;
import org.openqa.selenium.support.FindBy;
import java.awt.datatransfer.StringSelection;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1048_VerifyPINConfirmationEmailToUsingResendBookingConfirmationEmail_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	TestBase objTestBase;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newBookingTab;

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesSection;

	@FindBy(xpath = "(//span[normalize-space()='All'])[1]")
	WebElement ridesTabAll;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchRideId;

	@FindBy(xpath = "//i[@title='Resend Booking Confirmation']")
	WebElement resendEmailConfirmation;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[@title='Clear']")
	List<WebElement> clearBtn;

	@FindBy(xpath = "//b[contains(normalize-space(),'PIN')]")
	List<WebElement> pinNumber;

	@FindBy(xpath = "(//div[contains(normalize-space(),'Booking confirmation')])[2]")
	List<WebElement> mailSubject;

	public DEV_TC_1048_VerifyPINConfirmationEmailToUsingResendBookingConfirmationEmail_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void eyeIconClick() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIcon).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public Boolean visibilityOfSigninButton(Boolean visibilityStatus) {
		try {
			if (signInBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return visibilityStatus;
	}

	public void clickSigninButton() {
		try {
			signInBtn.click();
			// Validate Dispatch 2fa Authentication:
//			Boolean visibilityStatus = false;
//			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
//			utillLogger.info(
//					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean visibilityOfLoggedinUser(Boolean visibilityStatus) {
		try {
			waitTimeForElement(signinUser);
			if (signinUser.isDisplayed()) {
				expected = signinUser.getText();
				if (expected.toLowerCase().contains("welcome")) {
					visibilityStatus = true;
				} else {
					visibilityStatus = false;
				}
			} else {
				visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfNewBookingPage(Boolean visibilityStatus) {
		try {
			newBookingTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("booking"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickRidesSection() {
		try {
			ridesSection.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfRidesAllPage(Boolean visibilityStatus) {
		try {
			ridesTabAll.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("all"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void searchRideId(String tripID) {
		try {
			action = new Actions(driver);
			searchRideId.click();
			objTestBase.defaultWaitTime(1000);
			searchRideId.sendKeys(Keys.CONTROL + "A");
			searchRideId.sendKeys(Keys.DELETE);
			objTestBase.defaultWaitTime(1000);
			searchRideId.sendKeys(tripID);
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyResendEmailConfirmationBtn(Boolean visibilityStatus) {
		try {
			resendEmailConfirmation.click();
			objTestBase.defaultWaitTime(1000);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));

			if (displayStatus.isDisplayed() && alertMessge.getText().toString().toLowerCase().contains("successfully"))
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return visibilityStatus;
	}

	public String emailIDSerach(String scenario, String eMail, String tripID) {
		action = new Actions(driver);
		try {
			if (scenario.contains("Primary"))
				eMail = prop.getProperty("dispatchadminMail");
			else
				eMail = prop.getProperty("spEmail");
			System.out.println("DEV_TC_1048_Email = " + eMail);
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
			action.sendKeys(Keys.ENTER).build().perform();
			defaultWaitTime(2000);
			driver.navigate().refresh();
			defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eMail;
	}

	public Boolean verificationOfPINConfirmationEmail(Boolean visibilityStatus, String tripID) {
		try {
			expected = driver.getCurrentUrl();
			action = new Actions(driver);
			if (expected.toLowerCase().contains("yopmail")) {
				defaultWaitTime(1000);
				driver.switchTo().frame("ifmail");
				if (mailSubject.size() > 1) {
					if (mailSubject.get(1).isDisplayed() && mailSubject.get(1).getText().contains(tripID))
						visibilityStatus = true;
				} else {
					if (mailSubject.get(0).isDisplayed() && mailSubject.get(0).getText().contains(tripID))
						visibilityStatus = true;
				}

				objTestBase.defaultWaitTime(1000);

				StringSelection stringSelection = new StringSelection("PIN");
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
		}
		return visibilityStatus;
	}
}
