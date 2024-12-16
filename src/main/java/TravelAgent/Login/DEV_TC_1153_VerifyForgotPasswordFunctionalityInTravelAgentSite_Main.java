package TravelAgent.Login;

import java.util.Set;
import java.time.Duration;
import java.util.List;
import common.TestBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.interactions.Actions;

public class DEV_TC_1153_VerifyForgotPasswordFunctionalityInTravelAgentSite_Main extends TestBase {

	WebDriver driver;
	Actions action;
	String expected;

	@FindBy(xpath = "//a[@class='link-default']")
	List<WebElement> forgotPwdLink;

	@FindBy(xpath = "//input[@type='email']")
	WebElement email;

	@FindBy(xpath = "//a[normalize-space()='Change Password']")
	WebElement ChangePWDbutton;

	@FindBy(xpath = "//input[@type='text']")
	WebElement entereMail;

	@FindBy(xpath = "//input[@type='password']")
	WebElement enterpassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement getResetLinkClick;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement signInBtn;

	@FindBy(xpath = "//div[@id='clearbut']//a")
	List<WebElement> yopMailClearEmailBtn;

	@FindBy(xpath = "//input[@id='login']")
	WebElement yopMaileMail;

	@FindBy(xpath = "//*[@id='mail']//font[normalize-space()='Reset Password']")
	WebElement yopMailforgotPwdLink;

	@FindBy(xpath = "(//*[@type = 'password'])[1]")
	WebElement password;

	@FindBy(xpath = "(//*[@type = 'password'])[2]")
	WebElement confirmPwd;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement confirmPwdSubmitBtn;

	@FindBy(xpath = "(//input[@id='password'])[1]")
	WebElement loginPwd;

	@FindBy(xpath = "(//div[@class='input-group-prepend'])[1]//span//i")
	WebElement eyeIcon;

	@FindBy(xpath = "(//*[text()='Sign In'])[1]")
	WebElement signInBtnHomePage;

	@FindBy(xpath = "//button[@type='button']")
	WebElement userLoginName;

	@FindBy(xpath = "//button[contains(text(),'Welcome')]")
	WebElement loggedInUserName;

	@FindBy(xpath = "//a[normalize-space()='Logout']")
	WebElement signoutBtn;

	@FindBy(xpath = "(//input[@type='password'])[1]")
	WebElement inputoldpwd;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	WebElement inputnewpwd;

	@FindBy(xpath = "(//input[@type='password'])[3]")
	WebElement inputconfirmpwd;

	@FindBy(xpath = "//button[@type='submit']")
	List<WebElement> changePwdSubmitBtn;

	@FindBy(xpath = "//a[text()='Sign Out']")
	WebElement clickOnSingoutBtn;

	@FindBy(xpath = "(//input[@id='email'])")
	WebElement eMailInput;

	@FindBy(xpath = "(//input[@id='password'])[1]")
	WebElement pwdInput;

	@FindBy(xpath = "//[@id=\"root\"]/div/div[2]/div/div[1]/ul/li[2]/button")
	WebElement loggedInDropdown;

	@FindBy(xpath = "//*[(@role='alert')]")
	WebElement alertMessge;

	TestBase objTestBase;

	public DEV_TC_1153_VerifyForgotPasswordFunctionalityInTravelAgentSite_Main(WebDriver driver) {
		try {
			this.driver = driver;
			PageFactory.initElements(driver, this);
			objTestBase = new TestBase();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfForgotPwdLink(Boolean visibilityStatus) {
		try {
			visibilityStatus = waitToPageLoadElementsFluentWait(visibilityStatus, forgotPwdLink);
			if (visibilityStatus.booleanValue() == true)
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public Boolean visibilityOfsigninButton(Boolean visibilityStatus) {
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

	public void clickSignInButton() {
		try {
			action = new Actions(driver);
			action.moveToElement(signInBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfsigninDropDown(Boolean visibilityStatus) {
		try {
			if (loggedInDropdown.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void forgotPwdlinkClick() {
		try {
			action = new Actions(driver);
			action.moveToElement(forgotPwdLink.get(0)).click().build().perform(); // Click on Forgot Password:
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void eMailInput() {
		try {
			action = new Actions(driver);
			email.sendKeys(prop.getProperty("travelAgentEMail"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfresendlinkbtn(Boolean visibilityStatus) {
		try {
			if (getResetLinkClick.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void yopMaileMailInput() {
		try {
			action = new Actions(driver);
			expected = prop.getProperty("travelAgentEMail");
			String[] tempEmail = expected.split("@");
			yopMaileMail.sendKeys(tempEmail[0]);
			action.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfyopMailForgotPwdLink(Boolean visibilityStatus) throws Exception {
		try {
			driver.switchTo().frame("ifmail");
			objTestBase.defaultWaitTime(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", yopMailforgotPwdLink);
			objTestBase.defaultWaitTime(2000);
			if (yopMailforgotPwdLink.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void yopMailforgotPwdLinkClick() {
		try {
			action = new Actions(driver);
			action.moveToElement(yopMailforgotPwdLink).click().build().perform();
			objTestBase.defaultWaitTime(2000);
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
					driver.switchTo().window(currWindow);	try	{	defaultWaitTime(5000);	}	catch (Exception e)	{	e.printStackTrace(); }
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

	public void passwordInput(String scenario) {
		try {
			action = new Actions(driver);
			if (scenario == "forgotPassword") {
				password.sendKeys(prop.getProperty("travelAgentPwd"));
			} else {
				password.sendKeys(prop.getProperty("travelAgentTempPwd"));
			}
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void confirmPwdInput(String scenario) {
		try {
			action = new Actions(driver);
			if (scenario == "forgotPassword") {
				confirmPwd.sendKeys(prop.getProperty("travelAgentPwd"));
			} else {
				confirmPwd.sendKeys(prop.getProperty("travelAgentTempPwd")); // resetBacktoMainPassword
			}
			action.sendKeys(Keys.TAB).build().perform();
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfConfirmPwdConfirmationMessage(Boolean visibilityStatus) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(alertMessge));
			if (displayStatus.isDisplayed() && displayStatus.getText().toLowerCase().contains("successfully"))
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnforgotPwdBtn() {
		try {
			action = new Actions(driver);
			action.moveToElement(confirmPwdSubmitBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void loginPwdInput(String scenario) {
		try {
			action = new Actions(driver);
			if (scenario == "forgotPassword") {
				loginPwd.sendKeys(prop.getProperty("travelAgentTempPwd"));
			} else {
				loginPwd.sendKeys(prop.getProperty("travelAgentPwd")); // resetBacktoMainPassword
			}
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnEyeIcon() {
		try {
			action = new Actions(driver);
			action.moveToElement(eyeIcon).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfLoggedInUserName(Boolean visibilityStatus) {
		try {
			waitTimeForElement(loggedInUserName);
			if (loggedInUserName.isDisplayed()) {
				expected = loggedInUserName.getText();
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

	public Boolean visibilityOfLoginDropdown(Boolean visibilityStatus) {
		try {
			if (userLoginName.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void clickOnSignoutButton() {
		try {
			action = new Actions(driver);
			action.moveToElement(signoutBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean visibilityOfGetResetLinkClick(Boolean visibilityStatus) {
		try {
			if (getResetLinkClick.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void GetResetLinkClick() {
		try {
			action = new Actions(driver);
			action.moveToElement(getResetLinkClick).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void enterpassword(String scenario) {
		try {
			action = new Actions(driver);
			if (scenario == "resetBacktoMainPwd") {
				password.sendKeys(prop.getProperty("travelAgentPwd"));
			} else {
				password.sendKeys(prop.getProperty("travelAgentTempPwd"));
			}
			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean entereMail(Boolean visibilityStatus) {
		try {
			visibilityStatus = waitToPageLoadElementsFluentWait(visibilityStatus, forgotPwdLink);
			if (visibilityStatus.booleanValue() == true) {
				entereMail.sendKeys(prop.getProperty("travelAgentEMail"));
				visibilityStatus = true;
			} else
				visibilityStatus = false;

			action.sendKeys(Keys.TAB).build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
			visibilityStatus = false;
		}
		return visibilityStatus;
	}

	public void clickOnuserLoginName() {
		try {
			action = new Actions(driver);
			action.moveToElement(userLoginName).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickChangePWDbutton() {
		try {
			action = new Actions(driver);
			action.moveToElement(ChangePWDbutton).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void clickOnChangePWDSubmit() {
		try {
			if (changePwdSubmitBtn.size() != 0)
				changePwdSubmitBtn.get(0).click();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Boolean enterChangePWDDetails(Boolean visibilityStatus, String scenario) {
		try {
			action = new Actions(driver);

			if (scenario == "changepassword") {
				inputoldpwd.sendKeys(prop.getProperty("travelAgentPwd"));
				action.sendKeys(Keys.TAB).build().perform();

				inputnewpwd.sendKeys(prop.getProperty("travelAgentTempPwd"));
				action.sendKeys(Keys.TAB).build().perform();

				inputconfirmpwd.sendKeys(prop.getProperty("travelAgentTempPwd"));
			} else {
				inputoldpwd.sendKeys(prop.getProperty("travelAgentTempPwd"));
				action.sendKeys(Keys.TAB).build().perform();

				inputnewpwd.sendKeys(prop.getProperty("travelAgentPwd"));
				action.sendKeys(Keys.TAB).build().perform();

				inputconfirmpwd.sendKeys(prop.getProperty("travelAgentPwd"));
			}
			visibilityStatus = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return visibilityStatus;
	}

	public void confirmPwdSubmitBtn(String scenario) {
		try {
			action = new Actions(driver);
			action.moveToElement(confirmPwdSubmitBtn).click().build().perform();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
