package firstprojectWinthTestNGAndAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateProducts extends BaseClass {
	
@Test
	public  void createProducts() throws Exception {



		
		
		int randomNum=javaLib.getRandomNumber();
		String productName=eLib.getDataFromExcel("Product", 1,0)+randomNum ;
		
	
		
		/*CRATEING ORGANIZATION */
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Product')]")).click();
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
/*HEADER VERIFICATION*/
		
		String headerInfo = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		System.out.println(headerInfo);
		System.out.println(productName);
		Assert.assertTrue(headerInfo.contains(productName));
	}

@Test
public void ProductsWithStartAndDate() throws Exception {


		int randomNum=javaLib.getRandomNumber();
		String productName=eLib.getDataFromExcel("Product", 1,0)+randomNum ;
		String salesStartDate=javaLib.getSystemDate();
		String salesEndDate=javaLib.getrequiredDate(15);
		
		
		
		
		
		
		
		/*CRATEING PRODUCT*/
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Product')]")).click();
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.id("jscal_field_sales_start_date")).clear();
		driver.findElement(By.id("jscal_field_sales_start_date")).sendKeys(salesStartDate);
		driver.findElement(By.id("jscal_field_sales_end_date")).clear();
		driver.findElement(By.id("jscal_field_sales_end_date")).sendKeys(salesEndDate);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		String startDateDisplayed =driver.findElement(By.id("mouseArea_Sales Start Date")).getText();
		String endDateDisplayed =driver.findElement(By.id("mouseArea_Sales End Date")).getText();
				SoftAssert verify = new SoftAssert();
				verify.assertEquals(startDateDisplayed.trim(), salesStartDate);
				verify.assertEquals(endDateDisplayed.trim(), salesEndDate);
				verify.assertAll();
	}

@Test
public  void SearchProductAndDelete() throws Exception {

		int randomNum=javaLib.getRandomNumber();
		String productName=eLib.getDataFromExcel("Product", 1,0)+randomNum ;
		String salesStartDate=javaLib.getSystemDate();
		String salesEndDate=javaLib.getrequiredDate(15);
		
		
		
		
		
		/*CRATEING ORGANIZATION */
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//img[contains(@title,'Create Product')]")).click();
		driver.findElement(By.name("productname")).sendKeys(productName);
		driver.findElement(By.id("jscal_field_sales_start_date")).clear();
		driver.findElement(By.id("jscal_field_sales_start_date")).sendKeys(salesStartDate);
		driver.findElement(By.id("jscal_field_sales_end_date")).clear();
		driver.findElement(By.id("jscal_field_sales_end_date")).sendKeys(salesEndDate);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		//step
		
		
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//a[text()='Products']")).click();
		Thread.sleep(2000);
		System.out.println(productName);
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(productName);
		WebElement searchorg= driver.findElement(By.id("bas_searchfield"));
		wlib.selectOptions(searchorg,"Product Name");
		driver.findElement(By.xpath("//input[@value=' Search Now ' and @name  ]")).click();
		
	
		WebElement webElementToDelete=driver.findElement(By.xpath("(//a[contains(text(),'"+productName+"')]/ancestor::tr/td)[position()=15]/a[text()='del']"));
		wlib.waitForElementToclickable(driver, webElementToDelete);
		webElementToDelete.click();
		wlib.switchToAlert(driver);
		
		String noProductFound = driver.findElement(By.xpath("//span[contains(text(),'No Product Found !')]"))
				.getText();
		SoftAssert verify = new SoftAssert();
		verify.assertTrue(noProductFound.contains("No Product Found !"));
		verify.assertAll();
		//driver.quit();
		

}
}