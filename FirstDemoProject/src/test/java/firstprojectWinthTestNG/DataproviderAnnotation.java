package firstprojectWinthTestNG;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JsonUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class DataproviderAnnotation {
	
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	JsonUtility jLib = new JsonUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	JavaUtility javaLib =new JavaUtility();
	
	@Test(dataProvider = "getData")
	
	public void AmazoneLoginTest(String brandName, String product ) throws IOException, InterruptedException
	{
		/* parameters*/
		WebDriver driver = null;
		String BROWSER = fLib.getDataFromProperyFile("browser");
		String URL = fLib.getDataFromProperyFile("url1");
	
		/* Open browser*/
		
		driver= wlib.openWebBrowser(driver,BROWSER);
		wlib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		/*Enter URL*/
		driver.get(URL);
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brandName,Keys.ENTER);
		
		String price=driver.findElement(By.xpath("//span[contains(text(),'"+product+"')]/ancestor::div[@class='puisg-col-inner']/descendant::span[@class='a-price']")).getText();
		
		System.out.println("product: "+ product + "price : " + price);
		
		driver.quit();
		
	}
	
	@DataProvider
	public Object[][] getData() throws Exception{
		int lastRow=eLib.getRowCount("AmazonProducts");
		
		Object [][] objArr= new Object[lastRow][2];
		
		for(int i=0;i<lastRow;i++) {
		objArr[i][0]=eLib.getDataFromExcel("AmazonProducts",i+1,0);
		objArr[i][1]=eLib.getDataFromExcel("AmazonProducts",i+1,1);
	}
return objArr;
}
}
