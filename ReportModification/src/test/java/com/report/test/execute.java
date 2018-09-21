package com.report.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class execute {
	ArrayList<String> builds = new ArrayList<String>();
	WebDriver driver=null;
	public static String changeReport=null;
	public static String widgets = null;
	
	@Test
	public void executer() throws Exception {
		for(int browser =0; browser<=2;browser++) {
			driver =new FirefoxDriver();
			if(browser==0) {
				Function.ProjectName="iOS_ARMS_Automation";
				changeReport = "iOS_ARMS_Automation";
			}if(browser==1) {
				Function.ProjectName="iOS_Regression_Automation";
				changeReport = "iOS_Regression_Automation";
			}if(browser==2) {
				Function.ProjectName="iOS_Smoke_Automation";
				changeReport = "iOS_Smoke_Automation";
				
			}
				
				driver.get("http://localhost:8089/job/"+Function.ProjectName+"/allure/");
				driver.manage().window().maximize();
				WebElement Build= driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div[2]/div[3]/div[2]/div/div/span/div[2]/a"));
				Function.BuildNo =   Build.getText().replaceAll(Function.ProjectName+" #", "");

			
		System.out.println("Execution on Build : "+Function.BuildNo);
		Function.destDir= "/Users/macmini/.jenkins/jobs/"+Function.ProjectName+"/builds/"+Function.BuildNo+"/archive/";
		String zipFilePath="/Users/macmini/.jenkins/jobs/"+Function.ProjectName+"/builds/"+Function.BuildNo+"/archive/allure-report.zip";
<<<<<<< HEAD
		widgets="/Users/macmini/.jenkins/jobs/"+changeReport+"/builds/"+Function.BuildNo+"/archive/allure-report/data/";
=======
		widgets="/Users/macmini/.jenkins/jobs/"+changeReport+"/builds/"+Function.BuildNo+"/archive/allure-report/widgets/";
>>>>>>> b7477953b5dfa5ed32da7a4b1875938a870506c0
		driver.close();
		Function.zipfolder("unzip");
		Function.move_Files("Allure_Style");
		Function.zipfolder("zip");
			
		}
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("***=======Report Execution Started======***");
		

	}

	@AfterClass
	public void afterClass() {
	}

}
