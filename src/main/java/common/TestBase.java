package common;

import java.net.URL;
import java.io.File;
import java.util.Map;
import java.util.List;
import java.awt.Robot;
import java.util.Date;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.HashMap;
import java.time.Duration;
import java.awt.Rectangle;
import org.json.JSONObject;
import java.util.Properties;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.testng.ITestContext;
import java.io.FileInputStream;
import org.openqa.selenium.Keys;
import java.util.logging.Logger;
import org.openqa.selenium.Alert;
import java.text.SimpleDateFormat;
import java.util.function.Function;
import java.awt.image.BufferedImage;
import java.util.logging.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import java.util.logging.SimpleFormatter;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.TimeoutException;
import java.util.concurrent.ConcurrentHashMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.FluentWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.ElementNotInteractableException;

public class TestBase {

	public static Robot robot;
	public static String eMail;
	public static String tripID;
	public static FileHandler fh;
	public static Actions action;
	public static String exception;
	public static WebDriver driver;
	public static String buildName;
	public static ExtentTest logger;
	public static String destination;
	public static String curDateTime;
	public static String browserType;
	public static String currDateTime;
	public static String dateTimeStamp;
	public static ExtentReports extent;
	public static Rectangle screenRect;
	public static String screenshotPath;
	public static JavascriptExecutor js;
	public static String environmentCode;
	public static String filePathExtension;
	public static List<WebElement> popupMain;
	public static List<WebElement> popupChild;
	public static List<WebElement> popupCookies;
	public static String tripIDFarmoutScenario;
	public static BufferedImage screenFullImage;
	public static List<WebElement> animatedTeaser;
	public static String conciergehourlyRideTripID;
	public static String travelAgenthourlyRideTripID;
	public static Properties prop = new Properties();
	public static UpdateExtentReportResults objupdateResults;
	public static Logger utillLogger = Logger.getLogger("LuxyQAAutoTest");
	public static String dockerScreenshotsPath = "https://testimages.luxyride.com/screenshots/";
	public static String localScreenshotsPath = System.getProperty("user.dir") + "\\screenshots\\";

	// --------------------------------------------------------------------------------------------------
	// ## LambdaTest Configuration:
	public static Boolean localExecutionFlag = false;
	public static JavascriptExecutor jseLambdaTest;
	public static String userName = "hvudutala";
	public static String automationKey = "Wz4cMuQW16k1ZB8Uqp0I3pRU4x3zKRD5WGhCRwZerNOOe2pZ8f";
	public static JSONObject executorObject = new JSONObject();
	public static JSONObject argumentsObject = new JSONObject();
	public static final String URL = "https://" + userName + ":" + automationKey + "@hub.lambdatest.com/wd/hub";
	// --------------------------------------------------------------------------------------------------

	// Vehicle Images Path for Dispatch TC:
	// DEV_TC_923_VerifyNewVehicleRegistrationInDispatchSite_Test
	public static String localvehicleImagesPath = System.getProperty("user.dir") + "\\Resources\\vehicleImages\\";
	public static String dockervehicleImagesPath = "https://testimages.luxyride.com/vehicleImages/";

	// Travel Agent Paths:
	// DEV_TC_1196_VerifyFunctionalityOfTravelAgentRegistrationThroughWebPortal_Test
	// DEV_TC_1390_VerifyFunctionalityOfTravelAgentRegistrationThroughDispatch_Test
	public static String localTravelAgentDocsPath = System.getProperty("user.dir") + "\\Resources\\travelAgentDocs\\";
	public static String dockerTravelAgentDocsPath = "https://testimages.luxyride.com/travelAgentDocs/";

	// For Capturing the Ride Booking ids:
	public static Map<String, String> rideBookingIds;

	// For Capturing the Ride Booking ids from Guest User:
	public static Map<String, String> guestrideBookingIds;

	// For Capturing the Dispatch Ride Booking ids:
	public static Map<String, String> rideBookingDispatchIds;

	// For Capturing the Concierge CompanyName And Regression Email:
	public static Map<String, String> conciergeCompanyName;

	// For Capturing the Ride Booking IDs from Concierge Site: [DEV-TC-1126 &
	// DEV_TC_1248]
	public static Map<String, String> rideBookingIdsConcierge;

	// For Capturing the Ride Booking IDs from Travel Agent Site: [DEV_TC_1152]
	public static Map<String, String> rideBookingIdsTravelAgent;

	// For Capturing the TripIDs from Concierge.NewBookings: [DEV_TC_1410]:
	public static Map<String, String> dispatchTripIDsOriginator;

	// For Capturing the TripIDs from Concierge.NewBookings: [DEV_TC_1416]:
	public static Map<String, String> conciergeTripIDsOriginator;

	// For Capturing the TripIDs from Concierge.NewBookings: [DEV_TC_1417]:
	public static Map<String, String> travelAgentTripIDsOriginator;

	// For Capturing the TripIDs from Concierge.NewBookings: [DEV_TC_1519]:
	public static Map<String, String> externalSourceTripIDsOriginator;

	// ---------------------------------------------------------------

	// Dispatch Delete Account:
	@FindBy(xpath = "//input[@type='text']")
	WebElement dispatcheMailInput;

	@FindBy(xpath = "//input[@type='password']")
	WebElement dispatchpasswordInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement dispatchsignInBtn;

	@FindBy(xpath = "(//span[normalize-space()='Passengers'])[1]")
	WebElement dispatchpassengersTab;

	@FindBy(xpath = "//div[@aria-label='Paying with Card']")
	WebElement cardOptions;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement dispatchSearchPassenger;

	@FindBy(xpath = "//i[@title='Delete Passenger']")
	WebElement dispatchDeletePassenger;

	@FindBy(xpath = "//button[normalize-space()='Yes']")
	WebElement dispatchYesBtn;

	@FindBy(xpath = "//*[text()='There is no data to display']")
	WebElement dispatchNoPassengerMsg;
	// ---------------------------------------------------------------

	@Parameters({ "environment", "browser" })
	@BeforeTest(alwaysRun = true)
	public void beforeTest(ITestContext context, String environment, String browserName) {
		try {
			robot = new Robot();
			objupdateResults = new UpdateExtentReportResults(driver);
			System.out.println("Environment = " + environment);
			System.out.println("Browser = " + browserName);
			System.out.println("LambdaTest HUB URL = " + URL);

			// User Portal Configuration:
			if (environment.equalsIgnoreCase("devuserportal")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/userportal_TestRunConfig/dev/" + "devuserportalConfig.properties")));
				environmentCode = "dev";
			} else if (environment.equalsIgnoreCase("uatuserportal")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/userportal_TestRunConfig/uat/" + "uatuserportalConfig.properties")));
				environmentCode = "uat";
			} else if (environment.equalsIgnoreCase("produserportal")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/userportal_TestRunConfig/prod/" + "produserportalConfig.properties")));
				environmentCode = "prod";
			}

			// Dispatch Configuration:
			else if (environment.equalsIgnoreCase("devdispatch")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/dispatch_TestRunConfig/dev/" + "devdispatchConfig.properties")));
				environmentCode = "dev";
			} else if (environment.equalsIgnoreCase("uatdispatch")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/dispatch_TestRunConfig/uat/" + "uatdispatchConfig.properties")));
				environmentCode = "uat";
			} else if (environment.equalsIgnoreCase("proddispatch")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/dispatch_TestRunConfig/prod/" + "proddispatchConfig.properties")));
				environmentCode = "prod";
			}

			// Concierge Configuration:
			else if (environment.equalsIgnoreCase("devconcierge")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/concierge_TestRunConfig/dev/" + "devconciergeConfig.properties")));
				environmentCode = "dev";
			} else if (environment.equalsIgnoreCase("uatconcierge")) {
				System.out.println(System.getProperty("user.dir") + "/Config/concierge_TestRunConfig/uat/"
						+ "uatconciergeConfig.properties");
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/concierge_TestRunConfig/uat/" + "uatconciergeConfig.properties")));
				environmentCode = "uat";
			} else if (environment.equalsIgnoreCase("prodconcierge")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/concierge_TestRunConfig/prod/" + "prodconciergeConfig.properties")));
				environmentCode = "prod";
			}

			// TravelAgent Configuration:
			else if (environment.equalsIgnoreCase("devtravelagent")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/travelagent_TestRunConfig/dev/" + "devtravelagentConfig.properties")));
				environmentCode = "dev";
			} else if (environment.equalsIgnoreCase("uattravelagent")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/travelagent_TestRunConfig/uat/" + "uattravelagentConfig.properties")));
				environmentCode = "uat";
			} else if (environment.equalsIgnoreCase("prodtravelagent")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/travelagent_TestRunConfig/prod/" + "prodtravelagentConfig.properties")));
				environmentCode = "prod";
			}

			// Affiliate Configuration:
			else if (environment.equalsIgnoreCase("devaffiliate")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/affiliate_TestRunConfig/dev/" + "devaffiliateConfig.properties")));
				environmentCode = "dev";
			} else if (environment.equalsIgnoreCase("uataffiliate")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/affiliate_TestRunConfig/uat/" + "uataffiliateConfig.properties")));
				environmentCode = "uat";
			} else if (environment.equalsIgnoreCase("prodaffiliate")) {
				prop.load(new FileInputStream(new File(System.getProperty("user.dir")
						+ "/Config/affiliate_TestRunConfig/prod/" + "prodaffiliateConfig.properties")));
				environmentCode = "prod";
			}

			System.out.println("Test Suite Name = " + context.getCurrentXmlTest().getSuite().getName());
			currDateTime = GetCurrentDateTime.getCurrentDateTime(currDateTime);
			System.out.println("Test Results Report = " + System.getProperty("user.dir") + "/test-output/"
					+ context.getCurrentXmlTest().getSuite().getName() + "_" + currDateTime + "_"
					+ environmentCode.toUpperCase() + "_" + browserName.toUpperCase() + ".html");

			// --------------------------------------------------------------------------
			// ## LamdaTest Configuration:
			buildName = context.getCurrentXmlTest().getSuite().getName() + "_" + environmentCode.toUpperCase() + "_"
					+ browserName.toUpperCase();
			Date date = new Date();
			SimpleDateFormat formatTime = new SimpleDateFormat("dd-MM-yyyy & kk:mm:ss");
			String dateTime = formatTime.format(date);
			dateTimeStamp = "Date & Time:    " + dateTime;
			// --------------------------------------------------------------------------

			// Set the ReportFileName:
			extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/"
					+ context.getCurrentXmlTest().getSuite().getName() + "_" + currDateTime + "_"
					+ environmentCode.toUpperCase() + "_" + browserName.toUpperCase() + ".html", true);
			extent.loadConfig(new File(System.getProperty("user.dir") + "/Config/" + "extent-config.xml"));
			// --------------------------------------------------------------------------
			// Local Path: Set the LogsFileName:
			fh = new FileHandler(System.getProperty("user.dir") + "/test-output/"
					+ context.getCurrentXmlTest().getSuite().getName() + "_" + currDateTime + "_"
					+ environmentCode.toUpperCase() + "_" + browserName.toUpperCase() + ".log");
			utillLogger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			// --------------------------------------------------------------------------
			// For Capturing the Ride Booking ids from Registered User:
			rideBookingIds = new ConcurrentHashMap<String, String>();
			// For Capturing the Ride Booking ids from Guest User:
			guestrideBookingIds = new ConcurrentHashMap<String, String>();
			// For Capturing the Dispatch Ride Booking ids:
			rideBookingDispatchIds = new ConcurrentHashMap<String, String>();
			// For Capturing the Concierge CompanyName And Regression Email:
			conciergeCompanyName = new ConcurrentHashMap<String, String>();
			// For Capturing the Ride Booking IDs from Concierge Site: [DEV-TC-1126]
			rideBookingIdsConcierge = new ConcurrentHashMap<String, String>();
			// For Capturing the Ride Booking IDs from TravelAgent Site: [DEV-TC-1152]
			rideBookingIdsTravelAgent = new ConcurrentHashMap<String, String>();
			// --------------------------------------------------------------------------
			// Originator Test Cases:
			dispatchTripIDsOriginator = new ConcurrentHashMap<String, String>(); // Concierge.NewBookings[DEV_TC_1410]
			conciergeTripIDsOriginator = new ConcurrentHashMap<String, String>(); // Concierge.NewBookings[DEV_TC_1416]
			travelAgentTripIDsOriginator = new ConcurrentHashMap<String, String>(); // Concierge.NewBookings[DEV_TC_1417]
			externalSourceTripIDsOriginator = new ConcurrentHashMap<String, String>(); // Concierge.NewBookings[DEV_TC_1519]
			// --------------------------------------------------------------------------

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		try {
			curDateTime = GetCurrentDateTime.getCurrentDateTime(curDateTime);
			filePathExtension = screenshotName + curDateTime + ".jpeg";
			if (System.getProperty("user.name").equals("circleci")) // Docker Env. User Name
				destination = dockerScreenshotsPath + filePathExtension;
			else
				destination = localScreenshotsPath + filePathExtension;

			utillLogger.info("Docker Screenshot Path = " + destination);
			screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			screenFullImage = robot.createScreenCapture(screenRect);
			ImageIO.write(screenFullImage, "jpeg", new File(destination));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return destination;
	}

	public WebDriverWait explicitwaitTime(WebDriverWait wait, WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Confirm Account"))).click();
		return wait;
	}

	public void defaultWaitTime(int time) throws Exception {
		try {
			Thread.sleep(time);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void waitTimeForElement(WebElement element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOf(element));

			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("window.scrollBy(0,-100)", "");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public WebDriver launchBrowser(String browser, WebDriver driver, String testCaseName) {
		try {
			browserType = browser;
			// #################### LambdaTest Cloud Execution #################### //
//			if (browser.equalsIgnoreCase("chrome")) {
//				DesiredCapabilities chromeCapability = new DesiredCapabilities();
//				chromeCapability.setCapability("platform", "Windows 11");
//				chromeCapability.setCapability("version", "latest");
//				chromeCapability.setCapability("name", testCaseName);
//				chromeCapability.setCapability("framework", "testng");
//				chromeCapability.setCapability("status", "COMPLETED");
//				chromeCapability.setCapability("buildName", buildName);
//				chromeCapability.setCapability("browserName", "Chrome");
//				chromeCapability.setCapability("browserVersion", "latest");
//				chromeCapability.setCapability("percyCaptureMode", "auto");
//				chromeCapability.setCapability("projectName", dateTimeStamp);
//				chromeCapability.setCapability("LambdaTest.idleTimeout", 300);
//				chromeCapability.setCapability("LambdaTest.chrome.enablePopups", "false");
//				chromeCapability.setCapability("autoGrantPermissions", "true");
//				chromeCapability.setCapability("visual", "true");
//
//				// INIT CHROME OPTIONS
//				ChromeOptions chromeOptions = new ChromeOptions();
//				Map<String, Object> prefs = new HashMap<String, Object>();
//				Map<String, Object> profile = new HashMap<String, Object>();
//				Map<String, Object> contentSettings = new HashMap<String, Object>();
//
//				// SET CHROME OPTIONS
//				// 0 - Default, 1 - Allow, 2 - Block
//				contentSettings.put("geolocation", 1);
//				profile.put("managed_default_content_settings", contentSettings);
//
//				prefs.put("profile.default_content_setting_values.notifications", 2);
//				prefs.put("autofill.profile_enabled", false);
//				prefs.put("credentials_enable_service", false);
//				prefs.put("autofill.credit_card_enabled", false);
//				prefs.put("profile.password_manager_enabled", false);
//				prefs.put("profile", profile);
//
//				// Chrome options to handle popups
//				chromeOptions.addArguments("--incognito");
//				chromeOptions.addArguments("--disable-infobars");
//				chromeOptions.addArguments("--disable-notifications");
//				chromeOptions.addArguments("--remote-allow-origins=*");
//				chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
//				chromeOptions.setExperimentalOption("prefs", prefs);
//
//				// SET CAPABILITY
//				chromeCapability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//				driver = new RemoteWebDriver(new URL(URL), chromeCapability);
//				Thread.sleep(1000);
//				driver.manage().window().maximize();
//				Thread.sleep(2000);
//				jseLambdaTest = (JavascriptExecutor) driver;
//			} else if (browser.equalsIgnoreCase("safari")) {
//				DesiredCapabilities safariCapability = new DesiredCapabilities();
//				safariCapability.setCapability("platform", "macos");
//				safariCapability.setCapability("version", "latest");
//				safariCapability.setCapability("name", testCaseName);
//				safariCapability.setCapability("framework", "testng");
//				safariCapability.setCapability("status", "COMPLETED");
//				safariCapability.setCapability("buildName", buildName);
//				safariCapability.setCapability("browserName", "Safari");
//				safariCapability.setCapability("browserVersion", "17.3");
//				safariCapability.setCapability("percyCaptureMode", "auto");
//				safariCapability.setCapability("projectName", dateTimeStamp);
//				safariCapability.setCapability("LambdaTest.idleTimeout", 300);
//				safariCapability.setCapability("unhandledPromptBehavior", "ignore");
//				safariCapability.setCapability("--disable-infobars", true);
//				safariCapability.setCapability("--disable-notifications", true);
//				safariCapability.setCapability("--remote-allow-origins=*", true);
//				safariCapability.setCapability("excludeSwitches", Arrays.asList("disable-popup-blocking"));
//				safariCapability.setCapability("autoGrantPermissions", true);
//				safariCapability.setCapability("javascriptEnabled", false);
//
//				// Handling pop-ups and permissions
//				safariCapability.setCapability("safariAllowPopups", false);
//				safariCapability.setCapability("LambdaTest.safari.enablePopups", true); // LambdaTest specific
//
//				// Set additional options for Safari
//				safariCapability.setCapability("safari:automaticProfiling", false);
//				safariCapability.setCapability("safari:automaticInspection", false);
//
//				// Set capabilities specific to Safari
//				safariCapability.setCapability("safari:useSingleSession", true);
//
//				// Initialize SafariOptions
//				SafariOptions safariOptions = new SafariOptions();
//				safariOptions.setCapability("excludeSwitches", Arrays.asList("disable-popup-blocking"));
//				safariOptions.setCapability("CAPABILITY", SafariOptions.fromCapabilities(safariOptions));
//
//				Map<String, Object> prefs = new HashMap<String, Object>();
//				Map<String, Object> profile = new HashMap<String, Object>();
//				Map<String, Object> contentSettings = new HashMap<String, Object>();
//
//				// SET CHROME OPTIONS
//				// 0 - Default, 1 - Allow, 2 - Block
//				contentSettings.put("geolocation", 1);
//				profile.put("managed_default_content_settings", contentSettings);
//				prefs.put("profile.default_content_setting_values.notifications", 2);
//				prefs.put("autofill.profile_enabled", false);
//				prefs.put("credentials_enable_service", false);
//				prefs.put("autofill.credit_card_enabled", false);
//				prefs.put("profile.password_manager_enabled", false);
//				prefs.put("--disable-infobars", true);
//				prefs.put("--remote-allow-origins=*", true);
//				prefs.put("excludeSwitches", Arrays.asList("disable-popup-blocking"));
//				prefs.put("profile", profile);
//
//				safariOptions.setCapability("prefs", prefs);
//				safariOptions.setCapability("--disable-infobars", true);
//				safariOptions.setCapability("--disable-notifications", true);
//				safariOptions.setCapability("--remote-allow-origins=*", true);
//				safariOptions.setCapability("excludeSwitches", Arrays.asList("disable-popup-blocking"));
//
//				// SET CAPABILITY
//				safariCapability.setCapability("prefs", prefs);
//
//				// Initialize RemoteWebDriver with LambdaTest URL
//				driver = new RemoteWebDriver(new URL(URL), safariCapability);
//				Thread.sleep(1000);
//				driver.manage().window().maximize();
//				Thread.sleep(2000);
//				jseLambdaTest = (JavascriptExecutor) driver;
//			} else if (browser.equalsIgnoreCase("chromeAndroidMobileView")) {
//				DesiredCapabilities chromeCapability = new DesiredCapabilities();
//				chromeCapability.setCapability("platform", "Windows 11");
//				chromeCapability.setCapability("version", "latest");
//				chromeCapability.setCapability("name", testCaseName);
//				chromeCapability.setCapability("framework", "testng");
//				chromeCapability.setCapability("status", "COMPLETED");
//				chromeCapability.setCapability("buildName", buildName);
//				chromeCapability.setCapability("browserName", "Chrome");
//				chromeCapability.setCapability("browserVersion", "latest");
//				chromeCapability.setCapability("percyCaptureMode", "auto");
//				chromeCapability.setCapability("projectName", dateTimeStamp);
//				chromeCapability.setCapability("LambdaTest.idleTimeout", 300);
//				chromeCapability.setCapability("LambdaTest.chrome.enablePopups", "false");
//				chromeCapability.setCapability("autoGrantPermissions", "true");
//				chromeCapability.setCapability("visual", "true");
//
//				// INIT CHROME OPTIONS
//				ChromeOptions chromeOptions = new ChromeOptions();
//				Map<String, Object> prefs = new HashMap<String, Object>();
//				Map<String, Object> profile = new HashMap<String, Object>();
//				Map<String, Object> contentSettings = new HashMap<String, Object>();
//
//				// SET CHROME OPTIONS
//				// 0 - Default, 1 - Allow, 2 - Block
//				contentSettings.put("geolocation", 1);
//				profile.put("managed_default_content_settings", contentSettings);
//
//				prefs.put("profile.default_content_setting_values.notifications", 2);
//				prefs.put("autofill.profile_enabled", false);
//				prefs.put("credentials_enable_service", false);
//				prefs.put("autofill.credit_card_enabled", false);
//				prefs.put("profile.password_manager_enabled", false);
//				prefs.put("profile", profile);
//
//				// Chrome options to handle popups
//				chromeOptions.addArguments("--incognito");
//				chromeOptions.addArguments("--disable-infobars");
//				chromeOptions.addArguments("--disable-notifications");
//				chromeOptions.addArguments("--remote-allow-origins=*");
//				chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
//				chromeOptions.setExperimentalOption("prefs", prefs);
//
//				// Mobile View Configuration:
//				chromeOptions.setExperimentalOption("mobileEmulation",
//						Map.of("deviceName", "Samsung Galaxy S20 Ultra"));
//
//				// SET CAPABILITY
//				chromeCapability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//				driver = new RemoteWebDriver(new URL(URL), chromeCapability);
//				Thread.sleep(1000);
//				driver.manage().window().maximize();
//				Thread.sleep(2000);
//				jseLambdaTest = (JavascriptExecutor) driver;
//			} else if (browser.equalsIgnoreCase("chromeiOSMobileView")) {
//				DesiredCapabilities chromeCapability = new DesiredCapabilities();
//				chromeCapability.setCapability("platform", "Windows 11");
//				chromeCapability.setCapability("version", "latest");
//				chromeCapability.setCapability("name", testCaseName);
//				chromeCapability.setCapability("framework", "testng");
//				chromeCapability.setCapability("status", "COMPLETED");
//				chromeCapability.setCapability("buildName", buildName);
//				chromeCapability.setCapability("browserName", "Chrome");
//				chromeCapability.setCapability("browserVersion", "latest");
//				chromeCapability.setCapability("percyCaptureMode", "auto");
//				chromeCapability.setCapability("projectName", dateTimeStamp);
//				chromeCapability.setCapability("LambdaTest.idleTimeout", 300);
//				chromeCapability.setCapability("LambdaTest.chrome.enablePopups", "false");
//				chromeCapability.setCapability("autoGrantPermissions", "true");
//				chromeCapability.setCapability("visual", "true");
//
//				// INIT CHROME OPTIONS
//				ChromeOptions chromeOptions = new ChromeOptions();
//				Map<String, Object> prefs = new HashMap<String, Object>();
//				Map<String, Object> profile = new HashMap<String, Object>();
//				Map<String, Object> contentSettings = new HashMap<String, Object>();
//
//				// SET CHROME OPTIONS
//				// 0 - Default, 1 - Allow, 2 - Block
//				contentSettings.put("geolocation", 1);
//				profile.put("managed_default_content_settings", contentSettings);
//
//				prefs.put("profile.default_content_setting_values.notifications", 2);
//				prefs.put("autofill.profile_enabled", false);
//				prefs.put("credentials_enable_service", false);
//				prefs.put("autofill.credit_card_enabled", false);
//				prefs.put("profile.password_manager_enabled", false);
//				prefs.put("profile", profile);
//
//				// Chrome options to handle popups
//				chromeOptions.addArguments("--incognito");
//				chromeOptions.addArguments("--disable-infobars");
//				chromeOptions.addArguments("--disable-notifications");
//				chromeOptions.addArguments("--remote-allow-origins=*");
//				chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
//				chromeOptions.setExperimentalOption("prefs", prefs);
//
//				// Mobile View Configuration:
//				chromeOptions.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone 14 Pro Max"));
//
//				// SET CAPABILITY
//				chromeCapability.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//				driver = new RemoteWebDriver(new URL(URL), chromeCapability);
//				Thread.sleep(1000);
//				driver.manage().window().maximize();
//				Thread.sleep(2000);
//				jseLambdaTest = (JavascriptExecutor) driver;
//			}
			// ######################################################################## //

			// ########################## Local Execution ############################# //
			if (browser.equalsIgnoreCase("chromeLocal")) { // chromeLocal or chromeLocalMobileView
				localExecutionFlag = true;
				System.setProperty("webdriver.http.factory", "jdk-http-client");
				WebDriverManager.chromedriver().clearDriverCache().setup();
				// Chrome Popups Disable Configurations:
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("autofill.profile_enabled", false);
				prefs.put("credentials_enable_service", false);
				prefs.put("autofill.credit_card_enabled", false);
				prefs.put("profile.password_manager_enabled", false);

				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--disable-infobars");
				chromeOptions.addArguments("--disable-notifications");
				chromeOptions.addArguments("--remote-allow-origins=*");
				chromeOptions.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
				chromeOptions.setExperimentalOption("prefs", prefs);
//				// -----------------------------------------------------------------------
				// Mobile View Configuration:
//				chromeOptions.setExperimentalOption("mobileEmulation",
//						Map.of("deviceName", "Samsung Galaxy S20 Ultra"));
				// -----------------------------------------------------------------------
				driver = new ChromeDriver(chromeOptions);
			}
			// ######################################################################## //
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return driver;
	}

	// Join Our Mailing List and Receive - Pop-up Window Hiding:
	public void closePopupWindow() {
		try {
			action = new Actions(driver);
			defaultWaitTime(1000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			popupChild = driver.findElements(By.xpath("(//*[name()='circle'])[1]"));
			WebElement displayStatus = wait.until(ExpectedConditions.visibilityOf(popupChild.get(0)));
			if (displayStatus.isDisplayed()) {
				if (popupChild.get(0).isDisplayed())
					action.moveToElement(popupChild.get(0)).click().build().perform();
			}
			defaultWaitTime(1000);
		} catch (ElementNotInteractableException ex) {
		} catch (Exception ex) {
		}
	}

	public void closeCookiesPopupWindow() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// Option 1: Based on value attribute
			WebElement cookieBtn = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='Accept Cookies']")));

			// Option 2: Alternatively, based on aria-label
			// WebElement cookieBtn = wait.until(ExpectedConditions.elementToBeClickable(
			// By.xpath("//button[@aria-label='button for Accept Cookies']")
			// ));

			cookieBtn.click();
		} catch (Exception e) {
		}
	}

	public Boolean waitToPageLoadElementsFluentWait(Boolean visibilityStatus, List<WebElement> element) {
		try {
			Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
					.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);
			Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					boolean visibilityStatus = false;
					try {
						if (element.size() != 0)
							visibilityStatus = true;
						else {
							for (int i = 1; i <= 3; i++) {
								driver.navigate().refresh();
								defaultWaitTime(5000);
								if (element.size() != 0) {
									visibilityStatus = true;
									break;
								} else
									visibilityStatus = false;
							}
						}
					} catch (Exception ex) {
						ex.printStackTrace();
						visibilityStatus = false;
					}
					return visibilityStatus;
				}
			};
			visibilityStatus = fluentWait.until(function);
			System.out.println("Page Load Elements Visibility = " + visibilityStatus);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	// Validate 2FA authorization for Dispatch Site Login:
	public Boolean validateDispatchBypassCode(Boolean visibilityStatus) {
		System.out.println("Browser Type = " + browserType);
		try {
			defaultWaitTime(5000);
			action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(By.xpath("//button[normalize-space()='Skip for now']")));
			List<WebElement> skipBtn = driver.findElements(By.xpath("//button[normalize-space()='Skip for now']"));
			if (skipBtn.size() != 0)
				skipBtn.get(0).click();

			try {
				wait.until(ExpectedConditions
						.visibilityOfAllElementsLocatedBy(By.xpath("(//a[normalize-space()='Other options'])[1]")));
				defaultWaitTime(1000);
				List<WebElement> skipChromeUpdateScreen = driver
						.findElements(By.xpath("(//a[normalize-space()='Other options'])[1]"));
				if (skipChromeUpdateScreen.size() != 0) {
					skipChromeUpdateScreen.get(0).click();
					defaultWaitTime(3000);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(By.xpath("//div[normalize-space()='Bypass code']")));
			List<WebElement> getStartedBtn = driver.findElements(By.xpath("//div[normalize-space()='Bypass code']"));
			defaultWaitTime(3000);
			if (getStartedBtn.size() != 0)
				getStartedBtn.get(0).click();

			/*
			 * wait.until(ExpectedConditions .visibilityOfAllElementsLocatedBy(By.xpath(
			 * "//button[@data-testid='login-with-duo']"))); List<WebElement>
			 * loginWithDuoBtn =
			 * driver.findElements(By.xpath("//button[@data-testid='login-with-duo']")); if
			 * (loginWithDuoBtn.size() != 0) loginWithDuoBtn.get(0).click();
			 */
			try {
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@type='submit']")));
				defaultWaitTime(500);
			} catch (TimeoutException ex) {
				ex.printStackTrace();
			}

			String expected = driver.getCurrentUrl();
			if (expected.contains("duosecurity")) {
				wait.until(
						ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='passcode-input']")));
				WebElement bypassCode = driver.findElement(By.xpath("//input[@id='passcode-input']"));
				bypassCode.click();
				defaultWaitTime(500);
				action.moveToElement(bypassCode).click().build().perform();
				System.out.println("By Pass Code = " + prop.getProperty("bypassCode"));
				action.moveToElement(bypassCode).sendKeys(prop.getProperty("bypassCode")).build().perform();

				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@type='submit']")));
				WebElement verifyBtn = driver.findElement(By.xpath("//button[@type='submit']"));
				defaultWaitTime(1000);

				try {
					wait.until(ExpectedConditions.visibilityOf(verifyBtn));
					defaultWaitTime(1000);
					if (verifyBtn.isDisplayed()) {
						action.moveToElement(verifyBtn).click().build().perform();
						defaultWaitTime(5000);
						wait = new WebDriverWait(driver, Duration.ofSeconds(40));
						Boolean urlStatus = wait.until(ExpectedConditions.urlContains("dispatch"));
						if (urlStatus == true)
							visibilityStatus = true;
						else
							visibilityStatus = false;
					} else
						visibilityStatus = false;
				} catch (TimeoutException ex) {
					ex.printStackTrace();
				}
			} else if (expected.contains("dispatch"))
				visibilityStatus = true;
			else
				visibilityStatus = false;

			defaultWaitTime(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visibilityStatus;
	}

	// Click on FAQs checkbox for User Portal Ride-Details Page:
	public void clickonFAQscheckbox() {
		try {
			WebElement checkbox1 = driver
					.findElement(By.xpath("//label[@for='677c7684-e3ff-4afd-b679-7cbf41eaa70034']"));

			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", checkbox1);
			Thread.sleep(300);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox1);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Dispatch Payments Method:
	public void clickOnCardOption() {
		try {
			defaultWaitTime(2000);
			cardOptions.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// UserPortal 3 Horizontal Toggle Navigation Bar for SignIn[Simulator View]:
	public void clickOn3HorizontalToggleNavigationBar() {
		try {
			defaultWaitTime(6000);
			action = new Actions(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					By.xpath("(//div[normalize-space()='Book Now'])[1]//following::button[1]")));
			List<WebElement> displayStatus = driver
					.findElements(By.xpath("(//div[normalize-space()='Book Now'])[1]//following::button[1]"));
			if (displayStatus.size() != 0)
				action.moveToElement(displayStatus.get(0)).click().build().perform();
			defaultWaitTime(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Delete Created user from Dispatch Site:
	public Boolean deleteCreatedUserfromDispatch(Boolean visibilityStatus, String eMail) {
		try {
			action = new Actions(driver);
			driver.get(prop.getProperty("dispatchURL"));
			defaultWaitTime(3000);
			dispatcheMailInput.sendKeys(prop.getProperty("dispatchadminMail"));
			defaultWaitTime(500);
			action.sendKeys(Keys.TAB).build().perform();
			dispatchpasswordInput.sendKeys(prop.getProperty("dispatchadminPwd"));
			defaultWaitTime(500);

			try {
				dispatchsignInBtn.click();
				// Validate Dispatch 2fa Authentication:
				Boolean visibilityStatus1 = false;
				visibilityStatus1 = validateDispatchBypassCode(visibilityStatus1);
				utillLogger.info(
						"2FA Validation Status for Script - " + getClass().getSimpleName() + " = " + visibilityStatus1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			defaultWaitTime(3000);
			dispatchpassengersTab.click();
			defaultWaitTime(8000);
			action.moveToElement(dispatchSearchPassenger).click().sendKeys(eMail).build().perform();
			defaultWaitTime(5000);
			action.sendKeys(Keys.ENTER).build().perform();
			action.moveToElement(dispatchDeletePassenger).click().build().perform();
			defaultWaitTime(2000);
			action.moveToElement(dispatchYesBtn).click().build().perform();
			defaultWaitTime(5000);
			driver.navigate().refresh();
			defaultWaitTime(2000);
			action.moveToElement(dispatchSearchPassenger).click().sendKeys(eMail).build().perform();
			defaultWaitTime(2000);
			if (dispatchNoPassengerMsg.isDisplayed())
				visibilityStatus = true;
			else
				visibilityStatus = false;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return visibilityStatus;
	}

	public void lambdaTestStatusUpdate(String status, String testStep) throws Exception {
		try {
			if (status == "passed") {
				jseLambdaTest.executeScript("lambda-status=" + status);
				jseLambdaTest
						.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \""
								+ testStep + "\", \"level\": \"info\"}}");
				// Result Report Configuration:
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.PASS, testStep, exception);
			} else if (status == "failed") {
				jseLambdaTest.executeScript("lambda-status=" + status);
				jseLambdaTest
						.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \""
								+ testStep + "\", \"level\": \"error\"}}");
				// Result Report Configuration:
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			} else {
				jseLambdaTest.executeScript("lambda-status=" + status);
				jseLambdaTest
						.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \""
								+ testStep + "\", \"level\": \"warn\"}}");
				// Result Report Configuration:
				objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
			}
		} catch (Exception e) {
			e.printStackTrace();
			jseLambdaTest.executeScript("lambda-status=" + status);
			jseLambdaTest
					.executeScript("lambdatest_executor: {\"action\": \"stepcontext\", \"arguments\": {\"data\": \""
							+ testStep + "\", \"level\": \"warn\"}}");
			// Result Report Configuration:
			objupdateResults.updateResults(screenshotPath, logger, LogStatus.FAIL, testStep, exception);
		}
	}

	@AfterTest(alwaysRun = true)
	public void afterTest() {
		try {
			if (eMail != null) {
				String testStep = "Delete registered user from Dispath after all validations completed - " + "\n"
						+ "#Note: This step is only for Automation Suite runs to avoid unnecessary account creation on daily test runs - Status: ";
				Boolean visibilityStatus = false;
				visibilityStatus = deleteCreatedUserfromDispatch(visibilityStatus, eMail);
				utillLogger.info("##AfterTestMethod: " + testStep + visibilityStatus + " - Email: " + eMail);
			}
			extent.flush();
			driver.quit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}