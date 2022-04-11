package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utilities.Constants;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class LoginPageTest extends BaseTest 
{

	@Test
	@Description("logion page title test")
	@Severity(SeverityLevel.NORMAL)
	public void TC_001_loginPageTitle() 
	{
		String actualTitle=loginPage.getLoginPageTitle();
		System.out.println("Login Page Title :"+actualTitle);
		Assert.assertEquals(actualTitle,Constants.LOGINPAGE_TITLE);
	}
	
	@Test
	public void TC_002_loginPageUrl() 
	{
		String url=loginPage.getLoginPageUrl();
		System.out.println("Login Page Url :"+url);
		Assert.assertTrue(url.contains(Constants.LOGINPAGE_URL));
	}
	
	@Test
	public void TC_003_forgotPasswordLink() 
	{
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	
	@Test
	@Description("login test with correct username and password")
	@Severity(SeverityLevel.BLOCKER)
	public void TC_004_login() 
	{
		accountsPage=loginPage.doLogin(prop.getProperty("email"),prop.getProperty("password"));
		Assert.assertTrue(accountsPage.isAccountsPageHeaderExist());
	}
	
	@Test
	public void ATC_005_registerLink() 
	{
		Assert.assertTrue(loginPage.isRegisterLinkExist());
	}

}
