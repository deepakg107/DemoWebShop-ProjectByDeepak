package org.dwsapp.genericlibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;



public class WebDriverLibrary implements ProjectConstant {

	public WebDriver driver;
	public static WebDriver stdriver;
	public Actions actionobj;
	public Select selectobj;

	public void openBrowser(String browser) {
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
			stdriver = driver;

			Reporter.log("chrome browser opened", true);
		}

		else if (browser.equals("edge")) {
			driver = new EdgeDriver();
			stdriver = driver;

			Reporter.log("edge browser opened", true);
		} else {
			Reporter.log("invalid browser", true);
		}

	}

	public void navigateToApplication(String url) {
		driver.get(url);
	}

	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void closeSingleBrowser() {
		driver.close();
	}

	public void closeAllBrowser() {
		driver.quit();
	}

	public void waitStatement() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitduration));
	}

	public void waitStatement(WebElement element) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(waitduration));
		w.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void clickOnElementUsingActionsClass(WebElement element) {
		actionobj = new Actions(driver);
		actionobj.moveToElement(element).click(element).perform();
	}

	public void enterDataOnElements(WebElement element, String data) {
		element.clear();
		element.sendKeys(data);
	}

	public void enterDataOnElementsUsingActionsClass(WebElement element, String data) {
		element.clear();
		actionobj = new Actions(driver);
		actionobj.moveToElement(element).sendKeys(data).perform();
	}

	public void mouseHoverToElement(WebElement element) {
		actionobj = new Actions(driver);
		actionobj.moveToElement(element).perform();
	}

	public void selectOptions(WebElement element, int value) {
		selectobj = new Select(element);
		selectobj.selectByIndex(value);
	}

	public void selectOptions(String visibletext,WebElement element) {
		selectobj = new Select(element);
		selectobj.selectByVisibleText(visibletext);
	}

	public void selectOptions(WebElement element, String value) {
		selectobj = new Select(element);
		selectobj.selectByValue(value);
	}
}
