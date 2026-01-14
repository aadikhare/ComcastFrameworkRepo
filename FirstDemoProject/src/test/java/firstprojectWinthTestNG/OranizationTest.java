package firstprojectWinthTestNG;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


public class OranizationTest {
	
	/*Utility OBJECTS CREATION*/
	
	FileUtility fLib = new FileUtility();
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wlib = new WebDriverUtility();
	JavaUtility javaLib =new JavaUtility();
	
	
	
    @Test
	public void createOranizationTest() throws Exception {
		
		
    	/* PARAMETERS */
    	WebDriver driver = null;
    	String BROWSER = fLib.getDataFromProperyFile("browser");
    	String URL = fLib.getDataFromProperyFile("url");
    	String USERNAME = fLib.getDataFromProperyFile("username");
    	String PASSWORD = fLib.getDataFromProperyFile("password");
    	int randomNum=javaLib.getRandomNumber();
    	String actualOrganizationName=eLib.getDataFromExcel("org", 1,1)+randomNum ;
    	String address=eLib.getDataFromExcel("org", 1,2)+randomNum ;
    	
		
		
		/* OPEN BROWSER*/
		driver= wlib.openWebBrowser(driver,BROWSER);
		
		wlib.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		/*ENTER URL*/
		
		driver.get(URL);
		
		/*LOGIN TO APPLICATION*/
		LoginPage lp=new LoginPage(driver);
		
		lp.getUsrEditField().sendKeys(USERNAME);
		lp.getPswdEditField().sendKeys(PASSWORD);
		lp.getSubmitBtn().click();
		
		/*CRATEING ORGANIZATION*/
		
		//Step 1
		HomePage hp = new HomePage(driver); 
		hp.getOrganizationsLink().click();
		
		//Step 2
		OrganizationsPage op = new OrganizationsPage(driver); 
		op.getCreateOrganizationbtn().click();
		
		//Step 3
		CreatingNewOrganization cno = new CreatingNewOrganization(driver);		
		cno.getOrganizationNametxtfld().sendKeys(actualOrganizationName);
		cno.getShippingAddress().sendKeys(address);
		cno.getSavebtn().click();
		
	
		/*HEADER VERIFICATION*/
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String headerInfo = oip.getHeaderInfo().getText();
		if(headerInfo.contains(actualOrganizationName)) {
		
		
		System.out.println(actualOrganizationName + "sucessfully created" );
		
		
		System.out.println("===============TEST1 PASS=========================" );
		
	}else {
		System.out.println("===============TEST1 FAIL=========================" );
		
	}
		/*ORGANIZATION NAME VERIFICATION*/
		String OrganizationName =oip.getOrganizationName().getText();
		System.out.println(OrganizationName);
		
		if(OrganizationName.equals(actualOrganizationName)) {
			
			
			System.out.println("===============TEST2 PASS=========================" );
			
		}else {
			System.out.println("===============TEST2 FAIL=========================" );
			
		}
		
		WebElement logoutImg= hp.getLogoutImg();
		wlib.moveToElement(driver, logoutImg);
		hp.getSignOutLink().click();
		
		driver.quit();
    }
    
    
    
    
    
    
    
		@Test
		public void createOrganizationWithPhoneNumberTest() throws Exception {
			
			/* PARAMETERS */
			WebDriver driver = null;
			String BROWSER = fLib.getDataFromProperyFile("browser");
			String URL = fLib.getDataFromProperyFile("url");
			String USERNAME = fLib.getDataFromProperyFile("username");
			String PASSWORD = fLib.getDataFromProperyFile("password");
			int randomNum=javaLib.getRandomNumber();
			String actualOrganizationName=eLib.getDataFromExcel("org", 1,1)+randomNum ;
			String address=eLib.getDataFromExcel("org", 1,2)+randomNum ;
			String PhoneNo=eLib.getDataFromExcel("org", 1,5);
			
			/* OPEN BROWSER*/
			driver= wlib.openWebBrowser(driver,BROWSER);
			
			wlib.waitForPageToLoad(driver);
			driver.manage().window().maximize();
			
			/*ENTER URL*/
			
			driver.get(URL);
			
			/*LOGIN TO APPLICATION*/
			LoginPage lp=new LoginPage(driver);
			
			lp.getUsrEditField().sendKeys(USERNAME);
			lp.getPswdEditField().sendKeys(PASSWORD);
			lp.getSubmitBtn().click();
			
			/*CRATEING ORGANIZATION WITH PHONE NUMBER*/
			
			HomePage hp = new HomePage(driver); 
			hp.getOrganizationsLink().click();
			
			
			OrganizationsPage op = new OrganizationsPage(driver); 
			op.getCreateOrganizationbtn().click();
			
			
			CreatingNewOrganization cno = new CreatingNewOrganization(driver);		
			cno.getOrganizationNametxtfld().sendKeys(actualOrganizationName);
			cno.getShippingAddress().sendKeys(address);
			cno.getPhoneNo().sendKeys(PhoneNo);
			
			cno.getSavebtn().click();
			
		
			/*PHONE-NUMBER VERIFICATION*/
			OrganizationInformationPage oip = new OrganizationInformationPage(driver);
			String ActPhoneNo = oip.getPhone().getText();
			
			
			if(ActPhoneNo.trim().equals(PhoneNo)) {
				
				
				System.out.println("===============TEST3 PASS=========================" );
				
				
			}else {
				System.out.println("===============TEST3 FAIL=========================" );
				
			}
		
			WebElement logoutImg= hp.getLogoutImg();
			wlib.moveToElement(driver, logoutImg);
			hp.getSignOutLink().click();
			
			driver.quit();
		}
		}
		
		

	

