package webApp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PerformAction {

	public static int SLEEP_TIME = 1000;
	public void delay()
	{
		try {
			Thread.sleep(SLEEP_TIME);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void performXpathClick(WebDriver driver,String code){
		delay();
		driver.findElement(By.xpath(code)).click();
		
	}
	
	public void implictywait(WebDriver driver){
	//	delay();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
}
	public void performIDClick(WebDriver driver,String code){
		delay();
		driver.findElement(By.id(code)).click();

	}
	public void performNameClick(WebDriver driver,String code){
		delay();
		driver.findElement(By.name(code)).click();
}
	

	public void performSendDataById(WebDriver driver,String code,String data){
	//	delay();
		driver.findElement(By.id(code)).sendKeys(data);
		
	}
	
}

