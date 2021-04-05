package com.qa.opencart.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.oprncart.utills.ConstantsUtill;
import com.qa.oprncart.utills.ElementUtill;

public class AccountPage {
	private WebDriver driver;	
	ElementUtill elementUtill;
	
	private By logo = By.xpath("//div[@id='logo']");
	private By AccHeaders = By.xpath("//div[@id='content']/h2");
	private By SearchField = By.name("search");
	private By searchButton = By.cssSelector("div#search button");
	
	
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		elementUtill = new ElementUtill(driver);
				
	}
	
	
	public String getaccountsPageTitle() {
		return elementUtill.waitForTitleIs(5, ConstantsUtill.ACC_page_Title);
		
	}
	
	public boolean  isLogoExist() {
		return elementUtill.doIsDisplayed(logo);
	}
	
	public int getAccountPageHeaderCount() {
		return elementUtill.getElements(AccHeaders).size();
		
	}
	
	public List<String> getAccountHeaderCount() {
		
		List<WebElement>acctList =elementUtill.getElements(AccHeaders);
		List<String> accSectionList = new ArrayList<String>();
		
		for(WebElement e: acctList) {
			accSectionList.add(e.getText());						
		}
		
		return accSectionList;
				
	}
	
	public SearchResultPage doSearch(String productName ) {
		System.out.println("Searching for the product:" + productName);
		elementUtill.doSendKeys(SearchField, productName);
		elementUtill.doClick(searchButton);
		return new SearchResultPage(driver);
				
	}


	
	
			
	}
