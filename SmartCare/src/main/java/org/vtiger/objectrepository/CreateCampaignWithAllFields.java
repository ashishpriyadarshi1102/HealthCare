package org.vtiger.objectrepository;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateCampaignWithAllFields {
	
	@FindBy(xpath = "//table[@class='hdrTabBg']/descendant::td[@onmouseout=\"fnHide_Event('allMenu');\"]")
	private WebElement MoreAllOptions;
	
	@FindBy(xpath = "//a[@name='Campaigns']")
	private WebElement CampaignButton;
	
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement CreateCampaignButton;
	
	@FindBy(xpath = "//input[@name='campaignname']")
	private WebElement CampaignNameTextfield;
	
	@FindBy(xpath = "//input[@value='T']")
	private WebElement AssignedToGroup;
	
	@FindBy(xpath = "//input[@id='targetaudience']")
	private WebElement TargetAudienceTextField;
	
	@FindBy(xpath = "//input[@id='sponsor']")
	private WebElement SponsorTextField;
	
	@FindBy(xpath = "//input[@id='numsent']")
	private WebElement NumSentTextField;
	
	@FindBy(xpath = "//input[@id='jscal_field_closingdate']")
	private WebElement ExpectedClosingDate;
	
	@FindBy(xpath = "//input[@id='targetsize']")
	private WebElement TragetSizeTextField;
	
//	Expectations & Actuals Section WebElement 
	
	@FindBy(xpath = "//input[@name='budgetcost']")
	private WebElement BudgetCostTextField;
	
	@FindBy(xpath = "//input[@id='expectedsalescount']")
	private WebElement ExpectedSalesCountTextField;
	
	@FindBy(xpath = "//input[@id='expectedresponsecount']")
	private WebElement ExpectedResponseCountTextField;
	
	@FindBy(xpath = "//input[@name='expectedroi']")
	private WebElement ExpectedROITextField;
	
	@FindBy(xpath = "//input[@name='actualcost']")
	private WebElement ActualCostTextField;
	
	@FindBy(xpath = "//input[@name='expectedrevenue']")
	private WebElement ExpecetedRevenueTextField;
	
	@FindBy(xpath = "//input[@id='actualsalescount']")
	private WebElement ActualSalesCountTextField;
	
	@FindBy(xpath = "//input[@id='actualresponsecount']")
	private WebElement ActualResponseCountTextField;
	
	@FindBy(xpath = "//input[@name='actualroi']")
	private WebElement ActualROITextField;
	
//	Description Information section WebElement
	
	@FindBy(xpath = "//textarea[@class='detailedViewTextBox']")
	private WebElement DescriptionTextField;
	
	
	
	
	
	
	
	

}
