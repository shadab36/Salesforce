package SalesForce;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SourceCloudSales {
	public static final String USERNAME = "test.shadab";
	public static final String ACCESS_KEY = "69802f7b-d56d-434c-980e-a57c7397a3ad";
	public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

	public static WebDriver driver;

	@Parameters("browser")

	@BeforeTest

	public void setup(String browser) throws Exception {
		// Check if parameter passed from TestNG is 'Chrome'

		if (browser.equalsIgnoreCase("chrome")) {
			// set path to Chromedrive.exe

			ChromeOptions caps = new ChromeOptions();
			Thread.sleep(1000);
			caps.addArguments("--disable-notifications");
			Thread.sleep(1000);
	
			caps.setCapability("platform", "Windows 10");
			caps.setCapability("version", "64");
		   driver = new RemoteWebDriver(new URL(URL), caps);
			driver.get("https://connect-inspiration-9547-dev-ed.cs90.my.salesforce.com/");
			Thread.sleep(1000);

		} else if (browser.equalsIgnoreCase("firefox")) {

			//
			FirefoxOptions caps = new FirefoxOptions();

			caps.setCapability("platform", "Windows 10");

			caps.setCapability("version", "57");

			WebDriver driver = new RemoteWebDriver(new URL(URL), caps);

			driver.get("https://connect-inspiration-9547-dev-ed.cs90.my.salesforce.com/");
			Thread.sleep(2000);
		}
		// Check if parameter passed as 'IE'
		else if (browser.equalsIgnoreCase("edge")) {

			DesiredCapabilities caps = DesiredCapabilities.edge();
			caps.setCapability("platform", "Windows 10");

			caps.setCapability("version", "16");

			WebDriver driver = new RemoteWebDriver(new URL(URL), caps);
			driver.get("https://connect-inspiration-9547-dev-ed.cs90.my.salesforce.com/");
			Thread.sleep(1000);
		}

		// set path of edgedriver.exe
		// System.setProperty(CommonData.Edge_Name, CommonData.Edge_Path);
		// driver = new EdgeDriver();
		//// driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		// }
		//
		else {
			// If no browser passed throw exception
			System.out.println("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// @Test(priority = 1)
		// public void login() throws InterruptedException {
		// // Open Url
		// driver.get("https://connect-inspiration-9547-dev-ed.cs90.my.salesforce.com/");
		// Thread.sleep(8000);

		// Login the application

		driver.findElement(By.id("username")).sendKeys("qascratch1@inscaletech.com");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("password")).sendKeys("AvSight1");
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.id("Login")).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(1000);

		// disable notificatio

		// xpath of Element
		String RFQ = "(//*[@class='slds-context-bar__label-action'])[4]";
		String New = "(//*[@title='New'])[2]";
		String List = "(//*[@class='listContent'])[2]";
		String Save = "//*[@title='Save']";
		String ReqNew = "//*[@class='slds-button slds-button--neutral']";

		String port = "(//*[@class='sl-lookup__input_container slds-grid slds-grid--pull-padded-xx-small'])[1]";
		String A100 = "//*[@class='slds-lookup__item-action slds-media']";
		String cond = "(//*[@class='slds-form-element__control'])[4]";
		String quant = "(//*[@class='slds-form-element__control'])[5]";

		// click on Rfq button and Create new RFQ
		driver.findElement(By.xpath(RFQ)).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath(New)).click();
		Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		WebElement e = driver.findElement(By.xpath(List));
		Actions a = new Actions(driver);
		a.doubleClick(e).build().perform();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.xpath(Save)).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		Thread.sleep(10000);

		// Create New on Rfq Section

		driver.findElement(By.xpath(ReqNew)).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		// down scroll
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");

		// click on port and select d
		WebElement wd = driver.findElement(By.xpath(port));
		Thread.sleep(1000);
		a.click(wd).build().perform();
		Thread.sleep(2000);
		a.sendKeys("A100").build().perform();
		Thread.sleep(1000);
		wd = driver.findElement(By.xpath(A100));
		a.doubleClick(wd).build().perform();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		// select condition code
		WebElement We = driver.findElement(By.xpath(cond));
		a.click(We).build().perform();
		Thread.sleep(1000);
		a.sendKeys("OH").build().perform();
		Thread.sleep(1000);
		a.click().build().perform();
		// QUANTITY

		WebElement wb = driver.findElement(By.xpath(quant));
		a.click(wb).build().perform();
		Thread.sleep(1000);
		a.sendKeys("10").build().perform();

		// scroll down
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);

		// new port quoted

		String PNQ = "(//*[@class='sl-lookup__input slds-col slds-p-horizontal--xx-small'])[3]";
		String RA100 = ".slds-lookup__menu>ul>li:nth-child(1)";
		String CCQ = "(//*[@class='slds-form-element__control'])[11]";
		String QQ = "(//*[@class='slds-form-element__control'])[12]";
		String UnitP = "(//*[@class='slds-form-element__control'])[13]";
		String save = "//*[@class='slds-button slds-button--brand']";
		String Gen = "(//*[@class='slds-button slds-button--neutral slds-truncate'])[3]";
		String pclose = "//*[@title='Close this window']";
		String Po = "(//*[@class='slds-button slds-button--neutral slds-truncate'])[4]";
		String Convert = "//*[@class='slds-button slds-button--brand']";

		WebElement portq = driver.findElement(By.xpath(PNQ));
		Thread.sleep(1000);
		Actions ac = new Actions(driver);
		ac.click(portq).build().perform();
		Thread.sleep(2000);
		ac.sendKeys("A100").build().perform();
		Thread.sleep(2000);
		portq = driver.findElement(By.cssSelector(RA100));
		ac.doubleClick(portq).build().perform();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(1000);

		// new request

		WebElement Wt = driver.findElement(By.xpath(CCQ));
		Thread.sleep(1000);
		ac.click(Wt).build().perform();
		Thread.sleep(1000);
		ac.sendKeys("OH").build().perform();
		Thread.sleep(1000);
		ac.sendKeys(Keys.ENTER).build().perform();
		ac.click().build().perform();

		Wt = driver.findElement(By.xpath(QQ));
		Thread.sleep(1000);
		ac.click(Wt).build().perform();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		ac.sendKeys("10").build().perform();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(2000);

		Wt = driver.findElement(By.xpath(UnitP));
		Thread.sleep(1000);
		ac.click(Wt).build().perform();
		Thread.sleep(1000);
		ac.sendKeys("100.00").build().perform();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,-1300)", "");
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath(save)).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(1000);

		driver.findElement(By.xpath(Gen)).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(1000);
		driver.findElement(By.xpath(pclose)).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath(Po)).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath(Convert)).click();
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		Thread.sleep(1000);
		// driver.findElement(By.xpath())
		// Thread.sleep(2000);

		// driver.close();
		// Thread.sleep(1000);
	}

}