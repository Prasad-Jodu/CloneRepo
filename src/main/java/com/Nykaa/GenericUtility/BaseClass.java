package com.Nykaa.GenericUtility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Provider.Service;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseClass {

	AppiumDriverLocalService service;
    public AndroidDriver driver;
	public static AndroidDriver sdriver;
	@BeforeSuite
	public void startService()
	{
		File f = new File("C:\\Users\\user\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js");
		 service = new AppiumServiceBuilder().withAppiumJS(f)
		.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
		
		service.start();
	}
	@BeforeClass
	public void openBrowser() throws Throwable
	{
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("deviceName", "Vivo Y27");
		dc.setCapability("automationName", "UiAutomator2");
		dc.setCapability("UDID", "10BD851JE1000FB");
		dc.setCapability("appPackage", "com.fsn.nykaa");
		dc.setCapability("appActivity", ".SplashScreenActivity");
		
		URL u=new URL("http://localhost:4723");
		 driver=new AndroidDriver(u,dc);
		 sdriver=driver;
	}
	@BeforeMethod
	public void login()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		driver.findElement(AppiumBy.id("com.fsn.nykaa:id/mobileNumber")).sendKeys("7780180333");
		driver.findElement(AppiumBy.id("com.fsn.nykaa:id/btnGetOtp")).click();
		driver.findElement(AppiumBy.id("com.fsn.nykaa:id/cross")).click();
		for(int i=0;i<=5;i++)
		{
			driver.findElement(AppiumBy.id("com.fsn.nykaa:id/recyclerView")).click();
	}
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void stopService()
	{
		service.stop();
	}
}
