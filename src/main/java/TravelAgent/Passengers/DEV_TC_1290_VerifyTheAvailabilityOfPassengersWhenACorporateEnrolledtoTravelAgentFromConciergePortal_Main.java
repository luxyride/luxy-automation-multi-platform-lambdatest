package TravelAgent.Passengers;

import java.util.Set;
import common.TestBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1290_VerifyTheAvailabilityOfPassengersWhenACorporateEnrolledtoTravelAgentFromConciergePortal_Main
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

	@FindBy(xpath = "(//span[normalize-space()='Travel Arranger'])[1]")
	WebElement travelArrangerTab;

	@FindBy(xpath = "(//button[normalize-space()='Invite TA'])[1]")
	WebElement inviteTA;

	@FindBy(xpath = "(//input[@type='checkbox'])[1]")
	WebElement enrollBtn;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement activateBtn;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement yesBtn;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement alertMessage;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchfield;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailDispatch;

	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement password;

	@FindBy(xpath = "//label[@for='checkboxAgreement']")
	WebElement checkBox;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement confirmPassword;

	@FindBy(xpath = "(//span[normalize-space()='Corporate'])[1]")
	WebElement corporateBtn;

	@FindBy(xpath = "(//span[normalize-space()='Passengers'])[1]")
	WebElement passengerBtn;

	@FindBy(xpath = "(//span[normalize-space()='Travel Arranger'])[1]")
	WebElement TravelArranger;

	@FindBy(xpath = "(//span[normalize-space()='Travel Arranger'])[2]")
	WebElement travelArrangerTb;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateBtn;

	@FindBy(xpath = "//input[@id='login']")
	WebElement loginBtn;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement companyName;

	@FindBy(xpath = "(//a[normalize-space()='Add Passenger'])[1]")
	WebElement addTravel;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement lastName;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement mobile;

	@FindBy(xpath = "(//input[@type='email'])[1]")
	WebElement eMailTA;

	@FindBy(xpath = "//a[normalize-space()='Sample W9 Document']")
	WebElement w9Document;

	@FindBy(xpath = "(//input[@type='email'])[1]")
	WebElement directDeposit;

	@FindBy(xpath = "//input[@placeholder='Work Address']")
	WebElement businessAddress;

	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement website;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement alertMessge;

	@FindBy(xpath = "//input[@id='file-upload-w9']")
	WebElement w9DocumentUpload;

	@FindBy(xpath = "//i[@class='material-icons-outlined f36']")
	WebElement continueBtn;

	@FindBy(xpath = "//input[@id='file-upload-direct_deposit']")
	WebElement directDepositeDocUpload;

	@FindBy(xpath = "(//a[normalize-space()='Add Travel Arranger'])[1]")
	WebElement addTravelArrangerTab;

	@FindBy(xpath = "//font[normalize-space()='Confirm Account']")
	WebElement confirmAccount;

	TestBase objTestBase;

	public DEV_TC_1290_VerifyTheAvailabilityOfPassengersWhenACorporateEnrolledtoTravelAgentFromConciergePortal_Main(
			WebDriver driver) {
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
			eMailInput.sendKeys(prop.getProperty("conciergeadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInput() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("conciergePwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterEMail() {
		try {
			action = new Actions(driver);
			eMailDispatch.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
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

	public Boolean visibilityOfAddTravelArrangerTab(Boolean visibilityStatus) {
		try {
			if (addTravelArrangerTab.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfTravelArrangerFieldsDisplay(Boolean visibilityStatus) {
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

	public void clickTravelArrangerTb() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(travelArrangerTb).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickTravelArrangerTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(travelArrangerTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfManageTAPage(Boolean visibilityStatus) {
		try {
			if (inviteTA.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void enterSearchField(String eMail) {
		try {
			searchfield.sendKeys(eMail);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfTravelArrangerdetailsbasedonSearchcriteria(Boolean visibilityStatus) {
		try {
			if (enrollBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnEnrollBtn() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(enrollBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityofpopupmessage(Boolean visibilityStatus) {
		try {
			if (yesBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnYesBtn() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(yesBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityofAlertMessage(Boolean visibilityStatus) {
		try {
			if (alertMessage.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnSignin() {
		try {
			signInBtn.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean enterDetailsTravelAgentForm(Boolean visibilityStatus) {
		try {
			companyName.sendKeys(prop.getProperty("travelAgentCName") + "_" + currDateTime);
			defaultWaitTime(500);
			firstName.sendKeys(prop.getProperty("fName"));
			defaultWaitTime(500);
			lastName.sendKeys(prop.getProperty("lName"));
			defaultWaitTime(500);
			mobile.sendKeys(prop.getProperty("phoneNumber"));
			defaultWaitTime(500);
			eMail = prop.getProperty("regeMail") + currDateTime + prop.getProperty("eMailDomain");
			eMailTA.sendKeys(eMail);
			defaultWaitTime(500);
			for (int i = 1; i <= 11; i++) {
				action.sendKeys(Keys.TAB).build().perform();
			}
			defaultWaitTime(5000);
			visibilityStatus = uploadDocuments(visibilityStatus);
			if (visibilityStatus.booleanValue() == true)
				visibilityStatus = true;
			else {
				visibilityStatus = false;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}

		return visibilityStatus;
	}

	public Boolean uploadDocuments(Boolean visibilityStatus) {
		try {
			if (System.getProperty("user.name").equalsIgnoreCase("circleci")) // Docker Env. User Name
			{
				w9DocumentUpload.sendKeys(dockerTravelAgentDocsPath + "W9Test.pdf");
				defaultWaitTime(15000);
				directDepositeDocUpload.sendKeys(dockerTravelAgentDocsPath + "TestDDForm.pdf");
				defaultWaitTime(15000);
			} else {
				w9DocumentUpload.sendKeys(localTravelAgentDocsPath + "W9Test.pdf");
				defaultWaitTime(15000);
				directDepositeDocUpload.sendKeys(localTravelAgentDocsPath + "TestDDForm.pdf");
				defaultWaitTime(15000);
			}
			defaultWaitTime(3000);
			if (updateBtn.isDisplayed())
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

	public void clickaddTravelArrangerTab() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(addTravelArrangerTab).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterEmail(String eMail) {
		try {
			action = new Actions(driver);
			eMailDispatch.sendKeys(eMail);

			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnUpdateBtn() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(updateBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void searchInput(String eMail) {
		try {
			action = new Actions(driver);
			loginBtn.sendKeys(eMail);
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityofConfirmAccount(Boolean visibilityStatus) {
		try {
			driver.switchTo().frame("ifmail");
			objTestBase.defaultWaitTime(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", confirmAccount);
			objTestBase.defaultWaitTime(2000);
			if (confirmAccount.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnGo() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(continueBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean switchToWindow(Boolean visibilityStatus) {
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
				}
				i++;
			}
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains("luxyride"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnConfirmAccount() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(confirmAccount).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterPasswordInput() {
		try {
			action = new Actions(driver);
			password.sendKeys(prop.getProperty("regPwd"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void confirmPwdInput() {
		try {
			action = new Actions(driver);
			confirmPassword.sendKeys(prop.getProperty("regPwd"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickCheckBox() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(checkBox).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfActivateBtn(Boolean visibilityStatus) {
		try {
			if (activateBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnActivateBtn() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(activateBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnCorporate() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(corporateBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnPassenger() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(passengerBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfManagePassenger(Boolean visibilityStatus) {
		try {
			if (addTravel.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

}
