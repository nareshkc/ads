package com.Genaral;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Test_Parllal extends Driver {
	public static AppiumDriver<MobileElement> driver;
	public static AppiumDriverLocalService service;
	static int port = 4000*(int)(Math.random()*((5000-4000)+1));
	static int devicePort = 8000+(int)(Math.random()*((9000-8000)+1));

	public static void Setup() {
		
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
