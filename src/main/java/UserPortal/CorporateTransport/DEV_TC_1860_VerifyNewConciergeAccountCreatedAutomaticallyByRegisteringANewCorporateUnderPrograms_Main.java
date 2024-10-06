package UserPortal.CorporateTransport;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import common.TestBase;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1860_VerifyNewConciergeAccountCreatedAutomaticallyByRegisteringANewCorporateUnderPrograms_Main
		extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	JavascriptExecutor js;
	TestBase objTestBase;
	String currURL;

	@FindBy(xpath = "//div[normalize-space()='Corporate Transport'][1]")
	WebElement corporateBtn;

	@FindBy(xpath = "//a[normalize-space()='Corporate']")
	WebElement corporate;

	@FindBy(xpath = "(//a[contains(@aria-label,'Try LUXY for Corporate Transport')])[1]")
	WebElement corporateSignup;

	@FindBy(xpath = "//input[@id='companyName']")
	WebElement companyName;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement fName;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lName;

	@FindBy(xpath = "(//input[@id='email'])[1]")
	WebElement eMailInput;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement phoneInput;

	@FindBy(xpath = "//input[@id='677c7684-e3ff-4afd-b679-7cbf41eaa70089']")
	WebElement workAddress;

	@FindBy(xpath = "//label[@for='isPartner']")
	WebElement termsConditionsChckbx;

	@FindBy(xpath = "//button[@aria-label='Create']")
	WebElement signupCreateBtn;

	@FindBy(xpath = "//p[@class='font-normal text-[16px] leading-[25.6px]']")
	WebElement successMsg;

	@FindBy(xpath = "//div[@class='modal-body']")
	WebElement mailBody;

	@FindBy(xpath = "(//span[normalize-space()='Corporate'])[1]")
	WebElement corporateTab;

	@FindBy(xpath = "//span[normalize-space()='Concierge']")
	WebElement conciergeTab;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchItem;

	@FindBy(xpath = "//i[@title='Edit Corporate']")
	List<WebElement> editCorporateBtn;

	@FindBy(xpath = "//i[@title='Delete Corporate']")
	WebElement deleteCorporateBtn;

	@FindBy(xpath = "//i[@title='Edit Concierge']")
	List<WebElement> editConciergeBtn;

	@FindBy(xpath = "//i[@title='Delete Concierge']")
	WebElement deleteConciergeBtn;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement yesBtn;

	@FindBy(xpath = "//p[@class='text-danger']")
	List<WebElement> alertMsgs;

	@FindBy(xpath = "//*[text()='Active']")
	List<WebElement> activeStatus;

	@FindBy(xpath = "//*[text()='Inactive']")
	List<WebElement> inActiveStatus;

	@FindBy(xpath = "//div[@id='clearbut']//a")
	List<WebElement> clearBtn;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[normalize-space()='Customer Login']")
	WebElement customerLogin;

	@FindBy(xpath = "//*[@id='mail']//font[normalize-space()='Activate Account']")
	WebElement confirmEmailAccount;

	@FindBy(xpath = "//*[@type='password']")
	WebElement password;

	@FindBy(xpath = "(//*[text()='Sign In'])[1]")
	WebElement signInBtn;

	@FindBy(xpath = "//input[@id='password'][1]")
	WebElement reloginPwd;

	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
	WebElement loggedInDrpdwn;

	@FindBy(xpath = "//button[normalize-space()='Confirm Luxy Account']")
	WebElement confirmAccount;

	@FindBy(xpath = "//input[@type='text']")
	WebElement dispatcheMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement dispatchpasswordInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement dispatchsignInBtn;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement dispatchsigninUser;

	@FindBy(xpath = "(//*[@type='password'])[1]")
	WebElement conciergepassword;

	@FindBy(xpath = "(//*[@type='password'])[2]")
	WebElement conciergeConfirmpassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement conciergeActivateBtn;

	public DEV_TC_1860_VerifyNewConciergeAccountCreatedAutomaticallyByRegisteringANewCorporateUnderPrograms_Main(
			WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Boolean visibilityOfCorporateTransport(Boolean visibilityStatus) {
		try {
			if (corporateBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public void clickOnCorporate() {
		try {
			action = new Actions(driver);
			action.moveToElement(corporateBtn).click().build().perform();
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

	public Boolean verifyCorporatePage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains(prop.getProperty("environment"))
					&& expected.toLowerCase().contains("corporate"))
				if (corporateSignup.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfCorporateRegistrationForm(Boolean visibilityStatus) {
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

	public void clickOnEnrollCorporateBtn() {
		try {
			action = new Actions(driver);
			action.moveToElement(corporateSignup).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void enterAllDetails() throws Exception {
		try {
			action = new Actions(driver);
			for (int i = 1; i <= 3; i++) {
				action.sendKeys(Keys.ARROW_DOWN).build().perform();
			}

			currDateTime = GetCurrentDateTime.getCurrentDateTime(currDateTime);

			objTestBase.defaultWaitTime(2000);
			companyName.sendKeys(prop.getProperty("conciergeCName") + "_" + currDateTime);
			objTestBase.defaultWaitTime(2000);
			workAddress.sendKeys(prop.getProperty("fromAddress"));
			objTestBase.defaultWaitTime(4000);
			action.sendKeys(Keys.DOWN).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
			fName.sendKeys(prop.getProperty("conciergeFName"));
			lName.sendKeys(prop.getProperty("conciergeLName"));

			// luxyqatestMMDDYYYY_HHMMSS@yopmail.com
			eMail = prop.getProperty("conciergeMail") + currDateTime + prop.getProperty("eMailDomain");

			action.sendKeys(Keys.TAB).build().perform();
			eMailInput.sendKeys(eMail);

			phoneInput.sendKeys(prop.getProperty("phoneNumber"));
			termsConditionsChckbx.click();
			objTestBase.defaultWaitTime(500);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void clickOnSignupCreateBtn() throws Exception {
		try {
			objTestBase.defaultWaitTime(1000);
			signupCreateBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Boolean visibilityOfSignupConfirmationMsg(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(successMsg));

			if (displayStatus.isDisplayed()) {
				expected = successMsg.getText();
				if (expected.toLowerCase().contains("success")) {
					visibilityStatus = true;
				} else {
					visibilityStatus = false;
				}
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfSignupCreateBtn(Boolean visibilityStatus) {
		try {
			if (signupCreateBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public Boolean launchDispatchSite(Boolean visibilityStatus) {
		try {
			driver.get(prop.getProperty("dispatchURL"));
			objTestBase.defaultWaitTime(3000);
			currURL = driver.getCurrentUrl();
			dispatcheMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
			dispatchpasswordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
			try {
				signInBtn.click();
				// Validate Dispatch 2fa Authentication:
				Boolean visibilityStatus1 = false;
				visibilityStatus1 = validateDispatchBypassCode(visibilityStatus1);
				utillLogger.info(
						"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus1);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

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

	public Boolean verifyCorporateTab(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(corporateTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);

			action.moveToElement(searchItem).click().sendKeys(prop.getProperty("conciergeCName")).build().perform();
			objTestBase.defaultWaitTime(2000);

			if (editCorporateBtn.size() != 0) {
				System.out.println(activeStatus.get(0).getText().toLowerCase());
				if (activeStatus.get(0).getText().toLowerCase().equalsIgnoreCase("active"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyConciergeTab(Boolean visibilityStatus, String scenario) {
		try {
			if (scenario == "afterEMailActivation")
				driver.get(prop.getProperty("dispatchURL"));

			driver.navigate().refresh();
			objTestBase.defaultWaitTime(3000);
			action = new Actions(driver);
			action.moveToElement(conciergeTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			action.moveToElement(searchItem).click().sendKeys(eMail).build().perform();
			objTestBase.defaultWaitTime(2000);
			if (editConciergeBtn.size() != 0) {
				if (scenario == "beforeEMailActivation"
						&& inActiveStatus.get(0).getText().toLowerCase().equalsIgnoreCase("inactive")) {
					visibilityStatus = true;
				} else if (scenario == "afterEMailActivation"
						&& activeStatus.get(0).getText().toLowerCase().equalsIgnoreCase("active")) {
					visibilityStatus = true;
				} else {
					visibilityStatus = false;
				}
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean launchYopmail(Boolean visibilityStatus) {
		try {
			driver.get(prop.getProperty("yopmailURL"));
			driver.navigate().refresh();
			clearButton();
			objTestBase.defaultWaitTime(1000);
			eMail = emailIDSerach(eMail);
			objTestBase.defaultWaitTime(1000);
			System.out.println("Regression Email = " + eMail);
			utillLogger.info(
					"DEV_TC_700_VerifyGenerateConciergeAccountByRegisteringCorporateInWebPortal_Main - Regression Email = "
							+ eMail);
			visibilityStatus = verifyyopeMail(visibilityStatus);
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,150)", "");
			objTestBase.defaultWaitTime(2000);
			confirmEmailAccount();
			objTestBase.defaultWaitTime(3000);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clearButton() {
		try {
			if (clearBtn.get(0).isDisplayed()) {
				waitTimeForElement(clearBtn.get(0));
				clearBtn.get(0).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public void confirmEmailAccount() {
		try {
			driver.switchTo().frame("ifmail");
			objTestBase.defaultWaitTime(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", confirmEmailAccount);
			objTestBase.defaultWaitTime(2000);
			confirmEmailAccount.click();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyConfirmAccountPassword(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			Set<String> listOfWindows = driver.getWindowHandles();
			int i = 0;
			for (String currWindow : listOfWindows) {
				if (i == 2)
					driver.switchTo().window(currWindow);
				try {
					defaultWaitTime(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}
				i++;
			}

			objTestBase.defaultWaitTime(2000);
			action.moveToElement(conciergepassword).click().sendKeys(prop.getProperty("conciergePwd")).build()
					.perform();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(conciergeConfirmpassword).click().sendKeys(prop.getProperty("conciergePwd")).build()
					.perform();
			objTestBase.defaultWaitTime(1000);
			js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelector(\"label[for=checkboxAgreement]\").click();");
			objTestBase.defaultWaitTime(500);
			action.moveToElement(conciergeActivateBtn).click().build().perform();
			objTestBase.defaultWaitTime(500);

			expected = driver.getCurrentUrl();
			if (expected.contains(prop.getProperty("environment")))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			action.moveToElement(password).click().sendKeys(prop.getProperty("regPwd")).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void login() throws InterruptedException {
		try {
			action = new Actions(driver);
			action.moveToElement(signInBtn).click().build().perform();
			Thread.sleep(1000);
			if (customerLogin.isDisplayed())
				action.moveToElement(customerLogin).click().build().perform();
			Thread.sleep(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
			WebElement ele = driver.findElement(By.xpath("//*[@id='responsive-navbar-nav']/div/a[4]"));
			ele.click();
			Thread.sleep(1000);
		}
	}

	public String enterEmail() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(eMail);
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return eMail;
	}

	public void passwordRelogin() {
		try {
			action = new Actions(driver);
			password.sendKeys(prop.getProperty("regPwd"));
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean loggedInDrpdwn(Boolean visibilityStatus) {
		try {
			if (loggedInDrpdwn.isDisplayed()) {
				waitTimeForElement(loggedInDrpdwn);
				String tempText = loggedInDrpdwn.getText();
				if (tempText.toLowerCase().contains("welcome")) {
					visibilityStatus = true;
				} else {
					visibilityStatus = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void confirmAccount() {
		try {
			confirmAccount.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}