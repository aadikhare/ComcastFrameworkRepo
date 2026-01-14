package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectOrganizations {

	WebDriver driver;
	public SelectOrganizations(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="search_txt")
	private WebElement OrgSearchtxt;
	
	
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement SearchBtn;
	
	public WebElement getSearchBtn() {
		return SearchBtn;
	}

	public WebElement getOrgSearchtxt() {
		return OrgSearchtxt;
	}
	

}
