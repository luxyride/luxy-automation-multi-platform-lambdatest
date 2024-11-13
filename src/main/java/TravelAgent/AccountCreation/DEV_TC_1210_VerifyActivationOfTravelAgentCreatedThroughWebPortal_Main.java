package TravelAgent.AccountCreation;

import java.util.Set;
import java.time.Duration;
import java.util.List;
import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1210_VerifyActivationOfTravelAgentCreatedThroughWebPortal_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	TestBase objTestBase;
	String currURL;

	@FindBy(xpath = "//div[@id='clearbut']//a")
	List<WebElement> clearBtn;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtn;

	@FindBy(xpath = "//a[normalize-space()='Customer Login']")
	WebElement customerLogin;

	@FindBy(xpath = "//*[@id='mail']//font[normalize-space()='Confirm Account']")
	WebElement confirmEmailAccount;

	@FindBy(xpath = "(//*[@type='password'])[1]")
	WebElement password;

	@FindBy(xpath = "(//*[@type='password'])[2]")
	WebElement confirmPwd;

	@FindBy(xpath = "//input[@id='password'][1]")
	WebElement reloginPwd;

	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
	WebElement loggedInDrpdwn;

	@FindBy(xpath = "//button[normalize-space()='Activate']")
	WebElement activateAccount;

	@FindBy(xpath = "//input[@type='text']")
	WebElement dispatcheMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement dispatchpasswordInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement dispatchsignInBtn;

	@FindBy(xpath = "(//span[text()='Travel Arranger'])[1]")
	WebElement travelArrangerTab;

	@FindBy(xpath = "(//span[text()='Travel Agent'])[1]")
	WebElement travelAgentTab;

	@FindBy(xpath = "//*[contains(text(),'Manage Travel Agent')]")
	WebElement travelAgentHeader;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement serachTravelAgent;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement dispatchYesBtn;

	@FindBy(xpath = "//*[text()='There is no data to display']")
	WebElement dispatchNoTravelAgentMsg;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInputTA;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbooking;

	@FindBy(xpath = "//i[@title='Delete Travel Agent']")
	WebElement dispatchDeleteTravelAgent;

	public DEV_TC_1210_VerifyActivationOfTravelAgentCreatedThroughWebPortal_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		} catch (Exception e) {
			e.printStackTrace();
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
					if (currURL.toLowerCase().contains("uat"))
						visibilityStatus = updateuaturlWithAuth(visibilityStatus, currURL);
				}
				i++;
			}
			objTestBase.closePopupWindow();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean updateuaturlWithAuth(Boolean visibilityStatus, String currURL) {
		try {
			currURL = currURL.replace("uat", "uat");
			System.out.println(currURL);
			driver.get(currURL);
			objTestBase.defaultWaitTime(3000);
			if (activateAccount.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void passwordConfirmPasswordInputs() {
		try {
			action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(password));
			if (displayStatus.isDisplayed()) {
				action.moveToElement(password).click().sendKeys(prop.getProperty("regPwd")).build().perform();
				defaultWaitTime(500);
				action.moveToElement(confirmPwd).click().sendKeys(prop.getProperty("regPwd")).build().perform();
				defaultWaitTime(500);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eMailInput(String eMail) {
		try {
			action = new Actions(driver);
			eMailInputTA.sendKeys(eMail);
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("travelAgentPwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickNewBooking() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(newbooking).click().build().perform();
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

	public void activateAccount() {
		try {
			activateAccount.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean deleteCreatedUserfromDispatch(Boolean visibilityStatus, String eMail) {
		try {
			action = new Actions(driver);
			driver.get(prop.getProperty("dispatchURL"));
			objTestBase.defaultWaitTime(3000);
			dispatcheMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
			objTestBase.defaultWaitTime(500);
			action.sendKeys(Keys.TAB).build().perform();
			dispatchpasswordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
			objTestBase.defaultWaitTime(500);
			try {
				dispatchsignInBtn.click();
				// Validate Dispatch 2fa Authentication:
				Boolean visibilityStatus1 = false;
				visibilityStatus = validateDispatchBypassCode(visibilityStatus);
				utillLogger.info(
						"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus1);
			} catch (Exception e) {
				// TODO: handle exception
			}
			action.moveToElement(travelArrangerTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(travelAgentTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			action.moveToElement(serachTravelAgent).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			String tempEmail[] = eMail.split("@");
			serachTravelAgent.sendKeys(tempEmail[0]);
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.ENTER).build().perform();
			action.moveToElement(dispatchDeleteTravelAgent).click().build().perform();
			objTestBase.defaultWaitTime(2000);
			action.moveToElement(dispatchYesBtn).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(2000);
			action.moveToElement(serachTravelAgent).click().sendKeys(tempEmail[0]).build().perform();
			objTestBase.defaultWaitTime(2000);
			if (dispatchNoTravelAgentMsg.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

}
