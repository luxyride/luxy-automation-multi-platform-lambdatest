package Concierge.Profile;

import java.util.Iterator;
import java.util.Set;
import common.TestBase;
import org.openqa.selenium.Keys;
import common.GetCurrentDateTime;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1128_VerifySelectDeselectofOptInVerificationSecurityCheckboxin_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;
	JavascriptExecutor js;
	TestBase objTestBase;

	@FindBy(xpath = "//a[normalize-space()='Programs']")
	WebElement programsDrpdwn;

	@FindBy(xpath = "//a[normalize-space()='Corporate']")
	WebElement corporate;

	@FindBy(xpath = "(//a[normalize-space()='SIGN UP'])[1]")
	WebElement signupBtn;

	@FindBy(xpath = "//button[text()='Create']")
	WebElement conciergesignupBtn;

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
	WebElement workAddress;

	@FindBy(xpath = "(//input[@id='formBasicCheckbox'])[2]")
	WebElement termsConditionsChckbx;

	@FindBy(xpath = "//button[normalize-space()='Create']")
	WebElement signupCreateBtn;

	@FindBy(xpath = "//b[normalize-space()='Success!']")
	WebElement successMsg;

	@FindBy(xpath = "//div[@class='modal-body']")
	WebElement mailBody;

	@FindBy(xpath = "(//input[@id = 'formBasicCheckbox'])[1]")
	WebElement optInChkbox;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInputDispatch;

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

	@FindBy(xpath = "(//span[normalize-space()='Corporate'])[1]")
	WebElement corporateTab;

	@FindBy(xpath = "//a[text()=' Add Corporate ']")
	WebElement addCorporateBtn;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement dispatchCompanyName;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement dispatchFirstName;

	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement dispatchLastName;

	@FindBy(xpath = "//input[@type='email']")
	WebElement dispatchEMail;

	@FindBy(xpath = "//input[@type='tel']")
	WebElement dispatchMobile;

	@FindBy(xpath = "//input[@placeholder='Work Address']")
	WebElement dispatchWorkaddress;

	@FindBy(xpath = "//input[@id='pin_opt_in']")
	WebElement dispatchoptInChkbox;

	@FindBy(xpath = "//input[@type='text']")
	WebElement eMailInputConcierge;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordInputConcierge;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtnConcierge;

	@FindBy(xpath = "//a[normalize-space()='Profile']")
	WebElement profileTab;

	@FindBy(xpath = "//button[contains(text(),'Edit Profile')]")
	WebElement editProfileBtn;

	@FindBy(xpath = "//input[@id='pin_opt_in']")
	WebElement conciergeoptInChkbox;

	public DEV_TC_1128_VerifySelectDeselectofOptInVerificationSecurityCheckboxin_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfProgramsDropdown(Boolean visibilityStatus) {
		try {
			if (programsDrpdwn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnPrograms() {
		try {
			action = new Actions(driver);
			action.moveToElement(programsDrpdwn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnCorporate() {
		try {
			action = new Actions(driver);
			action.moveToElement(corporate).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
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

	public Boolean verifyCorporatePage(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.toLowerCase().contains(prop.getProperty("environment"))
					&& expected.toLowerCase().contains("corporate"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyVisibilityOfSignupCreateBtn(Boolean visibilityStatus) {
		try {
			if (signupCreateBtn.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnEnroll() {
		try {
			action = new Actions(driver);
			action.moveToElement(signupBtn).click().build().perform();
			defaultWaitTime(3000);
			for (int i = 1; i <= 10; i++) {
				action.sendKeys(Keys.TAB).build().perform();
			}
			defaultWaitTime(500);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void enterAllDetails(String scenario) throws Exception {
		try {
			action = new Actions(driver);
			for (int i = 1; i <= 3; i++) {
				action.sendKeys(Keys.ARROW_DOWN).build().perform();
			}
			currDateTime = GetCurrentDateTime.getCurrentDateTime(currDateTime);
			String cName = prop.getProperty("conciergeCName") + "_" + currDateTime;
			companyName.sendKeys(cName);
			fName.sendKeys(prop.getProperty("conciergeFName"));
			lName.sendKeys(prop.getProperty("conciergeLName"));

			// luxyqatestMMDDYYYY_HHMMSS@yopmail.com
			eMail = prop.getProperty("conciergeMail") + currDateTime + prop.getProperty("eMailDomain");

			// Update the Concierge Company Name & Email ID:
			conciergeCompanyName.put("conciergeCName_" + scenario, cName);
			System.out.println("Concierge Company Name and EMail: " + conciergeCompanyName);

			action.sendKeys(Keys.TAB).build().perform();
			eMailInput.sendKeys(eMail);
			phoneInput.sendKeys(prop.getProperty("phoneNumber"));
			workAddress.sendKeys(prop.getProperty("workAddress"));
			objTestBase.defaultWaitTime(4000);
			action.sendKeys(Keys.DOWN).build().perform();
			objTestBase.defaultWaitTime(500);
			action.sendKeys(Keys.ENTER).build().perform();
			objTestBase.defaultWaitTime(6000);
			for (int i = 1; i <= 3; i++) {
				action.sendKeys(Keys.TAB).build().perform();
				objTestBase.defaultWaitTime(500);
			}
			objTestBase.defaultWaitTime(3000);

			if (scenario == "Unchecked" && optInChkbox.isSelected()) {
				action.moveToElement(optInChkbox).click().build().perform();
				defaultWaitTime(800);
			}

			js = (JavascriptExecutor) driver;
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signupCreateBtn);

			action.moveToElement(termsConditionsChckbx).click().build().perform();
			objTestBase.defaultWaitTime(500);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnSignupCreateBtn() throws Exception {
		try {
			objTestBase.defaultWaitTime(1000);
			signupCreateBtn.click();
			objTestBase.defaultWaitTime(1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSignupConfirmationMsg(Boolean visibilityStatus) {
		try {
			if (successMsg.isDisplayed()) {
				expected = successMsg.getText();
				if (expected.toLowerCase().contains("success"))
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

	public Boolean verifyOptInCheckboxSelected(Boolean visibilityStatus) {
		try {
			if (optInChkbox.isSelected())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyOptInCheckUncheck(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			for (int i = 0; i <= 1; i++) {
				if (i == 0) {
					if (optInChkbox.isSelected()) {
						action.moveToElement(optInChkbox).click().build().perform();
						defaultWaitTime(800);
						if (!optInChkbox.isSelected())
							visibilityStatus = true;
					} else {
						action.moveToElement(optInChkbox).click().build().perform();
						defaultWaitTime(800);
						if (optInChkbox.isSelected())
							visibilityStatus = true;
					}
				} else if (i == 1) {
					if (optInChkbox.isSelected()) {
						action.moveToElement(optInChkbox).click().build().perform();
						defaultWaitTime(800);
						if (!optInChkbox.isSelected())
							visibilityStatus = true;
					} else {
						action.moveToElement(optInChkbox).click().build().perform();
						defaultWaitTime(800);
						if (optInChkbox.isSelected())
							visibilityStatus = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyOptInCheckbox(Boolean visibilityStatus, String scenario) {
		try {
			if (scenario == "Checked" && !optInChkbox.isSelected()) {
				action.moveToElement(optInChkbox).click().build().perform();
				defaultWaitTime(800);
			} else if (scenario == "Unchecked" && optInChkbox.isSelected()) {
				action.moveToElement(optInChkbox).click().build().perform();
				defaultWaitTime(800);
			}
			visibilityStatus = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void eMailInputDispatch() {
		try {
			action = new Actions(driver);
			eMailInputDispatch.sendKeys(prop.getProperty("dispatchadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInputDispatch() {
		try {
			action = new Actions(driver);
			passwordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSigninButtonDispatch(Boolean visibilityStatus) {
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

	public void clickSigninButtonDispatch() {
		try {
			signInBtn.click();
			// Validate Dispatch 2fa Authentication:
			Boolean visibilityStatus1 = false;
			visibilityStatus1 = validateDispatchBypassCode(visibilityStatus1);
			utillLogger.info(
					"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public Boolean visibilityOfLoggedinUserDispatch(Boolean visibilityStatus) {
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

	public Boolean verifyCorporateTabDispatch(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			if (corporateTab.isDisplayed()) {
				action.moveToElement(corporateTab).click().build().perform();
				objTestBase.defaultWaitTime(3000);
				action.moveToElement(addCorporateBtn).click().build().perform();
				objTestBase.defaultWaitTime(2000);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyCorporateRegisPageDispatch(Boolean visibilityStatus) {
		try {
			expected = driver.getCurrentUrl();
			if (expected.contains("register")) {
				action = new Actions(driver);
				action.moveToElement(dispatchCompanyName).click().sendKeys(prop.getProperty("conciergeCName") + "TEST")
						.build().perform();
				objTestBase.defaultWaitTime(500);
				action.moveToElement(dispatchFirstName).click().sendKeys(prop.getProperty("conciergeFName")).build()
						.perform();
				objTestBase.defaultWaitTime(500);
				action.moveToElement(dispatchLastName).click().sendKeys(prop.getProperty("conciergeLName")).build()
						.perform();
				objTestBase.defaultWaitTime(500);
				action.moveToElement(dispatchEMail).click().sendKeys(prop.getProperty("dispatchadminMail")).build()
						.perform();
				objTestBase.defaultWaitTime(500);

				js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
				objTestBase.defaultWaitTime(3000);

				action.moveToElement(dispatchMobile).click().sendKeys(prop.getProperty("phoneNumber")).build()
						.perform();
				objTestBase.defaultWaitTime(500);
				action.moveToElement(dispatchWorkaddress).click().sendKeys(prop.getProperty("workAddress")).build()
						.perform();
				objTestBase.defaultWaitTime(3000);
				action.sendKeys(Keys.DOWN).build().perform();
				objTestBase.defaultWaitTime(500);
				action.sendKeys(Keys.ENTER).build().perform();
				objTestBase.defaultWaitTime(2000);
				visibilityStatus = true;
			} else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public Boolean verifyOptInCheckedDefaultDispatch(Boolean visibilityStatus) {
		try {
			if (dispatchoptInChkbox.isSelected())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyOptInCheckUncheckDispatch(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			for (int i = 0; i <= 1; i++) {
				if (i == 0) {
					if (dispatchoptInChkbox.isSelected()) {
						js.executeScript("document.getElementById('pin_opt_in').click();");
						defaultWaitTime(800);
						if (!dispatchoptInChkbox.isSelected())
							visibilityStatus = true;
					} else {
						js.executeScript("document.getElementById('pin_opt_in').click();");
						defaultWaitTime(800);
						if (dispatchoptInChkbox.isSelected())
							visibilityStatus = true;
					}
				} else if (i == 1) {
					if (dispatchoptInChkbox.isSelected()) {
						js.executeScript("document.getElementById('pin_opt_in').click();");
						defaultWaitTime(800);
						if (!dispatchoptInChkbox.isSelected())
							visibilityStatus = true;
					} else {
						js.executeScript("document.getElementById('pin_opt_in').click();");
						defaultWaitTime(800);
						if (dispatchoptInChkbox.isSelected())
							visibilityStatus = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public void eMailInputConcierge() {
		try {
			action = new Actions(driver);
			eMailInputConcierge.sendKeys(prop.getProperty("conciergeadminMail"));
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void passwordInputConcierge() {
		try {
			action = new Actions(driver);
			passwordInputConcierge.sendKeys(prop.getProperty("conciergePwd"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfSigninButtonConcierge(Boolean visibilityStatus) {
		try {
			if (signInBtnConcierge.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickSigninButtonConcierge() {
		try {
			signInBtnConcierge.click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedinUserConcierge(Boolean visibilityStatus) {
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

	public Boolean verifyProfilePageConcierge(Boolean visibilityStatus) {
		try {
			if (signinUser.isDisplayed()) {
				signinUser.click();
				defaultWaitTime(1000);
				profileTab.click();
				defaultWaitTime(2000);
				expected = driver.getCurrentUrl();
				if (expected.toLowerCase().contains("profile"))
					visibilityStatus = true;
				else
					visibilityStatus = false;
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyEditProfilePageConcierge(Boolean visibilityStatus) {
		try {
			if (editProfileBtn.isDisplayed()) {
				editProfileBtn.click();
				defaultWaitTime(3000);
				js = (JavascriptExecutor) driver;
				
				objTestBase.defaultWaitTime(2000);
			} else
				visibilityStatus = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyOptInCheckedDefaultConcierge(Boolean visibilityStatus) {
		try {
			if (conciergeoptInChkbox.isSelected())
				visibilityStatus = true;
			else
				visibilityStatus = false;
			return visibilityStatus;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean verifyOptInCheckUncheckConcierge(Boolean visibilityStatus) {
		try {
			action = new Actions(driver);
			js = (JavascriptExecutor) driver;
			for (int i = 0; i <= 1; i++) {
				if (i == 0) {
					if (conciergeoptInChkbox.isSelected()) {
						js.executeScript("document.getElementById('pin_opt_in').click();");
						defaultWaitTime(800);
						if (!conciergeoptInChkbox.isSelected())
							visibilityStatus = true;
					} else {
						js.executeScript("document.getElementById('pin_opt_in').click();");
						defaultWaitTime(800);
						if (conciergeoptInChkbox.isSelected())
							visibilityStatus = true;
					}
				} else if (i == 1) {
					if (conciergeoptInChkbox.isSelected()) {
						js.executeScript("document.getElementById('pin_opt_in').click();");
						defaultWaitTime(800);
						if (!conciergeoptInChkbox.isSelected())
							visibilityStatus = true;
					} else {
						js.executeScript("document.getElementById('pin_opt_in').click();");
						defaultWaitTime(800);
						if (conciergeoptInChkbox.isSelected())
							visibilityStatus = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

}
