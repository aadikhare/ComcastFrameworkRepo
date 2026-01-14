package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}

	
		@FindBy(name="user_name")
		private WebElement UsrEditField;
		
		@FindBy(name="user_password")
		private WebElement pswdEditField;
		
		@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@value='Login' and @type='submit']")})
		private WebElement submitBtn;

		public WebElement getUsrEditField() {
			return UsrEditField;
		}

		public WebElement getPswdEditField() {
			return pswdEditField;
		}
		
		public WebElement getSubmitBtn() {
			return submitBtn;
		}
		
	}


