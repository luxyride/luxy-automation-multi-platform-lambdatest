package TravelAgent.Login;

import common.TestBase;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1157_VerifyTheFieldValidationForForgotPasswordInTravelAgentSite_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//input[@type='email']")
	WebElement eMailInput;

	@FindBy(xpath = "//a[@class='link-default']")
	WebElement forgotPwdLink;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement getResetLinkClick;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement alert;

	TestBase objTestBase;

	public DEV_TC_1157_VerifyTheFieldValidationForForgotPasswordInTravelAgentSite_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfGetResetLinkClick(Boolean visibilityStatus) {
		try {
			if (getResetLinkClick.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void GetResetLinkClick() {
		try {
			action = new Actions(driver);
			action.moveToElement(getResetLinkClick).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void invalidEMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("travelAgentInvalidMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("travelAgentEMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSuccessMessage(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alert));
			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfForgotPassword(Boolean visibilityStatus) {
		try {
			if (forgotPwdLink.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfErrorMessage(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alert));
			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnForgotPwd() {
		try {
			action = new Actions(driver);
			action.moveToElement(forgotPwdLink).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfAlertMessage(Boolean visibilityStatus) {
		try {
			if (eMailInput.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}
}
