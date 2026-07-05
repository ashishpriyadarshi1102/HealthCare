package org.vtiger.businessutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import org.vtiger.genericutility.FileUtility;
import org.vtiger.genericutility.JavaUtility;
import org.vtiger.genericutility.WebDriverUtility;
import org.vtiger.objectrepository.CampaignPage;
import org.vtiger.objectrepository.CreateCampaign;
import org.vtiger.objectrepository.HomePage;
import org.vtiger.objectrepository.LoginPageVtiger;

public class BaseClass {
	
public WebDriver driver;

public static WebDriver sdriver;
	
 //	Create Object for utility classes

		public FileUtility futil = new FileUtility();
		public	WebDriverUtility webUtil = new WebDriverUtility();
		public	JavaUtility jutil = new JavaUtility();
	
//	Create Object of POM classes
	    public LoginPageVtiger loginpage;
	    public HomePage homepage;
	    public CampaignPage campaignpage;
	    public CreateCampaign createcampaignpage;
	    
	    
//	 @Parameters("browser")   
	@BeforeClass	
	public void beforeClass() throws IOException
	{
		
				
		String BROWSER = futil.readDataFromPropertiesFile("browser");
		
		
		
	    if (BROWSER.equalsIgnoreCase("Chrome")) {
	    	driver = new ChromeDriver();
			
		}else if (BROWSER.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
			
		}else if (BROWSER.equalsIgnoreCase("FireFox")) {
			
			driver = new FirefoxDriver();
			
		}
		else {
			//Enter valid browser
			Reporter.log("Enter valid browser");
		}
				
		sdriver = driver;
		String URL = futil.readDataFromPropertiesFile("url");
	
//		Maximize the Browser
		webUtil.toMaximizeWindow(driver);
		
//		implicitly wait
		webUtil.toImplicitlyWait(driver, 10);
		
//		Navigate to URL
		driver.get(URL);
	}
	
	@AfterClass
	public void afterClass()
	{
//		Close browser
		driver.quit();
		
	}	
	
	
	@BeforeMethod
	public void beforeMethod() throws IOException	{
		String USERNAME = futil.readDataFromPropertiesFile("username");
		String PASSWORD = futil.readDataFromPropertiesFile("password");
		
//		login
		loginpage = new LoginPageVtiger(driver);
		loginpage.getUserNameTextfield().sendKeys(USERNAME);
		loginpage.getPasswordTestField().sendKeys(PASSWORD);
		loginpage.getPasswordButton().click();
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
//		logout
		homepage = new HomePage(driver);
        WebElement AdministratorIcon = homepage.getAdministrationtIcon();
        webUtil.toMoveToElement(driver, AdministratorIcon);
        homepage.getLogOutButton().click();
		
	}		

	@BeforeTest
    public void beforeTest()
    {
    	Reporter.log("Reports initialized- beforeTest", true);
	}
    @AfterTest
    public void afterTest()
    {
    	Reporter.log("Report backup - afterTest", true);
    }
    @BeforeSuite
    public void beforeSuit()
    {
    	Reporter.log("Database connectivity established - beforeSuit", true);
    }
    @AfterSuite
    public void afterSuit()
    {
    	Reporter.log("Database connectivity established - afterSuit", true);
    }

}
