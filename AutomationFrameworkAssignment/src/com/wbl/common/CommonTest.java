package com.wbl.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.wbl.helper.ConfigUtils;
import com.wbl.helper.WblBy;
import com.wbl.helper.WebUIDriver;

public abstract class CommonTest {
    public WebDriver driver;
	@BeforeTest
	public void beforeSuite(){
		ConfigUtils config= new ConfigUtils("config.properties");
		WblBy.loadProperties("locators.properties");
		driver = WebUIDriver.getDriver(config);
		driver.get(config.URL);
	}
	
	@AfterSuite
	public void afterSuite(){
		driver.close();
	}
	
}
