package com.Functions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Genaral.Driver;

public class ExecutableFunctions extends Driver   {

	//Verify Bb ad call on pull to refresh
	public static void Function_pullto_refresh() throws Exception{
		Thread.sleep(2000);
		Functions.close_launchApp();
		Functions.enternewAddress_ifAddrssnotfound("30337");
		Functions.delete_folder("Charles");
		Functions.clear_session();
		Functions.scroll_Up();
		Thread.sleep(6000);
		Functions.downloadXMLFile();
		Functions.clear_sb();
		Functions.readXML();
		Functions.verifyPubadCal("Smoke","Pulltorefresh");
		Functions.pubads.clear();
		Functions.retryclear();
	}

	//Verify Bb ad call on Severe Modes to refresh
	public static void Function_BBValidation_withSevere(String severetype) throws Exception{
		Functions.contentmodemodule(severetype);
		////	Functions.close_launchApp();
		Functions.delete_folder("Charles");
		Functions.clear_session();
		Functions.close_launchApp();
		Thread.sleep(6000);
		Functions.downloadXMLFile();
		Functions.clear_sb();
		Functions.readXML();
		Functions.verify_bbadcall("Smoke","MapLocal",severetype);
		Functions.retryclear();
	}

	//Verify Ad presented on UI of Hourly Module
	public static void Function_extened_HourlyPage_ads() throws Exception {
		Thread.sleep(2000);
		logStep("Hourly ad verification started");
		Functions.Verify_selectedPages("Hourly");
		//		Functions.Navigate_extendedPages("Hourly");
		Functions.Verify_Adpresenton_extendedPages("Hourly");
		Functions.retryclear();
	}


	//Ad validation after nav back from ad page
	public static void Function_Smoke_Test_Case_VerifyAdCals_BackfromAdsPage() throws Exception{
		Functions.TestName="Ad Validation";
		ExecutableFunctions.Function_extened_HourlyPage_ads();
		//		Ad.findElementByName("Return to The Weather").click();
		//		Thread.sleep(3000);
		//		//Functions.Scroll_end();
		//		Functions.downloadXMLFile();
		//		Functions.clear_sb();
		////		Functions.readXML();
		//		Functions.Verify_feedcals("CleanLaunch");
	}

	//Verify Ad presented on UI of Daily Module
	public static void Function_extened_DailyPage_ads() throws Exception {
		logStep("Daily ad verification started");
		Functions.Verify_selectedPages("Daily");
		//Functions.Navigate_extendedPages("Daily");
		Functions.Verify_Adpresenton_extendedPages("Daily");
		Functions.retryclear();
	}

	//Verify Ad presented on UI of Map Module
	public static void Function_extened_MapPage_ads() throws Exception {
		logStep("Map ad verification started");
		Functions.Verify_selectedPages("Map");
		//Functions.Navigate_extendedPages("Map");
		Functions.Verify_Adpresenton_extendedPages("Map");
		Functions.retryclear();
	}

	//Verify Ad presented on UI of Hurricane Module
	public static void Function_extened_Hurricane_ads() throws Exception {
		logStep("Hurricane ad verification started");
		Functions.Verify_selectedPages("Hurricane(MainPage)");
		Functions.Navigate_extendedPages("Hurricane(MainPage)");
		Functions.Verify_Adpresenton_extendedPages("Hurricane(MainPage)");
		Functions.Navigate_Submodule("Hurricane(SubModule)");
		Functions.Verify_Adpresenton_extendedPages("Hurricane(SubModule)");
		Functions.navBackfrom_Submodule("Hurricane(SubModule)");
		Functions.retryclear();
	}

	//Verify ad presented on NEWS module UI
	public static void Function_extened_NewsPage_ads() throws Exception {
		logStep("News ad verification started");
		Functions.Verify_selectedPages("News");

		Functions.Verify_Adpresenton_extendedPages("News");

	}

	//Verify ad presented on NEWS module UI
	public static void Function_validate_BB_ads(String BBType) throws Exception {
		logStep(BBType +"ad verification started");
		WebDriverWait wait = new WebDriverWait(Ad,15);
		WebElement adPlace=null;
		if(BBType.equals("StaticBB")) {
			logStep("Validating "+BBType +" Ad ");
			Functions.enternewAddress("Bridgeton, New Jersey");
			try {
				Thread.sleep(5000);
				adPlace = wait.until(ExpectedConditions.visibilityOf(Ad.findElementByName("view_currentConditionsBrandedBGDContainerWeatherContainer")));
				//Ad.findElementByName("ftl-bg-gradient");
				if(adPlace.isDisplayed()) {
				logStep(BBType+ "ad present on the screen");
				System.out.println(BBType+ "ad present on the screen");
				Functions.ScreenShot(BBType,"Passed");
				}

			}catch(Exception e) {
				logStep(BBType+ "ad not present on the screen");
				System.out.println(BBType+ " ad not present on the screen");
				Functions.ScreenShot(BBType,"Failed");
				Assert.fail(BBType+ " ad not present on the screen");

			}

		}else if(BBType.equals("nativeBB")) {
			logStep("Validating "+BBType +" Ad ");
			Functions.enternewAddress("Pond Eddy, New York");
			try {
				Thread.sleep(5000);
				adPlace = wait.until(ExpectedConditions.visibilityOf(Ad.findElementByName("view_currentConditionsBrandedBGDContainerWeatherContainer")));
				//Ad.findElementByName("ftl-bg-gradient");
				if(adPlace.isDisplayed()) {
				logStep(BBType+ "ad present on the screen");
				System.out.println(BBType+ "ad present on the screen");
				Functions.ScreenShot(BBType,"Passed");
				}

			}catch(Exception e) {
				logStep(BBType+ "ad not present on the screen");
				System.out.println(BBType+ " ad not present on the screen");
				Functions.ScreenShot(BBType,"Failed");
				Assert.fail(BBType+ " ad not present on the screen");

			}

		}else if(BBType.equals("native_animated_BB")) {
			logStep("Validating "+BBType +" Ad ");
			Functions.enternewAddress("Rainbow City, Alabama");
			Ad.swipe(181, 91, 3, 494, 2000);
			try {
				Thread.sleep(5000);
				adPlace = wait.until(ExpectedConditions.visibilityOf(Ad.findElementByName("view_currentConditionsBrandedBGDContainerWeatherContainer")));
				//Ad.findElementByName("ftl-bg-gradient");
				if(adPlace.isDisplayed()) {
				logStep(BBType+ "ad present on the screen");
				System.out.println(BBType+ "ad present on the screen");
				Functions.ScreenShot(BBType,"Passed");
				}

			}catch(Exception e) {
				logStep(BBType+ "ad not present on the screen");
				System.out.println(BBType+ " ad not present on the screen");
				Functions.ScreenShot(BBType,"Failed");
				Assert.fail(BBType+ " ad not present on the screen");

			}

		}else if(BBType.equals("nativeAd")) {
				//Functions.enternewAddress("Bridgeton, New Jersey");
				Functions.close_launchApp();
				int scroolloop=1;
				for(scroolloop=1;scroolloop<=9;scroolloop++) {
					try {

						if(Ad.findElementById("Sponsored").isDisplayed()){
							logStep(BBType+ "ad present on the screen");
							System.out.println(BBType+ " ad present on the screen");
							Functions.ScreenShot(BBType,"Passed");
							break;
						}else {
							Functions.scroll_Down();
							if(scroolloop==9) {
								logStep(BBType+ "ad not present on the screen");
								System.out.println(BBType+ " ad not present on the screen");
								Functions.ScreenShot(BBType,"Failed");
								Assert.fail(BBType+ " ad not present on the screen");
							}
						}

					}catch(Exception e) {
						Functions.scroll_Down();
						if(scroolloop==9) {
							logStep(BBType+ "ad not present on the screen");
							System.out.println(BBType+ " ad not present on the screen");
							Functions.ScreenShot(BBType,"Failed");
							Assert.fail(BBType+ " ad not present on the screen");
						}

					}
				}


			}else{
				Functions.enternewAddress("Dodson, Montana");
				try {
					adPlace = wait.until(ExpectedConditions.visibilityOf(Ad.findElementByName("view_currentConditionsBrandedBGDContainerWeatherContainer")));
					//Ad.findElementByName("view_currentConditionsBrandedBGDContainerWeatherContainer");
					if(adPlace.isDisplayed()) {
					logStep(BBType+ "ad present on the screen");
					System.out.println(BBType+ "ad present on the screen");
					Functions.ScreenShot(BBType,"Passed");
					}
				}catch(Exception e) {
					logStep(BBType+ "ad not present on the screen");
					System.out.println(BBType+ " ad not present on the screen");
					Functions.ScreenShot(BBType,"Failed");
					Assert.fail(BBType+ " ad not present on the screen");

				}
			}



	}
	//Verify Adzone with iu Param
	public static void Function_VerifyAdzones() throws Exception {
		logStep("Adzone param  verification started");
		Functions.delete_folder("Charles");
		Functions.clear_session();
		Functions.close_launchApp();
		Functions.Verify_selectedPages("News");
		Functions.downloadXMLFile();
		Functions.clear_sb();
		Functions.readXML();
		Functions.verifyAPICal("Adzone");
		Functions.delete_folder("Charles");
		Functions.clear_session();
		Functions.Navigate_extendedPages("News");
		Functions.downloadXMLFile();
		Functions.clear_sb();
		Functions.readXML();
		Functions.verifyPubadCal("Smoke","Adzone");
		Functions.taponVideo_ValidateAdzone();
		Functions.downloadXMLFile();
		Functions.clear_sb();
		Functions.readXML();
		Functions.verifyPubadCal("Smoke","Adzone");
		Functions.read_Adzone_fromAPI();

		//			Functions.delete_folder("Charles");
		//			Functions.clear_session();
		//			
		//			
		//			Functions.downloadXMLFile();
		//			Functions.clear_sb();
		//			Functions.readXML();
		//			Functions.read_Adzone_fromAPI();
	}
	//Verify all ad feed ad cals on clean launch
	public static void Function_cleanlaunch() throws Exception {
		logStep("feed ad calls verification started on clean launch");
		Functions.contentmodemodule("normal");
		Functions.delete_folder("Charles");
		Functions.clear_session();
		Functions.close_launchApp();
		Functions.Scroll_end();
		Functions.downloadXMLFile();
		Functions.clear_sb();
		Functions.readXML();
		Functions.Verify_feedcals("CleanLaunch");
		//Functions.close_launchApp();
		Functions.pubads.clear();
		Functions.retryclear();
	}

	//Verify all ad feed ad cals after navigate from weather widget
	public static void Function_Feedcalls_FromWeather_Widget() throws Exception {
		logStep("Verifing all feed all cals after navigating from Weather Widget ");
		Functions.delete_folder("Charles");
		Functions.clear_session();
		//Functions.Kill_realaunch();
		Functions.navigateto_Widgetpage();
		Functions.validateWidgetLogs();
		Functions.pubads.clear();
		Functions.retryclear();
	}

	//verify WFXTG and Cxtg values with ad call
	public static void Function_WFXTriggers_cxtg() throws Exception {
		Functions.delete_folder("Charles");
		Functions.navigatetoSettingPage();
		Functions.verifyuserloggedIn();
		Functions.logIn();
		//Functions.close_launchApp();
		Functions.delete_folder("Charles");
		Functions.clear_session();
		Functions.close_launchApp();
		Thread.sleep(8000);
		Functions.downloadXMLFile();
		Functions.readXML();
		Functions.verifyAPICal("WFXTrigger");
		//Functions.readwfxTriggers("WFXTrigger") ;
		Functions.navigatetoAddressPage();
		Functions.verifysavedAddresses();
		Functions.selectsavedAddresses(1);
		Functions.readwfxTriggers("WFXTrigger") ;
		//Functions.verifyPubadCal("WFXTrigger");
		Functions.verify_wfxtg("WFXTrigger");
		Functions.pubads.clear();
		Functions.retryclear();
	}

	//Verify Factual values with ad call
	public static void Function_WFXTriggers_Factuals() throws Exception {
		Functions.verifyPubadCal("Smoke","LocationWFX");
		Functions.verifyAPICal("LocationWFX");
		Functions.readlocation_wfxTriggers("LocationWFX") ;	
		//Functions.pubads.clear();
		Functions.retryclear();
	}

	//Verify lotame values with ad call
	public static void Function_Lotame() throws Exception {
		Functions.verifyPubadCal("Smoke","Lotame");
		Functions.verifyAPICal("Lotame");
		Functions.readlocation_wfxTriggers("Lotame") ;
		Functions.pubads.clear();
		Functions.retryclear();
	}

	//Verify bb ad call in test mode
	public static void Function_Pubadcall_in_TestMode() throws Exception {
		try{
			Functions.Setappinto_TestMode();
			Functions.delete_folder("Charles");
			Functions.clear_session();
			Functions.enternewAddress("Bridgeton, New Jersey");
			Functions.downloadXMLFile();
			Functions.clear_sb();
			Functions.readXML();
			Functions.verifyPubadCal("Smoke","TestMode");
			Functions.retryclear();
		}catch(Exception e){
			String[] strcleariProxy ={"/bin/bash", "-c", "killall iproxy xcodebuild XCTRunner"};
			Process proc = Runtime.getRuntime().exec(strcleariProxy);
			Assert.fail("Test Mode not set properly or Scroll function error");
		}
	}

	//Verify Thirdparty beacon on bb ad call in test mode
	public static void Function_ThirdParty_beacons() throws Exception {
		Functions.thirdPart_Beacon();
		Functions.pubads.clear();
	}

	//Preroll ad verification in test mode
	public static void Function_PrerollAd() throws Exception {
		Functions.delete_folder("Charles");
		Functions.clear_session();
		Functions.Verify_selectedPages("PreRollVideo");
		Functions.Navigate_extendedPages("PreRollVideo");
		Functions.downloadXMLFile();
		Functions.clear_sb();
		Functions.readXML();
		Functions.verifyPubadCal("Smoke","PreRollVideo");
		Functions.navBack_fromExtendedPage("PreRollVideo");
		//Functions.Verify_videoads();
		Functions.pubads.clear();
		Functions.retryclear();
	}

	//Health module(Allergy and Colu&Flu) ads Verification
	public static void Function_extened_LSModule_ads(String HealthModule) throws Exception {
		Functions.Verify_selectedPages(HealthModule);
		//Functions.Navigate_extendedPages("LSModule(Allergy)");
		Functions.Verify_Adpresenton_extendedPages(HealthModule);
		Functions.pubads.clear();
		Functions.retryclear();
		Functions.clear_session();
	}

	//Watson ad verification
	public static void Function_Watson_Ads() throws Exception{
		Functions.delete_folder("Charles");
		Functions.clear_session();
		Functions.enternewAddress("Hoquiam, WA");   //west rocksburry
		Functions.Swipe_Conter(5);
		Functions.search_with_watson_ad("Hot");
		Functions.retryclear();
	}
}
