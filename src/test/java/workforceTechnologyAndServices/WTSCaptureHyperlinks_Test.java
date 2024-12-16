package workforceTechnologyAndServices;

import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Arrays;
import java.util.TreeMap;
import java.util.HashMap;
import java.time.Duration;
import org.openqa.selenium.By;
import java.util.LinkedHashMap;
import java.util.logging.Logger;
import java.io.FileOutputStream;
import common.GetCurrentDateTime;
import org.testng.annotations.Test;
import java.util.logging.FileHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.logging.SimpleFormatter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.TimeoutException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.JavascriptExecutor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WTSCaptureHyperlinks_Test {

	static Boolean status;
	static String currURL;
	static FileHandler fh;
	static String expected;
	static WebDriver driver;
	static int rowIndex = 1;
	static String mainWindow;
	static WebDriverWait wait;
	static Logger utillLogger;
	static String currDateTime;
	static JavascriptExecutor js;
	static String currentLinkURL;
	static String currentLinkName;
	static String subCategoryLink;
	static String subCategoryName;
	static String childCategoryName;
	static String childCategoryLink;
	static Set<String> listOfWindows;
	static List<WebElement> displayStatus;
	static int subCategoryListlinkRowCount = 1;
	static List<WebElement> showMoreVendorsBtn;
	static Map<String, String> subCategoryList;
	static Map<String, String> childCategoryList;
	static WTSCaptureHyperlinks_Test objCatpureWebLinks;
	static List<WebElement> subCategoryLinksElement;
	static List<WebElement> childCategoriesWebElement;
	static List<WebElement> visibilityOfVisitWebsiteLink;
	static String baseURL = "https://www.myshortlister.com/categories";
	static Map<Integer, Object[]> excelData = new TreeMap<Integer, Object[]>();
	static Map<String, List<String>> SubCategoryMap1 = new HashMap<String, List<String>>();

	@BeforeClass
	public void beforeClass() {
		try {
			objCatpureWebLinks = new WTSCaptureHyperlinks_Test();
			utillLogger = Logger.getLogger(WTSCaptureHyperlinks_Test.class.getName());
			currDateTime = GetCurrentDateTime.getCurrentDateTime(currDateTime);
			// Local Path: Set the LogsFileName:
			fh = new FileHandler(System.getProperty("user.dir") + "/test-output/" + "WTS_CaptureHyperLinks_"
					+ currDateTime + "_ResultsFile" + ".log");
			utillLogger.addHandler(fh);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);

			utillLogger.info("## " + objCatpureWebLinks.getClass().getSimpleName()
					+ " - START --------------------------------------------------------------##");
		} catch (Exception ex) {
			ex.printStackTrace();
			utillLogger.info("Exception = " + ex.toString());
		}
	}

	@Test
	public static void validateCaptureHyperLinks() {
		try {
			driver = launchBrowser(driver);
			status = verifylaunchURL();
			if (status == true)
				verifyCaptureWebLinks();
			else
				System.out.println("Launch Browser and Load URL is Failed.!");
		} catch (Exception ex) {
			ex.printStackTrace();
			utillLogger.info("Exception = " + ex.toString());
		}
	}

	public static WebDriver launchBrowser(WebDriver driver) {
		try {
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
			options.addArguments("--disable-notifications");
			options.addArguments("--remote-allow-origins=*");
			options.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver();
		} catch (Exception ex) {
			ex.printStackTrace();
			utillLogger.info("Exception = " + ex.toString());
		}
		return driver;
	}

	public static Boolean verifylaunchURL() throws Exception {
		try {
			driver.get(baseURL);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			expected = driver.getCurrentUrl();

			if (expected != null)
				status = true;
			else
				status = false;
		} catch (Exception ex) {
			ex.printStackTrace();
			utillLogger.info("Exception = " + ex.toString());
		}
		return status;
	}

	public static void verifyCaptureWebLinks() {
		try {
			int count = 0;
			int childLinksCount = 0;
			Boolean repeatScrollDown = true;
			subCategoryList = new LinkedHashMap<String, String>();
			childCategoryList = new LinkedHashMap<String, String>();

			try {
				js = (JavascriptExecutor) driver;
				subCategoryLinksElement = driver.findElements(
						By.xpath("//div[@id='workforce-technology--services']//following-sibling::div[a][1]//a"));
				Thread.sleep(500);
				js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
				Thread.sleep(500);
				js.executeScript("arguments[0].scrollIntoView(true);", subCategoryLinksElement.get(0));
				Thread.sleep(3000);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				displayStatus = wait.until(ExpectedConditions.visibilityOfAllElements(subCategoryLinksElement));
			} catch (TimeoutException ex) {
				System.out.println("Exception = " + ex.toString() + "\n");
				utillLogger.info("Exception = " + ex.toString() + "\n");
			}

			// Capture all the Sub-category Links:
			if (displayStatus.size() != 0) {
				System.out.println(
						"List of Sub-Category Links Size under main Category [Workforce Technology & Services] - "
								+ subCategoryLinksElement.size());
				for (WebElement currEle : subCategoryLinksElement) {
					subCategoryList.put(currEle.getText(), currEle.getAttribute("href"));
				}
			}

			utillLogger.info(
					"###_____________________________________________________________________________________________________________________________________________ ###");
			System.out.println("Sub-Categories Hyperlinks Count = [" + subCategoryList.size() + "]");
			System.out.println("Sub-Categories Hyperlinks Data = " + subCategoryList);
			utillLogger.info("Sub-Categories Hyperlinks Count = [" + subCategoryList.size() + "]");
			utillLogger.info("Sub-Categories Hyperlinks Data = " + subCategoryList);
			utillLogger.info(
					"###_____________________________________________________________________________________________________________________________________________ ###");

			// -------------------------------------------------------------------------------------------------------
			// Configure the Excel Header:
			excelData.put(rowIndex, new Object[] { "Sub-CategoryName[ChildHyperlinksCount]", "Sub-CategoryLink",
					"Child-CategoryName", "Child-CategoryLink" });
			// -------------------------------------------------------------------------------------------------------

			for (Map.Entry subCategory : subCategoryList.entrySet()) {
				subCategoryName = subCategory.getKey().toString();
				subCategoryLink = subCategory.getValue().toString();
				if (subCategoryName.startsWith("-"))
					subCategoryName = subCategoryName.replaceAll("-", "").trim();
				utillLogger.info("subCategoryName and subCategoryLink = " + subCategoryName + " - " + subCategoryLink);
				// Open each SubCategory Link:
				if (!subCategory.getValue().toString().toLowerCase().contains("blocked")
						&& !subCategory.getValue().toString().toLowerCase().contains("javascript")) {
					// Load the subcategory url:
					driver.get(subCategory.getValue().toString());
					Thread.sleep(6000);
					driver.navigate().refresh();
					Thread.sleep(3000);
					try {
						showMoreVendorsBtn = driver.findElements(By.xpath("//button[@id='show-more-vendors']"));
						wait = new WebDriverWait(driver, Duration.ofSeconds(10));
						Thread.sleep(500);
						js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
						Thread.sleep(500);
						js.executeScript("arguments[0].scrollIntoView(true);", showMoreVendorsBtn.get(0));
						Thread.sleep(3000);
						displayStatus = wait.until(ExpectedConditions.visibilityOfAllElements(showMoreVendorsBtn));
						Thread.sleep(2000);
					} catch (TimeoutException ex) {
						utillLogger.info("Exception in Subcateogry Name @Placeholder[1] = " + subCategoryName
								+ " - Subcategory Link = " + subCategoryLink + " - subCategoryListlinkRowCount = "
								+ subCategoryListlinkRowCount + "\n" + " - Exception = " + ex.toString() + "\n");
						repeatScrollDown = false;
					} catch (IndexOutOfBoundsException ex) {
						utillLogger.info("Exception in Subcateogry Name @Placeholder[2] = " + subCategoryName
								+ "- Subcategory Link = " + subCategoryLink + "- subCategoryListlinkRowCount = "
								+ subCategoryListlinkRowCount + "\n" + " - Exception = " + ex.toString() + "\n");
						repeatScrollDown = false;
					}
					Thread.sleep(6000);
					if (displayStatus.size() != 0) {
						showMoreVendorsBtn.get(0).click();
						Thread.sleep(6000);
						try {
							Thread.sleep(500);
							js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
							Thread.sleep(500);
							js.executeScript("arguments[0].scrollIntoView(true);", showMoreVendorsBtn.get(0));
							Thread.sleep(3000);
							wait = new WebDriverWait(driver, Duration.ofSeconds(10));
							wait.until(ExpectedConditions.visibilityOfAllElements(showMoreVendorsBtn));
							Thread.sleep(2000);
						} catch (TimeoutException ex) {
							utillLogger.info("Exception in Subcateogry Name @Placeholder[3] = " + subCategoryName
									+ " - Subcategory Link = " + subCategoryLink + " - subCategoryListlinkRowCount = "
									+ subCategoryListlinkRowCount + "\n" + " - Exception = " + ex.toString() + "\n");
							repeatScrollDown = false;
						}

						Thread.sleep(6000);
						// Click on Show More Vendors until all Vendors loaded:
						while (repeatScrollDown == true) {
							Thread.sleep(500);
							showMoreVendorsBtn.clear();
							Thread.sleep(1000);

							wait = new WebDriverWait(driver, Duration.ofSeconds(8));
							showMoreVendorsBtn = driver.findElements(By.xpath("//button[@id='show-more-vendors']"));
							wait.until(ExpectedConditions.visibilityOfAllElements(showMoreVendorsBtn));
							Thread.sleep(1000);

							if (showMoreVendorsBtn.get(0).isDisplayed()) {
								showMoreVendorsBtn.get(0).click();
								Thread.sleep(6000);
								try {
									Thread.sleep(500);
									js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
									Thread.sleep(500);
									js.executeScript("arguments[0].scrollIntoView(true);", showMoreVendorsBtn.get(0));
									Thread.sleep(1000);
									wait = new WebDriverWait(driver, Duration.ofSeconds(10));
									displayStatus = wait
											.until(ExpectedConditions.visibilityOfAllElements(showMoreVendorsBtn));
									Thread.sleep(2000);
								} catch (TimeoutException ex) {
									ex.printStackTrace();
									utillLogger.info("Exception in Subcateogry Name @Placeholder[4] = "
											+ subCategoryName + "Subcategory Link = " + subCategoryLink
											+ "subCategoryListlinkRowCount = " + subCategoryListlinkRowCount + "\n"
											+ "Exception = " + ex.toString() + "\n");
									repeatScrollDown = false;
								}
								Thread.sleep(2000);
								if (displayStatus.size() != 0)
									repeatScrollDown = true;
								else
									repeatScrollDown = false;
							} else
								repeatScrollDown = false;
							Thread.sleep(2000);
						}
					}

					Thread.sleep(3000);
					js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
					Thread.sleep(1000);

					// Capture all the Child Hyperlinks for each Sub-category link:
					if (repeatScrollDown == false) {
						childCategoriesWebElement = driver.findElements(By.xpath(
								"//div[@class='vendor-item-wrapper']//preceding-sibling::h4//following-sibling::a[starts-with(@href,\"/\")]"));
						childLinksCount = childCategoriesWebElement.size();
						System.out.println("Child Category Total Links Count = " + childLinksCount);
						utillLogger.info("Child Category Total Links Count = " + childLinksCount);
						if ((childCategoriesWebElement.size() != 0)) {
							for (WebElement currElement : childCategoriesWebElement) {
								currentLinkName = currElement.getText();
								currentLinkURL = currElement.getAttribute("href");
								try {
									// Verify Visit Website Links is present:
									System.out.println("//a[contains(text()," + "'" + currentLinkName + "'"
											+ ")]//following-sibling::a[contains(normalize-space(),'Visit Website')]");
									visibilityOfVisitWebsiteLink = driver.findElements(By.xpath("//a[contains(text(),"
											+ "'" + currentLinkName + "'"
											+ ")]//following-sibling::a[contains(normalize-space(),'Visit Website')]"));
								} catch (InvalidSelectorException ex) {
									ex.printStackTrace();
								} catch (TimeoutException ex) {
									ex.printStackTrace();
								}

								if (visibilityOfVisitWebsiteLink.size() != 0) {
									currentLinkURL = visibilityOfVisitWebsiteLink.get(0).getAttribute("href");

									mainWindow = driver.getWindowHandle();
									visibilityOfVisitWebsiteLink.get(0).click(); // Click on the Visit Website link:
									Thread.sleep(8000);
									listOfWindows = driver.getWindowHandles();
									for (String currWindow : listOfWindows) {
										driver.switchTo().window(currWindow); // Control goes to last Window:
									}
									Thread.sleep(5000);
									driver.navigate().refresh();
									Thread.sleep(3000);
									currURL = driver.getCurrentUrl();
									Thread.sleep(1000);
									driver.close();
									Thread.sleep(1000);
									driver.switchTo().window(mainWindow); // Control back to Main Window:
									Thread.sleep(1000);
								} else {
									currURL = " ";
								}

								utillLogger.info(
										"currentLinkName & currentLinkURL = " + currentLinkName + " - " + currURL);
								Thread.sleep(1000);
								childCategoryList.put(currentLinkName, currURL);
								Thread.sleep(1000);
								count++;
							}
						} else {
							childCategoryList.put(subCategoryName, " ");
							utillLogger.info("No hyperlinks found for the Subcategory = " + subCategoryName + "\n");
						}
					}
				} else if (childLinksCount == 0) {
					childCategoryList.put(subCategoryName, " ");
					utillLogger.info(subCategoryName + subCategoryLink);
				}

				utillLogger.info(
						"###_____________________________________________________________________________________________________________________________________________ ###");

				// Update Sub-category Column Data:
				System.out.println(subCategoryName + "_[" + childLinksCount + "] - " + subCategoryLink);
				System.out.println(subCategoryName + "_[" + childLinksCount + "] - " + childCategoryList);
				utillLogger.info(subCategoryName + "_[" + childLinksCount + "] - " + " - " + subCategoryLink);
				utillLogger.info(subCategoryName + "_[" + childLinksCount + "] - " + childCategoryList);
				Thread.sleep(3000);

				// For EXCEL Data update:
				for (Map.Entry childCategory : childCategoryList.entrySet()) {
					childCategoryName = childCategory.getKey().toString();
					childCategoryLink = childCategory.getValue().toString();

					if (childCategoryName.startsWith("-"))
						childCategoryName = childCategoryName.replaceAll("-", "").trim();

					// Update Child-category Column Data for each Sub-category:
					System.out.println(subCategoryName + "_[" + childLinksCount + "] = " + childCategoryName + " - "
							+ "\n" + childCategoryLink);
					utillLogger.info(subCategoryName + "_[" + childLinksCount + "] = " + childCategoryName + " - "
							+ "\n" + childCategoryLink);

					excelData = captureDataForExcelUpdate(rowIndex + 1, subCategoryName + "[" + childLinksCount + "]",
							subCategoryLink, childCategoryName, childCategoryLink);
					rowIndex++;
				}

				// Reset back counts to zero:
				count = 0;
				childLinksCount = 0;
				childCategoryList.clear();
				childCategoriesWebElement.clear();
				showMoreVendorsBtn.clear();
				subCategoryListlinkRowCount++;
				utillLogger.info(
						"###_____________________________________________________________________________________________________________________________________________ ###");

			}

			System.out.println("ExcelData Size = " + excelData);
			System.out.println("ExcelData = " + excelData);
			utillLogger.info("ExcelData = " + excelData);

			// Update capture data into Excel:
			updateDataExcel(excelData);

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception = " + ex.toString() + "\n" + "subCategoryListlinkRowCount = "
					+ subCategoryListlinkRowCount);
			utillLogger.info("Exception = " + ex.toString() + "\n" + "subCategoryListlinkRowCount = "
					+ subCategoryListlinkRowCount);

			System.out.println("ExcelData Size from Exception Block = " + excelData);
			System.out.println("ExcelData from Exception Block = " + excelData);
			utillLogger.info("ExcelData from Exception Block = " + excelData);

			// Update capture data into Excel:
			updateDataExcel(excelData);
		}
	}

	private static void updateDataExcel(Map<Integer, Object[]> excelData) {
		try {
			XSSFWorkbook workbook = new XSSFWorkbook();
			XSSFSheet sheet = workbook.createSheet("Workforce Technology & Services");

			// Iterating over data and writing it to sheet
			Set<Integer> keyset = excelData.keySet();
			int rownum = 0;
			for (Integer key : keyset) {
				// Creating a new row in the sheet
				XSSFRow row = sheet.createRow(rownum++);
				Object[] objArr = excelData.get(key);
				int cellnum = 0;
				for (Object obj : objArr) {
					// This line creates a cell in the next column of that row
					XSSFCell cell = row.createCell(cellnum++);
					if (obj instanceof String)
						cell.setCellValue((String) obj);
					else if (obj instanceof Integer)
						cell.setCellValue((Integer) obj);
				}
			}
			// Writing the workbook
			FileOutputStream out = new FileOutputStream(System.getProperty("user.dir") + "/test-output/"
					+ "WTS_CaptureHyperLinks_" + currDateTime + "_ResultsFile" + ".xlsx");
			workbook.write(out);
			// Closing file output connections
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	private static Map<Integer, Object[]> captureDataForExcelUpdate(int rowIndex, String subCategoryName,
			String subCategoryLink, String childCategoryName, String childCategoryLink) {
		try {
			if (!subCategoryLink.toLowerCase().contains("javascript"))
				excelData.put(rowIndex,
						new Object[] { subCategoryName, subCategoryLink, childCategoryName, childCategoryLink });
			else
				excelData.put(rowIndex, new Object[] { subCategoryName, " ", childCategoryName, childCategoryLink });
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return excelData;
	}

	@AfterClass
	public void afterClass() {
		try {
			driver.quit();
			utillLogger.info("## " + objCatpureWebLinks.getClass().getSimpleName()
					+ " - END ----------------------------------------------------------------##");
		} catch (Exception ex) {
			ex.printStackTrace();
			utillLogger.info("Exception = " + ex.toString());
		}
	}
}
