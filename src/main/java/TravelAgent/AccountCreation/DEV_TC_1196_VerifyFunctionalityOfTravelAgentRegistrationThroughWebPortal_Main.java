package TravelAgent.AccountCreation;

import java.util.Set;
import java.util.List;
import common.TestBase;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.support.ui.ExpectedConditions;

public class DEV_TC_1196_VerifyFunctionalityOfTravelAgentRegistrationThroughWebPortal_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String currURL;

	@FindBy(xpath = "//*[text()='Programs']")
	WebElement programsDrpdwn;

	@FindBy(xpath = "//a[normalize-space()='Travel Agent']")
	WebElement travelAgentOption;

	@FindBy(xpath = "(//*[text()='Sign In'])[1]")
	WebElement signInBtn;

	@FindBy(xpath = "(//a[normalize-space()='Customer Login'])[2]")
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

	@FindBy(xpath = "//input[@id='formBasicCheckbox']")
	WebElement checBox;

	@FindBy(xpath = "//button[text()='Create']")
	WebElement createBtn;

	@FindBy(xpath = "//div[(@role='alert')]")
	WebElement alertMessge;

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

//	@FindBy(xpath = "//input[@id='w9']")
	@FindBy(xpath = "(//input[@type='file'])[1]")
	WebElement w9DocumentUpload;

//	@FindBy(xpath = "//input[@id='directDeposit']")
	@FindBy(xpath = "(//input[@type='file'])[2]")
	WebElement directDepositeDocUpload;

	public DEV_TC_1196_VerifyFunctionalityOfTravelAgentRegistrationThroughWebPortal_Main(WebDriver driver) {
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
			visibilityStatus = false;
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
			visibilityStatus = false;
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
			visibilityStatus = false;
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
			visibilityStatus = false;
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
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verificationOfTARegistrationForm(Boolean visibilityStatus) {
		try {
			joinTABtn.click();
			defaultWaitTime(2000);
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
			visibilityStatus = false;
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
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean enterDetailsTravelAgentForm(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			if (companyName.size() != 0 && firstName.size() != 0 && lastName.size() != 0 && email.size() != 0
					&& lastName.size() != 0 && mobileNumber.size() != 0 && w9Document.size() != 0
					&& directDiposit.size() != 0 && businessAddress.size() != 0 && website.size() != 0) {
				defaultWaitTime(500);
				companyName.get(0).sendKeys(prop.getProperty("travelAgentCName") + "_" + currDateTime);
				defaultWaitTime(500);
				firstName.get(0).sendKeys(prop.getProperty("fName"));
				defaultWaitTime(500);
				lastName.get(0).sendKeys(prop.getProperty("lName"));
				defaultWaitTime(500);
				mobileNumber.get(0).sendKeys(prop.getProperty("phoneNumber"));
				defaultWaitTime(500);
				eMail = prop.getProperty("regeMail") + currDateTime + prop.getProperty("eMailDomain");
				email.get(0).sendKeys(eMail);
				defaultWaitTime(500);
				for (int i = 1; i <= 11; i++) {
					action.sendKeys(Keys.TAB).build().perform();
				}

				action.moveToElement(checBox).click().build().perform();
				defaultWaitTime(500);
				visibilityStatus = uploadDocuments(visibilityStatus);
				if (visibilityStatus.booleanValue() == true)
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

	public Boolean uploadDocuments(Boolean visibilityStatus) {
		try {
			if (w9Document.size() != 0) {
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
				if (createBtn.isDisplayed())
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else {
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
			createBtn.click();
			defaultWaitTime(3000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
			if (displayStatus.isDisplayed() && displayStatus.getText().toLowerCase().contains("success"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}
}
