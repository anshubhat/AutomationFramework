package com.wbl.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.wbl.helper.WblBy;

public class HomePage extends PortalPage {
	public HomePage(WebDriver driver){
		super(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public int countSlides(){
		return driver.findElements(WblBy.getBy("css-home-slides-is")).size();
		
	}
	
	public void loginClick(){
		driver.findElement(WblBy.getBy("link-home-Login")).click();
	}

	public boolean sectionHeaders(){
		return driver.findElement(WblBy.getBy("css-home-section-headers")).isDisplayed();

	}
	
	public boolean videoElement(){
		return driver.findElement(WblBy.getBy("css-home-video-elm")).isEnabled();
	}
}
