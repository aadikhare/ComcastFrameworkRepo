package firstprojectWinthTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JsonUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateOranizationWithIndustryAndType {

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
		
		WebElement industory= driver.findElement(By.name("industry"));
		String ActIndustory=eLib.getDataFromExcel("org", 1,3);
		wlib.selectOptions(industory,ActIndustory);
	
		WebElement type= driver.findElement(By.name("accounttype"));
		String Actualtype=eLib.getDataFromExcel("org", 1,4);
		wlib.selectOptions(type,Actualtype);
		
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
	
				
		
		/*INDUSTORY VERIFICATION*/
		String industoryDisplayed = driver.findElement(By.id("mouseArea_Industry")).getText();
		
		
		if(industoryDisplayed.equals(ActIndustory)) {
			
			
			System.out.println("===============TEST3 PASS=========================" );
			
		}else {
			System.out.println("===============TEST3 FAIL=========================" );
			
		}
		
		/*TYPE VERIFICATION*/
		
		String typeDisplayed = driver.findElement(By.id("mouseArea_Type")).getText();
		
		if(typeDisplayed.equals(Actualtype)) {
			
			
			System.out.println("===============TEST4 PASS=========================" );
			
		}else {
			System.out.println("===============TEST4 FAIL=========================" );
			
		}
		
		/*==LOGOUT==*/
		
		WebElement logout= driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wlib.moveToElement(driver, logout);
		driver.findElement(By.partialLinkText("Sign Out")).click();
		System.out.println(javaLib.getSystemDate());
		driver.quit();
}

	}


