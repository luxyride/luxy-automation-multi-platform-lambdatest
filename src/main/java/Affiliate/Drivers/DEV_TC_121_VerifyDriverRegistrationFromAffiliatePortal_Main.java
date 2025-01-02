package Affiliate.Drivers;

import common.GetCurrentDateTime;
import common.TestBase;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_121_VerifyDriverRegistrationFromAffiliatePortal_Main extends TestBase {

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

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesTab;

	@FindBy(xpath = "(//span[normalize-space()='All'])[1]")
	WebElement allTab;

	@FindBy(xpath = "(//span[normalize-space()='Drivers'])[1]")
	WebElement driversTab;

	@FindBy(xpath = "//*[contains(text(),'Manage Driver')]")
	WebElement manageDriverHeader;

	@FindBy(xpath = "//*[text()=' Add Driver'][1]")
	WebElement addDriverBtn;

	@FindBy(xpath = "(//label[@for='exampleFormControlInput1'])[1]//following-sibling::input")
	WebElement fName;

	@FindBy(xpath = "(//label[@for='exampleFormControlInput1'])[2]//following-sibling::input")
	WebElement lName;

	@FindBy(xpath = "(//label[@for='exampleFormControlInput1'])[3]//following-sibling::input")
	WebElement driverLicense;

	@FindBy(xpath = "(//label[@for='exampleFormControlInput1'])[4]//following-sibling::input")
	WebElement eMailInputRegression;

	@FindBy(xpath = "(//input[@type='tel'])[1]")
	WebElement phoneInput;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//button[text()='Register']")
	WebElement registerBtn;

	@FindBy(xpath = "(//*[(@role='alert')])[1]")
	WebElement alertMessge;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchEmailID;

	@FindBy(xpath = "//i[@title='Driver Profile']")
	List<WebElement> driverProfile;

	TestBase objTestBase;

	public DEV_TC_121_VerifyDriverRegistrationFromAffiliatePortal_Main(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		objTestBase = new TestBase();
	}

	public void eMailInput() {
		action = new Actions(driver);
		eMailInput.sendKeys(prop.getProperty("affiliatEMail"));
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void passwordInput() {
		action = new Actions(driver);
		passwordInput.sendKeys(prop.getProperty("affiliatePwd"));
	}

	public void eyeIconClick() {
		action = new Actions(driver);
		action.moveToElement(eyeIcon).click().build().perform();
	}

	public Boolean visibilityOfSigninButton(Boolean visibilityStatus) {
		if (signInBtn.isDisplayed())
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void clickSigninButton() {
		signInBtn.click();
	}

	public void clickOnRides() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(ridesTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnAllTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(allTab).click().build().perform();
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

	public Boolean verifyNavigationOfDriversPage(Boolean visibilityStatus) {
		try {
			driversTab.click();
			waitTimeForElement(addDriverBtn);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(manageDriverHeader));

			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyNavigationOfDriverRegistrationPage(Boolean visibilityStatus) {
		try {
			waitTimeForElement(addDriverBtn);
			addDriverBtn.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			Boolean displayStatus = wait.until(ExpectedConditions.urlContains("register"));

			if (displayStatus == true)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public String enterAllDetails(String eMail) throws Exception {
		try {
			action = new Actions(driver);
			for (int i = 1; i <= 5; i++) {
				action.sendKeys(Keys.ARROW_DOWN).build().perform();
			}

			currDateTime = GetCurrentDateTime.getCurrentDateTime(currDateTime);

			fName.sendKeys(prop.getProperty("affiliateFName"));
			lName.sendKeys(prop.getProperty("affiliateLName"));
			driverLicense.sendKeys(prop.getProperty("driverLicense") + currDateTime);

			// luxyqatestMMDDYYYY_HHMMSS@yopmail.com
			eMail = prop.getProperty("driverMailRegression") + currDateTime + prop.getProperty("eMailDomain");
			action.sendKeys(Keys.TAB).build().perform();
			eMailInputRegression.sendKeys(eMail);

			phoneInput.sendKeys(prop.getProperty("phoneNumber"));
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(1000);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-100)", "");
			objTestBase.defaultWaitTime(2000);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return eMail;
	}

	public Boolean verifyDriverManageNavigation(Boolean visibilityStatus) {
		try {
			waitTimeForElement(cancelBtn);
			cancelBtn.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			Boolean displayStatus = wait.until(ExpectedConditions.urlContains("manage"));

			if (displayStatus == true)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyDriverAccountConfMsg(Boolean visibilityStatus) {
		try {
			waitTimeForElement(registerBtn);
			registerBtn.click();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));

			if (displayStatus.isDisplayed() && alertMessge.getText().toLowerCase().contains("saved"))
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean searchDriverEMailID(String eMail, Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			driversTab.click();
			objTestBase.defaultWaitTime(3000);
			searchEmailID.click();
			objTestBase.defaultWaitTime(1000);
			searchEmailID.sendKeys(eMail);
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(1000);

			if (driverProfile.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

}
