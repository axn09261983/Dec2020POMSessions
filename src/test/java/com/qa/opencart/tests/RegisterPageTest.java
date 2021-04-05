package com.qa.opencart.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.oprncart.utills.ConstantsUtill;
import com.qa.oprncart.utills.Error;
import com.qa.oprncart.utills.ExcelUtill;


public class RegisterPageTest extends BaseTest {
	
	
	@BeforeClass
	public void setupRegister() {
		
		registerpage = loginPage.navigateToRegisterPage();
	}
	
	@DataProvider
	public Object[][]getRegisterData() {		
		Object data [][]= ExcelUtill.getTestData(ConstantsUtill.Register_Sheet_Name);
		return data;
	}
	
	public String getRandomNumber() {
		Random randomGenerator = new Random();
		String email = "testautomation" +randomGenerator.nextInt(1000)+ "@gmail.com";
		return email;
		
		
		
	}
	
	@Test(dataProvider = "getRegisterData")
	public void useRegisterTest(String firstname, String lastname, String telephone, String password, String subscribe) {
		
	Assert.assertTrue(registerpage.accountRegistration(firstname, lastname, getRandomNumber(), telephone,
				password, subscribe),Error.REGISTRATION_FAIL_MESSAGE);
		
		
		
		
	}
	
	
	
}
	
	
	


