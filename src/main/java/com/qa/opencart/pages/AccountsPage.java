 package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage
{
	private WebDriver driver;
	
	public AccountsPage(WebDriver driver) 
	{
		this.driver=driver;
	}

	private By txtSearch=By.name("search");
	private By btnSearch=By.cssSelector("div#search button");
	private By logoHeader=By.cssSelector("div#logo a");
	private By accountsList=By.cssSelector("div#content h2");
	
	public String getAccountsPageTitle() 
	{
		return driver.getTitle();
	}
	
	public boolean isAccountsPageSearchExit() 
	{
		return driver.findElement(txtSearch).isDisplayed();
	}
	
	public boolean isAccountsPageHeaderExist() 
	{
		return driver.findElement(logoHeader).isDisplayed();
	}
	
	public SearchResultsPage doSearch(String productName) 
	{
		if(isAccountsPageSearchExit()) 
			{
				driver.findElement(txtSearch).clear();
				driver.findElement(txtSearch).sendKeys(productName);
				driver.findElement(btnSearch).click();
				return new SearchResultsPage(driver);
			}
		 return null;
	}
	
	public List<String> getAccountSectionList() 
	{
		List<WebElement> list=driver.findElements(accountsList);
		List<String> li=new ArrayList<String>();
		for(WebElement e:list) 
		{
			String text=e.getText();
			li.add(text);
		}
      return li;
	}
}
