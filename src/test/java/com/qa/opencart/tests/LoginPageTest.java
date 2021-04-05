package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.oprncart.utills.ConstantsUtill;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


@Story("US-100: design the login pgae for demo opencart application app with login , title and forgot pwd link")
@Epic("Epic-100:design login page features")
		
public class LoginPageTest extends BaseTest{
	@Description("Login Page title test....")
	@Severity(SeverityLevel.NORMAL)	
	@Test(priority= 1)
	public void loginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
	    System.out.println("login page Title : " + title);
	    Assert.assertEquals(title, ConstantsUtill.Login_Page_Title);
		
		
	}
	
	@Description("forgot pwd link test..")
	@Severity(SeverityLevel.CRITICAL)
	@Test(priority= 2)
	public void forgotPwdLinkTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
		
	}
	
	@Description("Login test with correct credentails ..")
	@Severity(SeverityLevel.BLOCKER)
	
	public void loginTest() {
		
		accPage=loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		Assert.assertEquals(accPage.getaccountsPageTitle(), ConstantsUtill.ACC_page_Title);
		
	}

}
