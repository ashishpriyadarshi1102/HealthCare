package org.vtiger.campaign;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
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

@Listeners (org.vtiger.genericutility.ListenerUtility.class)

public class TC001_Verifying2UserIsAbletoCreateCampaignWithMandatoryFieldsTest extends BaseClass{
	

	@Test
	public void tC001_VerifyingUserIsAbletoCreateCampaignWithMandatoryFields() throws IOException 
	{
		
					
//		Create Data
		String URL = futil.readDataFromPropertiesFile("url");

		
		
		
		String CAMPAIGNNAME = futil.readDatafromExcelFile("multipledatacampaign", 1, 0)+jutil.randomNumber();
		String EXPECTEDCLOSINGDATE = futil.readDatafromExcelFile("Sheet1", 1, 9);
		
//		Create object for ChromeDriver class
//		driver = new ChromeDriver();
//		
//		Maximize the Browser
//		webUtil.toMaximizeWindow(driver);
//		
//		implicitly wait
//		webUtil.toImplicitlyWait(driver, 10);
//		
//		Navigate to URL
//		driver.get(URL);
		
//		Create Object of POM classes
//		loginpage = new LoginPageVtiger(driver);
//		HomePage homepage = new HomePage(driver);
//		CampaignPage campaignpage = new CampaignPage(driver);
//		CreateCampaign createcampaignpage = new CreateCampaign(driver);
		
//		Login page test steps
		
//		loginpage.getUserNameTextfield().sendKeys(USERNAME);
//		loginpage.getPasswordTestField().sendKeys(PASSWORD);
//		loginpage.getPasswordButton().click();
		
		
//	    Home page test steps
		homepage = new HomePage(driver);
		WebElement moreoptionselement = homepage.getMoreTab();
		webUtil.toMoveToElement(driver, moreoptionselement);
		homepage.getCampaigns().click();
		
//		Create CampaignButton text steps
		campaignpage = new CampaignPage(driver);
		
		createcampaignpage = new CreateCampaign(driver);
		createcampaignpage.getCreateCampaignButton().click();

		
		createcampaignpage.getCampaignNameTextBox().sendKeys(CAMPAIGNNAME);
		createcampaignpage.getAssignToRadioButton().click();
		createcampaignpage.getClosingEndDate().sendKeys(EXPECTEDCLOSINGDATE);
		createcampaignpage.getSaveButtonTop().click();
		
//		Verify
        String ExpectedResult = CAMPAIGNNAME;
        String ActualResult = campaignpage.getCampaignNameView().getText();
        Assert.assertEquals(ActualResult, ExpectedResult);
        
//        WebElement AdministratorIcon = homepage.getAdministrationtIcon();
//        webUtil.toMoveToElement(driver, AdministratorIcon);
//        homepage.getLogOutButton().click();
        
//        driver.quit();		
        

        }
//    @BeforeTest
//    public void beforeTest()
//    {
//    	Reporter.log("Reports initialized- beforeTest", true);
//	}
//    @AfterTest
//    public void afterTest()
//    {
//    	Reporter.log("Report backup - afterTest", true);
//    }
//    @BeforeSuite
//    public void beforeSuit()
//    {
//    	Reporter.log("Database connectivity established - beforeSuit", true);
//    }
//    @AfterSuite
//    public void afterSuit()
//    {
//    	Reporter.log("Database connectivity established - afterSuit", true);
//    }
}



