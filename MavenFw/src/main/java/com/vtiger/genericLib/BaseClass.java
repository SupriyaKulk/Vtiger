package com.vtiger.genericLib;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.ObjectRepository.HomePage;
import com.vtiger.ObjectRepository.LoginPage;



public class BaseClass {
	
		public WebDriverCommonLib wlib=new WebDriverCommonLib();
		public FileData data=new FileData();
		public static WebDriver driver=null;
		@BeforeSuite
		public void ConfigBS()
		{
			System.out.println("DB connect");
			
		}
		
		@BeforeClass
		public void configBC() throws IOException
		{
			String browser=data.FetchDataFromProperty("browser");
			System.out.println("Launch Browser");
			if(browser.equals("Chrome"))	
			{
				System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
				driver=new ChromeDriver();
			}
			else if(browser.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckodriver.exe");

				driver=new FirefoxDriver();
			}
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
		
		@BeforeMethod
		public void configBM() throws IOException
		{
			
			String un=data.FetchDataFromProperty("username");
			String pwd=data.FetchDataFromProperty("password");
			
			System.out.println("login done");
			driver.get(data.FetchDataFromProperty("url"));
			
			LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
			lp.loginToVtiger(un,pwd);
			
		}
		
		@AfterMethod
		public void configAM()
		{
			System.out.println("logout done");
			HomePage hp=PageFactory.initElements(driver, HomePage.class);
			hp.signOutFromVtiger();
		}
		
		@AfterClass
		public void configAC()
		{
			System.out.println("close browser");
			driver.quit();
		}
		@AfterSuite
		public void configAS()
		{
			System.out.println("DB Disconnect");
		}
		}


