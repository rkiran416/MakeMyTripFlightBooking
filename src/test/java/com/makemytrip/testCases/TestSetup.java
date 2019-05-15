package com.makemytrip.testCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestSetup {

	 //Initializes browser and reports
	  @BeforeSuite
	  public void beforeSuite() 
	  {
		  
	  BaseClass.initialize();
		  

	  }
	//closed browser and report object
	
	
	  @AfterSuite public void afterSuite() { 
		  BaseClass.quit();
	  
	  }
	 
	 
}
