package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
		
		WebDriver driver;
		public HomePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(xpath="//a[text()='Organizations']")
		private WebElement OrganizationsLink;
		
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement logoutImg;
		
		@FindBy(xpath="//a [@href='index.php?module=Contacts&action=index']")
		private WebElement ContactLink;
		
		@FindBy(partialLinkText="Sign Out")
		private WebElement SignOutLink;
		
		
		
		public WebElement getOrganizationsLink() {
			return OrganizationsLink;
		}
		

		public WebElement getContactLink() {
			return ContactLink;
		}


		public WebElement getLogoutImg() {
			return logoutImg;
		}
		
		public WebElement getSignOutLink() {
			return SignOutLink;
		}
		
	}


