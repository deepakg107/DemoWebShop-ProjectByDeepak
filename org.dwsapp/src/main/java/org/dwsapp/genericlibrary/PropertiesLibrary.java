package org.dwsapp.genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesLibrary implements ProjectConstant {

	public FileInputStream fis;
	public FileOutputStream fos;
	public Properties propertyobj;
	
	public String readData(String key) 
	{
		//Step 1...
		try {
			fis = new FileInputStream(propertiesPath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Step 2 
		propertyobj=new Properties();
		
		//Step 3
		try {
			propertyobj.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// Step  4
		return propertyobj.getProperty(key);
		
		
	}

}
