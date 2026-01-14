package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganization {

	WebDriver driver;
	public CreatingNewOrganization(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
@FindBy(name="accountname")
private WebElement OrganizationNametxtfld;


@FindBy(name="ship_street")
private WebElement ShippingAddress;

@FindBy(id="phone")
private WebElement PhoneNo;

@FindBy(name="industry")
private WebElement IndustoryDD;

@FindBy(name="accounttype")
private WebElement TypeDD;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement Savebtn;

public WebElement getOrganizationNametxtfld() {
	return OrganizationNametxtfld;
}

public WebElement getShippingAddress() {
	return ShippingAddress;
}



public WebElement getPhoneNo() {
	return PhoneNo;
}



public WebElement getIndustoryDD() {
	return IndustoryDD;
}

public WebElement getTypeDD() {
	return TypeDD;
}

public WebElement getSavebtn() {
	return Savebtn;
}


}
	


