package org.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageVtiger {
	
	
	
	@FindBy(xpath = "//input[@name='user_name']")
	private WebElement UserNameTextfield;
	
	@FindBy(xpath = "//input[@name='user_password']")
	private WebElement PasswordTestField;
	
	@FindBy(xpath = "//input[@id='submitButton']")
	private WebElement PasswordButton;
	
//	Initializations
	public LoginPageVtiger(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
//	getters
	public WebElement getUserNameTextfield() {
		return UserNameTextfield;
	}

	public WebElement getPasswordTestField() {
		return PasswordTestField;
	}

	public WebElement getPasswordButton() {
		return PasswordButton;
	}
	

	

}
