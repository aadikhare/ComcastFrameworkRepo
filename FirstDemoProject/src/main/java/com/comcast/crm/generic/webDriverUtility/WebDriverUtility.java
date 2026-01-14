package com.comcast.crm.generic.webDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
    /*implicit wait*/
	
	public void waitForPageToLoad (WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	
	/*Explicit wait*/
	
	public void waitForElementToPresent (WebDriver driver, WebElement element) {

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementToclickable (WebDriver driver, WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
	
	/* Open Web Browser */
	
	public WebDriver openWebBrowser(WebDriver driver, String BROWSER) {
      
	WebDriver driver1;
		
		if(BROWSER.equals("firefox")) {
			driver1=new FirefoxDriver();
		}
		else if(BROWSER.equals("chrome")) {
			driver1=new ChromeDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver1=new EdgeDriver();
		}
		else
		{
			driver1=new ChromeDriver();
		}
	 return driver1;
	}
	
	/*Select options from Drop down using visibleText*/
	
	public void selectOptions(WebElement element,String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	  }
	public void selectOptions(WebElement element,int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
		
	}
	
	/*MOUSE ACTIONS*/
	
   /* Double click*/
	
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
		
	}
	/* MOUSE HOVER*/
	public void moveToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	public WebDriver moveControlToWindow(WebDriver driver,String title) {
		
		Set<String> allWindows=driver.getWindowHandles();
		Iterator<String> window=allWindows.iterator();
		while(window.hasNext()) {
			String windowID=window.next();
			driver.switchTo().window(windowID);
			
			String urlTitle = driver.getTitle();
			if(urlTitle.contains(title)){
				break;
			}
				
			}
			return driver;
		}
		
public void switchToAlert(WebDriver driver) {
		
		
		
			driver.switchTo().alert().accept();
			
	}

}

