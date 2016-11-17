package com.wbl.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebUIDriver {
	private static String LOCATION=System.getProperty("user.dir")+"\\resources\\drivers";
    public static WebDriver getDriver(ConfigUtils config){
    	WebDriver driver=null;
    	switch(config.BROWSER){
    	case "chrome":
    		System.setProperty("webdriver.chrome.driver", LOCATION+"chromedriver");
    		driver = new ChromeDriver();
    		break;
    	case "firefox":
    		System.setProperty("webdriver.gecko.driver", LOCATION+"geckodriver");
    		driver = new FirefoxDriver();
    		break;
    	
    	case "ie":
    		driver = new InternetExplorerDriver();
    		break;
    	case "htmlunit":
    		driver = new HtmlUnitDriver();
    		break;
    		
    		default:
    			driver=new ChromeDriver();
    	}
    	
		return driver;
    	
    }
}
