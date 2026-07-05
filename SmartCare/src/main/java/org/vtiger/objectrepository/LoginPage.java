package org.vtiger.objectrepository;

import java.security.PrivateKey;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
//	Declaration -- 
	@FindBy (xpath = "//input[@id='Email']")
	private WebElement EmailTextField;
	
    @FindBy (xpath = "//input[@id='Password']")
    private WebElement PasswordTextField;
    
    @FindBy (xpath = "//input[@class='button-1 login-button']")
    private WebElement LoginButton;
    
//    initialization
    public LoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
//    getters
    public WebElement getEmailTextField()
    {
    	return EmailTextField;
    }
    public WebElement getPasswordTextField()
    {
    	return PasswordTextField;
    }
    public WebElement getLogInButton()
    {
    	return LoginButton;
    }
    

}
