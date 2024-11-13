package TravelAgent.DispatchTravelArranger;

import common.TestBase;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1271_VerifyDeleteTravelArrangerButtonFunctionalityInManageTravelArrangerPage_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	TestBase objTestBase;
	String currURL;

	@FindBy(xpath = "//input[@type='text']")
	WebElement dispatcheMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement dispatchpasswordInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement dispatchsignInBtn;

	@FindBy(xpath = "(//span[text()='Travel Arranger'])[1]")
	WebElement travelArrangerHeaderTab;

	@FindBy(xpath = "(//span[text()='Travel Arranger'])[2]")
	WebElement travelArrangerTab;

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

	@FindBy(xpath = "//i[@title='Delete Travel Arranger']")
	WebElement dispatchDeleteTravelAgent;

	public DEV_TC_1271_VerifyDeleteTravelArrangerButtonFunctionalityInManageTravelArrangerPage_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Boolean deleteCreatedUserfromDispatch(Boolean visibilityStatus, String eMail) {
		try {
			action = new Actions(driver);
			driver.get(prop.getProperty("dispatchURL"));
			driver.manage().window().maximize();
			objTestBase.defaultWaitTime(3000);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(dispatcheMailInput));

			if (displayStatus.isDisplayed()) {
				dispatcheMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
				objTestBase.defaultWaitTime(500);
				action.sendKeys(Keys.TAB).build().perform();
				dispatchpasswordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
				objTestBase.defaultWaitTime(500);

				try {
					dispatchsignInBtn.click();
					// Validate Dispatch 2fa Authentication:
					Boolean visibilityStatus1 = false;
//					visibilityStatus1 = validateDispatchBypassCode(visibilityStatus1);
					utillLogger.info("2FA Validation Status for Script - " + getClass().getSimpleName() + " = "
							+ visibilityStatus1);
				} catch (Exception e) {
					// TODO: handle exception
				}
				objTestBase.defaultWaitTime(3000);
				action.moveToElement(travelArrangerHeaderTab).click().build().perform();
				objTestBase.defaultWaitTime(1000);
				action.moveToElement(travelArrangerTab).click().build().perform();
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
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}
}
