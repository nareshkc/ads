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

public class AdMonitor_run extends Driver {

	public static String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
	

	//	@Test(priority=0)
	//	public static void Feed_0_Ad_VAlidation() throws Exception{
	//		Functions.Feed_Ad_Validation(0);
	//	}
	@Test(priority=1)
	public static void Feed_1_Ad_Validation() throws Exception {
		Functions.Feed_Ad_Validation(1);
	}

	@Test(priority=2)
	public static void Feed_2_Ad_VAlidation() throws Exception{
		Functions.Feed_Ad_Validation(2);
	}
	@Test(priority=3)
	public static void Feed_3_Ad_Validation() throws Exception {
		Functions.Feed_Ad_Validation(3);
	}
	@Test(priority=4)
	public static void Feed_4_Ad_VAlidation() throws Exception{
		Functions.Feed_Ad_Validation(4);
	}
	@Test(priority=5)
	public static void Feed_5_Ad_Validation() throws Exception {
		Functions.Feed_Ad_Validation(5);
	}
	@Test(priority=6)
	public static void HourlyPageAd_Validations() throws Exception{
		System.out.println("*********************** Started Validating Hourly Detail page ads ****************");
		Functions.FeedValue=10;
		//Functions.returnToWeather();
		//Functions.close_launchApp();
		Functions.addnewAddress("Detail");
		//Functions.ScrollUp_ToHomePage();
		ExecutableFunctions.Function_extened_HourlyPage_ads();
	}
	@Test(priority=7)
	public static void DailyPageAd_Validations() throws Exception{
		System.out.println("*********************** Started Validating Daily Detail page ads ****************");
		Functions.returnToWeather();
		ExecutableFunctions.Function_extened_DailyPage_ads();
	}
	@Test(priority=8)
	public static void MapPageAd_Validations()throws Exception{
		System.out.println("*********************** Started Validating Map Detail page ads ****************");
		Functions.returnToWeather();
		ExecutableFunctions.Function_extened_MapPage_ads();
	}
	@Test(priority=9)
	public static void NewsPageAd_Validations()throws Exception{
		System.out.println("*********************** Started Validating News Detail page ads ****************");
		ExecutableFunctions.Function_extened_NewsPage_ads();
	}
	@Test(priority=10)
	public static void HealthPage_cold_Flu_Ad_Validations()throws Exception{
		System.out.println("*********************** Started Validating LS_Cold and Flu Detail page ads ****************");
		Functions.enternewAddress("Bridgeton, New Jersey");
		ExecutableFunctions.Function_extened_LSModule_ads("LSModule(ColdAndFlu)");
	}
	@Test(priority=11)
	public static void HealthPage_Allergy_Ad_Validations()throws Exception{
		System.out.println("*********************** Started Validating Ls_Allergy Detail page ads ****************");
		ExecutableFunctions.Function_extened_LSModule_ads("LSModule(Allergy)");
	}
	@Test(priority=12)
	public static void HealthPage_Ski_Ad_Validations()throws Exception{
		System.out.println("*********************** Started Validating LS_Ski Detail page ads ****************");
		ExecutableFunctions.Function_extened_LSModule_ads("LSModule(Ski)");
	}
	@Test(priority=13)
	public static void HealthPage_Running_Ad_Validations()throws Exception{
		System.out.println("*********************** Started Validating LS_Running Detail page ads ****************");
		ExecutableFunctions.Function_extened_LSModule_ads("LSModule(Running)");
	}
	@Test(priority=14)
	public static void HealthPage_Boat_Beach_Ad_Validations()throws Exception{
		System.out.println("*********************** Started Validating Ls_Boat_Beach Detail page ads ****************");
		ExecutableFunctions.Function_extened_LSModule_ads("LSModule(Boat&Beach)");
	}
	@Test(priority=15)
	public static void NativAd_Validations()throws Exception{
		System.out.println("*********************** Started Validating Native ad ****************");
		Functions.Setappinto_TestMode("nativeAd");
		ExecutableFunctions.Function_validate_BB_ads("nativeAd");
	}
	@Test(priority=16)
	public static void NativBB_Validations()throws Exception{
		System.out.println("*********************** Started Validating Native BB ****************");
		Functions.Setappinto_TestMode("nativeBB");
		ExecutableFunctions.Function_validate_BB_ads("nativeBB");
	}
	@Test(priority=17)
	public static void NativanimatedBB_Validations()throws Exception{
		System.out.println("*********************** Started Validating Native animated BB ****************");
		//Functions.Setappinto_TestMode("native_animated_BB");
		ExecutableFunctions.Function_validate_BB_ads("native_animated_BB");
	}
	@Test(priority=18,enabled = false)
	public static void staticBBAd_Validations()throws Exception{
		System.out.println("*********************** Started Validating StaticBB ad ****************");
		Functions.Setappinto_TestMode("Select");
		ExecutableFunctions.Function_validate_BB_ads("StaticBB");
	}
	
	@Test(priority=19)
	public static void animatedBBAd_Validations()throws Exception{
		System.out.println("*********************** Started Validating AnimatedBB ad ****************");
		ExecutableFunctions.Function_validate_BB_ads("AnimatedBB");
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeTest
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
		Functions.Setappinto_TestMode("UnSelect");
		Functions.addnewAddress("Feed");
		Functions.scroll_Down();
		Functions.check_BN_enabled();
	}

	@AfterTest
	public void afterTest() throws Exception {
		Functions.downloadXMLFile();
		driver_ios.close();
	}

}
