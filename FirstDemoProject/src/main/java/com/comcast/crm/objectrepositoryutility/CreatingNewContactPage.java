package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {

	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement CreateContactBtn;

@FindBy(name="lastname")
private WebElement Lastname;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement SaveBtn;

@FindBy(id="jscal_field_support_start_date")
private WebElement supportStartDate;

@FindBy(id="jscal_field_support_end_date")
private WebElement supportEndDate;

@FindBy(xpath="//input[@name='account_name']/ancestor::td[@class='dvtCellInfo']/descendant::img")
private WebElement SelectOrg;
public WebElement getCreateContactBtn() {
	return CreateContactBtn;
}


public WebElement getLastname() {
	return Lastname;
}


public WebElement getSelectOrg() {
	return SelectOrg;
}


public WebElement getSupportStartDate() {
	return supportStartDate;
}


public WebElement getSupportEndDate() {
	return supportEndDate;
}


public WebElement getSaveBtn() {
	return SaveBtn;
}




}
	


