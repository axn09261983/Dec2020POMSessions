package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.oprncart.utills.ElementUtill;

public class ProductInfoPage {

	ElementUtill elementUtill;
	
	private By productHeader = By.cssSelector("#content h1");
	private By productImgcount = By.cssSelector(".thumbnail img");
	private By productmetaData = By.cssSelector("div.col-sm-4 ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div.col-sm-4 ul.list-unstyled:nth-of-type(2) li");
	private By Quantity = By.id("input-quantity");
	private By addToCartButton = By.id("button-cart");
	private By SuccessMessg = By.cssSelector("div.alert.alert-success.alert-dismissible");
	
	
	

	public ProductInfoPage(WebDriver driver) {
		elementUtill = new ElementUtill(driver);
		
	}
	
	
	public String getProductHeaderText() {
		 return elementUtill.doGetElementText(productHeader);
				
	}
	
	
	public int getProductImgCount() {
	return elementUtill.getElements(productImgcount).size();
		
	}
	
	public Map<String, String> getProudctInformation() {
		Map<String, String> productInfomap = new HashMap<String, String>();
		productInfomap.put("name", getProductHeaderText());
		
		List<WebElement>productmetaDataList =elementUtill.getElements(productmetaData);
		System.out.println("total product metadata: " + productmetaDataList );
		
//		Brand: Apple
//		Product Code: Product 18
//		Reward Points: 800
//		Availability: Out Of Stock
		
		
		for(WebElement e: productmetaDataList) {
			String meta[]=e.getText().split(":");
			String metakey = meta[0].trim();
			String metaValue = meta[1].trim();
			productInfomap.put(metakey, metaValue);
			
		}
			
			//price
			List<WebElement>productmetaPriceList =elementUtill.getElements(productPriceData);
			productInfomap.put("price",productmetaPriceList.get(0).getText().trim() );
			productInfomap.put("exTaxPrice", productmetaPriceList.get(1).getText().split(":")[1].trim());
			
			
			return productInfomap;
			
		}
	
	 public void selectQuantity(String qty) {
		 elementUtill.doSendKeys(Quantity, qty);
		 
		 
	 }
	
	 public void addTocart() {
		 elementUtill.doClick(addToCartButton);
		 
		 
	 }
	 
	 public String getSuccessMessage() {
		 
		 return elementUtill.doGetElementText(SuccessMessg);
		 
		 
	 }
	 
		
		
	}
	
	
	
	
	

