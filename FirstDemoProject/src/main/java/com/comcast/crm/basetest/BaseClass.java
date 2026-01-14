package com.comcast.crm.basetest;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;


import com.comcast.crm.basetest.BaseClass;
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


public class BaseClass {
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public JavaUtility javaLib =new JavaUtility();
	public WebDriver driver;
	public int randomNum=javaLib.getRandomNumber();
	
	public static WebDriver sdriver;

	DatabaseUtility dbLib = new DatabaseUtility();
	@BeforeSuite(groups= {"regression","smokeTest"})
	public void configBS() {
		
		
		//dbLib.getDbConnection("DBURL", "UN", "PASSWD");
	}
	@Parameters("BROWSER")
	@BeforeClass(groups= {"regression","smokeTest"})
	public void configBC(String browser) throws IOException {
		
		String BROWSER=browser; //fLib.getDataFromProperyFile("browser");
		System.out.println(BROWSER);
		String URL = fLib.getDataFromProperyFile("url");
		
		
	    driver=wlib.openWebBrowser(driver,BROWSER);
	    sdriver=driver;
	    System.out.println(driver);
	    driver.manage().window().maximize();
	    driver.get(URL);
	    wlib.waitForPageToLoad(driver);
	
	}
	
	@BeforeMethod(groups= {"regression","smokeTest"})
	public void configBM() throws Exception {
		/*LOGIN TO APPLICATION*/
		LoginPage lp=new LoginPage(driver);
    	
    	String USERNAME = fLib.getDataFromProperyFile("username");
    	String PASSWORD = fLib.getDataFromProperyFile("password");
		
		
		
		lp.getUsrEditField().sendKeys(USERNAME);
		lp.getPswdEditField().sendKeys(PASSWORD);
		lp.getSubmitBtn().click();
	}
	
	@AfterMethod(groups= {"regression","smokeTest"})
	public void configAM()
	{
		HomePage hp = new HomePage(driver); 
		WebElement logoutImg= hp.getLogoutImg();
		wlib.moveToElement(driver, logoutImg);
		hp.getSignOutLink().click();
		
	}
	
	
	@AfterClass(groups= {"regression","smokeTest"})
	public void configAC() {
	driver.quit();
	}
	@AfterSuite(groups= {"regression","smokeTest"})
	public void configAS() {
		
		}
	}

