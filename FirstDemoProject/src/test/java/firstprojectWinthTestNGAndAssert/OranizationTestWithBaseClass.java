package firstprojectWinthTestNGAndAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganization;
import com.comcast.crm.objectrepositoryutility.HomePage;

import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class OranizationTestWithBaseClass extends BaseClass {

	@Test // TC-1
	public void createOranizationTest() throws Exception {

		String actualOrganizationName = eLib.getDataFromExcel("org", 1, 1) + randomNum + "abc";
		String address = eLib.getDataFromExcel("org", 1, 2) + randomNum + "abc";

		/* CRATEING ORGANIZATION */

		// Step 1
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		// Step 2
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrganizationbtn().click();

		// Step 3
		CreatingNewOrganization cno = new CreatingNewOrganization(driver);
		cno.getOrganizationNametxtfld().sendKeys(actualOrganizationName);
		cno.getShippingAddress().sendKeys(address);
		cno.getSavebtn().click();

		/* HEADER VERIFICATION */
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String headerInfo = oip.getHeaderInfo().getText();
		SoftAssert verify=new SoftAssert();
		
		verify.assertTrue(headerInfo.contains(actualOrganizationName));

					/* ORGANIZATION NAME VERIFICATION */
		String OrganizationName = oip.getOrganizationName().getText();
		

		verify.assertTrue(OrganizationName.equals(actualOrganizationName)); 

	}

	@Test // TC-2
	public void createOrganizationWithPhoneNumberTest() throws Exception {

		/* PARAMETERS */

		String actualOrganizationName = eLib.getDataFromExcel("org", 1, 1) + randomNum + randomNum;
		String address = eLib.getDataFromExcel("org", 1, 2) + randomNum + randomNum;
		String PhoneNo = eLib.getDataFromExcel("org", 1, 5);

		/* CRATEING ORGANIZATION WITH PHONE NUMBER */

		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrganizationbtn().click();

		CreatingNewOrganization cno = new CreatingNewOrganization(driver);
		cno.getOrganizationNametxtfld().sendKeys(actualOrganizationName);
		cno.getShippingAddress().sendKeys(address);
		cno.getPhoneNo().sendKeys(PhoneNo);

		cno.getSavebtn().click();

		/* PHONE-NUMBER VERIFICATION */
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String ActPhoneNo = oip.getPhone().getText();
		
		SoftAssert verify=new SoftAssert();
		verify.assertTrue(ActPhoneNo.trim().equals(PhoneNo));
	}

	@Test //TC-3
	public void createOranizationWithIndustryAndType() throws Exception {

		/* PARAMETERS */

		String ActualOrganizationName = eLib.getDataFromExcel("org", 1, 1) + randomNum + randomNum + randomNum;
		String address = eLib.getDataFromExcel("org", 1, 2) + randomNum + randomNum + randomNum;

		/* CRATEING ORGANIZATION WITH INDUSTORY AND TYPE */

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

		// Step4

		WebElement industoryDD = cno.getIndustoryDD();
		String ActIndustory = eLib.getDataFromExcel("org", 1, 3);
		wlib.selectOptions(industoryDD, ActIndustory);

		WebElement typeDD = cno.getTypeDD();
		String Actualtype = eLib.getDataFromExcel("org", 1, 4);
		wlib.selectOptions(typeDD, Actualtype);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		/* INDUSTORY VERIFICATION */
		String industoryDisplayed = driver.findElement(By.id("mouseArea_Industry")).getText();

		SoftAssert verify = new SoftAssert();

		verify.assertEquals(industoryDisplayed, ActIndustory);

		/* TYPE VERIFICATION */

		String typeDisplayed = driver.findElement(By.id("mouseArea_Type")).getText();

		verify.assertEquals(typeDisplayed, Actualtype);
		verify.assertAll();

		Reporter.log("================testcase pass=================", true);

	}

	@Test //TC-4

	public void DeleteDynamicDataTest() throws Exception {

		// actualOrganizationName= null;

		String actualOrganizationName = eLib.getDataFromExcel("org", 1, 1) + randomNum + randomNum + randomNum
				+ randomNum + randomNum;

		String address = eLib.getDataFromExcel("org", 1, 2) + randomNum + randomNum + randomNum + randomNum + randomNum;

		/* CRATEING ORGANIZATION */

		// Step 1
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();

		// Step 2
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateOrganizationbtn().click();

		// Step 3
		CreatingNewOrganization cno = new CreatingNewOrganization(driver);
		cno.getOrganizationNametxtfld().sendKeys(actualOrganizationName);
		cno.getShippingAddress().sendKeys(address);
		cno.getSavebtn().click();

		// step 4
		Thread.sleep(2000);
		hp.getOrganizationsLink().click();
		Thread.sleep(2000);

		op.getSearchOrgName().sendKeys(actualOrganizationName);
		WebElement searchUsing = op.getSearchUsing();
		wlib.selectOptions(searchUsing, "Organization Name");
		op.getSearchbtn().click();

		WebElement webElementToDelete = driver.findElement(
				By.xpath("(//a[text()='" + actualOrganizationName + "']/ancestor::tr/td)/a[text()='del']"));

		webElementToDelete.click();

		wlib.switchToAlert(driver);
		System.out.println(actualOrganizationName + "Deleted");
		String noOrgFound = driver.findElement(By.xpath("//span[contains(text(),'No Organization Found !')]"))
				.getText();
		SoftAssert verify = new SoftAssert();
		verify.assertTrue(noOrgFound.contains("No Organization Found !"));
		verify.assertAll();
//
		
	}

}
