package com.makemytrip.testCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.makemytrip.utilities.PageScroll;

public class FlightResultPage extends HomePage{

	@FindBy(xpath="//div[@class='splitVw-sctn pull-left']/child::div[2]/child::div")
	List<WebElement> departureFilghts;
	
	@FindBy(xpath="//div[@class='splitVw-sctn pull-right']/child::div[2]/child::div")
	List<WebElement> ReturnFilghts;
	
	@FindBy(xpath="//div[@class='pull-right marL5 text-right']/p/span")
	List<WebElement> FlightPrices;
	
	@FindBy(xpath="//span[@class='splitVw-total-fare']")
	WebElement totalFlightPrice;
	
	By SelectedFlightPrice=By.xpath("//p[@class='actual-price']");
	
	
	  //Constructor to initialize webelements
	
	/*
	 * public FlightResultPage() { PageFactory.initElements(BaseClass.driver, this);
	 * }
	 */
	 
	
	//counts total departure flights, flights on left side. Returns no flight exception if flight not found
	public int departureFilightCount() throws Exception
	{
		PageScroll.toBottomOfPage();
		if(departureFilghts.size()<1)
		{
			throw new Exception("No Flight availabe");
		}
		return departureFilghts.size();
	}
	//counts return departure flights, flights on right side. Returns no flight exception if flight not found
	public int returnFilightCount() throws Exception
	{
		PageScroll.toUP();
		if(ReturnFilghts.size()<1)
		{
			throw new Exception("No Flight availabe");
			
		}
		return ReturnFilghts.size();
	}
	//counts flight when no filter is applied
	public int[] NoStopsFlightCount() throws Exception
	{
		
		int[] count=new int[2];
		count[0]=departureFilightCount();
		count[1]=returnFilightCount();
		return count;
	}
	
	
	
}
