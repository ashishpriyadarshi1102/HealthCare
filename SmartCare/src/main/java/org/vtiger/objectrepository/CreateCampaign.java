package org.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaign {
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement CreateCampaignButton;
	
	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement CampaignNameTextBox;
	
	@FindBy(xpath = "//input[@value='U']")
	private WebElement AssignToRadioButton;
	
	@FindBy(xpath = "//input[@id='jscal_field_closingdate']")
	private WebElement ClosingEndDate;
	
	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveButtonTop;
	
//	Initialization
	public CreateCampaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

//	Getters
	public WebElement getCreateCampaignButton() {
		return CreateCampaignButton;
	}

	public WebElement getCampaignNameTextBox() {
		return CampaignNameTextBox;
	}

	public WebElement getAssignToRadioButton() {
		return AssignToRadioButton;
	}

	public WebElement getClosingEndDate() {
		return ClosingEndDate;
	}

	public WebElement getSaveButtonTop() {
		return SaveButtonTop;
	}
	
	

}
