package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegistersPage;
import com.qa.opencart.pages.SearchResultsPage;

public class BaseTest 
{
	public DriverFactory driverFactory;
	public WebDriver driver;
	public Properties prop;
	public LoginPage loginPage;
	public AccountsPage accountsPage;
	public SearchResultsPage searchResultsPage;
	public ProductInfoPage productInfoPage;
	public SoftAssert softAssert;
	public RegistersPage registersPage;
	
	@BeforeTest
	public void setup() 
	{
		driverFactory=new DriverFactory();
		prop=driverFactory.init_prop();
		driver=driverFactory.init_driver(prop);
		loginPage=new LoginPage(driver);
		softAssert=new SoftAssert();
		
	}
	
	@AfterTest
	public void tearDown() 
	{
		driver.quit(); 
	}
}