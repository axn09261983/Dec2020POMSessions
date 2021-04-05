package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.oprncart.utills.ElementUtill;

public class SearchResultPage {
	private WebDriver driver;
	ElementUtill elementUtill;
	
	
 By searchItemResult = By.cssSelector("div.product-layout div.product-thumb");
 By resultsItems  = By.cssSelector("div.product-thumb h4 a");
 
 
 public SearchResultPage(WebDriver driver) {
	 this.driver = driver;	 
	 elementUtill = new ElementUtill(driver);
	  
 }
 
 
 
 public int getResultsProductCount() {	 
	 return elementUtill.getElements(searchItemResult).size();
	 
 }
 
 public ProductInfoPage selectProductFromResults(String productName) {
	 
	List<WebElement> resultItemsList = elementUtill.getElements(resultsItems);
	System.out.println("total number of items displayed for :" + productName + " : " + resultItemsList.size()); 
	
	for(WebElement e: resultItemsList) {
		if(e.getText().equals(productName)) {
			e.click();
			break;
		}
		
	}
	
	return new ProductInfoPage(driver);
 }
 
	

}
