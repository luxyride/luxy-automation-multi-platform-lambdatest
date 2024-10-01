package Affiliate.Login;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import common.TestBase;
import java.time.Duration;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_911_VerifyLoggingintotheRegisteredAffiliate_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	JavascriptExecutor js;
	TestBase objTestBase;
	String currURL;

	@FindBy(xpath = "//a[normalize-space()='Programs']")
	WebElement programsDrpdwn;

	@FindBy(xpath = "//a[normalize-space()='Affiliate']")
	WebElement affiliate;

	@FindBy(xpath = "//a[normalize-space()='JOIN US']")
	WebElement joinUsBtn;

	@FindBy(xpath = "//input[@id='companyName']")
	WebElement companyName;

	@FindBy(xpath = "//input[@id='firstName']")
	WebElement fName;

	@FindBy(xpath = "//input[@id='lastName']")
	WebElement lName;

	@FindBy(xpath = "(//input[@id='email'])[1]")
	WebElement eMailInput;

	@FindBy(xpath = "(//input[@class='PhoneInputInput'])[1]")
	WebElement phoneInput;

	@FindBy(xpath = "//input[@id='affliliate_addr']")
	WebElement businessAddress;

	@FindBy(xpath = "//input[@id='website']")
	WebElement websiteInput;

	@FindBy(xpath = "(//input[@id='formBasicCheckbox'])[1]")
	WebElement termsConditionsChckbx;

	@FindBy(xpath = "(//input[@id='formBasicCheckbox'])[2]")
	WebElement agreeChckbx;

	@FindBy(xpath = "//button[normalize-space()='Create']")
	WebElement signupCreateBtn;

	@FindBy(xpath = "//b[normalize-space()='Success!']")
	WebElement successMsg;

	@FindBy(xpath = "//div[@class='modal-body']")
	WebElement mailBody;

	// User Account Activation
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

	@FindBy(xpath = "(//*[text()='Sign In'])[1]")
	WebElement signInBtn;

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

	@FindBy(xpath = "(//span[normalize-space()='Rides'])[1]")
	WebElement ridesTabAffiliate;

	@FindBy(xpath = "(//span[normalize-space()='All'])[1]")
	WebElement allTabAffiliate;

	public DEV_TC_911_VerifyLoggingintotheRegisteredAffiliate_Main(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		objTestBase = new TestBase();
	}

	public Boolean visibilityOfProgramsDropdown(Boolean visibilityStatus) {
		if (programsDrpdwn.isDisplayed())
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void clickOnPrograms() {
		action = new Actions(driver);
		action.moveToElement(programsDrpdwn).click().build().perform();
	}

	public void clickOnAffiliate() {
		action = new Actions(driver);
		action.moveToElement(affiliate).click().build().perform();
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


	public Boolean verifyAffiliatePage(Boolean visibilityStatus) {
		expected = driver.getCurrentUrl();
		if (expected.toLowerCase().contains(prop.getProperty("environment"))
				&& expected.toLowerCase().contains("affiliate"))
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfSignupBtn(Boolean visibilityStatus) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
		WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(joinUsBtn));
		if (displayStatus.isDisplayed())
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfSignupCreateBtn(Boolean visibilityStatus) {
		if (signupCreateBtn.isDisplayed())
			visibilityStatus = true;
		else
			visibilityStatus = false;
		return visibilityStatus;
	}

	public void clickOnJoinUS() {
		try {
			action = new Actions(driver);
			action.moveToElement(joinUsBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public String enterAllDetails(String eMail) throws Exception {
		try {
			action = new Actions(driver);
			for (int i = 1; i <= 5; i++) {
				action.sendKeys(Keys.ARROW_DOWN).build().perform();
			}

			currDateTime = GetCurrentDateTime.getCurrentDateTime(currDateTime);

			companyName.sendKeys(prop.getProperty("affiliateCName") + "_" + currDateTime);
			fName.sendKeys(prop.getProperty("affiliateFName"));
			lName.sendKeys(prop.getProperty("affiliateLName"));

			// luxyqatestMMDDYYYY_HHMMSS@yopmail.com
			eMail = prop.getProperty("affiliateMailRegression") + currDateTime + prop.getProperty("eMailDomain");

			action.sendKeys(Keys.TAB).build().perform();
			eMailInput.sendKeys(eMail);

			phoneInput.sendKeys(prop.getProperty("phoneNumber"));

			businessAddress.sendKeys("JFK");
			objTestBase.defaultWaitTime(4000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(2000);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(2000);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);

			websiteInput.sendKeys(prop.getProperty("websiteInput"));
			objTestBase.defaultWaitTime(1000);
			termsConditionsChckbx.click();
			objTestBase.defaultWaitTime(500);
			agreeChckbx.click();
			objTestBase.defaultWaitTime(500);

			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(500);
			action.sendKeys(Keys.TAB).build().perform();
			objTestBase.defaultWaitTime(500);

			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,200)", "");
			objTestBase.defaultWaitTime(2000);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return eMail;
	}

	public void clickOnSignupCreateBtn() throws Exception {
		objTestBase.defaultWaitTime(1000);
		signupCreateBtn.click();
		objTestBase.defaultWaitTime(1000);
	}

	public Boolean visibilityOfSignupConfirmationMsg(Boolean visibilityStatus) {
		if (successMsg.isDisplayed()) {
			expected = successMsg.getText();

			if (expected.toLowerCase().contains("success")) {
				visibilityStatus = true;
			} else {
				visibilityStatus = false;
			}

		} else
			visibilityStatus = false;
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
			JavascriptExecutor js =  (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", confirmEmailAccount);
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
				driver.switchTo().window(currWindow);	try	{	defaultWaitTime(5000);	}	catch (Exception e)	{	e.printStackTrace(); }
				currURL = driver.getCurrentUrl();
				if (currURL.toLowerCase().contains("uat"))
					visibilityStatus = updateuaturlWithAuth(visibilityStatus, currURL);
				else
					visibilityStatus = true;
				break;
			}
			i++;
		}
		objTestBase.closePopupWindow();
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

	public void passwordInput() {
		try {
			action = new Actions(driver);
			action.moveToElement(password).click().sendKeys(prop.getProperty("affiliatePwd")).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void confirmPassword() {
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

	public void clickOnRidesAffiliate() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(ridesTabAffiliate).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnAllTabAffiliate() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(allTabAffiliate).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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

}
