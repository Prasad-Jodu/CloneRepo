package com.Nykaa;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.Nykaa.GenericUtility.BaseClass;
import com.Nykaa.GenericUtility.GestureUtility;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class PurchaseProductTest extends BaseClass {

	@Test
	public void purchaseProductTest() throws Throwable
	{
		GestureUtility gUtil=new GestureUtility(driver);
	driver.findElement(AppiumBy.id("com.fsn.nykaa:id/tv_search")).click();
	driver.findElement(AppiumBy.id("com.fsn.nykaa:id/search_field")).sendKeys("Maybelline");
	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Maybelline New York']")).click();
	gUtil.scroll("Superstay Vinyl Ink Liquid Lipstick");
	driver.findElement(AppiumBy.id("com.fsn.nykaa:id/ll_add_to_bag")).click();
	driver.findElement(AppiumBy.id("com.fsn.nykaa:id/badge_count")).click();
	driver.findElement(AppiumBy.id("com.fsn.nykaa:id/llProceedBtn")).click();

	}
}
