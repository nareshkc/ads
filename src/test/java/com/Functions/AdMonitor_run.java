package com.Functions;

import io.appium.java_client.MobileElement;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.asserts.SoftAssert;

import com.Genaral.Driver;
import com.Genaral.readExcelValues;

//---Main method for execute the test

/**
 * @author Naresh
 *
 */
public class AdMonitor_run extends Driver {
	

	//public static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
	

	//	@Test(priority=0)
	//	public static void Feed_0_Ad_VAlidation() throws Exception{
	//		Functions.Feed_Ad_Validation(0);
	//	}
	
	
	@Test(priority=1)
	//Execute method for feed_1 Validation
	public void feed_1_Ad_Validation() throws Exception {
		try {
			logStep("Validating feed_1 ad");
		Functions.Feed_Ad_Validation(1);
		}catch(Exception e) {
			logStep("App was closed suddenly trying to reopn and execute");
			Functions.close_launchApp();
			Functions.Feed_Ad_Validation(1);
		}
	}
	
	@Test(priority=2)
	//Execute method for feed_2 Validation
	public void feed_2_Ad_VAlidation() throws Exception{
		logStep("Validating feed_2 ad");
		Functions.Feed_Ad_Validation(2);
	}
	
	@Test(priority=3)
	//Execute method for feed_3 Validation
	public void Feed_3_Ad_Validation() throws Exception {
		logStep("Validating feed_3 ad");
		Functions.Feed_Ad_Validation(3);
	}
	@Test(priority=4)
	//Execute method for feed_4 Validation
	public void feed_4_Ad_VAlidation() throws Exception{
		logStep("Validating feed_4 ad");
		Functions.Feed_Ad_Validation(4);
	}
	/*@Test(priority=5)
	//Execute method for feed_5 Validation
	public void feed_5_Ad_Validation() throws Exception {
		logStep("Validating feed_5 ad");
		Functions.Feed_Ad_Validation(5);
	}*/
	@Test(priority=6)
	//Execute method for hourly page ad Validation
	public void hourlyPageAd_Validations() throws Exception{
		System.out.println("*********************** Started Validating Hourly Detail page ads ****************");
		Functions.FeedValue=10;
		try {
		//Functions.returnToWeather();
		//Functions.close_launchApp();
		Functions.addnewAddress("Detail");
		//Functions.ScrollUp_ToHomePage();
		logStep("Validating hourly detail page ad");
		ExecutableFunctions.Function_extened_HourlyPage_ads();
		}catch(Exception e) {
			logStep("app closed suddenly trying to restart and Validating hourly detail page ad");
			Functions.close_launchApp();
			Functions.addnewAddress("Detail");
			//Functions.ScrollUp_ToHomePage();
			ExecutableFunctions.Function_extened_HourlyPage_ads();
		}
	}
	@Test(priority=7)
	//Execute method for daily page ad Validation
	public void dailyPageAd_Validations() throws Exception{
		System.out.println("*********************** Started Validating Daily Detail page ads ****************");
		Functions.returnToWeather();
		logStep("Validating Daily detail page ad");
		ExecutableFunctions.Function_extened_DailyPage_ads();
	}
	@Test(priority=8)
	//Execute method for map page ad Validation
	public void mapPageAd_Validations()throws Exception{
		System.out.println("*********************** Started Validating Map Detail page ads ****************");
		Functions.returnToWeather();
		logStep("Validating Map detail page ad");
		ExecutableFunctions.Function_extened_MapPage_ads();
	}
	@Test(priority=9)
	//Execute method for news page ad Validation
	public void newsPageAd_Validations()throws Exception{
		System.out.println("*********************** Started Validating News Detail page ads ****************");
		logStep("Validating News detail page ad");
		ExecutableFunctions.Function_extened_NewsPage_ads();
	}*/
	/*@Test(priority=10)
	//Execute method for Lifestyle combo - Cold & Flu page ad Validation
	public void healthPage_cold_Flu_Ad_Validations()throws Exception{
		System.out.println("*********************** Started Validating LS_Cold and Flu Detail page ads ****************");
		logStep("Validating  LS_Cold and Flu detail page ad");
		try {
		Functions.enternewAddress("Bridgeton, New Jersey");
		Thread.sleep(8000); 
		ExecutableFunctions.Function_extened_LSModule_ads("LSModule(ColdAndFlu)");
		}catch(Exception e) {
			logStep("app closed suddenly trying to restart and Validating LS_Cold and Flu detail page ad");
			Functions.close_launchApp();
			Functions.enternewAddress("Bridgeton, New Jersey");
			Thread.sleep(8000); 
			ExecutableFunctions.Function_extened_LSModule_ads("LSModule(ColdAndFlu)");
		}
	}
	@Test(priority=11)
	//Execute method for Lifestyle combo - Allergy page ad Validation
	public void healthPage_Allergy_Ad_Validations()throws Exception{
		System.out.println("*********************** Started Validating Ls_Allergy Detail page ads ****************");
		logStep("Validating  Ls_Allergy detail page ad");
		ExecutableFunctions.Function_extened_LSModule_ads("LSModule(Allergy)");
	}
	@Test(priority=12)
	//Execute method for Lifestyle combo - Ski page ad Validation
	public void healthPage_Ski_Ad_Validations()throws Exception{
		System.out.println("*********************** Started Validating LS_Ski Detail page ads ****************");
		logStep("Validating  LS_Ski detail page ad");
		ExecutableFunctions.Function_extened_LSModule_ads("LSModule(Ski)");
	}
	@Test(priority=13)
	//Execute method for Lifestyle combo - Running page ad Validation
	public void HealthPage_Running_Ad_Validations()throws Exception{
		System.out.println("*********************** Started Validating LS_Running Detail page ads ****************");
		logStep("Validating  LS_Running detail page ad");
		ExecutableFunctions.Function_extened_LSModule_ads("LSModule(Running)");
	}
	@Test(priority=14)
	//Execute method for Lifestyle combo - Boat & Beach page ad Validation
	public void healthPage_Boat_Beach_Ad_Validations()throws Exception{
		System.out.println("*********************** Started Validating Ls_Boat_Beach Detail page ads ****************");
		logStep("Validating  Ls_Boat_Beach detail page ad");
		ExecutableFunctions.Function_extened_LSModule_ads("LSModule(Boat&Beach)");
	}
	@Test(priority=15,enabled=false)
	//Execute method for native ad Validation
	public void nativAd_Validations()throws Exception{
		System.out.println("*********************** Started Validating Native ad ****************");
		Functions.Setappinto_TestMode("Select");
		Functions.Setappinto_TestMode("nativeAd");
		ExecutableFunctions.Function_validate_BB_ads("nativeAd");
	}*/
	@Test(priority=16)
	//Execute method for nativeBB-ad Validation
	public void nativBB_Validations()throws Exception{
		System.out.println("*********************** Started Validating Native BB ****************");
		Functions.Setappinto_TestMode("Select");
		//Functions.Setappinto_TestMode("nativeBB");
		ExecutableFunctions.Function_validate_BB_ads("nativeBB");
	}
	@Test(priority=17)
	//Execute method for native_animated BB  ad Validation
	public void nativanimatedBB_Validations()throws Exception{
		System.out.println("*********************** Started Validating Native animated BB ****************");
		//Functions.Setappinto_TestMode("native_animated_BB");
		ExecutableFunctions.Function_validate_BB_ads("native_animated_BB");
	}
	/*@Test(priority=18,enabled = false)
	//Execute method for Static BB Ad Validation
	public void staticBBAd_Validations()throws Exception{
		System.out.println("*********************** Started Validating StaticBB ad ****************");
		//Functions.Setappinto_TestMode("Select");
		ExecutableFunctions.Function_validate_BB_ads("StaticBB");
	}
	
	@Test(priority=19,enabled = false)
	//Execute method for animated BB Ad Validation
	public void animatedBBAd_Validations()throws Exception{
		System.out.println("*********************** Started Validating AnimatedBB ad ****************");
		ExecutableFunctions.Function_validate_BB_ads("AnimatedBB");
	}*/

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeTest
	//before test 
	public void beforeTest() throws Exception {
		//Preconditions
		Functions.startCharlesSession();
		//Functions.downloadXMLFile();
//		Functions.charles_Stop();
		Functions.uninstallApp();
		Functions.Appium_Autostart();
		Functions.capabilities();
		Functions.launchtheApp("true");
		//Functions.Setappinto_TestMode("UnSelect");
		//System.out.println("App launched ");
		//Functions.close_launchApp();
		Functions.delete_screenshots();
//		Functions.Setappinto_TestMode("UnSelect");
//		Functions.addnewAddress("Feed");
		Functions.scroll_Down();
		Functions.check_BN_enabled();
	}

	@AfterTest
	public void afterTest() throws Exception {
		Functions.downloadXMLFile();
		driver_ios.close();
		Functions.move_Files("Allure_Style");
		Ad.quit();
	}

}
