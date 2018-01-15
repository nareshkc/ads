package com.Functions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
//import org.apache.tools.ant.types.FileList.FileName;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

//import atu.testng.reports.ATUReports;

import com.Appium.Start_Stop_AppiumServer;
import com.Genaral.Driver;
import com.Genaral.RetryAnalyzer;
import com.Genaral.readExcelValues;
import com.relevantcodes.extentreports.LogStatus;
import com.weather.excel.ExcelData;
import com.weather.excel.WriteResultintoExcel;
import com.weather.excel.Write_result;



public class Functions extends Driver{

	static DesiredCapabilities capabilities = new DesiredCapabilities();
	static int Cap =1;
	static String UserStatus = null;
	static List<MobileElement> Addresseslist =null;
	static MobileElement TempEle =null;
	static MobileElement Settings =null;
	static MobileElement SelectAddress =null;
	public static StringBuffer sb = new StringBuffer("");
	public static String req =null;
	static String pubreq=null; 
	public static String pubreq1 = null;
	public static String Hardcode = null;
	public static String adreq1 = null;
	static List<String> container=null;
	static String SecondParamValue =null;
	public static String firstParamValue =null;
	public static String AdParams =null;
	public static String excelPage=null;
	public static int index;
	static String zipCode = null;
	static String[] splitPubvalues = null;
	public static String[] wfxcontainer=null;
	static String pubadcal=null;
	static String adcal=null;
	static String HurricaneXpath =null;
	static String prerolladxpath =null;
	public static String params_val=null;
	public static String fgeoparams_val=null;
	public static String faudparams_val=null;
	static int startY;
	static int endY;
	public static MobileElement module;
	public static String ModuleName="normal";
	public static String Hardcoded=null;
	public static String VideoAdzone=null;
	public static String seg = null;
	public static String Xpth =null;
	public static String ScreenShot=System.getProperty("user.dir")+"/screenshots";
	public static String VerifypubadValues=null;
	//	public static ArrayList<String> firstParamValue = new ArrayList<String>();
	public static ArrayList<String> pubads = new ArrayList<String>();
	public static ArrayList<String> pubads_video = new ArrayList<String>();
	public static ArrayList<String> AdzoneList = new ArrayList<String>();
	public static ArrayList<String> ads = new ArrayList<String>();
	public static ArrayList<String> pubadvalues = new ArrayList<String>();
	public static ArrayList<String> advalues = new ArrayList<String>();
	public static ArrayList<String> pubvalues = new ArrayList<String>();
	public static ArrayList<String> fgeolist = new ArrayList<String>();
	public static ArrayList<String> faudlist = new ArrayList<String>();
	public static ArrayList<String> cxtgcontainer = new ArrayList<String>();
	public static ArrayList<String> nzcscontainer = new ArrayList<String>();
	public static ArrayList<String> hzcscontainer = new ArrayList<String>();
	public static ArrayList<String> zcscontainer = new ArrayList<String>();
	public static ArrayList<String> wfxtgcontainer = new ArrayList<String>();
	public static ArrayList<String> firstList = new ArrayList<String>();
	public static String ipaPath=null;
	public static File folder=null;
	public static String buildText =null;
	public static String BuildName =null;
	public static String BuildNo =null;
	static String old_Build=null;
	static String new_build =null;
	public static String TestName=null;
	public static int FeedValue;

	//Appium Start
	public static void startAppiumServer() throws Exception { 
		readExcelValues.excelValues("Smoke","Appium");
		CommandLine command = new CommandLine(readExcelValues.data[1][Cap]);
		command.addArgument(readExcelValues.data[2][Cap], false);
		command.addArgument("--address", false);
		command.addArgument(readExcelValues.data[3][Cap]);
		command.addArgument("--port", false);
		command.addArgument(readExcelValues.data[4][Cap]);
		command.addArgument("--no-reset", true);
		command.addArgument("--log-level", true);
		command.addArgument("error");
		//		command.addArgument("--log");
		//		command.addArgument("/Users/aparna/Documents/sys11.log");


		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		executor.execute(command, resultHandler);
		Thread.sleep(20000);


	} 

	//Stop Appium Server
	public static  void stopAppiumServer() throws IOException {  
		//String[] command ={"/usr/bin/killall","-KILL","node"};  
		String[] command = new String[]{"sh", "-c", "lsof -P | grep ':4727' | awk '{print $2}' | xargs kill -9"};
		Runtime.getRuntime().exec(command);  
		//System.out.println("Appium server stop");  
	} 

	//Stop Appium Server
	public static  void startAppiumServer_command() throws Exception {  
		readExcelValues.excelValues("Smoke","Paths");
		Thread.sleep(3000);
		String line = "";
		String allLine = "";
		String[] str1 ={"/bin/bash", "-c", "/usr/local/bin/appium >> /Users/aparna/Documents/Naresh/com.werather.SmokeiOS/LogFilePath/syslog.log"};
		Process p1 = Runtime.getRuntime().exec(str1);


		//		    ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c", "appium >> /Users/aparna/Documents/Naresh/com.werather.SmokeiOS/LogFilePath/syslog.log");
		//
		//		    Process pr = builder.start();

		Thread.sleep(50000);
		BufferedReader r = new BufferedReader(new FileReader(readExcelValues.data[1][Cap]));
		Thread.sleep(3000);
		outerloop:
			while((line=r.readLine()) != null)
			{
				for(int i =1;i<=5;i++){
					//System.out.println("Sys data is ::"+line);
					if(line.contains("Welcome to Appium")){

						System.out.println("Appium launched Successfully");
						break outerloop;
					}else
					{
						Thread.sleep(10000);
						r = new BufferedReader(new FileReader(readExcelValues.data[1][Cap]));
					}
				}

			}

	} 
	//Appium Autostart
	public static void Appium_Autostart() throws IOException, Exception{
		//Auto start Appium
		Start_Stop_AppiumServer appiumStart = new Start_Stop_AppiumServer();
		System.out.println("Stopping the appium server");
		stopAppiumServer();
		System.out.println("Appium server is stopped");
		//Thread.sleep(10000);
		System.out.println("Starting the appium server");
		startAppiumServer();
		//startAppiumServer_command();
		System.out.println("Appium server is started and running");
	}

	//Decide connected device
	public static void capabilities() throws Exception {
		//Read Device Platform
		readExcelValues.excelValues("Smoke","Device");

		if(readExcelValues.data[1][1].equals("Android")){
			Cap = Cap+1;
		}else
		{
			Cap=Cap;
		}


	}
	//Scroll Down
	public static void scrolldown() throws InterruptedException{
		//Thread.sleep(1000);
		//Scroll JS
		JavascriptExecutor js = (JavascriptExecutor) Ad ;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);


	}
	//Swipe with cordinates
	public static void swipe(String SwipeType) {

		//TouchAction action= new TouchAction(Ad);
		if(SwipeType.equals("Up")) {
			Ad.swipe(386, 626, -11, -533, 2000);
			//action.press(356, 626).waitAction(1000).moveTo(-11,-533).release().perform();
		}else if(SwipeType.equals("Down")){
			Ad.swipe(181, 91, 3, 494, 2000);
			//action.press(181, 91).waitAction(1000).moveTo(3,494).release().perform();
		}else if(SwipeType.equals("right-to-left")){
			MobileElement skiModule=null;
			MobileElement coldFluModule =null;
			if(excelPage.equals("LSModule(Running)")||excelPage.equals("LSModule(Ski))")||excelPage.equals("LSModule(Boat&Beach)")) {
				skiModule= Ad.findElementByXPath("//XCUIElementTypeStaticText[@name='ski_title']");
				coldFluModule = Ad.findElementByXPath("//XCUIElementTypeStaticText[@name='coldAndFlu_title']");
				//			}else if(excelPage.equals("LSModule(Boat&Beach)")){
				//				skiModule= Ad.findElementByXPath("//XCUIElementTypeStaticText[@name='goRun_title']");
				//				coldFluModule = Ad.findElementByXPath("//XCUIElementTypeStaticText[@name='ski_title']");
			}
			Point skiPoint = skiModule.getLocation();
			Point coldFluPoint =coldFluModule.getLocation();
			//				String skilocationX =skiModule.getAttribute("x");
			//				String skilocationY =skiModule.getAttribute("y");
			//				String coldFlulocationX =coldFluModule.getAttribute("x");
			//				String coldFlulocationY =coldFluModule.getAttribute("y");
			int skiX=skiPoint.getX();
			int skiY=skiPoint.getY();

			int coldX=coldFluPoint.getX();
			int coldY=coldFluPoint.getY();
			//action.press(skiX,skiY).waitAction(1000).moveTo(coldX,coldY).release().perform();
			Ad.swipe(skiX, skiY, coldX, coldY, 2000);
			//Ad.swipe(skiX, skiY, coldX, coldY, 2000);
		}else {
			Ad.swipe(340, 657, -318, -1, 2000);
			//action.press(340, 657).waitAction(1000).moveTo(-318,-1).release().perform();
		}

		try {
			Ad.findElementByName("Cancel").click();
		}catch(Exception e) {

		}

	}
	//Swipe
	public static void Swipe(){
		Dimension dimensions = Ad.manage().window().getSize();
		Double startY1 = dimensions.getHeight() * 0.7;  
		startY = startY1.intValue();
		Double endY1 = (double) (dimensions.getHeight()/40);  //  dimensions.getHeight()  0.2;  == 512.0
		endY = endY1.intValue();
		Ad.swipe(0, startY, 0, endY,2000);
	}
	//App Kill Relaunch
	public static void Kill_realaunch() throws Exception
	{

		//Close the app
		Ad.closeApp();
		Thread.sleep(2000);
		System.out.println("App closed successfully");

		//Relaunch the app
		Ad.launchApp();
		System.out.println("App launched successfully");
		Thread.sleep(2000);
		Functions.Handle_onwanted_popups();

	}
	//Assert Equlist
	public static boolean equalLists(List<String> segmentJsonArray, List<String> container2) {

		if (segmentJsonArray == null && container2 == null) {
			return true;
		}

		if ((segmentJsonArray == null && container2 != null) || segmentJsonArray != null && container2 == null
				|| segmentJsonArray.size() != container2.size()) {
			System.out.println("Pubad request triggers and trigger call triggers are not matched");
			return false;

		}

		return segmentJsonArray.equals(container2);

	}


	//launch with xcuitest

	public static void launchtheApp_xcuit() throws Exception{	

		readExcelValues.excelValues("Smoke","Capabilities");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.1.1");
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("newCommandTimeout", "100000");
		capabilities.setCapability("deviceName", "=iPhone (10.1.1) [caea71833e3ca5e0adb5070514485bdeb8827951]");
		//capabilities.setCapability(MobileCapabilityType.VERSION, "10.1.1");
		capabilities.setCapability(MobileCapabilityType.PLATFORM,"Mac");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("sendKeyStrategy","setValue");
		capabilities.setCapability("UDID","caea71833e3ca5e0adb5070514485bdeb8827951");
		capabilities.setCapability("--no-reset", false);
		capabilities.setCapability("app", "/Users/aparna/Documents/Naresh/com.werather.SmokeiOS/Build/AppStore-Dev.ipa");
		capabilities.setCapability("realDeviceLogger", "/Users/aparna/.npm-packages/lib/node_modules/deviceconsole/deviceconsole");
		Ad = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Ad.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	//click ok allow after launch
	public static void click_allow(){
		try{
			Ad.findElementByName("Allow").click();
		}catch(Exception e){

		}
	}


	//clear retrycount
	public static void retryclear(){

		if(RetryAnalyzer.count==RetryAnalyzer.maxCount){
			System.out.println("RetryCount reached MaxCount");
			RetryAnalyzer.count=0;
			Assert.fail("RetryCount reached MaxCount");
			//break;

		}
	}
	//launch the app
	public static void launchtheApp(String ResetType) throws Exception{	

		readExcelValues.excelValues("Smoke","Capabilities");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		//Capabilities for IOS and Android Based on Selected on Device Selection
		capabilities.setCapability(readExcelValues.data[1][0], readExcelValues.data[1][Cap]);
		capabilities.setCapability(readExcelValues.data[2][0], readExcelValues.data[2][Cap]);
		capabilities.setCapability(readExcelValues.data[3][0], readExcelValues.data[3][Cap]);
		capabilities.setCapability(readExcelValues.data[5][0], readExcelValues.data[5][Cap]);
		capabilities.setCapability(readExcelValues.data[6][0], readExcelValues.data[6][Cap]);
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability(readExcelValues.data[7][0],"="+readExcelValues.data[7][Cap]);
		//capabilities.setCapability(readExcelValues.data[7][0],"iPhone");
		capabilities.setCapability(readExcelValues.data[8][0], readExcelValues.data[8][Cap]);
		capabilities.setCapability(readExcelValues.data[9][0], ResetType);
		capabilities.setCapability(readExcelValues.data[10][0], ipaPath.toString());
		capabilities.setCapability(readExcelValues.data[12][0], readExcelValues.data[12][Cap]);
		capabilities.setCapability(readExcelValues.data[13][0], readExcelValues.data[13][Cap]);
		capabilities.setCapability(readExcelValues.data[14][0], true);
		capabilities.setCapability(readExcelValues.data[16][0], readExcelValues.data[16][Cap]);
		capabilities.setCapability(readExcelValues.data[11][0], readExcelValues.data[11][Cap]);
		capabilities.setCapability("--session-override",true);
		capabilities.setCapability("bundleId","com.weather.TWC");
		//capabilities.setCapability("xcodeConfigfile","/Users/vishal.pathania/Downloads/appium-163/node_modules/appium-xcuitest-driver/WebDriverAgent/Config.xcconfig");
		//capabilities.setCapability("xcodeSigningId","iPhone Developer");
		//capabilities.setCapability("locationServicesEnabled", false);
		//capabilities.setCapability("realDeviceLogger", "/Users/vishal.pathania/node_modules/deviceconsole/deviceconsole");
		//capabilities.setCapability("wdaLocalPort", "8200");	
		//capabilities.setCapability("locationServicesAuthorized", true);
		capabilities.setCapability("waitForAppScript","$.delay(5000); true");
		capabilities.setCapability("clearSystemFiles",true);
		System.out.println("Reading capabilities done");
		//Wait time for Execution of node.js
		//Thread.sleep(10000);
		Ad = new IOSDriver(new URL("http://127.0.0.1:4727/wd/hub"), capabilities);
		Ad.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Handle Extra popup appears when app launched (like New module ebnable)
		Handle_onwanted_popups();
		//		//Ad.tap(1, 10, 6, 2000);
		//		Functions.BacktoWeather();
		//		Functions.TakeScreenshot();

		Write_result wrResult1 = new Write_result();
		wrResult1.WriteResult("Capabilities", ipaPath.toString(), 14, Cap);
	}

	//Handle unwanted popups
	public static void Handle_onwanted_popups(){
		try{
			Ad.findElementByName("Later").click();
		}catch(Exception e){

		}
		try{
			Ad.findElementByName("close_button").click();
		}catch(Exception e){

		}

		try{
			Ad.findElementByName("Yes").click();
		}catch(Exception e){

		}

		try{
			Ad.findElementByName("Always Allow").click();
		}catch(Exception e){

		}

		click_allow();
		try{
			Ad.findElementByName("Continue").click();
		}catch(Exception e){

		}

		try{
			Ad.findElementByName("Later").click();
		}catch(Exception e){

		}
		try{
			Ad.findElementByName("Not Now").click();
		}catch(Exception e){

		}
		try{
			Ad.findElementByName("Do not show again").click();
		}catch(Exception e){

		}
	}

	//Launch without full reset
	//launch the app
	public static void launchtheApp_Withoutfullreset() throws Exception{	

		readExcelValues.excelValues("Smoke","Capabilities");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		//Capabilities for IOS and Android Based on Selected on Device Selection
		capabilities.setCapability(readExcelValues.data[1][0], readExcelValues.data[1][Cap]);
		capabilities.setCapability(readExcelValues.data[2][0], readExcelValues.data[2][Cap]);
		capabilities.setCapability(readExcelValues.data[3][0], readExcelValues.data[3][Cap]);
		capabilities.setCapability(readExcelValues.data[5][0], readExcelValues.data[5][Cap]);
		capabilities.setCapability(readExcelValues.data[6][0], readExcelValues.data[6][Cap]);
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability(readExcelValues.data[7][0],"="+readExcelValues.data[7][Cap]);
		//capabilities.setCapability(readExcelValues.data[7][0],"iPhone");
		capabilities.setCapability(readExcelValues.data[8][0], readExcelValues.data[8][Cap]);
		capabilities.setCapability(readExcelValues.data[9][0], false);
		capabilities.setCapability(readExcelValues.data[10][0], ipaPath.toString());
		capabilities.setCapability(readExcelValues.data[12][0], readExcelValues.data[12][Cap]);
		capabilities.setCapability(readExcelValues.data[13][0], readExcelValues.data[13][Cap]);
		capabilities.setCapability(readExcelValues.data[14][0], readExcelValues.data[14][Cap]);
		capabilities.setCapability(readExcelValues.data[16][0], readExcelValues.data[16][Cap]);
		capabilities.setCapability(readExcelValues.data[11][0], readExcelValues.data[11][Cap]);
		//capabilities.setCapability("--session-override",true);
		capabilities.setCapability("bundleId","com.weather.TWC");
		capabilities.setCapability("xcodeConfigfile","/Users/aparna/Downloads/appium163/node_modules/appium-xcuitest-driver/WebDriverAgent/Config.xcconfig");
		//capabilities.setCapability("xcodeSigningId","iPhone Developer");
		//capabilities.setCapability("locationServicesEnabled", false);
		capabilities.setCapability("realDeviceLogger", "/Users/aparna/.npm-packages/lib/node_modules/deviceconsole/deviceconsole");
		//capabilities.setCapability("wdaLocalPort", "8200");	
		//capabilities.setCapability("locationServicesAuthorized", true);
		capabilities.setCapability("waitForAppScript","$.delay(5000); true");
		System.out.println("Reading capabilities done");
		//Wait time for Execution of node.js
		Thread.sleep(80000);

		Ad = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		Ad.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//Handle Extra popup appears when app launched (like New module ebnable)
		try{
			Ad.findElementByName("close_button").click();
		}catch(Exception e){

		}
		try{
			Ad.findElementByName("Allow").click();
		}catch(Exception e){

		}
		//Ad.tap(1, 10, 6, 2000);
		Functions.BacktoWeather();
		//Functions.TakeScreenshot();
	}

	//quit charles
	public static void quit_charles() throws Exception{
		String[] quitCharles ={"/bin/bash", "-c","osascript -e 'quit app \"charles\"'"};
		Process quit = Runtime.getRuntime().exec(quitCharles);
		Thread.sleep(5000);
		System.out.println("Charles was quit successfully");
	}



	//Navigating from Back to weather
	public static void BacktoWeather(){
		System.out.println("Eneter for Back to wather page");
		try{

			if(Ad.findElementByName("Back to The Weather").isDisplayed()){

				//Ad.findElementByName("Back to The Weather").click();
				Ad.tap(1, 10, 6, 2000);
			}

		}catch(Exception e){
			System.out.println("User on Weather CC Page");
		}
	}

	//Disable enable Follow me forecast
	public static void disableEnable_FMF(){
		if(Ad.findElementByName("Follow Me Forecast, Weather for your current location").isSelected())
		{
			System.out.println("LBS is already enabled");
			Ad.findElementByName("Follow Me Forecast, Weather for your current location").click();
			System.out.println("LBS is Disabled");
			Ad.findElementByName("Follow Me Forecast, Weather for your current location").click();
			System.out.println("LBS is Enabled now");

		}else
		{
			Ad.findElementByName("Follow Me Forecast, Weather for your current location").click();
			System.out.println("LBS is enabled");
		}

	}

	//Verifi User Loggedin
	public static void verifyuserloggedIn() throws Exception{	
		readExcelValues.excelValues("Smoke","Login");
		logStep("verify User login");
		Thread.sleep(5000);
		UserStatus= Ad.findElementByXPath(readExcelValues.data[2][Cap]).getText();

		if(UserStatus.equals(readExcelValues.data[9][Cap])){
			System.out.println("User Already LoggedIn");
			logStep("User Already LoggedIn");
		}else{
			System.out.println("User not LoggedIn");
			logStep("User not LoggedIn try to loggin");
		}


	}

	//Clear data from AllFeeds Excelfile
	public static void Clear_AllParams() throws Exception{
		String[][] data2 = new String[10][10];
		ExcelData er2 = new ExcelData();
		data2 = er2.excelread("Cust_Param_Result","AllParams");
		Write_result wrResult2 = new Write_result();


		for(int filln = 1;filln<=er2.rowcount;filln++){
			wrResult2.WriteResult("AllParams","n",filln,2);
			wrResult2.WriteResult("AllParams","n",filln,3);
			wrResult2.WriteResult("AllParams","n",filln,4);
		}
	}

	//Clear data from CustParam Result Excelfile
	public static void Clear_CustParams() throws Exception{
		for(int feeds=1;feeds<=6;feeds++){

			String[][] data3 = new String[10][10];
			ExcelData er3 = new ExcelData();
			data3 = er3.excelread("Cust_Param_Result","SMOKE");

			int Getresult1 = feeds*2;
			//Change values for entering result into all the feeds
			int ResultColumn_n1=7+Getresult1;
			int ResultColumn_n2=8+Getresult1;

			//Write results into Excel
			WriteResultintoExcel wResult3 = new WriteResultintoExcel();
			for(int testcase=1;testcase<=er3.rowcount;testcase++)
			{
				wResult3.enterResult("SMOKE", "n", "n", testcase, ResultColumn_n1, ResultColumn_n2);

			}

		}
	}
	//Login
	public static void logIn() throws Exception{	

		readExcelValues.excelValues("Smoke","Login");
		Thread.sleep(5000);
		Settings =Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]");
		//		Settings.click();
		UserStatus= Ad.findElementByXPath(readExcelValues.data[2][Cap]).getText();
		//if User already logged in navigate to cc page
		if(UserStatus.equals(readExcelValues.data[9][Cap])){
			System.out.println("User Already LoggedIn");
			Thread.sleep(3000);
			Settings.click();
			System.out.println("User on CC page");
		}else{
			System.out.println("User not LoggedIn");

			//If user not logged in enter username and password and try to loggin
			Ad.findElementByName(readExcelValues.data[7][Cap]).click();
			Thread.sleep(1000);
			Ad.findElementByName(readExcelValues.data[3][Cap]).clear();
			Ad.findElementByName(readExcelValues.data[3][Cap]).sendKeys(readExcelValues.data[4][Cap]);
			Thread.sleep(1000);
			Ad.findElementByName(readExcelValues.data[5][Cap]).clear();
			Ad.findElementByName(readExcelValues.data[5][Cap]).sendKeys(readExcelValues.data[6][Cap]);
			Thread.sleep(1000);
			Ad.findElementByName(readExcelValues.data[8][Cap]).click();
			Ad.findElementByName(readExcelValues.data[7][Cap]).click();
			try{
				Ad.findElementByName("ok").click();
				System.out.println("User not able logged in successfully ");
				logStep("User not able logged in successfully");
				Ad.findElementByName("navControl backArrow").click();
			}catch(Exception e){

			}
			System.out.println("User logged in successfully");
			logStep("User logged in successfully");
			Thread.sleep(7000);
			Functions.clear_session();
			//Functions.disableEnable_FMF();

			WebDriverWait wait = new WebDriverWait(Ad,10);
			try{
				//Settings =Ad.findElementByXPath(readExcelValues.data[1][Cap]);
				wait.until(ExpectedConditions.visibilityOf(Settings));

			}catch (Exception e)
			{
				//Functions.TakeScreenshot();
			}
			Settings.click();

			Thread.sleep(3000);
			System.out.println("User on CC page");
			logStep("User back to CC Page");
		}
		Thread.sleep(3000);
	}


	//Kill The app
	public void killtheApp() throws Exception
	{
		Ad.closeApp();
		Thread.sleep(1000);
		System.out.println("App closed successfully");
	}

	//Relaunch the app
	public void relaunchtheApp() throws Exception
	{
		try{
			Ad.launchApp();
			System.out.println("App launched successfully");
		}catch (Exception e){
			//Functions.TakeScreenshot();
		}
	}

	public static void uninstall_installApp() throws Exception{
		readExcelValues.excelValues("Smoke","Paths");

		if(Ad.isAppInstalled(readExcelValues.data[10][Cap])){
			System.out.println("App installed in the device and trying to uninstall");
			Ad.removeApp(readExcelValues.data[10][Cap]);
			System.out.println("App was uninstalled succesfully and trying to install");
			Ad.installApp(readExcelValues.data[14][Cap]);
			System.out.println("App was installed Successfully");
		}else{
			System.out.println("App was not ther in the device, installing the appa");
			Ad.installApp(readExcelValues.data[14][Cap]);
			System.out.println("App was installed Successfully");
			Thread.sleep(5000);
			Ad.launchApp();
		}
	}
	//Uninstall the app
	public static void uninstallApp() throws Exception{
		readExcelValues.excelValues("Smoke","Paths");
		Thread.sleep(3000);
		String line = "";
		String allLine = "";
		String[] str1 ={"/bin/bash", "-c", readExcelValues.data[13][Cap]+" " +readExcelValues.data[1][Cap]};
		Process p1 = Runtime.getRuntime().exec(str1);

		Thread.sleep(2000);
		BufferedReader r = new BufferedReader(new FileReader(readExcelValues.data[1][Cap]));
		Thread.sleep(3000);
		while((line=r.readLine()) != null)
		{
			//System.out.println("Sys data is ::"+line);
			if(line.contains(readExcelValues.data[10][Cap])){
				String[] str2 ={"/bin/bash", "-c", readExcelValues.data[11][Cap] +readExcelValues.data[10][Cap]};
				Process p2 = Runtime.getRuntime().exec(str2);
				System.out.println("App uninstalled in the device and trying to install the app");
				break;
			}


		}
		//System.out.println("App not installed in the device and trying to install the app");
	}

	//install the app
	public static void installApp() throws Exception{
		readExcelValues.excelValues("Smoke","Paths");
		String[] str ={"/bin/bash", "-c", readExcelValues.data[12][Cap]+" " +Functions.ipaPath};
		Process p = Runtime.getRuntime().exec(str);

		Thread.sleep(50000);
		System.out.println("App was installed in the device successfully");
	}

	//navigatetoSettingPage or manage locations
	public static void navigatetoSettingPage() throws Exception{
		readExcelValues.excelValues("Smoke","Login");
		MobileElement Settings =null;
		try{
			//Settings =Ad.findElementByXPath(readExcelValues.data[1][Cap]);
			Settings =Ad.findElementByXPath(readExcelValues.data[1][Cap]);
			logStep("tapping Settings");
		}catch(Exception e){
			Settings =Ad.findElementByName("topNav settings");
			logStep("Settings option not found");
		}
		Settings.click();
	}

	//navigatetoSettingPage or manage locations
	public static void navigatetoAddressPage() throws Exception{
		readExcelValues.excelValues("Smoke","AddressPage");
		MobileElement addressPage =null;
		Thread.sleep(5000);	
		try{
			addressPage =Ad.findElementByName(readExcelValues.data[1][Cap]);
			logStep("Naviagate to Address Page");
		}catch(Exception e){
			addressPage =Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[2]");
			logStep("Naviagate to Address Page");
		}
		addressPage.click();
		MobileElement Address=null;
		try{
			Address =Ad.findElementByXPath(readExcelValues.data[2][Cap]);
			//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]

		}catch(Exception e){
			Address =Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[2]");

		}
		Addresseslist = Address.findElementsByClassName(readExcelValues.data[3][Cap]);
	}

	//Add New addresses
	public static void addnewAddress(String AdType) throws Exception{

		readExcelValues.excelValues("Smoke","AddressPage");
		String Zip=readExcelValues.data[10][Cap].trim().toString();
		String ChangedAddress=null;
		ChangedAddress = Ad.findElementByClassName("XCUIElementTypeStaticText").getText();
		if(AdType.equals("Detail")&&Zip.equals("null")){

			//Functions.ScrollUp_ToHomePage();
			Functions.put_Background_launcg();

		}else{
			System.out.println("Zip code is : "+Zip);
			String[]CityName=Zip.split(",");
			for(int i=1;i<=2;i++){
				if(Zip.equals("null")){

					System.out.println("Please verify ads on current location and Ad type is : "+readExcelValues.data[11][Cap]);

				}else{
					System.out.println("Please verify ads on specified location / Zip "+readExcelValues.data[10][Cap]+" and Ad type is : "+readExcelValues.data[11][Cap]);
					Ad.findElementByName(readExcelValues.data[1][Cap]).click();
					TempEle=Ad.findElementByClassName(readExcelValues.data[9][Cap]);
					TempEle.click();
					Thread.sleep(2000);
					TempEle.sendKeys(Zip);
					//down Keyboad
					Thread.sleep(2000);
					Ad.findElementByName("Search").click();
					//select first name in the list
					Thread.sleep(2000);
					try{
						Ad.findElementByName(Zip).click();
					}catch(Exception e){
						Ad.findElementByXPath(readExcelValues.data[8][Cap]).click();

					}
					Thread.sleep(8000); 
				}
				try{
					ChangedAddress = Ad.findElementByClassName("XCUIElementTypeStaticText").getText();
					//Ad.findElementByXPath("//XCUIElementTypeNavigationBar[@name=‘FSLocationCollectionView’]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeStaticText").getText();
					System.out.println("Changed address is "+ChangedAddress);
					System.out.println("Enter Address is :"+Zip);
					if(ChangedAddress.equalsIgnoreCase(Zip)){
						System.out.println(Zip+ "-  Address selected");
						break;
					}
				}catch(Exception e){
					System.out.println(Zip+ "-  Address is not selected");
				}
			}
		}

	}
	//Enter New when no address found addresses
	public static void enternewAddress_ifAddrssnotfound(String zip) throws Exception{
		if(zip.equals("null")){
			zip=readExcelValues.data[10][Cap];
		}
		readExcelValues.excelValues("Smoke","AddressPage");
		try{
			TempEle=Ad.findElementByClassName(readExcelValues.data[9][Cap]);
			if(!TempEle.isDisplayed()){
				System.out.println("User on CC page");	
			}else{
				System.out.println("User on Address select page");	
				logStep("Current location not found try to enter location");
				TempEle.click();
				TempEle.sendKeys(zip);
				//down Keyboad
				Thread.sleep(2000);
				Ad.findElementByName("Search").click();
				//select first name in the list
				Ad.findElementByXPath(readExcelValues.data[8][Cap]).click();
				Thread.sleep(2000); 
			}
		}catch(Exception e){

			System.out.println("User on CC page");
		}

	}



	//Enter New addresses
	public static void enternewAddress(String zip) throws Exception{
		Functions.put_Background_launcg();
		Thread.sleep(5000);
		readExcelValues.excelValues("Smoke","AddressPage");

		try{
			Thread.sleep(5000);
			TempEle=(MobileElement) Ad.findElementByClassName(readExcelValues.data[9][Cap]);
			if(!TempEle.isDisplayed()){
				Ad.findElementByName(readExcelValues.data[1][Cap]).click();
				TempEle=(MobileElement) Ad.findElementByClassName(readExcelValues.data[9][Cap]);
			}else{
				System.out.println("User on Address select page");	
			}
		}catch(Exception e){
			Ad.findElementByName(readExcelValues.data[1][Cap]).click();
			try {
				TempEle=(MobileElement) Ad.findElementByClassName(readExcelValues.data[9][Cap]);
			}catch(Exception e1) {
				TempEle=Ad.findElementByAccessibilityId("view_locationManagementSearchbar");
			}

		}
		TempEle.click();
		TempEle.click();
		Thread.sleep(1000);
		TempEle.sendKeys(zip);
		//Functions.clear_session();
		//down Keyboad
		Thread.sleep(5000);
		Ad.findElementByName("Search").click();
		//select first name in the list
		Ad.findElementByName(zip).click();
		logStep(zip+ " address Selected");
		//Ad.findElementByXPath(readExcelValues.data[8][Cap]).click();
		Thread.sleep(8000); 

	}
	//Verify saved address list
	public static void verifysavedAddresses() throws Exception{
		readExcelValues.excelValues("Smoke","AddressPage");
		int savedlistcount =Addresseslist.size()-2;
		System.out.println("Saved address list count is :"+savedlistcount);
		if(Addresseslist.size()>2){
			logStep("Saved address are found");
			for(int addresslist=1;addresslist<=Addresseslist.size()-2;addresslist++){
				int Count =addresslist+2; 
				//int TempEle = addresslist+1;
				String xyz = readExcelValues.data[4][Cap];
				//System.out.println("String xyz is "+xyz);
				String[] AddrestSplit =xyz.split("Count");
				xyz=AddrestSplit[0]+Count+AddrestSplit[1];

				SelectAddress = Ad.findElementByXPath(xyz);
				//readExcelValues.data[4][Cap]);
				String SavedAddress=SelectAddress.getText();
				System.out.println("Saved Address is  - "+SavedAddress);


			}	
		}


	}
	public static void contentmodemodule(String severemode) throws Exception{
		readExcelValues.excelValues("Smoke","MapLocal");
		File sourceFile,destinationFile = null;

		List<String> get_content_file_name = Functions.listFiles(readExcelValues.data[4][Cap]+severemode+"/");

		for (int i=0;i < get_content_file_name.size();i++)
		{
			if(get_content_file_name.get(i).equals("content-mode-severe.json")){

				sourceFile = new File(readExcelValues.data[4][Cap]+severemode+"/".concat(get_content_file_name.get(i)));
				destinationFile = new File(readExcelValues.data[3][Cap].concat(get_content_file_name.get(i)));
				//Remove Files From Destination Folder
				if(severemode.equals("normal")){
					FileUtils.cleanDirectory(new File(readExcelValues.data[3][Cap]));
					break;
				}
				else{
					//Copy  File From Source To Destination Folder
					FileUtils.cleanDirectory(new File(readExcelValues.data[3][Cap]));
					Thread.sleep(2000);
					FileUtils.copyFile(sourceFile, destinationFile);
					Thread.sleep(5000);
				}
				Thread.sleep(5000);
			}
		}

	}

	//Select multiple saved address one by one using addresscount value
	public static void selectsavedAddresses(int addresscount) throws Exception{

		logStep("Select "+addresscount +" saved address");
		if(Addresseslist.size()>2){
			pubads.clear();
			for(int addresslist=1;addresslist<=addresscount;addresslist++){

				Functions.delete_folder("Charles");
				//Functions.clear_session();

				readExcelValues.excelValues("Smoke","AddressPage");
				int Count =addresslist+2; 
				//int TempEle = addresslist+1;
				String xyz = readExcelValues.data[4][Cap];
				//System.out.println("String xyz is "+xyz);
				String[] AddrestSplit =xyz.split("Count");
				xyz=AddrestSplit[0]+Count+AddrestSplit[1];

				SelectAddress = Ad.findElementByXPath(xyz);
				//readExcelValues.data[4][Cap]);
				String SavedAddress=SelectAddress.getText();
				System.out.println("Selected saved Address is  - "+SavedAddress);
				SelectAddress.click();

				//Functions.charles_Stop();

				//				Functions.scroll_Down();
				//				Functions.scroll_Down();
				Thread.sleep(3000);
				Functions.downloadXMLFile();
				Functions.readXML();
				Functions.verifyPubadCalwithselectedAddress("Smoke","WFXTrigger");

				if(addresscount>1 && addresslist!=addresscount){
					navigatetoAddressPage();
				}else{
					System.out.println("");
				}


			}
		}

	}

	//clear Airlock Group
	public static void clearAirlock() throws Exception  {
		readExcelValues.excelValues("Smoke","TestMode");
		Ad.findElementByName(readExcelValues.data[24][Cap]).click();
		try {
			Ad.findElementByName("OK").click();
			System.out.println("Airlock filter Clear with OK");


		}catch(Exception e) {
			System.out.println("Airlock filter Clear");
		}
	}

	//clear Airlock Group
	public static void checkResponsiveMode() throws Exception  {
		readExcelValues.excelValues("Smoke","TestMode");
		WebElement responsiveSwitch = Ad.findElementByXPath(readExcelValues.data[25][Cap]);
		String responsiveswithVvalue=responsiveSwitch.getAttribute("value");
		if(responsiveswithVvalue.equals("1")) {
			System.out.println("Responsive Mode already enabled");
		}else {
			responsiveSwitch.click();
		}

	}

	//Put app in Background and relaunch
	public static void put_Background_launcg() throws Exception {
		try {
			Ad.runAppInBackground(3);
		} catch (WebDriverException e) {
			if (e.getMessage().contains("An error occurred while executing user supplied JavaScript")) {
			} else {
				throw new RuntimeException(e);
			}
		}

		//		ProcessBuilder pb = new ProcessBuilder("idevicedebug", "run", "com.weather.TWC");
		//		Thread.sleep(5000);
		//		Process p=pb.start();
		//		Thread.sleep(5000);
		//		p.destroy();
	}
	//Set app  into TestMode
	public static void Setappinto_TestMode(String TestMode) throws Exception
	{

		logStep("Verify bb ad call in Test mode");
		readExcelValues.excelValues("Smoke","TestMode");

		MobileElement el = null;
		Thread.sleep(2000);
		//Ad.findElementByXPath(readExcelValues.data[2][Cap]).click();
		try{
			Ad.findElementByName(readExcelValues.data[1][Cap]).click();
		}catch(Exception e){
			Ad.findElementByXPath("//XCUIElementTypeButton[@name='topNav settings']").click();
		}
		Thread.sleep(1000);
		Functions.scroll_Down();
		Thread.sleep(4000);
		MobileElement el2=(MobileElement) Ad.findElementByName(readExcelValues.data[6][Cap]);
		el2.click();
		Thread.sleep(1000);
		for(int i=1;i<=10;i++)
		{
			Ad.findElementByName(readExcelValues.data[11][Cap]).click();
		}
		//Select About This app
		Ad.findElementByName(readExcelValues.data[12][Cap]).click();
		//Enable Responsive Mode
		checkResponsiveMode();
		//Select UserGroup

		Ad.findElementByName(readExcelValues.data[16][Cap]).click();
		Thread.sleep(20000);
		//		WebDriverWait wait = new WebDriverWait(Ad,25);
		//		//verify first airlock group presented
		//		WebElement airlockFirstGroup=wait.until(ExpectedConditions.visibilityOf(Ad.findElementByXPath("//XCUIElementTypeSwitch[@name='1554-GeoIP']")));
		MobileElement AdsTestSwitch = null;
		String SwitchValue = null;
		if(TestMode.equals("Select")) {
			clearAirlock();
			//Select Test Group

			Ad.findElementByClassName("XCUIElementTypeSearchField").sendKeys("AdsTestAdUnitOnly");
			try {
				AdsTestSwitch =	Ad.findElementByXPath(readExcelValues.data[23][Cap]+"AdsTestAdUnitOnly']");
			}catch(Exception e) {
				//Back to AirlockGroup 
				Ad.findElementByName(readExcelValues.data[22][Cap]).click();
				//Select UserGroup

				Ad.findElementByName(readExcelValues.data[16][Cap]).click();
				Thread.sleep(20000);
				AdsTestSwitch =	Ad.findElementByXPath(readExcelValues.data[23][Cap]+"AdsTestAdUnitOnly']");

			}
			SwitchValue =	AdsTestSwitch.getAttribute("value");
			if(SwitchValue.equals("1")) {
				System.out.println("Test Mode already enabled");
			}else {
				AdsTestSwitch.click();
			}
			try {
				Ad.findElementByName("Cancel").click();
			}catch(Exception e) {
				Ad.findElementByName("Done").click();
			}
			//Ad.findElementByXPath(readExcelValues.data[23][Cap]).click();
		}else if(TestMode.equals("nativeAd")) {
			//clearAirlock();
			//Select Test Group

			Ad.findElementByClassName("XCUIElementTypeSearchField").sendKeys("Vishal_Native");
			try {
				AdsTestSwitch =	Ad.findElementByXPath(readExcelValues.data[23][Cap]+"Vishal_Native']");

			}catch(Exception e) {
				//Back to AirlockGroup 
				Ad.findElementByName(readExcelValues.data[22][Cap]).click();
				//Select UserGroup

				Ad.findElementByName(readExcelValues.data[16][Cap]).click();
				Thread.sleep(20000);
				AdsTestSwitch =	Ad.findElementByXPath(readExcelValues.data[23][Cap]+"Vishal_Native']");
			}
			SwitchValue =	AdsTestSwitch.getAttribute("value");
			if(SwitchValue.equals("1")) {
				System.out.println("vishal_Native config already enabled");
			}else{
				AdsTestSwitch.click();

			}
			try {
				Ad.findElementByName("Cancel").click();
			}catch(Exception e) {
				Ad.findElementByName("Done").click();
			}
		}else if(TestMode.equals("nativeBB")) {
			//clearAirlock();
			//Select Test Group

			Ad.findElementByClassName("XCUIElementTypeSearchField").sendKeys("IOS-843-NativeBB");
			try {
				AdsTestSwitch =	Ad.findElementByXPath(readExcelValues.data[23][Cap]+"IOS-843-NativeBB']");
			}catch(Exception e) {
				//Back to AirlockGroup 
				Ad.findElementByName(readExcelValues.data[22][Cap]).click();
				//Select UserGroup

				Ad.findElementByName(readExcelValues.data[16][Cap]).click();
				Thread.sleep(20000);
				AdsTestSwitch =	Ad.findElementByXPath(readExcelValues.data[23][Cap]+"IOS-843-NativeBB']");
			}
			SwitchValue =	AdsTestSwitch.getAttribute("value");
			if(SwitchValue.equals("1")) {
				System.out.println("IOS-843-NativeBB config already enabled");
			}else{
				AdsTestSwitch.click();

			}
			try {
				Ad.findElementByName("Cancel").click();
			}catch(Exception e) {
				Ad.findElementByName("Done").click();
			}
		}else{
			clearAirlock();

		}

		//Back to AirlockGroup 
		Ad.findElementByName(readExcelValues.data[22][Cap]).click();
		//Back to About  this page
		Ad.findElementByName(readExcelValues.data[18][Cap]).click();

		//Save the settings
		Ad.findElementByName(readExcelValues.data[19][Cap]).click();

		Thread.sleep(3000);
		try{
			Ad.closeApp();
			Ad.launchApp();
		}catch(Exception e){
			Functions.close_launchApp();
		}
		//app set to Test mode

		readExcelValues.excelValues("Smoke","TestMode");
		Thread.sleep(5000);
		try{
			System.out.println("excel data :"+readExcelValues.data[1][Cap]);
			if(Ad.findElementByName(readExcelValues.data[1][Cap]).isDisplayed()){
				//Select Addresss
				Ad.findElementByName(readExcelValues.data[20][Cap]).click();
				logStep("Select Address page");
			}else{
				System.out.println("User already on address search page");
				logStep("User already on address search page");
			}
			System.out.println("Searching for address");
			//			Ad.findElementByClassName("UIASearchBar").click();
			//			Ad.findElementByClassName("UIASearchBar").sendKeys("08302");
			//
			//			Thread.sleep(2000);
			//			Ad.findElementByName("Search").click();
			//			//Ad.navigate().back();
			//
			//			Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
			//			Thread.sleep(2000);
			//			//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]").click();
			//			Thread.sleep(3000);    
			//	Functions.enternewAddress(readExcelValues.data[21][Cap]);
			System.out.println("Address entered and searched");
		}catch (Exception e){
			System.out.println("Address already presented");
		}



	}
	public static void ScreenShot(String Adtype,String ScreenType) throws Exception{
		ScreenShot = System.getProperty("user.dir")+"/screenshots";
		if(ScreenType.equals("Passed")){

			File Screenshot = ((TakesScreenshot)Ad).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Screenshot, new File(ScreenShot+"/"+BuildNo+"/ScreenShot_"+ScreenType+" "+Adtype+".png"));
		}else{
			File Screenshot = ((TakesScreenshot)Ad).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(Screenshot, new File(ScreenShot+"/"+BuildNo+"/ScreenShot_"+ScreenType+" "+Adtype+".png"));
			FileUtils.copyFile(Screenshot, new File(ScreenShot+"/Failed/ScreenShot_"+ScreenType+" "+Adtype+".png"));

		}
	}
	//Feed ad validation
	public static void Feed_Ad_Validation(int feed) throws Exception{
		SoftAssert softAssert = new SoftAssert();
		MobileElement AdView = null;
		readExcelValues.excelValues("Smoke","Paths");
		System.out.println("*********************** Started Validating for feed_"+feed+" ad ****************");
		FeedValue=feed;
		if(ModuleName.equals("NOW")||ModuleName.equals("LIVE")||ModuleName.contains("now")) {
			if(feed==0){
				System.out.println("User on Home screen finding Feed_"+feed);
			}else if(feed==4||feed==4||feed==4||feed==4||feed==5){
				Functions.scroll_Down();
				Functions.scroll_Down();
				System.out.println("User on Home screen finding Feed_"+feed);
			}else{
				Functions.scroll_Down();
				System.out.println("User on Home screen finding Feed_"+feed);
			}
		}else{
			if(feed==0){
				System.out.println(" on Home screen finding Feed_"+feed);
			}else if(feed==3||feed==3||feed==3||feed==3||feed==3){
				Functions.scroll_Down();
				Functions.scroll_Down();
				System.out.println("User on Home screen finding Feed_"+feed);
			}else{
				Functions.scroll_Down();
				System.out.println("User on Home screen finding Feed_"+feed);
			}
		}

		for(int CelView=1;CelView<=5;CelView++){
			if(feed==0){
				try{
					try{
						Functions.returnToWeather();
						AdView=(MobileElement)Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell["+CelView+"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]");

					}catch(Exception e){
						Functions.returnToWeather();
						AdView = Ad.findElementByXPath("//XCUIElementTypeApplication[@name='The Weather']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[3]/XCUIElementTypeOther[3]/XCUIElementTypeOther");
					}
					System.out.println("Feed_"+feed+" Ad present on the screen and Size is : "+AdView.getSize());
					ScreenShot("Feed_"+feed,"Passed");
					break;
				}catch(Exception e){
					System.out.println("Feed_"+feed+" Ad not presented on the screen");
					//File Screenshot = ((TakesScreenshot)Ad).getScreenshotAs(OutputType.FILE);
					ScreenShot("Feed"+feed,"Failed");
					softAssert.fail("Feed_"+feed+"Ad Not prsent on the screen");
					break;
				}
			}else{

				try{
					Functions.returnToWeather();
					if(feed==4) {
						try {
							AdView = Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell["+CelView+"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]");
						}catch(Exception e) {
							Functions.scroll_Down();
							AdView = Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell["+CelView+"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]");
						}
					}else {
					AdView = Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell["+CelView+"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]");
					}
					//System.out.println("Feed_"+feed+" Ad present on the screen and Size is : "+AdView.getSize());
					if(feed==1||feed==3||feed==5){

						if(AdView.getSize().toString().equals("(301, 250)")||AdView.getSize().toString().equals("(300, 250)")||AdView.getSize().toString().equals("(301, 251)")||AdView.getSize().toString().equals("(300, 251)")){
							if(AdView.isDisplayed()){
								System.out.println("Feed_"+feed+" Ad present on the screen and Size is : "+AdView.getSize());
								ScreenShot("Feed_"+feed,"Passed");
								break;
							}else{
								Functions.scroll_Down();
								System.out.println("Feed_"+feed+" Ad present on the screen and Size is : "+AdView.getSize());
								ScreenShot("Feed_"+feed,"Passed");
								break;
							}
						}
					}else {

						if(AdView.getSize().toString().equals("(321, 51)")||AdView.getSize().toString().equals("(320, 50)")||AdView.getSize().toString().equals("(321, 50)")||AdView.getSize().toString().equals("(320, 51)")){
							System.out.println("Feed_"+feed+" Ad present on the screen and Size is : "+AdView.getSize());
							if(AdView.isDisplayed()){

								ScreenShot("Feed_"+feed,"Passed");
								break;
							}else {
								Functions.scroll_Down();
								if(AdView.isDisplayed()){

									//System.out.println("Feed_"+feed+" Ad present on the screen and Size is : "+AdView.getSize());
									ScreenShot("Feed_"+feed,"Passed");
									break;

								}else{
									Functions.scroll_Down();
									//System.out.println("Feed_"+feed+" Ad present on the screen and Size is : "+AdView.getSize());
									ScreenShot("Feed_"+feed,"Passed");
									break;
								}
							}
						}
					}

				}catch(Exception e){
					System.out.println("Feed_"+feed+" Ad not presented on the screen");

				}
				if(CelView==5){
					File Screenshot = ((TakesScreenshot)Ad).getScreenshotAs(OutputType.FILE);
					ScreenShot("Feed_"+feed,"Failed");
					softAssert.fail("Feed_"+feed+"Ad Not prsent on the screen");
				}
			}

		}
		softAssert.assertAll();

	}

	//Check BN Enabled or not
	public static void check_BN_enabled() throws Exception {
		//Functions.scroll_Down();
		MobileElement Modules=null;
		String moduleName=null;

		try {
			//Modules = (MobileElement)  Ad.findElementByXPath("(//XCUIElementTypeStaticText[@name=\"label_callToAction\"])[1]");
			Modules = Ad.findElementByName("breaking-news-card");
			//breaking-news-card
			ModuleName=Modules.getAttribute("value");
			System.out.println("ModuleName is : "+ModuleName);
			if(ModuleName.equals("NOW")||ModuleName.equals("LIVE")) {

				System.out.println("Breaking News Module not enabled");
			}else {
				System.out.println("Breaking News Module enabled");
			}
		}catch(Exception e) {
			Modules = Ad.findElementByName("right-now-card");
			ModuleName=Modules.getAttribute("value");
			System.out.println("ModuleName is : "+ModuleName);
			if(ModuleName.equals("NOW")||ModuleName.equals("LIVE")||ModuleName.contains("now")) {

				System.out.println("Breaking News Module not enabled");
			}else {
				System.out.println("Breaking News Module enabled");
			}

		}
	}

	//Select Address
	public static void select_adressFromList(){

		MobileElement Saveedaddresspage = Ad.findElementByXPath("//XCUIElementTypeApplication[@name=‘The Weather’]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable");

	}

	//Delete Charles session xml files
	public static void delete_folder(String folderType) throws Exception{
		readExcelValues.excelValues("Smoke","Paths");
		String downloadPath = null;

		if(folderType.equals("Charles")){
			downloadPath = readExcelValues.data[4][Cap];
		}else{
			downloadPath = readExcelValues.data[18][Cap];
		}

		//String Screenshots = readExcelValues.data[16][Cap];

		File index = new File(downloadPath);


		if (!index.exists()) {
			System.out.println("Specified charles session folder is not exist and creating the same folder now");
			index.mkdir();
		} else {
			System.out.println("Specified charles session folder is exist and deleting the same folder");
			FileUtils.cleanDirectory(index);
			System.out.println("Deleted all the files in the specified charles session folder");
		}

	}


	//Delete Screenshots session xml files
	public static void delete_screenshots() throws Exception{
		readExcelValues.excelValues("Smoke","Paths");
		ScreenShot = System.getProperty("user.dir")+"/screenshots";

		String downloadPath = ScreenShot+"/Failed";
		//String Screenshots = readExcelValues.data[16][Cap];

		File index = new File(downloadPath);
		//File Screenindex= new File(Screenshots);

		if (!index.exists()) {
			System.out.println("Specified ScreenShot folder is not exist and creating the same folder now");
			index.mkdir();
		} else {
			System.out.println("Specified ScreenShot folder is exist and deleting the same folder");
			FileUtils.cleanDirectory(index);
			System.out.println("Deleted all the files in the specified ScreenShot folder");
		}

	}



	//Download ap from HockeyApp
	public static void delete_IPA() throws Exception{
		readExcelValues.excelValues("Smoke","Paths");

		String App = readExcelValues.data[14][Cap];
		String AppPath = readExcelValues.data[15][Cap];

		File index = new File(AppPath);
		File f = new File(App);
		try{
			System.out.println("file Size is:"+FileUtils.sizeOf(f));
		}catch(Exception e){
			System.out.println("Ipa file not available in the path");
		}
		if (!index.exists()) {
			System.out.println("Specified folder is not exist and creating the same folder now");
			index.mkdir();
		} else {
			System.out.println("Specified folder is exist and deleting the same folder");
			System.out.println("File name :"+FileUtils.sizeOf(index));
			FileUtils.cleanDirectory(index);
			System.out.println("Deleted all the files in the specified folder");

		}
	}

	//Verify App downloaded or not
	public static void Verify_IPA() throws Exception{
		readExcelValues.excelValues("Smoke","Paths");


		String App = readExcelValues.data[14][Cap];
		String AppPath = readExcelValues.data[15][Cap];
		File indexPath =  new File(AppPath);
		File file = new File(App);
		long Size = FileUtils.sizeOf(file);
		System.out.println("File Size is :"+Size);

		for(int i=1;i<=40;i++){
			if(FileUtils.sizeOf(file)>1){
				System.out.println("ipa File Downloaded ");
				driver_ipa.close();
				Thread.sleep(1000);
				break;
			}else{
				Thread.sleep(10000);
			}
		}

	}

	//Open Charless session and control from Browser
	public static void startCharlesSession() throws Exception{


		//Open Charles Using Terminal
		String[] openCharles_str ={"/bin/bash", "-c", "open -a CharlesiOS"};
		Runtime.getRuntime().exec(openCharles_str);	
		Thread.sleep(10000);
		//Download app from Hockey
		//Close App download until next release
		//Functions.app_download_from_hockeyapp();
		Functions.listFilesForFolder(Functions.folder);
		//Check build folder
		Functions.CheckBuildFolder(Functions.folder);

		//Functions.delete_folder("Charles");

		String downloadPath = readExcelValues.data[4][Cap];

		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.http", "192.168.1.24");
		profile.setPreference("network.proxy.http_port", 8111);

		profile.setPreference("browser.download.folderList", 2);

		profile.setPreference("browser.download.dir", downloadPath+"/"+BuildNo);

		profile.setPreference("browser.helperApps.neverAsk.openFile","text/xml,application/x-octet-stream");
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/xml,application/x-octet-stream");


		driver_ios = new FirefoxDriver(profile);
		Thread.sleep(2000);
		driver_ios.manage().window().maximize();
		driver_ios.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		//driver.get("http://mohantestengg:123456@control.charles");
		driver_ios.get(readExcelValues.data[9][1]);

		readExcelValues.excelValues("Smoke","Charlesdeatils");
		Thread.sleep(1000);
		driver_ios.findElement(By.linkText(readExcelValues.data[1][0])).click();
		//		Thread.sleep(1000);
		//		driver_ios.findElement(By.linkText(readExcelValues.data[2][0])).click();
		//		Thread.sleep(1000);
		//		driver_ios.findElement(By.linkText(readExcelValues.data[3][0])).click();
		//		Thread.sleep(1000);
		//		driver_ios.findElement(By.linkText(readExcelValues.data[4][0])).click();
		//
		//		//Start the Charles session
		//		Thread.sleep(1000);
		//		driver_ios.findElement(By.linkText(readExcelValues.data[5][0])).click();
		//
		//		Thread.sleep(1000);
		//		driver_ios.findElement(By.linkText(readExcelValues.data[3][0])).click();
		//		Thread.sleep(1000);
		//		driver_ios.findElement(By.linkText(readExcelValues.data[1][0])).click();
	}
	//Open Charles controller for Stop
	public static void clear_session() throws Exception{
		readExcelValues.excelValues("Smoke","Charlesdeatils");
		Thread.sleep(1000);
		driver_ios.findElement(By.linkText(readExcelValues.data[2][0])).click();
		Thread.sleep(1000);
	}

	//Navigate to WIDGET PAGE
	public static void navigateto_Widgetpage() throws Exception{
		//Swinpe Status bar for notification screen
		logStep("Swip for weather Widget");
		Ad.swipe(0, 0, 0, 300, 2000);
		//Find Weather Widget option
		Ad.swipe(0, 80, 400, 80, 2000);

		int WidgetPlace;
		try{
			Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]").click();
			logStep("Weather Widgent found and tapped");
			//Ad.findElement(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther["+WidgetPlace+"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]")).click();
		}catch(Exception e){
			logStep("Weather Widgent not found");
		}
		try{
			Ad.findElementByName("Open").click();
		}catch(Exception e){

		}

		Dimension dimensions = Ad.manage().window().getSize();
		Double startY1 = (double) dimensions.getHeight(); 
		System.out.println("Y value is :"+startY1);
		startY1 = (double) (dimensions.getHeight() -20);  
		System.out.println("After Y"+startY1);
		startY = startY1.intValue();
		int y =startY1.intValue();
		//				Double endY1 = (double) (dimensions.getHeight()/40);  //  dimensions.getHeight()  0.2;  == 512.0
		//				endY = endY1.intValue()

		//			WebDriverWait wait = new WebDriverWait(Ad,15);
		//			WebElement WeatherChannel = wait.until(ExpectedConditions.elementToBeClickable(Ad.findElementByName("The Weather Channel")));
		Functions.clear_session();
		Ad.tap(1, 10, y, 2000);
		logStep("Tap on weather channel icon on weather widget");
		//			Actions builder = new Actions(driver);   
		//			//builder.moveToElement(WeatherChannel,10,y).click().build().perform();
		//			//builder.moveByOffset(10, y).click().build().perform();
		//			builder.moveByOffset(10, y).clickAndHold().build().perform();


	}

	//Navigate Back to WIDGET PAGE
	public static void navigateto_BackWidgetpage() throws Exception{

		//Swinpe Status bar for notification screen
		Ad.swipe(0, 0, 0, 300, 2000);
		//Find Weather Widget option
		Ad.swipe(0, 80, 400, 80, 2000);
		int WidgetPlace;
		//Select Weather widget in notifications
		String WidgetName =null;
		for(WidgetPlace=1;WidgetPlace<=6;WidgetPlace++){
			try{
				WidgetName = Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther["+WidgetPlace+"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeButton[1]").getText();
				if(WidgetName.equals("WEATHER")){
					System.out.println("WEATHER Widget found");
					System.out.println("Location of Widget is :"+WidgetPlace);
					break;
				}else{
					System.out.println("WEATHER widget not found search for widget");
				}
			}catch (Exception e){
				System.out.println("WEATHER widget not found for first time search / Scroll for widget");
				Ad.swipe(50, 200, 50, 80, 2000);
				WidgetPlace=WidgetPlace-1;
			}

		}

		Ad.findElement(By.xpath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeScrollView[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther["+WidgetPlace+"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[1]")).click();

		try{
			Ad.findElementByName("Open").click();
		}catch(Exception e){

		}

		Dimension dimensions = Ad.manage().window().getSize();
		Double startY1 = (double) dimensions.getHeight(); 
		System.out.println("Y value is :"+startY1);
		startY1 = (double) (dimensions.getHeight() -20);  
		System.out.println("After Y"+startY1);
		startY = startY1.intValue();
		int y =startY1.intValue();
		//				Double endY1 = (double) (dimensions.getHeight()/40);  //  dimensions.getHeight()  0.2;  == 512.0
		//				endY = endY1.intValue()

		//			WebDriverWait wait = new WebDriverWait(Ad,15);
		//			WebElement WeatherChannel = wait.until(ExpectedConditions.elementToBeClickable(Ad.findElementByName("The Weather Channel")));
		Ad.tap(1, 10, 6, 2000);
		//			Actions builder = new Actions(driver);   
		//			//builder.moveToElement(WeatherChannel,10,y).click().build().perform();
		//			//builder.moveByOffset(10, y).click().build().perform();
		//			builder.moveByOffset(10, y).clickAndHold().build().perform();


	}

	public static void validateWidgetLogs() throws Exception{
		Functions.delete_folder("Charles");
		//Functions.clear_session();
		//Functions.close_launchApp();
		Functions.Scroll_end();
		Functions.downloadXMLFile();
		Functions.clear_sb();
		Functions.readXML();
		Functions.Verify_feedcals("CleanLaunch");
	}
	//Open Charles controller for Stop
	public static void charles_Stop() throws Exception{
		readExcelValues.excelValues("Smoke","Charlesdeatils");
		Thread.sleep(1000);
		//driver.findElement(By.linkText(readExcelValues.data[6][0])).click();
		Thread.sleep(1000);
		driver_ios.findElement(By.linkText(readExcelValues.data[3][0])).click();
		Thread.sleep(1000);
		driver_ios.findElement(By.linkText(readExcelValues.data[1][0])).click();

	}

	//Download XML file
	public static void downloadXMLFile() throws Exception{
		Thread.sleep(5000);
		readExcelValues.excelValues("Smoke","Charlesdeatils");
		Thread.sleep(1000);
		driver_ios.findElement(By.linkText(readExcelValues.data[7][0])).click();
		Thread.sleep(2000);
		System.out.println("Export file");
		//driver.navigate().to(readExcelValues.data[3][0]);
		Thread.sleep(5000);
		//driver.close();
	}

	//Read XML File
	public static void readXML() throws Exception{

		readExcelValues.excelValues("Smoke","Paths");

		//Read the file name from the folder
		File folder = new File(readExcelValues.data[4][Cap]);
		File[] listOfFiles = folder.listFiles();
		String Filename = null;
		for (File file : listOfFiles) {
			if (file.isFile()) {
				Filename = file.getName();
				System.out.println("File Name is : "+Filename);
			}
		}

		File file = new File(readExcelValues.data[4][Cap]+Filename);

		BufferedReader r = new BufferedReader(new FileReader(file));

		String line = "";
		String allLine = "";
		while((line=r.readLine()) != null)
		{
			//			if(line.length()==256){
			//				System.out.println("String length is more the normal value");
			//			}else{
			sb.append(line.trim());
			//System.out.println(line);
			//}
		}
		String	req =null;
		String pubreq=null; 
		String pubreq1 = null;
		//System.out.println(sb);
		System.out.println("data read finished");
		r.close();
	}	

	//Clear stringbuffer
	public static void clear_sb(){
		sb=sb.delete(0, sb.length());
	}

	//Verify single Param Value from pubad call from XML File
	public static void verifyParamsFromPubadCal(String Excelname,String sheetName) throws Exception{
		//container=null;
		readExcelValues.excelValues(Excelname,sheetName);
		VerifypubadValues =readExcelValues.data[16][Cap];
		//System.out.println("Pubad values are -"+VerifypubadValues);
		for(String pubreq2:pubads){
			String str[] = pubreq2.split("&");
			if(readExcelValues.data[16][Cap].contains(",")){
				String[] splitPubvalues= VerifypubadValues.split(",");
				for(int i=0;i<=splitPubvalues.length-1;i++){
					System.out.println("Pubad value is -"+splitPubvalues[i].toString()+"----Size is"+splitPubvalues.length);
					for (String ssss : str) {
						String s[] = ssss.split("=");

						if (s[0].equals(splitPubvalues[i].toString())) {
							if(i==0){
								pubadvalues.clear();
								firstParamValue = s[1].toString();
								System.out.println(splitPubvalues[i]  +" Param value is :" + firstParamValue);
								pubadvalues.add(firstParamValue);
								Thread.sleep(1000);
								System.out.println("all first Param value is :" + pubadvalues);

							}else if(s[0].equals("cxtg"))
							{
								cxtgcontainer.clear();
								seg = s[1].toString();
								System.out.println("seg is :"+seg);
								seg=seg.replaceAll(",",", ");
								cxtgcontainer.add(seg);
								System.out.println("CXTG Container is:" + cxtgcontainer);

							}else if(s[0].equals("nzcs"))
							{
								nzcscontainer.clear();
								seg = s[1].toString();
								System.out.println("seg is :"+seg);
								seg=seg.replaceAll(",",", ");
								nzcscontainer.add(seg);
								System.out.println("nzcs Container is:" + nzcscontainer);

							}else if(s[0].equals("hzcs"))
							{
								hzcscontainer.clear();
								seg = s[1].toString();
								System.out.println("seg is :"+seg);
								seg=seg.replaceAll(",",", ");
								hzcscontainer.add(seg);
								System.out.println("hzcs Container is:" + hzcscontainer);

							}else if(s[0].equals("zcs"))
							{
								zcscontainer.clear();
								seg = s[1].toString();
								System.out.println("seg is :"+seg);
								seg=seg.replaceAll(",",", ");
								zcscontainer.add(seg);
								System.out.println("zcs Container is:" + zcscontainer);

							}else if(s[0].equals("wfxtg"))
							{
								wfxtgcontainer.clear();
								seg = s[1].toString();
								System.out.println("seg is :"+seg);
								seg=seg.replaceAll(",",", ");
								wfxtgcontainer.add(seg);
								System.out.println("WFXTG Container is:" + wfxtgcontainer);

							}else
							{
								seg = s[1].toString();
								String[] items = seg.split(",");
								container = Arrays.asList(items);
								System.out.println("Container is:" + container);
								System.out.println("Container size is:" + container.toString().length());
							}
						}
					}
				}
			}
			else
			{
				for (String ssss : str) {
					String s[] = ssss.split("=");

					if (s[0].equals(VerifypubadValues.toString())) {
						firstParamValue = s[1].toString();
						System.out.println(VerifypubadValues +"Param value is :" + firstParamValue);
					}

				}

			}
		}
	}
	//Verify pubad call from XML File
	public static void verifyPubadCalwithselectedAddress(String Excelname,String sheetName) throws Exception{
		readExcelValues.excelValues(Excelname,sheetName);
		//Get Pubad call from 

		if(sb.toString().contains(readExcelValues.data[17][Cap])){
			System.out.println("bb ad call is pressent");

			pubadcal = sb.toString().substring(sb.toString().lastIndexOf(readExcelValues.data[17][Cap]));
			//System.out.println("pubad call is :"+pubadcal);

			pubreq1 = pubadcal.toString().substring(pubadcal.toString().indexOf(readExcelValues.data[7][Cap]));

			pubreq1= pubreq1.toString().replaceAll(readExcelValues.data[8][Cap], "=");
			pubreq1= pubreq1.toString().replaceAll(readExcelValues.data[9][Cap], "&");
			pubreq1= pubreq1.toString().replaceAll(readExcelValues.data[10][Cap], ",");
			int sizeparam = readExcelValues.data[14][Cap].length();
			pubreq1 = pubreq1.substring(pubreq1.indexOf(readExcelValues.data[14][Cap])+sizeparam,pubreq1.indexOf(readExcelValues.data[15][Cap]));
			//System.out.println("feed call zip is "+ pubreq1.toString());
			pubads.add(pubreq1.toString());
			System.out.println("feed call data is "+ pubads);

		}
		else{
			System.out.println("bb ad call is not pressent");
			Assert.fail("bb ad call is not pressent");
		}


		verifyParamsFromPubadCal(Excelname,sheetName);
	}

	//Verify pubad call from XML File
	public static void verifyPubadCal(String Excelname, String sheetName) throws Exception{
		readExcelValues.excelValues(Excelname,sheetName);
		//Get Pubad call from 
		pubads.clear();

		if(Functions.sb.toString().contains(readExcelValues.data[17][Cap])){
			System.out.println("ad call is pressent");

			pubadcal = sb.toString().substring(sb.toString().lastIndexOf(readExcelValues.data[17][Cap]));
			//System.out.println("pubad call is :"+pubadcal);
			try{
				pubreq1 = pubadcal.toString().substring(pubadcal.toString().indexOf(readExcelValues.data[7][Cap]));
			}catch(Exception e){
				pubreq1 = pubadcal.toString().substring(pubadcal.toString().indexOf("slotname"));
			}
			if(pubreq1.contains(readExcelValues.data[8][Cap]) || pubreq1.contains(readExcelValues.data[9][Cap])||pubreq1.contains(readExcelValues.data[10][Cap])){
				pubreq1= pubreq1.toString().replaceAll(readExcelValues.data[8][Cap], "=");
				pubreq1= pubreq1.toString().replaceAll(readExcelValues.data[9][Cap], "&");
				pubreq1= pubreq1.toString().replaceAll(readExcelValues.data[10][Cap], ",");
				pubreq1= pubreq1.toString().replaceAll("%2F", "/");

			}else{
				System.out.println("not a ad call");
			}
			int sizeparam = readExcelValues.data[14][Cap].length();
			pubreq1 = pubreq1.substring(pubreq1.indexOf(readExcelValues.data[14][Cap])+sizeparam,pubreq1.indexOf(readExcelValues.data[15][Cap]));
			//System.out.println("feed call zip is "+ pubreq1.toString());
			pubreq1=pubreq1.replaceAll("/7646/app_iphone_us/" ,"");
			if(Excelname=="Smoke"){
				pubreq1=pubreq1.toString();
			}else{
				pubreq1=pubreq1.replaceAll("^\"|:\"$","");
				pubreq1=pubreq1.replaceAll("\"","");
				pubreq1=pubreq1.replaceAll(",","&");
				//pubreq1=pubreq1.replaceAll(":","=");
			}try{
				if(VideoAdzone.equals("Video")){
					pubads_video.add(pubreq1.toString());
				}
			}catch(Exception e)
			{
				pubads.add(pubreq1.toString());
			}
			//System.out.println("feed call zip is "+ pubads);
			RetryAnalyzer.count=0;
			logStep("BB ad call presented ");
		}
		else{
			System.out.println("bb ad call is not pressent");
			Functions.navBack_fromExtendedPage("PreRollVideo");
			logStep("bb ad call is not pressented");
			Assert.fail("bb ad call is not pressent");

		}
		verifyParamsFromPubadCal(Excelname,sheetName);
	}


	public static void verify_bbadcall(String Excelname, String sheetName,String Severetype) throws Exception{

		readExcelValues.excelValues(Excelname,sheetName);
		//Get Pubad call from 
		pubads.clear();
		try{
			if(Severetype.equals("severe1")){
				try{
					if(Functions.sb.toString().contains(readExcelValues.data[1][Cap])){
						System.out.println("ad call is pressent");
						logStep("BB ad call presented ");
					}
					else{
						System.out.println("bb ad call is not pressent");

						logStep("bb ad call is not pressented");
						Assert.fail("bb ad call is not pressent");

					}
				}catch(Exception e){
					System.out.println("bb ad call is not pressent");

					logStep("bb ad call is not pressented");
					Assert.fail("bb ad call is not pressent");
				}
			}else if(Severetype.equals("severe2")){
				try{
					if(Functions.sb.toString().contains(readExcelValues.data[1][Cap])){
						System.out.println("ad call is pressent");
						logStep("BB ad call presented, call should not be genarated");
						Assert.fail("BB ad call presented, call should not be genarated");
					}
					else{
						System.out.println("bb ad call is not pressent");
						logStep("bb ad call is not pressented");


					}
				}catch(Exception e1){
					System.out.println("bb ad call is not pressent");

					logStep("bb ad call is not pressented");

				}
			}
		}catch(Exception e2){

			System.out.println("Not sev mode");
		}
	}



	//	//Verify single Param Value from pubad call from XML File
	//	public static void verifySingleParamFromPubadCal(String firstParam) throws Exception{
	//
	//		String str[] = pubreq1.split("&");
	//		for (String ssss : str) {
	//			String s[] = ssss.split("=");
	//			if (s[0].equals(firstParam)) {
	//				firstParamValue = s[1].toString();
	//				System.out.println(firstParam +"Param value is :" + firstParamValue);
	//
	//			}
	//		}
	//	}

	//	//Verify Two Param Values from pubad call from XML File
	//	public static void verifyTwoParamsFromPubadCal(String firstParam,String SecondParam) throws Exception{
	//		String str[] = pubreq1.split("&");
	//		for (String ssss : str) {
	//			String s[] = ssss.split("=");
	//			if (s[0].equals(firstParam)) {
	//				firstParamValue = s[1].toString();
	//				System.out.println(firstParam +"Param value is :" + firstParamValue);
	//
	//			}
	//			if (s[0].equals(SecondParam)) {
	//
	//				SecondParamValue  = s[1].toString();
	//				String[] items = SecondParamValue.split(",");
	//				container = Arrays.asList(items);
	//				System.out.println("Container is:" + container);
	//			}
	//		}
	//	}

	//Verify API call from XML File
	public static void verifyAPICal(String SheetName) throws Exception{

		//readXML();
		readExcelValues.excelValues("Smoke",SheetName);
		//Get Pubad call from 
		//for(int APIlist=1;APIlist<=whichAPI;APIlist++){
		String ApiCall=null;
		try{
			ApiCall = sb.toString().substring(sb.toString().lastIndexOf(readExcelValues.data[2][Cap]));
			logStep("Api Call Found");
		}catch(Exception e){
			logStep("Api Call not Found");
		}
		String req1 = ApiCall.toString().substring(ApiCall.toString().indexOf(readExcelValues.data[3][Cap]));
		//System.out.println("Req1 data is "+req1.toString());
		req = req1.toString().substring(req1.indexOf(readExcelValues.data[4][Cap])+7,req1.indexOf(readExcelValues.data[5][Cap])-2);
		//System.out.println("file is "+ req.toString());
		//}
	}

	//Verify WFXTG From Api
	public static void verify_wfxtg(String sheetName) throws Exception{
		readExcelValues.excelValues("Smoke",sheetName);
		logStep("Validate WFXTG Values");
		String WfxTrigeer = req.toString().substring(req.indexOf("current")+10,req.indexOf("scatterSegs")-4);
		WfxTrigeer = WfxTrigeer.replaceAll("^\"|:\"$","");

		System.out.println("WfxTrigeer is :"+WfxTrigeer.toString());
		wfxcontainer = WfxTrigeer.toString().split(",");
		for(String wfxcontainerkey : wfxcontainer ){
			if(wfxtgcontainer.toString().contains(wfxcontainerkey.toString())){
				//System.out.println("Values are matched with : "+wfxcontainerkey.toString()+"----"+WfxTrigeer.toString());
				params_val = "Pass";
				RetryAnalyzer.count=0;
				logStep("wfxtg Values are matched");
			}else if(wfxcontainerkey.equals("nl")){
				//System.out.println("Values are matched with : "+wfxcontainerkey.toString()+"----"+WfxTrigeer.toString());
				params_val = "Pass";
				logStep("wfxtg Values are matched");
				RetryAnalyzer.count=0;
			}else{
				//	System.out.println("Values are not matched with : "+wfxcontainerkey.toString()+"----"+WfxTrigeer.toString());
				params_val = "Fail";
				logStep("wfxtg Values are not matched");
			}

		}

	}




	//	//Verify API call from XML File
	//	public static void readwfxTriggers(String sheetName,String ParamName,String ObjectType) throws Exception{
	//		readExcelValues.excelValues("Smoke",sheetName);
	//		firstList.clear();
	//		String Content = "";
	//		// Json file
	//		JSONParser parser = new JSONParser();
	//		Object obj = parser.parse(new String(req.toString()));
	//		JSONObject jsonObject = (JSONObject) obj;
	//
	//		List<String> segmentList = new ArrayList<String>();
	//		
	//		JSONObject mainTag = (JSONObject) jsonObject.get(readExcelValues.data[11][Cap]);
	//		JSONArray scatterSegs = (JSONArray) mainTag.get(readExcelValues.data[12][Cap]);
	//		Iterator<JSONObject> iterator = scatterSegs.iterator();
	//		while (iterator.hasNext()) {
	//
	//			JSONObject zipMainJsonObject = (JSONObject) iterator.next();
	//
	//			JSONArray zcszipJson = (JSONArray) zipMainJsonObject.get(ObjectType);
	//			for(String Pubadzip :pubadvalues){
	//				if (zcszipJson != null) {
	//					Iterator<JSONObject> zcszipIterator = zcszipJson.iterator();
	//					while (zcszipIterator.hasNext()) {
	//						JSONObject zcszipObject = (JSONObject) zcszipIterator.next();
	//
	//						zipCode = zcszipObject.get("zip").toString();
	//						if (zipCode.contains(Pubadzip)) {
	//							System.out.println("Value is :" + Pubadzip);
	//							JSONArray segmentJsonArray = (JSONArray) zcszipObject.get(ParamName);
	//							System.out.println(zipCode + " zip code segemtn list : " + segmentJsonArray);
	//
	//							segmentList.addAll(segmentJsonArray.subList(0, segmentJsonArray.size()));
	//							//List<String> firstList = new ArrayList<String>();
	//							List<String> secondList = new ArrayList<String>();
	//							
	//							for (Object firstString : segmentList) {
	//								//System.out.println("firstString: " + firstString);
	//								firstList.add(firstString.toString().trim());
	//							}
	//							//cxtgcontainer.addAll(cxtgcontainer.subList(0, cxtgcontainer.size()));
	//							for (Object secondString : cxtgcontainer) {
	//								//System.out.println("secondString : " + secondString);
	//								secondList.add(secondString.toString().trim());
	//							}
	//							System.out.println("segments :" + firstList);
	//							if(ObjectType.equals("cxtg")){
	//							System.out.println("cxtgcontainer Containe :" + cxtgcontainer);
	//							for(String flist:firstList){
	//								if(cxtgcontainer.toString().contains(flist)){
	//									//System.out.println("Matched");
	//									params_val = "Pass";
	//								}else{
	//									System.out.println("Not Matched");
	//									params_val = "Fail";
	//									Assert.fail("cxtg Values are not matched");
	//								}
	//							}
	//							}else if(ObjectType.equals("zcs")){
	//								System.out.println("zcscontainer Containe :" + zcscontainer);
	//								for(String flist:firstList){
	//									if(zcscontainer.toString().contains(flist)){
	//										//System.out.println("Matched");
	//										params_val = "Pass";
	//									}else{
	//										System.out.println("Not Matched");
	//										params_val = "Fail";
	//										Assert.fail("zcs Values are not matched");
	//									}
	//								}
	//							}else if(ObjectType.equals("nzcs")){
	//								System.out.println("nzcscontainer Containe :" + nzcscontainer);
	//								for(String flist:firstList){
	//									if(nzcscontainer.toString().contains(flist)){
	//										//System.out.println("Matched");
	//										params_val = "Pass";
	//									}else{
	//										System.out.println("Not Matched");
	//										params_val = "Fail";
	//										Assert.fail("nzcs Values are not matched");
	//									}
	//								}
	//							}else if(ObjectType.equals("hzcs")){
	//								System.out.println("hzcscontainer Containe :" + hzcscontainer);
	//								for(String flist:firstList){
	//									if(hzcscontainer.toString().contains(flist)){
	//										//System.out.println("Matched");
	//										params_val = "Pass";
	//									}else{
	//										System.out.println("Not Matched");
	//										params_val = "Fail";
	//										Assert.fail("hzcs Values are not matched");
	//									}
	//								}
	//							}
	//							//System.out.println("File name is :"+Filename);
	//
	//							
	//
	//						}
	//					}
	//				}
	//			}
	//		}
	//		//System.out.println("cxtg Testcase passed");
	//	}

	//get all the files in the folder
	public static List<String> listFiles(String directoryName){

		//String file_name = null;
		List<String> filelist = new ArrayList<String>();
		File directory = new File(directoryName);
		//get all the files from a directory
		File[] fList = directory.listFiles();
		for (File file : fList){
			if (file.isFile()){
				filelist.add(file.getName());
				//file_name = file.getName();
				//break;
			}
		}
		return filelist;
	}/* --- End Get File Names from Folder  --- */

	//Moving Files
	public static void move_Files(String Foldername)throws Exception{
		String projDir = System.getProperty("user.dir");
		File sourceFile,destinationFile = null;
		String SourcePath=projDir+File.separator+Foldername+"/";
		String DestinationPath="/Users/vishal.pathania/.jenkins/workspace/IPhone_Smoke_Test_Cases/target/site/allure-maven-plugin";
		List<String> get_content_file_name = listFiles(SourcePath);
		String Filename=null;
		String destPath=null;
		for (int i=0;i < get_content_file_name.size();i++)
		{

			Filename=get_content_file_name.get(i);
			System.out.println("File name is :+"+Filename);
			sourceFile = new File(SourcePath.concat(get_content_file_name.get(i)));
			if(get_content_file_name.get(i).contains("allure-logo.png")||get_content_file_name.get(i).contains("tests_passed.jpg")){
				destPath=DestinationPath+"/img/";
				destinationFile = new File(destPath.concat(get_content_file_name.get(i)));
			}else if(get_content_file_name.get(i).contains("environment.json")||get_content_file_name.get(i).contains("timeline.json")||get_content_file_name.get(i).contains("report.json")){
				destPath=DestinationPath+"/data/";
				destinationFile = new File(DestinationPath+"data/".concat(get_content_file_name.get(i)));
			}



			//FileUtils.cleanDirectory(new File(destPath));
			FileUtils.copyFile(sourceFile, destinationFile);

		}
	}

	//Get Report with Screenshot
	public static void Take_Report_Screenshot() throws InterruptedException, IOException, Exception{
		readExcelValues.excelValues("Smoke","Paths");
		FirefoxProfile profile_Report = new FirefoxProfile();
		//			profile_Report.setPreference("browser.download.folderList",2);
		//			profile_Report.setPreference("browser.download.panel.shown", false);
		//			profile_Report.setPreference("browser.download.dir",readExcelValues.data[15][Cap]);
		//			profile_Report.setPreference("browser.helperApps.neverAsk.openFile","text/xml,text/csv,application/x-msexcel,application/octet-stream,application/vnd.android.package-archive,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/apk,application/ipa");
		//			profile_Report.setPreference("browser.helperApps.neverAsk.saveToDisk","text/xml,text/csv,application/x-msexcel,application/octet-stream,application/vnd.android.package-archive,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/apk,application/zip");
		//			readExcelValues.excelValues("Smoke","DownloadApp");
		driver_Report = new FirefoxDriver(profile_Report);
		driver_Report.manage().window().maximize();
		String ReportUrl = "file:///Users/vishal.pathania/Documents/Iphone/smoke/target/site/allure-maven-plugin/index.html";
		//"http://localhost:8080/job/IPhone_Smoke_Test_Cases/";
		// "file:///Users/vishal.pathania/.jenkins/workspace/IPhone_Smoke_Test_Cases/target/site/allure-maven-plugin/index.html";
		driver_Report.get(ReportUrl);
		//WebDriverWait wait = new WebDriverWait(driver_Report,20);
		try{
			//	wait.until(ExpectedConditions.visibilityOf(driver_Report.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td/div[3]/div/a/img"))));
			//driver_Report.findElement(By.xpath("/html/body/div[4]/div[1]/div[2]/div[2]/div[2]/table/tbody/tr[2]/td/div[3]/div/a/img")).click();
			Thread.sleep(2000);
			//				String projDir = System.getProperty("user.dir");

			String projDir = "/Users/vishal.pathania/.jenkins/workspace/IPhone_Smoke_Test_Cases";
			System.out.println("Proj Dir is : "+projDir);
			String FilePath = projDir+File.separator+"Report_images";
			WebElement ModuleName=null;

			for(int i=1;i<=6;i++){
				ModuleName = driver_Report.findElement(By.xpath("/html/body/div[2]/div[1]/ul/li["+i+"]/a"));
				System.out.println("Module Name is : "+ModuleName.getText());
				ModuleName.click();

				try{
					Thread.sleep(5000);
					// now copy the  screenshot to desired location using copyFile //method
					File src= ((TakesScreenshot)driver_Report).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(src, new File(FilePath+File.separator+ModuleName.getText()+".png"));
				}

				catch (IOException e)
				{
					System.out.println(e.getMessage());

				}
			}
		}catch(Exception e){
			System.out.println("Allure Repor not genarated");
		}

		driver_Report.close();
	}



	//Verify API call from XML File
	public static void readwfxTriggers(String sheetName) throws Exception{
		readExcelValues.excelValues("Smoke",sheetName);

		String Content = "";
		// Json file
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new String(req.toString()));
		JSONObject jsonObject = (JSONObject) obj;

		List<String> segmentList = new ArrayList<String>();
		JSONObject mainTag = (JSONObject) jsonObject.get(readExcelValues.data[11][Cap]);
		JSONArray scatterSegs = (JSONArray) mainTag.get(readExcelValues.data[12][Cap]);
		Iterator<JSONObject> iterator = scatterSegs.iterator();
		while (iterator.hasNext()) {

			JSONObject zipMainJsonObject = (JSONObject) iterator.next();

			JSONArray zcszipJson = (JSONArray) zipMainJsonObject.get("zcs");
			for(String Pubadzip :pubadvalues){
				if (zcszipJson != null) {
					Iterator<JSONObject> zcszipIterator = zcszipJson.iterator();
					while (zcszipIterator.hasNext()) {
						JSONObject zcszipObject = (JSONObject) zcszipIterator.next();

						zipCode = zcszipObject.get("zip").toString();
						if (zipCode.contains(Pubadzip)) {
							System.out.println("Value is :" + Pubadzip);
							JSONArray segmentJsonArray = (JSONArray) zcszipObject.get("cxtg");
							System.out.println(zipCode + " zip code segemtn list : " + segmentJsonArray);

							segmentList.addAll(segmentJsonArray.subList(0, segmentJsonArray.size()));
							List<String> firstList = new ArrayList<String>();
							List<String> secondList = new ArrayList<String>();
							for (Object firstString : segmentList) {
								//System.out.println("firstString: " + firstString);
								firstList.add(firstString.toString().trim());
							}
							//cxtgcontainer.addAll(cxtgcontainer.subList(0, cxtgcontainer.size()));
							for (Object secondString : cxtgcontainer) {
								//System.out.println("secondString : " + secondString);
								secondList.add(secondString.toString().trim());
							}
							System.out.println("segments :" + firstList);
							System.out.println("Containe :" + cxtgcontainer);
							//System.out.println("File name is :"+Filename);

							for(String flist:firstList){
								if(cxtgcontainer.toString().contains(flist)){
									//System.out.println("Matched");
								}else{
									System.out.println("Not Matched");
									logStep("cxtg Values are not matched");
									Assert.fail("cxtg Values are not matched");

								}
							}

						}
					}
				}
			}
		}
		System.out.println("cxtg Testcase passed");
		logStep("cxtg Testcase passed");
	}


	//Swipe based on counter  //by naresh
	public static void Swipe_Conter(int Counter) throws Exception{

		int swipe = Counter;

		for(int i=1;i<=swipe ;i++){
			//Thread.sleep(2000);
			//Swipe();
			try{
				if(Ad.findElementByName("Name any course, dish, or ingredient").isDisplayed()){
					System.out.println("Watson ad presented");
					break;
				}
			}catch (Exception e){
				Functions.scroll_Down();
				Functions.scroll_Down();

				System.out.println("watson ad not present");
			}


			//Thread.sleep(2000);
		}
	}
	//Search with Watson
	public static void search_with_watson_ad(String SeachText) throws Exception{
		Ad.findElementByName("Name any course, dish, or ingredient").click();
		//Ad.findElementByName("Name any course, dish, or ingredient").clear();

		Thread.sleep(2000);
		Ad.findElementByName("Name any course, dish, or ingredient").sendKeys(SeachText);
		Ad.navigate().back();
		Thread.sleep(3000);//changed from 1 to 3 by ravi
		Ad.findElementByAccessibilityId("Enter").click();
		Thread.sleep(15000);
		String SearchedText = Ad.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[8]").getAttribute("name");
		//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[8]
		//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[9]
		//			System.out.println("SS Text is : "+Ad.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[8]").getAttribute("name"));
		//			System.out.println("Searched Text is :"+SearchedText );
		if(Ad.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[8]").getAttribute("name").contains(SeachText.toString())){
			System.out.println("Seached text is matched");
		}else
		{
			Assert.fail("Searched Text : "+ SeachText +" not matched");
		}

		//Functions.Swipe_Conter(3);


	}
	//Read Location.wfxtriggers API
	public static void readlocation_wfxTriggers(String sheetName) throws Exception{
		readExcelValues.excelValues("Smoke",sheetName);
		String fgeoActual=null;
		String Pubadparmascount = readExcelValues.data[16][Cap];
		String pubparam[] = Pubadparmascount.split(",");
		System.out.println("Size of Pub param is :"+pubparam.length);
		if(req.toString().contains(readExcelValues.data[11][Cap])){
			System.out.println("req :"+req.toString());
			if(req.toString().contains("false")||req.toString().contains("Mnl")||req.toString().contains("[]")){
				fgeoActual="nl";
			}else{


				String factualreq1 = req.substring(req.indexOf("[")+1,req.indexOf("]")-1);
				System.out.println("FactualReq1 ::"+factualreq1);
				String[] factualarrays = factualreq1.split("},");
				String[] factualVal = null;
				for(String factualKeys:factualarrays)
				{
					factualVal =factualKeys.split(",");
					//System.out.println("factualVal :"+factualVal);
					for(String FactualValues:factualVal)
					{
						if(FactualValues.contains(readExcelValues.data[12][Cap]))
						{
							String Factualval = FactualValues.toString().replace("{", "").trim();
							String[] fgeofilter = Factualval.toString().split(",");
							Factualval = fgeofilter[0].replaceAll("^\"|\"$","");
							String[]fgeoval = Factualval.split(":");
							String fgeovalues =fgeoval[1].replaceFirst("^\"|\"$","");
							fgeolist.add(fgeovalues);
							if(Factualval.contains(""))
							{
								fgeoparams_val = "Fail";
								logStep("Api Values are empty");
								Assert.assertNotNull(Factualval);
							}
						}
					}
				}
				fgeoActual = fgeolist.toString().replace("[", "").replace("]", "");
				System.out.println("sg values are :" + fgeoActual.toString());
			}

			System.out.println("firstParamValue is :"+firstParamValue);
			String[] Factualarrays = firstParamValue.toString().split(",");

			for(String Factualkey : Factualarrays){
				Factualkey=Factualkey.toString().replaceAll("^\"|\"$", "");	
				Factualkey=Factualkey.toString().replace(" ", "");

				//Fgeo Comparison
				if(fgeoActual.toString().contains(Factualkey.toString())){
					System.out.println("Values are matched --"+firstParamValue +"--"+Factualkey);
					fgeoparams_val = "Pass";
					RetryAnalyzer.count=0;

				}else
				{
					System.out.println("Values are not matched for :"+ Factualkey);
					fgeoparams_val = "Faile";
					logStep("Values are not matched for :"+ Factualkey);
					Assert.fail("Values are not matched for :"+ Factualkey);
				}
			}
		}


		if(Pubadparmascount.contains(",")){
			//Faud values in to Container
			System.out.println("container  is "+container);
			String FaudActual = container.toString().replace("[", "").replace("]", "");
			if(req.toString().contains("set")&&req.toString().contains("true")){
				String faudreq1 = req.substring(req.indexOf("set")+7,req.indexOf("]}"));
				if(faudreq1.contains("group"))
				{
					String Faudval = faudreq1.toString().replace("{", "").trim();
					Faudval =Faudval.replaceAll("}","");
					String[] faudgroup = Faudval.toString().split(",");
					for(String Faudval1:faudgroup){
						//System.out.println("Faudval1 :"+Faudval1);
						String[]faudval = Faudval1.split(":");
						String faudvalues =faudval[1].replaceFirst("^\"|\"$","");
						faudvalues =faudvalues.replaceAll("^\"|\"$","");
						faudlist.add(faudvalues);

						System.out.println("faudlist :"+faudlist);
						//System.out.println("container::"+container);

					}
				}else{
					faudparams_val = "Pass";
					faudlist.add("nl");
					RetryAnalyzer.count=0;
				}
			}else{
				faudparams_val = "Pass";
				faudlist.add("nl");
			}
			String faudValues = faudlist.toString().replace("[", "").replace("]", "");
			//faued values split from Pubads
			String Expected = container.toString().replace("[", "").replace("]", "");
			//Expected = Expected.toString().replaceAll("\"", "");	
			System.out.println("Expected vales are :"+Expected.toString());
			System.out.println("faudValu vales are :"+faudValues.toString());
			//Fgeo Comparison
			String[] Faudlarrays = seg.toString().split(",");
			for(String Faudlkey : Faudlarrays){
				Faudlkey=Faudlkey.toString().replaceAll("^\"|\"$", "");	
				Faudlkey=Faudlkey.toString().replace(" ", "");

				//Fgeo Comparison
				if(faudValues.toString().contains(Faudlkey.toString())){
					faudparams_val = "Pass";
					System.out.println("Values are matched --"+seg +"--"+Faudlkey);
					RetryAnalyzer.count=0;
				}else
				{
					System.out.println("Values are not matched for :"+ Faudlkey);
					faudparams_val = "Faile";
					logStep("Values are not matched for :"+ Faudlkey);
					Assert.fail();
				}
			}


		}
	}


	//Pull to refresh
	public static void pulltorefresh() throws Exception{
		readExcelValues.excelValues("Smoke","pulltorefresh");
		//pull to refresh
		MobileElement el = Ad.findElementByXPath(readExcelValues.data[1][Cap]);
		MobileElement el1 = (MobileElement)Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]");
		System.out.println("el name:"+el.getText());		
		//(readExcelValues.data[1][Cap]);
		//MobileElement el1 = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[1]/UIACollectionView[1]/UIACollectionCell[1]/UIAStaticText[3]");
		TouchAction action1 = new TouchAction(Ad);
		Dimension dimensions = Ad.manage().window().getSize();
		Double startY = (double) dimensions.getHeight();
		Double startX = (double) dimensions.getWidth();
		System.out.println("StartX :"+startX+"startY"+startY);
		action1.longPress(el).moveTo(el1).release().perform();
		Thread.sleep(1000);
	}

	//Scroll up till home page
	public static void ScrollUp_ToHomePage(){
		JavascriptExecutor js = (JavascriptExecutor) Ad ;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "up");
		for(int i=1;i<=10;i++){
			js.executeScript("mobile: scroll", scrollObject);
			//			js.executeScript("mobile: scroll", scrollObject);
			//			js.executeScript("mobile: scroll", scrollObject);
			try{
				MobileElement el = Ad.findElementByName(" 48 Hours");
				//Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeStaticText[2]");
				//MobileElement el1 = (MobileElement)Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeTable[1]/XCUIElementTypeCell[3]");

				if(el.isDisplayed()){
					System.out.println("Userat Hourly page -"+el.getText());
					js.executeScript("mobile: scroll", scrollObject);
					js.executeScript("mobile: scroll", scrollObject);
					break;
				}
			}catch(Exception e){
				System.out.println("Scrol to Home page");
			}


		}
	}
	//SCROLL DOWN
	public static void scroll_Down() throws Exception{
		//Scroll JS
		JavascriptExecutor js = (JavascriptExecutor) Ad ;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
	}
	//SCROLL DOWN
	public static void scroll_Up() throws Exception{
		//Scroll JS
		try{
			JavascriptExecutor js = (JavascriptExecutor) Ad ;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "up");
			js.executeScript("mobile: scroll", scrollObject);
			logStep("Scroll / Pull to refresh done");
		}catch(Exception e){
			logStep("Scroll / Pull to refresh failed");
		}
	}

	//Move to selected page
	public static void Verify_selectedPages(String Pagename) throws Exception{
		if(Pagename.equals("Hourly")){
			Functions.scroll_Down();
		}
		readExcelValues.excelValues("Smoke",Pagename);
		Functions.verify_neednavBack(Pagename);
		String Counts =readExcelValues.data[2][Cap].toString();
		int Count =Integer.parseInt(Counts);
		int x;
		Xpth = readExcelValues.data[4][Cap].toString();
		if(Pagename=="Hurricane(MainPage)"){
			x=3;
			String[]xpt = Xpth.split("xpath");
			String xp=null;
			String xxpt = xpt[0].toString();
			String [] xpatcont = xxpt.split("xcount");
			int xpath;
			WebElement Hurricane = null;
			outerloop:

				for(int i = 10; i<=11;i++){
					for(int j=2;j<=4;j++){
						xxpt= xpatcont[0]+j+xpatcont[1];

						HurricaneXpath=xxpt+i+xpt[1];
						Xpth=HurricaneXpath;
						try{
							Hurricane = Ad.findElementByXPath(Xpth);
							String HurricaneText = Hurricane.getText();
							System.out.println("HurricaneText"+HurricaneText);
							try{
								if(HurricaneText.toString().contains("Trop")||HurricaneText.toString().contains("HURRICANE CENTRAL")){
									if(Hurricane.isDisplayed()){
										logStep("Module found and navigating to detaile page");
										break outerloop;

									}

									i=i-1;
									Functions.scroll_Down();
								}
								else{
									Functions.scroll_Down();
								}
							}catch(Exception e){
								System.out.println("Hurricane Extended option not found still on search");
								//Functions.TakeScreenshot();
								if(i==Count){
									logStep("Module not found till end of the app");
								}
							}
						}catch(Exception e1){
							System.out.println("Hurricane Extended option not found still on search");
							if(i==Count){
								logStep("Module not found till end of the app");
							}
						}
					}


				}
		}else{
			x=3;
		}

		String elemntType = readExcelValues.data[x][Cap].toString();
		if(readExcelValues.data[4][Cap].contains("NEWS1")){
			for(int i =1;i<=Count;i++){

				try{
					if(Ad.findElement(By.name(readExcelValues.data[4][Cap])).isDisplayed()){
						System.out.println("News element found");
						logStep("Module found and navigating to detaile page");
					}
					break;
				} catch (Exception e) {
					System.out.println("News element Not found");
					if(i==Count){
						logStep("Module not found till end of the app");
					}
				}	
				scroll_Down();
			}
		}
		outer:
			for(int i =1;i<=Count;i++){
				//for(int j=1;j<=3;j++) {
				//ModuleName=Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeCollectionView[1]/XCUIElementTypeCell["+j+"]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[1]").getAttribute("value");
				String Module_Name = readExcelValues.data[4][Cap].toString();
				////XCUIElementTypeStaticText[@name="hourly-card"]
				try {
					//ModName =
					ModuleName= Ad.findElementByXPath("//XCUIElementTypeStaticText[@name='"+Module_Name+"']").getAttribute("name");
					System.out.println("ModuleName is : "+ModuleName);
					if(ModuleName.contains(readExcelValues.data[4][Cap])) {
						if(Pagename.equals("News")) {
							try {
								module= Ad.findElementByName("news_article_cell_0");
							}catch(Exception e) {
								module= Ad.findElementById("news_article_thumbnail_0");	
							}
						}else {
							module =Ad.findElementByXPath("//XCUIElementTypeStaticText[@name='"+Module_Name+"']");

						}
						//index=j;
						//break;
					}
				}catch(Exception e) {
					//j=3;
				}

				//}
				if(elemntType.contains("name")){
					try{
						//if(Ad.findElement(By.name(readExcelValues.data[4][Cap])).isDisplayed()){
						if(ModuleName.contains(readExcelValues.data[4][Cap])) {
							for(int k=1;k<=5;k++ ) {
								try {
									if(module.isDisplayed()) {
										System.out.println(readExcelValues.data[1][Cap]+" element found");
										logStep("Module found  and navigating to detaile page");
										break outer;
									}else {
										//scroll_Down();
										swipe("Up");
									}
								}catch(Exception e) {

								}
								//break;
							}

						}

					} catch (Exception e) {
						System.out.println(readExcelValues.data[1][Cap]+" element Not found");
						if(i==Count){
							logStep("Module not found till end of the app");
						}
					}	
					scroll_Down();

				}else if(elemntType.contains("xpath")){
					try{
						if(Ad.findElement(By.xpath(readExcelValues.data[4][Cap])).isDisplayed()){
							System.out.println(readExcelValues.data[1][Cap]+" element found");
							logStep("Module found  and navigating to detaile page");
							break;
						}
					} catch (Exception e) {
						System.out.println(readExcelValues.data[1][Cap]+" element Not found");
						if(i==Count){
							logStep("Module not found till end of the app");
						}
					}	
					scroll_Down();
				}else if(elemntType.contains("classname")){
					if(Ad.findElement(By.className(readExcelValues.data[4][Cap])).isDisplayed()){
						System.out.println(readExcelValues.data[1][Cap] + " page is displayed");
						logStep("Module found  and navigating to detaile page");
						break;
					}else{
						scroll_Down();
					}
				}else if(elemntType.contains("css")){
					if(Ad.findElement(By.cssSelector("//input[contains(@name, '"+readExcelValues.data[4][Cap]+"')]")).isDisplayed()){
						System.out.println(readExcelValues.data[1][Cap] + " page is displayed");
						logStep("Module found  and navigating to detaile page");
						break;
					}else{
						scroll_Down();
					}
					//break;

				}

			}
	}



	//Navigate to selected exteneded page
	public static void Navigate_extendedPages(String Pagename) throws Exception{
		excelPage=Pagename;
		readExcelValues.excelValues("Smoke",Pagename);
		String Xpth = readExcelValues.data[5][Cap].toString();
		int x;
		if(Pagename=="PreRollVideo1"){
			x=18;
			String[]xpt = Xpth.split("xpath");
			String xp=null;
			int xpath;
			//Xpth=prerolladxpath;
			try{
				xpath=2;
				Xpth=xpt[0]+xpath+xpt[1];
				if(Ad.findElementByXPath(Xpth).isDisplayed()){
					System.out.println("Video's page is present");
				}

			}catch(Exception e){
				xpath=3;
				Xpth=xpt[0]+xpath+xpt[1];
				if(Ad.findElementByXPath(Xpth).isDisplayed()){
					System.out.println("Video's page is present");
				}
			}
		}else if(Pagename=="News1"){
			x=18;
			String[]xpt = Xpth.split("xpath");
			String xp=null;
			int xpath;
			outerloop:
				for(int j=1;j<=2;j++){
					for(int i = 1; i<=7;i++){
						Xpth=xpt[0]+i+xpt[1];
						try{
							if(Ad.findElementByXPath(Xpth).isDisplayed()){

								break outerloop;

							}
						}catch(Exception e){
							System.out.println("News Extended option not found still on search");
							//Functions.TakeScreenshot();
							if(i==7){
								scroll_Down();
							}
						}
					}
				}

		}else if(Pagename=="Hurricane(MainPage)"){
			x=13;
			//			String[]xpt = Xpth.split("xpath");
			//			String xp=null;
			//			int xpath;
			//
			//			//for(int i = 10; i<=13;i++){
			Xpth=HurricaneXpath;
			try{
				if(Ad.findElementByXPath(Xpth).isDisplayed()){
					//break;
				}
			}catch(Exception e){
				System.out.println("Hurricane Extended option not found still on search");
				//Functions.TakeScreenshot();
			}
			//}

			//			Functions.Xpth=Xpth.toString();

		}else{
			x=10;
		}


		String ElemntType = readExcelValues.data[x][Cap].toString();
		if(ElemntType.contains("name")){
			Thread.sleep(5000);
			MobileElement Navigater=null;
			for(int k=1;k<=3;k++) {
				try{
					if(Pagename.equals("News")){
						try {
							Navigater=Ad.findElementByName("news_article_cell_0");
						}catch(Exception e) {
							Navigater=Ad.findElementById("news_article_thumbnail_0");
						}
					}else {
						Navigater = Ad.findElementByXPath(readExcelValues.data[5][Cap]);
					}
					if(Navigater.isDisplayed()){
						//Ad.findElementByName(readExcelValues.data[5][Cap]
						Navigater.click();
						break;

					}else {
						if(excelPage.equals("LSModule(OutDoor)")||excelPage.equals("LSModule(Ski)")||excelPage.equals("LSModule(Running)")||excelPage.equals("LSModule(Boat&Beach"))
						{
							Functions.swipe("right-to-left");	
						}else {
							scroll_Down();
						}
					}
				}catch(Exception e){
					if(excelPage.equals("LSModule(OutDoor)")||excelPage.equals("LSModule(Ski)")||excelPage.equals("LSModule(Running)")||excelPage.equals("LSModule(Boat&Beach"))
					{
						Functions.swipe("right-to-left");	
					}else if(excelPage.equals("WinterStorm")){


					}else {
						scroll_Down();
						Navigater.click();
					}

				}
			}

			logStep("Navigated to detaile page");
		}else if(ElemntType.contains("xpath")){

			try{
				if(Ad.findElementByXPath(readExcelValues.data[5][Cap]).isDisplayed()){
					Ad.findElementByXPath(readExcelValues.data[5][Cap]).click();
					Thread.sleep(3000);
				}
			}catch(Exception e){
				scroll_Down();
				Ad.findElementByXPath(Xpth).click();
			}
			//Ad.findElementByXPath(Xpth).click();
			logStep("Navigated to detaile page");
		}else if(ElemntType.contains("classname")){
			Ad.findElementByClassName(readExcelValues.data[5][Cap]).click();
			logStep("Navigated to detaile page");
		}else{
			System.out.println("User Still on Home page element not fount");
			logStep("Navigating failed to detaile page");
			Assert.fail();
		}



	}

	//Verify User on Extened page
	public static void  Verify_Extenedpage(String Pagename) throws Exception{
		readExcelValues.excelValues("Smoke",Pagename);
		//Verify the  user on Extended page or not
		String navElemntType = readExcelValues.data[3][Cap].toString();
		if(navElemntType.contains("name")){
			if(Ad.findElementByName(readExcelValues.data[6][Cap]).isDisplayed()){
				System.out.println("User Navigate to Selected "+readExcelValues.data[1][Cap] +" page");
			}else{
				System.out.println("User Still on Home page");
			}
		}else if(navElemntType.contains("xpath")){
			if(Ad.findElementByXPath(readExcelValues.data[6][Cap]).isDisplayed()){
				System.out.println("User Navigate to Selected "+readExcelValues.data[1][Cap] +" page");
			}else{
				System.out.println("User Still on Home page");
			}
		}else if(navElemntType.contains("classname")){
			if(Ad.findElementByClassName(readExcelValues.data[6][Cap]).isDisplayed()){
				System.out.println("User Navigate to Selected "+readExcelValues.data[1][Cap] +" page");
			}else{
				System.out.println("User Still on Home page");
			}

		}
	}

	//Verify If User need to navigate back from extened page
	public static void verify_neednavBack(String Pagename) throws Exception{
		readExcelValues.excelValues("Smoke",Pagename);
		try{
			if(Ad.findElementByName(readExcelValues.data[6][Cap]).isDisplayed()){
				if(readExcelValues.data[12][Cap].toString().contains("Yes"))
				{
					navBack_fromExtendedPage(Pagename);
					navBack_fromExtendedPage(Pagename);
				}else{

					//System.out.println("User Navigate to Selected "+readExcelValues.data[1][Cap] +" page");
					navBack_fromExtendedPage(Pagename);

				}
			}
		}catch(Exception e){
			//System.out.println("User on Main page");
		}
	}

	//Navigate to SubModule page
	public static void Navigate_Submodule(String Pagename) throws Exception{
		readExcelValues.excelValues("Smoke",Pagename);
		String navElemntType = readExcelValues.data[3][Cap].toString();
		if(navElemntType.contains("xpath")){
			if(Ad.findElementByName(readExcelValues.data[4][Cap]).isDisplayed()){
				System.out.println("User Navigate to Selected "+readExcelValues.data[1][Cap] +" page");
				//Navigate to Submodule page
				Ad.findElementByXPath(readExcelValues.data[5][Cap]).click();
				//Functions.Verify_Extenedpage(Pagename);

			}else{
				System.out.println("User Still on Extened page");
			}
		}
	}

	//CHCEK AD
	public static void check_ad(String Pagename)throws Exception{
		readExcelValues.excelValues("Smoke",Pagename);

	}


	//Move to selected page
	public static void Verify_Adpresenton_extendedPages(String Pagename) throws Exception{
		readExcelValues.excelValues("Smoke",Pagename);
		String Adc = readExcelValues.data[11][Cap].toString();
		int Adcount =Integer.parseInt(Adc);
		String Adp = readExcelValues.data[7][Cap].toString();
		String[] AdPath = null;
		if(Adp.contains(",")){
			AdPath = Adp.split(",");
		}

		String Adx = readExcelValues.data[8][Cap].toString();
		String[]Adxvl=null;
		String Ady = readExcelValues.data[9][Cap].toString();
		String[]Adyvl=null;
		if(Adx.contains(",")){
			Adxvl = Adx.split(",");
		}
		if(Ady.contains(",")){
			Adyvl = Ady.split(",");
		}

		//int AdxVal = Integer.parseInt(Adx);
		int AdxVal;
		int AdyVal;
		int path ;
		if(AdPath==null){
			path =1;
		}else
		{
			path = AdPath.length;
		}

		System.out.println("ADpath is :"+path);
		for(int ads =0;ads<=path-1;ads++){
			if(path>1){
				Adp = AdPath[ads].toString();
				AdxVal = Integer.parseInt(Adxvl[ads]);
				AdyVal = Integer.parseInt(Adyvl[ads]);
			}else{
				AdxVal = Integer.parseInt(Adx);
				AdyVal = Integer.parseInt(Ady);
			}


			if(Pagename=="News1"){
				//String [] NewsAd= Adp.split("counter");

				int counter;
				try{
					for(counter=2;counter<=4;counter++){
						//						if(Ad.findElementByXPath(NewsAd[0]+counter+NewsAd[1]).isDisplayed()){
						//							Adp=NewsAd[0]+counter+NewsAd[1];
						//						}
						if(Ad.findElementByXPath(Adp).isDisplayed()){
							//Adp=NewsAd[0]+counter+NewsAd[1];
						}
					}
				}catch(Exception e){

					System.out.println("Ad is not present / ad possistion changed");
					logStep("Ad is not present / ad possistion changed");
					Assert.fail("Ad is not present / ad possistion changed");
					//Assert.fail("Ad is not present / ad possistion changed");
				}

			}

			if(ads>0){
				for(int s =5;s<=7;s++){
					if(Pagename.equals("LSModule(Allergy)")){
						Functions.Swipe();
						Functions.Swipe();				
						System.out.println("Page scrolled for add");
					}

					try{
						String adxpath = AdPath[ads].toString();
						System.out.println("Ads xpath is :"+adxpath);
						if(adxpath.contains("xpath")){
							String[] xpathad = adxpath.split("xpath");
							prerolladxpath = xpathad[0]+s+xpathad[1];
						}else{
							prerolladxpath=adxpath.toString();
						}
						//for(int i = 5;i<=7;i++){

						System.out.println("adxpath is :"+prerolladxpath.toString());
						try{
							if(Ad.findElementByXPath(prerolladxpath.toString()).isDisplayed()){
								Adp=prerolladxpath.toString();
								break;
							}
						}catch(Exception e2){
							System.out.println("add not found");
							//logStep("Ad not found");
							try{
								Functions.Swipe();
								//Functions.Swipe();
							}catch(Exception e){
								Functions.scroll_Down();
							}
						}
						//}
					}catch(Exception e1){

						System.out.println("add is not present");
						logStep("Ad is not presented");
						//Functions.TakeScreenshot();
					}

				}

			}

			Functions.Navigate_extendedPages(Pagename);
			if(Pagename.equals("LSModule(Allergy)")||Pagename.equals("LSModule(ColdAndFlu)")||Pagename.equals("LSModule(Boat&Beach)")){
				Functions.Swipe();
				Functions.Swipe();				
				System.out.println("Page scrolled for add");
			}else if(Pagename.equals("LSModule(Running)")){
				Functions.Swipe();
				Functions.Swipe();
				Functions.Swipe();
				System.out.println("Page scrolled for add");
			}
			//try{
			//Thread.sleep(15000);
			if(Pagename=="News"){
				System.out.println("User on News Page");
				//try{
				//Thread.sleep(10000);
			}else{
				//				WebDriverWait wait = new WebDriverWait(Ad, 5);
				//				wait.until(ExpectedConditions.visibilityOf(Ad.findElementByXPath(Adp)));
			}
			MobileElement AdEle =null;
			String Adsizes=null;
			try{
				//				try{
				//					AdEle = Ad.findElementByClassName("XCUIElementTypeLink");
				//			System.out.println("Size is :"+AdEle.getSize());
				//				}catch(Exception e){
				//				try{
				//				AdEle = Ad.findElementByClassName("XCUIElementTypeImage");
				//			}catch(Exception e1){
				//				AdEle = Ad.findElementByClassName("XCUIElementTypeWebView");
				//			}
				//			}

				//				Functions.Navigate_extendedPages(Pagename);

				//Functions.Navigate_extendedPages(Pagename);
				Functions.returnToWeather();
				System.out.println("User on "+Pagename +" Module");
				if(Pagename.equals("Map")){
					Thread.sleep(6000);
					AdEle = Ad.findElementByClassName(Adp);
					//Ad.findElementByXPath(Adp);

				}else if(Pagename=="News"){
					System.out.println("User on News Page");
					Thread.sleep(4000);
					AdEle = Ad.findElementByClassName(Adp);
					//AdEle=Ad.findElementByClassName("XCUIElementTypeWebView");
					Adsizes=AdEle.getSize().toString();
					System.out.println("Ad size is "+Adsizes);
				}else{
					Thread.sleep(4000);
					AdEle = Ad.findElementByClassName(Adp);
					Adsizes=AdEle.getSize().toString();
				}

			}catch (Exception e){
				try{
					AdEle = Ad.findElementByClassName(Adp);
					Adsizes=AdEle.getSize().toString();
				}catch(Exception e1){
					ScreenShot(Pagename,"Failed");
					Assert.fail("Ad not present on the "+Pagename+" detaile page");
				}
				//Functions.scroll_Down();
				//				Functions.scrolldown();
				//				MobileElement Advert = Ad.findElementByName("ADVERTISEMENT");
				//				MobileElement Advert = Ad.findElementByName("ADVERTISEMENT");
			}
			//				String xVal=AdxVal.toString().trim();
			//				System.out.println("xVal is :"+xVal.trim());
			int x= AdxVal;
			String yVal=readExcelValues.data[9][Cap].toString().trim();
			int y= AdyVal;


			if(AdEle.isDisplayed())
			{

				Dimension ActualSize = AdEle.getSize();
				System.out.println("Size of the ad is ::"+ActualSize);
				System.out.println("Height  of the ad is ::"+ActualSize.getHeight());
				System.out.println("Width of the ad is ::"+ActualSize.getWidth());
				if(ActualSize.getHeight() == y && ActualSize.getWidth()==x){

					System.out.println("Ad present on Extended"+ Pagename +"page");
					System.out.println("Ad sizes are matched");
					ScreenShot(Pagename,"Passed");


					try{
						if(TestName.toString().equals("Ad Validation")){
							AdEle.click();
							Functions.delete_folder("Charles");
							Functions.clear_session();
							try{
								Ad.findElementByName("Return to The Weather").click();
								Thread.sleep(3000);
							}catch(Exception e){
								try{
									Ad.findElementByName("Done").click();
									Thread.sleep(3000);
								}catch(Exception e1){
									try{
										Ad.findElementByName("Cancle").click();
										Thread.sleep(3000);
									}catch(Exception e2){
										try{
											Ad.findElementByName("Close").click();
											Thread.sleep(3000);
										}catch(Exception e3){

											System.out.println("Ad page not presented");
											Functions.TestName=null;
											Assert.fail("Ad page not presented");
										}

									}

								}

							}
							Functions.TestName=null;
							//Functions.Scroll_end();
							Functions.downloadXMLFile();
							Functions.clear_sb();
							//Functions.readXML();
							Functions.Verify_feedcals("CleanLaunch");
						}
					}catch(Exception e){
						System.out.println("User on :"+Pagename +"page");
					}
					//				ATUReports.add("Ad is displayed on Extended"+ Pagename +"page",false);
					//				logger.log(LogStatus.PASS, "Ad is displayed on Extended 10 Days page");
					//Ad.findElementByName(readExcelValues.data[6][Cap]).click();
					logStep("Ad present on Extended"+ Pagename +"page");
					logStep("Ad sizes are matched");
					RetryAnalyzer.count=0;

				}else if(ActualSize.getHeight()+1 == y && ActualSize.getWidth()==x){

					System.out.println("Ad present on Extended"+ Pagename +"page");
					System.out.println("Ad sizes are matched");
					ScreenShot(Pagename,"Passed");
				}else if(ActualSize.getHeight() == y && ActualSize.getWidth()+1==x){

					System.out.println("Ad present on Extended"+ Pagename +"page");
					System.out.println("Ad sizes are matched");
					ScreenShot(Pagename,"Passed");
				}else if(ActualSize.getHeight()+1 == y && ActualSize.getWidth()+1==x){

					System.out.println("Ad present on Extended"+ Pagename +"page");
					System.out.println("Ad sizes are matched");
					ScreenShot(Pagename,"Passed");
				}else if(ActualSize.getHeight() == y+1 && ActualSize.getWidth()==x){

					System.out.println("Ad present on Extended"+ Pagename +"page");
					System.out.println("Ad sizes are matched");
					ScreenShot(Pagename,"Passed");
				}else if(ActualSize.getHeight() == y && ActualSize.getWidth()==x+1){

					System.out.println("Ad present on Extended"+ Pagename +"page");
					System.out.println("Ad sizes are matched");
					ScreenShot(Pagename,"Passed");
				}else if(ActualSize.getHeight() == y+1 && ActualSize.getWidth()+1==x+1){

					System.out.println("Ad present on Extended"+ Pagename +"page");
					System.out.println("Ad sizes are matched");
					ScreenShot(Pagename,"Passed");
				}else 
				{

					System.out.println("Ad present but sizes are not matched");
					Ad.findElementByName(readExcelValues.data[6][Cap]).click();
					logStep("Ad present but sizes are not matched");
					ScreenShot(Pagename,"Failed");//Functions.TakeScreenshot();
					Functions.TestName=null;
					//					Assert.fail();
					Assert.fail("Ad preset on "+Pagename+" Module,  but sizes are not matched");
				}

				Thread.sleep(2000);
			}

		}
		readExcelValues.excelValues("Smoke",Pagename);
		if(readExcelValues.data[12][Cap].toString().contains("No")){
			try{
				navBack_fromExtendedPage(Pagename);
			}catch(Exception e){

			}
		}else{
			System.out.println("try to Navigate submodule");
		}
	}


	//Swipe with cordinates
	public static void swipeUp() {
		TouchAction action= new TouchAction(Ad);

		action.press(285, 626).waitAction(1000).moveTo(-4,-533).release().perform();

	}

	//Navigate back to home page from Submodule
	public static void navBackfrom_Submodule(String Pagename) throws Exception{
		readExcelValues.excelValues("Smoke",Pagename);
		if(readExcelValues.data[12][Cap].toString().contains("Yes")){
			navBack_fromExtendedPage(Pagename);
			navBack_fromExtendedPage(Pagename);
		}else{
			System.out.println("try to Navigate submodule");
		}
	}

	//Check Returnto Weather present
	public static void returnToWeather(){
		/*try{
			if(Ad.findElementByName("Return to The Weather").isDisplayed()){
				System.out.println("User on Ad page Navigate back to main page");
				Ad.findElementByName("Return to The Weather").click();
				int ScrolltoFeed;
				if(FeedValue==1){
					ScrolltoFeed=FeedValue+(FeedValue);
				}else if(FeedValue==10){
					ScrolltoFeed=0;
				}else {
					ScrolltoFeed= FeedValue+(FeedValue-1);
				}
				for(int i=0;i<=ScrolltoFeed;i++){
					Functions.scroll_Down();
				}
			}
		}catch(Exception e){
			System.out.println("User on main page");
		}*/
	}

	//Close the app and launch the app
	public static void close_launchApp() throws Exception{

		Ad.closeApp();
		System.out.println("App closed for restart");
		//			logStep("App Closed SuccessFully");
		Thread.sleep(1000);
		Ad.launchApp();
		Thread.sleep(1000);
		System.out.println("App launched after restart");
		Functions.Handle_onwanted_popups();

	}

	//Navigate Back from Extended page
	public static void navBack_fromExtendedPage(String sheetName) throws Exception{
		//Verify the  user on Extended page or not
		readExcelValues.excelValues("Smoke",sheetName);
		try{
			String navElemntType = readExcelValues.data[10][Cap].toString();
			if(navElemntType.contains("name")){
				if(Ad.findElementByName(readExcelValues.data[6][Cap]).isDisplayed()){
					Ad.findElementByName(readExcelValues.data[6][Cap]).click();
				}else{

				}
			}else if(navElemntType.contains("xpath")){
				if(Ad.findElementByXPath(readExcelValues.data[6][Cap]).isDisplayed()){
					Ad.findElementByName(readExcelValues.data[6][Cap]).click();
				}else{
					System.out.println("User Still on Home page");
				}
			}else if(navElemntType.contains("classname")){
				if(Ad.findElementByClassName(readExcelValues.data[6][Cap]).isDisplayed()){
				}else{
					System.out.println("User Still on Home page");
				}

			}
		}catch(Exception e){
			System.out.println("User on Main page");
		}
	}

	//Verify Feed calls
	public static void Verify_feedcals(String sheetName) throws Exception{
		//Functions.downloadXMLFile();
		int fail=-1;
		readXML();
		readExcelValues.excelValues("Smoke",sheetName);
		String feedVal=readExcelValues.data[3][Cap].toString().trim();
		System.out.println("xVal is :"+feedVal.trim());
		int feedcount=Integer.parseInt(feedVal);
		int Feed;
		try{
			if(Functions.TestName.equals("Ad Validation")){
				feedcount=0;
			}
		}catch(Exception e){
			feedcount=Integer.parseInt(feedVal);
		}
		for(Feed=0;Feed<=feedcount;Feed++){


			String pubadcal;
			String feedcall = readExcelValues.data[2][Cap]+Feed;
			String FeedName=null;
			if(Feed==0){
				try{
					FeedName="bb";
					pubadcal = sb.toString().substring(sb.toString().lastIndexOf(readExcelValues.data[1][Cap]));
					if(pubadcal.toString().contains(readExcelValues.data[1][Cap])){
						System.out.println("bb ad call is pressent");
						Functions.verifyPubadCal("Smoke", "Pulltorefresh");
						try{
							readExcelValues.excelValues("Smoke","ThirdpartyBecon");
							//System.out.println("pubadcal :"+pubadcal);
							if(pubadcal.contains(readExcelValues.data[1][Cap])){
								System.out.println("Branded Background present on UI, So no Feed_0  present");
								Feed=1;
							}
						}catch(Exception e){

						}
						readExcelValues.excelValues("Smoke","CleanLaunch");

						logStep("bb ad call is pressent");
					}else{

						System.out.println("bb call not present");
						logStep("bb ad call is not pressent");
						Assert.fail();
						fail=fail+1;
					}
					//Validating Feed_0 Call
					FeedName ="Feed_0";
					pubadcal = sb.toString().substring(sb.toString().lastIndexOf(readExcelValues.data[2][Cap]+Feed));
					if(pubadcal.toString().contains(feedcall)){
						System.out.println("Feed_"+Feed +"ad call is pressent");
					}else{

						System.out.println("Feed_"+Feed +"ad call is not pressent");
						logStep("Feed_"+Feed +"ad call is not pressent");
						//Assert.fail("Feed_"+Feed +"ad call is not pressent");
						fail=fail+Feed;
					}

				}catch(Exception e){
					System.out.println(FeedName+ " ad call is not pressent");
					logStep(FeedName+ " ad call is not pressent");
					fail=fail+1;
				}
			}else
			{
				//Validatimng All the feed cals 1-4
				//String feedcall = readExcelValues.data[2][Cap]+Feed;
				pubadcal = sb.toString().substring(sb.toString().lastIndexOf(readExcelValues.data[2][Cap]+Feed));
				if(pubadcal.toString().contains(feedcall)){
					System.out.println("Feed_"+Feed +"ad call is pressent");
					logStep("Feed_"+Feed +"ad call is pressent");
					if(Feed==4){
						RetryAnalyzer.count=0;
					}
				}else{
					System.out.println("Feed_"+Feed +"ad call is not pressent");
					logStep("Feed_"+Feed +"ad call is not pressent");
					Assert.fail("Feed_"+Feed +"ad call is not pressent");
					fail=fail+Feed;
				}
			}

		}

		if(fail==-1){
			System.out.println("Testcases Passed");
		}else if(fail==0){
			System.out.println("bb ad call is not pressent");
			logStep("bb ad call is not pressent");
			Assert.fail("bb ad call is not pressent");
		}else {
			System.out.println("feed_"+Feed+" ad call is not pressent");
			logStep("feed_"+Feed+" ad call is not pressent");
			Assert.fail("feed_"+Feed+" ad call is not pressent");
		}
	}



	//Verify pubad params call from XML File
	public static void verifyPubadCal_params(String Excelname,int feedval,String sheetName) throws Exception{
		readExcelValues.excelValues("Smoke",sheetName);
		pubadcal=null;
		pubreq1=null;
		//Get Pubad call from 
		pubads.clear();

		if(sb.toString().contains(readExcelValues.data[17][Cap]+feedval)){
			System.out.println("ad call is pressent");

			pubadcal = sb.toString().substring(sb.toString().lastIndexOf(readExcelValues.data[17][Cap]+feedval));
			//System.out.println("pubad call is :"+pubadcal);

			pubreq1 = pubadcal.toString().substring(pubadcal.toString().indexOf(readExcelValues.data[7][Cap]));

			pubreq1= pubreq1.toString().replaceAll(readExcelValues.data[8][Cap], "=");
			pubreq1= pubreq1.toString().replaceAll(readExcelValues.data[9][Cap], "&");
			pubreq1= pubreq1.toString().replaceAll(readExcelValues.data[10][Cap], ",");
			int sizeparam = readExcelValues.data[14][Cap].length();
			pubreq1 = pubreq1.substring(pubreq1.indexOf(readExcelValues.data[14][Cap])+sizeparam,pubreq1.indexOf(readExcelValues.data[15][Cap]));
			//System.out.println("feed call zip is "+ pubreq1.toString());
			pubads.add(pubreq1.toString());
			System.out.println("feed call zip is "+ pubads);

		}
		else{
			System.out.println("bb ad call is not pressent");
			Assert.fail("bb ad call is not pressent");
		}


		verifyParamsFromPubadCal(Excelname,sheetName);
	}




	//	//Scroll app till end
	//	public static void Scroll_end() throws Exception{
	//		readExcelValues.excelValues("Smoke","General");
	//		logStep("User on Cc page and trying to scroll the app till end");
	//		for(int scrollend=1;scrollend<=12;scrollend++){
	//			try{
	//				if(Ad.findElementByName(readExcelValues.data[1][Cap]).isDisplayed()){
	//					System.out.println("User done scrolling");
	//					logStep("User done scrolling till last page");
	//					break;
	//				}
	//			}
	//			catch(Exception e){
	//				System.out.println("last page not found, Need to scrol till the end");
	//				if(scrollend==12){
	//					logStep("last page not found");
	//				}
	//			}
	//			scroll_Down();
	//			scroll_Down();
	//		}
	//	}



	//Set app  into TestMode

	public static void Setappinto_TestMode() throws Exception
	{
		logStep("Verify bb ad call in Test mode");
		readExcelValues.excelValues("Smoke","TestMode");

		MobileElement el = null;
		Thread.sleep(2000);
		//Ad.findElementByXPath(readExcelValues.data[2][Cap]).click();
		try{
			Ad.findElementByName(readExcelValues.data[1][Cap]).click();
		}catch(Exception e){
			Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeNavigationBar[1]/XCUIElementTypeButton[1]").click();
		}
		Thread.sleep(1000);
		Functions.scroll_Down();
		Thread.sleep(4000);
		MobileElement el2=Ad.findElementByName(readExcelValues.data[6][Cap]);
		el2.click();
		Thread.sleep(1000);
		for(int i=1;i<=10;i++)
		{
			Ad.findElementByName(readExcelValues.data[11][Cap]).click();
		}

		Ad.findElementByName(readExcelValues.data[12][Cap]).click();
		Ad.findElementByName(readExcelValues.data[16][Cap]).click();

		Ad.findElementByName(readExcelValues.data[18][Cap]).click();
		Ad.findElementByName(readExcelValues.data[19][Cap]).click();

		Thread.sleep(3000);
		try{
			Ad.closeApp();
			Ad.launchApp();
		}catch(Exception e){
			Functions.launchtheApp_Withoutfullreset();
		}
		//app set to Test mode

		readExcelValues.excelValues("Smoke","TestMode");
		Thread.sleep(5000);
		try{
			System.out.println("excel data :"+readExcelValues.data[1][Cap]);
			if(Ad.findElementByName(readExcelValues.data[1][Cap]).isDisplayed()){
				//Select Addresss
				Ad.findElementByName(readExcelValues.data[20][Cap]).click();
				logStep("Select Address page");
			}else{
				System.out.println("User already on address search page");
				logStep("User already on address search page");
			}
			System.out.println("Searching for address");
			//			Ad.findElementByClassName("UIASearchBar").click();
			//			Ad.findElementByClassName("UIASearchBar").sendKeys("08302");
			//
			//			Thread.sleep(2000);
			//			Ad.findElementByName("Search").click();
			//			//Ad.navigate().back();
			//
			//			Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]").click();
			//			Thread.sleep(2000);
			//			//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[2]/UIATableCell[1]/UIAStaticText[1]").click();
			//			Thread.sleep(3000);    
			//	Functions.enternewAddress(readExcelValues.data[21][Cap]);
			System.out.println("Address entered and searched");
		}catch (Exception e){
			System.out.println("Address already presented");
		}



	}

	//Verify Thirdparty Beacon
	public static void thirdPart_Beacon() throws Exception{
		readExcelValues.excelValues("Smoke","ThirdpartyBecon");
		//System.out.println("pubadcal :"+pubadcal);
		if(pubadcal.contains(readExcelValues.data[1][Cap])){
			String Pubcal=pubadcal.toString().substring(pubadcal.toString().indexOf(readExcelValues.data[2][Cap]),pubadcal.toString().indexOf(readExcelValues.data[3][Cap]));
			System.out.println("pubcal is :"+Pubcal.toString());
			Pubcal =Pubcal.replace("thirdPartyBeacon", "&thirdPartyBeacon");
			String [] Creativetext=Pubcal.split(readExcelValues.data[4][Cap]);
			System.out.println("string 1 :"+Creativetext[0]);
			System.out.println("string 2 :"+Creativetext[1]);
			String Cidtext =Creativetext[0].toString().substring(Creativetext[0].indexOf(readExcelValues.data[2][Cap]),Creativetext[0].indexOf(readExcelValues.data[5][Cap]));
			System.out.println("Cidtext :"+Cidtext);
			String CreativeID[] = Cidtext.split(readExcelValues.data[6][Cap]);
			if(CreativeID[1].isEmpty()){
				logStep("Creative id showing Empty");
				Assert.fail("Creative id showing Empty");

			}else{
				System.out.println("CreativeId is:"+CreativeID[1].toString());
			}

			String Ttext = Creativetext[1].replace("thirdPartySurvey", "&thirdPartySurvey");
			String[] Tpartytext =Ttext.split(readExcelValues.data[7][Cap]);


			for(String TPtext:Tpartytext){

				String[] thirdpartytext =TPtext.split(readExcelValues.data[8][Cap]);
				if(thirdpartytext[1].isEmpty()){
					logStep("Thirdparty beacon/Survey shows Empty");
					Assert.fail("Thirdparty beacon/Survey shows Empty");
				}else if(thirdpartytext[1].equals("thirdPartySurvey:")){
					logStep("Thirdparty beacon/Survey shows Empty");
					Assert.fail("Thirdparty beacon/Survey shows Empty");
				}else{
					logStep("Thirdparty beacon / Survey urls are presented");
					System.out.println("Thirdparty beacon/Survey urls is --:"+thirdpartytext[1].toString());
					RetryAnalyzer.count=0;
				}
			}
		}else{
			logStep("Thirdparty Beacons are not present");
			Assert.fail("Thirdparty Beacons are not present");
		}
	}


	//Verify Video ads
	public static void Verify_videoads() throws Exception{
		long start1 = System.currentTimeMillis();
		System.out.println("Start Time :" + start1+" millisec");
		MobileElement clickvideo = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]");
		List<MobileElement> numberOfVideos = clickvideo.findElementsByClassName("UIATableCell");

		System.out.println("Size is :"+numberOfVideos.size());
		int x=2;
		for(int n =1;n<=numberOfVideos.size();n++){
			//Thread.sleep(5000);
			try{
				WebElement Learnmore = Ad.findElementByName("Learn More");
				//Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell["+n+"]/UIAWebView[1]/UIAStaticText[1]");
				//System.out.println(Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAWebView[1]/UIAStaticText[1]").getText());
				//				WebDriverWait wait = new WebDriverWait(Ad, 10);
				//				wait.until(ExpectedConditions.visibilityOf(Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAWebView[1]")));
				//MobileElement WebView = Ad.findElementByXPath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIAWebView[1]");
				//List<WebElement> listofAdelements = Learnmore.findElements(By.className("UIAStaticText"));
				System.out.println("Learn More Present");

				if(n==x){
					scroll_Down();
					x=x+n;
				}

			}catch(Exception e){
				System.out.println("Learn more not displayed");
			}

		}

	}

	//Clear excel data
	public static void Clear_Exceldata(String Pagename) throws Exception{
		readExcelValues.excelValues("Cust_Param_Result",Pagename);

		for(int feeds=1;feeds<=6;feeds++){

			String[][] data1 = new String[10][10];
			ExcelData er1 = new ExcelData();
			data1 = er1.excelread("Cust_Param_Result",Pagename);

			int Getresult1 = feeds*2;
			//Change values for entering result into all the feeds
			int ResultColumn_n1=7+Getresult1;
			int ResultColumn_n2=8+Getresult1;

			//Write results into Excel
			WriteResultintoExcel wResult1 = new WriteResultintoExcel();
			for(int testcase=1;testcase<=43;testcase++)
			{
				wResult1.enterResult("SMOKE", "n", "n", testcase, ResultColumn_n1, ResultColumn_n2);

			}

		}
	}

	//read Turbo api call
	public static void Read_Turbo_api(String Excelname, String sheetName) throws Exception{
		readExcelValues.excelValues(Excelname,sheetName);
		Hardcode=readExcelValues.data[18][Cap];

		if(Functions.sb.toString().contains(readExcelValues.data[17][Cap])){
			System.out.println("ad call is pressent");

			int sheetVal;
			if(sheetName=="readTruboApi"){
				adcal = sb.toString().substring(sb.toString().lastIndexOf(readExcelValues.data[17][Cap]));
				adcal = sb.toString().substring(sb.toString().lastIndexOf(readExcelValues.data[17][Cap]));
				adreq1 = adcal.toString().substring(adcal.toString().indexOf(readExcelValues.data[7][Cap]));

				if(adreq1.contains(readExcelValues.data[8][Cap]) || adreq1.contains(readExcelValues.data[9][Cap])||adreq1.contains(readExcelValues.data[10][Cap])){
					adreq1= adreq1.toString().replaceAll(readExcelValues.data[8][Cap], "=");
					adreq1= adreq1.toString().replaceAll(readExcelValues.data[9][Cap], "&");
					adreq1= adreq1.toString().replaceAll(readExcelValues.data[10][Cap], ",");
				}else{
					System.out.println("not a ad call");
				}


				int sizeparam = readExcelValues.data[14][Cap].length();
				adreq1 = adreq1.substring(adreq1.indexOf(readExcelValues.data[14][Cap])+sizeparam,adreq1.indexOf(readExcelValues.data[15][Cap]));
				//System.out.println("feed call zip is "+ pubreq1.toString());
				if(Excelname=="Smoke"){
					adreq1=adreq1.toString();
				}else{
					adreq1=adreq1.replaceAll("^\"|}:\"$","");
					adreq1=adreq1.replaceAll("\"","");
					adreq1=adreq1.replaceAll(",","&");
					adreq1=adreq1.replaceAll("=&","=nl&");
					adreq1=adreq1.replaceAll("}","");
					adreq1=adreq1.replaceAll("ci","");
					//pubreq1=pubreq1.replaceAll(":","=");
				}

				ads.add(adreq1.toString());
				//System.out.println("feed call Values is "+ ads);

				System.out.println("ads data is :"+ads);
				System.out.println("***********************************");

			}
		}


	}



	//Verify pubad call from XML File
	//	public static void verifyPubadCal_CustParam(int feed,String Excelname, String sheetName,String Param_Validation) throws Exception{
	//		readExcelValues.excelValues(Excelname,sheetName);
	//		//Get Pubad call from 
	//
	//
	//		if(Functions.sb.toString().contains(readExcelValues.data[17][Cap])){
	//			System.out.println("ad call is pressent");
	//
	//			int sheetVal;
	//			if(sheetName=="readTruboApi"){
	//				adcal = sb.toString().substring(sb.toString().lastIndexOf(readExcelValues.data[17][Cap]));
	//				adcal = sb.toString().substring(sb.toString().lastIndexOf(readExcelValues.data[17][Cap]));
	//				adreq1 = adcal.toString().substring(adcal.toString().indexOf(readExcelValues.data[7][Cap]));
	//
	//				if(adreq1.contains(readExcelValues.data[8][Cap]) || adreq1.contains(readExcelValues.data[9][Cap])||adreq1.contains(readExcelValues.data[10][Cap])){
	//					adreq1= adreq1.toString().replaceAll(readExcelValues.data[8][Cap], "=");
	//					adreq1= adreq1.toString().replaceAll(readExcelValues.data[9][Cap], "&");
	//					adreq1= adreq1.toString().replaceAll(readExcelValues.data[10][Cap], ",");
	//				}else{
	//					System.out.println("not a ad call");
	//				}
	//
	//
	//				int sizeparam = readExcelValues.data[14][Cap].length();
	//				adreq1 = adreq1.substring(adreq1.indexOf(readExcelValues.data[14][Cap])+sizeparam,adreq1.indexOf(readExcelValues.data[15][Cap]));
	//				//System.out.println("feed call zip is "+ pubreq1.toString());
	//				if(Excelname=="Smoke"){
	//					adreq1=adreq1.toString();
	//				}else{
	//					adreq1=adreq1.replaceAll("=&","=nl&");
	//					adreq1=adreq1.replaceAll("^\"|:\"$","");
	//					adreq1=adreq1.replaceAll("\"","");
	//					adreq1=adreq1.replaceAll(",","&");
	//					//adreq1=adreq1.replaceAll("=&","=nl&");
	//
	//					//pubreq1=pubreq1.replaceAll(":","=");
	//				}
	//
	//				ads.add(adreq1.toString());
	//				//System.out.println("feed call Values is "+ ads);
	//
	//				System.out.println("ads data is :"+ads);
	//				System.out.println("***********************************");
	//
	//			}else{
	//				//for(int feeds=1;feeds<=5;feeds++){
	//				pubads.clear();
	//
	//				pubadcal = sb.toString().substring(sb.toString().lastIndexOf(readExcelValues.data[17][Cap])+feed);
	//				pubadcal = sb.toString().substring(sb.toString().lastIndexOf(readExcelValues.data[17][Cap]));
	//				pubreq1 = pubadcal.toString().substring(pubadcal.toString().indexOf(readExcelValues.data[7][Cap]));
	//
	//				if(pubreq1.contains(readExcelValues.data[8][Cap]) || pubreq1.contains(readExcelValues.data[9][Cap])||pubreq1.contains(readExcelValues.data[10][Cap])){
	//					pubreq1= pubreq1.toString().replaceAll(readExcelValues.data[8][Cap], "=");
	//					pubreq1= pubreq1.toString().replaceAll(readExcelValues.data[9][Cap], "&");
	//					pubreq1= pubreq1.toString().replaceAll(readExcelValues.data[10][Cap], ",");
	//				}else{
	//					System.out.println("not a ad call");
	//				}
	//
	//				int sizeparam = readExcelValues.data[14][Cap].length();
	//				pubreq1 = pubreq1.substring(pubreq1.indexOf(readExcelValues.data[14][Cap])+sizeparam,pubreq1.indexOf(readExcelValues.data[15][Cap]));
	//				//System.out.println("feed call zip is "+ pubreq1.toString());
	//				if(Excelname=="Smoke"){
	//					pubreq1=pubreq1.toString();
	//				}else{
	//					pubreq1=pubreq1.replaceAll("^\"|:\"$","");
	//					pubreq1=pubreq1.replaceAll("\"","");
	//					pubreq1=pubreq1.replaceAll(",","&");
	//					pubreq1=pubreq1.replaceAll("_"," ");
	//				}
	//
	//				pubads.add(pubreq1.toString());
	//				System.out.println("Pubads data is :"+pubads.toString());
	//				System.out.println("=================================");
	////				Cust_param cp = new Cust_param();
	//				//Read Excel
	//				String[][] data = new String[10][10];
	//				ExcelData er = new ExcelData();
	//				data = er.excelread("Cust_Param_Result","AllParams");
	//				Write_result wrResult = new Write_result();
	//
	//
	//				for(int filln = 1;filln<=44;filln++){
	//					wrResult.WriteResult("AllParams","n",filln,2);
	//					wrResult.WriteResult("AllParams","n",filln,3);
	//					wrResult.WriteResult("AllParams","n",filln,4);
	//				}
	//
	//				for(String pubreq2:pubads){
	//					String str[] = pubreq2.split("&");
	//
	//					for(String pubreq3:ads){
	//						String str1[] = pubreq3.split("&");
	//						for (String ssss : str) {
	//							String s[] = ssss.split("=");
	//
	//							for (String sss : str1) {
	//								String s1[] = sss.split("=");
	//								if(s[0].equals(Param_Validation)){
	//									if(s[0].equals(s1[0])){
	//
	//										if(s[1].equals(s1[1])){
	//											System.out.println("Pubad Param :"+s[0] +"-----"+ "Pubad Value :"+s[1]);
	//											System.out.println("ad Param :"+s1[0] +"-----"+ " ad Value :"+s1[1]);
	//											System.out.println("Values are matched ");
	//											for(int paramtot =1;paramtot<=43;paramtot++){
	//												//System.out.println("Exceldata is :"+data[paramtot][0].toString());
	//												if(s[0].equals(data[paramtot][0])){
	//													if(data[paramtot][1].toString().contains(s1[1])){
	//														wrResult.WriteResultAllParams("AllParams",s1[1].toString(),"Passed",paramtot,3,4);
	//														wrResult.WriteResultAllParams("AllParams",s[1].toString(),"Passed",paramtot,2,3);
	//														cp.Param_val = "Pass";
	//
	//														break;
	//													}else
	//													{
	//														wrResult.WriteResultAllParams("AllParams",s1[1].toString(),"MisMatched",paramtot,3,4);
	//														wrResult.WriteResultAllParams("AllParams",s[1].toString(),"MisMatched",paramtot,2,3);
	//														cp.Param_val = "Fail";
	//														break;
	//													}
	//												}
	//
	//											}
	//
	//											//cp.Param_val = "Pass";
	//
	//											System.out.println("==================================");
	//										}else{
	//											System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	//											System.out.println("Pubad Param :"+s[0] +"-----"+ "Pubad Value :"+s[1]);
	//											System.out.println("ad Param :"+s1[0] +"-----"+ " ad Value :"+s1[1]);
	//											System.out.println("Values are not matched");
	//											for(int paramtot =1;paramtot<=43;paramtot++){
	//												if(s[0].equals(data[paramtot][0])){
	//													wrResult.WriteResultAllParams("AllParams",s1[1].toString(),"Failed",paramtot,2,3);
	//													cp.Param_val = "Fail";
	//													break;
	//												}
	//
	//											}
	//
	//											System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	//										}
	//									}else{
	//
	//									}
	//								}else{
	//									//	System.out.println(Param_Validation+" --Paramter not available");
	//								}
	//							}
	//						}
	//					}
	//				}
	//				//}
	//			}
	//
	//
	//
	//
	//
	//		}
	//		else{
	//			System.out.println("bb ad call is not pressent");
	//			Assert.fail("bb ad call is not pressent");
	//		}
	//
	//
	//		;
	//	}
	//Verify Cust_Params from Pubad

	public static void verifyParamsFromPubadCal_CustParam(String Excelname,String sheetName) throws Exception{
		//container=null;
		readExcelValues.excelValues(Excelname,sheetName);
		VerifypubadValues =readExcelValues.data[16][Cap];
		System.out.println("Pubad values are -"+VerifypubadValues);
		for(String pubreq2:pubads){
			String str[] = pubreq2.split("&");
			if(readExcelValues.data[16][Cap].contains(",")){
				String[] splitPubvalues= VerifypubadValues.split(",");
				for(int i=0;i<=splitPubvalues.length-1;i++){
					System.out.println("Pubad value is -"+splitPubvalues[i].toString()+"----Size is"+splitPubvalues.length);
					for (String ssss : str) {
						String s[] = ssss.split("=");
						int sheetVal;
						if(sheetName=="readTruboApi"){
							sheetVal=1;
						}else{
							sheetVal=2;
						}

						if (s[0].equals(splitPubvalues[i].toString())) {
							if(i>=0){
								if(sheetVal==1){
									AdParams = s[1].toString();
									System.out.println(splitPubvalues[i]  +" Param value is :" + AdParams);
									advalues.add(AdParams);
									Thread.sleep(1000);
									System.out.println("all ad Param value is :" + advalues);

								}else
								{

									AdParams = s[1].toString();
									System.out.println(splitPubvalues[i]  +" Param value is :" + AdParams);
									pubvalues.add(AdParams);
									Thread.sleep(1000);
									System.out.println("all ad Param value is :" + pubvalues);
								}

							}else if(s[0].equals("cxtg"))
							{

								seg = s[1].toString();
								System.out.println("seg is :"+seg);
								seg=seg.replaceAll(",",", ");
								cxtgcontainer.add(seg);
								System.out.println("CXTG Container is:" + cxtgcontainer);

							}else if(s[0].equals("wfxtg"))
							{
								seg = s[1].toString();
								System.out.println("seg is :"+seg);
								seg=seg.replaceAll(",",", ");
								wfxtgcontainer.add(seg);
								System.out.println("WFXTG Container is:" + wfxtgcontainer);

							}else
							{
								seg = s[1].toString();
								String[] items = seg.split(",");
								container = Arrays.asList(items);
								System.out.println("Container is:" + container);
								System.out.println("Container size is:" + container.size());
							}
						}
					}
				}

			}
			else
			{
				for (String ssss : str) {
					String s[] = ssss.split("=");

					if (s[0].equals(VerifypubadValues.toString())) {
						firstParamValue = s[1].toString();
						System.out.println(VerifypubadValues +"Param value is :" + firstParamValue);
					}

				}

			}
		}
	}

	//read DSX Call from Logs
	public static void readDSX_call(int feed,String Pagename1,String Pagename2,String Param_Validation) throws Exception{

		//		readExcelValues.excelValues("Cust_Param",Pagename1);
		//		Functions.verifyPubadCal_CustParam(feed,"Cust_Param",Pagename1,Param_Validation);
		//
		//		readExcelValues.excelValues("Cust_Param",Pagename2);
		//		Functions.verifyPubadCal_CustParam(feed,"Cust_Param",Pagename2,Param_Validation);

	}

	//Take Screenshot
	public static void TakeScreenshot() throws Exception{
		readExcelValues.excelValues("Smoke","Paths");
		File Screenshot = ((TakesScreenshot)Ad).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime());
		FileUtils.copyFile(Screenshot, new File(readExcelValues.data[16][Cap]+"/ScreenShot-"+timeStamp+".png"));

	}

	//Download app from Hockey
	public static void app_download_from_hockeyapp() throws InterruptedException, IOException, Exception{
		readExcelValues.excelValues("Smoke","Paths");
		FirefoxProfile profile1 = new FirefoxProfile();
		profile1.setPreference("browser.download.folderList",2);
		profile1.setPreference("browser.download.panel.shown", false);
		profile1.setPreference("browser.download.dir",readExcelValues.data[15][Cap]);
		profile1.setPreference("browser.helperApps.neverAsk.openFile","text/xml,text/csv,application/x-msexcel,application/octet-stream,application/vnd.android.package-archive,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/apk,application/ipa");
		profile1.setPreference("browser.helperApps.neverAsk.saveToDisk","text/xml,text/csv,application/x-msexcel,application/octet-stream,application/vnd.android.package-archive,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/apk,application/zip");


		readExcelValues.excelValues("Smoke","DownloadApp");
		driver_ipa = new FirefoxDriver(profile1);
		driver_ipa.manage().window().maximize();
		driver_ipa.get(readExcelValues.data[1][Cap]);
		driver_ipa.findElement(By.id("user_email")).sendKeys(readExcelValues.data[2][Cap]);
		driver_ipa.findElement(By.id("user_password")).sendKeys(readExcelValues.data[3][Cap]);
		driver_ipa.findElement(By.name(readExcelValues.data[4][Cap])).click();

		Thread.sleep(2000);
		WebElement AppType = driver_ipa.findElement(By.xpath(readExcelValues.data[5][Cap]));
		String Apps = AppType.getText();
		System.out.println("Apps text :: "+Apps);
		if(Apps.contains(readExcelValues.data[6][Cap])){
			System.out.println("Apps content already in :: "+Apps);
		}else{


			AppType.click();
			Thread.sleep(2000);
			for(int i=2;i<=7;i++){
				WebElement platforms = driver_ipa.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/ul/li[2]/ul/li["+i+"]/a/span"));
				String platformsText = platforms.getText();
				System.out.println("platforms text is :: "+platformsText);
				if(platformsText.contains(readExcelValues.data[6][Cap])){
					Thread.sleep(2000);
					platforms.click();
					System.out.println("Selected "+platformsText +" in the Platforms Dropdown");
					break;
				}else{
					System.out.println(platformsText +"not found in the list");
				}
			}
		}
		Thread.sleep(2000);
		for(int j=1;j<=15;j++){
			WebElement build =  driver_ipa.findElement(By.xpath("/html/body/div[2]/div[2]/div/table/tbody/tr["+j+"]/td[2]"));
			buildText = build.getText();
			Thread.sleep(2000);
			if(buildText.contains(readExcelValues.data[7][Cap])){
				JavascriptExecutor jse = (JavascriptExecutor)driver_ipa;
				jse.executeScript("window.scrollBy(0,350)", "");
				System.out.println("Buid Text is : "+buildText);
				build.click();
				break;
			}
		}
		int k;
		for(k=1;k<=5;k++){
			try{
				if(driver_ipa.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div/form/table/tbody/tr["+k+"]/td[4]/div/a/i")).isDisplayed()){
					System.out.println("K is "+k);
					break;
				}

			}catch (Exception e){

			}
		}

		WebElement Build_Name = driver_ipa.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div[1]/div/form/table/tbody/tr["+k+"]/td[2]/div"));
		BuildName =Build_Name.getText();
		//String Latest_DownloadedBuild = Ad.findElementByXPath("/html/body/div[2]/div[1]/div[2]/div[1]/div/form/table/tfoot/tr/td[1]/a").getText();
		Thread.sleep(2000);
		System.out.println("Buid Name is : "+BuildName);


		FileOutputStream fos =  new FileOutputStream(properties.getProperty("dataFilePath"));

		properties.setProperty("New_Build",BuildName);
		properties.store(fos, "Build Information to download the latest apk and run the scripts");
		fos.close();

		old_Build = properties.getProperty("Old_Build");
		new_build=properties.getProperty("New_Build");
		System.out.println("Old Build :"+old_Build +"-----"+"New Build :"+new_build);
		if(new_build.equals(old_Build)){
			System.out.println("Old build and new build is same no need to download build");
			driver_ipa.manage().deleteAllCookies();
			driver_ipa.close();
		}else{
			System.out.println("Old build and new build is not same please download the build and start testing");	
			Functions.delete_IPA();
			readExcelValues.excelValues("Smoke","DownloadApp");

			Build_Name.click();

			driver_ipa.findElement(By.id(readExcelValues.data[8][Cap])).click();
			//driver_ipa.findElement(By.xpath(readExcelValues.data[8][Cap])).click();
			Thread.sleep(15000);
			driver_ipa.manage().deleteAllCookies();
			driver_ipa.close();
			//Verify_IPA();
			Functions.Set_BuildNumber();
		}
	}
	public static void Set_BuildNumber() throws Exception{
		FileOutputStream fos =  new FileOutputStream(properties.getProperty("dataFilePath"));

		properties.setProperty("Old_Build",BuildName);
		properties.store(fos, "Build Information stotred");
		fos.close();
	}

	//read ipa details from Build Folder
	public static void listFilesForFolder(File folder) throws Exception {
		readExcelValues.excelValues("Smoke","Paths");
		folder = new File(readExcelValues.data[15][Cap]);
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {

				listFilesForFolder(fileEntry);

			} else {
				if(fileEntry.toString().contains("ipa")){

					ipaPath =readExcelValues.data[15][Cap]+fileEntry.getName();
					System.out.println("ipaPath is :"+ipaPath.toString());
					BuildNo=fileEntry.getName().replace(".ipa","");
					//					Write_result wrResult1 = new Write_result();
					//					wrResult1.WriteResult("Paths", ipaPath.toString(), 14, Cap);
					//					readExcelValues.excelValues("Smoke","Capabilities");
					//					wrResult1.WriteResult("Capabilities", ipaPath.toString(), 10, Cap);
					//  System.out.println("ipa is :"+readExcelValues.data[14][Cap]);
				}
			}
		}

	}
	//read Build folder details from Build Folder
	public static void CheckBuildFolder(File folder) throws Exception {
		readExcelValues.excelValues("Smoke","Paths");

		String Foldername = ScreenShot+"/"+BuildNo;
		folder = new File(Foldername);


		for(int i =0;i<=150;i++){
			if(i==0){
				folder = new File(Foldername);
			}else{
				folder = new File(Foldername+"_"+i);
			}
			if(folder.exists()){
				/*System.out.println("Build Number is exist "+BuildNo);
				System.out.println("Folder is :"+folder.toString());*/

			}else{
				if(i==0){
					System.out.println("Build Number is "+BuildNo);
					BuildNo=BuildNo;
					break;
				}else{
					System.out.println("Build Number is "+BuildNo+"_"+i);
					BuildNo=BuildNo+"_"+i;
					break;
				}
			}
		}

	}

	public static void main(String args[]) throws Exception
	{
		//		//		Functions.startCharlesSession();
		//		//		Functions.charles_Stop();
		//		//		//		delete_IPA();
		//		//		//		app_download_from_hockeyapp();
		//		//		//STR
		//		//Functions.app_download_from_hockeyapp();
		//		//		Functions.uninstallApp();
		//		//		Functions.installApp();
		//		//Functions.Appium_Autostart();
		//		//		Functions.delete_folder();
		//		//		Functions.clear_session();
		//		//				Functions.capabilities();
		//		//				Functions.launchtheApp();
		//		//	Functions.uninstall_installApp();
		//		//		Functions.scroll_Down();
		//		//		Functions.downloadXMLFile();
		//		//Functions.readXML();
		//		//Functions.readDSX_call(5,"readTruboApi","readPubads");
		//		//Functions.downloadXMLFile();
		//		//Functions.Verify_feedcals("CleanLaunch");
		//		//		Functions.readXML();
		//		//		Functions.verifyPubadCal("Smoke","TestMode");
		//		//		Functions.thirdPart_Beacon();
		//		//		System.out.println("Turbo Api value are :"+Functions.ads);
		//
		//		//Preconditions
		//		Functions.startCharlesSession();
		//		Functions.charles_Stop();
		//		Functions.delete_screenshots();
		//		//
		//		//		Functions.delete_IPA();
		//		//		Functions.app_download_from_hockeyapp();
		//
		//		//		Functions.startCharlesSession();
		//		//		Functions.charles_Stop();
		//		//STR
		//		Functions.uninstallApp();
		//		Functions.installApp();
		//		Functions.Appium_Autostart();
		//		Functions.capabilities();
		//		Functions.launchtheApp();
		//		System.out.println("==============================================");
		//		System.out.println("****** WFX Trigger CXTG Cal test cases Started");
		//		Functions.delete_folder();
		//		Functions.navigatetoSettingPage();
		//		Functions.verifyuserloggedIn();
		//		Functions.logIn();
		//		//Functions.close_launchApp();
		//		Functions.clear_session();
		//		Functions.Kill_realaunch();
		//		//		Functions.close_launchApp();
		//		Functions.downloadXMLFile();
		//		Functions.readXML();
		//		Functions.verifyAPICal("WFXTrigger");
		//		//Functions.readwfxTriggers("WFXTrigger") ;
		//		Functions.navigatetoAddressPage();
		//		Functions.verifysavedAddresses();
		//		Functions.selectsavedAddresses(2);
		//		Functions.readwfxTriggers("WFXTrigger") ;
		//		//Functions.verifyPubadCal("WFXTrigger");
		//		Functions.verify_wfxtg("WFXTrigger");

		//		String[] str1 ={"/usr/bin/open", "-c", "node ." , "/Users/aparna/Downloads/appium163"};
		//		Process p1 = Runtime.getRuntime().exec(str1);
		//		String cmd = "/Users/aparna/Downloads/appium163/node ." ;
		//		Runtime run = Runtime.getRuntime() ;
		//		Process pr = run.exec(cmd) ;
		//		pr.waitFor() ;
		//		BufferedReader buf = new BufferedReader( new InputStreamReader( pr.getInputStream() ) ) ;
		//
		//		

		//Runtime.getRuntime().exec("/bin/bash -c appium >> /Users/aparna/Documents/Naresh/com.werather.SmokeiOS/LogFilePath/syslog.log");

		//		Functions.readXML();
		//		Functions.verifyPubadCal("Smoke","LocationWFX");
		//		Functions.verifyAPICal("LocationWFX");
		//		Functions.readlocation_wfxTriggers("LocationWFX") ;

		//		String[] str1 ={"/bin/bash", "-c", "/usr/local/bin/appium>"+" "+"/Users/vishal.pathania/Documents/loger/syslog.log"};
		//		Process p1 = Runtime.getRuntime().exec(str1);
		//		String[] str2 ={"/bin/bash", "-c", "/usr/local/bin/ideviceinstaller -l>>"+" "+"/Users/vishal.pathania/Documents/loger/syslog1.log"};
		//		Process p2 = Runtime.getRuntime().exec(str2);
		//Thread.sleep(200000);
		//Functions.move_Files("report_MoveFiles");
		Functions.Take_Report_Screenshot();


	}


	public static void Scroll_end() throws Exception {readExcelValues.excelValues("Smoke","General");
	logStep("User on Cc page and trying to scroll the app till end");
	for(int scrollend=1;scrollend<=12;scrollend++){
		try{
			if(Ad.findElementByName(readExcelValues.data[1][Cap]).isDisplayed()){
				System.out.println("User done scrolling");
				logStep("User done scrolling till last page");
				break;
			}
		}
		catch(Exception e){
			System.out.println("last page not found, Need to scrol till the end");
			if(scrollend==12){
				logStep("last page not found");
			}
		}
		try{
			scroll_Down();
			scroll_Down();
		}catch(Exception e){

			String[] strcleariProxy ={"/bin/bash", "-c", "killall iproxy xcodebuild XCTRunner"};
			Process proc = Runtime.getRuntime().exec(strcleariProxy);
			Assert.fail("Scrolling filed, need to execute test Case again	");
		}

	}
	}

	//Tap on video option on News page
	public static void taponVideo_ValidateAdzone(){
		VideoAdzone="Video";
		try{
			MobileElement Video = Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]");
			if(Video.getText().contains(":")){
				try{
					Video.click();

				}catch(Exception e){
					Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]").click();

				}
			}else{
				Ad.findElementByXPath("//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTable[1]/XCUIElementTypeCell[1]/XCUIElementTypeButton[1]").click();

			}


		}catch(Exception e){
			System.out.println("Video Not availale on the page");
		}
	}

	public static void read_Adzone_fromAPI() {

		String Adz;

		String []Adzonearray = req.split("adzone");
		int AdzoneSize = Adzonearray.length;
		int i=0;
		for(String Azone:Adzonearray){

			Adz = Azone.toString().substring(Azone.indexOf(":"),Azone.indexOf(","));
			if(i>0){
				Adz=Adz.replaceAll("\"", "");
				Adz=Adz.replaceAll(": ", "");
				System.out.println("Adz is : "+Adz.toString());
				AdzoneList.add(Adz.toString().trim());
				System.out.println("pubads value is : "+pubads.toString());

			}
			i=i+1;
			Adzonearray = Azone.split("adzone");
		}
		if(AdzoneList.isEmpty()){
			AdzoneList.add("display/details/articles");
		}
		if(pubads_video.isEmpty()){
			pubads_video=pubads;
		}
		outerloop:
			for(String VideoPubAd_iu:pubads_video){
				for(String Pubad_iu:pubads){
					for(String Adzone_iu:AdzoneList){
						if(Pubad_iu.equals(Adzone_iu)){
							System.out.println("AdZone iu's are Matched --- Adcall_iU : "+Pubad_iu+" ---- APICall_iu : "+Adzone_iu);
							break outerloop;
						}
					}

					Assert.fail("AdZone iu's are not Matched ");
				}

			}

	}
}