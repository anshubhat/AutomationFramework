package com.wbl.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.testng.log4testng.Logger;

public class ConfigUtils {
	private Logger logger=Logger.getLogger(ConfigUtils.class);
	
	
	Properties prop ;
	public final String BROWSER;
	public final String URL;
	
	public ConfigUtils(String fileName){
		logger.info("Reading the config File");
		prop = new Properties();
	
		 try {
			prop.load(new FileInputStream(System.getProperty("user.dir")+"\\resources"+fileName));
		} 
		 catch (FileNotFoundException e) {
			 logger.error("File Not found-Please give correct file detail");
		 }
		 catch (IOException e) {
			// TODO Auto-generated catch block
			 logger.error("Issue reading the given config properties file");
		 }
		 BROWSER = prop.getProperty("browser");
		 URL = prop.getProperty("url");
	}
		
	}



