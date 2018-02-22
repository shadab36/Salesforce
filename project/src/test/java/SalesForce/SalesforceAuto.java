package SalesForce;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.apache.log4j.Logger;

public class SalesforceAuto {

	public WebDriver driver;

	@Parameters("browser")

	@BeforeTest

	public void setup(String browser) throws Exception {
		// Check if parameter passed from TestNG is 'Chrome'

		if (browser.equalsIgnoreCase("chrome")) {
			// set path to Chromedrive.exe

			System.setProperty("webdriver.driver.chrome", "chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}
		// Check if parameter passed as 'firefox'
		else if (browser.equalsIgnoreCase("firefox")) {
			// set path to firefoxdriver.exe
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			FirefoxProfile ffprofile = new FirefoxProfile();
			ffprofile.setPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(ffprofile);

		}

		// // Check if parameter passed as 'IE'
		else if (browser.equalsIgnoreCase("edge")) {
			// set path of edgedriver.exe
			System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
			driver = new EdgeDriver();

		}

	}

	// Login the application with valid credentials
	@Test(priority = 0)
	public void login() throws InterruptedException {
		// Open Url
		driver.get("https://connect-inspiration-9547-dev-ed.cs90.my.salesforce.com/");
		Thread.sleep(1000);

		driver.findElement(By.id("username")).sendKeys("qascratch1@inscaletech.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("password")).sendKeys("AvSight1");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("Login")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
	}

	// Create new RfQ Vendor sight
	@Test(priority = 1)
	public void test_clcik() throws InterruptedException, FindFailed {
		

		// FluentWait
		
		String RFQ = "//*[@class='slds-context-bar__label-action'][(@href='/one/one.app#/sObject/inscor__RFQ__c/home')]";
	
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(RFQ)));

		
		
		WebElement et = driver.findElement(By.xpath(RFQ));
	 	et.click();
	 	 String text=et.getText();
	 	System.out.println(text);
		 Assert.assertEquals(true, et.isDisplayed());
		Thread.sleep(1000);
	}

	// create New Vendor Sight
	@Test(priority = 2)
	public void create_new() throws InterruptedException, FindFailed {
		

		
		String New = "(//*[@title='New'])[2]";
		String Search = "(//*[@class='autocompleteWrapper slds-grow'])[1]";
		String List = "(//*[@class='listContent'])[2]";
		String Save = "//*[@title='Save']";
		String ReqNew = "//*[@class='slds-button slds-button--neutral']";
		String port = "(//*[@class='sl-lookup__input_container slds-grid slds-grid--pull-padded-xx-small'])[1]";
		String A100 = "//*[@class='slds-lookup__item-action slds-media']";
		String cond = "(//*[@class='slds-form-element__control'])[4]";
		String quant = "(//*[@class='slds-form-element__control'])[5]";
		// // click on Rfq button and Create new RFQ
		driver.findElement(By.xpath(New)).click();	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement searc = driver.findElement(By.xpath(Search));
		Actions ac = new Actions(driver);
		ac.sendKeys("Av").build().perform();
		
		//send name 
		 String search=searc.getText();
		 	System.out.println(search);
			 Assert.assertEquals(true, searc.isDisplayed());
			Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);

		WebElement e = driver.findElement(By.xpath(List));
		
		 String list=e.getText();
		 	System.out.println(list);
			 Assert.assertEquals(true, e.isDisplayed());
			Thread.sleep(1000);
		
			//verify text name
		ac.doubleClick(e).build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		
		
		
		driver.findElement(By.xpath(Save)).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Thread.sleep(1000);

		// Create New on Rfq Section

		driver.findElement(By.xpath(ReqNew)).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// down scroll
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,200)", "");

		// click on port and select d
		WebElement wd = driver.findElement(By.xpath(port));
		Thread.sleep(1000);
		//verify port name
		
		 String Port=wd.getText();
		 	System.out.println(Port);
			 Assert.assertEquals(true, wd.isDisplayed());
			Thread.sleep(1000);
		
		Actions a = new Actions(driver);
		a.click(wd).build().perform();
		Thread.sleep(2000);
		a.sendKeys("A100").build().perform();
		Thread.sleep(1000);
		
	
		wd = driver.findElement(By.xpath(A100));
		a.doubleClick(wd).build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// select condition code
		WebElement We = driver.findElement(By.xpath(cond));
		//verfiy
		 String Con=We.getText();
		 	System.out.println(Con);
			 Assert.assertEquals(true, We.isDisplayed());
			Thread.sleep(1000);
		
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
		
		//Verify Quantity 
		 String qq=wb.getText();
		 	System.out.println(qq);
			 Assert.assertEquals(true, wb.isDisplayed());
			Thread.sleep(1000);
		
		// scroll down
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
	}

	//
	@Test(priority = 3)
	public void chek_new() throws InterruptedException {

		String PNQ = "(//*[@class='sl-lookup__input slds-col slds-p-horizontal--xx-small'])[3]";
		String RA100 = ".slds-lookup__menu>ul>li:nth-child(1)";
		String CCQ = "(//*[@class='slds-form-element__control'])[11]";
		String QQ = "(//*[@class='slds-form-element__control'])[12]";
		String UnitP = "(//*[@class='slds-form-element__control'])[13]";
		String save = "//*[@class='slds-button slds-button--brand']";

		WebElement portq = driver.findElement(By.xpath(PNQ));
		Thread.sleep(1000);
		Actions ac = new Actions(driver);
		ac.click(portq).build().perform();
		Thread.sleep(2000);
		
		//Verify quotation
		 String Search=portq.getText();
		 	System.out.println(Search);
			 Assert.assertEquals(true, portq.isDisplayed());
			Thread.sleep(1000);
		
		ac.sendKeys("A100").build().perform();
		Thread.sleep(2000);
		portq = driver.findElement(By.cssSelector(RA100));
		ac.doubleClick(portq).build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ac.sendKeys("10").build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
		Thread.sleep(2000);

		Wt = driver.findElement(By.xpath(UnitP));
		Thread.sleep(1000);
		ac.click(Wt).build().perform();
		Thread.sleep(1000);
		ac.sendKeys("100.00").build().perform();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);

		js.executeScript("window.scrollBy(0,-1300)", "");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);
		driver.findElement(By.xpath(save)).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}

	@Test(priority = 4)
	public void send_emal() throws InterruptedException {
		DOMConfigurator.configure("log4j.xml");
		Logger log = Logger.getLogger("devpinoyLogger");
		
		//xpath of Element
		String Gen = "(//*[@class='slds-button slds-button--neutral slds-truncate'])[3]";
		String email = ".cuf-content>section>div:nth-child(4)>div:nth-child(1)>div:nth-child(1)>div>input";
		String send = ".slds-button.slds-button--brand.slds-button_brand";
		// String pclose = "//*[@title='Close this window']";
		String Po = "(//*[@class='slds-button slds-button--neutral slds-truncate'])[4]";
		String Convert = "//*[@class='slds-button slds-button--brand']";

		WebElement gen = driver.findElement(By.xpath(Gen));
		gen.click();
		
		//Verify General quotation button
		
		 String GenQ=gen.getText();
		 	System.out.println(GenQ);
			 Assert.assertEquals(true, gen.isDisplayed());
			Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(1000);

		WebElement web = driver.findElement(By.cssSelector(email));
		Thread.sleep(1000);
		log.info("Click on Generate RfQ");
		web.sendKeys("amw.chhotusingh@gmail.com");
		Thread.sleep(1000);
		
		//verify email
		 String Email=web.getText();
		 	System.out.println(Email);
			 Assert.assertEquals(true, web.isDisplayed());
			Thread.sleep(1000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(send)).click();
		Thread.sleep(7000);
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Po)));
		web = driver.findElement(By.xpath(Po));
		web.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath(Convert)).click();
		log.info("Convert currenct");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.navigate().refresh();
		Thread.sleep(1000);
		//(//*[@data-name='In Progress'])[4]
		//(//*[@data-tab-name='Requested'])[4]
		//(//*[@data-tab-name='Sent to Vendor'])[4]
		
		String expectedMessage = "Requested";
		String expectedMessage1 = "In Progress";
		
		String message = driver.findElement(By.xpath("(//*[@data-name='In Progress'])[4]")).getText();
		Assert.assertTrue(message.contains(expectedMessage));
		System.out.println(message);
		Thread.sleep(200);
		String mess = driver.findElement(By.xpath("(//*[@data-name='In Progress'])[4]")).getText();
		Assert.assertTrue(mess.contains(expectedMessage1));
		System.out.println(message);
	
		
	}

	@Test(priority = 5)
	public void close_browser() throws InterruptedException {
		driver.close();
		Thread.sleep(3000);
	}
}