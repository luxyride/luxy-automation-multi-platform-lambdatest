package Dispatch.Login;

import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DEV_TC_27_VerifyAvailablityOfButtons_NavigationLinksInHomePage_Main extends TestBase {

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
	WebElement newBookingTab;

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesSection;
	@FindBy(xpath = "(//span[normalize-space()='All'])[1]")
	WebElement ridesTabAll;
	@FindBy(xpath = "(//span[normalize-space()='in progress'])[1]")
	WebElement ridesTabInProgress;
	@FindBy(xpath = "(//span[normalize-space()='Upcoming'])[1]")
	WebElement ridesTabUpcoming;
	@FindBy(xpath = "(//span[normalize-space()='Available'])[1]")
	WebElement ridesTabAvailable;
	@FindBy(xpath = "(//span[normalize-space()='Cancelled'])[1]")
	WebElement ridesTabCancelled;
	@FindBy(xpath = "(//span[normalize-space()='Completed'])[1]")
	WebElement ridesTabCompleted;

	@FindBy(xpath = "(//span[normalize-space()='Corporate'])[1]")
	WebElement corporateTab;

	@FindBy(xpath = "//span[normalize-space()='Concierge']")
	WebElement conciergeTab;

	@FindBy(xpath = "(//span[normalize-space()='Passengers'])[1]")
	WebElement passengersTab;

	@FindBy(xpath = "(//span[normalize-space()='Affiliates'])[1]")
	WebElement affiliatesTab;

	@FindBy(xpath = "(//span[normalize-space()='Affiliate Leads'])[1]")
	WebElement affiliateLeadsTab;

	@FindBy(xpath = "(//span[normalize-space()='Drivers'])[1]")
	WebElement driversTab;

	@FindBy(xpath = "(//span[normalize-space()='Vehicles'])[1]")
	WebElement vehiclesTab;

	@FindBy(xpath = "(//span[normalize-space()='Vehicle Inventory'])[1]")
	WebElement vehicleInventoryTab;

	@FindBy(xpath = "(//span[normalize-space()='Pricing'])[1]")
	WebElement pricingSection;
	@FindBy(xpath = "(//span[normalize-space()='Region'])[1]")
	WebElement regionTab;
	@FindBy(xpath = "(//span[normalize-space()='Zone'])[1]")
	WebElement zoneTab;
	@FindBy(xpath = "(//span[normalize-space()='Region Fee'])[1]")
	WebElement regionFeeTab;
	@FindBy(xpath = "(//span[normalize-space()='Service Rate'])[1]")
	WebElement serviceRateTab;
	@FindBy(xpath = "(//span[normalize-space()='Promo Code'])[1]")
	WebElement promoCodeTab;

	@FindBy(xpath = "(//span[normalize-space()='Settings'])[1]")
	WebElement settingsSection;
	@FindBy(xpath = "(//span[normalize-space()='Users'])[1]")
	WebElement usersTab;
	@FindBy(xpath = "(//span[normalize-space()='Coverage Zones'])[1]")
	WebElement coverageZonesTab;
	@FindBy(xpath = "(//span[normalize-space()='Notifications'])[1]")
	WebElement notificationsTab;
	@FindBy(xpath = "(//span[normalize-space()='Special Events'])[1]")
	WebElement specialEventsTab;
	@FindBy(xpath = "(//span[normalize-space()='User Profile'])[1]")
	WebElement userProfileTab;

	@FindBy(xpath = "(//span[normalize-space()='Live Tracking'])[1]")
	WebElement liveTrackingTab;

	@FindBy(xpath = "(//span[normalize-space()='Entrepreneur'])[1]")
	WebElement entrepreneurTab;

	@FindBy(xpath = "(//span[normalize-space()='API'])[1]")
	WebElement manageAPIsTab;

	TestBase objTestBase;

	public DEV_TC_27_VerifyAvailablityOfButtons_NavigationLinksInHomePage_Main(WebDriver driver) {
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

	public Boolean visibilityOfRidesInprogressPage(Boolean visibilityStatus) {
		try {
			ridesTabInProgress.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("inprogress"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfRidesUpcomingPage(Boolean visibilityStatus) {
		try {
			ridesTabUpcoming.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("upcoming"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfRidesAvailablePage(Boolean visibilityStatus) {
		try {
			ridesTabAvailable.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("available"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfRidesCancelledPage(Boolean visibilityStatus) {
		try {
			ridesTabCancelled.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("canceled"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfRidesCompletedPage(Boolean visibilityStatus) {
		try {
			ridesTabCompleted.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("completed"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfCorporatePage(Boolean visibilityStatus) {
		try {
			corporateTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("corporate"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfConciergePage(Boolean visibilityStatus) {
		try {
			conciergeTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("concierge"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfPassengersPage(Boolean visibilityStatus) {
		try {
			passengersTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("customer"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfAffiliatePage(Boolean visibilityStatus) {
		try {
			affiliatesTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("affiliate"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfAffiliateLeadsTabPage(Boolean visibilityStatus) {
		try {
			affiliateLeadsTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("affiliate-leads"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfDriversTabPage(Boolean visibilityStatus) {
		try {
			driversTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("driver"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfVehicleTabPage(Boolean visibilityStatus) {
		try {
			vehiclesTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("vehicle"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfvehicleInventoryTabPage(Boolean visibilityStatus) {
		try {
			vehicleInventoryTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("vehicle-inventory"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickPricingSection() {
		try {
			pricingSection.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfRegionTabPage(Boolean visibilityStatus) {
		try {
			regionTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("region"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfZoneTabPage(Boolean visibilityStatus) {
		try {
			zoneTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("zone"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfRegionFeeTabPage(Boolean visibilityStatus) {
		try {
			regionFeeTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("manageregionfee"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfServiceRateTabPage(Boolean visibilityStatus) {
		try {
			serviceRateTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("manageservicerate"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfPromocodeTabPage(Boolean visibilityStatus) {
		try {
			promoCodeTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			objTestBase.defaultWaitTime(1000);
			if (expected.toLowerCase().contains("managepromocode"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSettingSection() {
		try {
			settingsSection.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfUsersTabPage(Boolean visibilityStatus) {
		try {
			usersTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("manage"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfCoveragezonesTabPage(Boolean visibilityStatus) {
		try {
			coverageZonesTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("coveragezones"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfUserProfileTabPage(Boolean visibilityStatus) {
		try {
			userProfileTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("profile"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfLiveTrackingTabPage(Boolean visibilityStatus) {
		try {
			liveTrackingTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("live-tracking"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfEntrepreneurTabPage(Boolean visibilityStatus) {
		try {
			entrepreneurTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("entrepreneur"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfManageAPIsPage(Boolean visibilityStatus) {
		try {
			manageAPIsTab.click();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("apis"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}
}
