package com.Functions;

import io.appium.java_client.MobileElement;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.TemporaryFilesystem;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import ru.yandex.qatools.allure.annotations.Title;

import com.Genaral.Driver;
import com.Genaral.RetryAnalyzer;
import com.Genaral.readExcelValues;

public class Smoke_Run extends Driver {



	//Verify bb call with Sever1
	/*@Test(priority =0,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("BB cal verification with Server1 Test case")
	public void Verify_BBcall_Severe1() throws Exception {
		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** BB call verification test cases Started with Severe1 for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_BBValidation_withSevere("severe1");
		}else{
			System.out.println("****** BB call verification test cases Started with Severe1 for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_BBValidation_withSevere("severe1");		
		}
	}

	//Pull to refresh Test case
	@Test(priority =1,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Pull to refresh Test case")
	public void Verify_pullto_refresh() throws Exception {
		System.out.println("==============================================");
		Functions.contentmodemodule("normal");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Pull To Refresh test cases Started for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_pullto_refresh();
		}else{
			System.out.println("****** Pull To Refresh test cases Started for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_pullto_refresh();		
			}
	}
	 */
	//Verify extended Hourly page ad presence Test case
	@Test(priority =2,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify extended Hourly page ad presence Test case")
	public void Verify_extened_HourlyPage_ads() throws Exception {

		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Hourly Module test cases Started for "+RetryAnalyzer.count);
			Functions.close_launchApp();
			ExecutableFunctions.Function_extened_HourlyPage_ads();
		}else{
			System.out.println("****** Hourly Module test cases Started for "+RetryAnalyzer.count);

			ExecutableFunctions.Function_extened_HourlyPage_ads();
		}
	}

	@Test(priority=3,enabled = true,retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify Adcals Back from Ads page Call")
	public void Smoke_Test_Case_VerifyAdCals_BackfromAdsPage() throws Exception{
		System.out.println("===========================Verify  Adcals Back from Ads page====================");

		//System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Ad validation Back from Ad page test cases Started for "+RetryAnalyzer.count);
			Functions.close_launchApp();
			ExecutableFunctions.Function_Smoke_Test_Case_VerifyAdCals_BackfromAdsPage();
		}else{
			System.out.println("****** Ad validation Back from Ad page test cases Started for "+RetryAnalyzer.count);
			Functions.close_launchApp();
			ExecutableFunctions.Function_Smoke_Test_Case_VerifyAdCals_BackfromAdsPage();
		}


	}

	//Verify extended Daily page ad presence Test case
	@Test(priority =4,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify extended Daily page ad presence Tst case")
	public void Verify_extened_DailyPage_ads() throws Exception {
		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Daily Module test cases Started for "+RetryAnalyzer.count);
			Functions.close_launchApp();
			ExecutableFunctions.Function_extened_DailyPage_ads();
		}else{
			System.out.println("****** Daily Module test cases Started for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_extened_DailyPage_ads();
		}


	}
	//Verify extended Map page ad presence Test case
	@Test(priority =5,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify extended Map page ad presence Test case")
	public void Verify_extened_MapPage_ads() throws Exception {
		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Map Module test cases Started for "+RetryAnalyzer.count);
			Functions.close_launchApp();
			ExecutableFunctions.Function_extened_MapPage_ads();
		}else{
			System.out.println("****** Map Module test cases Started for "+RetryAnalyzer.count);
			//Functions.close_launchApp();
			ExecutableFunctions.Function_extened_MapPage_ads();
		}

	}
	//Verify extended Hurricane Central page ad presence Test case
	/*@Test(priority =8,enabled = false, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify extended Hurricane Central page ad presence Test case")
	public void Verify_extened_Hurricane_ads() throws Exception {
		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Haricane test cases Started for "+RetryAnalyzer.count);	
			Functions.close_launchApp();
			ExecutableFunctions.Function_extened_Hurricane_ads();
		}else{
			System.out.println("****** Haricane test cases Started for "+RetryAnalyzer.count);	
			ExecutableFunctions.Function_extened_Hurricane_ads();
		}

	}*/

	//Verify Adzone validation Test case
	@Test(priority =7,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify Adzone validation Test case")
	public void Verify_Adzone() throws Exception{
		System.out.println("=============================================");
		if(RetryAnalyzer.count >= 1){
			Functions.TestName="Adzone";
			System.out.println("****** Adzone Veification test cases Started");

			ExecutableFunctions.Function_VerifyAdzones();
		}else{
			ExecutableFunctions.Function_VerifyAdzones();
		}
	}
	//Verify bb call with Sever2
	/*@Test(priority =9,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("BB cal verification with Server2 Test case")
	public void Verify_BBcall_Severe2() throws Exception {
		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** BB call verification test cases Started with Severe2 for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_BBValidation_withSevere("severe2");
		}else{
			System.out.println("****** BB call verification test cases Started with Severe2 for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_BBValidation_withSevere("severe2");		
		}
	}*/

	//Verify Clean launch the app Test case
	@Test(priority =10,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify Clean launch the app Test case")
	public void Verify_cleanlaunch() throws Exception {
		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Clean launch test cases Started for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_cleanlaunch();
		}else{
			System.out.println("****** Clean launch test cases Started for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_cleanlaunch();
		}
	}

	@Test(priority =11,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify Feed ads Navigate Back from Weather Widget")
	public void Verify_Feedcalls_FromWeather_Widget() throws Exception {
		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Weather widget test cases Started for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_Feedcalls_FromWeather_Widget();
		}else{
			System.out.println("****** Weather widget test cases Started for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_Feedcalls_FromWeather_Widget();
		}
	}

	@Test(priority =12,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify WFXTG and CXTG Values with WFXTriggers API")
	public void Verify_WFXTriggers_cxtg() throws Exception {
		System.out.println("==============================================");
		//Functions.retryclear();
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** WFX Trigger CXTG Cal test cases Started for "+RetryAnalyzer.count);
			Functions.close_launchApp();
			ExecutableFunctions.Function_WFXTriggers_cxtg();
		}else{
			System.out.println("****** WFX Trigger CXTG Cal test cases Started for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_WFXTriggers_cxtg();
		}
	}

	//FACTUAL Test cases
	@Test(priority =13,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify Facual Values with Facual API")
	public void Verify_WFXTriggers_Factuals() throws Exception {
		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Factua Cal test cases Started for "+RetryAnalyzer.count);
			Functions.close_launchApp();
			Thread.sleep(3000);
			Functions.downloadXMLFile();
			Functions.readXML();
			ExecutableFunctions.Function_WFXTriggers_Factuals();
		}else{
			System.out.println("****** Factua Cal test cases Started for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_WFXTriggers_Factuals();
		}
	} 
	//Lotame Test case
	@Test(priority =14,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify Lotame Values with Lotame API")
	public void Verify_Lotame() throws Exception {
		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Lotame Cal test cases Started for "+RetryAnalyzer.count);
			Functions.close_launchApp();
			Thread.sleep(3000);
			Functions.downloadXMLFile();
			Functions.readXML();
			ExecutableFunctions.Function_Lotame();
		}else{
			System.out.println("****** Lotame Cal test cases Started for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_Lotame();
		}
	}



	@Test(priority =15,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify BB ad call in Test Mode")
	public void Verify_Pubadcall_in_TestMode() throws Exception {
		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Set Test mode and verify BB Cal test cases Started for "+RetryAnalyzer.count);
			Functions.close_launchApp();
			ExecutableFunctions.Function_Pubadcall_in_TestMode();
		}else{
			System.out.println("****** Set Test mode and verify BB Cal test cases Started for "+RetryAnalyzer.count);
			Functions.close_launchApp();
			ExecutableFunctions.Function_Pubadcall_in_TestMode();
		}

	}

	//Thirdparty beacon Testcase Verification

	@Test(priority =16,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Thirdparty beacon Testcase Verification")
	public void Verify_ThirdParty_beacons() throws Exception {
		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Thirdparty Beacon test cases Started for "+RetryAnalyzer.count);
			Functions.close_launchApp();
			Functions.delete_folder("Charles");
			Functions.clear_session();
			Functions.enternewAddress("Bridgeton, New Jersey");
			Functions.downloadXMLFile();
			Functions.clear_sb();
			Functions.readXML();
			ExecutableFunctions.Function_ThirdParty_beacons();

		}else{
			System.out.println("****** Thirdparty Beacon test cases Started for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_ThirdParty_beacons();
		}

	}


	@Test(priority =17,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify Preroll ad on Video madule")
	public void Verify_PrerollAd() throws Exception {
		System.out.println("==============================================");
		//Functions.retryclear();
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Prerol-video ad test cases Started for "+RetryAnalyzer.count);
			Functions.close_launchApp();
			ExecutableFunctions.Function_PrerollAd();
		}else{
			System.out.println("****** Prerol-video ad test cases Started for "+RetryAnalyzer.count);
			ExecutableFunctions.Function_PrerollAd();
		}

	}

	/*//Verify extended Hurricane Central page ad presence Test case
	@Test(priority =6,enabled = false, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify extended Hurricane Central page ad presence Test case")
	public void Verify_extened_Hurricane_ads() throws Exception {
		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** Haricane test cases Started for "+RetryAnalyzer.count);	
			Functions.close_launchApp();
			ExecutableFunctions.Function_extened_Hurricane_ads();
		}else{
			System.out.println("****** Haricane test cases Started for "+RetryAnalyzer.count);	
			ExecutableFunctions.Function_extened_Hurricane_ads();
		}

	}

	//Verify extended News page ad presence Test case
	@Test(priority =7,enabled = true, retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify extended News page ad presence Test case")
	public void Verify_extened_NewsPage_ads() throws Exception {
		System.out.println("==============================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** News Module test cases Started for "+RetryAnalyzer.count);
			Functions.delete_folder();
			Functions.clear_session();
			Functions.close_launchApp();
			ExecutableFunctions.Function_extened_NewsPage_ads();
		}else{
			System.out.println("****** News Module test cases Started for "+RetryAnalyzer.count);
			Functions.close_launchApp();
			ExecutableFunctions.Function_extened_NewsPage_ads();
		}
	}//Verify extended LSModule page ad presence Test case
	@Test(priority =16,enabled = false,  retryAnalyzer=RetryAnalyzer.class)
	@Title("Verify extended LSModule page ad presence Test case")
	public void Verify_extened_LSModule_ads() throws Exception {
		System.out.println("================================================");
		if(RetryAnalyzer.count >= 1){
			System.out.println("****** LS Module test cases Started for "+RetryAnalyzer.count);	
			Functions.close_launchApp();
			ExecutableFunctions.Function_extened_LSModule_ads();
		}else{
			System.out.println("****** LS Module test cases Started for "+RetryAnalyzer.count);	
			ExecutableFunctions.Function_extened_LSModule_ads();
		}
	}*/




	@BeforeMethod
	public void beforeMethod(){

	}

	@BeforeTest
	public void beforeTest() throws Exception {
		//Preconditions
		Functions.startCharlesSession();
		Functions.charles_Stop();
		Functions.app_download_from_hockeyapp();
		Functions.listFilesForFolder(Functions.folder);
		Functions.uninstallApp();
		Functions.Appium_Autostart();
		Functions.capabilities();
		Functions.launchtheApp("false");
		System.out.println("App launched ");
		Functions.close_launchApp();
		
	}

	@AfterTest
	public void afterTest() throws Exception{
		//Functions.move_Files("report_MoveFiles");
		Functions.delete_folder("Logs");
		driver_ios.quit();
		//Ad.quit();	
		Functions.quit_charles();
	}

	@AfterSuite
	public void afterSuite() throws Exception{
		Functions.Take_Report_Screenshot();
	}

}
