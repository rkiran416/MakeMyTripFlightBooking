package com.makemytrip.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.makemytrip.utilities.DatePicker;
import com.makemytrip.utilities.DynamicXpath;
import com.makemytrip.utilities.PageScroll;
import com.makemytrip.utilities.ReadPropertyFile;
import com.makemytrip.testCases.BaseClass;

public class HomePage {
	
	
	String datePickerXpath="//div[@aria-label='%replacable%' and @aria-disabled='false']";
		
	//Searches for flight by entering FROM,TO, DEPARTURE and RETURN details, clicks on search and returns object of flight result page
	  @Test
	  public void searchFlights() throws Exception
	  {
		  		  
		  BaseClass.driver.findElement(By.xpath("//li[contains(text(),'Round Trip')]/child::span")).click();
		  BaseClass.driver.findElement(By.id("fromCity")).click();
		  BaseClass.driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(ReadPropertyFile.get("From"));
		  WebElement autoselectfirstfromoption=BaseClass.driver.findElement(By.xpath("//li[@class='react-autosuggest__suggestion react-autosuggest__suggestion--first' and @data-section-index='0']"));
			
			WebDriverWait wait=new WebDriverWait(BaseClass.driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(autoselectfirstfromoption));
			
			autoselectfirstfromoption.click();
			
			//BaseClass.driver.findElement(By.id("toCity")).click();
			BaseClass.driver.findElement(By.id("toCity")).sendKeys(Keys.TAB);
			BaseClass.driver.findElement(By.id("toCity")).sendKeys(ReadPropertyFile.get("To"),Keys.ENTER);
			//BaseClass.driver.findElement(By.xpath("//input[contains(@placeholder,'To')]")).sendKeys("BOM");
			WebElement autoselectfirsttooption=BaseClass.driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));
			wait.until(ExpectedConditions.elementToBeClickable(autoselectfirsttooption));
			autoselectfirsttooption.click();
			
			BaseClass.driver.findElement(By.xpath("//label[@for='departure']")).click();
			//BaseClass.driver.findElement(By.xpath("//div[@class='fsw_inputBox dates inactiveWidget activeWidget']")).click();
			
			String datePickerXpath="//div[@aria-label='%replacable%' and @aria-disabled='false']";
			DatePicker date=DatePicker.getDates();
			BaseClass.driver.findElement(DynamicXpath.get(datePickerXpath, date.getDepartureDate())).click();
			BaseClass.driver.findElement(DynamicXpath.get(datePickerXpath, date.getReturnDate())).click();
			BaseClass.driver.findElement(By.xpath("//a[text()='Search']")).click();
			
			//
			List<WebElement> departureFilghts=BaseClass.driver.findElements(By.xpath("//div[@class='splitVw-sctn pull-left']/child::div[2]/child::div"));
			List<WebElement> ReturnFilghts=BaseClass.driver.findElements(By.xpath("//div[@class='splitVw-sctn pull-right']/child::div[2]/child::div"));
			
			PageScroll.toBottomOfPage();
			Thread.sleep(5000);
			if(departureFilghts.size()<1)
			{
				throw new Exception("No Flight availabe");
			}
			System.out.println("Depature Flght count:"+departureFilghts.size());
						
		    PageScroll.toUP();
		    Thread.sleep(5000);
			if(ReturnFilghts.size()<1)
			{
				throw new Exception("No Flight availabe");
				
			}
			System.out.println("Return Flght count:"+ReturnFilghts.size());
			
			for (WebElement e : departureFilghts) {
				String flightDetail = e.getText();
				//System.out.println(flightDetail);
				String[] FlightArray = flightDetail.split("\\r?\\n");
				System.out.println("Departure flight name: "+FlightArray[0]);
				System.out.println("Departure flight price: "+FlightArray[FlightArray.length - 1]);
				
			}
			
			for (WebElement e : ReturnFilghts) {
				String flightDetail = e.getText();
				//System.out.println(flightDetail);
				String[] FlightArray = flightDetail.split("\\r?\\n");
				System.out.println("Return flight name: "+FlightArray[0]);
				System.out.println("Return flight price: "+FlightArray[FlightArray.length - 1]);
				
			}
		  }
	  
	  	
}
