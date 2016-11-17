package com.wbl.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.testng.log4testng.Logger;

public class WblBy {
	
	static Properties LocatorsProp=null;
	private static Logger logger=Logger.getLogger(WblBy.class);
	public static void loadProperties(String fileName){
		LocatorsProp=new Properties();
		 try {
			 LocatorsProp.load(new FileInputStream(System.getProperty("user.dir")+"\\resources"+fileName));
			} 
			 catch (FileNotFoundException e) {
				 logger.error("File Not found-Please give correct file detail");
			 }
			 catch (IOException e) {
				// TODO Auto-generated catch block
				 logger.error("Issue reading the given config properties file");
			 }
	}
	
	public static By getBy(String key){
		By by=null;
		String value = LocatorsProp.getProperty(key);
		if (key.startsWith("id")){
			by= By.id(value);
		}else if (key.startsWith("css")){
			by= By.cssSelector(value);
		}else if (key.startsWith("link")){
			by= By.linkText(value);
		}else if (key.startsWith("name")){
			by= By.name(value);
		}else if (key.startsWith("plink")){
			by= By.partialLinkText(value);
		}else if (key.startsWith("xpath")){
			by= By.xpath(value);
		}else if (key.startsWith("tag")){
			by= By.tagName(value);
		}else if (key.startsWith("classname")){
			by= By.className(value);
		
		}
		return by;
	}

}
