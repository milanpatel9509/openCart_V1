package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage
{
	private WebDriver driver;
	
	private By searchHeader=By.cssSelector("div#content h1");
	private By products=By.cssSelector("div.caption a");
	
	public SearchResultsPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	public String getResultsPageHeaderValue() 
	{
		if(driver.findElement(searchHeader).isDisplayed()) 
		{
			return driver.findElement(searchHeader).getText();
		}
		return null;
	}
	
	public int getProductSearchCount() 
	{
		return driver.findElements(products).size();
	}
	
	public List<String> getProductResultsList() 
	{
		List<WebElement> productList=driver.findElements(products);
		List<String> productValList=new ArrayList<String>();
		for(WebElement e:productList) 
		{
			String text=e.getText();
			productValList.add(text);
		}
		
		return productValList;
	}
	
	public ProductInfoPage selectProduct(String mainProductName) 
	{
		System.out.println("Main Product Name :"+mainProductName);
		List<WebElement> productList=driver.findElements(products);
		for(WebElement e:productList) 
		{
			String text=e.getText();
			if(text.equals(mainProductName)) 
			{
				e.click();
				break;
			}
		}
		return new ProductInfoPage(driver);
	}
	

}
