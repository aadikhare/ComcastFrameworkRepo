package firstprojectWinthTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateContactWithOrganization {

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
		String ActualOrganizationName=eLib.getDataFromExcel("org", 1,1)+randomNum ;
		String address=eLib.getDataFromExcel("org", 1,2)+randomNum ;
		String contactName=eLib.getDataFromExcel("contact", 1,0)+randomNum ;
		
		
		
		
		
		
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
		//WebElement we= driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Contacts']"));
		//wlib.waitForElementToclickable(driver, we);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//input[@name='account_name']/ancestor::td[@class='dvtCellInfo']/descendant::img")).click();
		driver=wlib.moveControlToWindow(driver, "Accounts&action");
		driver.findElement(By.id("search_txt")).sendKeys(ActualOrganizationName);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[text()='"+ActualOrganizationName+"']")).click();
		driver=wlib.moveControlToWindow(driver, "Contacts&action");
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
		
	}

}
