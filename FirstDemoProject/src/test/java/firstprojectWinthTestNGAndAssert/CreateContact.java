package firstprojectWinthTestNGAndAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;
import com.comcast.crm.objectrepositoryutility.SelectOrganizations;

public class CreateContact extends BaseClass {
	
	@Test //TC-5

	public  void createContact() throws Exception {


		int randomNum=javaLib.getRandomNumber();
		String contactName=eLib.getDataFromExcel("contact", 1,0)+randomNum ;
		
		
		//====*CREATE contact*====//
		
		/*CREATE CONTACT*/
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		CreatingNewContactPage cc = new CreatingNewContactPage(driver);
		
		
		cc.getCreateContactBtn().click();
		cc.getLastname().sendKeys(contactName);
		cc.getSaveBtn().click();
		
		ContactInformationPage cip = new ContactInformationPage(driver);
		String contactNameDisplayed=cip.getHeaderInfo().getText();
		
		Assert.assertTrue(contactNameDisplayed.contains(contactName));
			
		
	}
	
	@Test //TC-6
public void createContactWithTime() throws Exception {
		
       
		
		
		int randomNum=javaLib.getRandomNumber();
		String contactName=eLib.getDataFromExcel("contact", 1,0)+randomNum ;
		String supportStartDate=javaLib.getSystemDate();
		String supportEndDate=javaLib.getrequiredDate(31);
		
		
		//====*CREATE CONTACT WITH SUPPORT DATES*====//
		
		
		
		
		/* CREATE CONTACT*/
		
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		
		CreatingNewContactPage cc = new CreatingNewContactPage(driver);
		cc.getCreateContactBtn().click();
		cc.getLastname().sendKeys(contactName);
		
		
		cc.getSupportStartDate().clear();
		cc.getSupportStartDate().sendKeys(supportStartDate);
		cc.getSupportEndDate().clear();
		cc.getSupportEndDate().sendKeys(supportEndDate);
		
		System.out.println(supportStartDate);
		System.out.println(supportEndDate);
		cc.getSaveBtn().click();
		
		ContactInformationPage cip = new ContactInformationPage(driver);
		String supportstartDateDisplayed= cip.getSupportStartDateDisplayed().getText();
		String supportEndDateDisplayed = cip.getSupportEndDateDisplayed().getText();
		
		SoftAssert verify = new SoftAssert();
		verify.assertEquals(supportStartDate, supportstartDateDisplayed);
		verify.assertEquals(supportEndDateDisplayed, supportEndDate);
		verify.assertAll();
			
	}	
	
	@Test //TC-7
	public void createContactWithOrganization() throws Exception {

		
				
				
				int randomNum=javaLib.getRandomNumber();
				String ActualOrganizationName = eLib.getDataFromExcel("org", 1, 1) + randomNum + "abc";
				String address = eLib.getDataFromExcel("org", 1, 2) + randomNum + "abc";
				String contactName=eLib.getDataFromExcel("contact", 1,0)+randomNum +"abc";
		
	
				/* CRATEING ORGANIZATION */

				// Step 1
				HomePage hp = new HomePage(driver);
				hp.getOrganizationsLink().click();

				// Step 2
				OrganizationsPage op = new OrganizationsPage(driver);
				op.getCreateOrganizationbtn().click();

				// Step 3
				CreatingNewOrganization cno = new CreatingNewOrganization(driver);
				cno.getOrganizationNametxtfld().sendKeys(ActualOrganizationName);
				cno.getShippingAddress().sendKeys(address);
				cno.getSavebtn().click();
				Thread.sleep(2000);
				
				hp.getContactLink().click();
				
				CreatingNewContactPage cc = new CreatingNewContactPage(driver);
				cc.getCreateContactBtn().click();
				cc.getLastname().sendKeys(contactName);
				
				cc.getSelectOrg().click();
				driver=wlib.moveControlToWindow(driver, "Accounts&action");
				SelectOrganizations so = new SelectOrganizations(driver);
				so.getOrgSearchtxt().sendKeys(ActualOrganizationName);
				so.getSearchBtn().click();
				driver.findElement(By.xpath("//a[text()='"+ActualOrganizationName+"']")).click();
				driver=wlib.moveControlToWindow(driver, "Contacts&action");
				
				
				cc.getSaveBtn().click();
				
				ContactInformationPage cip = new ContactInformationPage(driver);
				String organizationNameDisplayed=cip.getOrganizationNameDisplayed().getText();
				
				SoftAssert verify = new SoftAssert();
				verify.assertEquals(organizationNameDisplayed.trim(), ActualOrganizationName);
				verify.assertAll();

}

}