package TravelAgent.Passengers;

import common.TestBase;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1255_VerifyAbilityToViewProfileFeaturesUnderActionsInManagePassengerPage_Main extends TestBase {

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

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement firstName;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbooking;

	@FindBy(xpath = "(//span[normalize-space()='Passengers'])[1]")
	WebElement passengerTab;

	@FindBy(xpath = "//*[@placeholder='Search']")
	WebElement searchPassenger;

	@FindBy(xpath = "//*[@title='Passenger Profile']")
	WebElement passengerProfile;

	@FindBy(xpath = "(//*[normalize-space()='Upcoming Trips'])[1]")
	WebElement upcomingTrips;

	@FindBy(xpath = "(//*[normalize-space()='Past Trips'])[1]")
	WebElement pastTrips;

	@FindBy(xpath = "//button[normalize-space()='Back']")
	WebElement backBtn;

	TestBase objTestBase;

	public DEV_TC_1255_VerifyAbilityToViewProfileFeaturesUnderActionsInManagePassengerPage_Main(WebDriver driver) {
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
			eMailInput.sendKeys(prop.getProperty("travelAgentEMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("travelAgentPwd"));
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

	public void clickOnPassengerTab() {
		try {
			action = new Actions(driver);
			action.moveToElement(passengerTab).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfManagePassengerPage(Boolean visibilityStatus) {
		try {
			if (searchPassenger.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean searchPassenger(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(searchPassenger).click().sendKeys(prop.getProperty("taPassengerEMail")).build()
					.perform();
			defaultWaitTime(2000);
			action.sendKeys(Keys.ENTER).build().perform();
			defaultWaitTime(500);
			action.sendKeys(Keys.TAB).build().perform();
			defaultWaitTime(500);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
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

	public void clickSigninButton() {
		try {
			signInBtn.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfPassengerProfileButton(Boolean visibilityStatus) {
		try {
			if (passengerProfile.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfPassengerProfilePage(Boolean visibilityStatus) {
		try {
			passengerProfile.click();
			defaultWaitTime(2000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(upcomingTrips));
			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfUpcomingTripsTab(Boolean visibilityStatus) {
		try {
			upcomingTrips.click();
			defaultWaitTime(1000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(upcomingTrips));
			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfPastTripsTab(Boolean visibilityStatus) {
		try {
			pastTrips.click();
			defaultWaitTime(2000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(pastTrips));
			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyProfilePageBackBtnFunctionality(Boolean visibilityStatus) {
		try {
			backBtn.click();
			defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.contains("manage"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}
}
