package Concierge.Profile;

import common.TestBase;
import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.ElementNotInteractableException;

public class DEV_TC_362_VerifyValidationFieldForPhoneNumber_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

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
	WebElement newbooking;

	@FindBy(xpath = "//a[normalize-space()='Profile']")
	WebElement profileTab;

	@FindBy(xpath = "//button[contains(text(),'Edit Profile')]")
	WebElement editProfileBtn;

	@FindBy(xpath = "(//input[@type='tel'])[1]")
	WebElement phoneNumber;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateBtn;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//div[normalize-space()='9999999999']")
	WebElement tempPhoneNumber;

	TestBase objTestBase;

	public DEV_TC_362_VerifyValidationFieldForPhoneNumber_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("conciergeadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("conciergePwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eyeIconClick() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIcon).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSigninButton(Boolean visibilityStatus) {
		try {
			if (signInBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSigninButton() {
		try {
			signInBtn.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickNewBooking() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(newbooking).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
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

	public Boolean verifyProfilePage(Boolean visibilityStatus) {
		try {
			if (signinUser.isDisplayed()) {
				signinUser.click();
				defaultWaitTime(1000);
				profileTab.click();
				defaultWaitTime(2000);
				expected = driver.getCurrentUrl();
				if (expected.toLowerCase().contains("profile")) {
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

	public Boolean validationOfPhoneNumber(Boolean visibilityStatus) {
		try {
			Boolean validateStatus = false;
			if (editProfileBtn.isDisplayed()) {
				editProfileBtn.click();
				defaultWaitTime(3000);
				js = (JavascriptExecutor) driver;
				
				objTestBase.defaultWaitTime(2000);

				// Verify thru Exception Handle:
				action = new Actions(driver);
				String actualPhoneNumber = phoneNumber.getAttribute("value"); // 9912345678

				// Validate Negative Scenarios:
				for (int i = 0; i <= 1; i++) {
					phoneNumber.click();
					objTestBase.defaultWaitTime(500);
					phoneNumber.sendKeys(Keys.CONTROL + "A");
					phoneNumber.sendKeys(Keys.DELETE);
					objTestBase.defaultWaitTime(1000);
					if (i == 0)
						phoneNumber.sendKeys("6* 81067377416");
					else
						phoneNumber.sendKeys("7* 80808080800080808");
					objTestBase.defaultWaitTime(1000);
					phoneNumber.sendKeys(Keys.ENTER);
					phoneNumber.sendKeys(Keys.TAB);
					String tempVal = phoneNumber.getAttribute("value");
					if (!tempVal.contains("* "))
						validateStatus = true;
					else
						validateStatus = false;
				}

				objTestBase.defaultWaitTime(500);
				phoneNumber.click();
				objTestBase.defaultWaitTime(1000);
				phoneNumber.sendKeys(Keys.CONTROL + "A");
				phoneNumber.sendKeys(Keys.DELETE);
				objTestBase.defaultWaitTime(1000);
				phoneNumber.sendKeys("9999999999");
				objTestBase.defaultWaitTime(500);
				updateBtn.click();
				objTestBase.defaultWaitTime(3000);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));

				if (displayStatus.isDisplayed() && alertMessge.getText().toLowerCase().contains("successfully")) {
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(3000);
					if (actualPhoneNumber != tempPhoneNumber.getText())
						visibilityStatus = true;
					else
						visibilityStatus = false;
				} else
					visibilityStatus = false;
				objTestBase.defaultWaitTime(1000);

				// Revert back to Original Phone Number:
				if (visibilityStatus == true) {
					driver.navigate().refresh();
					objTestBase.defaultWaitTime(1000);
					editProfileBtn.click();
					defaultWaitTime(3000);
					js = (JavascriptExecutor) driver;
					
					objTestBase.defaultWaitTime(2000);

					phoneNumber.click();
					objTestBase.defaultWaitTime(500);
					phoneNumber.sendKeys(Keys.CONTROL + "A");
					phoneNumber.sendKeys(Keys.DELETE);
					objTestBase.defaultWaitTime(1000);
					phoneNumber.sendKeys(actualPhoneNumber);
					objTestBase.defaultWaitTime(500);
					updateBtn.click();
					objTestBase.defaultWaitTime(3000);

					wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));

					if (displayStatus.isDisplayed() && alertMessge.getText().toLowerCase().contains("successfully"))
						visibilityStatus = true;
					else
						visibilityStatus = false;
					objTestBase.defaultWaitTime(1000);
				}
				visibilityStatus = true;
			} else
				visibilityStatus = false;

			if (validateStatus != true) // Set the status to FALSE if Negative Scenarios Failed:
				visibilityStatus = false;
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
			visibilityStatus = true;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}
}