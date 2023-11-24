package automation.common;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static automation.common.TestLogger.*;

public class CommonBase {
	public WebDriver driver;
	protected String baseUrl = "https://staging.capa.ai/";
	protected int DEFAULT_TIMEOUT = 20000;
	protected int WAIT_INTERVAL = 1000;
	public int loopCount = 0;
	public final int ACTION_REPEAT = 5;
	public Actions action;

	/**
	 * init Driver
	 *
	 * @param URL
	 */
	public WebDriver initDriverTest(String... URL) {
		String url1 = URL.length > 0 ? URL[0] : baseUrl;
		String proName = URL.length > 2 ? URL[2] : "";
		String broName = URL.length > 1 ? URL[1] : "chrome";
		String url2 = System.getProperty("Url");
		String browser = System.getProperty("browser");
		String plaForm = System.getProperty("platForm");
		WebDriver dr = null;

		if (browser == null) {
			browser = broName;
		}
		ChromeOptions options = new ChromeOptions();
		if ("chrome".equals(browser)) {
			System.setProperty("webdriver.chrome.driver",
			System.getProperty("user.dir") + "\\driver\\chromedriver119.exe");
			dr = new ChromeDriver();
		} else if ("iexplorer".equals(browser)) {
			dr = new InternetExplorerDriver();
		} else if ("safari".equals(browser)) {
			dr = new SafariDriver();
		} else {
			if (proName != null && proName != "") {
				FirefoxProfile ffprofile = new FirefoxProfile(new File(proName));
				dr = new FirefoxDriver(ffprofile);
			} else {
				FirefoxProfile fxProfile = new FirefoxProfile();
				File browserAppPath = new File("/usr/bin/geckodriver");
				FirefoxBinary ffBin = new FirefoxBinary(browserAppPath);
				dr = new FirefoxDriver(ffBin, fxProfile);
			}
		}
		if (url2 != "" && url2 != null) {
			dr.get(url2);
		} else {
			dr.get(url1);
		}
		dr.manage().window().maximize();
		dr.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		return dr;
	}

	public WebDriver initChromeDriver(String URL)
	{
		ChromeOptions options = new ChromeOptions();
		System.setProperty("webdriver.chrome.driver",
		System.getProperty("user.dir") + "\\driver\\chromedriver119.exe");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * pause driver in timeInMillis
	 *
	 * @param timeInMillis
	 */
	public void pause(long timeInMillis) {
		try {
			Thread.sleep(timeInMillis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * click on an element */

	public void click(Object locator) {
		By xPath = locator instanceof By ? (By) locator : By.xpath(locator.toString());
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement elementClick = wait.until(ExpectedConditions
				.elementToBeClickable(xPath));
		elementClick.click();
	}

	/** get absolute path of file
	 *
	 * @param relativeFilePath
	 * @return
	 */
	public String getAbsoluteFilePath(String relativeFilePath) {
		String curDir = System.getProperty("user.dir");
		String absolutePath = curDir + relativeFilePath;
		return absolutePath;
	}


	/**
	 *
	 * @param locator
	 * @param opParams
	 */
//	public void mouseOverAndClick(Object locator, Object... opParams) {
//		WebElement element;
//		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0] : 0);
//		Actions actions = new Actions(driver);
//		try {
//			element = getElementPresent(locator, DEFAULT_TIMEOUT, 1, notDisplay);
//			actions.moveToElement(element).click(element).build().perform();
//		} catch (StaleElementReferenceException e) {
//			mouseOverAndClick(locator, opParams);
//		}
//	}

	/**
	 * quit driver if driver existed
	 *
	 * @param dr
	 */
	public void quitDriver(WebDriver dr) {
		if (dr.toString().contains("null")) {
			System.out.print("All Browser windows are closed ");
		} else {
			driver.manage().deleteAllCookies();
			dr.close();
		}
	}

	/**
	 * switch to a frame
	 *
	 * @param locator
	 * @param opParams
	 */
//	public void switchToFrame(Object locator, Object... opParams) {
//		info("Switch to frame " + locator);
//		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0] : 0);
//		try {
//			driver.switchTo().frame(getElementPresent(locator, DEFAULT_TIMEOUT, 1, notDisplay));
//		} catch (Exception e) {
//			switchToFrame(locator, notDisplay);
//		}
//	}

	/**
	 * back to main frame
	 */
	public void switchToParentFrame() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			switchToParentFrame();
		}
	}

	/**
	 * accept unexpected alert
	 */
	public void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException ex) {
			info("No Alert present");
			;
		}
	}

	/**
	 *
	 * @param locator
	 * @param opParams
	 */
//	public void scrollToElement(Object locator, Object... opParams) {
//		int notDisplay = (Integer) (opParams.length > 0 ? opParams[0] : 0);
//		WebElement element = getElementPresent(locator, DEFAULT_TIMEOUT, 1, notDisplay);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//	}

	/**
	 * check field is null = ""
	 *
	 * @param s
	 */
	public void verifyNull(String s) {
		if (!s.equalsIgnoreCase("")) {
			Assert.fail("Du lieu khong null");
		}
	}

	/**
	 * tra ve so lan xuat hien cua 1 xau trong chuoi
	 *
	 * @param value
	 * @param array
	 * @return
	 */
	public String checkValueInArray(String value, String[] array) {
		int soLan = 0;
		if (value != null && value != "" && array.length > 0) {
			for (int i = 0; i < array.length; i++) {
				if (value.equalsIgnoreCase(array[i])) {
					soLan++;
					info("Chuoi \"" + value + "\" xuat hien trong mang lan thu: " + soLan);
				}
			}
			return String.valueOf(soLan);
		} else {
			info("Chuoi can kiem tra dang null hoac mang khong co phan tu");
			return "";
		}
	}

	/**
	 *
	 * @param string
	 * @param split
	 * @return
	 */
	public String[] convertStringToArray(String string, String split) {
		String[] a = new String[100];
		if (string != null && string != "") {
			a = string.split(split);
		} else {
			info("Xau ky tu can chuyen sang mang ");
		}
		return a;
	}

	public int initWaitTime = 30;

	public void inputTextJavaScriptInnerHTML(By inputElement, String companyName) {
		WebElement element = driver.findElement(inputElement);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].innerHTML = '" + companyName + "'", element);
		} catch (StaleElementReferenceException ex) {
			pause(1000);
			inputTextJavaScriptInnerHTML(inputElement, companyName);
		}
	}

	public void inputTextJavaScriptValue(By locator, String value) {
		WebElement element = getElementPresentDOM(locator);
		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "'", element);
		} catch (StaleElementReferenceException ex) {
			pause(1000);
			inputTextJavaScriptValue(locator, value);
		}
	}

	public void scrollToElement(By locator) {
		WebElement element = getElementPresentDOM(locator);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public WebElement getElementPresentDOM(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}

	public boolean isElementPresent(By locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
		wait.until(ExpectedConditions.visibilityOf(getElementPresentDOM(locator)));
		return getElementPresentDOM(locator).isDisplayed();
	}
	public void click(By locator)
	{
		WebElement element = getElementPresentDOM(locator);
		WebDriverWait wait = new WebDriverWait(driver, initWaitTime);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	public void type(By locator, String value)
	{
		WebElement element = getElementPresentDOM(locator);
		element.sendKeys(value);
	}


}
