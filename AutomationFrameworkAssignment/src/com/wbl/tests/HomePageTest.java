package com.wbl.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wbl.common.CommonTest;
import com.wbl.page.HomePage;
import static org.testng.Assert.*;

public class HomePageTest extends CommonTest{
	HomePage hm;
	
	@BeforeClass
	public void beforeClass(){
		hm=new HomePage(driver);
		
	}
	
	@Test
	public void testSlides(){
		assertEquals(6, hm.countSlides());
	}
	@Test
	public void testVideo(){
		assertTrue(hm.videoElement());
	}
   
}
