package org.vtiger.campaign;

import java.io.IOException;

import org.openqa.selenium.WebElement;
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

public class TC006_VerifyingUserIsAbletoDeleteCampaignWithMandatoryFieldsTest extends BaseClass {
	
	@Test
	public void tC001_VerifyingUserIsAbletoDeleteCampaignWithMandatoryFields() throws IOException, InterruptedException 
	{		
		
//		Create Data
		String URL = futil.readDataFromPropertiesFile("url");		
		String CAMPAIGNNAME = futil.readDatafromExcelFile("Sheet1", 1, 0)+jutil.randomNumber();
		String EXPECTEDCLOSINGDATE = futil.readDatafromExcelFile("Sheet1", 1, 9);
		
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
        
//      To Delete the created Campaign from the campaigns list page
        
//      Step1: To go to campaign list page
		homepage = new HomePage(driver);
		WebElement moreoptions = homepage.getMoreTab();
		webUtil.toMoveToElement(driver, moreoptions);
		homepage.getCampaigns().click();
		
//		Step2: To check the check-box and click on delete button
		campaignpage.getSelectAllCheckboxButton().click();
		Thread.sleep(5000);
		campaignpage.getDeleteButton().click();
		Thread.sleep(5000);
		webUtil.toAcceptJSPopupAlert(driver);
		
//		Step3: To check the 'No Campaign Found' message
		String expectedConfirmation = "No Campaign Found !";
		String ActualConfirmation = campaignpage.getNoCampaignMessage().getText();
		Reporter.log(ActualConfirmation, true);
		Assert.assertEquals(ActualConfirmation, expectedConfirmation);
        

}
}
