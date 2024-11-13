package TravelAgent.Passengers;

import common.TestBase;

import java.time.Duration;
import java.util.List;
import java.util.Set;

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

public class DEV_TC_1256_VerifyActivateAccountButtonToSendActivationLinkTotheRegisteredEmail_Main extends TestBase {

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

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement firstName;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbooking;

	@FindBy(xpath = "(//span[normalize-space()='Passengers'])[1]")
	WebElement passengerTab;

	@FindBy(xpath = "//*[@placeholder='Search']")
	WebElement searchPassenger;

	@FindBy(xpath = "//*[@title='Activate Passenger']")
	List<WebElement> activatePassenger;

	@FindBy(xpath = "//*[@title='Activate Account']")
	List<WebElement> activateAccount;

	@FindBy(xpath = "//*[@title='Deactivate Passenger']")
	List<WebElement> deactivatePassenger;

	@FindBy(xpath = "//button[normalize-space()='No']")
	WebElement noBtn;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement yesBtn;

	@FindBy(xpath = "//button[normalize-space()='Back']")
	WebElement backBtn;

	@FindBy(xpath = "//*[(@role='alert')]")
	WebElement alertMessge;

	// Account Activation:
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
	WebElement confirmPassword;

	@FindBy(xpath = "//button[normalize-space()='Activate']")
	WebElement confirmEmailAccountPopup;

	@FindBy(xpath = "//input[@id='password'][1]")
	WebElement reloginPwd;

	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
	WebElement loggedInDrpdwn;

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

	@FindBy(xpath = "//i[@title='Delete Travel Agent']")
	WebElement dispatchDeleteTravelAgent;

	@FindBy(xpath = "(//button[contains(text(),'Welcome')])[1]")
	WebElement welcomedropdown;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement logout;

	// User Portal:
	@FindBy(xpath = "(//*[text()='Sign In'])[1]")
	WebElement signinBtnUserPortal;

	@FindBy(xpath = "//a[normalize-space()='Customer Login']")
	WebElement customerLoginUserPortal;

	@FindBy(xpath = "(//input[@id='email'])[1]")
	WebElement eMailInputUserPortal;

	@FindBy(xpath = "(//input[@id='password'])[1]")
	WebElement passwordInputUserPortal;

	@FindBy(xpath = "(//div[@class='input-group-prepend'])[1]//span//i")
	WebElement eyeIconUserPortal;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement signInBtn_LoginUserPortal;

	@FindBy(xpath = "//a[contains(normalize-space(),'Welcome')]")
	WebElement signInBtnDropdownUserPortal;

	TestBase objTestBase;

	public DEV_TC_1256_VerifyActivateAccountButtonToSendActivationLinkTotheRegisteredEmail_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
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

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("travelAgentPwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eyeIconClick() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIcon).click().build().perform();
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

	public void clickOnPassengerTab() {
		try {
			action = new Actions(driver);
			action.moveToElement(passengerTab).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfManagePassengerPage(Boolean visibilityStatus) {
		try {
			if (searchPassenger.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public String searchPassenger(String eMail) {
		try {
			action = new Actions(driver);
			eMail = prop.getProperty("taPassengerEMail");
			action.moveToElement(searchPassenger).click().sendKeys(eMail).build().perform();
			defaultWaitTime(2000);
			action.sendKeys(Keys.ENTER).build().perform();
			defaultWaitTime(500);
			action.sendKeys(Keys.TAB).build().perform();
			defaultWaitTime(500);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return eMail;
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
			visibilityStatus = false;
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

	public Boolean visibilityOfPassengerActivateButton(Boolean visibilityStatus) {
		try {
			if (activatePassenger.size() != 0 && activatePassenger.get(0).isDisplayed())
				visibilityStatus = true;
			else if (deactivatePassenger.size() != 0 && deactivatePassenger.get(0).isDisplayed()) {
				// Deactivate and Activate If already in Activate State:
				deactivatePassenger.get(0).click();
				defaultWaitTime(5000);
				yesBtn.click();
				defaultWaitTime(5000);
				driver.navigate().refresh();
				defaultWaitTime(2000);
				eMail = searchPassenger(eMail);
				if (activatePassenger.size() != 0)
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

	public Boolean visibilityOfActivatePassengerPopupConfirmation(Boolean visibilityStatus) {
		try {
			if (activateAccount.size() != 0 && activateAccount.get(0).isDisplayed()) {
				activateAccount.get(0).click();
				defaultWaitTime(2000);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(noBtn));
				if (displayStatus.isDisplayed())
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

	public Boolean verificationOfNavigatingBackToManagePassengerPage(Boolean visibilityStatus) {
		try {
			noBtn.click();
			defaultWaitTime(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(activatePassenger.get(0)));
			if (displayStatus.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verificationOfActivatePassengerConfirmationMessage(Boolean visibilityStatus) {
		try {
			yesBtn.click();
			defaultWaitTime(2000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
			if (displayStatus.isDisplayed() && alertMessge.getText().toLowerCase().contains("successfully"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	// Account Activation:
	public void clearButtonTA() {
		try {
			if (clearBtn.get(0).isDisplayed()) {
				waitTimeForElement(clearBtn.get(0));
				clearBtn.get(0).click();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String emailIDSerachTA(String eMail) {
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

	public Boolean verifyyopeMailTA(Boolean visibilityStatus) {
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

	public void confirmEmailAccountTA() {
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

	public Boolean switchToConfirmAccountWindowTA(Boolean visibilityStatus) {
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
					if (environmentCode == "dev") {
						expected = driver.getCurrentUrl();
						if (expected.toLowerCase().contains("uat")) {
							expected = expected.replace("uat", "dev");
							driver.get(expected);
							defaultWaitTime(3000);
						}
					} else if (environmentCode == "uat") {
						expected = driver.getCurrentUrl();
						if (expected.toLowerCase().contains("uat"))
							visibilityStatus = updateuaturlWithAuthTA(visibilityStatus, expected);
					}
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean updateuaturlWithAuthTA(Boolean visibilityStatus, String currURL) {
		try {
			currURL = currURL.replace("uat", "uat");
			System.out.println(currURL);
			driver.get(currURL);
			objTestBase.defaultWaitTime(3000);
			if (confirmEmailAccountPopup.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean passwordConfirmPasswordInputsTA(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(password));
			if (displayStatus.isDisplayed()) {
				action.moveToElement(password).click().sendKeys(prop.getProperty("regPwd")).build().perform();
				defaultWaitTime(500);
				action.moveToElement(confirmPassword).click().sendKeys(prop.getProperty("regPwd")).build().perform();
				defaultWaitTime(500);
				js = (JavascriptExecutor) driver;
				js.executeScript("document.querySelector(\"label[for=checkboxAgreement]\").click();");
				defaultWaitTime(1000);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void eMailInputTA(String eMail) {
		try {
			action = new Actions(driver);
			eMailInputTA.sendKeys(eMail);
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInputTA() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("travelAgentPwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnConfirmEMailAccountTA() {
		try {
			confirmEmailAccountPopup.click();
			objTestBase.defaultWaitTime(5000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSigninButtonTA(Boolean visibilityStatus) {
		try {
			if (signInBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void clickSigninButtonTA() {
		try {
			signInBtn.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickNewBookingTA() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(newbooking).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUserTA(Boolean visibilityStatus) {
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
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void clickWelcomeDropdown() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(welcomedropdown).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickNewBookingTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(newbooking).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOflogout(Boolean visibilityStatus) {
		try {
			if (logout.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickLogoutoption() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(logout).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	// UserPortal:
	public void clickLoginUserPortal() throws InterruptedException {
		try {
			action = new Actions(driver);
			action.moveToElement(signinBtnUserPortal).click().build().perform();
			Thread.sleep(1000);
			if (customerLoginUserPortal.isDisplayed())
				action.moveToElement(customerLoginUserPortal).click().build().perform();
			Thread.sleep(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
			WebElement ele = driver.findElement(By.xpath("//*[@id='responsive-navbar-nav']/div/a[4]"));
			ele.click();
			Thread.sleep(1000);
		}
	}

	public void eMailInputUserPortal(String eMail) {
		try {
			action = new Actions(driver);
			eMailInputUserPortal.sendKeys(eMail);
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInputUserPortal() {
		try {
			action = new Actions(driver);
			passwordInputUserPortal.sendKeys(prop.getProperty("taPassengerPwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eyeIconClickUserPortal() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIconUserPortal).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSigninButtonUserPortal(Boolean visibilityStatus) {
		try {
			if (signInBtn_LoginUserPortal.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSigninButtonUserPortal() {
		try {
			signInBtn_LoginUserPortal.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUserPortal(Boolean visibilityStatus) {
		try {
			waitTimeForElement(signInBtnDropdownUserPortal);
			if (signInBtnDropdownUserPortal.isDisplayed()) {
				expected = signInBtnDropdownUserPortal.getText();
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
