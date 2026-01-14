package firstprojectWinthTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrgTest {
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	JavaUtility javaLib =new JavaUtility();
	int randomNum=javaLib.getRandomNumber();
	String actualOrganizationName= null;
@Test

	public void DeleteDynamicDataTest() throws Exception {
	
	
	
	WebDriver driver = null;
	String BROWSER = fLib.getDataFromProperyFile("browser");
	String URL = fLib.getDataFromProperyFile("url");
	String USERNAME = fLib.getDataFromProperyFile("username");
	String PASSWORD = fLib.getDataFromProperyFile("password");
    actualOrganizationName= eLib.getDataFromExcel("org", 1,1)+randomNum;
	
	String address=eLib.getDataFromExcel("org", 1,2)+randomNum ;
	
	
	
	/* OPEN BROWSER*/
	driver= wlib.openWebBrowser(driver,BROWSER);
	
	wlib.waitForPageToLoad(driver);
	driver.manage().window().maximize();
	
	/*ENTER URL*/
	
	driver.get(URL);
	
	/*LOGIN TO APPLICATION*/
	LoginPage lp=new LoginPage(driver);
	
	lp.getUsrEditField().sendKeys(USERNAME);
	lp.getPswdEditField().sendKeys(PASSWORD);
	lp.getSubmitBtn().click();
	
	/*CRATEING ORGANIZATION*/
	
	//Step 1
	HomePage hp = new HomePage(driver); 
	hp.getOrganizationsLink().click();
	
	//Step 2
	OrganizationsPage op = new OrganizationsPage(driver); 
	op.getCreateOrganizationbtn().click();
	
	//Step 3
	CreatingNewOrganization cno = new CreatingNewOrganization(driver);		
	cno.getOrganizationNametxtfld().sendKeys(actualOrganizationName);
	cno.getShippingAddress().sendKeys(address);
	cno.getSavebtn().click();
	
	//step 4
	 Thread.sleep(2000);
	hp.getOrganizationsLink().click();
	Thread.sleep(2000);
	System.out.println(actualOrganizationName);
	driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(actualOrganizationName);
	WebElement searchorg= driver.findElement(By.id("bas_searchfield"));
	wlib.selectOptions(searchorg,"Organization Name");
	driver.findElement(By.xpath("//input[@value=' Search Now ' and @name  ]")).click();
	
	WebElement webElementToDelete=driver.findElement(By.xpath("(//a[text()='"+actualOrganizationName+"']/ancestor::tr[@class='lvtColData']/td)[position()=8]/a[text()='del']"));
	wlib.waitForElementToclickable(driver, webElementToDelete);
	webElementToDelete.click();
	driver.quit();
	
	
}
	
	

}
