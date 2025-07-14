package UserPortal.CorporateTransport;

import java.util.Iterator;
import java.util.Set;
import common.TestBase;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1835_VerifyTheAvailabilityOfTryLuxyForCorporateTransportButtonInCorporateTransportPage_Main
		extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	JavascriptExecutor js;
	TestBase objTestBase;

	@FindBy(xpath = "(//a[normalize-space()='Corporate Program'])[1]")
	WebElement corporateBtnNormalView;

	@FindBy(xpath = "(//a[normalize-space()='Corporate Program'])[1]")
	WebElement corporateBtnSimulatorView;

	@FindBy(xpath = "//a[normalize-space()='Corporate']")
	WebElement corporate;

	@FindBy(xpath = "(//a[@aria-label='Link for Try LUXY for Corporate Travel'])[1]")
	WebElement corporateSignup;

	@FindBy(xpath = "//input[@id='companyName']")
	WebElement companyName;

	public DEV_TC_1835_VerifyTheAvailabilityOfTryLuxyForCorporateTransportButtonInCorporateTransportPage_Main(
			WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Boolean visibilityOfCorporateTransport(Boolean visibilityStatus, String viewName) {
		try {
			if (viewName.equalsIgnoreCase("simulatorView")) {
				if (corporateBtnSimulatorView.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else {
				if (corporateBtnNormalView.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void clickOnCorporate(String viewName) {
		try {
			action = new Actions(driver);
			if (viewName.equalsIgnoreCase("simulatorView")) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", corporateBtnSimulatorView);
				js.executeScript("window.scrollBy(0,-100)", "");
				action.moveToElement(corporateBtnSimulatorView).click().build().perform();
			} else {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView(true);", corporateBtnNormalView);
				js.executeScript("window.scrollBy(0,-100)", "");
				action.moveToElement(corporateBtnNormalView).click().build().perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyCorporatePage(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains(prop.getProperty("environment"))
					&& expected.toLowerCase().contains("corporate")) {
				js.executeScript("arguments[0].scrollIntoView(true);", corporateSignup);
				js.executeScript("window.scrollBy(0,-100)", "");
				if (corporateSignup.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfCorporateRegistrationForm(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", companyName);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (companyName.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void clickOnEnrollCorporateBtn() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", corporateSignup);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(corporateSignup).click().build().perform();
			defaultWaitTime(3000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
