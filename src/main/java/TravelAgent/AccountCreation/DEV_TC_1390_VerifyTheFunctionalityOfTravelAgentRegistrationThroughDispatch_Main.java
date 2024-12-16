package TravelAgent.AccountCreation;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import common.TestBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1390_VerifyTheFunctionalityOfTravelAgentRegistrationThroughDispatch_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	String currURL;

	@FindBy(xpath = "//input[@type='text']")
	List<WebElement> eMailDispatch;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[normalize-space()='Travel Arranger'])[1]")
	WebElement TravelArranger;

	@FindBy(xpath = "(//span[normalize-space()='Travel Agent'])[1]")
	WebElement travelAgent;

	@FindBy(xpath = "(//a[normalize-space()='Add Travel Agent'])[1]")
	WebElement travelAgentTab;

	@FindBy(xpath = "//select[@name='corporate_id']")
	WebElement travelArrangerName;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='Mobile']")
	WebElement mobile;

	@FindBy(xpath = "//input[@id='login']")
	WebElement searchInput;

	@FindBy(xpath = "(//input[@type='email'])[1]")
	WebElement eMailTravelArranger;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement register;

	@FindBy(xpath = "(//div[@role='alert'])")
	WebElement alertMessge;

	@FindBy(xpath = "//label[@for='file-upload-w9']")
	WebElement sampleW9;

	@FindBy(xpath = "//label[@for='file-upload-w9']")
	WebElement sampleDirect;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchField;

	@FindBy(xpath = "//*[normalize-space()= 'Travel Agent Registration']")
	WebElement travelAgentlbl;

	@FindBy(xpath = "//*[@id='mail']//font[normalize-space()='Confirm Account']")
	WebElement confirmEmailAccount;

	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement Password;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement confirmPassword;

	@FindBy(xpath = "//label[@for='checkboxAgreement']")
	WebElement checkBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement activateBtn;

	@FindBy(xpath = "//i[@class='material-icons-outlined f36']")
	WebElement confirm;

	TestBase objTestBase;

	public DEV_TC_1390_VerifyTheFunctionalityOfTravelAgentRegistrationThroughDispatch_Main(WebDriver driver) {
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
			eMailDispatch.get(0).sendKeys(prop.getProperty("dispatchadminMail"));
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

	public Boolean visibilityOfManageTravelAgentPage(Boolean visibilityStatus) {
		try {
			waitTimeForElement(signinUser);
			if (signinUser.isDisplayed()) {
				expected = driver.getCurrentUrl();
				if (expected.toLowerCase().contains("manage")) {
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

	public Boolean visibilityOfAlertMessage(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
			objTestBase.defaultWaitTime(500);

			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public String verifyFillingAllDetailsInTraveArrangerPage(String eMail) {
		try {
			if (travelAgentlbl.isDisplayed()) {
				action = new Actions(driver);
				Select select = new Select(travelArrangerName);
				select.selectByVisibleText(prop.getProperty("travelAgentCName"));
				objTestBase.defaultWaitTime(3000);
				action.moveToElement(firstName).click().sendKeys(prop.getProperty("fName")).build().perform();
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(lastName).click().sendKeys(prop.getProperty("lName")).build().perform();
				objTestBase.defaultWaitTime(1000);
				eMail = prop.getProperty("regeMail") + currDateTime + prop.getProperty("eMailDomain");
				action.sendKeys(Keys.TAB).build().perform();
				eMailTravelArranger.sendKeys(eMail);
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(mobile).click().sendKeys(prop.getProperty("phoneNumber")).build().perform();
				objTestBase.defaultWaitTime(6000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			eMail = null;
		}
		return eMail;
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

	public void enterSearchField(String eMail) {
		try {
			searchField.sendKeys(eMail);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyyopeMail(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("yopmail"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void confirmEmailAccount() {
		try {
			driver.switchTo().frame("ifmail");
			confirmEmailAccount.click();
			objTestBase.defaultWaitTime(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", confirmEmailAccount);
			objTestBase.defaultWaitTime(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyActivatePage(Boolean visibilityStatus) {
		expected = driver.getCurrentUrl();
		if (expected.toLowerCase().contains("activation"))
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void clickOncheckbox() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelector(\"label[for=checkboxAgreement]\").click();");
			objTestBase.defaultWaitTime(500);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickActivateBtn() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(activateBtn).click().build().perform();
			objTestBase.defaultWaitTime(500);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean eMailTravelArrange(Boolean visibilityStatus, String eMail) {
		try {
			visibilityStatus = waitToPageLoadElementsFluentWait(visibilityStatus, eMailDispatch);
			if (visibilityStatus.booleanValue() == true) {
				action = new Actions(driver);
				eMailDispatch.get(0).sendKeys(eMail);
				action.sendKeys(Keys.TAB).build().perform();
				visibilityStatus = true;
			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void passwordTravelArranger() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("regPwd"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchInput() {
		try {
			action = new Actions(driver);
			eMail = prop.getProperty("regeMail") + currDateTime + prop.getProperty("eMailDomain");
			searchInput.sendKeys(eMail);
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnConfirm() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(confirm).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnRegister() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(register).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordConfirmPwdInputs() {
		try {
			action = new Actions(driver);
			action.moveToElement(Password).click().sendKeys(prop.getProperty("regPwd")).build().perform();
			defaultWaitTime(500);
			action.moveToElement(confirmPassword).click().sendKeys(prop.getProperty("regPwd")).build().perform();
			defaultWaitTime(500);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean switchToConfirmAccountWindow(Boolean visibilityStatus) {
		try {
			Set<String> listOfWindows = driver.getWindowHandles();
			int i = 0;
			for (String currWindow : listOfWindows) {
				if (i == 1) {
					driver.switchTo().window(currWindow);
					try {
						defaultWaitTime(5000);
					} catch (Exception e) {
						e.printStackTrace();
					}
					currURL = driver.getCurrentUrl();
				}
				i++;
			}
			objTestBase.closePopupWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}
}
