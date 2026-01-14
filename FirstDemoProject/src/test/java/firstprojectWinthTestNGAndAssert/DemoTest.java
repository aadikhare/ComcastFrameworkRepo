package firstprojectWinthTestNGAndAssert;

import java.io.File;
import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass2;

public class DemoTest extends BaseClass2{
	
	@Test
	public void demoTest() throws Exception {
		//int i=0;
		//int j=0;
		
		driver.findElement(By.xpath("//a[text()='Monitors']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='next2']")).click();
		
		Thread.sleep(2000);
		
	//List<WebElement> we=driver.findElements(By.xpath("//a[@class='hrefch']/ancestor::div[@class='card-block']/descendant::h5"));
	//List<WebElement> we1=driver.findElements(By.xpath("//a[@class='hrefch']"));
	
	
	
	//for(WebElement price:we) {
		//System.out.println(price.getText());
		
	//eLib.setDataInToExcel("demo", i, 1, price.getText());
	
	//i=i+1;
	//System.out.println(i);
	//Thread.sleep(2000);
	//}
	
	//for(WebElement name:we1) {
		//System.out.println(price1.getText());
		
	//eLib.setDataInToExcel("demo", j, 2, price1.getText());
	
	//j=j+1;
	//System.out.println(j);
	//Thread.sleep(2000);
	//}
	
	String email=fLib.getDataFromProperyFile("email");
	String name=fLib.getDataFromProperyFile("name");
	driver.findElement(By.xpath("//a[text()='Contact']")).click();
	driver.findElement(By.id("recipient-email")).sendKeys(email);
	driver.findElement(By.id("recipient-name")).sendKeys(name);
	driver.findElement(By.id("message-text")).sendKeys("hi this is first msg");
	driver.findElement(By.xpath("//button[text()='Send message']")).click();
	wlib.switchToAlert(driver);
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[text()='Phones']")).click();
	driver.findElement(By.xpath("(//a[@class='hrefch'])[position()=2]")).click();
	driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
	Thread.sleep(2000);
	wlib.switchToAlert(driver);
	
	driver.findElement(By.id("cartur")).click();
	
	Thread.sleep(2000);
	TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);

    // Save screenshot
    File destination = new File("screenshot.png");
    FileHandler.copy(source, destination);

    driver.findElement(By.xpath("//button[text()='Place Order']")).click();
    
   String  name1= eLib.getDataFromExcel("data", 1, 0);
    String  country=eLib.getDataFromExcel("data", 1, 1);
    String city=eLib.getDataFromExcel("data", 1, 2);
    String Credit=eLib.getDataFromExcel("data", 1, 3);
   String Month= eLib.getDataFromExcel("data", 1, 4);
   String Year= eLib.getDataFromExcel("data", 1, 5);
   
   driver.findElement(By.id("name")).sendKeys(name1);
   driver.findElement(By.id("country")).sendKeys(country);
   driver.findElement(By.id("city")).sendKeys(city);
   driver.findElement(By.id("card")).sendKeys(Credit);
   driver.findElement(By.id("month")).sendKeys(Month);
   driver.findElement(By.id("year")).sendKeys(Year);
   
   driver.findElement(By.xpath("//button[text()='Purchase']")).click();
   
   WebElement sucess=driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']"));
   
   SoftAssert obj = new SoftAssert();
   obj.assertTrue(sucess.getText().contains("Thank you for your purchase"));
   
   Thread.sleep(2000);
   
   driver.findElement(By.xpath("//button[text()='OK']")).click();
	}
    
	
	
    //=============================================================================================
   
   @Test(dataProvider = "getData")
	public void laptopData(String name1, String country, String city, String Credit,String Month, String Year ) throws InterruptedException 	{
		
	   driver.findElement(By.xpath("//a[text()='Laptops']")).click();
	   driver.findElement(By.xpath("(//a[@class='hrefch'])[position()=3]")).click();
	   driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		
		
	
		Thread.sleep(2000);
		
		wlib.switchToAlert(driver);
		
		driver.findElement(By.id("cartur")).click();
		
		
	    driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	     
	   driver.findElement(By.id("name")).sendKeys(name1);
	   driver.findElement(By.id("country")).sendKeys(country);
	   driver.findElement(By.id("city")).sendKeys(city);
	   driver.findElement(By.id("card")).sendKeys(Credit);
	   driver.findElement(By.id("month")).sendKeys(Month);
	   driver.findElement(By.id("year")).sendKeys(Year);
	   
	   driver.findElement(By.xpath("//button[text()='Purchase']")).click();
	   
	   WebElement sucess=driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']"));
	   SoftAssert obj = new SoftAssert();
	   obj.assertTrue(sucess.getText().contains("Thank you for your purchase"));
		}
		
		
		
	
	
	@DataProvider
	public Object[][] getData() throws Exception{
		
		
		
		Object [][] objArr= new Object[1][6];
	
		
		objArr[0][0]= eLib.getDataFromExcel("data", 1, 0);
		objArr[0][1]   =eLib.getDataFromExcel("data", 1, 1);
		objArr[0][2]=eLib.getDataFromExcel("data", 1, 2);
		objArr[0][3]=eLib.getDataFromExcel("data", 1, 3);
		objArr[0][4] = eLib.getDataFromExcel("data", 1, 4);
		objArr[0][5] = eLib.getDataFromExcel("data", 1, 5);
	
return objArr;
}
	
	
	}
	


