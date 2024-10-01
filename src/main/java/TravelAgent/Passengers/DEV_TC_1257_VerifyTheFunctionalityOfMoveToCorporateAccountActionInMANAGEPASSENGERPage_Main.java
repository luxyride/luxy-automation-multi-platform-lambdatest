package TravelAgent.Passengers;

import common.TestBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1257_VerifyTheFunctionalityOfMoveToCorporateAccountActionInMANAGEPASSENGERPage_Main
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

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement lastName;

	@FindBy(xpath = "(//input[@placeholder='Mobile Number'])[1]")
	WebElement mobile;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement eMailTA;

	@FindBy(xpath = "//div[@role='alert']")
	WebElement alert;

	@FindBy(xpath = "//span[normalize-space()='Move']")
	WebElement confirmMove;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement signinUser;

	@FindBy(xpath = "(//span[normalize-space()='New Booking'])[1]")
	WebElement newbooking;

	@FindBy(xpath = "(//span[normalize-space()='Passengers'])[1]")
	WebElement passengerTab;

	@FindBy(xpath = "(//a[normalize-space()='Add Passenger'])")
	WebElement addPassengerTab;

	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement search;

	@FindBy(xpath = "//i[@title='Move to Corporate Account']")
	WebElement moveBtn;

	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//input[@class='form-control col-sm-12']")
	WebElement corpInput;

	TestBase objTestBase;

	public DEV_TC_1257_VerifyTheFunctionalityOfMoveToCorporateAccountActionInMANAGEPASSENGERPage_Main(
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
			if (addPassengerTab.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnaddPassengerTab() {
		try {
			action = new Actions(driver);
			action.moveToElement(addPassengerTab).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfPassengerdetailsPage(Boolean visibilityStatus) {
		try {
			if (firstName.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
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

	public void clickSigninButton() {
		try {
			signInBtn.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean enterDetailsPassengerInformation(Boolean visibilityStatus) {
		try {
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
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void clickOnconfirmMove() {
		try {
			confirmMove.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void entersearchfield() {
		try {
			action = new Actions(driver);
			search.sendKeys(prop.getProperty("regeMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickonMoveBtn() {
		try {
			moveBtn.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterFirstName() {
		try {
			action = new Actions(driver);
			firstName.clear();
			firstName.sendKeys(prop.getProperty("fName"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterEmail() {
		try {
			action = new Actions(driver);
			eMailTA.clear();
			eMail = prop.getProperty("regeMail") + currDateTime + prop.getProperty("eMailDomain");
			eMailTA.sendKeys(eMail);
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfCancelBtn(Boolean visibilityStatus) {
		try {
			if (cancelBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnCancelBtn() {
		try {
			cancelBtn.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfMoveBtn(Boolean visibilityStatus) {
		try {
			if (confirmMove.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfAlertmessage(Boolean visibilityStatus) {
		try {
			if (alert.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void enterCorpInput() {
		try {
			action = new Actions(driver);
			corpInput.sendKeys(prop.getProperty("lName"));
			objTestBase.defaultWaitTime(3000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(1000);
			action.click();
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(2000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
