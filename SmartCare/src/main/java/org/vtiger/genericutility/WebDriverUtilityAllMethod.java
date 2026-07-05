package org.vtiger.genericutility;


import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverUtilityAllMethod {
	
	/**
	 * This method will load the fully qualified URL
	 * @param driver
	 * @param url
	 */
	
    public void togetStringURL(WebDriver driver, String url)
    {
    	driver.get(url);
    }
    
/**
 * This method will return the title of
 * @param driver
 * @return
 */
    public String togetTitle(WebDriver driver)
    {
		 
		String titleofwebpage = driver.getTitle();  
		 return titleofwebpage;
		
		
		
    }
    
    /**
     * This method will fetch the URL upto current extension
     * @param driver
     */
     public void togetCurrentUrl(WebDriver driver)
     {
    	 driver.getCurrentUrl();
     }
     
     /**
      * The method will provide the complete HTML source code of the page
      * @param driver
      */
     
     public void togetPageSource(WebDriver driver)
     {
    	 driver.getPageSource();
     }
     
     /**
      * This method will only close the current window
      * @param driver
      */
     public void Toclose(WebDriver driver)
     {
    	 driver.close();
     }
     
     /**
      * This method will close all the opened window and even it will close the server connection too
      * @param driver
      */
     
     public void toquite(WebDriver driver)
     {
    	 driver.quit();
     }
     
     /**
      * This method will maximize the respective window
      * @param driver
      */
     public void toMaximizeWindow(WebDriver driver)
     {
    	 driver.manage().window().maximize();
     }
     
     /**
      * This method will minimize the respective window
      * @param driver
      */
     public void toMinimizeWindow(WebDriver driver)
     {
    	driver.manage().window().minimize(); 
     }
     /**
      * This method will full screen the respective window 
      * @param driver
      */
     public void toFullscreenWindow(WebDriver driver)
     {
    	 driver.manage().window().fullscreen();
     }
     
     /**
      * This method will get size of current window. This will return the outer window dimension, not just the view port
      * @param driver
      */
     public void toGetSize(WebDriver driver)
     {
    	 driver.manage().window().getSize();
     }
     
     /**
      * This method will get the position of the current window, relative to the upper left corner of the screen
      * @param driver
     * @return 
      */
     
     public Point toGetPosition(WebDriver driver)
     {
    	 Point position = driver.manage().window().getPosition();
    	 return position;
     }
     
     public void toSetSize(WebDriver driver,int x, int y )
     {
    	 
    	 
    	 
    	 Dimension dimension = new Dimension(x, y);
    	 driver.manage().window().setSize(dimension);
     }
     /**
      * This method will set the position of the current window. This is relative to the upper left corner of the screen, synonymous to window.moveTo() in JS.
      * @param driver
      * @param x
      * @param y
      */
     public void setPosition(WebDriver driver, int x, int y)
     {
    	 Point point = new Point(x, y);
    	 driver.manage().window().setPosition(point);
     }
     /**
      * This method will specifies the amount of time the driver should wait when searching for an element if it is not immediately present.
      * @param driver
      * @param seconds
      */
     public void toImplicitlyWait(WebDriver driver,int seconds)
     {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
     }
     /**
      * This method will take back the window to immediate back screen (Move back a single "item" in the browser's history)
      * @param driver
      */
     
     public void toBackWindow(WebDriver driver)
     {
    	 driver.navigate().back();
     }
     
     /**
      * This method will move a single "item" forward in the browser's history. Does nothing if we are on the latest page viewed.
      * @param driver
      */
     public void toForwardWindow(WebDriver driver)
     {
    	 driver.navigate().forward();
     }
     
     /**
      * This method will refresh the current page
      * @param driver
      */
     public void toRefreshWindow(WebDriver driver)
     {
    	 driver.navigate().refresh();
     }
     
     /**
      * This method will load a new web page in the current browser window. This is done using an HTTP POST operation, and the method will block until the load is complete.
      * @param driver
      * @param url
      */
     public void toNavigateTo(WebDriver driver, String url)
     {
    	 driver.navigate().to(url);
     }
     
     /**
      * 
      */
     public void toNavigateToNewURL(WebDriver driver)
     {
//    	driver.navigate().to(New); 
     }
     
     /**
      * This method will return a single session id of an open window
      * @param driver
      */
     public void toGetWindowHandle(WebDriver driver)
     {
    	 String sessionid = driver.getWindowHandle();
     }
     
     
     /**
      * This method will return all the session id of all the open window
      * @param driver
      */
     public void togetWindowHandles(WebDriver driver)
     {
    	 Set<String> allsessionids = driver.getWindowHandles();
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
     /**
      * This method will dismiss the java script pop up alert. The return type of this method is void.
      * @param driver
      */
     public void toDismissJSPopupAlert(WebDriver driver)
     {
    	 Alert jspopupdismiss = driver.switchTo().alert();
    	 jspopupdismiss.dismiss();
     }
     /**
      * This method will send a text in the confirmation java script pop up.The return type of this method is void. 
      * @param driver
      * @param name
      */
     public void toSendKeystoJSpopupAlert(WebDriver driver, String name)
     {
    	 Alert jsconfirmationpopup = driver.switchTo().alert();
    	 jsconfirmationpopup.sendKeys(name);
     }
     /**
      * This metod will returns the text of javascript pop up alert
      * @param driver
      * @return
      */
     public String toGetTextofJSPopupAlert(WebDriver driver)
     {
    	Alert jspopupalerttext = driver.switchTo().alert();
    	String textofjspopup = jspopupalerttext.getText();
    	return textofjspopup;
     }
     /**
      * This method will select a frame by its (zero-based) index. Selecting a frame by index is equivalent to the 
      * JS expression window.frames[index] where "window" is the DOM window represented by the current context. 
      * Once the frame has been selected, all subsequent calls on the WebDriver interface are made to that frame. 
      * @param driver
      * @param index
      */
     public void toSwitchToFrameByIndex(WebDriver driver, int index)
     {
    	 driver.switchTo().frame(index);
     }
     
     /**
      * This method will select a frame by its name or ID.Frames located by matching name attributes are always given 
      * precedence over those matched by ID.
      * @param driver
      * @param name
      */
     public void toSwitchToFrameByStringName(WebDriver driver, String name )
     {
    	 driver.switchTo().frame(name);
     }
     /**
      * This method will select a frame using its previously located WebElement.
      * @param driver
      * @param frameelement
      */
     public void toSwitchToFrameByWebElement(WebDriver driver, WebElement frameelement)
     {
    	 driver.switchTo().frame(frameelement);
     }
     
     /**
      * This method will transfer driver control to immediate parent frame.
      * @param driver
      */
     public void toSwitchToParentFrame(WebDriver driver)
     {
    	 driver.switchTo().parentFrame();
     }
     
     /**
      * This method will transfer the driver control to main frame or base page 
      * @param driver
      */
     public void toDefaultContext(WebDriver driver)
     {
    	 driver.switchTo().defaultContent();
     }
     
     public void toSwitchToWindow(WebDriver driver)
     {
    	 
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     

}
