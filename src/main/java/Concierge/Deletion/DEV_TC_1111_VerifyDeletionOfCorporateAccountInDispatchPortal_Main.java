package Concierge.Deletion;

import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class DEV_TC_1111_VerifyDeletionOfCorporateAccountInDispatchPortal_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	JavascriptExecutor js;
	TestBase objTestBase;
	String currURL;

	@FindBy(xpath = "(//span[normalize-space()='Corporate'])[1]")
	WebElement corporateTab;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchItem;

	@FindBy(xpath = "//i[@title='Delete Corporate']")
	WebElement deleteCorporateBtn;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement yesBtn;

	@FindBy(xpath = "//input[@type='text']")
	WebElement dispatcheMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement dispatchpasswordInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement dispatchsignInBtn;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement dispatchsigninUser;

	@FindBy(xpath = "//span[normalize-space()='Concierge']")
	WebElement conciergeTab;

	@FindBy(xpath = "//*[text()='There is no data to display']")
	WebElement noConciergeMsg;

	public DEV_TC_1111_VerifyDeletionOfCorporateAccountInDispatchPortal_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean loginDispatch(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			dispatcheMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
			dispatchpasswordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
			try {
				dispatchsignInBtn.click();
				// Validate Dispatch 2fa Authentication:
				Boolean visibilityStatus1 = false;
//				visibilityStatus1 = validateDispatchBypassCode(visibilityStatus1);
//				utillLogger.info(
//						"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus1);
			} catch (Exception e) {
				// TODO: handle exception
			}			objTestBase.defaultWaitTime(5000);
			waitTimeForElement(dispatchsigninUser);
			if (dispatchsigninUser.isDisplayed()) {
				expected = dispatchsigninUser.getText();
				if (expected.toLowerCase().contains("welcome")) {
					visibilityStatus = true;
				} else {
					visibilityStatus = false;
				}
			} else {
				visibilityStatus = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean deleteCompanyFromCorporateTab(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(corporateTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			action.moveToElement(searchItem).click().sendKeys(prop.getProperty("conciergeCName")).build().perform();
			objTestBase.defaultWaitTime(2000);
			deleteCorporateBtn.click();
			objTestBase.defaultWaitTime(2000);
			if (yesBtn.isDisplayed()) {
				yesBtn.click();
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyCorporateAfterDeletion(Boolean visibilityStatus) {
		try {
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(3000);
			action.moveToElement(corporateTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			action.moveToElement(searchItem).click().sendKeys(prop.getProperty("conciergeCName")).build().perform();
			objTestBase.defaultWaitTime(2000);
			if (noConciergeMsg.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyCompanyFromConciergeTab(Boolean visibilityStatus) {
		try {
			action.moveToElement(conciergeTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			action.moveToElement(searchItem).click().sendKeys(prop.getProperty("conciergeCName")).build().perform();
			objTestBase.defaultWaitTime(2000);
			if (noConciergeMsg.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}
}
