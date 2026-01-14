package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
@FindBy(xpath="//img[contains(@title,'Create Organization')]")
WebElement createOrganizationbtn;

@FindBy(xpath="//input[@name='search_text']")
WebElement searchOrgName;

@FindBy(id="bas_searchfield")
WebElement SearchUsing;

@FindBy(xpath="//input[@value=' Search Now ' and @name  ]")
WebElement Searchbtn;

@FindBy(xpath="(//input[@value='Delete'])[position()=1]")
WebElement DeleteBtn;

public WebElement getCreateOrganizationbtn() {
	return createOrganizationbtn;
	
	
	
}

public WebElement getSearchOrgName() {
	return searchOrgName;
}

public WebElement getSearchUsing() {
	return SearchUsing;
}

public WebElement getSearchbtn() {
	return Searchbtn;
}

public WebElement getDeleteBtn() {
	return DeleteBtn;
}


	}


