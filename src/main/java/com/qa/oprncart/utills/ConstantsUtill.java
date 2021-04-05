package com.qa.oprncart.utills;

import java.util.ArrayList;
import java.util.List;

public class ConstantsUtill {
	
	public static final String Login_Page_Title = "Account Login";
	public static final String ACC_page_Title = "My Account";
	public static final int Acc_page_Sections_count = 4;
	public static final int Product_Img_count_MacBook = 5;
	public static final String ACCOUNT_CREATION_SUCCESS_MESSAGE = "Your Account Has Been Created!";
	
	public static final String Register_Sheet_Name = "register";
	
	
	
	public static List<String> expectedAccSectionList() {
		List<String>expecList = new ArrayList<String>();
		expecList.add("My Account");
		expecList.add("My Orders");
		expecList.add("My Affiliate Account");
		expecList.add("Newsletter");
		//expecList.add("testing");
		System.out.println(expecList);
		return expecList;
		
		
	}

}
