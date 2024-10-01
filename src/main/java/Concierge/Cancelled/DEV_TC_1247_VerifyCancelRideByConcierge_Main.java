package Concierge.Cancelled;

import java.util.Date;
import common.TestBase;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1247_VerifyCancelRideByConcierge_Main extends TestBase {

	TestBase objTestBase;
	String expected;
	Actions action;
	WebDriver driver;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement signInBtn;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[text() = 'New Booking'])[1]")
	WebElement newbooking;

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesSection;

	@FindBy(xpath = "(//span[text() = 'All'])[1]")
	WebElement ridesTabAll;

	@FindBy(xpath = "(//input[@type='text'])[4]")
	WebElement searchRideId;

	@FindBy(xpath = "//i[@title='Cancel Ride']")
	WebElement cancelRideBtn;

	@FindBy(xpath = "//*[text()='Review Cancel Ride']")
	WebElement reviewCancleRidePopup;

	@FindBy(xpath = "(//div[@class='form-group input group']//select[@class='form-control'])[1]")
	WebElement reasonForCancellation;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement cancelContinueBtn;

	@FindBy(xpath = "//*[text()='Confirm Cancel Ride']")
	WebElement confirmCancleRidePopup;

	@FindBy(xpath = "//button[text()='Confirm']")
	WebElement cancelRideConfirmBtn;

	@FindBy(xpath = "//td[text()='Cancelled']")
	WebElement cancelStatusLbl;

	@FindBy(xpath = "//td[@tabindex='3']")
	WebElement rideStatusConcierge;

	@FindBy(xpath = "//td[@tabindex='6']")
	WebElement ridePlaceDateTimeConcierge;

	@FindBy(xpath = "//td[@tabindex='7']")
	WebElement bookingRideTripIdConcierge;

	@FindBy(xpath = "//td[@tabindex='11']//div")
	WebElement bookedPassengerNameConcierge;

	@FindBy(xpath = "//td[@tabindex='13']")
	WebElement vehicleTypeConcierge;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

	Date date;
	SimpleDateFormat formatDate;
	String currDate;

	public DEV_TC_1247_VerifyCancelRideByConcierge_Main(WebDriver driver) {
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
			action = new Actions(driver);
			action.moveToElement(signInBtn).click().build().perform();
			objTestBase.defaultWaitTime(3000);
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
			searchRideId.click();
			searchRideId.sendKeys(tripID);
			objTestBase.defaultWaitTime(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyEDITRideDetailsPage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("bookingedit"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnCancelRide() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(cancelRideBtn).click().build().perform();
			objTestBase.defaultWaitTime(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfReviewCancleRidepopup(Boolean visibilityStatus) {
		try {
			if (reviewCancleRidePopup.isDisplayed()) {
				Select select = new Select(reasonForCancellation);
				select.selectByValue("Client change of plans");
				objTestBase.defaultWaitTime(2000);
				cancelContinueBtn.click();
				objTestBase.defaultWaitTime(2000);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfConfirmCancleRidepopup(Boolean visibilityStatus) {
		try {
			if (confirmCancleRidePopup.isDisplayed()) {
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfCancelRideConfirmationMsg(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(cancelRideConfirmBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			String msgText = "";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
			if (displayStatus.isDisplayed()) {
				objTestBase.defaultWaitTime(500);
				msgText = alertMessge.getText().toLowerCase();
				visibilityStatus = true;
			} else
				visibilityStatus = false;
			objTestBase.defaultWaitTime(1000);
			if (visibilityStatus == true && msgText.contains("successfully"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
			System.out.println(msgText);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfNoRidesFoundWithCancelledID(Boolean visibilityStatus, String tripID) {
		try {
			objTestBase.defaultWaitTime(1000);
			searchRideId.click();
			searchRideId.sendKeys(tripID);
			objTestBase.defaultWaitTime(3000);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(cancelStatusLbl));

			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean validateTripIDDetails(Boolean visibilityStatus) {
		try {
			// Get the CurrentDate:
			currDate = getCurrDate(currDate);

			System.out.println(rideStatusConcierge.getText().toLowerCase());
			System.out.println(bookedPassengerNameConcierge.getText().toLowerCase());
			System.out.println(ridePlaceDateTimeConcierge.getText().toLowerCase());

			if ((!rideStatusConcierge.getText().toLowerCase().contains("cancelled")
					|| !rideStatusConcierge.getText().toLowerCase().contains("completed"))
					&& bookedPassengerNameConcierge.getText().toLowerCase().contains("qa"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public String getCurrDate(String currDate) {
		try {
			date = new Date();
			formatDate = new SimpleDateFormat("MM-dd-yyyy");
			currDate = formatDate.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return currDate;
	}
}