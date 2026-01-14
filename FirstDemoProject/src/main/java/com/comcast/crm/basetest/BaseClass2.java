package com.comcast.crm.basetest;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;


import com.comcast.crm.basetest.BaseClass2;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;


import java.io.IOException;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DatabaseUtility;


public class BaseClass2 {
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public JavaUtility javaLib =new JavaUtility();
	public WebDriver driver;
	public int randomNum=javaLib.getRandomNumber();

	DatabaseUtility dbLib = new DatabaseUtility();
	@BeforeSuite
	public void configBS() {
		
		
		//dbLib.getDbConnection("DBURL", "UN", "PASSWD");
	}
	@Parameters("BROWSER")
	@BeforeClass
	public void configBC(String browser) throws IOException {
		
		String BROWSER=browser; //fLib.getDataFromProperyFile("browser");
		System.out.println(BROWSER);
		String URL = fLib.getDataFromProperyFile("url2");
		
		
	    driver=wlib.openWebBrowser(driver,BROWSER);
	    System.out.println(driver);
	    driver.manage().window().maximize();
	    driver.get(URL);
	    wlib.waitForPageToLoad(driver);
	
	}
	
	@BeforeMethod
	public void configBM() throws Exception {
		
		
	}
	
	@AfterMethod
	public void configAM()
	{
		
		
	}
	
	
	@AfterClass
	public void configAC() {
	//driver.quit();
	}
	@AfterSuite
	public void configAS() {
		
		}
	}

