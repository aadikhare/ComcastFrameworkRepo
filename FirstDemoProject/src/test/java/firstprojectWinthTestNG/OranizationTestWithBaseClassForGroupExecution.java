package firstprojectWinthTestNG;



import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.HomePage;

import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


public class OranizationTestWithBaseClassForGroupExecution extends BaseClass {
	
	
    @Test(groups= {"smokeTest"})
	public void createOranizationTest() throws Exception {
    
    	String actualOrganizationName=eLib.getDataFromExcel("org", 1,1)+randomNum ;
    	String address=eLib.getDataFromExcel("org", 1,2)+randomNum ;
    	
		
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
		Assert.assertTrue(headerInfo.contains(actualOrganizationName));
		
		/*ORGANIZATION NAME VERIFICATION*/
		String OrganizationName =oip.getOrganizationName().getText();
		System.out.println(OrganizationName);
		Assert.assertEquals(OrganizationName.trim(), actualOrganizationName);
		
		
		
		
		
    }
    
    
    
   
    
    
    
		@Test(groups= {"regression"})
		public void createOrganizationWithPhoneNumberTest() throws Exception {
			
			/* PARAMETERS */
			
			String actualOrganizationName=eLib.getDataFromExcel("org", 1,1)+randomNum+randomNum ;
			String address=eLib.getDataFromExcel("org", 1,2)+randomNum + randomNum ;
			String PhoneNo=eLib.getDataFromExcel("org", 1,5);
			
		
			
		
			
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
			
			SoftAssert verify = new SoftAssert();
			
			verify.assertEquals(ActPhoneNo.trim(), PhoneNo);
				verify.assertAll();
			Reporter.log("==============TEST CASE 1 COMPLEATED=============");	
		}
	
}
		
		

	

