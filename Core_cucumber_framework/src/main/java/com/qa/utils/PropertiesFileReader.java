package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.cucumber.listener.Reporter;

public class PropertiesFileReader {
	
	/**
	 * 
	 * @param config_path
	 * @return
	 * @throws IOException
	 * 
	 */
	public Properties properties;
	public Properties getProperty(String config_path) throws IOException
	{
		FileInputStream inputStream=null;
        properties = new Properties();
        try {        	 
            properties.load(new FileInputStream(config_path));
          
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            Reporter.addStepLog(""+e.getMessage()+"");
       } 
         return properties;	
	}
	
	public String getkey(String key)
	{
		String key_value=(String) properties.get(key);
		return key_value;
		
	}

}
