package TravelAgent.DispatchTravelAgent;

import java.util.Set;
import java.util.List;
import common.TestBase;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1278_VerifyResetPasswordFunctionalityInManageTravelAgentPage_Main extends TestBase {

	String currURL;
	Actions action;
	String expected;
	WebDriver driver;
	TestBase objTestBase;

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

	@FindBy(xpath = "//button[normalize-space()='No']")
	WebElement dispatchNoBtn;

	@FindBy(xpath = "//*[text()='There is no data to display']")
	WebElement dispatchNoTravelAgentMsg;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInputTA;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIcon;

	@FindBy(xpath = "//button[@type='submit']")
	List<WebElement> signInBtn;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbooking;

	@FindBy(xpath = "//*[@title='Reset Password']")
	WebElement dispatchResetPWDTravelAgent;

	@FindBy(xpath = "//*[(@role='alert')]")
	WebElement alertMessge;

	@FindBy(xpath = "//div[@id='clearbut']//a")
	List<WebElement> clearBtn;

	@FindBy(xpath = "//input[@id='login']")
	WebElement searchEMailID;

	@FindBy(xpath = "//*[@id='mail']//font[normalize-space()='Reset Password']")
	WebElement resetPassword;

	@FindBy(xpath = "//button[normalize-space()='Reset']")
	List<WebElement> confirmResetPassword;

	@FindBy(xpath = "(//*[@type='password'])[1]")
	WebElement password;

	@FindBy(xpath = "(//*[@type='password'])[2]")
	WebElement confirmPwd;

	public DEV_TC_1278_VerifyResetPasswordFunctionalityInManageTravelAgentPage_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyDispatchLogin(Boolean visibilityStatus, String eMail) {
		try {
			action = new Actions(driver);
			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(6000);
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
			expected = driver.getCurrentUrl();
			if (expected.contains("dashboard"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyTravelAgentPageNavigation(Boolean visibilityStatus, String eMail) {
		try {
			action = new Actions(driver);
			action.moveToElement(travelArrangerTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(travelAgentTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.contains("manage"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfResetButton(Boolean visibilityStatus, String eMail) {
		try {
			action = new Actions(driver);
			action.moveToElement(serachTravelAgent).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			String tempEmail[] = eMail.split("@");
			serachTravelAgent.sendKeys(tempEmail[0]);
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.ENTER).build().perform();
			if (dispatchResetPWDTravelAgent.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfConfirmResetPasswordPopup(Boolean visibilityStatus, String eMail) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchResetPWDTravelAgent).click().build().perform();
			objTestBase.defaultWaitTime(2000);
			if (dispatchYesBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean clickOnNoVerifyManageTAPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchNoBtn).click().build().perform();
			objTestBase.defaultWaitTime(2000);
			driver.navigate().refresh();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.contains("manage"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean clickOnYesVerifyManageTAPage(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(dispatchYesBtn).click().build().perform();
			objTestBase.defaultWaitTime(2000);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
			if (displayStatus.isDisplayed()) {
				objTestBase.defaultWaitTime(500);
				String msgText = alertMessge.getText().toLowerCase();
				if (msgText.contains("successfully"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyResetPasswordEmail(Boolean visibilityStatus, String eMail) {
		try {
			driver.get(prop.getProperty("yopmailURL"));
			objTestBase.closePopupWindow();

			clearButton();
			objTestBase.defaultWaitTime(1000);

			eMail = emailIDSerach(eMail);
			objTestBase.defaultWaitTime(1000);

			visibilityStatus = verifyyopeMail(visibilityStatus);
			if (visibilityStatus.booleanValue() == true)
				visibilityStatus = true;
			else
				visibilityStatus = false;

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
			System.out.println("Travel Agent Email = " + eMail);
			action = new Actions(driver);
			String[] tempEmail = eMail.toString().split("@");
			searchEMailID.sendKeys(tempEmail[0]);
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
			js.executeScript("arguments[0].scrollIntoView();", resetPassword);
			objTestBase.defaultWaitTime(2000);
			resetPassword.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyConfirmResetPassword(Boolean visibilityStatus) {
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
					if (currURL.toLowerCase().contains(prop.getProperty("environment")))
						visibilityStatus = updateuaturlWithAuth(visibilityStatus, currURL);
				}
				i++;
			}
			objTestBase.closePopupWindow();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean updateuaturlWithAuth(Boolean visibilityStatus, String currURL) {
		try {
			currURL = currURL.replace("uat", "uat");
			System.out.println(currURL);
			driver.get(currURL);
			objTestBase.defaultWaitTime(3000);
			if (confirmResetPassword.get(0).isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void passwordConfirmPwdInputs() {
		try {
			action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
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

	public Boolean confirmResetPassword(Boolean visibilityStatus) {
		try {
			visibilityStatus = waitToPageLoadElementsFluentWait(visibilityStatus, confirmResetPassword);
			if (visibilityStatus.booleanValue() == true) {
				confirmResetPassword.get(0).click();
				defaultWaitTime(500);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
				if (displayStatus.isDisplayed()) {
					objTestBase.defaultWaitTime(500);
					String msgText = alertMessge.getText().toLowerCase();
					if (msgText.contains("successfully"))
						visibilityStatus = true;
					else
						visibilityStatus = false;
				} else
					visibilityStatus = false;
			} else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyLoginWithNewPassword(Boolean visibilityStatus, String eMail) {
		try {
			visibilityStatus = waitToPageLoadElementsFluentWait(visibilityStatus, signInBtn);
			if (visibilityStatus.booleanValue() == true) {
				eMailInputTA.sendKeys(eMail);
				action.sendKeys(Keys.TAB).build().perform();
				passwordInput.sendKeys(prop.getProperty("travelAgentPwd"));
				if (signInBtn.get(0).isDisplayed())
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

	public Boolean visibilityOfLoggedinUser(Boolean visibilityStatus) {
		try {
			signinUser.click();
			defaultWaitTime(5000);
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
