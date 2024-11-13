package Affiliate.Login;

import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_650_VerifyUserLoggingoutAutomaticallyWhenReloadsthePageAffiliate_Main extends TestBase {

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

	TestBase objTestBase;

	public DEV_TC_650_VerifyUserLoggingoutAutomaticallyWhenReloadsthePageAffiliate_Main(WebDriver driver) {
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
}
