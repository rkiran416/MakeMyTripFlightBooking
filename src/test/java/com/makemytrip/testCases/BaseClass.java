package com.makemytrip.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.makemytrip.utilities.ReadPropertyFile;

public class BaseClass extends ReadPropertyFile{

public static WebDriver driver=null;
	
	//Private constructor to limit initialization, Initializes browser based on inputs from properties file
	private BaseClass()
	{
		String browser=ReadPropertyFile.get("Browser");
		if(browser.equalsIgnoreCase("chrome")|| browser.toUpperCase().contains("CHROME"))
		{
			try{
				
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--incognito");

				DesiredCapabilities capabilites=DesiredCapabilities.chrome();
				capabilites.setCapability(ChromeOptions.CAPABILITY, options);
				driver=new ChromeDriver(options);
					
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(ReadPropertyFile.get("url"));
		driver.manage().deleteAllCookies();
	}
	
	//Initializes browser instance
	public static void initialize()
	{
		new BaseClass();
	}
	//quits browser
	
	
	  public static void quit() { 
		  driver.quit(); 
		  }
	 
	 
	

}
