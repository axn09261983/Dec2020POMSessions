package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	
	
	public OptionManager(Properties prop) {
		this.prop = prop;
		
			}
	
	public ChromeOptions getchromeOptions() {
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless")))co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito")))co.addArguments("--incognito");
		
		return co;
				
		
	}
	
	public FirefoxOptions getfirefoxOptions() {
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) fo.addArguments("headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) fo.addArguments("incognito");
		
	return fo;
				
		
	}
	
	
	
	
	

}
