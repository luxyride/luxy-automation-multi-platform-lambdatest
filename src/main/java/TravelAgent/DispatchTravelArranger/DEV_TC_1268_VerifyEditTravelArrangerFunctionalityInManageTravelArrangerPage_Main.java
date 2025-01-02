package TravelAgent.DispatchTravelArranger;

import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1268_VerifyEditTravelArrangerFunctionalityInManageTravelArrangerPage_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailDispatch;

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

	@FindBy(xpath = "(//span[normalize-space()='Travel Arranger'])[2]")
	WebElement travelArrangerTab;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement searchField;

	@FindBy(xpath = "(//i[@title='Edit Travel Arranger'])[1]")
	WebElement editBtn;

	@FindBy(xpath = "(//i[@title='Edit Travel Arranger'])[1]")
	WebElement editProfile;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement updateBtn;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement lastName;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement mobile;

	@FindBy(xpath = "(//input[@type='email'])[1]")
	WebElement eMailTA;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement alert;

	@FindBy(xpath = "//input[@id='file-upload-w9']")
	WebElement w9DocumentUpload;

	@FindBy(xpath = "//input[@id='file-upload-direct_deposit']")
	WebElement directDepositeDocUpload;
	TestBase objTestBase;

	public DEV_TC_1268_VerifyEditTravelArrangerFunctionalityInManageTravelArrangerPage_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
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
		if (signInBtn.isDisplayed())
			visibilityStatus = true;
		else
			visibilityStatus = false;
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

	public Boolean visibilityOfEditTravelArrangerProfile(Boolean visibilityStatus) {
		try {
			if (firstName.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
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

	public void enterSearchField() {
		try {
			action = new Actions(driver);
			searchField.sendKeys(prop.getProperty("regeMail"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickOnEditBtn() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(editBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterfirstName() {
		try {
			action = new Actions(driver);
			firstName.clear();
			objTestBase.defaultWaitTime(1000);
			firstName.sendKeys(prop.getProperty("fName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterLastName() {
		try {
			action = new Actions(driver);
			lastName.clear();
			objTestBase.defaultWaitTime(1000);
			lastName.sendKeys(prop.getProperty("lName"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterEmail() {
		try {
			action = new Actions(driver);
			eMailTA.clear();
			eMailTA.sendKeys(prop.getProperty("travelAgentEMail"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterMobile() {
		try {
			action = new Actions(driver);
			mobile.clear();
			objTestBase.defaultWaitTime(1000);
			mobile.sendKeys(prop.getProperty("phoneNumber"));
			objTestBase.defaultWaitTime(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean visibilityOfCancelBtn(Boolean visibilityStatus) {
		try {
			if (cancelBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnCancel() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(cancelBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfManageTravelArrangerPage(Boolean visibilityStatus) {
		try {
			if (travelArrangerTab.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfConfirmBtn(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
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
			if (updateBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnupdateBtn() {
		try {
			action = new Actions(driver);
			objTestBase.defaultWaitTime(1000);
			action.moveToElement(updateBtn).click().build().perform();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfAlertMessage(Boolean visibilityStatus) {
		try {
			if (alert.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

}
