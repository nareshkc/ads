package com.Genaral;

import java.util.Set;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    public void onFinish(ITestContext context) {
		Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			//RetryAnalyzer.count=0;
			System.out.println("Method Size is : "+context.getFailedTests().getResults(method).size());

			if (context.getFailedTests().getResults(method).size() > 1) {
				failedTests.remove(temp);
				
			} else {
				System.out.println("Method Size is : "+context.getPassedTests().getResults(method).size());
				if (context.getPassedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
					
				}
			}
			
		}
	}
  
    public void onTestStart(ITestResult result) {   }
  
    public void onTestSuccess(ITestResult result) {   }
  
    public void onTestFailure(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}  