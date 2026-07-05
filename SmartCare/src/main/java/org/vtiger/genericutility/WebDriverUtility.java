package org.vtiger.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	/**
	 * This method will switch from one window to another window
	 * @param driver
	 * @param partialTitle
	 */
	
	public void toSwitchToWindow(WebDriver driver, String partialTitle)
	{
		Set<String> allsessionid = driver.getWindowHandles();
		for (String string : allsessionid) {
			driver.switchTo().window(string);
			if(driver.getTitle().contains(partialTitle))
			{
				break;
			}
			
		}
	}
	/**
	 * This method will maximize the respective window (Chrome, firefox etc)
	 * @param driver
	 */
	public void  toMaximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This is a global wait method  
	 * @param driver
	 */
	public void toImplicitlyWait(WebDriver driver, int time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	/**
	 * This method scroll to a particular element
	 * @param driver
	 * @param element
	 */
	
	public void toScrollToElement(WebDriver driver, WebElement element)
	{
		Actions ac = new Actions(driver);
		
		ac.scrollToElement(element).perform();
	}
	
	/**
	 * This method will always scroll from top and measures from (0, 0) co-orinates 
	 * @param driver
	 * @param x
	 * @param y
	 */
	
	public 
	void toScrollByAmount(WebDriver driver, int x, int y)
	{
		Actions ac = new Actions(driver);
		
		ac.scrollByAmount(x, y).perform();
	}
	
	/**
	 * This method will provide a way to scroll to a particular element
	 * @param driver
	 * @param element
	 */
	
	public void toMoveToElement(WebDriver driver, WebElement element)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		
	}
	
	/**
	 * This method will move the mouse pointer by a specified number of pixel
	 * @param driver
	 * @param x
	 * @param y
	 */
	
	public void toMoveByOffset(WebDriver driver, int x, int y)
	{
		Actions ac = new Actions(driver);
		ac.moveByOffset(x, y);
	
	}
	
	/**
	 * This method will select a value from the drop down list  
	 * @param element
	 * @param index
	 */
	public void toSelectByIndex(WebElement element, int index)
	{
	   Select sc = new Select(element);
	   sc.selectByIndex(index);
	}
	/**
	 * This method will select all options that have a value matching the argument. That is, when given "foo" this would select an option like:
       <option value="foo">Bar</option>
	 * @param element
	 * @param value
	 */
	public void toSelectByValue(WebElement element, String value)
	{
		Select sc = new Select(element);
		sc.selectByValue(value);
	}
	/**
	 * This method will select all options that display text matching the argument. That is, when given "Bar" this would select an option like:
       <option value="foo">Bar</option>
	 * @param element
	 * @param visibletext
	 */
	public void toselectByVisibleText(WebElement element,String visibletext)
	{
		Select sc = new Select(element);
		sc.selectByVisibleText(visibletext);
	}
	/**
	 * This method will wait until the element is loaded and can be clicked(An expectation for checking an element is visible and enabled such that you can click it.)
	 * @param driver
	 * @param element
	 */
	public void toWiatUntilElementIsClickable(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
   /**
    * This method will accept the java script pop up alert. The return type of this method is void.
    * @param driver
    */
   public void toAcceptJSPopupAlert(WebDriver driver)
   {
  	 Alert jspopupaccept = driver.switchTo().alert();
  	 jspopupaccept.accept();
   }
	
   
   public void  toTakesScreenshot(WebDriver driver) throws IOException
   {
//	   type caste the WebDriver reference (driver) in to TakesScreenshot reference
	   
	   TakesScreenshot ts = (TakesScreenshot) driver;
	   
//	   Call getScreenShotAs() and pass FILE type and store it in Temp file.
	   File temp = ts.getScreenshotAs(OutputType.FILE);
	   
		//Capture System time
		String time = LocalDateTime.now().toString().replace(":", "_");
	   
//	   create a destination file folder
	   File dest = new File("./ScreenShotsVtiger/img"+time+".png");
	   
//	   Copy the temp file to destination
	    FileHandler.copy(temp, dest);
   }
	
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
