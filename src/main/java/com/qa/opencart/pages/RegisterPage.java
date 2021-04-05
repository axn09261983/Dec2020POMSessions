package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.oprncart.utills.ConstantsUtill;
import com.qa.oprncart.utills.ElementUtill;

public class RegisterPage {
	
	private WebDriver driver;	
	ElementUtill elementUtill;
	
	
	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email =  By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");
	private By subscribeYes = By.xpath("(//label[@class='radio-inline' ])[position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline' ])[position()=2]/input");
	private By agreecheckbox = By.name("agree");  
	private By continueButton = By.xpath("//input[@type='submit']");
	private By sucessmessage = By.xpath("//div[@id='content']/h1");
	private By logoutButton = By.xpath("//div[@class='list-group']/a[text()='Logout']");
	private By registerLink = By.xpath("//div[@class='list-group']/a[text()='Register']");
	
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementUtill = new ElementUtill(driver);
	}
		
		
	public boolean accountRegistration(String firstName,String lastName, String email, String telephone, 
			String password, String subscribe) {
		
		elementUtill.doSendKeys(this.firstname, firstName);
		elementUtill.doSendKeys(this.lastname, lastName);
		elementUtill.doSendKeys(this.email, email);
		elementUtill.doSendKeys(this.telephone, telephone);
		elementUtill.doSendKeys(this.password, password);
		elementUtill.doSendKeys(this.confirmpassword, password);
		
		if(subscribe.equals("yes")) {
			elementUtill.doClick(this.subscribeYes);
		}
			else {
				elementUtill.doClick(this.subscribeNo);
				
			}
		
		
		elementUtill.doClick(this.agreecheckbox);
		elementUtill.doClick(this.continueButton);
		elementUtill.waitForPresenceOfElement(sucessmessage, 5);
		
		
		
		String msg =elementUtill.doGetElementText(this.sucessmessage);
		System.out.println("Account Creation : " + msg);
        if(msg.contains(ConstantsUtill.ACCOUNT_CREATION_SUCCESS_MESSAGE)) {
        	
        	elementUtill.doClick(logoutButton);
        	elementUtill.doClick(registerLink);
        	
        	return true;
        }
        	else {
        			return false;
        	}
        	
        	
        }	
	
}
		
		
			
			
	
	
		
		
		
		
	
		
		
		
	
	
	
	
	
	


