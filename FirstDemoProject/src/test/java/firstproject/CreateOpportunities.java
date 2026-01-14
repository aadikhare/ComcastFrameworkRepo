package firstproject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JsonUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateOpportunities {

	public static void main(String[] args) throws Exception {

	/*OBJECTS CREATION*/
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		JavaUtility javaLib =new JavaUtility();
		
		/* PARAMETERS */
		WebDriver driver = null;
		String BROWSER = fLib.getDataFromProperyFile("browser");
		String URL = fLib.getDataFromProperyFile("url");
		String USERNAME = fLib.getDataFromProperyFile("username");
		String PASSWORD = fLib.getDataFromProperyFile("password");
		int randomNum=javaLib.getRandomNumber();
		String ActualOpportunity=eLib.getDataFromExcel("Opportunity", 1,0)+randomNum ;
		String ActualOrganizationName=eLib.getDataFromExcel("org", 1,1)+randomNum ;
		String address=eLib.getDataFromExcel("org", 1,2)+randomNum ;
		String ExpectedCloseDate=javaLib.getrequiredDate(31);
		
		
		
		/* OPEN BROWSER*/
		driver= wlib.openWebBrowser(driver,BROWSER);
		
		wlib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		/*ENTER URL*/
		
		driver.get(URL);
		
		/*LOGIN TO APPLICATION*/
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*CRATEING ORGANIZATION */
		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Organization')]")).click();
		driver.findElement(By.name("accountname")).sendKeys(ActualOrganizationName);
		driver.findElement(By.name("ship_street")).sendKeys(address);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		Thread.sleep(3000);
		
		/*CREATE OPPORTUNITY*/
		driver.findElement(By.xpath("//a[text()='Opportunities']")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Opportunity')]")).click();
		driver.findElement(By.name("potentialname")).sendKeys(ActualOpportunity);
		
		driver.findElement(By.xpath("//input[@id='related_to_display']/ancestor::td[@class='dvtCellInfo']/descendant::img")).click();
		driver=wlib.moveControlToWindow(driver, "Accounts&action");
		driver.findElement(By.id("search_txt")).sendKeys(ActualOrganizationName);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='"+ActualOrganizationName+"']")).click();
		driver=wlib.moveControlToWindow(driver, "Potentials&action");
		
		driver.findElement(By.id("jscal_field_closingdate")).clear();
		driver.findElement(By.id("jscal_field_closingdate")).sendKeys(ExpectedCloseDate);
		
		
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//verification
		
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(ActualOpportunity)) {
		
		
		System.out.println(ActualOpportunity + "sucessfully created" );
		
		
		System.out.println("===============TEST1 PASS=========================" );
		
	}else {
		System.out.println("===============TEST1 FAIL=========================" );
		
	}
		/* VERIFICATION*/
		String ApportunityDisplayed = driver.findElement(By.id("mouseArea_Opportunity Name")).getText();
		
		if(ApportunityDisplayed.trim().equals(ActualOpportunity)) {
			
			
			System.out.println("===============TEST2 PASS=========================" );
			
		}else {
			System.out.println("===============TEST2 FAIL=========================" );
			
		}
		WebElement logout= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.moveToElement(driver, logout);
		driver.findElement(By.partialLinkText("Sign Out")).click();
		
		driver.quit();

	}

}
