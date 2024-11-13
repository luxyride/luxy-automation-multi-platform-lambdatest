package TravelAgent.DispatchTravelAgent;

import common.TestBase;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1279_VerifyTheActivateDeactivateTravelAgentFunctionalityInManageTravelAgentPage_Main
		extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailDispatch;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchField;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[normalize-space()='Travel Arranger'])[1]")
	WebElement TravelArranger;

	@FindBy(xpath = "(//span[normalize-space()='Travel Agent'])[1]")
	WebElement travelAgent;

	@FindBy(xpath = "(//a[normalize-space()='Add Travel Agent'])[1]")
	WebElement travelAgentTab;

	@FindBy(xpath = "(//i[@title='Activate Travel Agent'])[1]")
	WebElement activateBtn;

	@FindBy(xpath = "(//i[@title='Deactivate Travel Agent'])[1]")
	WebElement deActivateBtn;

	@FindBy(xpath = "//button[normalize-space()='No']")
	WebElement noBtn;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement yesBtn;

	@FindBy(xpath = "(//div[@role='alert'])")
	WebElement alertMessage;

	TestBase objTestBase;

	public DEV_TC_1279_VerifyTheActivateDeactivateTravelAgentFunctionalityInManageTravelAgentPage_Main(
			WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterEMail() {
		try {
			action = new Actions(driver);
			eMailDispatch.sendKeys(prop.getProperty("dispatchadminMail"));
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSigninButton() {
		try {
			signInBtn.click();
			// Validate Dispatch 2fa Authentication:
			Boolean visibilityStatus = false;
			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
			utillLogger.info(
					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void clickTravelArranger() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(TravelArranger).click().build().perform();
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

	public void clickAddTravelAgent() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(travelAgentTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfTravelAgentTab(Boolean visibilityStatus) {
		try {
			if (travelAgentTab.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickTravelAgent() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(travelAgent).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Boolean visibilityOfTARegistrationPage(Boolean visibilityStatus) {
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

	public void enterSearchField() {
		try {
			action = new Actions(driver);
			String tempEmail[] = eMail.split("@");
			searchField.sendKeys(tempEmail[0]);
			objTestBase.defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfActivateBtn(Boolean visibilityStatus) {
		try {
			if (activateBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickActivateBtn() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(activateBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickNo() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(noBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickYes() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(yesBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfConfirmationMessage(Boolean visibilityStatus) {
		try {
			if (alertMessage.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfDeActivateBtn(Boolean visibilityStatus) {
		try {
			if (deActivateBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickDeActivateBtn() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(deActivateBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public Boolean visibilityOfDeActivatepopup(Boolean visibilityStatus) {
		try {
			if (yesBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfActivatepopup(Boolean visibilityStatus) {
		try {
			if (yesBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

}
