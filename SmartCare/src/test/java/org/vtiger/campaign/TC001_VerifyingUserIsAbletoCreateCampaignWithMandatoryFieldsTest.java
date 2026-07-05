package org.vtiger.campaign;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import org.vtiger.businessutility.BaseClass;
import org.vtiger.genericutility.FileUtility;
import org.vtiger.genericutility.JavaUtility;
import org.vtiger.genericutility.WebDriverUtility;
import org.vtiger.objectrepository.CampaignPage;
import org.vtiger.objectrepository.CreateCampaign;
import org.vtiger.objectrepository.HomePage;
import org.vtiger.objectrepository.LoginPage;
import org.vtiger.objectrepository.LoginPageVtiger;

public class TC001_VerifyingUserIsAbletoCreateCampaignWithMandatoryFieldsTest {
	
	@Test
	public void tC001_VerifyingUserIsAbletoCreateCampaignWithMandatoryFields() throws IOException, InterruptedException
	{
		
		
//		Create Object for utility classes
		FileUtility futil = new FileUtility();
		WebDriverUtility webUtil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();	
				
//		Create Data
		String URL = futil.readDataFromPropertiesFile("url");
		String USERNAME = futil.readDataFromPropertiesFile("username");
		String PASSWORD = futil.readDataFromPropertiesFile("password");
		
		
		
		String CAMPAIGNNAME = futil.readDatafromExcelFile("Sheet1",1,0)+jutil.randomNumber();
		String EXPECTEDCLOSINGDATE = futil.readDatafromExcelFile("Sheet1", 1, 9);
		
//		Create object for ChromeDriver class
		WebDriver driver = new ChromeDriver();
		
//		Maximize the Browser
		webUtil.toMaximizeWindow(driver);
		
//		implicitly wait
		webUtil.toImplicitlyWait(driver, 10);
		
//		Navigate to URL
		driver.get(URL);
		
//		Create Object of POM classes
		LoginPageVtiger loginpage = new LoginPageVtiger(driver);
		HomePage homepage = new HomePage(driver);
		CampaignPage campaignpage = new CampaignPage(driver);
		CreateCampaign createcampaignpage = new CreateCampaign(driver);
		
//		Login page test steps
		
		loginpage.getUserNameTextfield().sendKeys(USERNAME);
		loginpage.getPasswordTestField().sendKeys(PASSWORD);
		loginpage.getPasswordButton().click();
		
		
//	    Home page test steps
		
		WebElement moreoptionselement = homepage.getMoreTab();
		webUtil.toMoveToElement(driver, moreoptionselement);
		homepage.getCampaigns().click();
		
//		Create CampaignButton text steps
		
		createcampaignpage.getCreateCampaignButton().click();

		createcampaignpage.getCampaignNameTextBox().sendKeys(CAMPAIGNNAME);
		createcampaignpage.getAssignToRadioButton().click();
		createcampaignpage.getClosingEndDate().sendKeys(EXPECTEDCLOSINGDATE);
		createcampaignpage.getSaveButtonTop().click();
		
//		Verify
        String ExpectedResult = CAMPAIGNNAME;
        String ActualResult = campaignpage.getCampaignNameView().getText();
        
        Reporter.log(ExpectedResult, true);
        Reporter.log(ActualResult, true);
        
        
        Assert.assertEquals(ActualResult, ExpectedResult);
        
        WebElement AdministratorIcon = homepage.getAdministrationtIcon();
        webUtil.toMoveToElement(driver, AdministratorIcon);
        homepage.getLogOutButton().click();
        
        driver.quit();		
	}

}
