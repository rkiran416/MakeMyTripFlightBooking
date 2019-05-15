package com.makemytrip.testCases;

import org.testng.annotations.Test;

public class FlightCounts extends FlightResultPage{

	//public static FlightResultPage pageObj=null;
	int[] counts;
	//Prints flight number when no filter is selected
  @Test(priority=1)
  public void NoFilterFlightCounts() throws Exception 
  {
	  counts=NoStopsFlightCount();
	  System.out.println("*****Flight Count *****");
	  System.out.println("Depature Flght count:"+counts[0]+"\nReturn Flight Count"+counts[1]);
	  	  
  }
 
}
