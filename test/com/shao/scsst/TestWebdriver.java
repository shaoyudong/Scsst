package com.shao.scsst;

import static org.junit.Assert.*;

import java.awt.List;
import java.security.spec.ECGenParameterSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.sound.sampled.Line;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestWebdriver {
	private WebDriver wd;
	private String url;
	private String mail;
	private CSVFileUtil csvFile;
	
	@Before
	public void setUp(){
		wd = new FirefoxDriver();
//		String chDriver = "/Users/shaoyudong/Downloads/chromedriver";
//		System.setProperty("webdriver.chrome.driver", chDriver);
//		System.setProperty("webdriver.chrome.bin", "/Users/shaoyudong/Downloads/chromedriver");
		url = "http://www.ncfxy.com";
//		wd = new ChromeDriver();
//		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testWD() throws Exception{
		ArrayList<String> userList = new ArrayList<String>();
		HashMap<String,String> userMap = new HashMap<String,String>();
		String line;
		String[] sLine;
		String username;
		String password;
		String mail;
		WebElement usernameElement;
		WebElement passwordElement;
		WebElement loginElement;
		WebElement mailElement;
		
		csvFile = new CSVFileUtil("info.csv");
		line = csvFile.readLine();
		while (line != null){
			sLine =line.split(",");
			if (sLine.length > 0) {
				userList.add(sLine[0]);
				userMap.put(sLine[0], sLine[1]);
			}
			line = csvFile.readLine();
		}
		
		csvFile.close();
		
		wd.get(url);
		
		for (int i = 0; i < userList.size(); i++) {
			username = userList.get(i);
			password = username.substring(username.length()-6);
			
			System.out.println(username);
			System.out.println(password);
			
			usernameElement = wd.findElement(By.id("name"));
			usernameElement.clear();
			usernameElement.sendKeys(username);
			
			passwordElement = wd.findElement(By.id("pwd"));
			passwordElement.clear();
			passwordElement.sendKeys(password);
			
			loginElement = wd.findElement(By.id("submit"));
			loginElement.click();
			
			mailElement = wd.findElement(By.xpath("id('table-main')/tr[1]/td[2]"));
			mail = mailElement.getText();
			
			assertEquals(mail, userMap.get(username));
			wd.navigate().back();
		}
		
	}
	
}
