package com.report.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class execute {
	@Test
	public void executer() throws Exception {
		Function.zipfolder("unzip");
		Function.move_Files("Allure_Style");
		Function.zipfolder("zip");
	}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Report Execution Started");
		WebDriver driver= new FirefoxDriver();
		driver.get("http://localhost:8089/job/iOS_ARMS_Automation/allure/");
		driver.manage().window().maximize();
		WebElement Build= driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/div[2]/div[3]/div[2]/div/div/span/div[2]/a"));
		Function.BuildNo =   Build.getText().replaceAll("iOS_ARMS #", "");
		System.out.println("Execution on Build : "+Function.BuildNo);
		Function.destDir= "/Users/macmini/.jenkins/jobs/iOS_ARMS/builds/"+Function.BuildNo+"/archive/";
		String zipFilePath="/Users/macmini/.jenkins/jobs/iOS_ARMS/builds/"+Function.BuildNo+"/archive/allure-report.zip";

		driver.close();
	}

	@AfterClass
	public void afterClass() {
	}

}
