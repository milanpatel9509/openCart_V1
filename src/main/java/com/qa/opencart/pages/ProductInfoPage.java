package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductInfoPage 
{
	private WebDriver driver;
	private Map<String,String> productInfoMap;
	public ProductInfoPage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By productHeader=By.cssSelector("div#content h1");
	private By productImage=By.cssSelector("div#content img");
	private By productMetaData=By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData=By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By qty=By.id("input-quantity");
	private By addToCartBtn=By.id("button-cart");
	private By successMsg=By.cssSelector("div.alert.alert-success.alert-dismissible");
	
	
	public String getProductHeaderText() 
	{
		return driver.findElement(productHeader).getText();
	}
	
	public int getProductImagesCount() 
	{
		List<WebElement> list=driver.findElements(productImage);
		return list.size();
	}
	
	public Map<String,String> getProductInfo() 
	{
		productInfoMap=new LinkedHashMap<String,String>();
		productInfoMap.put("productName", getProductHeaderText());
		productInfoMap.put("productImageCount",String.valueOf(getProductImagesCount()));
		getProductMetaData();
		getProductPriceData();
		return productInfoMap;
	}
	
	
	
	
	private void getProductMetaData() 
	{
		List<WebElement> list=driver.findElements(productMetaData);
		
		for(WebElement e:list) 
		{
			String text=e.getText().trim();
			String meta[]=text.split(":");
			String metaKey=meta[0].trim();
			String metaValue=meta[1].trim();
			productInfoMap.put(metaKey, metaValue);
		}
	}
	
	private void getProductPriceData() 
	{
		List<WebElement> list=driver.findElements(productPriceData);
		
		String price=list.get(0).getText().trim();
		String exPrice=list.get(1).getText().trim();
		productInfoMap.put("price", price);
		productInfoMap.put("ExTaxPrice",exPrice);
	}
	
	
	
	
	
}
