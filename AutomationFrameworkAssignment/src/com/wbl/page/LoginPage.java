package com.wbl.page;

import org.openqa.selenium.WebDriver;

import com.wbl.helper.WblBy;


public class LoginPage extends PortalPage {
	
	public LoginPage (WebDriver driver){
		super(driver);
		
	}
	
	public String login(String uname, String pwd){
		driver.findElement(WblBy.getBy("id-login-uname")).sendKeys(uname);
		driver.findElement(WblBy.getBy("id-login-password")).sendKeys(pwd);
		driver.findElement(WblBy.getBy("id-login-submit")).click();
		return driver.getTitle();
		
	}
	
	public int breadCrumbs(){
		return driver.findElements(WblBy.getBy("css-login-bc")).size();
		
	}
 public boolean forgotPassword(){
	 driver.findElement(WblBy.getBy("id-login-forgotpassword")).click();
	 return driver.findElement(WblBy.getBy("id-login-email")).isDisplayed();
 }
}
