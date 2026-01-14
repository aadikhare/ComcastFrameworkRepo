package firstprojectWinthTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.fileutility.JsonUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class Demo1 {

	public static void main(String[] args) throws Throwable {
		
		/*Objects*/
		
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JsonUtility jLib = new JsonUtility();
		WebDriverUtility wlib = new WebDriverUtility();
		JavaUtility javaLib =new JavaUtility();
		
		/* parameters*/
		WebDriver driver = null;
		String BROWSER = fLib.getDataFromProperyFile("browser");
		String URL = fLib.getDataFromProperyFile("url");
		
	
		
		/* Open browser*/
		
		driver= wlib.openWebBrowser(driver,BROWSER);
		
		/*Enter URL*/
		driver.get(URL);
		
		/*Read Excel Data*/
		String data= eLib.getDataFromExcel("org",2,2);
		System.out.println(data);
		
		/*write back to excel and read the same */
		eLib.setDataInToExcel("org",11,1,"aditya");
		String data1= eLib.getDataFromExcel("org",11,1);
		System.out.println(data1);
		
		/* print random number*/
		System.out.println(javaLib.getRandomNumber());
		
       /*getTime*/
		
		System.out.println(javaLib.getSystemDate());
		System.out.println(javaLib.getrequiredDate(31));
		
		
	}

}
