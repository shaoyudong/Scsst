package com.shao.scsst;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWebdriver {
	private WebDriver wd;
	private String url;
	
	@Before
	public void setUp(){
//		wd = new FirefoxDriver();
		String chDriver = "/Users/shaoyudong/Downloads/chromedriver";
		System.setProperty("webdriver.chrome.driver", chDriver);
		System.setProperty("webdriver.chrome.bin", "/Users/shaoyudong/Downloads/chromedriver");
		url = "http://www.baidu.com/";
		wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void testMD(){
		wd.get(url);
	}
	
}
