package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author AN0227
 *
 */

public class DriverFactory {	
	
	Properties prop;
	public static String highlight;
	OptionManager optionManager;
	
	public static ThreadLocal<WebDriver>tldriver = new ThreadLocal<>();
	
	/**
	 * This method is used to init the driver on the basis of given browser value....
	 * @param browserName
	 * @return thie returns webdriver 
	 */
	
	public WebDriver init_driver(Properties prop) {
		optionManager = new OptionManager(prop);
		
		String browserName = prop.getProperty("browser").trim();
		highlight = prop.getProperty("highlight").trim();
		
		System.out.println("brower name is: " + browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			//driver = new ChromeDriver(optionManager.getchromeOptions());
			tldriver.set(new ChromeDriver(optionManager.getchromeOptions()));
			
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver = new FirefoxDriver(optionManager.getfirefoxOptions());
			tldriver.set(new FirefoxDriver(optionManager.getfirefoxOptions()));
		
		}
		
		else if (browserName.equalsIgnoreCase("safari")) {
			//driver = new SafariDriver();
			tldriver.set(new SafariDriver());
		
		}
		
		else {
			
			System.out.println("browser is not found...Please pass the correct broswerName" + browserName);
		}
		
		getDriver().manage().window().fullscreen();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url").trim());
		
		return getDriver();
			
		
	}
	
	/**
	 * 
	 * @return
	 */
	
	public static synchronized WebDriver getDriver() {
		return tldriver.get();
	
		
	}
	
	
	/**
	 * This method is init the properties from .properties file 
	 * @return return Properties (Prop) 
	 */
	
	public Properties init_prop() {
		prop = new Properties();
		FileInputStream ip = null;
		
		String env =System.getProperty("env");
		System.out.println("the value of env" + env);
		if(env == null) {
			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}else {
			
			try {
				switch (env) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;
				case "dev":
					ip = new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;	

				default:
					System.out.println("Please pass the correct enviorment value");
					break;
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
				
			}
		
			try {
	        prop.load(ip);
	}catch(IOException e) {
		e.printStackTrace();
	}
	
	return prop;
		
		
	}
	
	
	/**
	 * take screen shot for failure test cases
	 */

	public String getScreenshot() {
		
          File srcFile =  ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
          //File srcFile = new File(src);
          
          String path = System.getProperty("user.dir")+"/Screenshots/"+ System.currentTimeMillis()+".png";
          File destination = new File(path);
          
          try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
          
          return path;
		
	}
	
		
	}
	















