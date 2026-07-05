package org.vtiger.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{
	
	@FindBy(xpath = "//table[@class=\"hdrTabBg\"]/descendant::a[text()='Leads']")
	private WebElement LeadsTab;
	
	@FindBy(xpath = "//table[@class=\"hdrTabBg\"]/descendant::a[text()='Organizations']")
	private WebElement OrganizationTab;
	
	@FindBy(xpath = "//a[text()='Contacts']")
	private WebElement contactTab;
	
	@FindBy(xpath = "//table[@class=\"hdrTabBg\"]/descendant::a[text()='Opportunities']")
	private WebElement Opportunities;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement productsTab;
	
	@FindBy(xpath = "//a[text()='Dashboard']")
	private WebElement dashboardTab;
	
//	//table[@class='hdrTabBg']/descendant::td[@onmouseout="fnHide_Event('allMenu');"]
	@FindBy(xpath = "//table[@class='hdrTabBg']/descendant::td[@onmouseout=\"fnHide_Event('allMenu');\"]")
	private WebElement moreTab;
	
	@FindBy(xpath = "//a[@name='Campaigns']")
	private WebElement campaigns;
	
	@FindBy(xpath = "//a[@name='Invoice']")
	private WebElement invoices;
	
	@FindBy(xpath = "//a[@name='Sales Order']")
	private WebElement salesorder;
	
	@FindBy(xpath = "//a[name='Quotes']")
	private WebElement quotes;
	
	@FindBy(xpath = "//span[text()=' Administrator']")
	private WebElement administratorlabel;
	
	@FindBy(xpath = "//a[normalize-space(text())='Home']")
	private WebElement homepage;
	
	@FindBy(xpath = "//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")
	private WebElement AdministrationtIcon;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement LogOutButton;
	
//	initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
//	Getters
	public WebElement getLeadsTab() {
		return LeadsTab;
	}

	public WebElement getOrganizationTab() {
		return OrganizationTab;
	}

	public WebElement getContactTab() {
		return contactTab;
	}

	public WebElement getOpportunities() {
		return Opportunities;
	}

	public WebElement getProductsTab() {
		return productsTab;
	}

	public WebElement getDashboardTab() {
		return dashboardTab;
	}

	public WebElement getMoreTab() {
		return moreTab;
	}

	public WebElement getCampaigns() {
		return campaigns;
	}

	public WebElement getInvoices() {
		return invoices;
	}

	public WebElement getSalesorder() {
		return salesorder;
	}

	public WebElement getQuotes() {
		return quotes;
	}

	public WebElement getAdministratorlabel() {
		return administratorlabel;
	}

	public WebElement getHomepage() {
		return homepage;
		
	}

	public WebElement getAdministrationtIcon() {
		return AdministrationtIcon;
	}


	public WebElement getLogOutButton() {
		return LogOutButton;
	}
	
	

}
