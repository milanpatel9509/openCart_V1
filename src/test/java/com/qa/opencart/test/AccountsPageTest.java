package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utilities.Constants;

public class AccountsPageTest extends BaseTest
{
	@BeforeClass
	public void accountsPageSetup() 
	{
		accountsPage=loginPage.doLogin(prop.getProperty("email"),prop.getProperty("password"));
	}

	@Test
	public void TC_201_getTitle() 
	{
		String actualTitle=accountsPage.getAccountsPageTitle();
		Assert.assertEquals(actualTitle,Constants.ACCOUNTSPAGE_TITLE);
	}
	
	@Test
	public void TC_202_headerExit() 
	{
		Assert.assertTrue(accountsPage.isAccountsPageHeaderExist());
	}
	
	@Test
	public void TC_203_searchExit() 
	{
		Assert.assertTrue(accountsPage.isAccountsPageSearchExit());
	}
	
	@Test
	public void TC_204_accountSection() 
	{
		List<String> actualSectionList=accountsPage.getAccountSectionList();
		Assert.assertEquals(actualSectionList,Constants.EXPECTED_SECTION_LIST);
	}
	
	@Test
	public void TC_205_searchHeaderTest() 
	{
		searchResultsPage=accountsPage.doSearch("Macbook");
		String actualSearchHeader=searchResultsPage.getResultsPageHeaderValue();
		Assert.assertTrue(actualSearchHeader.contains("Macbook"));
	}
	
	@Test
	public void TC_206_searchProductTest() 
	{
		searchResultsPage=accountsPage.doSearch("Macbook");
		int actualProductCount=searchResultsPage.getProductSearchCount();
		Assert.assertEquals(actualProductCount,Constants.MACBOOK_PRODUCT_COUNT);
	}
	
	@Test
	public void TC_207_searchProductListTest() 
	{
		searchResultsPage=accountsPage.doSearch("Macbook");
		List<String> actualProductList=searchResultsPage.getProductResultsList();
		System.out.println(actualProductList);
	}
	
	
}
