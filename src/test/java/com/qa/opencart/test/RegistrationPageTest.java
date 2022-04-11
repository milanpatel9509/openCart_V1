package com.qa.opencart.test;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utilities.Constants;
import com.qa.opencart.utilities.ExcelUtil;


public class RegistrationPageTest extends BaseTest
{
	@BeforeClass
	public void regPageSetup() 
	{
		registersPage=loginPage.navigateToRegisterPage();
	}
	
	public String getRandomEmail() 
	{
		Random random=new Random();
		String email="milan"+random.nextInt(1000)+"@gmail.com";
		return email;
	}
	
	/*
	@DataProvider
	public Object[][] getRegisterData() 
	{
		return new Object[][] {
								{"Nitesh","Agarwal","9812763265","nitesh@123","yes"},
								{"Anu","kamath","7623453243","anu@123","yes"},
								{"Gagan","Tyagi","9898992341","gagan@123","no"},
							  };
	}
	*/
	
	@DataProvider
	public Object[][] getRegisterData() 
	{
		Object regData[][]=ExcelUtil.getTestData(Constants.REGISTER_SHEETNAME);
		return regData;
	}
	
	@Test(dataProvider ="getRegisterData")
	public void userRegisteration(String fn,String ln,String pn,String pwd,String sub) 
	{
		boolean flag=registersPage.accountRegisteration(fn,ln,getRandomEmail(),pn,pwd,sub);
		Assert.assertTrue(flag);
	}

}
