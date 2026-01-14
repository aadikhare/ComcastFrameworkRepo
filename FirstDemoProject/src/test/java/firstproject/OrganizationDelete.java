package firstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JsonUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class OrganizationDelete {

	public static void main(String[] args) throws Exception {
		
	/*OBJECTS CREATION*/
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JsonUtility jLib = new JsonUtility();
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
		
		//step 4
		 Thread.sleep(2000);
		WebElement organizationNameLink= driver.findElement(By.xpath("//a[text()='Organizations']"));
		wlib.waitForElementToclickable(driver, organizationNameLink);
		organizationNameLink.click();
		Thread.sleep(2000);
		System.out.println(ActualOrganizationName);
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(ActualOrganizationName);
		WebElement searchorg= driver.findElement(By.id("bas_searchfield"));
		wlib.selectOptions(searchorg,"Organization Name");
		driver.findElement(By.xpath("//input[@value=' Search Now ' and @name  ]")).click();
		Thread.sleep(3000);
		
		WebElement webElementToDelete=driver.findElement(By.xpath("(//a[contains(normalize-space(text()),'"+ActualOrganizationName+"')]/ancestor::tr[@class='lvtColData']/td)[position()=8]/a[text()='del']"));
		System.out.println(webElementToDelete);
		wlib.waitForElementToclickable(driver, webElementToDelete);
		webElementToDelete.click();
		wlib.switchToAlert(driver);
		//driver.quit();
	

	}

}
