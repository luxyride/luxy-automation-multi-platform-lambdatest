package TravelAgent.AccountCreation;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import common.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1192_VerifyUIofTravelAgentRegistrationFormInWebPortal_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String currURL;

	@FindBy(xpath = "//*[text()='Programs']")
	WebElement programsDrpdwn;

	@FindBy(xpath = "//a[normalize-space()='Travel Agent']")
	WebElement travelAgentOption;

	@FindBy(xpath = "(//*[text()='Sign In'])[1]")
	WebElement signInBtn;

	@FindBy(xpath = "//a[normalize-space()='Customer Login']")
	WebElement customerLogin;

	@FindBy(xpath = "//input[@id='email'][1]")
	WebElement eMailInput;

	@FindBy(xpath = "//*[@type='password']")
	WebElement password;

	@FindBy(xpath = "//a[contains(text(),'Welcome')]")
	WebElement loggedInDrpdwn;

	@FindBy(xpath = "//button[normalize-space()='Sign In']")
	WebElement signInBtnfromHomePage;

	@FindBy(xpath = "//span[text()='JOIN THE LUXY™ TRAVEL AGENT PROGRAM']")
	WebElement joinTABtn;

	// Travel Agent Registration Form Fields:
	@FindBy(xpath = "//input[@id='companyName']")
	List<WebElement> companyName;
	@FindBy(xpath = "//input[@id='firstName']")
	List<WebElement> firstName;
	@FindBy(xpath = "//input[@id='lastName']")
	List<WebElement> lastName;
	@FindBy(xpath = "//input[@id='email']")
	List<WebElement> email;
	@FindBy(xpath = "//input[@type='tel']")
	List<WebElement> mobileNumber;
	@FindBy(xpath = "//*[contains(text(),'W9 DOCUMENT')]")
	List<WebElement> w9Document;
	@FindBy(xpath = "//*[contains(text(),'DIRECT DEPOSIT')]")
	List<WebElement> directDiposit;
	@FindBy(xpath = "//input[@id='affliliate_addr']")
	List<WebElement> businessAddress;
	@FindBy(xpath = "//input[@id='website']")
	List<WebElement> website;

	public DEV_TC_1192_VerifyUIofTravelAgentRegistrationFormInWebPortal_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfProgramsDropdown(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			if (programsDrpdwn.isDisplayed()) {
				action.moveToElement(programsDrpdwn).click().build().perform();
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnTravelAgent() {
		try {
			travelAgentOption.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean verifyTravelAgentPageNavigation(Boolean visibilityStatus) {
		try {
			Set<String> listOfWindows = driver.getWindowHandles();
			int i = 0;
			for (String currWindow : listOfWindows) {
				if (i == 1) {
					driver.switchTo().window(currWindow);	try	{	defaultWaitTime(5000);	}	catch (Exception e)	{	e.printStackTrace(); }
					visibilityStatus = true;
				}
				i++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean switchBacktoHomepage(Boolean visibilityStatus) {
		try {
			Set<String> listOfWindows = driver.getWindowHandles();
			int i = 0;
			for (String currWindow : listOfWindows) {
				if (i == 0) {
					driver.switchTo().window(currWindow);	try	{	defaultWaitTime(5000);	}	catch (Exception e)	{	e.printStackTrace(); }
					visibilityStatus = true;
				}
				i++;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickLogin() throws InterruptedException {
		try {
			action = new Actions(driver);
			action.moveToElement(signInBtn).click().build().perform();
			Thread.sleep(1000);
			if (customerLogin.isDisplayed())
				action.moveToElement(customerLogin).click().build().perform();
			Thread.sleep(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
			WebElement ele = driver.findElement(By.xpath("//*[@id='responsive-navbar-nav']/div/a[4]"));
			ele.click();
			Thread.sleep(1000);
		}
	}

	public void enterEmail() {
		try {
			action = new Actions(driver);
			eMailInput.sendKeys(prop.getProperty("sanityeMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordRelogin() {
		try {
			action = new Actions(driver);
			password.sendKeys(prop.getProperty("sanityPwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnSignInBtn() {
		try {
			action = new Actions(driver);
			action.moveToElement(signInBtnfromHomePage).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean loggedInDrpdwn(Boolean visibilityStatus) {
		try {
			waitTimeForElement(loggedInDrpdwn);
			if (loggedInDrpdwn.isDisplayed()) {
				String tempText = loggedInDrpdwn.getText();
				if (tempText.toLowerCase().contains("welcome")) {
					visibilityStatus = true;
				} else {
					visibilityStatus = false;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfSignInButton(Boolean visibilityStatus) {
		try {
			if (signInBtnfromHomePage.isDisplayed()) {
				visibilityStatus = true;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfJoinTheLuxyAgentProgramBtn(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(joinTABtn));
			if (displayStatus.isDisplayed()) {
				visibilityStatus = true;
			} else {
				visibilityStatus = false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verificationOfTARegistrationForm(Boolean visibilityStatus) {
		try {
			joinTABtn.click();
			defaultWaitTime(8000);
			if (environmentCode.equalsIgnoreCase("dev")) {
				currURL = driver.getCurrentUrl();
				if (currURL.contains("uat")) {
					currURL = currURL.replace("uat", "dev");
					driver.get(currURL);
					if (currURL.contains("dev"))
						visibilityStatus = true;
				}
				currURL = driver.getCurrentUrl();
			} else if (environmentCode.equalsIgnoreCase("uat")) {
				currURL = driver.getCurrentUrl();
				if (currURL.contains("uat")) {
					currURL = currURL.replace("uat", "uat");
					driver.get(currURL);
					if (currURL.contains("dev"))
						visibilityStatus = true;
				}
				currURL = driver.getCurrentUrl();
			}

			if (currURL.contains("travelagent"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfTravelAgentFieldsDisplay(Boolean visibilityStatus) {
		try {
			if (companyName.size() != 0 && firstName.size() != 0 && lastName.size() != 0 && email.size() != 0
					&& lastName.size() != 0 && mobileNumber.size() != 0 && w9Document.size() != 0
					&& directDiposit.size() != 0 && businessAddress.size() != 0 && website.size() != 0)
				visibilityStatus = true;
			else
				visibilityStatus = false;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}
}
