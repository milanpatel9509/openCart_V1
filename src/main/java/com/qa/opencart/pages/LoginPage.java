package com.qa.opencart.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.utilities.*;

import io.qameta.allure.Step;



public class LoginPage  
{
	public  WebDriver driver;

	
	//1. private by locators:
	
	private By txtEmail=By.id("input-email");
	private By txtPassword=By.id("input-password");
	private By btnLogin=By.xpath("//input[@value='Login']");
	private By lkdForgottenPassword=By.linkText("Forgotten Password");
	private By lkdRegister=By.linkText("Register");
	
	//2. public page constructor
	public LoginPage(WebDriver driver)
	{	
		this.driver=driver;
	}
	
	@Step("first step")
	public String getLoginPageTitle()
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		if(wait.until(ExpectedConditions.titleContains("Account Login")))
			{
				String title=driver.getTitle();
				return title;
			}
		else 
			{
				System.out.println("title is not correct");
				return null;
			}
	}
	
	public String getLoginPageUrl() 
	{
		return driver.getCurrentUrl();
	}
	
	public boolean isForgotPasswordLinkExist() 
	{
		return driver.findElement(lkdForgottenPassword).isDisplayed();
	}
	
	public AccountsPage doLogin(String un,String pwd) 
	{
		driver.findElement(txtEmail).sendKeys(un);
		driver.findElement(txtPassword).sendKeys(pwd);
		driver.findElement(btnLogin).click();
		return new AccountsPage(driver);
	}
	
	public boolean isRegisterLinkExist() 
	{
		return driver.findElement(lkdRegister).isDisplayed();
	}

	public RegistersPage navigateToRegisterPage() 
	{
		if(isRegisterLinkExist())
		{
			driver.findElement(lkdRegister).click();
			return new RegistersPage(driver);
		}
		return null;
	}

	
	
	
}
