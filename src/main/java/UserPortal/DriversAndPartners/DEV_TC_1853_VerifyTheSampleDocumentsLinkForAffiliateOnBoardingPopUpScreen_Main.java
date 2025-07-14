package UserPortal.DriversAndPartners;

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

public class DEV_TC_1853_VerifyTheSampleDocumentsLinkForAffiliateOnBoardingPopUpScreen_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	JavascriptExecutor js;
	TestBase objTestBase;

	@FindBy(xpath = "(//a[normalize-space()='Supply Partners'])[1]")
	WebElement affiliate_NormalView;

	@FindBy(xpath = "(//a[normalize-space()='Supply Partners'])[1]")
	WebElement affiliate_SimulatorView;

	@FindBy(xpath = "(//a[contains(@aria-label,'Sign Up with LUXY today')])[1]")
	WebElement affiliateSignup;

	@FindBy(xpath = "//input[@id='companyName']")
	WebElement companyName;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement fName;

	@FindBy(xpath = "//a[normalize-space()='Sample Insurance Certificate']")
	WebElement insuranceDocument;

	@FindBy(xpath = "//a[normalize-space()='Download Blank Direct Deposit']")
	WebElement directDeposit;

	@FindBy(xpath = "//a[normalize-space()='Download Blank W9']")
	WebElement SampleDocument;

	public DEV_TC_1853_VerifyTheSampleDocumentsLinkForAffiliateOnBoardingPopUpScreen_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfAffiliateTransportSimulatorView(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", affiliate_SimulatorView);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (affiliate_SimulatorView.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfAffiliateTransportNormalVeiw(Boolean visibilityStatus) {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", affiliate_NormalView);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (affiliate_NormalView.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnDriverPartners_Siumlator() {
		try {
			action = new Actions(driver);
			action.moveToElement(affiliate_SimulatorView).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfDriverPartnersSimulatorView(Boolean visibilityStatus) {
		try {
			if (affiliate_SimulatorView.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnAffiliateNormalView() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", affiliate_NormalView);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(affiliate_NormalView).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnAffiliateSimulatorView() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", affiliate_SimulatorView);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(affiliate_SimulatorView).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean switchToNewTab(Boolean visibilityStatus, String parentWindow) {
		try {
			defaultWaitTime(10000);
			Set<String> listOfWindows = driver.getWindowHandles();
			Iterator<String> windowsIterator = listOfWindows.iterator();
			while (windowsIterator.hasNext()) {
				String child_window = windowsIterator.next();
				if (!parentWindow.equals(child_window)) {
					driver.switchTo().window(child_window);
					visibilityStatus = true;
					break;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfAffiliateRegistrationForm(Boolean visibilityStatus) {
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
		}
		return visibilityStatus;
	}

	public void clickOnEnrollAffiliateBtn() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", affiliateSignup);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(affiliateSignup).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyAffiliatePage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains(prop.getProperty("environment"))
					&& expected.toLowerCase().contains("affiliate"))
				js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)", "");
			js.executeScript("arguments[0].scrollIntoView(true);", affiliateSignup);
			js.executeScript("window.scrollBy(0,-100)", "");
			if (affiliateSignup.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnW9Document() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", SampleDocument);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(SampleDocument).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnInsuranceDocument() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", insuranceDocument);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(insuranceDocument).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnDirectDeposit() {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", directDeposit);
			js.executeScript("window.scrollBy(0,-100)", "");
			action.moveToElement(directDeposit).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean switchBackToMainWindow(Boolean visibilityStatus) {
		try {
			Set<String> listOfWindows = driver.getWindowHandles();
			int i = 0;
			for (String currWindow : listOfWindows) {
				if (i == 0) {
					driver.switchTo().window(currWindow);
					try {
						defaultWaitTime(5000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					visibilityStatus = true;
					break;
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfDocumentsPage(Boolean visibilityStatus) {
		try {
			if (expected.toLowerCase().contains("images")) {
				visibilityStatus = true;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfW9DocumentPage(Boolean visibilityStatus) {
		try {
			String expected = driver.getCurrentUrl();
			String environment = prop.getProperty("environment");

			if (expected.toLowerCase().contains(environment.toLowerCase())
					&& expected.toLowerCase().contains("blank")) {
				visibilityStatus = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfInsurancePage(Boolean visibilityStatus) {
		try {
			String expected = driver.getCurrentUrl();
			String environment = prop.getProperty("environment");

			if (expected.toLowerCase().contains(environment.toLowerCase())
					&& expected.toLowerCase().contains("sample")) {
				visibilityStatus = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfDirectDepositPage(Boolean visibilityStatus) {
		try {
			String expected = driver.getCurrentUrl();
			String environment = prop.getProperty("environment");

			if (expected.toLowerCase().contains(environment.toLowerCase())
					&& expected.toLowerCase().contains("blank")) {
				visibilityStatus = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}
}
