package firstproject;

import org.openqa.selenium.WebDriver;

import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class DemoObjectRepoLoginPage {
	
	public static void main(String[] args) throws Exception {
		
		FileUtility fLib = new FileUtility();
		String BROWSER = fLib.getDataFromProperyFile("browser");
		
		WebDriver driver=null;
		WebDriverUtility wLib = new WebDriverUtility();
		driver=wLib.openWebBrowser(driver,BROWSER);
		
		String URL = fLib.getDataFromProperyFile("url");
		driver.get(URL);
		
        LoginPage lp = new LoginPage(driver);
        lp.getUsrEditField().sendKeys("admin");
        lp.getPswdEditField().sendKeys("admin");
        lp.getSubmitBtn().click();
        
        
        
	}

}
