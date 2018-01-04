package com.Genaral;

import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Driver extends PropertyFile {

	@SuppressWarnings("rawtypes")
	//protected static AppiumDriver Ad ;
	
	protected static AppiumDriver<MobileElement> Ad;
	public static AppiumDriverLocalService service;
	public static WebDriver driver_ios = null;
	public static WebDriver driver_ipa =null;
	public static WebDriver driver_Report=null;
	//protected static ExtentReports reporter;
	//protected static ExtentTest logger;
	public static String Excel_Path =null;
	

	@Step("{0}")
	public static void logStep(String stepName) {
	}
}
