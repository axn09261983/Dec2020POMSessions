package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;
import com.qa.oprncart.utills.ConstantsUtill;
import com.qa.oprncart.utills.Error;

public class AccountPageTest extends BaseTest{
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeClass
	public void AccSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority = 1)
	public void accountsPageTitleTest() {
		String title =accPage.getaccountsPageTitle();
		System.out.println("home page title is "+ title);
		Assert.assertEquals(title, ConstantsUtill.ACC_page_Title, Error.ACC_PAGE_MISMATCHED_ERROR);
		
	}
	@Test(priority = 2)
	public void accPageLogoTest() {	
		Assert.assertTrue(accPage.isLogoExist(), Error.LOGO_NOT_AVAILABLE_ERROR);
	}
	
	@Test(priority = 3)
	public void accPageSectionsCountTest() {
		
		Assert.assertEquals(accPage.getAccountPageHeaderCount(),ConstantsUtill.Acc_page_Sections_count,
				Error.ACC_PAGE_SECTION_ERROR);
	}
	
	@Test(priority = 4)
	public void accPageSectionListTest() {
		
		List<String>actualAccsecList = accPage.getAccountHeaderCount();
		System.out.println(actualAccsecList);
		
		Assert.assertEquals(actualAccsecList, ConstantsUtill.expectedAccSectionList());
		
	}
	
	@Test(priority = 5)
	public void searchTest() {
	searchResultPage =accPage.doSearch("MacBook");
	Assert.assertTrue(searchResultPage.getResultsProductCount()>0,Error.SEARCH_NOT_SUCESSFUL);
			
		
	}
	@Test(priority = 6)
	public void selectProductTest() {
		searchResultPage =accPage.doSearch("MacBook");
		productInfoPage	=searchResultPage.selectProductFromResults("MacBook Pro");
		String actualHeader=productInfoPage.getProductHeaderText();
		softAssert.assertEquals(actualHeader, "MacBook Pro",Error.PRODUCT_HEADER_NOT_FOUND);
		softAssert.assertEquals(productInfoPage.getProductImgCount(),ConstantsUtill.Product_Img_count_MacBook);
		softAssert.assertAll();
				
		
	}
	
	
	
	
	

}
