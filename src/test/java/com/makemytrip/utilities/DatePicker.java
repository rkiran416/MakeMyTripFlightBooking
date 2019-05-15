package com.makemytrip.utilities;

import java.util.Calendar;

public class DatePicker {

	private String departureDate=null;
	private String returnDate=null;
	
	public String getDepartureDate() {
		return departureDate;
	}

	public String getReturnDate() {
		return returnDate;
	}

	//Picks up current system for Departure Date and +7 days for Return date Returns in format "Mon May 13 2019"
	public static DatePicker getDates()
	{
		DatePicker date=new DatePicker();
		Calendar cal=Calendar.getInstance();
		String[] rawDate=cal.getTime().toString().split(" ");
		date.departureDate=rawDate[0]+" "+rawDate[1]+" "+rawDate[2]+" "+rawDate[5];
		cal.add(Calendar.DATE, Integer.parseInt(ReadPropertyFile.get("NoOfdays")));
		rawDate=cal.getTime().toString().split(" ");
		date.returnDate=rawDate[0]+" "+rawDate[1]+" "+rawDate[2]+" "+rawDate[5];
		return date;
	}
}
