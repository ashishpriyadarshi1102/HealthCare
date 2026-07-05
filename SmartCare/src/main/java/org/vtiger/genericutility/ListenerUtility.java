package org.vtiger.genericutility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.vtiger.businessutility.BaseClass;

public class ListenerUtility  implements ISuiteListener, ITestListener {
	ExtentReports reports;
	
	ExtentTest report;

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("OnTestSuccess", true);
		
		report.log(Status.PASS, "Test Case PASS: " + result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("OnTestFailure", true);
		
//		   type caste the WebDriver reference (driver) in to TakesScreenshot reference
		   
		   //TakesScreenshot ts = (TakesScreenshot) driver;
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		
//		To attach the screenshot to the report
	    String screenshot = ts.getScreenshotAs(OutputType.BASE64);
	    report.addScreenCaptureFromBase64String(screenshot, result.getName());
		   
//		   Call getScreenShotAs() and pass FILE type and store it in Temp file.
		   File temp = ts.getScreenshotAs(OutputType.FILE);
		   
			//Capture System time
			String time = LocalDateTime.now().toString().replace(":", "_");
		   
//		   create a destination file folder
		   File dest = new File("./ScreenShotsVtiger/img"+time+".png");
		   
//		   Copy the temp file to destination
		    try {
				FileHandler.copy(temp, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		    report.log(Status.FAIL, "Test Case FAIL: " + result.getName());
		    
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("OnTestSkipped", true);
		
		report.log(Status.SKIP, "Test Case SKIP: " + result.getName());
	}

	@Override
	public void onStart(ISuite suite) {
		Reporter.log("OnStrat", true);
		
//		create a report file 
		ExtentSparkReporter spark = new ExtentSparkReporter("./reports/testreport.html"); //onStart
		
//		Starting the report
		 reports = new ExtentReports(); //onStart
		
//		Write the report in to the report file
		reports.attachReporter(spark); //onStart
		
//		generating the report
		 report = reports.createTest("Sample Report: " + suite.getName()); //onStart
		
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("OnFinish", true);
		
//		Saving the file
		reports.flush(); //OnFnish -----it will save the report 
	}
	
	

}
