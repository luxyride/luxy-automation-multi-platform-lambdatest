package UserPortal.TravelAgentProgram;

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

public class DEV_TC_1866_VerifyTheAvailabilityOfSampleDocumentsLinkForTravelAgentOnBoarding_Main
		extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	JavascriptExecutor js;
	TestBase objTestBase;

	@FindBy(xpath = "//div[normalize-space()='Travel Agent Program'][1]")
	WebElement travelAgentBtn;

	@FindBy(xpath = "(//a[contains(@aria-label,'Join the LUXY Travel Agent Program')])[1]")
	WebElement travelAgentSignup;

	@FindBy(xpath = "//input[@id='companyName']")
	WebElement companyName;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement fName;


	@FindBy(xpath = "//a[normalize-space()='Download Blank Direct Deposit']")
	WebElement directDeposit;

	@FindBy(xpath = "//a[normalize-space()='Download Blank W9']")
	WebElement SampleDocument;



	public DEV_TC_1866_VerifyTheAvailabilityOfSampleDocumentsLinkForTravelAgentOnBoarding_Main(
			WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Boolean visibilityOfTaTransport(Boolean visibilityStatus) {
		try {
			if (travelAgentBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public void clickOnTa() {
		try {
			action = new Actions(driver);
			action.moveToElement(travelAgentBtn).click().build().perform();
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

	
	public Boolean verifyVisibilityOfTaRegistrationForm(Boolean visibilityStatus) {
		try {
			if (companyName.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public void clickOnEnrollTaBtn() {
		try {
			action = new Actions(driver);
			action.moveToElement(travelAgentSignup).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Boolean verifyTaPage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains(prop.getProperty("environment"))
					&& expected.toLowerCase().contains("travel"))
				if (travelAgentSignup.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
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
	
	public void clickOnW9Document() {
		try {
			action = new Actions(driver);
			action.moveToElement(SampleDocument).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickOnDirectDeposit() {
		try {
			action = new Actions(driver);
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

}
