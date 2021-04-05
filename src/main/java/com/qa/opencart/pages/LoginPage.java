package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.oprncart.utills.ConstantsUtill;
import com.qa.oprncart.utills.ElementUtill;

import io.qameta.allure.Step;

public class LoginPage {
	
    private WebDriver driver;
	private ElementUtill elementUtill;
	
	
	
	
	//Page Objects - By Locators- OR
	
	private By userName = By.id("input-email");
	private By Password = By.id("input-password");
	private By loignButton = By.xpath("//input[@value = 'Login']");
	private By forgotPwd = By.xpath("//div[@class='form-group']/a[text()='Forgotten Password']");
	private By registerlink = By.xpath("//div[@class='list-group']/a[text()= 'Register']");
	
	
	//constructor:	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtill = new ElementUtill(driver);
		
	}
	
	//page actions:	
	@Step("gettig login Page title....")
	public String getLoginPageTitle() {
		return elementUtill.waitForTitleIs(5, ConstantsUtill.Login_Page_Title);
		
	}
	@Step("Checking forgot pwd link....")
	public boolean isForgotPwdLinkExist() {
		return elementUtill.doIsDisplayed(forgotPwd);
	}
	
	@Step("login with UserName :{0} and password:{1}")
	public AccountPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + ":" + pwd);
		elementUtill.doSendKeys(userName, un);
		elementUtill.doSendKeys(Password, pwd);
		elementUtill.doClick(loignButton);
		return new AccountPage(driver);
				
		
	}
	
	@Step("Navigate to registerPage..")
	public RegisterPage navigateToRegisterPage() {
		elementUtill.doClick(registerlink);
		return new RegisterPage(driver);
		
		
		
	}
	
	
	

}
