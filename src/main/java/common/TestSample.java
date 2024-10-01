package common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSample {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		options.addArguments("--disable-notifications");
		options.addArguments("--remote-allow-origins=*");
		options.setCapability(ChromeOptions.CAPABILITY, options);
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.myshortlister.com/aca-reporting-software/vendor-list?paged=5");
		Thread.sleep(30000);

		driver.manage().window().maximize();

		// Get list of web-elements with tagName - a
		List<WebElement> allLinks = driver.findElements(By.xpath(
				"//div[@class='vendor-item-wrapper']//preceding-sibling::h4//following-sibling::a[starts-with(@href,\"/\")]"));

		System.out.println(allLinks.size());

		// Traversing through the list and printing its text along with link address
		for (WebElement link : allLinks) {
			System.out.println(link.getText() + " - " + link.getAttribute("href"));
		}

		// Commenting driver.quit() for user to easily verify the links
		driver.quit();
	}
}