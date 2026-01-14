package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement OrganizationName;
	
	@FindBy(id="mouseArea_Phone")
	private WebElement Phone;
	
	
	
	public WebElement getHeaderInfo() {
		return headerInfo;
	}


	public WebElement getOrganizationName() {
		return OrganizationName;
	}


	public WebElement getPhone() {
		return Phone;
	}
	

}
