package Concierge.Login;

import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_817_VerifyLinkToViewVideosAboutCorporateProgramInNewLUXYConciergeAccountEmailTemplate_Main
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

	@FindBy(xpath = "//ul[@class='slimScrollBar']//span[@class='displayB'][normalize-space()='Concierge']")
	WebElement Concierge;

	@FindBy(xpath = "//a[@class='btn-outline-orange pull-right p-2']")
	WebElement AddconciergeBtn;

	@FindBy(xpath = "//h4[@class='topText']")
	WebElement ConciergeRegistration;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement FirstName;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement LastName;

	@FindBy(xpath = "(//input[@type='email'])")
	WebElement Email;

	@FindBy(xpath = "//input[@placeholder='Mobile']")
	WebElement Mobile;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement RegistrationBtn;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement Successmessage;

	@FindBy(xpath = "//input[@id='login']")
	WebElement EmailInput;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtn;

	@FindBy(xpath = "//i[@class='material-icons-outlined f36']")
	WebElement ClickEnter;

	@FindBy(xpath = "(//font[normalize-space()='Thank you for Registering'])[1]")
	WebElement EmailConfirmation;

	@FindBy(xpath = "//a[normalize-space()='Click here']")
	WebElement ClickHere;

	@FindBy(xpath = "(//div[@class='ultv-video__outer-wrap'])[1]")
	List<WebElement> dashboardPage;

	TestBase objTestBase;

	public DEV_TC_817_VerifyLinkToViewVideosAboutCorporateProgramInNewLUXYConciergeAccountEmailTemplate_Main(
			WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("conciergeadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("conciergePwd"));
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void clickEyeIcon() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIcon).click().build().perform();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfsigninButton(Boolean visibilityStatus) {
		try {
			if (signInBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSignInButton() {
		try {
			action = new Actions(driver);
			action.moveToElement(signInBtn).click().build().perform();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfsigninUser(Boolean visibilityStatus) {
		try {
			expected = signinUser.getText();
			if (expected.toLowerCase().contains("welcome")) {
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfConcierge(Boolean visibilityStatus) {
		try {
			if (Concierge.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnConciergeBtn() {
		try {
			action = new Actions(driver);
			action.moveToElement(Concierge).click().build().perform();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnAddConciergeBtn() {
		try {
			action = new Actions(driver);
			action.moveToElement(AddconciergeBtn).click().build().perform();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfConciergeRegistrationPage(Boolean visibilityStatus) {
		try {
			if (ConciergeRegistration.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void enterFirstName() {
		try {
			action = new Actions(driver);
			FirstName.sendKeys(prop.getProperty("spFirstName"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterLastName() {
		try {
			action = new Actions(driver);
			LastName.sendKeys(prop.getProperty("spLastName"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterEmail() {
		try {
			// luxyqaautotestconciergeDDMMYYYY_HHMMSS@yopmail.com
			eMail = prop.getProperty("conciergeMail") + currDateTime + prop.getProperty("eMailDomain");

			action.sendKeys(Keys.TAB).build().perform();
			Email.sendKeys(eMail);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterMobile() {
		try {
			action = new Actions(driver);
			Mobile.sendKeys(prop.getProperty("spMobile"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfRegistrationBtn(Boolean visibilityStatus) {
		try {
			if (RegistrationBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnRegistrationBtn() {
		try {
			action = new Actions(driver);
			action.moveToElement(RegistrationBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfRegistrationSuccessmessage(Boolean visibilityStatus) {
		try {
			if (Successmessage.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyEmailConfirmation(Boolean visibilityStatus) {
		try {
			defaultWaitTime(1000);
			driver.switchTo().frame("ifmail");
			objTestBase.defaultWaitTime(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", EmailConfirmation);
			objTestBase.defaultWaitTime(2000);
			if (EmailConfirmation.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public String emailIDSerach(String eMail) {
		try {
			System.out.println("Regression Email = " + eMail);
			action = new Actions(driver);
			String[] tempEmail = eMail.toString().split("@");
			loginBtn.sendKeys(tempEmail[0]);
			action.sendKeys(Keys.ENTER).build().perform();
			driver.navigate().refresh();
			defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eMail;
	}

	public Boolean launchYopmail(Boolean visibilityStatus) {
		try {
			driver.get(prop.getProperty("yopmailURL"));
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(1000);
			eMail = emailIDSerach(eMail);
			objTestBase.defaultWaitTime(1000);
			System.out.println("Regression Email = " + eMail);
			utillLogger.info(
					"DEV_TC_700_VerifyGenerateConciergeAccountByRegisteringCorporateInWebPortal_Main - Regression Email = "
							+ eMail);
			visibilityStatus = verifyyopeMail(visibilityStatus);
			js = (JavascriptExecutor) driver;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void enterEmailinput(Boolean visibilityStatus) {
		try {
			System.out.println("Regression Email = " + eMail);
			utillLogger.info(
					"DEV_TC_700_VerifyGenerateConciergeAccountByRegisteringCorporateInWebPortal_Main - Regression Email = "
							+ eMail);
			visibilityStatus = verifyyopeMail(visibilityStatus);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,150)", "");
			objTestBase.defaultWaitTime(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyyopeMail(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("yopmail"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyClickHereLink(Boolean visibilityStatus) {
		try {
			if (ClickHere.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnLink() {
		try {
			js.executeScript("window.scrollBy(0,500)");
			objTestBase.defaultWaitTime(8000);
			action = new Actions(driver);
			action.moveToElement(ClickHere).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickEnter() {
		try {
			action = new Actions(driver);
			action.moveToElement(ClickEnter).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyLinksConciergeDashboardPage(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(dashboardPage.get(0)));

			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

}
