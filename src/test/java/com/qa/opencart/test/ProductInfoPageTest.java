package com.qa.opencart.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.SearchResultsPage;
import com.qa.opencart.utilities.Constants;
import com.qa.opencart.utilities.ExcelUtil;

public class ProductInfoPageTest extends BaseTest 
{
	@BeforeClass
	public void productInfoSetup() 
	{
		accountsPage=loginPage.doLogin(prop.getProperty("email"),prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] getProductData()
	{
		return new Object[][] 
				{
					{"MacBook","MacBook Pro"},
					{"MacBook","MacBook Air"},
					{"Apple","Apple Cinema 30\""}
				};
	}
	
//	@DataProvider
//	public Object[][] getProductData() 
//	{
//		Object productData[][]=ExcelUtil.getTestData(Constants.PRODUT_SHEETNAME);
//		return productData;
//	}
//	
	
	@Test(dataProvider = "getProductData")
	public void productInfoHeaderTest(String productName,String mainProductName) 
	{
		searchResultsPage=accountsPage.doSearch(productName);
		productInfoPage=searchResultsPage.selectProduct(mainProductName);
		String actualHeader=productInfoPage.getProductHeaderText();
		Assert.assertEquals(actualHeader,mainProductName);
	}
	
	@Test
	public void productImageTest() 
	{
		searchResultsPage=accountsPage.doSearch("MacBook");
		productInfoPage=searchResultsPage.selectProduct("MacBook Pro");
		int actualImgCount=productInfoPage.getProductImagesCount();
		Assert.assertTrue(actualImgCount==Constants.MACBOOK_IMG_COUNT);
	}
	
	@Test
	public void productInfoTest() 
	{
		searchResultsPage=accountsPage.doSearch("MacBook");
		productInfoPage=searchResultsPage.selectProduct("MacBook Pro");
		Map<String,String> actualProductInfoMap=productInfoPage.getProductInfo();
		actualProductInfoMap.forEach((k,v)->System.out.println(k+":"+v));
		softAssert.assertEquals(actualProductInfoMap.get("productName"),"MacBook Pro");
		softAssert.assertEquals(actualProductInfoMap.get("Brand"),"Apple");
		softAssert.assertEquals(actualProductInfoMap.get("Reward Points"),"800");
		softAssert.assertEquals(actualProductInfoMap.get("price"),"$2,000.00");
		softAssert.assertAll();
	}
	

}
