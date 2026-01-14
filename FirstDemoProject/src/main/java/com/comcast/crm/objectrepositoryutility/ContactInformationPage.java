package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	
	WebDriver driver;
	public ContactInformationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerInfo;
	
	@FindBy(id="dtlview_Organization Name")
	private WebElement ContactName;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement SupportStartDateDisplayed;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement SupportEndDateDisplayed;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement OrganizationNameDisplayed ;
	
	public WebElement getSupportStartDateDisplayed() {
		return SupportStartDateDisplayed;
	}


	public WebElement getSupportEndDateDisplayed() {
		return SupportEndDateDisplayed;
	}


	public WebElement getHeaderInfo() {
		return headerInfo;
	}


	public WebElement getOrganizationNameDisplayed() {
		return OrganizationNameDisplayed;
	}


	

}
