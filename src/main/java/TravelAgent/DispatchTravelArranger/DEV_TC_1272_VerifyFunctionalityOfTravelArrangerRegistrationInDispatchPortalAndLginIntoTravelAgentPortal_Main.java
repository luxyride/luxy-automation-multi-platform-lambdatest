package TravelAgent.DispatchTravelArranger;

import common.TestBase;

import java.time.Duration;

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

public class DEV_TC_1272_VerifyFunctionalityOfTravelArrangerRegistrationInDispatchPortalAndLginIntoTravelAgentPortal_Main
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

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbooking;

	@FindBy(xpath = "(//span[text()='Travel Arranger'])[1]")
	WebElement travelArrangerHeaderTab;

	@FindBy(xpath = "(//span[text()='Travel Arranger'])[2]")
	WebElement travelArrangerTab;

	@FindBy(xpath = "//*[contains(text(),'Manage Travel Arranger')]")
	WebElement travelArrangerHeader;

	@FindBy(xpath = "(//*[normalize-space()='Add Travel Arranger'])[1]")
	WebElement addtravelArrangerBtn;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement serachTravelAgent;

	@FindBy(xpath = "//i[@title='Edit Travel Agent']")
	WebElement editTravelAgent;

	@FindBy(xpath = "//*[@for='exampleFormControlInput1' and contains(normalize-space(),'Company Name')]//following-sibling::input")
	WebElement companyName;

	@FindBy(xpath = "//*[@for='exampleFormControlInput1' and contains(normalize-space(),'First Name')]//following-sibling::input")
	WebElement firstName;

	@FindBy(xpath = "//*[@for='exampleFormControlInput1' and contains(normalize-space(),'Last Name')]//following-sibling::input")
	WebElement lastName;

	@FindBy(xpath = "//*[@for='exampleFormControlInput1' and contains(normalize-space(),'Email')]//following-sibling::input")
	WebElement eMailTravelArranger;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement mobile;

	@FindBy(xpath = "//input[@id='file-upload-w9']")
	WebElement w9DocumentUpload;

	@FindBy(xpath = "//input[@id='file-upload-direct_deposit']")
	WebElement directDepositeDocUpload;

	@FindBy(xpath = "//input[@id='login']")
	WebElement searchInput;

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

	@FindBy(xpath = "//*[normalize-space()='Travel Arranger Registration']")
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

	// Travel Agent Elements:
	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInputTA;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInputTA;

	@FindBy(xpath = "//*[@type='submit' and normalize-space()='Sign In']")
	WebElement signInBtnTA;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUserTA;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbookingTA;

	TestBase objTestBase;

	public DEV_TC_1272_VerifyFunctionalityOfTravelArrangerRegistrationInDispatchPortalAndLginIntoTravelAgentPortal_Main(
			WebDriver driver) {
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
			Boolean visibilityStatus = false;
			visibilityStatus = validateDispatchBypassCode(visibilityStatus);
			utillLogger.info(
					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus);
		} catch (Exception e) {
			e.printStackTrace();
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
				if (expected.toLowerCase().contains("welcome"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyTravelArrangerTabNavigation(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(travelArrangerHeaderTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(travelArrangerTab).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			if (travelArrangerHeader.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyAddTravelArrangerPageNavigation(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(addtravelArrangerBtn).click().build().perform();
			objTestBase.defaultWaitTime(3000);
			expected = driver.getCurrentUrl();
			if (expected.contains("register"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public String verifyRegistrationOfTravelArranger(Boolean visibilityStatus, String eMail) {
		try {
			if (travelAgentlbl.isDisplayed()) {
				action = new Actions(driver);
				companyName.sendKeys(prop.getProperty("travelAgentCName") + "_" + currDateTime);
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
				objTestBase.defaultWaitTime(1000);

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,600)", "");
				objTestBase.defaultWaitTime(2000);

				visibilityStatus = uploadDocuments(visibilityStatus);
				if (visibilityStatus.booleanValue() == true)
					visibilityStatus = true;
				else {
					visibilityStatus = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return eMail;
	}

	public Boolean uploadDocuments(Boolean visibilityStatus) {
		try {
			if (System.getProperty("user.name").equalsIgnoreCase("circleci")) // Docker Env. User Name
			{
				w9DocumentUpload.sendKeys(dockerTravelAgentDocsPath + "W9Test.pdf");
				utillLogger.info("Travel Agent Docker Path = " + dockerTravelAgentDocsPath + "W9Test.pdf");
				defaultWaitTime(15000);
				directDepositeDocUpload.sendKeys(dockerTravelAgentDocsPath + "TestDDForm.pdf");
				utillLogger.info("Travel Agent Docker Path = " + dockerTravelAgentDocsPath + "TestDDForm.pdf");
				defaultWaitTime(15000);
			} else {
				w9DocumentUpload.sendKeys(localTravelAgentDocsPath + "W9Test.pdf");
				utillLogger.info("Travel Agent Local Path = " + localTravelAgentDocsPath + "W9Test.pdf");
				defaultWaitTime(15000);
				directDepositeDocUpload.sendKeys(localTravelAgentDocsPath + "TestDDForm.pdf");
				utillLogger.info("Travel Agent Local Path = " + localTravelAgentDocsPath + "TestDDForm.pdf");
				defaultWaitTime(15000);
			}
			defaultWaitTime(3000);
			if (register.isDisplayed())
				visibilityStatus = true;
			else {
				visibilityStatus = false;

			}
		} catch (Exception e) {
			e.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfConfimrationMessage(Boolean visibilityStatus) {
		try {
			register.click();
			defaultWaitTime(2000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
			if (displayStatus.isDisplayed() && displayStatus.getText().toLowerCase().contains("saved"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	// Travel Agent Methods:
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
			passwordInputTA.sendKeys(prop.getProperty("travelAgentPwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSigninButtonTA(Boolean visibilityStatus) {
		try {
			if (signInBtnTA.isDisplayed())
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
			action = new Actions(driver);
			action.moveToElement(signInBtnTA).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickNewBookingTA() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(newbookingTA).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUserTA(Boolean visibilityStatus) {
		try {
			waitTimeForElement(signinUserTA);
			if (signinUser.isDisplayed()) {
				expected = signinUserTA.getText();
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

}
