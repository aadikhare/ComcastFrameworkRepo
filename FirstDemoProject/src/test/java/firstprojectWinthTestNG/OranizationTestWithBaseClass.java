package firstprojectWinthTestNG;



import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.HomePage;

import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;


public class OranizationTestWithBaseClass extends BaseClass {
	
	
    @Test
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
		
		
		
    }
    
    
    
    
    
    
    
		@Test
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
			
			
			if(ActPhoneNo.trim().equals(PhoneNo)) {
				
				
				System.out.println("===============TEST3 PASS=========================" );
				
				
			}else {
				System.out.println("===============TEST3 FAIL=========================" );
				
			}
		
			
		}
		}
		
		

	

