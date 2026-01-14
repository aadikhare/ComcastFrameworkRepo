package firstproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateContact {

	public static void main(String[] args) throws Exception {

/*OBJECTS CREATION*/
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		JavaUtility javaLib =new JavaUtility();
		
		WebDriver driver = null;
		String BROWSER = fLib.getDataFromProperyFile("browser");
		String URL = fLib.getDataFromProperyFile("url");
		String USERNAME = fLib.getDataFromProperyFile("username");
		String PASSWORD = fLib.getDataFromProperyFile("password");
		int randomNum=javaLib.getRandomNumber();
		String contactName=eLib.getDataFromExcel("contact", 1,0)+randomNum ;
		
		
		//====*CREATE contact*====//
		
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
		/*CREATE CONTACT*/
		driver.findElement(By.xpath("//a [@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		driver.findElement(By.name("lastname")).sendKeys(contactName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
/*HEADER VERIFICATION*/
		
		String headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(contactName)) {
		
		
		System.out.println(contactName + "sucessfully created" );
		
		
		System.out.println("===============TEST1 PASS=========================" );
		
	}else {
		System.out.println("===============TEST1 FAIL=========================" );
		
	}
		/*ORGANIZATION NAME VERIFICATION*/
		String lastName = driver.findElement(By.id("mouseArea_Last Name")).getText();
		
		if(lastName.trim().equals(contactName)) {
			
			
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
