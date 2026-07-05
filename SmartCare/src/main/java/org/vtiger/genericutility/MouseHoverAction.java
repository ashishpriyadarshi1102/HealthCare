package org.vtiger.genericutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseHoverAction {

	
	public void toMoveToElement(WebDriver driver, WebElement element)
	{
		Actions ac = new Actions(driver);
		ac.moveToElement(element).perform();
		
	}
	
	
	
	
	public MouseHoverAction() {
		
	}
	
	
}
