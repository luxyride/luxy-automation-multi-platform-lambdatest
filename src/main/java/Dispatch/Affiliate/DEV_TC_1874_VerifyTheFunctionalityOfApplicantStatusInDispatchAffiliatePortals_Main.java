package Dispatch.Affiliate;

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

public class DEV_TC_1874_VerifyTheFunctionalityOfApplicantStatusInDispatchAffiliatePortals_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	String currURL;

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

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbooking;

	@FindBy(xpath = "(//span[normalize-space()='Affiliates'])[1]")
	WebElement affiliatesTab;

	@FindBy(xpath = "(//span[normalize-space()='Affiliate Leads'])[1]")
	WebElement affiliateLeadsTab;
	
	@FindBy(xpath = "(//input[@placeholder='Search'])[1]")
	WebElement searchAffiliate;

	@FindBy(xpath = "//td[normalize-space()='There is no data to display']")
	List<WebElement> noDataMsg;

	@FindBy(xpath = "//a[normalize-space()='Inactive Affiliates']")
	WebElement inActiveTab;

	@FindBy(xpath = "//i[@title='Affiliate Payment']")
	WebElement affiliatePaymentBtn;

	@FindBy(xpath = "(//i[@title='Edit Affiliate User'])[1]")
	WebElement editBtn;

	@FindBy(xpath = "(//img[@title='Reset Password'])[1]")
	WebElement resetPasswordBtn;

	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement deleteBtn;

	@FindBy(xpath = "(//i[@title='Affiliate Profile'])[1]")
	WebElement profileBtn;

	@FindBy(xpath = "(//i[@title='Edit Affiliate Lead'])[1]")
	WebElement editIcon;

	@FindBy(xpath = "//select[@name='applicant_status']")
	WebElement statusDropDown;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateBtn;

	@FindBy(xpath = "//option[@value='In Progress']")
	WebElement inprogress;

	// User Account Activation
	@FindBy(xpath = "//div[@id='clearbut']//a")
	List<WebElement> clearBtn;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtn;

	@FindBy(xpath = "(//a[normalize-space()='Customer Login'])[2]")
	WebElement customerLogin;

	@FindBy(xpath = "//*[@id='mail']//font[normalize-space()='Confirm Account']")
	WebElement confirmEmailAccount;

	@FindBy(xpath = "(//*[@type='password'])[1]")
	WebElement password;

	@FindBy(xpath = "(//*[@type='password'])[2]")
	WebElement confirmPassword;

	@FindBy(xpath = "//input[@id='password'][1]")
	WebElement reloginPwd;

	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
	WebElement loggedInDrpdwn;

	@FindBy(xpath = "//button[normalize-space()='Activate']")
	WebElement confirmAccount;

	@FindBy(xpath = "(//*[(@role='alert')])[1]")
	WebElement alertMessge;

	// Affiliate Portal:
	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInputAffiliate;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInputAffiliate;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement eyeIconAffiliate;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtnAffiliate;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUserAffiliate;

	@FindBy(xpath = "//span[@class='affiliate-application-status']//span")
	WebElement status;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement successMsg;

	TestBase objTestBase;

	public DEV_TC_1874_VerifyTheFunctionalityOfApplicantStatusInDispatchAffiliatePortals_Main(WebDriver driver) {
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
			eMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
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
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public void clickSigninButton() {
		try {
			signInBtn.click();
			// Validate Dispatch 2fa Authentication:
//			Boolean visibilityStatus = false;
//			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
//			utillLogger.info(
//					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception e) {
			// TODO: handle exception
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

	public Boolean verifyAffiliatesPageNavigationTab(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(affiliateLeadsTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			action.moveToElement(affiliatesTab).click().build().perform();
			objTestBase.defaultWaitTime(2000);

			expected = driver.getCurrentUrl();
			objTestBase.defaultWaitTime(1000);
			if (expected.toLowerCase().contains("affiliate"))
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifySearchAffiliate(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			searchAffiliate.click();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(searchAffiliate).click().sendKeys(eMail).build().perform();
			objTestBase.defaultWaitTime(5000);

			if (searchAffiliate.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void clickOnEditIcon() {
		try {
			action = new Actions(driver);
			action.moveToElement(editIcon).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyApplicantStatusDropDown(Boolean visibilityStatus) {
		try {
			if (statusDropDown.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public void clickOnStatusDropDown() {
		try {
			action = new Actions(driver);
			action.moveToElement(statusDropDown).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean verifyApplicantStatusDropDownList(Boolean visibilityStatus) {
		try {
			if (inprogress.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}

	public void affiliatepasswordInput() {
		try {
			action = new Actions(driver);
			action.moveToElement(password).click().sendKeys(prop.getProperty("affiliatePwd")).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void affiliateconfirmPassword() {
		try {
			action = new Actions(driver);
			action.moveToElement(confirmPassword).click().sendKeys(prop.getProperty("affiliatePwd")).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnTermsAndConditionsCheckbox() {
		try {
			js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelector(\"input[id=checkboxAgreement]\").click();");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String enterEmail() {
		action = new Actions(driver);
		eMailInput.sendKeys(eMail);
		action.sendKeys(Keys.TAB).build().perform();
		return eMail;
	}

	public Boolean visibilityOfActivateAccountConfirmationMsg(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			action.moveToElement(confirmAccount).click().build().perform();

			String msgText = "";
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
			if (displayStatus.isDisplayed()) {
				objTestBase.defaultWaitTime(500);
				msgText = alertMessge.getText().toLowerCase();
				visibilityStatus = true;
			} else
				visibilityStatus = false;
			objTestBase.defaultWaitTime(1000);
			if (visibilityStatus == true && msgText.contains("activated"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
			System.out.println(msgText);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	// User Account Activation:
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
		expected = driver.getCurrentUrl();
		if (expected.toLowerCase().contains("yopmail"))
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void confirmEmailAccount() {
		try {
			driver.switchTo().frame("ifmail");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", confirmEmailAccount);
			confirmEmailAccount.click();
			defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyConfirmAccountPasswordPage(Boolean visibilityStatus) {
		Set<String> listOfWindows = driver.getWindowHandles();
		int i = 0;
		for (String currWindow : listOfWindows) {
			if (i == 2) {
				driver.switchTo().window(currWindow);
				try {
					defaultWaitTime(5000);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
			i++;
		}
		return visibilityStatus;
	}

	public Boolean updateuaturlWithAuth(Boolean visibilityStatus, String currURL) {
		try {
			currURL = currURL.replace("uat", "uat");
			System.out.println(currURL);
			driver.get(currURL);
			objTestBase.defaultWaitTime(3000);
			if (confirmAccount.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyAffiliatePageLoad(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.contains("affiliate"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void eMailInputAffiliate(String eMail) {
		action = new Actions(driver);
		eMailInputAffiliate.sendKeys(eMail);
		action.sendKeys(Keys.TAB).build().perform();
	}

	public void passwordInputAffiliate() {
		action = new Actions(driver);
		passwordInputAffiliate.sendKeys(prop.getProperty("affiliatePwd"));
	}

	public void eyeIconClickAffiliate() {
		action = new Actions(driver);
		action.moveToElement(eyeIconAffiliate).click().build().perform();
	}

	public Boolean visibilityOfSigninButtonAffiliate(Boolean visibilityStatus) {
		if (signInBtnAffiliate.isDisplayed())
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void clickSigninButtonAffiliate() {
		signInBtn.click();
	}

	public Boolean visibilityOfLoggedinUserAffiliate(Boolean visibilityStatus) {
		try {
			waitTimeForElement(signinUserAffiliate);
			if (signinUserAffiliate.isDisplayed()) {
				expected = signinUserAffiliate.getText();
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

	public Boolean visibilityOfStatusInAffiliatePage(Boolean visibilityStatus) {
		try {
			waitTimeForElement(status);
			if (status.isDisplayed()) {
				expected = status.getText();
			} else {
				visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void selectFromDropDown() {
		try {
			action = new Actions(driver);
			statusDropDown.click();
			objTestBase.defaultWaitTime(2000);
			WebElement approvedOption = driver.findElement(By.xpath("//option[@value='Approved']"));
			approvedOption.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception e) {
		}

	}

	public void clickOnUpdate() {
		try {
			defaultWaitTime(1000);
			updateBtn.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean verifySuccessMessageAfterUpdatingStatus(Boolean visibilityStatus) {
		try {
			waitTimeForElement(successMsg);
			if (successMsg.isDisplayed()) {
				expected = successMsg.getText();
				if (expected.toLowerCase().contains("success")) {
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

	public Boolean VerifyvisibilityOfStatusInAffiliatePage(Boolean visibilityStatus) {
		try {
			if (!status.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return visibilityStatus;
	}
}
