package com.wbl.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


import com.wbl.common.CommonTest;
import com.wbl.helper.ExcelUtils;
import com.wbl.page.LoginPage;
import com.wbl.pageflow.LoginPageFlow;

public class LoginPageTest extends CommonTest{
	
		LoginPage lp;
		@BeforeClass
		public void beforeClass(){
			lp = new LoginPage(driver);
			LoginPageFlow.goToLogin(driver);
		}
		
		@DataProvider(name="login-data")
		public Object [][] loginData(){
			return ExcelUtils.getExcelData("login", "logindata.xlsx");
		}
		@Test(dataProvider="login-data")
		public void testLogin(String uname, String pwd, String result){
			assertEquals(result, lp.login(uname, pwd));
		}
		
		@Test
		public void testBreadCrumbs(){
			assertEquals(3 , lp.breadCrumbs());
		}
		
		@Test
		public void testForgotPassword(){
			assertTrue( lp.forgotPassword());
		}
		
		
}