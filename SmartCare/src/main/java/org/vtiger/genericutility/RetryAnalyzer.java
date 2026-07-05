package org.vtiger.genericutility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	
	int startingpoint = 0;
	int upperlimit = 3;
	
	@Override
	public boolean retry(ITestResult result) {

		if (startingpoint<upperlimit) {
			
			startingpoint++;
			return true;
			
		}
			
		return false;
	}

	
	
	
	
}
