package Concierge.NewBookings;

import java.util.List;
import common.TestBase;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1727_VerifyTheAvailabilityOfEmployeeIdInConciergePortalWhenIsEmployeeIdRequiredInDBIsTrue_Main
		extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement signInBtn;

	@FindBy(xpath = "(//button[@type='button'])[1]")
	WebElement signInBtnDropdown;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[text() = 'Passengers'])[1]")
	WebElement passangerTab;

	@FindBy(xpath = "(//a[normalize-space()='Add Passenger'])[1]")
	WebElement addPassanger;

	@FindBy(xpath = "(//input[@placeholder='Employee ID'])")
	WebElement employeeId;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInputDispatch;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInputDispatch;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIconDispatch;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtnDispatch;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUserDispatch;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbookingDispatch;

	@FindBy(xpath = "(//span[normalize-space()='Corporate'])[1]")
	WebElement corporateTab;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchInput;

	@FindBy(xpath = "(//i[@title='Edit Corporate'])[1]")
	WebElement editBtn;

	@FindBy(xpath = "(//a[normalize-space()='Add Corporate'])[1]")
	WebElement manageCorpPage;

	@FindBy(xpath = "(//i[@title='Edit Corporate']//parent::a)[1]")
	List<WebElement> editCorporateHyperlink;

	@FindBy(xpath = "//i[@title='Edit Corporate']")
	List<WebElement> editCorporate;

	TestBase objTestBase;

	public DEV_TC_1727_VerifyTheAvailabilityOfEmployeeIdInConciergePortalWhenIsEmployeeIdRequiredInDBIsTrue_Main(
			WebDriver driver) {
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
			eMailInput.sendKeys(prop.getProperty("conciergeadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("conciergePwd"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickEyeIcon() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIcon).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfsigninButton(Boolean visibilityStatus) {
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

	public void clickSignInButton() {
		try {
			action = new Actions(driver);
			action.moveToElement(signInBtn).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfsigninUser(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(signinUser));

			if (displayStatus.isDisplayed()) {
				expected = signinUser.getText();
				if (expected.toLowerCase().contains("welcome")) {
					visibilityStatus = true;
				} else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfAddPassangerBtn(Boolean visibilityStatus) {
		try {
			if (addPassanger.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnPassangerTab() {
		try {
			action = new Actions(driver);
			action.moveToElement(passangerTab).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnAddPassanger() {
		try {
			action = new Actions(driver);
			action.moveToElement(addPassanger).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfEmployeIdfield(Boolean visibilityStatus) {
		try {
			defaultWaitTime(1000);
			if (employeeId.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void eMailInputDispatch() {
		action = new Actions(driver);
		eMailInputDispatch.sendKeys(prop.getProperty("dispatchadminMail"));
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void passwordInputDispatch() {
		action = new Actions(driver);
		passwordInputDispatch.sendKeys(prop.getProperty("dispatchadminPwd"));
	}

	public void eyeIconClickDispatch() {
		action = new Actions(driver);
		action.moveToElement(eyeIconDispatch).click().build().perform();
	}

	public Boolean visibilityOfSigninButtonDispatch(Boolean visibilityStatus) {
		if (signInBtnDispatch.isDisplayed())
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void clickSigninButtonDispatch() {
		try {
			action = new Actions(driver);
			action.moveToElement(signInBtnDispatch).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			// Validate Dispatch 2fa Authentication:
			Boolean visibilityStatus = false;
//			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
//			utillLogger.info(
//					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickNewBookingDispatch() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(newbookingDispatch).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUserDispatch(Boolean visibilityStatus) {
		try {
			waitTimeForElement(signinUserDispatch);
			if (signinUserDispatch.isDisplayed()) {
				expected = signinUserDispatch.getText();
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

	public void clickOnCorporate() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(corporateTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfManageCorporatePage(Boolean visibilityStatus) {
		try {
			if (manageCorpPage.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void searchInput() {
		try {
			action = new Actions(driver);
			searchInput.sendKeys(prop.getProperty("conciergeCompanyNameCMN"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfEditBtn(Boolean visibilityStatus) {
		try {
			action.moveToElement(editCorporate.get(0)).build().perform();
			objTestBase.defaultWaitTime(3000);
			String tempVal = editCorporateHyperlink.get(0).getAttribute("href");
			tempVal = tempVal.replaceAll("[^\\d.]", "").replaceAll("\\.", "");
			System.out.println("Corporate ID Value = " + tempVal);

			if (tempVal.length() != 0 || tempVal.matches("[0-9]+"))
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
		}
		return visibilityStatus;
	}
}
