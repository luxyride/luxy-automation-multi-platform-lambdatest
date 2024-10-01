package Dispatch.Affiliate;

import java.util.List;
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

public class DEV_TC_1824_VerifyTheFunctionalityOfActiveAndInactiveCoverageZonesInAffiliatePortal_Main extends TestBase {

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

	@FindBy(xpath = "(//span[normalize-space()='Settings'])[1]")
	WebElement settingsTab;

	@FindBy(xpath = "(//span[normalize-space()='Coverage Zones'])[1]")
	WebElement coverageZonesPage;

	@FindBy(xpath = "(//input[@placeholder='Search'])[1]")
	WebElement searchCoverageZone;

	@FindBy(xpath = "//td[normalize-space()='There is no data to display']")
	List<WebElement> noDataMsg;

	@FindBy(xpath = "//a[normalize-space()='Inactive Affiliates']")
	WebElement inActiveTab;

	@FindBy(xpath = "//i[@title='Affiliate Payment']")
	WebElement affiliatePaymentBtn;

	@FindBy(xpath = "(//i[@title='Edit Affiliate User'])[1]")
	WebElement editBtn;

	@FindBy(xpath = "(//img[@title='Reset Password'])[1]")
	WebElement resetPasswordBtn;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement deleteBtn;

	@FindBy(xpath = "(//i[@title='Affiliate Profile'])[1]")
	WebElement profileBtn;

	@FindBy(xpath = "(//*[@title='Edit Affiliate User'])[1]")
	List<WebElement> editAffiliateIcon;

	@FindBy(xpath = "//button[normalize-space()='Add Coverage Zone']")
	List<WebElement> addCoverzoneBtn;

	@FindBy(xpath = "//input[@placeholder='Search Zone']")
	List<WebElement> searchZone;

	@FindBy(xpath = "(//input[@placeholder='Search Zone']//following::ul//li)[1]")
	List<WebElement> searchZoneValue;

	@FindBy(xpath = "//i[@title='Deactivate']")
	List<WebElement> deactiveCoverzone;

	@FindBy(xpath = "//button[text()='Add']")
	WebElement addBtn;

	@FindBy(xpath = "(//*[(@role='alert')])[1]")
	WebElement alertMessge;

	@FindBy(xpath = "//button[text()='Yes']")
	WebElement yesBtn;

	@FindBy(xpath = "//button[text()='No']")
	WebElement noBtn;

	@FindBy(xpath = "//a[normalize-space()='Inactive Coverage Zones']")
	WebElement inactiveCoverageZonesTab;

	TestBase objTestBase;

	public DEV_TC_1824_VerifyTheFunctionalityOfActiveAndInactiveCoverageZonesInAffiliatePortal_Main(WebDriver driver) {
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
			eMailInput.sendKeys(prop.getProperty("affiliatEMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("affiliatePwd"));
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
		} catch (Exception e) {
			e.printStackTrace();
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

	public Boolean verifySettingsPageNavigationTab(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(settingsTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			visibilityStatus = true;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyCoverageZonesPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(coverageZonesPage).click().build().perform();
			objTestBase.defaultWaitTime(5000);

			expected = driver.getCurrentUrl();
			objTestBase.defaultWaitTime(1000);
			if (expected.toLowerCase().contains("coveragezones"))
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean selectCoverageZone(Boolean visibilityStatus) {
		try {
			searchCoverageZone.sendKeys(prop.getProperty("JFK"));
			defaultWaitTime(5000);
			waitTimeForElement(editAffiliateIcon.get(0));
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
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean editAffiliatePageNavigation(Boolean visibilityStatus) {
		try {
			editAffiliateIcon.get(0).click();
			defaultWaitTime(5000);
			String temp = driver.getCurrentUrl();
			if (temp.contains("edit")) {
				js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView();", addCoverzoneBtn.get(0));
				js.executeScript("window.scrollBy(0,-100)", "");
				objTestBase.defaultWaitTime(2000);
				visibilityStatus = true;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyAddCoverzonePopupDisplay(Boolean visibilityStatus) {
		try {
			addCoverzoneBtn.get(0).click();
			defaultWaitTime(1000);
			waitTimeForElement(searchZone.get(0));
			if (addCoverzoneBtn.size() != 0)
				visibilityStatus = verifyAddCoverzone(visibilityStatus);
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyAddCoverzone(Boolean visibilityStatus) {
		try {
			defaultWaitTime(3000);
			searchZone.get(0).sendKeys("JFK");
			defaultWaitTime(5000);
			waitTimeForElement(searchZoneValue.get(0));
			if (searchZoneValue.size() != 0) {
				searchZoneValue.get(0).click();
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyAddCoverzoneSelectValueFromDropdown(Boolean visibilityStatus) {
		try {
			searchZone.get(0).click();
			defaultWaitTime(3000);
			waitTimeForElement(searchZoneValue.get(0));
			if (searchZoneValue.size() != 0) {
				searchZoneValue.get(0).click();
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean addCoverzoneConfirmationMsg(Boolean visibilityStatus) {
		try {
			String msgText = "";
			action = new Actions(driver);
			action.moveToElement(addBtn).click().build().perform();

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
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean searchCoverzone(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", searchCoverageZone);
			js.executeScript("window.scrollBy(0,-100)", "");
			objTestBase.defaultWaitTime(2000);

			searchCoverageZone.click();
			defaultWaitTime(3000);
			searchCoverageZone.sendKeys("JFK");
			defaultWaitTime(5000);
			if (deactiveCoverzone.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean deactivateAddedCoverzone(Boolean visibilityStatus) {
		try {
			deactiveCoverzone.get(0).click();
			defaultWaitTime(5000);
			if (yesBtn.isDisplayed() && noBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean deactivateAddedCoverzoneConfirmation(Boolean visibilityStatus) {
		try {
			String msgText = "";
			action = new Actions(driver);
			action.moveToElement(yesBtn).click().build().perform();

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
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean searchDeactivatedCoverzoneFromActiveCoverageZonesTab(Boolean visibilityStatus) {
		try {
			defaultWaitTime(8000);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", searchCoverageZone);
			js.executeScript("window.scrollBy(0,-100)", "");
			objTestBase.defaultWaitTime(2000);

			searchCoverageZone.click();
			defaultWaitTime(3000);
			searchCoverageZone.sendKeys("JFK");
			defaultWaitTime(3000);
			if (deactiveCoverzone.size() == 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean searchDeactivatedCoverzoneFromInActiveCoverageZonesTab(Boolean visibilityStatus) {
		try {
			defaultWaitTime(3000);
			inactiveCoverageZonesTab.click();
			defaultWaitTime(3000);
			searchCoverageZone.sendKeys("JFK");
			defaultWaitTime(3000);
			if (deactiveCoverzone.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

}
