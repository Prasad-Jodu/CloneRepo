package com.Nykaa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo {

	public static void main(String [] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jiomart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions a = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("(//a[.='Home & Kitchen']/ancestor::li[@class=\"header-nav-l1-item\"])"));
		a.moveToElement(element).perform();

		
	}
//	public static void Swiggy()
//	{
//		System.out.println("Thankyou to swiggy");
//	}
//
//public static void Swiggy(int a)
//	{
//		System.out.println("meals is" +a+" rupees");
//	}
}