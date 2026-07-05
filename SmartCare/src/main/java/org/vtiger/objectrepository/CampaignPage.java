package org.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	@FindBy(xpath = "//table[@class='hdrTabBg']/descendant::td[@onmouseover=\"fnvshobjMore(this,'allMenu','');\"]")
	private WebElement MoreOptions;

	@FindBy(xpath = "//a[@name='Campaigns']")
	private WebElement CampaignButton;
	
	@FindBy(xpath = "//td[@class='moduleName']/child::a[text()='Campaigns']")
	private WebElement CampaignPage;
	
	@FindBy(xpath = "//span[@id='dtlview_Campaign Name']")
	private WebElement CampaignNameView;
	
	@FindBy(xpath = "//input[@id='selectCurrentPageRec']")
	private WebElement SelectAllCheckboxButton;
	
	@FindBy(xpath = "//table[@class='small']/descendant::input[@value='Delete']")
	private WebElement DeleteButton;
	
	@FindBy(xpath = "//span[normalize-space(text())='No Campaign Found !']")
	private WebElement NoCampaignMessage;
	
//	initializations
	public CampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
//	Getters
	public WebElement getMoreOptions() {
		return MoreOptions;
	}

	public WebElement getCampaignButton() {
		return CampaignButton;
	}

	public WebElement getCampaignPage() {
		return CampaignPage;
	}


	public WebElement getCampaignNameView() {
		return CampaignNameView;
	}


	public WebElement getSelectAllCheckboxButton() {
		return SelectAllCheckboxButton;
	}


	public WebElement getDeleteButton() {
		return DeleteButton;
	}


	public WebElement getNoCampaignMessage() {
		return NoCampaignMessage;
	}
	
		
	
}
