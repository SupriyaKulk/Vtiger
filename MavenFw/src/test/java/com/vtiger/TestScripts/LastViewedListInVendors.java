package com.vtiger.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.crypto.Data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.genericLib.BaseClass;

@Listeners(com.vtiger.genericLib.ListenerImplementation.class)

public class LastViewedListInVendors extends BaseClass {
	
		@Test
		public void LastViewedListInVendors1() throws IOException
		{
		
		String ActTitle= driver.getTitle();
		String expTitle= data.fetchDatafromExcel("VendorsData",0,0);
		Assert.assertEquals(ActTitle, expTitle);
		System.out.println("Home page must be displayed");
		
	
		driver.findElement(By.linkText("More")).click();
		driver.findElement(By.linkText("Vendors")).click();
		
		String ActTitle1=driver.findElement(By.linkText("Vendors")).getText();
		String expTitle1= data.fetchDatafromExcel("VendorsData",2,0);
		Assert.assertEquals(ActTitle1, expTitle1);
		
		System.out.println("Vendors page must be displayed");
		
		
		driver.findElement(By.cssSelector("img[alt='Last Viewed']")).click();
		String ActTitle2=driver.findElement(By.id("Track_Handle")).getText();
		String expTitle2= data.fetchDatafromExcel("VendorsData",4,0);
		Assert.assertEquals(ActTitle2, expTitle2);
		
		System.out.println("Last Viewed Drop downlist must be displayed");
		

		
	}


	}


