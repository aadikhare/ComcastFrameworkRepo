package firstprojectWinthTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class ProductsWithStartAndDate {

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
		String productName=eLib.getDataFromExcel("Product", 1,0)+randomNum ;
		String salesStartDate=javaLib.getSystemDate();
		String salesEndDate=javaLib.getrequiredDate(15);
		
		
		
		
		
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
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Product')]")).click();
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.id("jscal_field_sales_start_date")).clear();
		driver.findElement(By.id("jscal_field_sales_start_date")).sendKeys(salesStartDate);
		driver.findElement(By.id("jscal_field_sales_end_date")).clear();
		driver.findElement(By.id("jscal_field_sales_end_date")).sendKeys(salesEndDate);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}


	}


