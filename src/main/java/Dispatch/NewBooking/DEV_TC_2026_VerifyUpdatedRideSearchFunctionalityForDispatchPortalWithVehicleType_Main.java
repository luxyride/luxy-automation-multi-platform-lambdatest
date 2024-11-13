package Dispatch.NewBooking;

import java.util.Map;
import java.util.Date;
import java.util.List;
import common.TestBase;
import java.util.Locale;
import java.util.TimeZone;
import java.time.Duration;
import java.util.Calendar;
import java.time.LocalDate;
import java.time.LocalTime;
import java.text.DateFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import common.UpdateExtentReportResults;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_2026_VerifyUpdatedRideSearchFunctionalityForDispatchPortalWithVehicleType_Main extends TestBase {

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

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement signInBtn_Login;

	@FindBy(xpath = "//button[@class='accoutBtn dropdown-toggle']")
	WebElement signInBtnDropdown;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newBookingTab;

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement rideTab;

	@FindBy(xpath = "(//span[normalize-space()='All'])[1]")
	List<WebElement> allRides;

	@FindBy(xpath = "(//span[normalize-space()='in progress'])[1]")
	List<WebElement> inProgress;

	@FindBy(xpath = "(//span[normalize-space()='Upcoming'])[1]")
	List<WebElement> upComing;

	@FindBy(xpath = "(//span[normalize-space()='Available'])[1]")
	List<WebElement> available;

	@FindBy(xpath = "(//span[normalize-space()='Cancelled'])[1]")
	List<WebElement> cancelled;

	@FindBy(xpath = "(//span[normalize-space()='Completed'])[1]")
	List<WebElement> completed;

	@FindBy(xpath = "//input[@placeholder='Search']")
	List<WebElement> searchBox;

	@FindBy(xpath = "//th[@title='Vehicle Type']//following::tr//following::tr//td[12]")
	List<WebElement> vehicleTypeWithIndex12; // Available:

	@FindBy(xpath = "//th[@title='Vehicle Type']//following::tr//following::tr//td[14]")
	List<WebElement> vehicleTypeWithIndex14; // Cancelled:

	@FindBy(xpath = "//th[@title='Vehicle Type']//following::tr//following::tr//td[15]")
	List<WebElement> vehicleTypeWithIndex15;

	@FindBy(xpath = "//td[normalize-space()='There is no data to display']")
	List<WebElement> noDataFoundTextMsg;

	LocalDate today;
	TestBase objTestBase;
	JavascriptExecutor js;
	GetCurrentDateTime getDate;
	UpdateExtentReportResults objupdateResults;

	public DEV_TC_2026_VerifyUpdatedRideSearchFunctionalityForDispatchPortalWithVehicleType_Main(WebDriver driver) {
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

	public void eMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
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
			if (signInBtn_Login.isDisplayed())
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
			action.moveToElement(signInBtn_Login).click().build().perform();
			// Validate Dispatch 2fa Authentication:
			Boolean visibilityStatus = false;
			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
			utillLogger.info(
					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUser(Boolean visibilityStatus) {
		try {
			objTestBase.defaultWaitTime(2000);
			if (signInBtnDropdown.isDisplayed()) {
				expected = signInBtnDropdown.getText();
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

	public Boolean visibilitOfNewBookingTab(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(newBookingTab).click().build().perform();
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

	public Boolean verifyNavigationOfAllRidesPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			if (allRides.size() != 0 && allRides.get(0).isDisplayed())
				action.moveToElement(allRides.get(0)).click().build().perform();
			else {
				action.moveToElement(rideTab).click().build().perform();
				objTestBase.defaultWaitTime(3000);
				action.moveToElement(allRides.get(0)).click().build().perform();
			}
			objTestBase.defaultWaitTime(3000);
			if (searchBox.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyNavigationOfINPROGRESSPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			if (inProgress.size() != 0 && inProgress.get(0).isDisplayed())
				action.moveToElement(inProgress.get(0)).click().build().perform();
			else {
				action.moveToElement(rideTab).click().build().perform();
				objTestBase.defaultWaitTime(3000);
				action.moveToElement(inProgress.get(0)).click().build().perform();
			}
			objTestBase.defaultWaitTime(3000);
			if (searchBox.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyNavigationOfUPCOMINGPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			if (upComing.size() != 0 && upComing.get(0).isDisplayed())
				action.moveToElement(upComing.get(0)).click().build().perform();
			else {
				action.moveToElement(rideTab).click().build().perform();
				objTestBase.defaultWaitTime(3000);
				action.moveToElement(upComing.get(0)).click().build().perform();
			}
			objTestBase.defaultWaitTime(3000);
			if (searchBox.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyNavigationOfAVAILABLEPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			if (available.size() != 0 && available.get(0).isDisplayed())
				action.moveToElement(available.get(0)).click().build().perform();
			else {
				action.moveToElement(rideTab).click().build().perform();
				objTestBase.defaultWaitTime(3000);
				action.moveToElement(available.get(0)).click().build().perform();
			}
			objTestBase.defaultWaitTime(3000);
			if (searchBox.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyNavigationOfCancelledPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			if (cancelled.size() != 0 && cancelled.get(0).isDisplayed())
				action.moveToElement(cancelled.get(0)).click().build().perform();
			else {
				action.moveToElement(rideTab).click().build().perform();
				objTestBase.defaultWaitTime(3000);
				action.moveToElement(cancelled.get(0)).click().build().perform();
			}
			objTestBase.defaultWaitTime(3000);

			if (searchBox.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyNavigationOfCompletedPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			if (completed.size() != 0 && completed.get(0).isDisplayed())
				action.moveToElement(completed.get(0)).click().build().perform();
			else {
				action.moveToElement(rideTab).click().build().perform();
				objTestBase.defaultWaitTime(3000);
				action.moveToElement(completed.get(0)).click().build().perform();
			}
			objTestBase.defaultWaitTime(3000);

			if (searchBox.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifySearchWithVehicleType(String scenario, String pageName, Boolean visibilityStatus) {
		try {
			if (searchBox.size() != 0) {
				action = new Actions(driver);
				searchBox.get(0).click();
				objTestBase.defaultWaitTime(1000);
				searchBox.get(0).sendKeys(Keys.CONTROL + "A");
				searchBox.get(0).sendKeys(Keys.DELETE);
				objTestBase.defaultWaitTime(2000);
				action.moveToElement(searchBox.get(0)).sendKeys(scenario).build().perform();
				objTestBase.defaultWaitTime(6000);

				if (pageName == "AVAILABLE") {
					if (vehicleTypeWithIndex12.size() != 0) {
						for (WebElement element : vehicleTypeWithIndex12) {
							System.out.println("Page Name = " + pageName + " - " + "Vehicle Type = "
									+ element.getText().toLowerCase());
							if (element.getText().toLowerCase() == scenario.toLowerCase())
								visibilityStatus = true;
							else if (element.getText().toLowerCase().contains(scenario.toLowerCase()))
								visibilityStatus = true;
							else {
								visibilityStatus = false;
								break;
							}
						}
					} else if (noDataFoundTextMsg.size() != 0)
						visibilityStatus = true;
				} else if (pageName == "CANCELLED") {
					if (vehicleTypeWithIndex14.size() != 0) {
						for (WebElement element : vehicleTypeWithIndex14) {
							System.out.println("Page Name = " + pageName + " - " + "Vehicle Type = "
									+ element.getText().toLowerCase());
							if (element.getText().toLowerCase() == scenario.toLowerCase())
								visibilityStatus = true;
							else if (element.getText().toLowerCase().contains(scenario.toLowerCase()))
								visibilityStatus = true;
							else {
								visibilityStatus = false;
								break;
							}
						}
					} else if (noDataFoundTextMsg.size() != 0)
						visibilityStatus = true;
				} else {
					if (vehicleTypeWithIndex15.size() != 0) {
						for (WebElement element : vehicleTypeWithIndex15) {
							System.out.println("Page Name = " + pageName + " - " + "Vehicle Type = "
									+ element.getText().toLowerCase());
							if (element.getText().toLowerCase() == scenario.toLowerCase())
								visibilityStatus = true;
							else if (element.getText().toLowerCase().contains(scenario.toLowerCase()))
								visibilityStatus = true;
							else {
								visibilityStatus = false;
								break;
							}
						}
					} else if (noDataFoundTextMsg.size() != 0)
						visibilityStatus = true;
				}

			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

}
