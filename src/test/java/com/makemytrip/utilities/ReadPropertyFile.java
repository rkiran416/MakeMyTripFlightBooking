package com.makemytrip.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	// This class is executed to read data from properties file
		public static String get(String PropertyName)
	{
		String returnProperty="";
		Properties property = new Properties();
		File src=new File("./Configuration/config.properties");	
		
		try {
			FileInputStream file =
					new FileInputStream(src);
			property.load(file);
			returnProperty=property.getProperty(PropertyName);
			if(returnProperty==null)
			{
				throw new Exception("Property with name : "+PropertyName+" not found in ./Configuration/config.properties");
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnProperty;
	}

	}
